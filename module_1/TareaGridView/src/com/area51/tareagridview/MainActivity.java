package com.area51.tareagridview;

import java.util.ArrayList;

import com.area51.adapters.ItemGridViewAdapter;
import com.area51.datos.ItemGridView;
import com.area51.utils.ConstantsUtil;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	int contador = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView matriz = (GridView)findViewById(R.id.matriz);	
		
		//Ponemos un progressbar mientras carga el adapter
		ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        matriz.setEmptyView( progressBar );
        
		
		
		//Instanciamos y llenamos la lista
		ConstantsUtil.lista = new ArrayList<ItemGridView>(); 
				

		ConstantsUtil.lista.add( new ItemGridView(0, "Dr. TV", R.drawable.sample_0  )  );
		ConstantsUtil.lista.add( new ItemGridView(1, "Corazón Indomable", R.drawable.sample_1  )  );
		ConstantsUtil.lista.add( new ItemGridView(2, "Fallo Historico", R.drawable.sample_2  )  );
		ConstantsUtil.lista.add( new ItemGridView(3, "Los Amores de Polo", R.drawable.sample_3  )  );
		ConstantsUtil.lista.add( new ItemGridView(4, "Cuarto Poder", R.drawable.sample_4  )  );
		ConstantsUtil.lista.add( new ItemGridView(5, "Super Sábado", R.drawable.sample_5  )  );
		ConstantsUtil.lista.add( new ItemGridView(6, "El Mundo de Ania & Kin", R.drawable.sample_6  )  );
		ConstantsUtil.lista.add( new ItemGridView(7, "TEC", R.drawable.sample_7  )  );
		ConstantsUtil.lista.add( new ItemGridView(8, "Esto es Guerra", R.drawable.sample_8  )  );
		ConstantsUtil.lista.add( new ItemGridView(9, "100 Peruanos Dicen", R.drawable.sample_9  )  );
		ConstantsUtil.lista.add( new ItemGridView(10, "Al Aire", R.drawable.sample_10  )  );
		ConstantsUtil.lista.add( new ItemGridView(11, "Dr. TV", R.drawable.sample_0  )  );
		ConstantsUtil.lista.add( new ItemGridView(12, "Corazón Indomable", R.drawable.sample_1  )  );
		ConstantsUtil.lista.add( new ItemGridView(13, "Fallo Historico", R.drawable.sample_2  )  );
		ConstantsUtil.lista.add( new ItemGridView(14, "Los Amores de Polo", R.drawable.sample_3  )  );
		ConstantsUtil.lista.add( new ItemGridView(15, "Cuarto Poder", R.drawable.sample_4  )  );
		ConstantsUtil.lista.add( new ItemGridView(16, "Super Sábado", R.drawable.sample_5  )  );
		ConstantsUtil.lista.add( new ItemGridView(17, "El Mundo de Ania & Kin", R.drawable.sample_6  )  );
		ConstantsUtil.lista.add( new ItemGridView(18, "TEC", R.drawable.sample_7  )  );
		ConstantsUtil.lista.add( new ItemGridView(19, "Esto es Guerra", R.drawable.sample_8  )  );
		ConstantsUtil.lista.add( new ItemGridView(20, "100 Peruanos Dicen", R.drawable.sample_9  )  );
		
		ItemGridViewAdapter adapter = new ItemGridViewAdapter( this ); 
		
		matriz.setAdapter(adapter);
		
		
		matriz.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View vistaItem, int position,
					long id) {

				//Seteamos el parametro a enviar
				Bundle bundle = new Bundle();
				bundle.putInt( ConstantsUtil.parametro  , position );
				
				//Creamos el intent
				Intent intent =  new Intent();
				intent.setClass( MainActivity.this , DetailGridViewActivity.class );
				intent.putExtras(bundle);
				
				//Cambiamos de activity
				startActivity(intent);
				
			}
			
			
		});
		
		
		
	}
	
	

	

	

}
