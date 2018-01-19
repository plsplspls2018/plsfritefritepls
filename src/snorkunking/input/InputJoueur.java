package snorkunking.input;


import snorkunking.graphique.StdDraw;
import snorkunking.moteurjeu.Partie;

public class InputJoueur extends Input {
	
	public final char TOUCHE_MONTER = 'z';
	public final char TOUCHE_DESCENDRE = 's';
	public final char TOUCHE_RECUPERER = ' ';

	public InputJoueur() {}

	
	@Override
	public String prochaineAction(Partie partie) {

	    while(true) {
            while(!StdDraw.hasNextKeyTyped()) {
                StdDraw.pause(20); //CHECK
            }
            char touchePressee = StdDraw.nextKeyTyped();

            if(touchePressee==TOUCHE_MONTER)
                return Input.actionMonter;
            if(touchePressee==TOUCHE_DESCENDRE)
                return Input.actionDescendre;
            if(touchePressee==TOUCHE_RECUPERER)
                return Input.actionRecuperer;
        }
	}


	

}
