package com.area51.sqlitedb;

import com.area51.datos.Usuario;
import com.area51.utils.Constantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ManageTableUsuario {
	
	Context contexto;
	ManageSQLite  dbConexion;	
	SQLiteDatabase dbProcesos;
	ContentValues registroDb;
	
	

	public boolean verificaSesionService(){
		
		dbConexion = new ManageSQLite( 
				contexto , Constantes.DB_NAME  , null, 
				Constantes.DB_VERSION );
		dbProcesos = dbConexion.getWritableDatabase();	
		
		String sql = "SELECT * FROM " + Constantes.TABLE_USUARIO_NAME + " " ;		
		Cursor registro = dbProcesos.rawQuery(sql, null);
		
		if( registro.moveToFirst() ){
			return true;			
		}else{
			return false;			
		}
	}
	
	

	public void actualizarEstadoUsuario( String idUsuario ){

		dbConexion = new ManageSQLite( 
				contexto , Constantes.DB_NAME  , null, Constantes.DB_VERSION );
		dbProcesos = dbConexion.getWritableDatabase();
		
		String sql = " DELETE FROM " + Constantes.TABLE_USUARIO_NAME 
				+ " WHERE " + Constantes.USUARIO_ID + "=" + idUsuario;
		
		dbProcesos.execSQL(sql);
		
	}
	
	
	public void actualizarVotacionUsuario( String idUsuario ){

		dbConexion = new ManageSQLite( 
				contexto , Constantes.DB_NAME  , null, Constantes.DB_VERSION );
		dbProcesos = dbConexion.getWritableDatabase();
		
		String sql = " UPDATE " + Constantes.TABLE_USUARIO_NAME
				+ " SET " + Constantes.USUARIO_VOTACION + " = '1' "
				+ " WHERE " + Constantes.USUARIO_ID + "=" + idUsuario;
		
		dbProcesos.execSQL(sql);	
		
	}
	
	
	public void ingresarUsuario(){
		
		
		dbConexion = new ManageSQLite( 
				contexto , Constantes.DB_NAME  , null, Constantes.DB_VERSION );
		dbProcesos = dbConexion.getWritableDatabase();	
		
		registroDb =  new ContentValues();

		registroDb.put( Constantes.USUARIO_ID  , Constantes.objUsuario.getIdUsuario()  );
		registroDb.put( Constantes.USUARIO_NOMBRE  , Constantes.objUsuario.getNombreUsuario() );
		registroDb.put( Constantes.USUARIO_VOTACION  , Constantes.objUsuario.getVotacion() );
		registroDb.put( Constantes.USUARIO_ESTADO  , Constantes.objUsuario.getEstado() );
		
		dbProcesos.insert( Constantes.TABLE_USUARIO_NAME , null, registroDb);

	}
	
	
	public void verificaSesion(){
		
		dbConexion = new ManageSQLite( 
				contexto , Constantes.DB_NAME  , null, Constantes.DB_VERSION );
		dbProcesos = dbConexion.getWritableDatabase();	
		
		String sql = "SELECT * FROM " + Constantes.TABLE_USUARIO_NAME + " " ;		
		Cursor registro = dbProcesos.rawQuery(sql, null);
		
		Constantes.objUsuario = null;
		
		if( registro.moveToFirst() ){
			

			//Existe el usuario logueado			

			Constantes.objUsuario = 
					new Usuario( registro.getInt( Constantes.USUARIO_ID_INDEX ) , 
							registro.getString( Constantes.USUARIO_NOMBRE_INDEX  ), 
							registro.getString( Constantes.USUARIO_VOTACION_INDEX ), 
							registro.getString( Constantes.USUARIO_ESTADO_INDEX));	
			
			/*
			if( !registro.getString( Constantes.USUARIO_ESTADO_INDEX).equals("1") ){
				//No hay usuario
				Constantes.objUsuario = new Usuario( 0 , "", "" , "" );
			}else{

				//Existe el usuario logueado			

				Constantes.objUsuario = 
						new Usuario( registro.getInt( Constantes.USUARIO_ID_INDEX ) , 
								registro.getString( Constantes.USUARIO_NOMBRE_INDEX  ), 
								registro.getString( Constantes.USUARIO_VOTACION_INDEX ), 
								registro.getString( Constantes.USUARIO_ESTADO_INDEX));	
			}				
			*/
		}else{

			Constantes.objUsuario = new Usuario( 0 , "", "" , "" );
			
		}
		
	}


	public ManageTableUsuario(Context contexto) {
		super();
		this.contexto = contexto;
	}
	
	
}
