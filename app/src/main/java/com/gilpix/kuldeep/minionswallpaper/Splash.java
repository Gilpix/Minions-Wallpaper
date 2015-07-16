package com.gilpix.kuldeep.minionswallpaper;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.gilpix.kuldeep.minionswallpaper.Home;
import com.gilpix.kuldeep.minionswallpaper.R;


public class Splash extends Activity {
	 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2500;
    private Animation animation,animation1,animation2,animation3,animation4;

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        ActionBar actionbar = getActionBar();   
		   actionbar.hide();			   
        
       final ImageView back = (ImageView) findViewById(R.id.back);  
       
      // back.setImageResource(R.drawable.image21);
       animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.lmove);
       back.startAnimation(animation);
     
        
        
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, Home.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
  
 
}