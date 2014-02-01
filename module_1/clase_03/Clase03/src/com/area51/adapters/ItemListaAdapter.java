package com.area51.adapters;


import java.util.ArrayList;

import com.area51.clase03.R;
import com.area51.datos.ItemLista;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListaAdapter extends BaseAdapter {
	
	private Activity actividadActual;
	private ArrayList<ItemLista>items;
	

	public ItemListaAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return items.get(position).getIdItem();
		
	}

	@Override
	public View getView(int position, View vistaItem, ViewGroup parent) {
		
		if ( vistaItem == null ) {
			//llenamos la vista con el recurso de diseño item_list.xml
			
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaItem = inflater.inflate( R.layout.item_list , null);
			
		}
		
		ItemLista itemActual = items.get(position);
		
		//procesos de los componentes de diseño ( Textview, Imageview, etc)
		
		TextView nombreItem = (TextView)vistaItem
				.findViewById(R.id.nombreItem);
		
		nombreItem.setText( itemActual.getNombreItem() );
		
		Typeface tipoFuente = Typeface.createFromAsset(
				actividadActual.getAssets() , "fonts/OpenSans-LightItalic.ttf" );
		
		nombreItem.setTypeface( tipoFuente );
		//Tarea: buscar como se asigna un tipo de fuente de lentra a un Textview por diseño;
		
		/*
		//Asignamos el texto de descripción
		TextView descripcionItem = (TextView)vistaItem
				.findViewById(R.id.descripcionItem);
		descripcionItem.setText( itemActual.getDescripcionItem() );
		*/
		
		//Llamamos a la imagen
		ImageView rutaImagenItem = (ImageView)vistaItem.findViewById(R.id.imagenItem);
		
		int imageResource = actividadActual.
				getResources().
				getIdentifier(
						itemActual.getRutaImagenItem(),
						null,
						actividadActual.getPackageName());
		
		rutaImagenItem.setImageDrawable( 
				actividadActual
				.getResources()
				.getDrawable(imageResource) );
		
		
		
		return vistaItem;
	}

	public ItemListaAdapter(Activity actividadActual, ArrayList<ItemLista> items) {
		this.actividadActual = actividadActual;
		this.items = items;
	}

}
