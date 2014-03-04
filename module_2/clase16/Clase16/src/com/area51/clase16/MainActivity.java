package com.area51.clase16;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends Activity {

	VideoView video;
	FrameLayout frameVideo;
	Button btnPlay;
	Button btnPause;
	Button btnStop;
	LinearLayout barraInferior;
	TextView nombreVideo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		video = (VideoView)findViewById(R.id.video);
		
		
		
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		//Uri uri = Uri.parse("android.resource://" + getPackageName() +"/"+ R.raw.videoclase16) ;
		//video.setVideoURI(uri);
		String path = "android.resource://" + getPackageName() 
				+ "/" + R.raw.muestra;
		video.setVideoPath(path);
		video.setMediaController( new MediaController(this));	
		//video.start();
		
		
	}


}
