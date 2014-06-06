package com.androidproject.ballthemall;

import java.util.ArrayList;
import java.util.List;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.androidproject.ballthemall.WallBloc.Type;

public class LabyrintheBuilder {
	
	private static Bitmap background = null;
	private static List<WallBloc> mBlocks = null;

	// Construit le labyrinthe
    public static List<WallBloc> getLabyrinthe() {
    	//String[][] t = getTabLab();
        mBlocks = new ArrayList<WallBloc>();

        /*for (int i = 0; i < 20 ;i++) {
        	
        	for (int j = 0 ; j < 20 ; j++) {
        		
        		if("w".equals(t[i][j])) {
        			mBlocks.add(new WallBloc(Type.WALL, i ,j,1,1));
        		}
        		
        	}
        }
    	*/
    	
    	mBlocks.add(new WallBloc(Type.WALL, 3, 0,1,8));
    	mBlocks.add(new WallBloc(Type.WALL, 6, 3,1,9));
    	mBlocks.add(new WallBloc(Type.WALL, 7, 3,3,1));
    	mBlocks.add(new WallBloc(Type.WALL, 10, 8,4,1));
    	mBlocks.add(new WallBloc(Type.WALL, 13, 0,1,9));    	
    	
    	
        mBlocks.add(new WallBloc(Type.END, 19,5 ,1,1));

        return mBlocks;
    }
    
    public static Bitmap getAddaptedBackground(){
    	String wrldId = WorldScrollAdapter.WolrdID;
     	String lvlId = LevelGridAdapter.levelID;
    	
     	if (wrldId.equals("Kill' Em All")) {
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w1n1);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w1nf);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	}
     	} else if (wrldId.equals("Ghost Busters")) {
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2n1);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2nf);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w2nx);
	    	}
     	} else if (wrldId.equals("MOdAFuKA")) {
     		
	    	if (lvlId.equals("1")) {
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.w3n1);
	    	} else if(lvlId.equals("10")){
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
	    	} else {
	    		
	    		background = BitmapFactory.decodeResource(AppContext.getAppContext().getResources(), R.drawable.background);
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
    
   /* public static String[][] getTabLab() {
    	String[][] levelTab = {	{"b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"},
    						   	{"b","e","e","e","w","e","e","e","e","e","w","e","e","e","e","e","e","e","e","b"},
						    	{"b","e","e","e","w","e","e","e","e","e","w","e","e","e","e","e","e","e","e","b"},
						    	{"b","e","e","e","w","e","e","e","e","e","w","e","e","e","e","e","e","e","e","b"},
						    	{"b","e","e","e","w","e","e","e","e","e","w","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","w","w","w","e","e","e","e","e","w","e","e","w","e","e","w","w","w","b"},
						    	{"b","e","e","e","e","e","e","w","w","w","w","w","w","w","e","e","w","e","e","b"},
						    	{"b","e","e","e","e","e","e","e","e","e","w","e","e","e","e","e","w","e","e","b"},
						    	{"b","e","w","w","w","w","e","e","e","e","w","e","e","e","e","e","w","e","e","b"},
						    	{"b","e","e","e","e","w","e","e","e","e","w","e","e","e","e","e","w","e","e","b"},
						    	{"b","e","e","e","e","w","e","e","e","e","w","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","w","w","w","w","e","e","e","e","e","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","w","e","e","e","e","e","e","e","e","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","w","e","e","e","e","e","e","e","e","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","w","e","e","e","e","w","w","w","w","e","e","w","e","e","e","e","e","b"},
						    	{"b","e","e","e","e","e","e","w","e","e","e","e","e","w","w","w","w","e","e","b"},
						    	{"b","e","e","e","e","e","e","w","e","e","e","e","e","e","e","e","e","e","e","b"},
						    	{"b","e","e","e","e","e","e","w","e","e","e","e","e","e","e","e","e","e","e","b"},
						    	{"b","e","e","e","e","e","e","w","e","e","e","e","e","e","e","e","e","e","e","b"},
						    	{"b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"}};
    	return levelTab;
    }*/

}
