package com.androidproject.ballthemall;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class LevelActivity extends Activity {
    // Identifiant de la boîte de dialogue de victoire
    public static final int VICTORY_DIALOG = 0;
    // Identifiant de la boîte de dialogue de défaite
    public static final int DEFEAT_DIALOG = 1;

    // Le moteur graphique du jeu
    private GraphicEngin mView = null;
    
    // Le moteur physique du jeu
    private PhysicEngin mEngine = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new GraphicEngin(this);
        //setContentView(R.layout.activity_level);
        //mView.setBackgroundResource(R.drawable.background);
        setContentView(mView);
        
        //mView = (GraphicEngin) findViewById(R.id.graphicenginlevel);
        
        mEngine = new PhysicEngin(this);

        Ball b = new Ball();
        mView.setBoule(b);
        mEngine.setBoule(b);

        List<WallBloc> mList = mEngine.buildLabyrinthe();
        mView.setBlocks(mList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEngine.resume();
    } 

    @Override
    protected void onPause() {
        super.onStop();
        mEngine.stop();
    }

    @Override
    public Dialog onCreateDialog (int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch(id) {
        case VICTORY_DIALOG:
            builder.setCancelable(false)
            .setMessage("Bravo, vous avez gagné !")
            .setTitle("GG bro ! tu vois quand tu veux !")
            .setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // L'utilisateur peut recommencer s'il le veut
                    mEngine.reset();
                    mEngine.resume();
                }
            });
            break;

        case DEFEAT_DIALOG:
            builder.setCancelable(false)
            .setMessage("La Terre a été détruite à cause de vos erreurs.")
            .setTitle("Bah bravo !")
            .setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mEngine.reset();
                    mEngine.resume();
                }
            });
        }
        return builder.create();
    }

    @Override
    public void onPrepareDialog (int id, Dialog box) {
        // A chaque fois qu'une boîte de dialogue est lancée, on arrête le moteur physique
        mEngine.stop();
    }
    
    @Override
	public void onBackPressed() {
	    this.finish();
	}
}
