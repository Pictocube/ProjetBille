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
import android.widget.ImageButton;
import android.widget.TextView;


public class WorldScrollAdapter extends BaseAdapter {

	private ArrayList<String> worldList; 
	private int listRessource[] = {R.drawable.cadrew1,R.drawable.cadrew2,R.drawable.cadrew3,R.drawable.cadrew4};
	private Context cont; // donne acces aux ressources de l'activity
	private LayoutInflater infl; // recupere les informations de la ressource du layout
	protected static String WolrdID = "";
	Typeface font;
	ViewHolder holder;
	 
	public WorldScrollAdapter(Context c){
		cont = c; // affectation du context de l'activity
		worldList  = new ArrayList<String>();  // liste des donnees
		infl = LayoutInflater.from(cont); // charge le fichier de vue qui sera rempli dans le getView
		
		worldList.add("Kill' Em All"); 
		worldList.add("Ghost Busters");
		worldList.add("MOdAFuKA");
		worldList.add("Toxicity");
		
		font = Typeface.createFromAsset(cont.getAssets(), "28 Days Later.ttf");


	}
	
	@Override
	// retourne le nombre d'objets de la liste
	public int getCount() { 
		return worldList.size();
	}

	@Override
	// retourne l'element de la liste a la position i
	public Object getItem(int i) { 
		return worldList.get(i);
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
		 
	    if(convertView == null) { // si la view n'a jamais ete instancie
	        holder = new ViewHolder(); // class d'enregistrement
	        convertView = infl.inflate(R.layout.icon_world_selector, null); // affectation de l'espace
	 
	        holder.titleWorld = (TextView)convertView.findViewById(R.id.titleWorldAdapteur); // declaration du TextView date
	        holder.iconWorld = (ImageButton)convertView.findViewById(R.id.imageWorldAdapter); // declaration du TextView daubed

	        
	        convertView.setTag(holder); // enregistre la ligne de la ListView
	    } else {
	        holder = (ViewHolder) convertView.getTag(); // sinon on recupere la ligne de la ListView a la position pos
	    }
	 
	    
	    holder.titleWorld.setText(worldList.get(pos).toString()); // renseigne le champ titre
	    holder.titleWorld.setTypeface(font);
	    holder.iconWorld.setImageResource(listRessource[pos]);
	    holder.titleWorld.setOnClickListener(onButtonClicListener);
	    
	    if(pos == 0){
	    	
		    holder.titleWorld.setPadding(160, 5, 100, 0);
		    holder.iconWorld.setPadding(160, 5, 100, 0);
		    
	    } else if (pos == worldList.size()){
	    	
		    holder.titleWorld.setPadding(100, 5, 100, 0);
		    holder.iconWorld.setPadding(100, 5, 100, 0);
		    
	    } else {
	    	
		    holder.titleWorld.setPadding(100, 5, 170, 0);
		    holder.iconWorld.setPadding(100, 5, 170, 0);
	    }
	    


	    
	    return convertView;
		
	}
	
	private View.OnClickListener onButtonClicListener = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(cont,LevelSelectorActivity.class);
			cont.startActivity(i);

			TextView currentlvl =  (TextView)arg0.findViewById(R.id.titleWorldAdapteur);
			WolrdID = currentlvl.getText().toString();

		}
		
	};
}
