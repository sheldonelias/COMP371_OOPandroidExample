package com.example.oopandroidexample;

import android.util.Log;

public abstract class AlienShip
{
    private  static int numShips;
    private int shieldStrength;
    public String shipName;

    public String currentMsgOut;

    ///empty constructor (constructor sig, no parameters)
    public AlienShip()
    {

    }

    public AlienShip(int shieldStrength)
    {
        Log.i("Location: ", "Alienship constructor");
        currentMsgOut = "Location: Alienship constructor";
        numShips++;
        setShieldStrength(shieldStrength);
    }

    //Recall abstract methods have no body.
    public abstract void fireWeapon();

    public static int getNumShips()
    {
        return numShips;
    }

    public void setShieldStrength(int shieldStrength)
    {
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength()
    {
        return shieldStrength;
    }

    public void hitDetected()
    {
        if(shieldStrength > 0) {

            shieldStrength -= 50;
            Log.i("Incoming: ", "Boom!! shieldStrength: " + shieldStrength);
            currentMsgOut = "Incoming: Boom!! shieldStrength: " + shieldStrength;
            if (shieldStrength == 0) {
                destroyShip();
            }

        }
    }

    private void destroyShip()
    {
        numShips--;
        //Notice the first character in the second arg MUST be a
        //string literal, not a variable of string type.
        Log.i("Explosion: ", "" + shipName + " destroyed." );
        currentMsgOut = "Explosion: " + shipName + " destroyed.";
    }
}
