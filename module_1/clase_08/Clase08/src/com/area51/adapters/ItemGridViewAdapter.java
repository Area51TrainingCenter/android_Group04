package com.area51.adapters;

import java.util.ArrayList;

import com.area51.ContantsUtils.Utils;
import com.area51.clase08.R;
import com.area51.datos.ItemGridView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ItemGridViewAdapter extends BaseAdapter {

	Activity actividadActual;
	
	
	

	@Override
	public int getCount() {
	
		return Utils.lista.size();
	}

	@Override
	public Object getItem(int position) {		
		return Utils.lista.get(position);
	}

	@Override
	public long getItemId(int position) {		
		return 0;
	}

	@Override
	public View getView(int position, View vistaActual, ViewGroup parent) {

		if ( vistaActual == null ) {
			//llenamos la vista con el recurso de diseño item_gridview.xml
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaActual = inflater.inflate( R.layout.item_gridview , null);
		}
		
		//Creamos la instancia del elemento del arreglo
		ItemGridView itemActual = Utils.lista.get(position);
		
		//Creamos la instancia del ImageView
		ImageView imagenGrid = (ImageView)vistaActual.
				findViewById(R.id.imagenGrid);
		
		imagenGrid.setImageResource( itemActual.getGridImagen() );
		
		TextView textoGrid = (TextView)vistaActual
				.findViewById(R.id.textoGrid);
		
		textoGrid.setText( itemActual.getGridNombre() );
		
		return vistaActual;
	}

	public ItemGridViewAdapter(Activity actividadActual
			) {
		this.actividadActual = actividadActual;		
	}

}
