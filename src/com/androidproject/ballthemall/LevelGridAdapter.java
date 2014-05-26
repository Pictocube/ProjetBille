package com.androidproject.ballthemall;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class LevelGridAdapter extends BaseAdapter{
	private ArrayList<String> levelList; 
	private Context cont; // donne acces aux ressources de l'activity
	private LayoutInflater infl; // recupere les informations de la ressource du layout
	Typeface font;
	public static String itemIndex;
	public static String levelID = "";
	
	public LevelGridAdapter(Context c){
		cont = c; // affectation du context de l'activity
		infl = LayoutInflater.from(cont); // charge le fichier de vue qui sera rempli dans le getView
		
		levelList = new ArrayList<String>();
		
		for (int i =1 ; i <= 20 ; i++){
			levelList.add(String.valueOf(i));
		}
		
		font = Typeface.createFromAsset(cont.getAssets(), "28 Days Later.ttf");

		
	}
	
	// retourne le nombre d'objets de la liste
	public int getCount() { 
		return levelList.size();
	}

	// retourne l'element de la liste a la position i
	public Object getItem(int i) { 
		return levelList.get(i);
	}

	// retourne l'item ayant pour identifiant id
	public long getItemId(int id) { 
		return id;
	}
	
	class ViewHolder { 
		Button numberLevel;
	}

	// retourne la view correspondant a un element de la liste
	public View getView(int pos, View convertView, ViewGroup parent) { 
		
		ViewHolder holder;
		
		itemIndex = levelList.get(pos).toString();
		
	    if(convertView == null) { // si la view n'a jamais ete instancie
	        holder = new ViewHolder(); // class d'enregistrement
	        convertView = infl.inflate(R.layout.icon_level_selector, null); // affectation de l'espace
	 
	        holder.numberLevel = (Button)convertView.findViewById(R.id.buttonlevel); 
	        holder.numberLevel.setOnClickListener(onButtonClicListener);
	        
	        convertView.setTag(holder); // enregistre la ligne de la ListView
	    } else {
	        holder = (ViewHolder) convertView.getTag(); // sinon on recupere la ligne de la ListView a la position pos
	    }
	 
	    
	    holder.numberLevel.setText(itemIndex); // renseigne le champ titre
	    holder.numberLevel.setTypeface(font);
	    holder.numberLevel.setTextSize(40);

	    return convertView;
		
	}
	
	
	private View.OnClickListener onButtonClicListener = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(cont, LevelActivity.class);
			i.putExtra("background","bg.jpg");
			cont.startActivity(i);

			Button hodor =  (Button)arg0.findViewById(R.id.buttonlevel);
			levelID = hodor.getText().toString();
		}
		
	};
}
