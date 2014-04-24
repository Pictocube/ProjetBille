package com.androidproject.ballthemall;

import android.graphics.RectF;
import android.util.DisplayMetrics;

public class WallBloc {
    enum  Type { TROU, DEPART, ARRIVEE };
    
    DisplayMetrics metrics = new DisplayMetrics();
    
    private float SIZE = Ball.RAYON * 3.5f;
    private float SCREEN_WIDTH = metrics.widthPixels;
    private float SCREEN_HEIGHT = metrics.heightPixels;
    
    private Type mType = null;
    private RectF mRectangle = null;
    
    public Type getType() {
        return mType;
    }

    public RectF getRectangle() {
        return mRectangle;
    }

    public WallBloc(Type pType, int pX, int pY) {
        this.mType = pType;
        this.mRectangle = new RectF(pX * SIZE, pY * SIZE, (pX + 1) * SIZE, (pY + 1) * SIZE);
        //this.mRectangle = new RectF(pX * (SCREEN_HEIGHT*10), pY * (SCREEN_HEIGHT*10), (pX + 1) * (SCREEN_HEIGHT*10), (pY + 1) * (SCREEN_HEIGHT*10));
    }
}