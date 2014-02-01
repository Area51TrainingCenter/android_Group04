package com.area51.proyectomodulo01;

import java.util.ArrayList;

import com.area51.adapters.ItemListaAdapter;
import com.area51.adapters.SectionFragmentPageAdapter;
import com.area51.datos.ItemLista;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements
	ActionBar.TabListener{

	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
		

	ArrayList<ItemLista>items;
	
	
	//Variables de la 1ra pantalla
	ActionBar mActionBar;
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
		
		
		//Ahora instanciamos el actionbar para los TABS y el ViewPager

		//Creamos el ActionBar de navegación		
		mActionBar = getActionBar();
		mActionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );
		
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
		mViewPager.setOnPageChangeListener( new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {				
				//Este codigo hace la magia
				mActionBar.setSelectedNavigationItem(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
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


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem( tab.getPosition() );
		
	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	

}
