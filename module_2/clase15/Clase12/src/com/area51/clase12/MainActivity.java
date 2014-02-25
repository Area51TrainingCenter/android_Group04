package com.area51.clase12;

import com.area51.application.UsuarioApplication;
import com.area51.sqlitedb.ManageTableUsuario;
import com.area51.utils.Constantes;
import com.area51.utils.DeviceManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
	LinearLayout lineaRed;
	DeviceManager estadoRed;
	//Botones de accion
	Button btnLogueo, btnVotacion, btnResultado;
	LinearLayout capaFrame;
	ManageTableUsuario objTableUsuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		capaFrame = (LinearLayout)findViewById(R.id.capaFrame);
		
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

	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		
		UsuarioApplication uapplication 
			= ( UsuarioApplication )getApplication();
		uapplication.onTerminate();
		
	}
	
	public void iniciaApp(){
		
		//Ocultamos la linea de red
		lineaRed.setVisibility(View.GONE);
		btnVotacion.setVisibility(View.GONE);
		btnResultado.setVisibility(View.GONE);
		
		
		objTableUsuario = new ManageTableUsuario(this);
		objTableUsuario.verificaSesion();
		
		
		
		if( !Constantes.objUsuario.getNombreUsuario().equals("")  ){
			
			btnLogueo.setVisibility(View.GONE);			
			//Agregamos el boton salir
			
			Button btnSalir = new Button(this);
			LinearLayout.LayoutParams parametro;			
			parametro = new 
					LinearLayout.LayoutParams( 
							LayoutParams.WRAP_CONTENT 
					, LayoutParams.WRAP_CONTENT );			
			btnSalir.setLayoutParams(parametro);			
			btnSalir.setText( R.string.btnSalirTexto );
			
			capaFrame.addView( btnSalir );
			
			btnSalir.setOnClickListener( new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					objTableUsuario.actualizarEstadoUsuario(
							"" + Constantes.objUsuario.getIdUsuario() );

					capaFrame.removeAllViews();	
					iniciaApp();
				}
			});
			
			
			
			
			if( !Constantes.objUsuario.getVotacion().equals("1") ){
				
				btnVotacion.setVisibility(View.VISIBLE);
				
			}else{

				btnResultado.setVisibility(View.VISIBLE);
				
			}
			
		}else{

			btnLogueo.setVisibility(View.VISIBLE);
			
		}

		
		
		btnLogueo.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v){
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
