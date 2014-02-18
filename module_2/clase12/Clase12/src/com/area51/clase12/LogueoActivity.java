package com.area51.clase12;

import org.json.JSONArray;
import org.json.JSONObject;

import com.area51.asynctask.RequestAsynctask;
import com.area51.datos.Usuario;
import com.area51.utils.Constantes;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class LogueoActivity extends Activity {

	EditText txtUsuario;
	EditText txtClave;
	Button btnIngreso;
	RequestAsynctask request;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logueo);

		txtUsuario = (EditText)findViewById(R.id.txtUsuario);
		txtClave = (EditText)findViewById(R.id.txtClave);
		btnIngreso = (Button)findViewById(R.id.btnIngreso);		
		
	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
		
		request = new RequestAsynctask(this);
		
		btnIngreso.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( !txtUsuario.getText().toString().equals("")
						&&
						!txtClave.getText().toString().equals("")){
					
					//Hace la petición al API					
					request.validaLogueo("" + Constantes.API
							+ Constantes.SECTION_LOGUEO
							+ Constantes.VAR_USUARIO + txtUsuario.getText().toString()
							+ "&" +Constantes.VAR_CLAVE + txtClave.getText().toString() );  
					
					
				}else{
					Toast.makeText( 
							getApplicationContext() , 
							R.string.mensajeLogueo , 
							Toast.LENGTH_SHORT).show();					
				}
				
			}
		});
		
		
	}
	
	
	public void resultadoLogueo( String jsonResultado ){
		
		
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
					
					Constantes.objUsuario = 
							new Usuario( objectDato.getInt( Constantes.VAR_USUARIO_ID ) , 
									objectDato.getString(Constantes.VAR_USUARIO_NOMBRE  ), 
									objectDato.getString( Constantes.VAR_USUARIO_VOTACION ));
					
					
					
				}
				
				//Tiene  que estar fuera del FOR
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
	


}
