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
    
    public float posX = 0;
    public float posY = 0;
    public float sizeX = 0;
    public float sizeY = 0;

    public float caseX = 0;
    public float caseY = 0;
    
    
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
    	this.caseX = SCREEN_WIDTH/20;
        this.caseY = SCREEN_HEIGHT/12;
        this.posX = pX * (SCREEN_WIDTH/20);
        this.posY = pY * (SCREEN_HEIGHT/12);
        this.sizeX = (pX + nbCaseX) * (SCREEN_WIDTH/20);
        this.sizeY =  (pY + nbCaseY) * (SCREEN_HEIGHT/12);
        this.mRectangle = new RectF(posX, posY,sizeX,sizeY);
        // on peut récuperer les position pour construire une image
    }
}