package com.area51.practica01;

import java.util.ArrayList;

import com.area51.adapters.ItemListaBaseAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;


public class PracticaActivity extends Activity {

	//Variables globales
	ListView lista;
	ItemListaBaseAdapter adapter;
	ArrayList<ItemLista>items;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practica);
		
		
		//Seteamos los datos y el arreglo hacia el adapter
		lista = (ListView)findViewById(R.id.lista);
		Button btnGraba = (Button)findViewById(R.id.btnGraba);
		final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
		final EditText txtApellido = (EditText)findViewById(R.id.txtApellido);
		
		
		items = new ArrayList<ItemLista>();
		
		adapter = new 
				ItemListaBaseAdapter(this, items);
		
		lista.setAdapter(adapter);
				
		
		//Llamamos al evento clic de btnGraba
		btnGraba.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Validamos que se haya ingresado los datos sino le mostramos un mensaje
				if( !txtNombre.getText().toString().equals("") &&  !txtApellido.getText().toString().equals("")  ){
					//Enviamos los parametros a agregar a la lista (ListView)
					AgregaElemento( txtNombre.getText().toString() , txtApellido.getText().toString() );
					
				}else{			
					Toast.makeText( getApplicationContext() ,
							"Debe igresar un nombre y un apellido!", Toast.LENGTH_SHORT)
							.show();
				}
				
			}
		});
		
		
				
	}


	
	public void AgregaElemento(String Nombre, String Apellido){		

		Log.i("clic","agrega" );		
		//Recibimos y agregamos los elementos al ArrayList
		items.add( new ItemLista( items.size() , Nombre , Apellido, "drawable/avatarcool") );
		
		//Ahora actualizamos el BaseAdapter para que se muestren los nuevos valores en el ListView
		adapter.notifyDataSetChanged();
		
	}

	


}
