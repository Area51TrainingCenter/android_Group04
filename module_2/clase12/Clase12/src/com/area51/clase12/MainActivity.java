package com.area51.clase12;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button btnLogueo = (Button)findViewById(R.id.btnLogueo);
		final Button btnVotacion = (Button)findViewById(R.id.btnVotacion);
		final Button btnResultado = (Button)findViewById(R.id.btnResultado);
		
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
