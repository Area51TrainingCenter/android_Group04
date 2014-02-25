package com.area51.services;

import com.area51.application.UsuarioApplication;
import com.area51.asynctask.RequestAsynctask;
import com.area51.sqlitedb.ManageTableUsuario;
import com.area51.utils.Constantes;
import com.area51.utils.DeviceManager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UsuarioService extends Service {
	
	static final int DELAY = 10000;
	boolean runFlag = false;
	
	String TAG = UsuarioService.class.getSimpleName();

	UpdateStateUsuario updatestate;
	UsuarioApplication uapplication;
	
	RequestAsynctask request;
	DeviceManager dm;
	ManageTableUsuario mtu;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}



	@Override
	public void onCreate() {
		
		super.onCreate();
		Log.d( "CLASE12" , TAG + "onCreate");		
		uapplication = ( UsuarioApplication )getApplication();
		updatestate = new UpdateStateUsuario();		
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
		Log.d( "CLASE12" , TAG + "onDestroy");		
		
		runFlag = false;
		uapplication.stateRunningService(runFlag);
		updatestate.interrupt();
		updatestate = null;		
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		super.onStartCommand(intent, flags, startId);

		Log.d( TAG , " onStartCommand");
		
		if( !runFlag ){
			runFlag = true;
			uapplication.stateRunningService(runFlag);
			updatestate.start();
		}	
		
		return START_STICKY;
	}
	
	
	public class UpdateStateUsuario extends Thread{
		
		@Override
		public void run() {
			
			super.run();
			
			UsuarioService detectedService = UsuarioService.this;
			
			while ( detectedService.runFlag ) {

				Log.d( "CLASE12" , TAG + " running ");
				try {
					
					dm = new DeviceManager( getApplicationContext() );
					if( dm.verificarRed() ){
						
						mtu = new ManageTableUsuario( getApplicationContext() );
						
						if( mtu.verificaSesionService() ){
							
							request = new RequestAsynctask( getApplicationContext() );
							request.estadoUsuario("" + Constantes.API
									+ Constantes.SECTION_ESTADO_USUARIO
									+ Constantes.VAR_USUARIO
									+ Constantes.objUsuario.getIdUsuario() );
						}
						
						Log.d("","RequestAsynctask");
					}


					Thread.sleep(DELAY);
					
				} catch (Exception e) {
					detectedService.runFlag = false;
					uapplication.stateRunningService(false);
				}
				
			}//fin del while
			
		}
		
		
		
	}

	
	
	
}
