package com.area51.clase05;

import com.area51.adapters.SectionFragmentPageAdapter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;


public class MainActivity extends FragmentActivity implements
 	ActionBar.TabListener
{
	
	ActionBar mActionBar;
	SectionFragmentPageAdapter mSectionFragmentPageAdapter;
	ViewPager mViewPager;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		//Codigo que hace la magia
		mViewPager.setCurrentItem( tab.getPosition() );
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
