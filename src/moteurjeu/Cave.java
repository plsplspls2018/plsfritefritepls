package moteurjeu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Cave {

	private List<Integer> nbCoffreNiveau;


	public Cave(int profondeur) {
	    int nbNiveaux;
        if(profondeur == 0)
            nbNiveaux = Utilitaires.RandomInt(9, 12);
        else if(profondeur == 1)
            nbNiveaux = Utilitaires.RandomInt(6, 19);
        else if(profondeur == 2)
            nbNiveaux = Utilitaires.RandomInt(3, 6);
        else
            throw new RuntimeException("profondeur cave doit être entre 1 et 3 et non "+ profondeur);

        nbCoffreNiveau = new ArrayList<>(nbNiveaux);
        Collections.fill(nbCoffreNiveau, 1);

	}
	
	public int getNbNiveaux() {
		return this.nbCoffreNiveau.size();
	}

	public Coffre prendreCoffre(int niveau) {
	    int nbCoffres = nbCoffreNiveau.get(niveau);
		if(nbCoffres > 0) {
		    nbCoffreNiveau.set(niveau, nbCoffres-1);
		    return new Coffre(niveau);
        }
		else
		    return null;
	}

	public void mettreAJour() {
	    int nbNiveaux = getNbNiveaux() - Collections.frequency(nbCoffreNiveau, 0);
        nbCoffreNiveau = new ArrayList<>(nbNiveaux);
        Collections.fill(nbCoffreNiveau, 1);
    }

    //useless
    /*
    public Coffre getCoffre(int profondeurCoffre) {
        return this.coffres.get(profondeurCoffre);
    }
    */

}
