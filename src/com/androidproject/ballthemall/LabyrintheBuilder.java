package com.androidproject.ballthemall;

import java.util.ArrayList;
import java.util.List;


import com.androidproject.ballthemall.WallBloc.Type;

public class LabyrintheBuilder {
	
	private static List<WallBloc> mBlocks = null;

	// Construit le labyrinthe
    public static List<WallBloc> getLabyrinthe() {
    	String[][] t = getTabLab();
        mBlocks = new ArrayList<WallBloc>();

        for (int i = 0; i < 20 ;i++) {
        	
        	for (int j = 0 ; j < 20 ; j++) {
        		
        		if("w".equals(t[i][j])) {
        			mBlocks.add(new WallBloc(Type.WALL, i ,j,1,1));
        		}
        		
        	}
        }
    	
        

        mBlocks.add(new WallBloc(Type.END, 17, 12,1,1));

        return mBlocks;
    }
    
    public static String[][] getTabLab() {
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
    }

}
