package com.area51.clase03;

import java.util.ArrayList;

import com.area51.adapters.ItemListaAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
		

	ArrayList<ItemLista>items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerList = (ListView)findViewById(R.id.left_drawer);
		
		mDrawerLayout.setDrawerShadow( 
				R.drawable.drawer_shadow, 
				GravityCompat.START);		
				
		getActionBar().setTitle( R.string.nameDisplay );
		getActionBar().setDisplayUseLogoEnabled(false);
				
		getActionBar().setIcon(R.drawable.logo);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		getActionBar().setBackgroundDrawable( new ColorDrawable( Color.parseColor("#F7F7F7") ));
		
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer,
				R.string.drawer_open,
				R.string.drawer_close);
			
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		

		
		
		ArrayList<ItemLista> itemsObtenidos = ObtenerItem();
		
		ItemListaAdapter adapter = new 
				ItemListaAdapter(this, itemsObtenidos);
		mDrawerList.setAdapter(adapter);
		
		
	}
	

	private ArrayList <ItemLista> ObtenerItem(){
		
		items = new ArrayList<ItemLista>();

		items.add( new ItemLista( 1 , "NEWS"  , "drawable/icon1", ""  ));
		items.add( new ItemLista( 2 , "SECTION"  , "drawable/icon2", ""  ));
		items.add( new ItemLista( 3 , "MEDIA"  , "drawable/icon3", ""  ));
			
		
		return items;
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		
		super.onConfigurationChanged(newConfig);		
		mDrawerToggle.onConfigurationChanged(newConfig);
		
	}
	
	

}
