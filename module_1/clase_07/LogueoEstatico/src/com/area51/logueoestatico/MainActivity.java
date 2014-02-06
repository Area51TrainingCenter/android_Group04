package com.area51.logueoestatico;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;



public class MainActivity extends Activity {

	EditText txtUsuario;
	EditText txtClave;
	Button   btnIngreso;
	TextView textoError;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Referenciamos las variables hacia los componentes 
		//gráficos declarados en el activity_main.xml
		//y así poder acceder a sus valores.
		
		txtUsuario = (EditText)findViewById(R.id.txtUsuario);
		txtClave = (EditText)findViewById(R.id.txtClave);
		btnIngreso = (Button)findViewById(R.id.btnIngreso);
		textoError = (TextView)findViewById(R.id.textoError); 
		
		//Generamos el evento clic del btnIngreso
		btnIngreso.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if( txtUsuario.getText().toString().equals("admin") 
						&&
						txtClave.getText().toString().equals("1234")  ){
										
					//Si ingreso aquí, todo va bien :D
					//Enviamos al nuevo activity
					CambiaPantalla();					
					
				}//fin del if
				else{					
					//Si ingreso aquí hubo un error :(
					
					textoError.setVisibility( View.VISIBLE );
					
				}//fin del else
				
			}
		});
				
	}

	
	public void CambiaPantalla(){

		Intent i = new Intent( this , HomeActivity.class );
		startActivity(i);		
		
	}
	
	
	
}
