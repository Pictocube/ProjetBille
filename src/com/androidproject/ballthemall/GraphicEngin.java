package com.androidproject.ballthemall;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;


public class GraphicEngin extends SurfaceView implements SurfaceHolder.Callback {
    Ball mBoule;
   // Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.w1n1);
    Bitmap ballDesign = BitmapFactory.decodeResource(getResources(), R.drawable.billetest);
    

	Bitmap lol = Bitmap.createScaledBitmap(ballDesign,2*mBoule.RAYON, 2*mBoule.RAYON,true);
    
    
    private static Chronometer chronometer;
    long elapsedTime=0;
    String currentTime="";
    long startTime=SystemClock.elapsedRealtime();
    
    public Ball getBoule() {
        return mBoule;
    }

    public void setBoule(Ball pBoule) {
        this.mBoule = pBoule;
    }

    SurfaceHolder mSurfaceHolder;
    DrawingThread mThread;

    private List<WallBloc> mBlocks = null;
    public List<WallBloc> getBlocks() {
        return mBlocks;
    }

    public void setBlocks(List<WallBloc> pBlocks) {
        this.mBlocks = pBlocks;
    }

    Paint mPaint; 
    Paint tPaint;
    Typeface tf;

    public GraphicEngin(Context pContext) {
        super(pContext);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mThread = new DrawingThread();
        
        tPaint = new Paint();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        
        tf = Typeface.createFromAsset(pContext.getAssets(), "digital.ttf");
        

        mBoule = new Ball();
        
        chronometer = new Chronometer(pContext);

        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }
    
    public void setChronoValue() {
    	 long time = SystemClock.elapsedRealtime() - chronometer.getBase();
         int h   = (int)(time/3600000);
         int m = (int)(time - h*3600000)/60000;
         int s= (int)(time - h*3600000- m*60000)/1000 ;
         String mm = m < 10 ? "0"+m: m+"";
         String ss = s < 10 ? "0"+s: s+"";
         chronometer.setText(mm+":"+ss);
    }
    
    public static String getChronoValue() {
    	return chronometer.getText().toString();
    }
    
    protected void onDraw(Canvas pCanvas) {

    	
    	
    	tPaint.setColor(Color.RED);
    	tPaint.setTextSize(40);
    	tPaint.setStyle(Paint.Style.FILL_AND_STROKE); 
    	tPaint.setStrokeWidth(1); 
    	tPaint.setColor(Color.RED); 
    	tPaint.setTypeface(tf);
    	
        if(mBlocks != null) {
            // Dessiner tous les blocs du labyrinthe
            for(WallBloc b : mBlocks) {
                switch(b.getType()) {
                case START:
                    mPaint.setColor(Color.YELLOW);
                    break;
                case END:
                    mPaint.setColor(Color.RED);
                    break;
                case WALL:
                    mPaint.setColor(Color.BLACK);
                    break;
                case HOLE:
                    mPaint.setColor(Color.GREEN);
                    break;
                }
                pCanvas.drawRect(b.getRectangle(), mPaint);
            }
        }

        // Dessiner la boule
        if(mBoule != null) {
           mPaint.setColor(mBoule.getCouleur());
           
           pCanvas.drawBitmap(lol, mBoule.getX()-mBoule.RAYON, mBoule.getY() - mBoule.RAYON,null);

           //pCanvas.drawCircle(mBoule.getX(), mBoule.getY(), Ball.RAYON, mPaint);
            
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder pHolder, int pFormat, int pWidth, int pHeight) {
        //
    }

    @Override
    public void surfaceCreated(SurfaceHolder pHolder) {
        mThread.keepDrawing = true;
        mThread.start();
        // Quand on crée la boule, on lui indique les coordonnées de l'écran
        if(mBoule != null ) {
            this.mBoule.setHeight(getHeight());
            this.mBoule.setWidth(getWidth());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder pHolder) {
        mThread.keepDrawing = false;
        boolean retry = true;
        while (retry) {
            try {
                mThread.join();
                retry = false;
            } catch (InterruptedException e) {}
        }
         
    }

	private class DrawingThread extends Thread {
        boolean keepDrawing = true;

		@Override
        public void run() {
            Canvas canvas;
            
            Bitmap Background= LabyrintheBuilder.getAddaptedBackground();

            
            
            
            
            while (keepDrawing) {
                canvas = null;

                try {
                    canvas = mSurfaceHolder.lockCanvas();
                    canvas.drawBitmap(Background, 0, 0, null);
                    
                    setChronoValue();
                    String chStr = getChronoValue();
                    
                    canvas.drawText(chStr, 15, 30, tPaint);
                    synchronized (mSurfaceHolder) {
                        onDraw(canvas);
                    }
                } finally {
                    if (canvas != null)
                        mSurfaceHolder.unlockCanvasAndPost(canvas);
                }

                // Pour dessiner à 50 fps
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {}
            }
        }
    }
}