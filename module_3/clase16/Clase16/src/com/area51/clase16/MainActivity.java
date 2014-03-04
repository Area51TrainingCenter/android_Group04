package com.area51.clase16;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity 
implements OnPreparedListener, OnCompletionListener, 
OnVideoSizeChangedListener, OnInfoListener, OnBufferingUpdateListener, Callback{

	FrameLayout frameVideo;
	ImageView btnPlay;
	ImageView btnPause;
	ImageView btnStop;
	LinearLayout barraInferior;
	TextView nombreVideo;
	
	//Para reproducción
	SurfaceView video;
	MediaPlayer videoMp;
	SurfaceHolder videoSh;
	
	Boolean display  = false;
	
	
	String TAG = "VIDEO_PLAYER";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		video = (SurfaceView)findViewById(R.id.video);
		frameVideo = (FrameLayout)findViewById(R.id.frameVideo);
		barraInferior = (LinearLayout)findViewById(R.id.barraInferior);

		btnPlay = (ImageView)findViewById(R.id.btnPlay);
		btnPause = (ImageView)findViewById(R.id.btnPause);
		btnStop = (ImageView)findViewById(R.id.btnStop);
		
		nombreVideo = (TextView)findViewById(R.id.nombreVideo);
		
		Log.d( TAG , "onCreate" );
		
	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
		
		String path = "android.resource://" + getPackageName() 
				+ "/" + R.raw.muestra;

		//path = "playlist.m3u8";		
		
		videoSh = video.getHolder();
		videoSh.addCallback(this);
		
		videoMp = new MediaPlayer();
		videoMp.setOnPreparedListener(this);
		videoMp.setOnCompletionListener(this);
		videoMp.setOnInfoListener(this);
		videoMp.setOnVideoSizeChangedListener(this);
		videoMp.setOnBufferingUpdateListener(this);
		videoMp.setAudioStreamType( AudioManager.STREAM_MUSIC );
				
		try {
			
			videoMp.setDataSource( getApplicationContext() , Uri.parse(path) );
			
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		frameVideo.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( display == false ){
					display = true;
					HideBars();					
				}else{
					display = false;
					ShowBars();					
				}				
			}
		});
		

		btnPlay.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					videoMp.start();
					btnPause.setVisibility(View.VISIBLE);
					btnStop.setVisibility(View.GONE);
					btnPlay.setVisibility(View.GONE);
				} catch (Exception e) {
					e.getMessage();
				}
			}
		});
		
		btnPause.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					if( videoMp.isPlaying() ){
						videoMp.pause();
						btnPlay.setVisibility(View.VISIBLE);
						btnStop.setVisibility(View.GONE);
						btnPause.setVisibility(View.GONE);
					}
					
				} catch (Exception e) {
					e.getMessage();
				}
			}
		});

		
		btnStop.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					liberaRecursos();
					
				} catch (Exception e) {
					e.getMessage();
				}
			}
		});
		

		ShowBars();
		
		Log.d( TAG , "onResume" );
		
	}
	
	public void liberaRecursos(){

		if( videoMp.isPlaying() ){
			videoMp.release();
		}
		
		finish();
	}
	
	@Override
	protected void onDestroy() {
		liberaRecursos();
		
		super.onDestroy();
	}
	
	public void ShowBars(){
		barraInferior.setVisibility(View.VISIBLE);
		nombreVideo.setVisibility(View.VISIBLE);
	}

	public void HideBars(){
		barraInferior.setVisibility(View.GONE);
		nombreVideo.setVisibility(View.GONE );
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
			
		try {

			mp.start();
				
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		Log.d( TAG , "onPrepared" );		
	}

	@Override
	public boolean onInfo(MediaPlayer mp, int what, int extra) {
		
		Log.d( TAG , "onInfo" );
		
		return false;
	}

	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
		
		Log.d( TAG , "onVideoSizeChanged" );
		
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		Log.d( TAG , "onCompletion" );
		
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub
		Log.d( TAG , "onBufferingUpdate" );		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		

		videoMp.setDisplay(holder);
		
		try {
			
			//Para streaming de video
			//mp.prepareAsync();
			
			//Para reproducción desde el dispositivo
			videoMp.prepare();
			
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		

		Log.d( TAG , "surfaceCreated" );
		
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
		Log.d( TAG , "surfaceChanged" );
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

		Log.d( TAG , "surfaceDestroyed" );
		
	}


}
