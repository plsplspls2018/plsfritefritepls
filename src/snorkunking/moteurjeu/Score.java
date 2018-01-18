package snorkunking.moteurjeu;

import java.util.HashMap;

public class Score {

	private HashMap<Plongeur, Integer> scorePlongeursTotal;
	private HashMap<Plongeur, Integer> scorePlongeursTourActuel;
	private HashMap<Plongeur, Integer> nombreCoffreFerme;
	public Score() {
		scorePlongeursTotal = new HashMap<Plongeur, Integer>();
		nombreCoffreFerme = new HashMap<Plongeur,Integer>();
	}
	
	public void initNouveauTour() {
		for(Plongeur plongeur : scorePlongeursTotal.keySet()) {
			scorePlongeursTourActuel.put(plongeur,0);
			this.nombreCoffreFerme.put(plongeur, 0);
		}
		
	}
	
	public void ajouterPlongeur(Plongeur p) {
		scorePlongeursTotal.put(p, 0);
	}

	public void compterTresorsPris(Plongeur plongeur, int tresorsPris) {
		
		int ancienScore = this.scorePlongeursTourActuel.get(plongeur);
		int nouveauScore = ancienScore + tresorsPris;
		this.scorePlongeursTourActuel.put(plongeur, nouveauScore);
		
		int ancienNbCoffres = this.nombreCoffreFerme.get(plongeur);
		int nouveauNbCoffres = ancienNbCoffres + 1 ;
		this.nombreCoffreFerme.put(plongeur,nouveauNbCoffres);
		
	}
	
	public int getScorePour(Plongeur p) {
		return this.scorePlongeursTourActuel.get(p);
	}
	public int getCoffresPour( Plongeur p) {
		return this.nombreCoffreFerme.get(p);
	}

}
