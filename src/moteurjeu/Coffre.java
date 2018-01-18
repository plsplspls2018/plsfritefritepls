package moteurjeu;

public class Coffre {
	private int nbTresors;
	private boolean tresorsPris;
	private int idCaveCoffre;
	
	public Coffre(int minTresor, int maxTresor, int idCaveCoffre){
		this.tresorsPris=false;
		this.idCaveCoffre=idCaveCoffre;
		nbTresors=minTresor + (int)(Math.random() * ((maxTresor - minTresor) + 1));
	}
	
	public int getNbTresors()
	{
		return this.nbTresors;
	}
	
	public boolean prendreTresors() {
		if (this.tresorsPris=false){
			tresorsPris=true;
			return true;
		}
		else {
			tresorsPris=false;
			return false;
		}
	}
	
	public int getIdCaveCoffre() {
		return this.idCaveCoffre;
	}
	public boolean estTresorPris() {
		return this.tresorsPris;
	}
}
