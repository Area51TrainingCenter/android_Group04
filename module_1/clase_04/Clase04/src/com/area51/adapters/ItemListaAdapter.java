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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemListaAdapter(Activity actividadActual, ArrayList<ItemLista> items) {
		this.actividadActual = actividadActual;
		this.items = items;
	}

}
