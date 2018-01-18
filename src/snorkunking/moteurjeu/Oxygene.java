package snorkunking.moteurjeu;

public class Oxygene {
	
	private int nbUniteOxygene;
	private int nbUniteOxygeneMax;
	public Oxygene (int capaciteMax) {
		this.nbUniteOxygeneMax = this.nbUniteOxygene = capaciteMax;
	}
	
	public double getPctageRestant() {
		return nbUniteOxygene / nbUniteOxygeneMax ;
	}
	
	public void consommer(int nombre) {
        nbUniteOxygene -= nombre;
        if(nbUniteOxygene < 0)
            nbUniteOxygene = 0;
	}
	public int getRestant() {
		return nbUniteOxygene;
	}
 
}
