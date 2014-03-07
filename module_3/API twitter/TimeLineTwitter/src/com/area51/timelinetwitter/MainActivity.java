package com.area51.timelinetwitter;

import java.util.ArrayList;

import com.area51.adapter.TweetAdapter;
import com.area51.db.DBOperations;
import com.area51.model.Tweet;
import com.area51.utils.ConstantsUtils;
import com.area51.utils.NetworkUtils;
import com.area51.utils.TwitterUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

	ListView lista_tweet;
	DBOperations dbOperations;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lista_tweet = (ListView)findViewById(R.id.lista_tweet);
		

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		

		dbOperations = new DBOperations(this);
		new TweetsSearchTask().execute();
		
	}

	

	public void ActualizaListView(ArrayList<Tweet> tweets){
		lista_tweet.setAdapter(new TweetAdapter(this, R.layout.row_tweet, tweets));
		
		
	}

	public class TweetsSearchTask extends AsyncTask<Object, Void, ArrayList<Tweet>>{

		private ProgressDialog progressDialog;

		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setMessage(getResources().getString( R.string.tweets_cargando ));
			progressDialog.setCancelable(false);
			progressDialog.show();
		}
		
		@Override
		protected ArrayList<Tweet> doInBackground(Object... param) {
			if(NetworkUtils.haveNetworkConnection(MainActivity.this)){
				return TwitterUtils.getTimelineForSearchTerm(ConstantsUtils.TWITTER_TERM);
			}else{
				return dbOperations.getStatusUpdates();
			}
		}
		
		@Override
		protected void onPostExecute(ArrayList<Tweet> tweets){
			progressDialog.dismiss();

			if (tweets.isEmpty()) {
				Toast.makeText(MainActivity.this, getResources().getString(R.string.tweets_vacio),
						Toast.LENGTH_SHORT).show();
			} else {
				ActualizaListView(tweets);
				Toast.makeText(MainActivity.this, getResources().getString(R.string.tweets_descargando),
						Toast.LENGTH_SHORT).show();
			}
		}


	}
	
	
	
}
