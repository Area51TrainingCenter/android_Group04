package com.area51.clase10;

import java.util.ArrayList;

import com.area51.adapters.AlumnoAdapter;
import com.area51.datos.Alumno;
import com.area51.sqlitedb.ManageSQLiteOpenHelper;
import com.area51.utils.Constantes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {

	//Variables para manejo de SQLite
	ManageSQLiteOpenHelper dbConexion;
	SQLiteDatabase procesosDb;
	ContentValues registroDb;
	Cursor registroQueryDb;
	
	//Manejo de datos
	AlumnoAdapter adapter;
	
	//Componentes gráficos
	ListView lista;
	EditText nombreAlumno;
	EditText edadAlumno;
	Button btnIngresaAlumno;
	RelativeLayout capaOpcion;
	LinearLayout capaEdicion;
	LinearLayout capaMain;	
	Button btnEditaAlumno;
	Button btnEliminaAlumno;
	Button btnActualizaAlumno;
	Button btnCancelarAlumno;
	AlertDialog.Builder alerta;
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Iniciamos la conexión a SQLite
		dbConexion = new ManageSQLiteOpenHelper( this, Constantes.dbName  , null , Constantes.dbVersion );
		//Iniciamos permisos de procesos en SQLite
		procesosDb =  dbConexion.getWritableDatabase();
		registroDb =  new ContentValues();
		
		
		//Manejo de datos en memoria ( tiempo de ejecución )
		Constantes.listaAlumnos =  new ArrayList<Alumno>();
		adapter = new AlumnoAdapter( this );
		
		
		//Componentes gráficos
		capaMain =  (LinearLayout)findViewById(R.id.capaMain);
		capaEdicion =  (LinearLayout)findViewById(R.id.capaEdicion);
		lista = (ListView)findViewById(R.id.lista);
		nombreAlumno = (EditText)findViewById(R.id.nombreAlumno);
		edadAlumno = (EditText)findViewById(R.id.edadAlumno);
		btnIngresaAlumno = (Button)findViewById(R.id.btnIngresaAlumno);
		btnActualizaAlumno = (Button)findViewById(R.id.btnActualizaAlumno);
		btnCancelarAlumno = (Button)findViewById(R.id.btnCancelarAlumno);
		
		
		

		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		

		alerta = new AlertDialog.Builder( this );
		
		btnIngresaAlumno.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
								
				if(  !nombreAlumno.getText().toString().equals("") 
						&& !edadAlumno.getText().toString().equals("") ){
					//Ingresamos los datos
					GrabaAlumno( nombreAlumno.getText().toString() , edadAlumno.getText().toString() );
					
					nombreAlumno.setText("");
					edadAlumno.setText("");
					
				}else{
					
					alerta.setTitle("Alerta!!");
					alerta.setMessage("Los valores ingresados son incorrectos");
					alerta.create();
					alerta.show();
					
				}
				
				
				
			}
		});
		
		
		lista.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, final int position,
					long id) {
				
				if( capaOpcion != null ){
					capaOpcion.setVisibility(View.GONE);
				}
				
				capaOpcion = (RelativeLayout)view.findViewById(R.id.capaOpcion);
				capaOpcion.setVisibility(View.VISIBLE);				
				
				btnEditaAlumno = (Button)view.findViewById(R.id.btnEditaAlumno);
				btnEliminaAlumno = (Button)view.findViewById(R.id.btnEliminaAlumno);
				
				btnEditaAlumno.setOnClickListener( new OnClickListener() {					
					@Override
					public void onClick(View v) {	
						
						btnActualizaAlumno.setTag(""+ position );

						capaEdicion.setVisibility(View.VISIBLE);
						btnIngresaAlumno.setVisibility(View.GONE);
						
						nombreAlumno.setText( "" + Constantes.listaAlumnos.get(position).getNombreAlumno() );
						edadAlumno.setText( "" + Constantes.listaAlumnos.get(position).getEdadAlumno() );

						if( capaOpcion != null ){
							capaOpcion.setVisibility(View.GONE);
						}		
						
					}
				});				
				

				btnEliminaAlumno.setOnClickListener( new OnClickListener() {					
					@Override
					public void onClick(View v) {
						EliminaAlumno( Constantes.listaAlumnos.get(position).getIdAlumno(), position );
						

						
					}
				});
				
			}
		});
		
		
		btnCancelarAlumno.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				capaEdicion.setVisibility(View.GONE);
				btnIngresaAlumno.setVisibility(View.VISIBLE);
				nombreAlumno.setText("");
				edadAlumno.setText("");
			}
		});
		
		
		capaMain.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if( capaOpcion != null ){
					capaOpcion.setVisibility(View.GONE);
				}
			}
		});
		
		
		btnActualizaAlumno.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if(  !nombreAlumno.getText().toString().equals("") 
						&& !edadAlumno.getText().toString().equals("") ){
					

					Log.i("btnActualizaAlumno","" + Integer.parseInt(""+btnActualizaAlumno.getTag()) );
					Log.i("btnActualizaAlumno2","" + Constantes.listaAlumnos.get( Integer.parseInt(""+btnActualizaAlumno.getTag()) ).getIdAlumno() );
					
					
										
					String sqlUpdate = "UPDATE " + Constantes.tableName + " SET " + Constantes.colNombreAlumno + " = '" + nombreAlumno.getText().toString()
							+ "' , " + Constantes.colEdadAlumno + " = " + edadAlumno.getText().toString()
							+ " WHERE " + Constantes.colIdAlumno + " = " + Constantes.listaAlumnos.get( Integer.parseInt(""+btnActualizaAlumno.getTag()) ).getIdAlumno();
					
										
					procesosDb.execSQL( sqlUpdate );
					
					//Actualizamos en el arreglo
					Constantes.listaAlumnos.get( Integer.parseInt(""+btnActualizaAlumno.getTag()) ).setNombreAlumno( nombreAlumno.getText().toString() );
					Constantes.listaAlumnos.get( Integer.parseInt(""+btnActualizaAlumno.getTag()) ).setEdadAlumno( Integer.parseInt(edadAlumno.getText().toString()) );
					
					adapter.notifyDataSetChanged();
					
					
					
					nombreAlumno.setText("");
					edadAlumno.setText("");
					

					capaEdicion.setVisibility(View.GONE);
					btnIngresaAlumno.setVisibility(View.VISIBLE);
					
				}else{
					
					alerta.setTitle("Alerta!!");
					alerta.setMessage("Los valores para actualizar son incorrectos");
					alerta.create();
					alerta.show();
					
				}
				
			}
		});
		
		
		LlenaLista();
		
	}

	public void EliminaAlumno(  int id, int position ){
		

		if( capaOpcion != null ){
			capaOpcion.setVisibility(View.GONE);
		}
		
		//primero eliminamos en la bd
		String sqlDelete = "DELETE FROM " + Constantes.tableName 
				+ " WHERE " + Constantes.colIdAlumno + " = " + id;
		
		procesosDb.execSQL(sqlDelete);
				
		
		Constantes.listaAlumnos.remove(position);		
		adapter.notifyDataSetChanged();
		
		
	}
	
	

	public void GrabaAlumno( String nombreAlumno, String edadAlumno ){
		
		//Grabamos en sqlite
		registroDb.put( Constantes.colIdAlumno  , Constantes.listaAlumnos.size() );
		registroDb.put( Constantes.colNombreAlumno  , nombreAlumno );
		registroDb.put( Constantes.colEdadAlumno  , edadAlumno );
		
		//Insertamos!!
		procesosDb.insert( Constantes.tableName , null, registroDb );
		
		
		//Actualizamos el adapter para mostrarlo en el listview
		Constantes.listaAlumnos.add( 
				new Alumno(Constantes.listaAlumnos.size(),
						nombreAlumno, 
						Integer.parseInt(edadAlumno) ));
		
		//Actualizamos el adapter para mostrar el nuevo registro en el listview
		adapter.notifyDataSetChanged();
		
		
	}
	
	public void LlenaLista(){
		
		String sql= "SELECT " 
		+ Constantes.colIdAlumno + " , "
		+ Constantes.colNombreAlumno + " , "
		+ Constantes.colEdadAlumno + " "
		+ " FROM " + Constantes.tableName;
		
		Log.i("SQLite","" + sql);
		
		registroQueryDb = procesosDb.rawQuery(sql, null);
		
		if( registroQueryDb.moveToFirst()  ){
			
			do{
				//Llenamos la lista
				Constantes.listaAlumnos.add( new Alumno(
						Integer.parseInt( registroQueryDb.getString(Constantes.colIdAlumno_index) ) , 
						"" + registroQueryDb.getString(Constantes.colNombreAlumno_index) , 
						Integer.parseInt( registroQueryDb.getString(Constantes.colEdadAlumno_index) ) ) );
						
				
			}while( registroQueryDb.moveToNext() );
			
		}
		
		lista.setAdapter(adapter);
		
		
		
		
	}
	
	
	
	
	

	
	
	

}
