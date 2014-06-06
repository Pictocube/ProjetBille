package com.androidproject.ballthemall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class WorldSelectorActivity extends Activity {

	HorizontalListView listViewWorlds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_world_selector);
		
		listViewWorlds = (HorizontalListView)findViewById(R.id.listViewWorld);  // recupere la ListView 
		 
		listViewWorlds.setAdapter(new WorldScrollAdapter(WorldSelectorActivity.this));
		//listViewWorlds.setOnItemClickListener(onWorldSelectListener);
	}

	// listener clic sur un item de la liste
	/*private ListView.OnItemClickListener onWorldSelectListener = new ListView.OnItemClickListener() { 

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			Intent i = new Intent(WorldSelectorActivity.this,LevelSelectorActivity.class);
			WorldSelectorActivity.this.startActivity(i);
		}
		
	};*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.world_selector, menu);
		return true;
	}

}
