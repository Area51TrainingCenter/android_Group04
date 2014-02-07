package com.area51.fragments;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.area51.proyectov2.R;



public class SectionFragment extends SherlockFragment {

	public final static String FRAGMENT_POSITION = "FRAGMENT_POSITION";
		
	public SectionFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vistaFragment = inflater.inflate(
				R.layout.fragment, null);
		
		TextView textoFragment = (TextView)vistaFragment
				.findViewById( R.id.textoFragment );
		
		textoFragment.setText("Fragmento"
							+ getArguments().getInt(FRAGMENT_POSITION) );
		
		
		return vistaFragment;
	}

}
