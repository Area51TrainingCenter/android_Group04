package com.area51.adapters;

import com.area51.fragments.SectionFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionFragmentPageAdapter extends  FragmentPagerAdapter {

	int total = 3;
	
	
	public SectionFragmentPageAdapter(FragmentManager fm) {
		super(fm);
		
	}

	@Override
	public Fragment getItem(int position) {
	
		Fragment mFragment = new SectionFragment();
		//Fragment alto ahí!!
		//Te voy a mandar mensajon
		Bundle argumentos = new Bundle();
		
		argumentos.putInt( 
				SectionFragment.FRAGMENT_POSITION
				, position);
		
		//Fragment toma el argumento y muestrate!!
		mFragment.setArguments(argumentos);
		
		return mFragment;
	}

	@Override
	public int getCount() {		
		//Para el libro coquito no olvidarse, de esto depende el sueldo!!
		
		return total;
	}
	
	
	public CharSequence getTitle( int position ){
		
		switch ( position ) {
		case 0:
			return "STORIES ";// + position;
		case 1:
			return "REVIEWS";// + position;
		case 2:
			return "FEATURES";// + position;
		}

		/*
		for (int i = 0; i < total; i++) {
			return "TAB " + i;
		}
		*/
		
		return null;
	}
	
	
	
	

}
