package com.area51.clase02b;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.actionbarsherlock.view.MenuInflater;


import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends SherlockActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menuXml) {
        // Inflate the menu; this adds items to the action bar if it is present.       
    	
    	//getMenuInflater().inflate(R.menu.main, menuXml);
             
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menuXml);
        
        for (int i = 1; i < 5; i++) {			

        	menuXml.getItem(0).getSubMenu().add(0, i, i, "Opcion 0" + i)
            .setIcon(R.drawable.vivoon)
            .setOnMenuItemClickListener( new OnMenuItemClickListener() {			
    			@Override
    			public boolean onMenuItemClick(MenuItem elementoAgregado) {				
    				Toast.makeText( getApplicationContext(), 
    						elementoAgregado.getTitle().toString()  , 
    						Toast.LENGTH_SHORT)
    						.show();				
    				return false;
    			}
    		});
            
        	
        	
		}//fin del for
        
        
        
        

		return super.onCreateOptionsMenu(menuXml);
    }
    
}
