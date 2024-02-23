package com.example.oopandroidexample;

import android.util.Log;

public class Bomber extends AlienShip
{
    public Bomber()
    {
        super(100);

        Log.i("Location: " , "Bomber constructor instantiating.");
        currentMsgOut = "Location: Bomber constructor instantiating.";

    }
   public void fireWeapon()
   {
       if(getShieldStrength() >0)
       {
           Log.i("Bomber firing: ", "Ka-blam!");
           currentMsgOut = "Bomber firing: Ka-blam!";
       }
   }


}
