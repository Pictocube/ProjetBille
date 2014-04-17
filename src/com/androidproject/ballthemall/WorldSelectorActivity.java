package com.androidproject.ballthemall;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

public class WorldSelectorActivity extends Activity {

	//HorizontalScrollView listViewWorlds;
	ListView listViewWorlds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_world_selector);
		
		listViewWorlds = (ListView)findViewById(R.id.listViewLevel);  // recupere la ListView 
		 
		listViewWorlds.setAdapter(new LevelScrollAdapter(this));
		listViewWorlds.setOnItemClickListener(onLevelSelectListener);
	}

	// listener clic sur un item de la liste
	private ListView.OnItemClickListener onLevelSelectListener = new ListView.OnItemClickListener() { 

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		}
		
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.world_selector, menu);
		return true;
	}

}
