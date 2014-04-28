package com.androidproject.ballthemall;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GraphicEngin extends SurfaceView implements SurfaceHolder.Callback {
    Ball mBoule;
    Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
    Bitmap ballDesign = BitmapFactory.decodeResource(getResources(), R.drawable.bille);
    Drawable ballD = getResources().getDrawable(R.drawable.bille);
    
    Bitmap lol;
    //ShapeDrawable ballShape = new ShapeDrawable(new OvalShape());
    
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
    }
    
    private Drawable resizeBallImg(Drawable imageball) {
        Bitmap b = ((BitmapDrawable)imageball).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 5, 5, false);
        return new BitmapDrawable(getResources(), bitmapResized);
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
            
           // Bitmap lol = Bitmap.createScaledBitmap(ballDesign,mBoule.RAYON, mBoule.RAYON,true);
            
           // pCanvas.drawBitmap(lol, mBoule.getX(), mBoule.getY() ,mPaint);
            
            pCanvas.drawCircle(mBoule.getX(), mBoule.getY(), Ball.RAYON, mPaint);
            
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
            
            while (keepDrawing) {
                canvas = null;

                try {
                    canvas = mSurfaceHolder.lockCanvas();
                    canvas.drawBitmap(background, 0, 0, null);
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