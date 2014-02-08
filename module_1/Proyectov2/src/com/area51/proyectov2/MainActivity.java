package com.area51.proyectov2;

import java.util.ArrayList;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.area51.adapters.ItemListaAdapter;
import com.area51.adapters.SectionFragmentPageAdapter;
import com.area51.datos.ItemLista;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class MainActivity extends SherlockFragmentActivity  implements
com.actionbarsherlock.app.ActionBar.TabListener{


	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	


	ArrayList<ItemLista>items;
	
	ActionBar mActionBar;
	//Variables de la 1ra pantalla
	//ActionBar mActionBar;
	SectionFragmentPageAdapter mSectionFragmentPageAdapter;
	ViewPager mViewPager;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		

		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		mDrawerList = (ListView)findViewById(R.id.left_drawer);
		
		mDrawerLayout.setDrawerShadow( 
				R.drawable.drawer_shadow, 
				GravityCompat.START);		
				
		
		//Para hacer compatible el actionBar
		getSupportActionBar().setTitle( R.string.nameDisplay );
		getSupportActionBar().setDisplayUseLogoEnabled(false);
				
		getSupportActionBar().setIcon(R.drawable.logo);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		getSupportActionBar().setBackgroundDrawable( new ColorDrawable( Color.parseColor("#F7F7F7") ));
		
		

		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer,
				R.string.drawer_open,
				R.string.drawer_close);
			
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		

		
		ArrayList<ItemLista> itemsObtenidos = ObtenerItem();
		
		ItemListaAdapter adapter = new 
				ItemListaAdapter(this , itemsObtenidos);
		mDrawerList.setAdapter(adapter);
		
		
		
		mDrawerList.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View vista, int position,
					long id) {

				mDrawerList.setItemChecked(position, true);
				mDrawerLayout.closeDrawer(mDrawerList);
				
			}
			
		});
		
		
		
		//Ahora instanciamos el actionbar para los TABS y el ViewPager

		//Creamos el ActionBar de navegación		
		mActionBar = getSupportActionBar();
		
		mActionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS  );
		

		
		
		//Creamos el manejador de los Fragments (FragmentPAgeAdapter)
		
		mSectionFragmentPageAdapter = 
				new SectionFragmentPageAdapter(
						getSupportFragmentManager() );
		
		//Creamos el panel donde se mostrarán los Fragments(ViewPager)
		
		mViewPager = (ViewPager)findViewById(R.id.viewPager);
		//Esta linea es la poderosa que hace la magia
		mViewPager.setAdapter(mSectionFragmentPageAdapter);
		

		//Ahora haremos que el mActionBar sea padre soltero :D
		for (int i = 0; i < mSectionFragmentPageAdapter.getCount()  ; i++) {
			
			mActionBar.addTab( mActionBar.newTab()
					.setText( mSectionFragmentPageAdapter.getTitle(i))
					.setTabListener(this));			
		}
		

		//Ahora hacemos que el ViewPager y el ActionBar sean amigos :D
		mViewPager.setOnPageChangeListener( new SimpleOnPageChangeListener(){
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub			
				//Este codigo hace la magia
				mActionBar.setSelectedNavigationItem(position);
			}
		});
		
		
	}

	

	private ArrayList <ItemLista> ObtenerItem(){
		
		items = new ArrayList<ItemLista>();

		items.add( new ItemLista( 1 , "NEWS"  , "drawable/icon1", ""  ));
		items.add( new ItemLista( 2 , "SECTION"  , "drawable/icon2", ""  ));
		items.add( new ItemLista( 3 , "MEDIA"  , "drawable/icon3", ""  ));
			
		
		return items;
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu( Menu  menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected( MenuItem item) {
		
		switch (item.getItemId()) {
        case android.R.id.home:
            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
            return true;
		}
		
		//Código sin soporte a las versiones pasadas		
		/*
		if (mDrawerToggle.onOptionsItemSelected( getMenuItem( item ) )) {
			return true;
		}*/
		
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
	
	
	@Override
	public void onTabSelected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem( tab.getPosition() );
		
	}



	@Override
	public void onTabUnselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTabReselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	

}
