package com.androidproject.ballthemall;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.androidproject.ballthemall.WallBloc.Type;

public class LabyrintheBuilder {
	
	private static Bitmap background = null;
	private static List<WallBloc> mBlocks = null;
	private static String wrldId = WorldScrollAdapter.WolrdID;
	private static String lvlId = LevelGridAdapter.levelID;

	// Construit le labyrinthe
    public static List<WallBloc> getLabyrinthe() {
    	wrldId = WorldScrollAdapter.WolrdID;
    	lvlId = LevelGridAdapter.levelID;

        mBlocks = new ArrayList<WallBloc>();
    	
        if (wrldId.equals("Kill' Em All")) {
        	if(lvlId.equals("1")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.WALL,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.WALL,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.WALL,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,18,5,2,1));       	
        	} else if(lvlId.equals("2")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.WALL,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.WALL,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,18,5,2,1));       	
        	} else if(lvlId.equals("3")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.WALL,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,18,5,2,1));       	
        	} else if(lvlId.equals("4")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.WALL,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.WALL,18,5,2,1));       	
        	} else if(lvlId.equals("5")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.WALL,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	} else if(lvlId.equals("6")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.HOLE,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.WALL,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	} else if(lvlId.equals("7")){
        		mBlocks.add(new WallBloc(Type.WALL,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.HOLE,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.HOLE,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	} else if(lvlId.equals("8")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.WALL,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.HOLE,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.WALL,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.HOLE,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	} else if(lvlId.equals("9")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.HOLE,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.HOLE,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.HOLE,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.HOLE,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.WALL,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	} else if(lvlId.equals("10")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,10,7,1));
        		mBlocks.add(new WallBloc(Type.HOLE,3,0,1,5));
        		mBlocks.add(new WallBloc(Type.HOLE,3,7,6,1));
        		mBlocks.add(new WallBloc(Type.HOLE,6,1,4,1));
        		mBlocks.add(new WallBloc(Type.HOLE,9,2,1,7));
        		mBlocks.add(new WallBloc(Type.HOLE,12,0,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,12,10,1,4));
        		mBlocks.add(new WallBloc(Type.HOLE,15,0,1,2));
        		mBlocks.add(new WallBloc(Type.HOLE,15,4,1,6));
        		mBlocks.add(new WallBloc(Type.HOLE,18,5,2,1));       	
        	}
        } else if (wrldId.equals("Ghost Busters")) {
        	if(lvlId.equals("1")){
        		mBlocks.add(new WallBloc(Type.WALL,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.WALL,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.WALL,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.WALL,16,8,4,1));
        	} else if(lvlId.equals("2")){
        		mBlocks.add(new WallBloc(Type.WALL,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.WALL,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.WALL,16,8,4,1));
        	} else if(lvlId.equals("3")){
        		mBlocks.add(new WallBloc(Type.WALL,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.WALL,16,8,4,1));
        	} else if(lvlId.equals("4")){
        		mBlocks.add(new WallBloc(Type.WALL,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.WALL,16,8,4,1));
        	} else if(lvlId.equals("5")){
        		mBlocks.add(new WallBloc(Type.WALL,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} else if(lvlId.equals("6")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} else if(lvlId.equals("7")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} else if(lvlId.equals("8")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.WALL,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.HOLE,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} else if(lvlId.equals("9")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.HOLE,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.HOLE,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.WALL,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} else if(lvlId.equals("10")){
        		mBlocks.add(new WallBloc(Type.HOLE,0,3,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,4,2,1,2));
	        	mBlocks.add(new WallBloc(Type.HOLE,7,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,6,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,2,7,1,3));
	        	mBlocks.add(new WallBloc(Type.HOLE,5,9,1,3));
	        	mBlocks.add(new WallBloc(Type.HOLE,10,2,1,10));
	        	mBlocks.add(new WallBloc(Type.HOLE,11,2,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,5,7,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,6,1,4));
	        	mBlocks.add(new WallBloc(Type.HOLE,16,8,4,1));
        	} 
	        	
        } else if (wrldId.equals("MOdAFuKA")) {
        	if(lvlId.equals("1")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.WALL,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.WALL,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("2")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.WALL,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.WALL,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("3")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.WALL,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("4")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.WALL,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("5")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("6")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("7")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.WALL,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("8")){
        		mBlocks.add(new WallBloc(Type.WALL,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("9")){
        		mBlocks.add(new WallBloc(Type.HOLE,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.WALL,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.WALL,17,11,1,1));
        	} else if(lvlId.equals("10")){
        		mBlocks.add(new WallBloc(Type.HOLE,5,0,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,2,5,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,13,4,1,6));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,14,4,6,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,0,8,4,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,8,3,1,9));
	        	mBlocks.add(new WallBloc(Type.HOLE,9,5,2,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,11,8,2,1));
	        	mBlocks.add(new WallBloc(Type.HOLE,17,11,1,1));
        	}
	        	

        }
    	
    	
        mBlocks.add(new WallBloc(Type.END, 19,6 ,1,1));

        return mBlocks;
    }
    
    public static Bitmap getAddaptedBackground(){
    	wrldId = WorldScrollAdapter.WolrdID;
    	lvlId = LevelGridAdapter.levelID;

     	SharedPreferences preferences = AppContext.getAppContext().getSharedPreferences("GamerPref", Context.MODE_PRIVATE);
     	
     	Boolean mactive = preferences.getBoolean("activMusic", false);
     	
     	if (wrldId.equals("Kill' Em All")) {
     		if(mactive){
     			BackgroundSoundService.startMusic(R.raw.dragula);
     		}

	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w1n1);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w1nf);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w1nx);
	    	}
     	} else if (wrldId.equals("Ghost Busters")) {
     		if(mactive){
     			BackgroundSoundService.startMusic(R.raw.ghostbustters);
     		}
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2n1);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2nf);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2nx);
	    	}
     	} else if (wrldId.equals("MOdAFuKA")) {
     		if(mactive){
     			BackgroundSoundService.startMusic(R.raw.spank);
     		}
     		 
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w3n1);
	    	} else if(lvlId.equals("10")){
	    		 
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w3nf);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w3nx);
	    	}
     	} else if (wrldId.equals("Toxicity")) {
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	}
     	} else {
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	}
     	}
    	
    	
    	int width = background.getWidth();
        int height = background.getHeight();
        float scaleWidth = ((float) 800) / width;
        float scaleHeight = ((float) 480) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBackground= Bitmap.createBitmap(background, 0, 0, width, height, matrix, false);
    	return resizedBackground;
    }

}