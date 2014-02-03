package com.area51.clase04;

import java.util.ArrayList;

import com.area51.adapters.ItemListaAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView lista;
	ArrayList<ItemLista>items;
	ItemListaAdapter adapter;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lista = (ListView)findViewById(R.id.lista);		
		
		//LinearLayout capalayout = (LinearLayout)findViewById(R.id.capalayout);
				
		
		ArrayList<ItemLista> itemsObtenidos = ObtenerItem();
		
		adapter = new 
				ItemListaAdapter(this, itemsObtenidos);
		
		lista.setAdapter(adapter);
		
		
				
	}
	
	

	
	private ArrayList <ItemLista> ObtenerItem(){
		
		items = new ArrayList<ItemLista>();
		
		for (int i = 0; i < 10; i++) {
			
			items.add( new ItemLista( i ,
					"Item " + i , 
					"drawable/avatar", 
					"Este elemeto es: Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."  ));
			
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
