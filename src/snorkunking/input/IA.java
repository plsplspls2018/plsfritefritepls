package snorkunking.input;

import snorkunking.moteurjeu.Coffre;
import snorkunking.moteurjeu.GererPartie;
import snorkunking.moteurjeu.Plongeur;
import snorkunking.moteurjeu.Score;

public class IA extends Input{
	
	private Score score;
	private Coffre coffre ;
	
	public IA(GererPartie jeu, Plongeur p) {
		super(jeu, p);
	}
	
	public double evaluerGainMonter() {
		return 0;
	
	}
	public double evaluerGainDescendre() {

		if(plongeur.assezOxygenePourRemonter()==false) {
			return -1;
		}
		else {
			return 1;
		}
		
		
		
		
		
	}
	public double evaluerGainRecuperer() {
		

		if(plongeur.assezOxygenePourRemonter()==false) {
			return -1;
		}
		else if(plongeur.assezOxygenePourRemonterPlus()==true)
			return score.getCoffresPour(plongeur)*coffre.getIdCaveCoffre();
		else {
		
			return 0;
		}
		
	}

	@Override
	public String prochaineAction() {
		
		double monter = this.evaluerGainMonter();
		double descendre = this.evaluerGainDescendre();
		double recuperer = this.evaluerGainRecuperer();

		if(descendre >= monter && descendre >= recuperer) {
			return this.actionDescendre;
		}
		if(monter >= descendre && monter >= recuperer) {
			return this.actionMonter;
		}
		if(recuperer >= monter && recuperer >= descendre) {
			return this.actionMonter;
		}
		
		return this.actionMonter;
	}
	

}
