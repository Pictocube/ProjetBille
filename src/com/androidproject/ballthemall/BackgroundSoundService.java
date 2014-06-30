package com.androidproject.ballthemall;

import android.media.MediaPlayer;
import android.net.Uri;

public class BackgroundSoundService {

    public static MediaPlayer player = null;
    
    public BackgroundSoundService() {
    	player = MediaPlayer.create(AppContext.getAppContext(),R.raw.maintheme);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
    }
    
    public static void startMusic(int musicUri){
    	player.reset();
    	player = MediaPlayer.create(AppContext.getAppContext(),musicUri);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
    	player.start();
   
    }
    
    public static void stopMusic() {
    	player.stop();
    }
    public static void pauseMusic() {
    	player.pause();
    }    

    public boolean isPlaying(){
    	return player.isPlaying();
    }
    
    public void setCurrentMusic(int res){
    	
    }
}