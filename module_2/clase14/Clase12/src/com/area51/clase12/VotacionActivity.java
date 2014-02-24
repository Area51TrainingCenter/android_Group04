package com.area51.clase12;

import org.json.JSONArray;
import org.json.JSONObject;

import com.area51.asynctask.RequestAsynctask;
import com.area51.datos.Usuario;
import com.area51.sqlitedb.ManageTableUsuario;
import com.area51.utils.Constantes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Color;

public class VotacionActivity extends Activity {

	RequestAsynctask request;
	RadioGroup opcionVotacion;
	Button btnVotacion;
	ManageTableUsuario mtusuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_votacion);
		
		opcionVotacion = (RadioGroup)findViewById(R.id.opcionVotacion);
		btnVotacion = (Button)findViewById(R.id.btnVotacion);
	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
		

		request = new RequestAsynctask(this);		
		request.traeVotaciones("" + Constantes.API + Constantes.SECTION_VOTACION );
		
		
		btnVotacion.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				RadioButton radioTemp = 
						(RadioButton)findViewById(opcionVotacion.getCheckedRadioButtonId());
								
				request.grabaVotaciones("" + Constantes.API + 
						Constantes.SECTION_VOTACION_INGRESO + 
						Constantes.VAR_USUARIO + Constantes.objUsuario.getIdUsuario()
						+ "&" + Constantes.VAR_VOTACION + radioTemp.getTag() );
				
			}
		});
		
	}
	
	
	public void ValidaVotacion( String jsonResultado ){
				
		try {

			JSONObject jsonData = new JSONObject(jsonResultado);
			
			if( jsonData.getString( Constantes.CONSTANTE_RESPUESTA )
					.equals(Constantes.CONSTANTE_RESPUESTA_VAL) ){
				
				Toast.makeText( 
						getApplicationContext() , 
						jsonData.getString( Constantes.CONSTANTE_MENSAJE ) , 
						Toast.LENGTH_SHORT).show();
				
				//Actualizamos el campo de votacion en sqlite
				mtusuario = new ManageTableUsuario( this );
				mtusuario.actualizarVotacionUsuario( "" + Constantes.objUsuario.getIdUsuario() );
				//matamos la actividad
				finish();
				
				
			}else{
				//Entra si hay error de logueo
				Toast.makeText( 
						getApplicationContext() , 
						jsonData.getString( Constantes.CONSTANTE_MENSAJE ) , 
						Toast.LENGTH_SHORT).show();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	public void OpcionesDeVotacion( String jsonResultado ){

		
		try {

			JSONObject jsonData = new JSONObject(jsonResultado);
			
			if( jsonData.getString( Constantes.CONSTANTE_RESPUESTA )
					.equals(Constantes.CONSTANTE_RESPUESTA_VAL) ){
				
				JSONObject objectDato;
				JSONArray jsonDatos 
					= jsonData.getJSONArray( Constantes.CONSTANTE_DATOS );
				
				int total = jsonDatos.length();
				
				for (int i = 0; i < total ; i++) {
					
					objectDato = (JSONObject) jsonDatos.get(i);					
					RadioButton radiobtn = new RadioButton(getApplicationContext());
					
					radiobtn.setText( objectDato.getString(Constantes.VAR_VOTACION_NOMBRE) );
					radiobtn.setPadding(0, 0, 0, 15);
					radiobtn.setTag( objectDato.getString(Constantes.VAR_VOTACION_ID) );
					radiobtn.setTextColor( Color.BLACK );
					
					
					opcionVotacion.addView( radiobtn );
					
				}
				
				
			}else{
				//Entra si hay error de logueo
				Toast.makeText( 
						getApplicationContext() , 
						jsonData.getString( Constantes.CONSTANTE_MENSAJE ) , 
						Toast.LENGTH_SHORT).show();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
