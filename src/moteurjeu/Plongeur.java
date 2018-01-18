package moteurjeu;

import java.util.ArrayList;
import java.util.List;

public class Plongeur {

    private Oxygene bouteille;
    private int idCaveActuelle;
    private int profondeurPropreCaveActuelle;
    private Score scoreCommun;
    private List<Cave> caves;

    private final String nom;
    private final Partie partie;
    private List<Coffre> coffresSurSoi = new ArrayList<>();
    private int nombreTresors = 0;
    private int niveauActuel = 0;
    private int profondeurActuelle = -1;

    public Plongeur(Partie partie, String nom) {
        this.partie = partie;
        this.nom = nom;
    }


    public boolean EstDansLEau() {
        return profondeurActuelle > -1;
    }


    /** Chaque action retourne false si son execution est impossible et n'as pas ete faite**/



    public boolean monter() {
        if(EstDansLEau())
            return false;

        //monte d'une cave
        if(niveauActuel == 0) {
            profondeurActuelle--;
            niveauActuel = 0;
        } else {
            niveauActuel++;
        }

        partie.getPhase().consomerOxygene(1+coffresSurSoi.size());

        return true;
    }

    public boolean descendre() {
        if(partie.getCaves().size() == profondeurActuelle-1)
            return false;

        //descend d'une cave
        if(EstDansLEau() || getCave().getNbNiveaux() == niveauActuel-1) {
            profondeurActuelle++;
            niveauActuel = 0;
        } else {
            niveauActuel++;
        }

        partie.getPhase().consomerOxygene(1+coffresSurSoi.size());

        return true;
    }



    public boolean recupererCoffre() {
        Cave caveActuelle = this.caves.get(this.idCaveActuelle);
        Coffre coffreDeCeNiveau = caveActuelle.getCoffre(this.profondeurPropreCaveActuelle);
        if (coffreDeCeNiveau.prendreTresors() == true) {
            int tresorsPris = coffreDeCeNiveau.getNbTresors();
            this.scoreCommun.compterTresorsPris(this, tresorsPris);
            return true;
        } else {
            return false;
        }
    }

    /**Attention, ne marche que si on est dans l'eau => il faut toujours tester avant*/
    private Cave getCave() {
        return partie.getCaves().get(profondeurActuelle);
    }





	/*
	public int profondeurActuelle() {
		int profondeur=0;
		for (int i=0;i<this.idCaveActuelle;i++) {
			profondeur= profondeur + caves.get(i).getNbNiveaux();
		}
		profondeur = profondeur + this.profondeurPropreCaveActuelle;
		
		return profondeur;
			
	}
	public boolean assezOxygenePourRemonter() {
		if (bouteille.getRestant()>=((profondeurActuelle() )* (scoreCommun.getCoffresPour(this)+1)))  {
			return true;
		}else {
			return false;
		}
	}
	public boolean assezOxygenePourRemonterPlus() {
		if (bouteille.getRestant()>=((profondeurActuelle() )* (scoreCommun.getCoffresPour(this)+2)))  {
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
	*/
}
