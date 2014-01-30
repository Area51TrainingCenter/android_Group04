package com.area51.adapters;


import java.util.ArrayList;

import com.area51.datos.ItemLista;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
		
		
		
		
		
		return null;
	}

	public ItemListaAdapter(Activity actividadActual, ArrayList<ItemLista> items) {
		this.actividadActual = actividadActual;
		this.items = items;
	}

}
