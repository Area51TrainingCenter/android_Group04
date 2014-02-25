package com.area51.application;

import com.area51.services.UsuarioService;

import android.app.Application;
import android.content.Intent;

public class UsuarioApplication extends Application {
	
	
	public boolean runningService;	

	public boolean RunningService(){
		return runningService;
	}	
	
	public void stateRunningService( boolean stateService ){
		this.runningService = stateService;
	}
	
	@Override
	public void onCreate() {
		
		super.onCreate();		
		startService( new Intent( this , UsuarioService.class  )  );		
	}

	@Override
	public void onTerminate() {
		
		super.onTerminate();		
		stopService( new Intent( this , UsuarioService.class  )  );
		
	}

	
	
}
