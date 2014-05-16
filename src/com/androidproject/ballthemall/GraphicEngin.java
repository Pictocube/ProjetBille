package com.androidproject.ballthemall;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;


public class GraphicEngin extends SurfaceView implements SurfaceHolder.Callback {
    Ball mBoule;
    Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.w1n1);
    Bitmap ballDesign = BitmapFactory.decodeResource(getResources(), R.drawable.billetest);
    

	Bitmap lol = Bitmap.createScaledBitmap(ballDesign,2*mBoule.RAYON, 2*mBoule.RAYON,true);
    
    //Bitmap mutableBitmap = ballDesign.copy(Bitmap.Config.ARGB_8888, true);
    //mutableBitmap.reconfigure(mBoule.RAYON, mBoule.RAYON, mutableBitmap.getConfig());
    
    private Chronometer chronometer;
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

    public GraphicEngin(Context pContext) {
        super(pContext);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mThread = new DrawingThread();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);

        mBoule = new Ball();
        
        chronometer = new Chronometer(pContext);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }
    
    
    protected void onDraw(Canvas pCanvas) {
        // Dessiner le fond de l'écran en premier
    	
    	
        //pCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background), 0, 0, null);
        //pCanvas.drawColor(Color.WHITE);
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

            
            
            
            
            while (keepDrawing) {
                canvas = null;

                try {
                    canvas = mSurfaceHolder.lockCanvas();
                    canvas.drawBitmap(resizedBackground, 0, 0, null);
                    
                    long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                    canvas.drawText(String.valueOf(elapsedMillis), 10, 10, mPaint);
                    
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