package com.area51.asyntask;

import com.area51.clase11.MainActivity;
import com.area51.utils.RESTClient;

import android.content.Context;
import android.os.AsyncTask;

public class RequestAsynTask {
	
	Context contextoActual;

	public RequestAsynTask(Context contextoActual) {
		this.contextoActual = contextoActual;
	}

	

	public void LogueoUsuario( String url){

		LogueoUsuario tarea = new LogueoUsuario();
		tarea.execute(url);
		
	}
		
	
	public class LogueoUsuario extends AsyncTask<String, Void, String> {		
		
		String resultado = "";
		
		@Override
		protected String doInBackground(String... urls) {
			String response = "";
			for (String url : urls) {
				try {
					response = RESTClient.connectAndReturnResponse(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return response;
		}

		@Override
		protected void onPostExecute(String result) {			
			
			//Aquí ya termino la descarga
			( ( MainActivity ) contextoActual  ).ValidaLogueo( result );
				
		}
		
		
	}
	
	
	

}
