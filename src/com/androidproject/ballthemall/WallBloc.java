package com.androidproject.ballthemall;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.Display;
import android.view.WindowManager;

public class WallBloc {
    enum  Type {WALL, HOLE, START, END};
    
    private float SCREEN_WIDTH = 0;
    
    private float SCREEN_HEIGHT = 0;
    
    private Type mType = null;
    private RectF mRectangle = null;
    
    public Type getType() {
        return mType;
    }

    public RectF getRectangle() {
        return mRectangle;
    }
    
    public void setScreenSize() {
        WindowManager wm = (WindowManager) AppContext.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        SCREEN_WIDTH = display.getWidth();  
        SCREEN_HEIGHT = display.getHeight();
    }

    public WallBloc(Type pType, int pX, int pY,int nbCaseX, int nbCaseY) {
    	setScreenSize();
        this.mType = pType;
        this.mRectangle = new RectF(pX * (SCREEN_WIDTH/20), pY * (SCREEN_HEIGHT/12), (pX + nbCaseX) * (SCREEN_WIDTH/20), (pY + nbCaseY) * (SCREEN_HEIGHT/12));
    }
}