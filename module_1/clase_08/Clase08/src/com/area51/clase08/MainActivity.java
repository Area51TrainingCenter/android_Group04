package com.area51.clase08;

import java.util.ArrayList;

import com.area51.ContantsUtils.Utils;
import com.area51.adapters.ItemGridViewAdapter;
import com.area51.datos.ItemGridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.app.Activity;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridview = (GridView)findViewById(R.id.gridview);
		
		Utils.lista = new ArrayList<ItemGridView>();
		
		//Llenamos el ArrayList
		Utils.lista.add( new ItemGridView(0,"Imagen 0" , R.drawable.sample_0 ) );
		Utils.lista.add( new ItemGridView(1,"Imagen 1" , R.drawable.sample_1 ) );
		Utils.lista.add( new ItemGridView(2,"Imagen 2" , R.drawable.sample_2 ) );
		Utils.lista.add( new ItemGridView(3,"Imagen 3" , R.drawable.sample_3 ) );
		Utils.lista.add( new ItemGridView(4,"Imagen 4" , R.drawable.sample_4 ) );
		Utils.lista.add( new ItemGridView(5,"Imagen 5" , R.drawable.sample_5 ) );
		Utils.lista.add( new ItemGridView(6,"Imagen 6" , R.drawable.sample_6 ) );
		Utils.lista.add( new ItemGridView(7,"Imagen 7" , R.drawable.sample_7 ) );
		Utils.lista.add( new ItemGridView(8,"Imagen 8" , R.drawable.sample_8 ) );
		Utils.lista.add( new ItemGridView(9,"Imagen 9" , R.drawable.sample_9 ) );
		
		ItemGridViewAdapter adapter 
		= new ItemGridViewAdapter( this);
		
		gridview.setAdapter(adapter);
		
		gridview.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				
				//view.findViewById(R.id.imagenGrid);
				int idItem = Utils.lista.get(position).getGridId();
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
		
	}


}
