package moteurjeu;

import java.util.ArrayList;
import java.util.List;

public class Plongeur {
	private Oxygene bouteille;
	private int idCaveActuelle;
	private int profondeurPropreCaveActuelle;
	private boolean estDanslEau;
	private Score scoreCommun;
	private List<Cave> caves;
	
	public Plongeur(Score scoreCommun) {
		this.scoreCommun= scoreCommun;
	}
	
	
	public void initNouveauTour(int capaciteBouteille, Cave cave0, Cave cave1, Cave cave2) {
		this.bouteille = new Oxygene(capaciteBouteille);
		idCaveActuelle=1;
		profondeurPropreCaveActuelle=0;
		this.estDanslEau=false;
		this.caves = new ArrayList<Cave>();
		caves.add(cave0);
		caves.add(cave1);
		caves.add(cave2);
	}
	
	public boolean getEstDanslEau() {
		return this.estDanslEau;
	}
	
	public boolean monter() {
		if (profondeurPropreCaveActuelle>0) {
			profondeurPropreCaveActuelle--;
			return true;
		}
		else if (idCaveActuelle>0) {
			idCaveActuelle--;
			profondeurPropreCaveActuelle=this.caves.get(idCaveActuelle).getNbNiveaux();
			
			return true;
		}
		else if(this.estDanslEau==true){
			this.estDanslEau=false;
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean descendre() {
		if(this.estDanslEau==false) {
			this.estDanslEau=true;
			idCaveActuelle=0;
			profondeurPropreCaveActuelle=0;
			return true;
		}
		if (profondeurPropreCaveActuelle<2) {
		profondeurPropreCaveActuelle++;
		return true;
	}
	else if (idCaveActuelle<2) {
		idCaveActuelle++;
		profondeurPropreCaveActuelle=this.caves.get(idCaveActuelle).getNbNiveaux()-1;
		
		return true;
	}
	else {
		return false;
		}
	}
	
	public boolean recupererCoffre() {
		Cave caveActuelle = this.caves.get(this.idCaveActuelle);
		Coffre coffreDeCeNiveau=caveActuelle.getCoffre(this.profondeurPropreCaveActuelle);
		if (coffreDeCeNiveau.prendreTresors()==true){
			int tresorsPris = coffreDeCeNiveau.getNbTresors();
			this.scoreCommun.compterTresorsPris(this, tresorsPris);
			return true;
		}
		else {
			return false;
		}
	}
	public double oxygenerestant() {
		return bouteille.getPctageRestant();
		}
	public int profondeurActuelle() {
		int profondeur=0;
		for (int i=0;i<this.idCaveActuelle;i++) {
			profondeur= profondeur + caves.get(i).getNbNiveaux();
		}
		profondeur = profondeur + this.profondeurPropreCaveActuelle;
		
		return profondeur;
			
	}
	public boolean assezOxygenePourRemonter() {
		if (bouteille.getOxygeneRestant()>=((profondeurActuelle() )* (scoreCommun.getCoffresPour(this)+1)))  {
			return true;
		}else {
			return false;
		}
	}
	public boolean assezOxygenePourRemonterPlus() {
		if (bouteille.getOxygeneRestant()>=((profondeurActuelle() )* (scoreCommun.getCoffresPour(this)+2)))  {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estACaveProfondeur(int idCave, int profondeurPourCave) {
		if(this.idCaveActuelle == idCave && this.profondeurPropreCaveActuelle == profondeurPourCave) {
			return true;
		}else {
			return false;
		}
	}
}
