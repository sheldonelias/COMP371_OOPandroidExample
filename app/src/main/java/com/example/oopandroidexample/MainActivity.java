package com.example.oopandroidexample;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.oopandroidexample.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    //Shared variables for cross-class messaging
    public static String messageString = "";

    //All or most of your XML Views are also Classes
    public TextView mainView;


    //Instantiate fighter and bomber
    Fighter aFighter;

    Bomber aBomber;

    //Save each of the clikcable alienship graphic to memory
    ImageView alien_ship1;
    ImageView alien_ship2;

    ImageView explosion1;
    ImageView explosion2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //These are the only two lines always needed. Much of the
        //other auto-generated code is a bit superfluous
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alien_ship1 = (ImageView) findViewById(R.id.alien_ship1);
        alien_ship2 = (ImageView) findViewById(R.id.alien_ship2);

        explosion1 = (ImageView) findViewById(R.id.explosion1);
        explosion2 = (ImageView) findViewById(R.id.explosion2);

        ImageView missle1 = (ImageView) findViewById(R.id.missle1);
        ImageView missle2 = (ImageView) findViewById(R.id.missle2);


        //Assign to static variable mainView the TextView object that has the text of MainActivity
        mainView = (TextView) findViewById(R.id.textview_first);

        //Instantiate fighter and bomber
        Fighter aFighter = new Fighter();
        passMessageToScreen(aFighter.currentMsgOut);
        Bomber aBomber = new Bomber();
        passMessageToScreen(aBomber.currentMsgOut);

        //Give derived AlienShip object names
        aBomber.shipName = "Newell Bomber";
        aFighter.shipName = "Meier Fighter";

        //Report to Log and MainActivity the instantiate and shield stength
        Log.i("aFighter Shield: ", ""+ aFighter.getShieldStrength());
        passMessageToScreen("aFighter Shield:" + aFighter.getShieldStrength());
        Log.i("aBomber Shield: ", ""+ aBomber.getShieldStrength());
        passMessageToScreen("aBomber Shield: " + aBomber.getShieldStrength());

        alien_ship2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,
                        "Bomber fires! Fighter is hit.", Toast.LENGTH_SHORT).show();

                RelativeLayout.LayoutParams missle2_RelativeLayout =
                        new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                    missle2_RelativeLayout.leftMargin = 180;

                    missle2.setLayoutParams(missle2_RelativeLayout);

                //Battle attacks
                aBomber.fireWeapon();
                passMessageToScreen(aBomber.currentMsgOut);

                //Battle hits
                aFighter.hitDetected();
                passMessageToScreen(aFighter.currentMsgOut);

                checkFighterShield();

            }

            public void checkFighterShield()
            {
                if(aFighter.getShieldStrength() <= 0)
                {
                    alien_ship1.setVisibility(View.INVISIBLE);
                    explosion1.setVisibility(View.VISIBLE);
                }
            }
        }); //Notice that the whole instantiation of the OnClickListener is an argument


        alien_ship1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,
                        "Fighter fires! Bomber is hit!", Toast.LENGTH_SHORT).show();

                RelativeLayout.LayoutParams missle1_RelativeLayout =
                        new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                missle1_RelativeLayout.rightMargin = 180;

                missle1.setLayoutParams(missle1_RelativeLayout);

                //Battle attacks
                aFighter.fireWeapon();
                passMessageToScreen(aFighter.currentMsgOut);

                //Battle hits
                aBomber.hitDetected();
                passMessageToScreen(aBomber.currentMsgOut);

                checkBomberShield();

            }



            public void checkBomberShield()
            {
                if(aBomber.getShieldStrength() <= 0)
                {
                    alien_ship2.setVisibility(View.INVISIBLE);
                    explosion2.setVisibility(View.VISIBLE);
                }
            }

        }); //Notice that the whole instantiation of the OnClickListener is an argument

    }

    public void onStart() {

        super.onStart();

    }



    public void blowUpShip(ImageView alienShip)
    {

    }

    //Messaging method
    public void passMessageToScreen(String msg)
    {
        //Concatenate static method
        messageString += msg + "\n";
        //Change visible text on MainActivity
        mainView.setText(messageString);

        //messageString = "";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}