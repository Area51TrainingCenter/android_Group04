package com.area51.ejercio01;

import java.util.ArrayList;

import com.area51.adapters.ItemListaBaseAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends Activity {

	ListView lista;
	ItemListaBaseAdapter adapter;
	ArrayList<ItemLista> item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final LinearLayout capaError = (LinearLayout)findViewById(R.id.capaError);
		
		
		//Instanciamos las variables para los componentes gráficos
		final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
		final EditText txtApellido = (EditText)findViewById(R.id.txtApellido);
		Button btnGraba = (Button)findViewById(R.id.btnGraba);
		lista = (ListView)findViewById(R.id.lista);
		
		item = new ArrayList<ItemLista>();		
		adapter = new ItemListaBaseAdapter( this , item);
		lista.setAdapter(adapter);


		btnGraba.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Primero validamos los valores ingresados				
				if( !txtNombre.getText().toString().equals("") 
						&& !txtApellido.getText().toString().equals("") ){
					//Si todo va bien , agregamos!!  :D
					
					item.add(new ItemLista( item.size()
							, "" + txtNombre.getText().toString()
							, "" + txtApellido.getText().toString()
							, "drawable/avatarcool")  );
					
					adapter.notifyDataSetChanged();
					
					txtNombre.setText("");
					txtApellido.setText("");

					capaError.setVisibility(View.GONE);
					
					
				}else{
					//Valores incorrectos, mostramos un mensaje
					
					capaError.setVisibility(View.VISIBLE);
					
					/*
					Toast.makeText( getApplicationContext(),
							"Ingresa valores correctos pe!!", 
							Toast.LENGTH_SHORT).show();
					
					*/
					
				}
				
				
			}
		} );
		
		
		
		
		
	}
	
	
	
	
	
	


	
	

}
