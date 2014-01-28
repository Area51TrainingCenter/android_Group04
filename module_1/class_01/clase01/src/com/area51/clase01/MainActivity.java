package com.area51.clase01;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	String TAG = "EVENTO";
	static String nombre = "";
	
	@Override
	protected void onCreate(Bundle estadoActividad) {
		super.onCreate(estadoActividad);
				
		setContentView(R.layout.activity_main);
		
		
		//Instanciamos recursos gaficos
		final EditText txtnombre = (EditText)findViewById(R.id.txtnombre);
		Button btnmostrar  = (Button)findViewById(R.id.btnmostrar);
		final TextView txtresultado = (TextView)findViewById(R.id.txtresultado);
				
		//generamos evento click del botón
		btnmostrar.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				if ( !txtnombre.getText().toString().equals("")  ) {
					
					nombre = nombre + txtnombre.getText().toString() + " \n";
					//txtnombre.setText("");					
					//txtresultado.setText( nombre );
					
					//Mostrar nombre usando clase Log
					Log.e( TAG, "El nombre ingresado es: " + nombre );
					 
					//Mostrar nombre usando Toast
					Toast.makeText( getApplicationContext() , 
							"El nombre ingresado es: " + nombre , 
							Toast.LENGTH_SHORT ).show();				
					
					
				}
							
			}
			
		});
		
		//Verificamos instancia de la actividad
		if ( estadoActividad != null ) {
			
			txtresultado.setText( nombre );
			
		}	
		
	}
	
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
