package snorkunking.moteurjeu;

import snorkunking.input.Input;

import java.util.ArrayList;
import java.util.List;

public class GererPartie {

	GererTour tour1;
	GererTour tour2;
	GererTour tour3;
	GererTour tourActuel;
	
	Score score;
	

	private List<Plongeur> plongeursDeCettePartie;

	private Plongeur plongeurJoueur1;
	private Plongeur plongeurJoueur2;
	private Plongeur plongeurDontCEstLeTour;
	
	
	public GererPartie() {
		
		this.score=new Score();
		
		this.plongeursDeCettePartie= new ArrayList<Plongeur>();
		this.plongeursDeCettePartie.add(new Plongeur(score));
		this.plongeursDeCettePartie.add(new Plongeur(score));
		
		tour1=new GererTour();
		tourActuel=tour1;
		tour1.setPlongeurs(this.plongeursDeCettePartie);
		List<Cave> caves=new ArrayList<Cave>();
		caves.add(new Cave(0));
		caves.add(new Cave(1));
		caves.add(new Cave(2));
		tour1.setCaves(caves);

		this.plongeurJoueur1=this.plongeursDeCettePartie.get(0);
		this.plongeurJoueur2=this.plongeursDeCettePartie.get(1);
		this.plongeurDontCEstLeTour=this.plongeurJoueur1;
		
	}
		
	
	
	public List<Plongeur> getPlongeurPour(int idCave, int profondeurPourCave){
		
		return tourActuel.getPlongeurPour(idCave, profondeurPourCave);
	}
	
	public int getNbNiveauxPour(int idCave) {
		return tourActuel.getNbNiveauxPour(idCave);
	}

	public boolean aCoffrePour(int idCave, int profondeurPourCave) {
		this.tourActuel.getACoffrePour(idCave, profondeurPourCave);
		return false;
	}

	public Plongeur getPlongeurJoueur1() {
		return plongeurJoueur1;
	}

	public Plongeur getPlongeurJoueur2() {
		return plongeurJoueur2;
	}

	
	public void executerAction(String nomAction) {
		
		Plongeur bonPlongeur = this.plongeurDontCEstLeTour;
		
		if (nomAction== Input.actionMonter) {
			bonPlongeur.monter();
		}else if (nomAction==Input.actionDescendre) {
			bonPlongeur.descendre();
		}	else	 {
			bonPlongeur.recupererCoffre();
		}
		
		if(this.estTourJoueur1()) {
			this.plongeurDontCEstLeTour=this.plongeurJoueur2;
		}else {
			this.plongeurDontCEstLeTour=this.plongeurJoueur1;
		}
		
	}
	
	public boolean estTourJoueur1() {
		if(this.plongeurDontCEstLeTour.equals(this.plongeurJoueur1)) {
			return true;
		}else {
			return false;
		}
		
	}

	
}
