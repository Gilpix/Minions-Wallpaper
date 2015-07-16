package com.gilpix.kuldeep.minionswallpaper;


import java.io.IOException;
import java.io.InputStream;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window; 
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;   
import android.widget.ImageView; 
import android.widget.Toast;
 
public class Home extends Activity implements OnClickListener {
    ImageView display; 
    int tophone;
    ImageView back;
    private Animation animation,animation1,animation2,animation3,animation4; 
    
    int count=0;
    int[] minionsId={R.drawable.minions1,R.drawable.minions2,R.drawable.minions3,R.drawable.minions4,
    		R.drawable.minions5,R.drawable.minions6,R.drawable.minions7,R.drawable.minions8,
    		R.drawable.minions9,R.drawable.minions10,R.drawable.minions11,R.drawable.minions12,
    		R.drawable.minions13,R.drawable.minions14,R.drawable.minions15,R.drawable.minions16,
    		R.drawable.minions17,R.drawable.minions18,R.drawable.minions19,R.drawable.minions20,  
    		R.drawable.minions21,R.drawable.minions22,R.drawable.minions23,R.drawable.minions24,
    		R.drawable.minions25};  
    		/*R.drawable.minions26,R.drawable.minions27,R.drawable.minions28,
    		R.drawable.minions29,R.drawable.minions30,R.drawable.minions31,R.drawable.minions32,
    		R.drawable.minions33,R.drawable.minions34,R.drawable.minions35,R.drawable.minions36,
    		R.drawable.minions37,R.drawable.minions38,R.drawable.minions39,R.drawable.minions40,
    		R.drawable.minions41,R.drawable.minions42,R.drawable.minions43,R.drawable.minions44,
    		R.drawable.minions45};
    		*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
 
        // to our activity to cover the whole screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
 
        setContentView(R.layout.home);
        Button but = (Button) findViewById(R.id.setwallpaper); 
        Button prev = (Button) findViewById(R.id.previous); 
        Button next = (Button) findViewById(R.id.next);
        tophone = R.drawable.minions1;
        
        final ImageView back = (ImageView) findViewById(R.id.image);     
	      // back.setImageResource(R.drawable.minions21);
	    
        //Animation
        /*
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.categories);
	       back.startAnimation(animation);
        */
    
	       ((Button) findViewById(R.id.setwallpaper))
	        .setOnClickListener(new OnClickListener() {
	           
			    public void onClick(View v) {
			    	
			    	
			    	/*
			    	back.setBackgroundResource(R.drawable.minions4);
				       animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.categories);
				       back.startAnimation(animation);
			        */
			         
			        // TODO Auto-generated method stub
			        Toast var;
			        

		            // to set a background we need to use bitmap
		            InputStream is = getResources().openRawResource(tophone);
		            // to phone is a variable that is updated everytime we click on an
		            // ImageView to that minionsview resource and by clicking the button
		            // we set the phone background to that minions.
		            Bitmap bm = BitmapFactory.decodeStream(is);
		            // decode inputstream is
		          /*  
		            wallpaperManager = WallpaperManager.getInstance(this);
		            wallpaperDrawable = wallpaperManager.getDrawable();
		            display.setImageURI(mUrls[1]);
		            */
		            try {
		                getApplicationContext().setWallpaper(bm);
		                // to set the wallpaper of the phone background we need to ask
		                // permission from the user so add permission of background from
		                // manifest file
		 
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		            var = Toast.makeText(Home.this, "Home Screen changed",
		                    Toast.LENGTH_SHORT);
		 
		            var.show();
		 
			    }
	       
			    
	        });
	       
 
	       
	       
	       
        
       
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        display = (ImageView) findViewById(R.id.ivdisplay);
    }
 
    
    
        @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Toast var;
        switch (v.getId()) {
        case R.id.previous:
        	if(count<=0)
        		count=minionsId.length-1;
            display.setImageResource(minionsId[count]);
            
            tophone = minionsId[count];
            count--;
            break;
            
        case R.id.next:
        	count++;
        	if(count>minionsId.length-1)
        		count=0;
        	else if (count==minionsId.length-1){
            display.setImageResource(minionsId[count]);
            tophone = minionsId[count]; 
            count=0;
            break;
        	}
        	 display.setImageResource(minionsId[count]);
            tophone = minionsId[count];
            //count++;
            break;  
        
        } 
    }
 
}