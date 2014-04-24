package com.androidproject.ballthemall;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class LevelSelectorActivity extends Activity {

	GridView listViewLevel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_selector);
		listViewLevel = (GridView)findViewById(R.id.listViewLevel);  // recupere la ListView 
		listViewLevel.setAdapter(new LevelGridAdapter(LevelSelectorActivity.this));
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_selector, menu);
		return true;
	}

}
