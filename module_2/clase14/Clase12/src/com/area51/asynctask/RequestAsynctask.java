package com.area51.asynctask;


import org.json.JSONArray;
import org.json.JSONObject;

import com.area51.clase12.LogueoActivity;
import com.area51.clase12.R;
import com.area51.clase12.VotacionActivity;

import com.area51.sqlitedb.ManageTableUsuario;
import com.area51.utils.Constantes;
import com.area51.utils.RESTClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class RequestAsynctask {

	Context contexto;
	String TAG = "RequestAsynctask";

	ManageTableUsuario mtusuario;
	
	public RequestAsynctask(Context contexto) {
		super();
		this.contexto = contexto;
	}
	
	
	public void estadoUsuario( String url ){
		
		Log.d(TAG, "url:" + url);
		
		EstadoUsuario obj = new EstadoUsuario();
		obj.execute(url);
		
	}
	

	public void grabaVotaciones( String url ){
		
		Log.d(TAG, "url:" + url);
		
		GrabaVotaciones obj = new GrabaVotaciones();
		obj.execute(url);
		
	}
	
	
	public void validaLogueo( String url ){
		
		Log.d(TAG, "url:" + url);
		
		ValidaLogueo obj = new ValidaLogueo();
		obj.execute(url);
		
	}
	
	public void traeVotaciones( String url ){
		
		Log.d(TAG, "url:" + url);
		
		TraeVotaciones obj = new TraeVotaciones();
		obj.execute(url);
		
	}
	
	
	


	public class EstadoUsuario extends AsyncTask< String, Void, String > {
		
		ProgressDialog mensaje;
		
		@Override
		protected void onPreExecute() {			
			super.onPreExecute();	
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String response = "";
			for (String url : params) {
				try {
					response = RESTClient.connectAndReturnResponse(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(String result){
			
			super.onPostExecute(result);
			try{		
				
				JSONObject jsonData = new JSONObject(result);
				
				if( jsonData.getString( Constantes.CONSTANTE_RESPUESTA )
						.equals(Constantes.CONSTANTE_RESPUESTA_VAL) ){

					Log.i("SERVICE","" + jsonData.getString( Constantes.CONSTANTE_MENSAJE ));

					JSONArray jsonDatos 
						= jsonData.getJSONArray( Constantes.CONSTANTE_DATOS );
									
					
					if( jsonDatos.getJSONObject(0).getString( Constantes.VAR_USUARIO_ESTADO ).equals("0") ){
						
						//Actualizamos en SQLite
						mtusuario = new ManageTableUsuario(contexto);
						mtusuario.actualizarEstadoUsuario( "" + Constantes.objUsuario.getIdUsuario() );					
						
						
						//Tarea para los dormilones :D para q su profe no programe
						//solo
						
						
					}
					
				}else{
					
					Log.i("SERVICE","" + jsonData.getString( Constantes.CONSTANTE_MENSAJE ));
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			
		}		
	}
	
	
	
	
	
	
	
	
	
	

	public class GrabaVotaciones extends AsyncTask< String, Void, String > {
		
		ProgressDialog mensaje;
		
		@Override
		protected void onPreExecute() {			
			super.onPreExecute();
			
			mensaje = new ProgressDialog(contexto);
			mensaje.setMessage( "Cargando votaciones!!!" );
			mensaje.show();
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String response = "";
			for (String url : params) {
				try {
					response = RESTClient.connectAndReturnResponse(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(String result){
			
			super.onPostExecute(result);
			
			mensaje.dismiss();
			
			( ( VotacionActivity ) contexto  ).ValidaVotacion(result);
			
			
		}		
	}
	
	
	
	
	
	
	

	public class TraeVotaciones extends AsyncTask< String, Void, String > {
		
		ProgressDialog mensaje;
		
		@Override
		protected void onPreExecute() {			
			super.onPreExecute();
			
			mensaje = new ProgressDialog(contexto);
			mensaje.setMessage( "Cargando votaciones!!!" );
			mensaje.show();
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String response = "";
			for (String url : params) {
				try {
					response = RESTClient.connectAndReturnResponse(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(String result){
			
			super.onPostExecute(result);
			
			mensaje.dismiss();
			
			( ( VotacionActivity ) contexto  ).OpcionesDeVotacion(result);
			
			
		}		
	}
	
	
	
	public class ValidaLogueo extends AsyncTask< String, Void, String > {
		
		ProgressDialog mensaje;
		
		@Override
		protected void onPreExecute() {			
			super.onPreExecute();
			//Revisar la cadena
			mensaje = new ProgressDialog(contexto);
			mensaje.setMessage( "Conectando al API!!!" );
			mensaje.show();
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			
			String response = "";
			for (String url : params) {
				try {
					response = RESTClient.connectAndReturnResponse(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return response;
		}
		
		@Override
		protected void onPostExecute(String result){
			
			super.onPostExecute(result);
			
			mensaje.dismiss();
			
			( ( LogueoActivity ) contexto  ).resultadoLogueo(result);
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}
