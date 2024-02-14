package com.example.oopandroidexample;

import android.util.Log;

public class Fighter extends AlienShip
{

    public Fighter()
    {
        super(400);

        Log.i("Location: " , "Fighter constructor instantiating.");
        currentMsgOut = "Location: Fighter constructor instantiating.";
    }
   public void fireWeapon()
   {
       Log.i("Firing weapon: ", "Lasers firing!");
       currentMsgOut = "Firing weapon: Lasers firing!";
   }
}
