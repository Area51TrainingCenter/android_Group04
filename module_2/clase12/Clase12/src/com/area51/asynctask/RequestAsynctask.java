package com.area51.asynctask;


import com.area51.clase12.LogueoActivity;
import com.area51.clase12.R;
import com.area51.clase12.VotacionActivity;

import com.area51.utils.RESTClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RequestAsynctask {

	Context contexto;
	String TAG = "RequestAsynctask";

	public RequestAsynctask(Context contexto) {
		super();
		this.contexto = contexto;
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
