package com.androidproject.ballthemall;

import java.util.ArrayList;
import java.util.List;

import com.androidproject.ballthemall.WallBloc.Type;

import android.app.Service;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class PhysicEngin {
    private Ball mBoule = null;
    public Ball getBoule() {
        return mBoule;
    }

    public void setBoule(Ball pBoule) {
        this.mBoule = pBoule;
    }

    // Le labyrinthe
    private List<WallBloc> mBlocks = null;

    private LevelActivity mActivity = null;

    private SensorManager mManager = null;
    private Sensor mAccelerometre = null;

    SensorEventListener mSensorEventListener = new SensorEventListener() {

		@Override
        public void onSensorChanged(SensorEvent pEvent) {
            float x = pEvent.values[0];
            float y = pEvent.values[1];
 
            if(mBoule != null) {
                // On met à jour les coordonnées de la boule
                RectF hitBox = mBoule.putXAndY(x, y,mBoule.getWidth(),0,mBoule.getHeight(),0,false,false);

                // Pour tous les blocs du labyrinthe
                for(WallBloc block : mBlocks) {
                    // On crée un nouveau rectangle pour ne pas modifier celui du bloc
                    RectF inter = new RectF(block.getRectangle());
                    if(inter.intersect(hitBox)) {
                        // On agit différement en fonction du type de bloc
                        switch(block.getType()) {
                        case HOLE:
                            mActivity.showDialog(LevelActivity.DEFEAT_DIALOG);
                            break;

                        case WALL:
                        	if (mBoule.getY() == inter.centerY()) {
                        		mBoule.putXAndY(x, y,inter.left , inter.right,inter.top,inter.bottom,true,true);
                        	} 
                        	
                        	if(mBoule.getX() == inter.centerX()) {
                        		mBoule.putXAndY(x, y,inter.left , inter.right,inter.top,inter.bottom,true,false);
                        	} 
                        	
                        	 
                        	 
                        	break;
                        case START:
                            break;

                        case END:
                            mActivity.showDialog(LevelActivity.VICTORY_DIALOG);
                            break;
                        }
                        break;
                    }
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor pSensor, int pAccuracy) {

        }
    };

    public PhysicEngin(LevelActivity pView) {
        mActivity = pView;
        mManager = (SensorManager) mActivity.getBaseContext().getSystemService(Service.SENSOR_SERVICE);
        mAccelerometre = mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    // Remet à zéro l'emplacement de la boule
    public void reset() {
        mBoule.reset();
    }

    // Arrête le capteur
    public void stop() {
        mManager.unregisterListener(mSensorEventListener, mAccelerometre);
    }

    // Redémarre le capteur
    public void resume() {
        mManager.registerListener(mSensorEventListener, mAccelerometre, SensorManager.SENSOR_DELAY_GAME);
    }

    // Construit le labyrinthe
    public List<WallBloc> buildLabyrinthe() {
        
        mBlocks = LabyrintheBuilder.getLabyrinthe();
    	
       /* mBlocks = new ArrayList<WallBloc>();
        mBlocks.add(new WallBloc(Type.WALL, 5, 5,5,1));
        mBlocks.add(new WallBloc(Type.WALL, 5, 6,1,5));
        mBlocks.add(new WallBloc(Type.WALL, 6, 10,5,1));
        mBlocks.add(new WallBloc(Type.WALL, 10, 5,1,5));*/
    	
        WallBloc b = new WallBloc(Type.START, 2, 2,1,1);
        mBoule.setInitialRectangle(new RectF(b.getRectangle()));
        mBlocks.add(b);

       // mBlocks.add(new WallBloc(Type.END, 8, 11,1,1));

        return mBlocks;
    }

}