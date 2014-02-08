package com.area51.adapters;

import com.area51.fragments.SectionFragment;
import com.area51.utils.ConstantsUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionFragmentPageAdapter extends FragmentPagerAdapter {

	public SectionFragmentPageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return ConstantsUtil.lista.size();
	}

}
