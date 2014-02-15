package com.area51.clase11;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.area51.asyntask.RequestAsynTask;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

public class MainActivity extends Activity {

	
	String url = "http://api.segundoacosta.com/logueo.php?" +
			"usuario=segu19@gmail.com&clave=1234";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RequestAsynTask request = new RequestAsynTask( this );
		request.LogueoUsuario( url );		
		
	}
	
	public void ValidaLogueo( String jsonResultado ){		

		try {
			
			JSONObject jsonObject = new JSONObject(jsonResultado);
			//JSONArray jsDatos = jsonObject.getJSONArray("datos");
			
			if( jsonObject.getString("respuesta").equals("ERROR") ){
				Log.i("","Error de logueo");
			}
			
			if( jsonObject.getString("respuesta").equals("OK") ){
				Log.i("","Logueo correcto ");
			}			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
				
		//Log.i("","" + jsonObject.getString("respuesta") );
		//Log.i("","" + jsDatos.getJSONObject(0).getString("id") );
		
		
		
	}


	
	
}
