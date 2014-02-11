package com.area51.clase09;

import java.util.ArrayList;

import com.area51.adapters.AlumnoAdapter;
import com.area51.datos.Alumno;
import com.area51.sqlitedb.ManageSQLiteOpenHelper;
import com.area51.utils.Constantes;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {
	
	ManageSQLiteOpenHelper dbConexion;
	SQLiteDatabase dbProcesos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView resultado = (TextView)findViewById(R.id.resultado);
		
		dbConexion = new ManageSQLiteOpenHelper( 
				this , Constantes.dbName  , null, Constantes.dbVersion ); 
		

		dbProcesos = dbConexion.getWritableDatabase();
		
		for (int j = 0; j < 10; j++) {

			ContentValues nuevosRegistros = new ContentValues();		
		
			nuevosRegistros.put("nombreAlumno", "nombre " + j );
			nuevosRegistros.put("edadAlumno", (j + 20) );
			
			dbProcesos.insert(
					Constantes.tableName , null, nuevosRegistros);
			
		}
		
		String sql = "SELECT * FROM " + Constantes.tableName + " " ;		
		Cursor registro = dbProcesos.rawQuery(sql, null);
		
		//dbProcesos.delete(table, whereClause, whereArgs);
		//dbProcesos.update(table, values, whereClause, whereArgs);
		
		
		//dbProcesos.update(Constantes.tableName, "Nuevo Nombre", "condiciona", "Argum");
		
		
		resultado.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Proceso de update
				finish();
				
			}
		});
		
		resultado.setText("");		
		if( registro.moveToFirst() ){
		
			do{
				//Aqui se llena el listview
				resultado.append( registro.getString(1).toString() + " \n " );
				
			}while( registro.moveToNext() );
			
		}
		
		
		
		
		
		
		
		/*
		ListView lista = (ListView)findViewById(R.id.lista);
		Constantes.listaAlumnos =  new ArrayList<Alumno>();		
		
		for (int i = 0; i < 10; i++) {
			
			//Llenamos el ArrayList
			Constantes.listaAlumnos
			.add( new Alumno(i, "nombre " + i, (11 + i) ) );
			
		}
		
		AlumnoAdapter adapter = new AlumnoAdapter( this);
		lista.setAdapter(adapter);
		*/
		
		
		
		
		
	}


}
