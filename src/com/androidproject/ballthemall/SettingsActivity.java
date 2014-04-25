package com.androidproject.ballthemall;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.androidproject.ballthemall.MainActivity;

public class SettingsActivity extends Activity {

	private ToggleButton toggleButtonMusic;
	private TextView textBGM; // TextView l'état de la musique de fond
	private boolean bgmEnable = false;
	private String statMusic;
	private String choosenLang = "English";
	public final static String PREF_FILE = "GamerPref";
	private SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		preferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE); // recupere les preferences de l'utilisateur
		
		setContentView(R.layout.activity_settings);

		// On récupère l'intent qui a lancé cette activité
	    //Intent i = getIntent();
		textBGM = (TextView) findViewById(R.id.bgMusic);
		
	    toggleButtonMusic = (ToggleButton)  findViewById(R.id.toggleButtonMusic); // declaration du ToggleButton d'activation de la musique de fond
		toggleButtonMusic.setOnCheckedChangeListener(runMusicListener); // affectation du Listener
		
		loadPreferences(); // chargement des preferences de l'utilisateur
		toggleButtonMusic.setChecked(bgmEnable);

	}
	
	// Listener qui permet de d'agir lors de l'interaction sur le bouton d'activation de la musique
		private CompoundButton.OnCheckedChangeListener runMusicListener = new CompoundButton.OnCheckedChangeListener(){
			// Fonction qui permet de verifier le changement d'etat du bouton
			@Override
			public void onCheckedChanged(final CompoundButton buttonView,final boolean isChecked) {
					bgmEnable = isChecked; // affecte la valeur (true/false) a notre boolean suivant si le bouton est enclanche ou non

					if(isChecked) {
						statMusic = " Background Music is On ";
						//startService(MainActivity.svc);
						if(!MainActivity.player.isPlaying()){
							BackgroundSoundService.startMusic();
						}
						
					} else {
						statMusic = " Background Music is Off ";
				       //stopService(MainActivity.svc);
						BackgroundSoundService.stopMusic();
					}
					textBGM.setText(statMusic); // affecte le text au TextView de description de l'etat de la musique
			}
		};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
	    //moveTaskToBack(true);
		saveSettings();
	    this.finish();
	}
	
	// affectation des preferences par defaut
	private void loadPreferences() {
		bgmEnable = preferences.getBoolean("activMusic", false); // musique de fond desactive
		choosenLang = preferences.getString("language", "English"); // valeur du delay a 5

	}

	// fonction permettant de sauvegarder les parametres
	private void saveSettings()
	{
		SharedPreferences.Editor editor = preferences.edit(); 
		editor.putBoolean("activMusic", bgmEnable);
		editor.putString("lang", choosenLang);
		editor.commit();
	}

}
