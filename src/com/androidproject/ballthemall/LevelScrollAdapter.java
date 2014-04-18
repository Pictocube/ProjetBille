package com.androidproject.ballthemall;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;


public class LevelScrollAdapter extends BaseAdapter {

	private ArrayList<String> levelList; 
	private int listRessource[] = {R.drawable.cadreword1,R.drawable.cadreword2,R.drawable.cadreword3,R.drawable.cadreword4};
	private Context cont; // donne acces aux ressources de l'activity
	private LayoutInflater infl; // recupere les informations de la ressource du layout
	int a;
	
	public LevelScrollAdapter(Context c){
		cont = c; // affectation du context de l'activity
		levelList  = new ArrayList<String>();  // liste des donnees
		infl = LayoutInflater.from(cont); // charge le fichier de vue qui sera rempli dans le getView
		
		levelList.add("WOWOWOW");
		levelList.add("MOthaFUkA");
		levelList.add("IONION");
		levelList.add("Prout ");
		
		a = R.drawable.cadreword1;
		/*listRessource[0] = R.drawable.cadreword1;
		listRessource[1] = R.drawable.cadreword2;
		listRessource[2] = R.drawable.cadreword3;
		listRessource[3] = R.drawable.cadreword4;*/

	}
	
	@Override
	// retourne le nombre d'objets de la liste
	public int getCount() { 
		return levelList.size();
	}

	@Override
	// retourne l'element de la liste a la position i
	public Object getItem(int i) { 
		return levelList.get(i);
	}

	@Override
	// retourne l'item ayant pour identifiant id
	public long getItemId(int id) { 
		return id;
	}
	
	class ViewHolder { 
		TextView titleWorld;
		ImageButton iconWorld;
	}

	@Override
	// retourne la view correspondant a un element de la liste
	public View getView(int pos, View convertView, ViewGroup parent) { 
		
		ViewHolder holder;
		 
	    if(convertView == null) { // si la view n'a jamais ete instancie
	        holder = new ViewHolder(); // class d'enregistrement
	        convertView = infl.inflate(R.layout.icon_level_selector, null); // affectation de l'espace
	 
	        holder.titleWorld = (TextView)convertView.findViewById(R.id.titleWorldAdapteur); // declaration du TextView date
	        holder.iconWorld = (ImageButton)convertView.findViewById(R.id.imageWorldAdapter); // declaration du TextView daubed

	        
	        convertView.setTag(holder); // enregistre la ligne de la ListView
	    } else {
	        holder = (ViewHolder) convertView.getTag(); // sinon on recupere la ligne de la ListView a la position pos
	    }
	 
	    
	    holder.titleWorld.setText(levelList.get(pos).toString()); // renseigne le champ date
	    holder.iconWorld.setImageResource(listRessource[pos]);

	    
	    return convertView;
		
	}
}
