package com.androidproject.ballthemall;

import android.media.MediaPlayer;

public class BackgroundSoundService {

    public static MediaPlayer player;
    
    public BackgroundSoundService() {
    	player = MediaPlayer.create(AppContext.getAppContext(),R.raw.maintheme);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
    }
    
    public static void startMusic(){
    	player.reset();
    	player = MediaPlayer.create(AppContext.getAppContext(),R.raw.maintheme);
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