package com.androidproject.ballthemall;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;

public class Ball {
    // Rayon de la boule
    public final static int RAYON = 10;
    
    // Couleur de la boule
    private int mCouleur = Color.GREEN;
    public int getCouleur() {
        return mCouleur;
    }
    
    // Vitesse maximale autorisée pour la boule
    private static final float MAX_SPEED = 6.0f;
    
    // Permet à la boule d'accélérer moins vite
    private static final float COMPENSATEUR = 15.0f;
    
    // Utilisé pour compenser les rebonds
    private static final float REBOND = 1.75f;
    
    // Le rectangle qui correspond à la position de départ de la boule
    private RectF mInitialRectangle = null;

    // A partir du rectangle initial on détermine la position de la boule
    public void setInitialRectangle(RectF pInitialRectangle) {
        this.mInitialRectangle = pInitialRectangle;
        this.mX = pInitialRectangle.left + RAYON;
        this.mY = pInitialRectangle.top + RAYON;
    }
    
    // Le rectangle de collision
    private RectF mRectangle = null;
    
    // Coordonnées en x
    private float mX;
    public float getX() {
        return mX;
    }
    
    
    public void setPosX(float pPosX, float borderLeft, float borderRight) {
        mX = pPosX;

        // Si la boule sort du cadre, on rebondit
        if((mX < RAYON + borderRight ) && (mSpeedY < 0 || borderRight == 0)) {
            mX = RAYON + borderRight;
            // Rebondir, c'est changer la direction de la balle
            mSpeedY = -mSpeedY / REBOND;
        } else if(mX > borderLeft - RAYON && mSpeedY > 0) {
            mX = borderLeft - RAYON;
            mSpeedY = -mSpeedY / REBOND;
        }
    }
    
    // Coordonnées en y
    private float mY;
    public float getY() {
        return mY;
    }

    public void setPosY(float pPosY, float borderTop, float borderBottom) {
        mY = pPosY;
        if(mY < RAYON + borderBottom && (mSpeedX < 0 || borderBottom == 0)) {
            mY = RAYON + borderBottom;
            mSpeedX = -mSpeedX / REBOND;
        } else if(mY > borderTop - RAYON && mSpeedX > 0) {
            mY = borderTop - RAYON;
            mSpeedX = -mSpeedX / REBOND;
        }

    }
    
    

    
    // Vitesse sur l'axe x
    private float mSpeedX = 0;
    // Utilisé quand on rebondit sur les murs horizontaux
    public void changeXSpeed() {
        mSpeedX = -mSpeedX;
    }
    
    // Vitesse sur l'axe y
    private float mSpeedY = 0;
    // Utilisé quand on rebondit sur les murs verticaux
    public void changeYSpeed() {
        mSpeedY = -mSpeedY;
    }
    
    public void setSpeedX(float speedX){
    	mSpeedX = speedX;
    }
    
    public void setSpeedY(float speedY){
    	mSpeedY = speedY;
    }
    
    public void reduceSpeedX(int compens){
    	mSpeedX = mSpeedX/compens;
    }
    
    public void reduceSpeedY(int compens){
    	mSpeedY = mSpeedY/compens;
    }
    
    public float getSpeedX() {
    	return mSpeedX;
    }
    
    public float getSpeedY() {
    	return mSpeedY;
    }
    
    // Taille de l'écran en hauteur
    private int mHeight = -1;
    public void setHeight(int pHeight) {
        this.mHeight = pHeight;
    }
    
    // Taille de l'écran en largeur
    private int mWidth = -1;
    public void setWidth(int pWidth) {
        this.mWidth = pWidth;
    }

    public float getWidth() {
    	return mWidth;
    }
    
    public float getHeight() {
    	return mHeight;
    }
    
    public Ball() {
        mRectangle = new RectF();
    }

    // Mettre à jour les coordonnées de la boule
    public RectF putXAndY(float pX, float pY, float borderLeft , float borderRight, float borderTop, float borderBottom, boolean isWall,boolean isVertical) {
        mSpeedX += pX / COMPENSATEUR;
        if(mSpeedX > MAX_SPEED)
            mSpeedX = MAX_SPEED;
        if(mSpeedX < -MAX_SPEED)
            mSpeedX = -MAX_SPEED;
            
        mSpeedY += pY / COMPENSATEUR;
        if(mSpeedY > MAX_SPEED)
            mSpeedY = MAX_SPEED;
        if(mSpeedY < -MAX_SPEED)
            mSpeedY = -MAX_SPEED;
        
        /*if (isWall) {
            if(Math.abs(mSpeedX) < Math.abs(mSpeedY) || mSpeedY == 0){
            	setPosX(mX + mSpeedY,borderLeft,borderRight);
            } else if (Math.abs(mSpeedX) > Math.abs(mSpeedY) ||mSpeedX == 0){
            	setPosY(mY + mSpeedX,borderTop,borderBottom);
            }
            
        } else {*/
        
        if(!isWall) {
        	setPosX(mX + mSpeedY,borderLeft,borderRight);
        	setPosY(mY + mSpeedX,borderTop,borderBottom);
        } else {
        	if(isVertical) {
        		setPosX(mX + mSpeedY,borderLeft,borderRight);
        	} else {
        		setPosY(mY + mSpeedX,borderTop,borderBottom);
        	}
        }

        	
        	
        //}

        
        //if (((centerY - heightW/2 != borderTop) && (centerY + heightW/2 != borderBottom)) || borderTop == mHeight || borderBottom == 0) {
        	
        //}
        
        
        // Met à jour les coordonnées du rectangle de collision
        mRectangle.set(mX - RAYON, mY - RAYON, mX + RAYON, mY + RAYON);
        
        return mRectangle;
    }
    
    
    // Remet la boule à sa position de départ
    public void reset() {
        mSpeedX = 0;
        mSpeedY = 0;
        this.mX = mInitialRectangle.left + RAYON;
        this.mY = mInitialRectangle.top + RAYON;
    }
}