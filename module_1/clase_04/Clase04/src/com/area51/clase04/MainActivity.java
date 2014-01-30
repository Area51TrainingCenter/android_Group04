package com.area51.clase04;

import java.util.ArrayList;

import com.area51.adapters.ItemListaAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lista = (ListView)findViewById(R.id.lista);		

		ArrayList<ItemLista> itemsObtenidos = ObtenerItem();
		
		ItemListaAdapter adapter = new 
				ItemListaAdapter(this, itemsObtenidos);
		lista.setAdapter(adapter);

				
				
				
	}
	
	private ArrayList <ItemLista> ObtenerItem(){
		
		ArrayList<ItemLista>items = new ArrayList<ItemLista>();
		
		for (int i = 0; i < 10; i++) {
			
			items.add( new ItemLista( i , "Item " + i ));
			
		}		
		
		return items;
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
