package com.area51.internacionalizacion;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	Locale myLocale;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
	
		
		super.onResume();
		

		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		String idioma = "";
		
		int id = item.getItemId();
		if (id == R.id.idioma_a) {
			idioma = "ja";
			return true;
		}
		if (id == R.id.idioma_b) {
			idioma = "es";
			return true;
		}
		if (id == R.id.idioma_c) {
			idioma = "fr";
			return true;
		}		

		myLocale = new Locale(idioma);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
		
		
		
		return true;
	}

}
