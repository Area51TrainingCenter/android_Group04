package com.area51.adapters;

import java.util.ArrayList;

import com.area51.datos.ItemLista;
import com.area51.ejercio01.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListaBaseAdapter extends BaseAdapter {

	Activity actividadActual;
	ArrayList<ItemLista>items;
	

	@Override
	public int getCount() {
		//Este metodo es importante sino me despiden
		//Representa el número de iteraciones que realizará
		//el adapter
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {

		return items.get(position).getItemId();
	}

	@Override
	public View getView(int position, View vistaActual, ViewGroup parent) {
		
		
		if( vistaActual == null ){
			//Cargamos el xml
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaActual = inflater.inflate(
					R.layout.item_lista, 
					null);			
		}
		
		ItemLista itemActual = items.get(position);		
		
		//Llamos a los componentes gráficos
		ImageView imagenItem = (ImageView)vistaActual
				.findViewById(R.id.imagenItem);
		
		TextView informacionItem = (TextView)vistaActual
				.findViewById(R.id.textoItem);
		
		//Personalizamos el ImageView		
		int imageResource = actividadActual.
				getResources().
				getIdentifier(
						itemActual.getItemImagen(),
						null,
						actividadActual.getPackageName());
		
		imagenItem.setImageDrawable( 
				actividadActual
				.getResources()
				.getDrawable(imageResource) );
		
		//Personalizamos el TextView
		informacionItem.setText( 
				itemActual.getItemApellido()
				+ ", " 
				+ itemActual.getItemNombre() );
		
		
		return vistaActual;
	}

	public ItemListaBaseAdapter(Activity actividadActual,
			ArrayList<ItemLista> items) {
		this.actividadActual = actividadActual;
		this.items = items;
	}

}
