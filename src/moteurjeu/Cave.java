package moteurjeu;
import java.util.ArrayList;
import java.util.List;
public class Cave {
	
	private int nbNiveau;
	private int minTresor;
	private int maxTresor;
	private int minNv;
	private int maxNv;
	private int idCave;
	private List<Coffre> coffres;
	public Cave (int idCave) {
	
		this.idCave=idCave;
		if (idCave==0){
		minNv=9;
		maxNv=12	;
		minTresor=1;
		maxTresor=3;
				
		}
		else if (idCave==1) {
			minNv=6;
			maxNv=9;
			minTresor=5;
			maxTresor=8;
			
		}
	
		else {
			minNv=3;
			maxNv=6;
			minTresor=9;
			maxTresor=12;
		}
			
	
			
		nbNiveau=minNv + (int)(Math.random() * ((maxNv - minNv) + 1));

		System.out.println("instanciateur");
		System.out.println(this.idCave);
		System.out.println(nbNiveau);
		
		
		coffres= new ArrayList<Coffre>(nbNiveau);
		for (int i=0;i<nbNiveau;i++) {

			coffres.add(new Coffre(minTresor, maxTresor, idCave));
		}

	}
	
	public int getNbNiveaux() {

		System.out.println("geteur");
		System.out.println(this.idCave);
		System.out.println(nbNiveau);
		return this.nbNiveau;
		
	}
	
	public Coffre getCoffre(int profondeurCoffre) {
		return this.coffres.get(profondeurCoffre);
	}

	public boolean aCoffre(int profondeurPourCave) {
		// TODO Auto-generated method stub
		if (this.coffres.get(profondeurPourCave).estTresorPris()==true){
			return false;
		}
		 else {
			return true;
		}
	}
	}
