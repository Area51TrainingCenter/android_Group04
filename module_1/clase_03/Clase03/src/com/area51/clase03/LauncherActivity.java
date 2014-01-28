package com.area51.clase03;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;

public class LauncherActivity extends Activity {

	//Variables de launcher
	LinearLayout capaLauncher;
	Integer contador = 0;
	Integer TIEMPO = 1000;
	String TAG = "Launcher";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		capaLauncher = (LinearLayout)
				findViewById(R.id.capaLauncher);
		
		//Declaracion en tiempo de ejecución
		/*
		LinearLayout capaTemporal = 
				new LinearLayout(getApplicationContext());
		*/
				
		
	}//fin del onCreate()
	
	private Runnable cargaApp = new Runnable() {
		
		@Override
		public void run() {
			
			Log.i(TAG, "contador: " + contador );
			
			if (contador < 3) {
				capaLauncher.postDelayed( cargaApp , 1000 );
				contador++;
			}else{
				IniciaApp();
			}
			
		}
	};//Cierra el hilo
	
	
	private void IniciaApp(){
		
		Intent intent =  new Intent( this, MainActivity.class );
		startActivity(intent);		
		
		overridePendingTransition( 
				R.anim.slide_left,
				R.anim.slide_right );
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		contador = 0;
		capaLauncher.postDelayed( cargaApp , TIEMPO );
		
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();		
		capaLauncher.removeCallbacks(cargaApp);
		
	}
	
	
	


}
