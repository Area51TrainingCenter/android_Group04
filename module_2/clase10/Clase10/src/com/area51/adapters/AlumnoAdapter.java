package com.area51.adapters;

import com.area51.clase10.R;
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
			//llenamos la vista con el recurso de dise�o item_listview.xml
			LayoutInflater inflater = 
					(LayoutInflater)actividadActual
					.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

			vistaActual = inflater.inflate( R.layout.item_listview , null);
		}
		
		//Creamos la instancia del elemento del arreglo
		Alumno itemActual = Constantes.listaAlumnos.get(position);	
		
		TextView textoId = (TextView)vistaActual
				.findViewById(R.id.textoId);
		
		TextView textoNombre = (TextView)vistaActual
				.findViewById(R.id.textoNombre);
		
		TextView textoEdad = (TextView)vistaActual
				.findViewById(R.id.textoEdad);

		textoId.setText("Id:  " + itemActual.getIdAlumno()  );
		textoNombre.setText("Nombre:  " + itemActual.getNombreAlumno()  );
		textoEdad.setText("Edad:  " + itemActual.getEdadAlumno()  );
		
		
		
		
		
		
		
		return vistaActual;
	}

	public AlumnoAdapter(Activity actividadActual) {
		this.actividadActual = actividadActual;
	}

}
