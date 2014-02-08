package com.area51.adapters;

import java.util.ArrayList;

import com.area51.datos.ItemGridView;
import com.area51.proyectov2.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemGridAdapter extends BaseAdapter {

	Activity actividadActual;
	ArrayList<ItemGridView>itemGrid;
	
	public ItemGridAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemGrid.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return itemGrid.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View vistaItem, ViewGroup parent) {

		ItemGridView itemActual = itemGrid.get(position);
		
		
		

		if ( vistaItem == null ) {
			//llenamos la vista con el recurso de diseño item_list.xml
			
			
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaItem = inflater.inflate( R.layout.item_gridview , null);
			
		}
		
		ImageView image = (ImageView)vistaItem.findViewById(R.id.imagenGrid);
		image.setImageResource( itemActual.getGridImagen() );
		
		TextView textoGrid = (TextView)vistaItem.findViewById(R.id.textoGrid);
		textoGrid.setText( itemActual.getGridNombre() );
		
		
		
		
		return vistaItem;
	}



	public ItemGridAdapter(Activity actividadActual, ArrayList<ItemGridView> itemGrid) {
		this.actividadActual = actividadActual;
		this.itemGrid = itemGrid;
	}

}
