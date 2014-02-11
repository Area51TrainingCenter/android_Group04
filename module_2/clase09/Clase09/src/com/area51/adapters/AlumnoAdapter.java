package com.area51.adapters;

import java.util.ArrayList;

import com.area51.clase09.R;
import com.area51.datos.Alumno;
import com.area51.utils.Constantes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AlumnoAdapter extends BaseAdapter {
	
	Activity actividadActual;

	@Override
	public int getCount() {
		return Constantes.listaAlumnos.size();
	}

	@Override
	public Object getItem(int position) {
		return Constantes.listaAlumnos.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return 0;
	}

	@Override
	public View getView(int position, View vistaActual, ViewGroup parent) {
		
		if ( vistaActual == null ) {
			//llenamos la vista con el recurso de diseño item_listview.xml
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

			vistaActual = inflater.inflate( R.layout.item_listview , null);
		}
		
		//Creamos la instancia del elemento del arreglo
		Alumno itemActual = Constantes.listaAlumnos.get(position);	
		
		TextView textoNombre = (TextView)vistaActual
				.findViewById(R.id.textoNombre);
				
		textoNombre.setText( itemActual.getNombreAlumno() );
		
		return vistaActual;
	}

	public AlumnoAdapter(Activity actividadActual) {
		this.actividadActual = actividadActual;
	}

}
