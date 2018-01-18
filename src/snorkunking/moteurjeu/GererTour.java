package snorkunking.moteurjeu;

import java.util.ArrayList;
import java.util.List;

public class GererTour {

	private List<Plongeur> plongeursDeCettePartie;
	private List<Cave> caves;
	
	public List<Plongeur> getPlongeurPour(int idCave, int profondeurPourCave){
		List<Plongeur> pp = new ArrayList<Plongeur>();
		
		for(Plongeur p : this.plongeursDeCettePartie) {
			if(p.estACaveProfondeur(idCave, profondeurPourCave)) {
				pp.add(p);
			}
		}
		
		return pp;
	}

	public int getNbNiveauxPour(int idCave) {
		return caves.get(idCave).getNbNiveaux();
	}

	public void setPlongeurs(List<Plongeur> plongeursDeCettePartie2) {
		// TODO Auto-generated method stub
		this.plongeursDeCettePartie=plongeursDeCettePartie2;
		
	}
	public void setCaves(List<Cave> caves) {
		this.caves = caves;
	}

	public void getACoffrePour(int idCave, int profondeurPourCave) {
		// TODO Auto-generated method stub
		this.caves.get(idCave).aCoffre(profondeurPourCave);
	}
	
	
}
