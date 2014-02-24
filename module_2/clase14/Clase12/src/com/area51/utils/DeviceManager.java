package com.area51.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class DeviceManager {
	
	Context contexto;
	
	public DeviceManager(Context contexto) {
		super();
		this.contexto = contexto;
	}

	public boolean verificarRed(){

    	ConnectivityManager connMgr = 
    			(ConnectivityManager) contexto.
    			getSystemService(Context.CONNECTIVITY_SERVICE);
    	
    	final android.net.NetworkInfo wifi = 
    			connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    	
    	final android.net.NetworkInfo mobile = 
    			connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);   
    	
    	if ( wifi.isAvailable() && wifi.isConnected() ) {    		
    		if( Constantes.RED == "" ){
    			Constantes.RED = "wifi";
    		}    		
    		return true;
    		
    	} else if ( mobile != null && mobile.isAvailable() && mobile.isConnected() ){
    		
    		if( Constantes.RED == "" ){
    			Constantes.RED = "mobile";
    		}

    		return true;
    		
    	} else {
    		//No hay RED
    		return false;
    	}
    	
	}
	
	

}
