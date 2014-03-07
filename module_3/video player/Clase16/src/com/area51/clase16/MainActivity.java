package com.area51.clase16;

import java.io.IOException;

import com.area51.util.Constantes;
import com.area51.util.SystemUiHider;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity 
implements OnPreparedListener, OnCompletionListener, 
OnVideoSizeChangedListener, OnInfoListener, OnBufferingUpdateListener,
Callback, OnSeekBarChangeListener, OnErrorListener {

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
	SeekBar seekProgreso;
	TextView tiempoVideo;
	TextView tiempoVideoTotal;
	
	int tiempoHilo = 1000;
	
	
	String TAG = "VIDEO_PLAYER";
	
	
	//Variables de animación
	boolean AUTO_HIDE = true;
	int AUTO_HIDE_DELAY_MILLIS = 5000;
	boolean TOGGLE_ON_CLICK = true;
	int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;
	SystemUiHider mSystemUiHider;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		video = (SurfaceView)findViewById(R.id.video);


		btnPlay = (ImageView)findViewById(R.id.btnPlay);
		btnPause = (ImageView)findViewById(R.id.btnPause);
		btnStop = (ImageView)findViewById(R.id.btnStop);
		
		nombreVideo = (TextView)findViewById(R.id.nombreVideo);
		
		//Para mostrar el progreso del video
		seekProgreso = (SeekBar)findViewById(R.id.seekProgreso);
		//Para mostrar el tiempo de progreso del video y la duración del video
		tiempoVideo = (TextView)findViewById(R.id.tiempoVideo);
		tiempoVideoTotal = (TextView)findViewById(R.id.tiempoVideoTotal);

		//Animación
		frameVideo = (FrameLayout)findViewById(R.id.frameVideo);
		barraInferior = (LinearLayout)findViewById(R.id.barraInferior);
		
		//Inicializamos el tiempo de reproducción		
		Constantes.tiempoTranscurrido = 0;
		
		

		
		
		Log.d( TAG , "onCreate" );
		
	}


	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		
		super.onPostCreate(savedInstanceState);
		delayedHide(AUTO_HIDE_DELAY_MILLIS);
	}
	
	@Override
	protected void onResume() {
		
		//Llamamos al video
		videoSh = video.getHolder();
		videoSh.addCallback(this);
		
		videoMp = new MediaPlayer();
		videoMp.setOnPreparedListener(this);
		videoMp.setOnCompletionListener(this);
		videoMp.setOnInfoListener(this);
		videoMp.setOnVideoSizeChangedListener(this);
		videoMp.setOnBufferingUpdateListener(this);
		videoMp.setOnErrorListener(this);
		
		videoMp.setAudioStreamType( AudioManager.STREAM_MUSIC );

		try {
			
			videoMp.setDataSource( getApplicationContext() , Uri.parse( Constantes.video ) );
			
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		

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
		
		btnPause.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					if( videoMp.isPlaying() ){
						videoHandler.removeCallbacks( videoRunnable );
						Constantes.reproduccion = false;
						videoMp.pause();
						btnPlay.setVisibility(View.VISIBLE);
						btnStop.setVisibility(View.GONE);
						btnPause.setVisibility(View.GONE);
						delayedHide(AUTO_HIDE_DELAY_MILLIS);
					}
					
				} catch (Exception e) {
					e.getMessage();
				}
				
			}
		});
		
		
		btnPlay.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					Constantes.reproduccion = true;
					videoMp.start();
					btnPause.setVisibility(View.VISIBLE);
					btnStop.setVisibility(View.GONE);
					btnPlay.setVisibility(View.GONE);
					delayedHide(AUTO_HIDE_DELAY_MILLIS);
					videoHandler.postDelayed( videoRunnable , tiempoHilo );
					
				} catch (Exception e) {
					e.getMessage();
				}
				
			}
		});
		
		

		mSystemUiHider = SystemUiHider.getInstance(this, frameVideo,
				HIDER_FLAGS);
		mSystemUiHider.setup();
		mSystemUiHider
				.setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
					// Cached values.
					int mControlsHeightBottom;
					int mShortAnimTimeBottom;
					int mControlsHeightTop;
					int mShortAnimTimeTop;
					
					
					
					@Override
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
					public void onVisibilityChange(boolean visible) {
						
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
							//Para barra superior
							if (mControlsHeightTop == 0) {
								mControlsHeightTop = -nombreVideo.getHeight();
							}
							if (mShortAnimTimeTop == 0) {
								mShortAnimTimeTop = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							nombreVideo
									.animate()
									.translationY(visible ? 0 : mControlsHeightTop)
									.setDuration(mShortAnimTimeTop);
							

							//Para barra inferior
							if (mControlsHeightBottom == 0) {
								mControlsHeightBottom = barraInferior.getHeight();
							}
							if (mShortAnimTimeBottom == 0) {
								mShortAnimTimeBottom = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							barraInferior
									.animate()
									.translationY(visible ? 0 : mControlsHeightBottom)
									.setDuration(mShortAnimTimeBottom);
						} else {
							barraInferior.setVisibility(visible ? View.VISIBLE
									: View.GONE);
							nombreVideo.setVisibility(visible ? View.VISIBLE
									: View.GONE);
						}

						if (visible && AUTO_HIDE) {
							delayedHide(AUTO_HIDE_DELAY_MILLIS);
						}
					}
				});

		// Set up the user interaction to manually show or hide the system UI.
		frameVideo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TOGGLE_ON_CLICK) {
					mSystemUiHider.toggle();
				} else {
					mSystemUiHider.show();
				}
			}
		});
		
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		videoMp.pause();
		Constantes.tiempoTranscurrido = videoMp.getCurrentPosition();
		videoHandler.removeCallbacks( videoRunnable );
		super.onPause();
	}


	public void liberaRecursos(){

		if( videoMp.isPlaying() ){	
			videoHandler.removeCallbacks( videoRunnable );
			Constantes.reproduccion = false;
			videoMp.pause();
			videoMp.stop();
			videoMp.release();
		}
		videoHandler.removeCallbacks( videoRunnable );
		finish();
	}
	
	@Override
	public boolean onError(MediaPlayer mp, int whatError, int extra) {

		try {

			if (whatError == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
			  Log.d(TAG, "Media Error,Murió el servidor " + extra);
			} else if (whatError == MediaPlayer.MEDIA_ERROR_UNKNOWN) {
			  Log.d(TAG, "Media Error, Error desconocido " + extra);
			}else{
			  Log.d(TAG, " || " + whatError + " || " + extra);
			}
			
			finish();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		
		if( fromUser ){

			Constantes.tiempoTranscurrido = seekProgreso.getProgress();
			detectaTiempo( tiempoVideo , Constantes.tiempoTranscurrido, 1 );
			delayedHide(AUTO_HIDE_DELAY_MILLIS);
		}
	
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
		videoHandler.removeCallbacks( videoRunnable);		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

		videoMp.seekTo( Constantes.tiempoTranscurrido );
		videoHandler.postDelayed( videoRunnable , tiempoHilo );
		
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

		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	
		
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		
		
	}

	@Override
	public boolean onInfo(MediaPlayer mp, int whatInfo, int extra) {

		try {

			if (whatInfo == MediaPlayer.MEDIA_INFO_BAD_INTERLEAVING) {
			  Log.d(TAG, "Media Info, Media Info Bad Interleaving " + extra);
			} else if (whatInfo == MediaPlayer.MEDIA_INFO_NOT_SEEKABLE) {
			  Log.d(TAG, "Media Info, Media Info Not Seekable " + extra);
			} else if (whatInfo == MediaPlayer.MEDIA_INFO_UNKNOWN) {
			  Log.d(TAG, "Media Info, Media Info Unknown " + extra);
			} else if (whatInfo == MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING) {
			  Log.d(TAG, "MediaInfo, Media Info Video Track Lagging " + extra);
			}else if (whatInfo == MediaPlayer.MEDIA_INFO_METADATA_UPDATE) {
			  Log.d(TAG,"MediaInfo, Media Info Metadata Update " + extra);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

		seekProgreso.setMax( mp.getDuration() );
		seekProgreso.setProgress( Constantes.tiempoTranscurrido );
		seekProgreso.setOnSeekBarChangeListener(this);
		
		detectaTiempo( tiempoVideoTotal , videoMp.getDuration(), 2 );
		
	}

	@Override
	public void onCompletion(MediaPlayer mp) {

		videoHandler.removeCallbacks( videoRunnable);
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {

		try {

			mp.seekTo( Constantes.tiempoTranscurrido );
			
			if( Constantes.reproduccion ){
				mp.start();
				videoHandler.postDelayed( videoRunnable , tiempoHilo );
			}			
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
		Log.d( TAG , "onPrepared" );
		
	}
	

	public void detectaTiempo( TextView texto, int tiempoCalculado , int tipo  ){
		
		int psegundos = tiempoCalculado/1000;	
		
		String tiempo;
		//Actualizamos minutos
		int pminutos = psegundos / 60;
		psegundos = psegundos % 60;
	   	//Actualizamos horas
	   	int phoras = pminutos / 60;
	   	pminutos = pminutos % 60;
	   	tiempo = String.format( "%02d : %02d : %02d", phoras , pminutos , psegundos );
	   	if( tipo == 1 ){
		   	texto.setText( tiempo );	   		
	   	}else{
		   	texto.setText( " / " +  tiempo );	   		
	   	}
		
	}


	View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (AUTO_HIDE) {
				delayedHide(AUTO_HIDE_DELAY_MILLIS);
			}
			return false;
		}
	};
	
	Handler mHideHandler = new Handler();
	Runnable mHideRunnable = new Runnable() {
		@Override
		public void run() {
			mSystemUiHider.hide();
		}
	};
	
	private void delayedHide(int delayMillis) {
		mHideHandler.removeCallbacks(mHideRunnable);
		mHideHandler.postDelayed(mHideRunnable, delayMillis);
	}
	
	
	//Para conteo del video

	Handler videoHandler = new Handler();
	Runnable videoRunnable = new Runnable() {
		@Override
		public void run() {
			
			Log.d( TAG , "Runnable" );

			videoHandler.postDelayed( videoRunnable , tiempoHilo );
			
			if( videoMp.isPlaying()  ){

				seekProgreso.setProgress(  videoMp.getCurrentPosition()  );

				Constantes.tiempoTranscurrido = seekProgreso.getProgress();
				detectaTiempo( tiempoVideo , Constantes.tiempoTranscurrido , 1 );
				
			}		
		}
	};


}
















