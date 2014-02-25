package com.area51.clase12;

import com.area51.asynctask.RequestAsynctask;
import com.area51.utils.Constantes;
import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.ValueDependentColor;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.app.Activity;
import android.graphics.Color;

public class ResultadoActivity extends Activity {

	RequestAsynctask ra;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ra = new RequestAsynctask( this );
		ra.resultadoVotacion( Constantes.API + Constantes.SECTION_VOTACION_RESULTADO  );
		
	}

	public void resultadoVotacion( String jsonResultado ){
		
		Log.d("", jsonResultado );
		GraphViewData gdata[] = new GraphViewData[4];
		
		for (int i = 0; i < 4; i++) {
			gdata[i] = new GraphViewData(i + 1, 2.0d); 
		}
		
		GraphViewSeries exampleSeries 
		= new GraphViewSeries(gdata);
		
		// init example series data
		/*
		GraphViewSeries exampleSeries 
		= new GraphViewSeries(new GraphViewData[] {
			      new GraphViewData(1, 2.0d)
			      , new GraphViewData(2, 1.5d)
			      , new GraphViewData(3, 2.5d)
			      , new GraphViewData(4, 1.0d)
			});
			*/
			 
			GraphView graphView = new LineGraphView(
			      this // context
			      , "GraphViewDemo" // heading
			);
			graphView.addSeries(exampleSeries); // data
			 
			LinearLayout layout = (LinearLayout) findViewById(R.id.graph01);
			layout.addView(graphView);
		
	}
	

}
