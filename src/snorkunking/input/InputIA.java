package snorkunking.input;


import snorkunking.moteurjeu.Cave;
import snorkunking.moteurjeu.Partie;
import snorkunking.moteurjeu.Plongeur;

public class InputIA extends Input{

	private Plongeur soiMeme;
	private Partie partie;


	@Override
	public String prochaineAction(Partie partie, Plongeur soiMeme) {
		this.soiMeme = soiMeme;
		this.partie = partie;
		int oxygeneRestant = partie.getPhase().getOxygeneRestant();
		if(!soiMeme.estDansLEau()) {
		    if(oxygeneRestant <=3)
		        return Input.actionRecuperer;
		    return Input.actionDescendre;
        }

        Cave caveActuelle = partie.getCaves().get(soiMeme.getProfondeur());

        int totalMontee = 0;
        for(Plongeur plongeur : partie.getPlongeurs())
            totalMontee += getTotalNiveaux(plongeur)*(1+plongeur.getNbCoffresSurSoi());

        if( totalMontee >= oxygeneRestant )
            return Input.actionMonter;

		if(caveActuelle.getNbCoffres(soiMeme.getNiveau()) >= 1)
		    return Input.actionRecuperer;

		return Input.actionDescendre;
	}

    private int getTotalNiveaux(Plongeur plongeur) {
        int totalNiveaux= 0;
        for(int profondeur = 0; profondeur <= plongeur.getProfondeur(); profondeur++) {
            totalNiveaux += partie.getCaves().get(profondeur).getNbNiveaux();
        }
        return totalNiveaux + plongeur.getNiveau();
    }

}
