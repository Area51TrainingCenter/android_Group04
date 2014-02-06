package com.area51.logueoestatico;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {

	EditText txtUsuario;
	EditText txtClave;
	Button   btnIngreso;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		txtUsuario = (EditText)findViewById(R.id.txtUsuario);
		txtClave = (EditText)findViewById(R.id.txtClave);
		btnIngreso = (Button)findViewById(R.id.btnIngreso);
		
		btnIngreso.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
		
		
		
		
	}

	
	
	
}
