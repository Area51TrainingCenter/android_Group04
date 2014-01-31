package com.area51.clase04;

import java.util.ArrayList;

import com.area51.adapters.ItemListaAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ArrayList<ItemLista>items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//ListView lista = (ListView)findViewById(R.id.lista);		
		
		
		LinearLayout capalayout = (LinearLayout)findViewById(R.id.capalayout);
		
		
		
		
		
		ArrayList<ItemLista> itemsObtenidos = ObtenerItem();
		/*
		ItemListaAdapter adapter = new 
				ItemListaAdapter(this, itemsObtenidos);
		lista.setAdapter(adapter);
		 */
		
		//Toast.makeText(this, "cantidad " + itemsObtenidos.size(), Toast.LENGTH_SHORT).show();
		
		for (int i = 0; i < itemsObtenidos.size(); i++) {
			
			
			/*
			LinearLayout capalayoutItem = new LinearLayout(this);
			capalayoutItem.setLayoutParams( 
					new LayoutParams( 
							LayoutParams.MATCH_PARENT , 
							LayoutParams.MATCH_PARENT ));
			capalayoutItem.setOrientation( LinearLayout.HORIZONTAL  );
			
			*/
			
			TextView nombre = new TextView(this);
			nombre.setLayoutParams( 
					new LayoutParams( 
							LayoutParams.MATCH_PARENT , 
							LayoutParams.WRAP_CONTENT ));
			
			nombre.setText( items.get(i).getNombreItem() );
			
			//Toast.makeText(this, "texto: " + items.get(i).getNombreItem(), Toast.LENGTH_SHORT).show();
			
			capalayout.addView(nombre);
			
			
		}
		
				
				
				
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
