package com.area51.tareagridview;

import com.area51.adapters.SectionFragmentPageAdapter;
import com.area51.utils.ConstantsUtil;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class DetailGridViewActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_grid_view);
		
		
		SectionFragmentPageAdapter sectionFragmentAdapter = 
				new SectionFragmentPageAdapter( getSupportFragmentManager());
		ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
		
		viewPager.setAdapter(sectionFragmentAdapter);
		
		Bundle bundle = getIntent().getExtras();
		
		viewPager.setCurrentItem( bundle.getInt( ConstantsUtil.parametro ) );
		
		
	}


	
	
	

}
