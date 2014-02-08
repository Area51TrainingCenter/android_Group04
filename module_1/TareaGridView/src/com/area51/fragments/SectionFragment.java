package com.area51.fragments;

import com.area51.tareagridview.R;
import com.area51.utils.ConstantsUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SectionFragment extends Fragment {
	
	public final static String FRAGMENT_POSITION = "FRAGMENT_POSITION";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View vistaFragment = inflater.inflate( R.layout.fragment, null);

		TextView textoGrid = (TextView)vistaFragment
				.findViewById( R.id.textoGrid );
		textoGrid.setText( ConstantsUtil.lista.get( getArguments().getInt(FRAGMENT_POSITION) ).getItemNombre() );
		
		
		ImageView imagenGrid = (ImageView )vistaFragment.findViewById(R.id.imagenGrid);
		
		imagenGrid.setImageResource(  ConstantsUtil.lista.get( getArguments().getInt(FRAGMENT_POSITION) ).getItemImagen() );
		
		return vistaFragment;
	}
		
	
	
}
