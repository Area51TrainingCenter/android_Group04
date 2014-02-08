package com.area51.adapters;

import com.area51.datos.ItemGridView;
import com.area51.tareagridview.R;
import com.area51.utils.ConstantsUtil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ItemGridViewAdapter extends BaseAdapter {

	Activity actividadActual;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ConstantsUtil.lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ConstantsUtil.lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View vistaItem, ViewGroup parent) {

		ItemGridView itemActual = ConstantsUtil.lista.get(position);

		if ( vistaItem == null ) {
			//llenamos la vista con el recurso de diseño item_list.xml
			
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			
			vistaItem = inflater.inflate( R.layout.item_gridview , null);
		}
		
		ImageView itemImagen = (ImageView)vistaItem.findViewById(R.id.itemImagen);
		itemImagen.setImageResource( itemActual.getItemImagen() );
		
		
		return vistaItem;
	}

	public ItemGridViewAdapter(Activity actividadActual) {
		this.actividadActual = actividadActual;
	}
	
	

}
