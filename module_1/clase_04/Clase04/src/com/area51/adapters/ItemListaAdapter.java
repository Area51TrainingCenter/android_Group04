package com.area51.adapters;


import java.util.ArrayList;

import com.area51.clase04.R;
import com.area51.datos.ItemLista;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
			//llenamos la vista con el recurso de dise�o item_list.xml
			
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaItem = inflater.inflate( R.layout.item_list , null);
			
		}
		
		ItemLista itemActual = items.get(position);
		
		//procesos de los componentes de dise�o ( Textview, Imageview, etc)
		
		TextView nombreItem = (TextView)vistaItem
				.findViewById(R.id.nombreItem);
		
		nombreItem.setText( itemActual.getNombreItem() );
		
		Typeface tipoFuente = Typeface.createFromAsset(
				actividadActual.getAssets() , "fonts/OpenSans-LightItalic.ttf" );
		
		nombreItem.setTypeface( tipoFuente );
		//Tarea: buscar como se asigna un tipo de fuente de lentra a un Textview por dise�o;
		
		
		
		return vistaItem;
	}

	public ItemListaAdapter(Activity actividadActual, ArrayList<ItemLista> items) {
		this.actividadActual = actividadActual;
		this.items = items;
	}

}
