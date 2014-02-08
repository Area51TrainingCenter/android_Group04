package com.area51.fragments;



import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.area51.adapters.ItemGridAdapter;
import com.area51.datos.ItemGridView;
import com.area51.proyectov2.R;



public class SectionFragment extends SherlockFragment {

	public final static String FRAGMENT_POSITION = "FRAGMENT_POSITION";
	ArrayList<ItemGridView>itemGrid;	
	ItemGridAdapter adapter;
	
	public SectionFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vistaFragment = null;
			
		
		switch ( getArguments().getInt(FRAGMENT_POSITION) ) {
		case 0:

			vistaFragment = inflater.inflate( R.layout.gridview, null);
			
			//En esta posicion mandamos el gridview
			
			GridView gridview = (GridView)vistaFragment.findViewById(R.id.gridview);
			
			//Instanciamos el ArrayList y lo llenamos
			itemGrid =  new ArrayList<ItemGridView>();

			itemGrid.add( new ItemGridView(0, "Sample 0", "Descripcion de imagen 0", R.drawable.sample_0) );
			itemGrid.add( new ItemGridView(1, "Sample 1", "Descripcion de imagen 1", R.drawable.sample_1) );
			itemGrid.add( new ItemGridView(2, "Sample 2", "Descripcion de imagen 2", R.drawable.sample_2) );
			itemGrid.add( new ItemGridView(3, "Sample 3", "Descripcion de imagen 3", R.drawable.sample_3) );
			itemGrid.add( new ItemGridView(4, "Sample 4", "Descripcion de imagen 4", R.drawable.sample_4) );
			itemGrid.add( new ItemGridView(5, "Sample 5", "Descripcion de imagen 5", R.drawable.sample_5) );
			itemGrid.add( new ItemGridView(6, "Sample 6", "Descripcion de imagen 6", R.drawable.sample_6) );
			itemGrid.add( new ItemGridView(7, "Sample 7", "Descripcion de imagen 7", R.drawable.sample_7) );
			itemGrid.add( new ItemGridView(8, "Sample 8", "Descripcion de imagen 8", R.drawable.sample_8) );
			itemGrid.add( new ItemGridView(9, "Sample 9", "Descripcion de imagen 9", R.drawable.sample_0) );
			itemGrid.add( new ItemGridView(10, "Sample 10", "Descripcion de imagen 10", R.drawable.sample_10) );
			
			//Creamos el adapter
			
			adapter = new ItemGridAdapter( getSherlockActivity() ,  itemGrid );
			
			//Enviamos el adapter al gridview
			gridview.setAdapter(adapter);
			
			
			break;
			
		default:
			vistaFragment = inflater.inflate( R.layout.fragment, null);
			
			TextView textoFragment = (TextView)vistaFragment
					.findViewById( R.id.textoFragment );
			textoFragment.setText("Fragmento"
								+ getArguments().getInt(FRAGMENT_POSITION) );
			
			break;
		}
		
		
		
		
		
		
		return vistaFragment;
	}

}
