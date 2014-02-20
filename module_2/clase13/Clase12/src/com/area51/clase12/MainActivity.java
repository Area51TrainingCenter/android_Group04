package com.area51.clase12;

import com.area51.sqlitedb.ManageTableUsuario;
import com.area51.utils.Constantes;
import com.area51.utils.DeviceManager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
	LinearLayout lineaRed;
	DeviceManager estadoRed;
	//Botones de accion
	Button btnLogueo, btnVotacion, btnResultado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lineaRed = (LinearLayout)findViewById(R.id.lineaRed);

		btnLogueo = (Button)findViewById(R.id.btnLogueo);
		btnVotacion = (Button)findViewById(R.id.btnVotacion);
		btnResultado = (Button)findViewById(R.id.btnResultado);
		
				
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		
		estadoRed =  new DeviceManager(this);
		
		if( estadoRed.verificarRed()  ){
			
			 iniciaApp();
			
		}else{
			lineaRed.setVisibility(View.VISIBLE);
			
			lineaRed.setOnClickListener( new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//Volvemos a consultar por la red
					if( estadoRed.verificarRed() ){
						iniciaApp();
					}		
				}
			});
			
		}
		
		
		
	}

	
	
	public void iniciaApp(){
		
		//Ocultamos la linea de red
		lineaRed.setVisibility(View.GONE);
		btnVotacion.setVisibility(View.GONE);
		btnResultado.setVisibility(View.GONE);
		
		
		ManageTableUsuario objTableUsuario = new ManageTableUsuario(this);
		objTableUsuario.verificaSesion();
		
		
		
		if( !Constantes.objUsuario.getNombreUsuario().equals("")  ){
			
			btnLogueo.setVisibility(View.GONE);

			
			if( !Constantes.objUsuario.getVotacion().equals("1") ){
				
				btnVotacion.setVisibility(View.VISIBLE);
				
			}else{

				btnResultado.setVisibility(View.VISIBLE);
			}
			
		}

		
		
		btnLogueo.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = 
						new Intent( getApplicationContext() , LogueoActivity.class  );
				startActivity(intent);
			}
		});
		
		btnVotacion.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = 
						new Intent( getApplicationContext() , VotacionActivity.class  );
				startActivity(intent);
			}
		});
		
		btnResultado.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = 
						new Intent( getApplicationContext() , ResultadoActivity.class  );
				startActivity(intent);
			}
		});
		
		
		
	}

}
