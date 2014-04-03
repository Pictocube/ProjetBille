package com.androidproject.ballthemall;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button start;  // declaration bouton start
	private Button settings;  // declaration bouton settings
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// listener clic sur le bouton start
	private View.OnClickListener startListener = new View.OnClickListener() { 
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	// listener clic sur le bouton settings
	private View.OnClickListener settingsListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			setContentView(R.layout.activity_settings);
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.button_start); // recupere le bouton start declare dans activity_main.xml
        start.setOnClickListener(startListener); // affecte le listener correspondant
        settings = (Button) findViewById(R.id.button_settings);  // recupere le bouton settings declare dans activity_main.xml
        settings.setOnClickListener(settingsListener);  // affecte le listener correspondant
	}



}
