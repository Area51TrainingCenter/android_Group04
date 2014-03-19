package com.area51.pruebalocation;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity
implements LocationListener,
ConnectionCallbacks,
OnConnectionFailedListener

{

	
	GoogleMap mapa;
	LocationClient locationClient;
	
	LocationRequest REQUEST = LocationRequest.create()
			.setInterval(2000)
			.setFastestInterval(16)
			.setPriority( LocationRequest.PRIORITY_HIGH_ACCURACY );
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		loadMap();
		loadClient();
		locationClient.connect();
		
	}
	
	public void loadMap(){
	
		if( mapa == null  ){
			
			mapa = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapa)  ).getMap();
			mapa.setBuildingsEnabled(true);		
			
		}
		
	}
	
	

	public void loadClient(){
		
		locationClient = new LocationClient( 
				getApplicationContext(), 
				this, 
				this);
		
		
	}
	
	public void MyLocation( Location location ){
		
		
		Log.d("MAPA", "Latitud: " + location.getLatitude() 
				+ " Longitud: " + location.getLongitude()  );
		
		MarkerOptions mOptions = new MarkerOptions();
		//LatLng latlng = new LatLng( location.getLatitude(), location.getLongitude() );
		
		LatLng latlng = new LatLng( -11.9646405 , -76.9892799 );		
		
		mOptions.position(latlng);
		mOptions.title( getResources().getString( R.string.ubicacionI )  );
		mOptions.icon( BitmapDescriptorFactory.fromResource( R.drawable.ic_launcher ) );
		mOptions.rotation(7);
		
		mapa.addMarker(mOptions);
		
		//Trazamos ruta usando Polygonos
		 PolylineOptions lineas = new PolylineOptions()
        .add(new LatLng(-11.9646405 , -76.9892799))
        .add(new LatLng( -11.9646608, -76.9893716))
        .add(new LatLng( -11.9941149, -77.007323));

		 lineas.width(8);
		 lineas.color(Color.RED);

		 mapa.addPolyline(lineas);

		 mapa.addMarker(
				 new MarkerOptions()
				 .position( new LatLng( -11.9941149, -77.007323 ) )
				 .title( getResources().getString( R.string.ubicacionI ) )
				 .icon( BitmapDescriptorFactory.fromResource( R.drawable.ic_launcher ) )
				 .rotation(7)
				 );
		
		

			
			//Nos dirigimos a la ubicación actual usando un efecto de zoom
			//con el objeto Camera
			CameraPosition cposition = new CameraPosition
					.Builder()
					.target( latlng )
					.zoom(13)
					.bearing(45)
					.tilt(70)
					.build();

			mapa.animateCamera( CameraUpdateFactory.newCameraPosition(cposition)  );
		
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.a:
			
			mapa.setMapType( GoogleMap.MAP_TYPE_NORMAL );
			
			break;
		case R.id.b:

			mapa.setMapType( GoogleMap.MAP_TYPE_HYBRID );
			break;
		case R.id.c:

			mapa.setMapType( GoogleMap.MAP_TYPE_SATELLITE );
			break;
		case R.id.d:

			mapa.setMapType( GoogleMap.MAP_TYPE_TERRAIN );
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		Toast.makeText( getApplicationContext() , "onConnectionFailed", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
		locationClient.requestLocationUpdates(REQUEST, this);	
		Toast.makeText( getApplicationContext() , "onConnected", Toast.LENGTH_SHORT).show();
		
		MyLocation( locationClient.getLastLocation() );
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		Toast.makeText( getApplicationContext() , "onDisconnected", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		Toast.makeText( getApplicationContext() , "onLocationChanged", Toast.LENGTH_SHORT).show();
		
	}


}
