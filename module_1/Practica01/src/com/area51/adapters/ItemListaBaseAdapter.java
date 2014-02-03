package com.area51.adapters;

import java.util.ArrayList;

import com.area51.datos.ItemLista;
import com.area51.practica01.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListaBaseAdapter extends BaseAdapter {

	Activity actividadActual;
	ArrayList<ItemLista>item;
	
	
	public ItemListaBaseAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public Object getItem(int position) {
		
		return item.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return item.get(position).getItemId();
	}

	@Override
	public View getView(int position, View vistaItem, ViewGroup parent) {		
		
		if( vistaItem == null ){
			
			LayoutInflater inflater = (LayoutInflater)
					actividadActual.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaItem = inflater.inflate( R.layout.item_lista  , null );			
			
		}
		
		

		ItemLista itemActual = item.get(position);
		
		//procesos de los componentes de diseño ( Textview, Imageview, etc)
		
		//Para el nombre
		TextView textNombre = (TextView)vistaItem
				.findViewById(R.id.textNombre);
		
		textNombre.setText( itemActual.getItemNombre() );
		
		Typeface tipoFuenteNombre = Typeface.createFromAsset(
				actividadActual.getAssets() , "fonts/OpenSans-Light.ttf" );
		
		textNombre.setTypeface( tipoFuenteNombre );
		
		//Para el apellido
		TextView textApellido = (TextView)vistaItem
				.findViewById(R.id.textApellido);
		
		textNombre.setText( itemActual.getItemNombre() );
		
		Typeface tipoFuenteApellido = Typeface.createFromAsset(
				actividadActual.getAssets() , "fonts/OpenSans-Regular.ttf" );
		
		textApellido.setTypeface( tipoFuenteApellido );
		
		//Para la imagen
		ImageView rutaImagenItem = (ImageView)vistaItem.findViewById(R.id.imagenItem);
		
		int imageResource = actividadActual.
				getResources().
				getIdentifier(
						itemActual.getItemImagen(),
						null,
						actividadActual.getPackageName());
		
		rutaImagenItem.setImageDrawable( 
				actividadActual
				.getResources()
				.getDrawable(imageResource) );
		
		
		
		return vistaItem;
	}

	public ItemListaBaseAdapter(Activity actividadActual,
			ArrayList<ItemLista> item) {
		this.actividadActual = actividadActual;
		this.item = item;
	}

}
