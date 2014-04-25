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
                RectF hitBox = mBoule.putXAndY(x, y);

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
                        	/*mBoule.setPosX(block.getRectangle().centerX());
                        	mBoule.setPosY(block.getRectangle().centerY());*/
                        	//mBoule.changeYSpeed();
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
        mBlocks = new ArrayList<WallBloc>();
        /*mBlocks.add(new WallBloc(Type.WALL, 0, 0));
        mBlocks.add(new WallBloc(Type.WALL, 0, 1));
        mBlocks.add(new WallBloc(Type.WALL, 0, 2));
        mBlocks.add(new WallBloc(Type.WALL, 0, 3));
        mBlocks.add(new WallBloc(Type.WALL, 0, 4));
        mBlocks.add(new WallBloc(Type.WALL, 0, 5));
        mBlocks.add(new WallBloc(Type.WALL, 0, 6));
        mBlocks.add(new WallBloc(Type.WALL, 0, 7));
        mBlocks.add(new WallBloc(Type.WALL, 0, 8));
        mBlocks.add(new WallBloc(Type.WALL, 0, 9));
        mBlocks.add(new WallBloc(Type.WALL, 0, 10));
        mBlocks.add(new WallBloc(Type.WALL, 0, 11));
        mBlocks.add(new WallBloc(Type.WALL, 0, 12));
        mBlocks.add(new WallBloc(Type.WALL, 0, 13));
        mBlocks.add(new WallBloc(Type.WALL, 0, 14));
        mBlocks.add(new WallBloc(Type.WALL, 0, 15));
        mBlocks.add(new WallBloc(Type.WALL, 0, 16));
        mBlocks.add(new WallBloc(Type.WALL, 0, 17));
        mBlocks.add(new WallBloc(Type.WALL, 0, 18));
        mBlocks.add(new WallBloc(Type.WALL, 0, 19));

        mBlocks.add(new WallBloc(Type.WALL, 1, 0));
        mBlocks.add(new WallBloc(Type.WALL, 1, 19));

        mBlocks.add(new WallBloc(Type.WALL, 2, 0));
        mBlocks.add(new WallBloc(Type.WALL, 2, 19));

        mBlocks.add(new WallBloc(Type.WALL, 3, 0));
        mBlocks.add(new WallBloc(Type.WALL, 3, 19));*/

       // mBlocks.add(new WallBloc(Type.WALL, 4, 0));
        mBlocks.add(new WallBloc(Type.WALL, 4, 1));
        mBlocks.add(new WallBloc(Type.WALL, 4, 2));
        mBlocks.add(new WallBloc(Type.WALL, 4, 3));
        mBlocks.add(new WallBloc(Type.WALL, 4, 4));
        mBlocks.add(new WallBloc(Type.WALL, 4, 5));
        mBlocks.add(new WallBloc(Type.WALL, 4, 6));
        mBlocks.add(new WallBloc(Type.WALL, 4, 7));
        mBlocks.add(new WallBloc(Type.WALL, 4, 8));
        mBlocks.add(new WallBloc(Type.WALL, 4, 9));
        mBlocks.add(new WallBloc(Type.WALL, 4, 10));
       /* mBlocks.add(new WallBloc(Type.WALL, 4, 19));

        mBlocks.add(new WallBloc(Type.WALL, 5, 0));
        mBlocks.add(new WallBloc(Type.WALL, 5, 19));

        mBlocks.add(new WallBloc(Type.WALL, 6, 0));
        mBlocks.add(new WallBloc(Type.WALL, 6, 19));

        mBlocks.add(new WallBloc(Type.WALL, 7, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 7, 1));
        mBlocks.add(new WallBloc(Type.WALL, 7, 2));
        mBlocks.add(new WallBloc(Type.WALL, 7, 5));
        mBlocks.add(new WallBloc(Type.WALL, 7, 6));
        mBlocks.add(new WallBloc(Type.WALL, 7, 9));
        mBlocks.add(new WallBloc(Type.WALL, 7, 10));
        mBlocks.add(new WallBloc(Type.WALL, 7, 11));
        mBlocks.add(new WallBloc(Type.WALL, 7, 12));
        //mBlocks.add(new WallBloc(Type.WALL, 7, 19));

       // mBlocks.add(new WallBloc(Type.WALL, 8, 0));
        mBlocks.add(new WallBloc(Type.WALL, 8, 5));
        mBlocks.add(new WallBloc(Type.WALL, 8, 9));
       // mBlocks.add(new WallBloc(Type.WALL, 8, 19));

       // mBlocks.add(new WallBloc(Type.WALL, 9, 0));
        mBlocks.add(new WallBloc(Type.WALL, 9, 5));
        mBlocks.add(new WallBloc(Type.WALL, 9, 9));
       /* mBlocks.add(new WallBloc(Type.WALL, 9, 19));

        mBlocks.add(new WallBloc(Type.WALL, 10, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 10, 5));
        mBlocks.add(new WallBloc(Type.WALL, 10, 9));
        /*mBlocks.add(new WallBloc(Type.WALL, 10, 19));

        mBlocks.add(new WallBloc(Type.WALL, 11, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 11, 5));
        mBlocks.add(new WallBloc(Type.WALL, 11, 9));
       /* mBlocks.add(new WallBloc(Type.WALL, 11, 19));

        mBlocks.add(new WallBloc(Type.WALL, 12, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 12, 1));
        mBlocks.add(new WallBloc(Type.WALL, 12, 2));
        mBlocks.add(new WallBloc(Type.WALL, 12, 3));
        mBlocks.add(new WallBloc(Type.WALL, 12, 4));
        mBlocks.add(new WallBloc(Type.WALL, 12, 5));
        mBlocks.add(new WallBloc(Type.WALL, 12, 9));
        mBlocks.add(new WallBloc(Type.WALL, 12, 8));
       /* mBlocks.add(new WallBloc(Type.WALL, 12, 19));

        mBlocks.add(new WallBloc(Type.WALL, 13, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 13, 8));
       /* mBlocks.add(new WallBloc(Type.WALL, 13, 19));

        mBlocks.add(new WallBloc(Type.WALL, 14, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 14, 8));
       /* mBlocks.add(new WallBloc(Type.WALL, 14, 19));

        mBlocks.add(new WallBloc(Type.WALL, 15, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 15, 8));
      /*  mBlocks.add(new WallBloc(Type.WALL, 15, 19));

        mBlocks.add(new WallBloc(Type.WALL, 16, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 16, 4));
        mBlocks.add(new WallBloc(Type.WALL, 16, 5));
        mBlocks.add(new WallBloc(Type.WALL, 16, 6));
        mBlocks.add(new WallBloc(Type.WALL, 16, 7));
        mBlocks.add(new WallBloc(Type.WALL, 16, 8));
        mBlocks.add(new WallBloc(Type.WALL, 16, 9));
       /* mBlocks.add(new WallBloc(Type.WALL, 16, 19));

        mBlocks.add(new WallBloc(Type.WALL, 17, 0));
        mBlocks.add(new WallBloc(Type.WALL, 17, 19));

        mBlocks.add(new WallBloc(Type.WALL, 18, 0));
        mBlocks.add(new WallBloc(Type.WALL, 18, 19));

        mBlocks.add(new WallBloc(Type.WALL, 19, 0));*/
        mBlocks.add(new WallBloc(Type.WALL, 19, 1));
        mBlocks.add(new WallBloc(Type.WALL, 19, 2));
        mBlocks.add(new WallBloc(Type.WALL, 19, 3));
        mBlocks.add(new WallBloc(Type.WALL, 19, 4));
        mBlocks.add(new WallBloc(Type.WALL, 19, 5));
        mBlocks.add(new WallBloc(Type.WALL, 19, 6));
        mBlocks.add(new WallBloc(Type.WALL, 19, 7));
        mBlocks.add(new WallBloc(Type.WALL, 19, 8));
        mBlocks.add(new WallBloc(Type.WALL, 19, 9));
        mBlocks.add(new WallBloc(Type.WALL, 19, 10));
        mBlocks.add(new WallBloc(Type.WALL, 19, 11));
        mBlocks.add(new WallBloc(Type.WALL, 19, 12));
        mBlocks.add(new WallBloc(Type.WALL, 19, 13));
        mBlocks.add(new WallBloc(Type.WALL, 19, 14));
        mBlocks.add(new WallBloc(Type.WALL, 19, 15));
        mBlocks.add(new WallBloc(Type.WALL, 19, 16));
        mBlocks.add(new WallBloc(Type.WALL, 19, 17));
        mBlocks.add(new WallBloc(Type.WALL, 19, 18));
       // mBlocks.add(new WallBloc(Type.WALL, 19, 19));

        WallBloc b = new WallBloc(Type.START, 2, 2);
        mBoule.setInitialRectangle(new RectF(b.getRectangle()));
        mBlocks.add(b);

        mBlocks.add(new WallBloc(Type.END, 8, 11));

        return mBlocks;
    }

}