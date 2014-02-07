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
		
		
		//Ahora instanciamos el actionbar para los TABS y el ViewPager

		//Creamos el ActionBar de navegación		
		mActionBar = getSupportActionBar();
		mActionBar.setNavigationMode( com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_TABS );
		
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
	
	
	
	private android.view.MenuItem getMenuItem(final MenuItem item) {

		 return new android.view.MenuItem() {

			@Override
			public boolean collapseActionView() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean expandActionView() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public android.view.ActionProvider getActionProvider() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public View getActionView() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public char getAlphabeticShortcut() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getGroupId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Drawable getIcon() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Intent getIntent() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getItemId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ContextMenuInfo getMenuInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public char getNumericShortcut() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getOrder() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public SubMenu getSubMenu() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CharSequence getTitle() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CharSequence getTitleCondensed() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasSubMenu() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isActionViewExpanded() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isCheckable() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isChecked() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isVisible() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public android.view.MenuItem setActionProvider(
					android.view.ActionProvider actionProvider) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setActionView(View view) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setActionView(int resId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setAlphabeticShortcut(char alphaChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setCheckable(boolean checkable) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setChecked(boolean checked) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setEnabled(boolean enabled) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIcon(Drawable icon) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIcon(int iconRes) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setIntent(Intent intent) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setNumericShortcut(char numericChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setOnActionExpandListener(
					OnActionExpandListener listener) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setOnMenuItemClickListener(
					OnMenuItemClickListener menuItemClickListener) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setShortcut(char numericChar,
					char alphaChar) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setShowAsAction(int actionEnum) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public android.view.MenuItem setShowAsActionFlags(int actionEnum) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitle(CharSequence title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitle(int title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setTitleCondensed(CharSequence title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public android.view.MenuItem setVisible(boolean visible) {
				// TODO Auto-generated method stub
				return null;
			}

		 };
		
	}

	

}
