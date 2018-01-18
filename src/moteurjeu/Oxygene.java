package moteurjeu;

public class Oxygene {
	
	private int nbUniteOxygene;
	private int nbUniteOxygeneMax;
	public Oxygene (int capaciteCave) {
		nbUniteOxygeneMax=2*capaciteCave;
		
		
	}
	
	public double getPctageRestant() {
		return nbUniteOxygene / nbUniteOxygeneMax ;
	}
	
	public void consommerOxygene() {
		nbUniteOxygene --;
	}
	public int getOxygeneRestant() {
		return nbUniteOxygene;
	}
 
}
