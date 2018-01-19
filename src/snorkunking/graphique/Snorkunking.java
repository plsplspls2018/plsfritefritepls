package snorkunking.graphique;
public class Snorkunking  {
/*

	private GererPartie jeu;
	private SpritesPlongeurs spritesPlongeurs;

	private double largeurBoutons;
	private double hauteurBoutons;
	private int largeurFenetre;
	private int hauteurFenetre;
	private double xNul;
	private double restart;
	private double largeurcaves;
	private double largeurstrate;
	private double hauteurcave1;
	private double hauteurcave3;
	private double hauteurcave2;
	private boolean partieEnCours;

	private Input inputJoueur1;
	private Input inputJoueur2;
	
	
	

    
    public void setGererPartie(GererPartie jjjeu) {
    		this.jeu = jjjeu;
    }
    
	

	
    public Snorkunking() {
    	
    		this.spritesPlongeurs=new SpritesPlongeurs();
		this.largeurBoutons= 200;
		this.hauteurBoutons = 30;
		this.xNul = 0;
		this.restart=-280;
		
		this.largeurFenetre=800;
		this.hauteurFenetre=800;

		
		this.largeurcaves=800;
		this.largeurstrate=800;
		this.hauteurcave1=250;
		this.hauteurcave2=150;
		this.hauteurcave3=100;
	
		this.partieEnCours=true;
		
		
		
	}
    
    public void afficheEtatPartieActuelle() {
	    	this.creeNiveau(0);
	    	this.creeNiveau(1);
	    	this.creeNiveau(2);

	    StdDraw.show();
    }
    
    
    private void creeNiveau(int idCave) {
    		int nbStrates = jeu.getNbNiveauxPour(idCave);
    		double hauteurStrate;
    		double yPremiereStrate;
    		
    		if(idCave==0) {
    			hauteurStrate = this.hauteurcave1 / nbStrates ;
    			yPremiereStrate=235-hauteurStrate/2;
    		
    		} else if(idCave==1) {
    			hauteurStrate = this.hauteurcave2 / nbStrates ;
    			yPremiereStrate= -15-hauteurStrate/2;
    		} else  {
    			hauteurStrate = this.hauteurcave3 / nbStrates ;
    			yPremiereStrate= -165-hauteurStrate/2;
    		}
    		
    		
    		for(int i=0; i<nbStrates;i++) {
    			double yStrate= yPremiereStrate - i*hauteurStrate;
    			List<snorkunking.moteurjeu.Plongeur> plongeursARepresenter = this.jeu.getPlongeurPour(idCave, i );
    			boolean aCoffre = this.jeu.aCoffrePour(idCave, i );
    			this.dessinerStrate(yStrate, hauteurStrate, plongeursARepresenter, aCoffre);
    			
    		}
    	
    }
    
    private void dessinerStrate(double yStrate, double hauteurStrate, List<snorkunking.moteurjeu.Plongeur> plongeursARepresenter, boolean aCoffre) {
    	
		if(plongeursARepresenter.isEmpty()) {
			StdDraw.rectangle(xNul, yStrate,largeurstrate, hauteurStrate/2);
			
		} else if(plongeursARepresenter.size()==1) {
			StdDraw.rectangle(xNul, yStrate,largeurstrate, hauteurStrate/2);
			
			boolean estPlongeur1;
			Plongeur plongeurARepresenter = plongeursARepresenter.get(0);
			
			if(plongeurARepresenter.equals(this.jeu.getPlongeurJoueur1())) {
				estPlongeur1=true;
			}else {
				estPlongeur1=false;
			}
			
			if(estPlongeur1) {
				double yPlongeur1 = yStrate - hauteurStrate/2;
				this.spritesPlongeurs.afficherplongeur1(yPlongeur1);
			}else {
				double yPlongeur2 = yStrate - hauteurStrate/2;
				this.spritesPlongeurs.afficherplongeur2(yPlongeur2);
			}
			
		} else if(plongeursARepresenter.size()==2) {
			StdDraw.rectangle(xNul, yStrate,largeurstrate, hauteurStrate/2);

			double yPlongeur1 = yStrate ;
			double yPlongeur2 = yStrate ;
			this.spritesPlongeurs.afficherplongeur1(yPlongeur1);
			this.spritesPlongeurs.afficherplongeur2(yPlongeur2);
			
		}
		
		if(aCoffre==false) {

			this.creeimage(xNul, yStrate,"image/coffre.png", 40, 20);
		}

    }
	
	public void dispMenu() {
		
		StdDraw.setCanvasSize(this.largeurFenetre, this.hauteurFenetre);
		
		StdDraw.setScale(-300, +300);
 	   	StdDraw.enableDoubleBuffering();
 	 
 	       //StdDraw.pause(20);
 	       

	       StdDraw.clear();
	       StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledRectangle(0, 0, 300, 300);
		this.creeimage(xNul, 110, "image/cave1.png", largeurcaves, hauteurcave1);
		this.creeimage(xNul, -90, "image/cave2.png", largeurcaves, hauteurcave2);
		this.creeimage(xNul, -215, "image/cave3.png", largeurcaves, hauteurcave3);
		this.creerBouton(restart, "restart", null);
		
		
		
		GererPartie jjjeu=new GererPartie();
		this.setGererPartie(jjjeu);

		this.lancerJoueurVSJoueur();

		
		while(this.partieEnCours) {
			this.afficheEtatPartieActuelle();
			
			this.attendreEtJouerProchainTour();
			
		}
		
	}
	
	
	private void attendreEtJouerProchainTour() {
		// TODO Auto-generated method stub
		
		
		StdDraw.pause(8*100);
		
		String prochaineAction;
		boolean estTourJoueur1 = this.jeu.estTourJoueur1();
		
		if(estTourJoueur1) {
			prochaineAction = this.inputJoueur1.prochaineAction();
		}else {
			prochaineAction = this.inputJoueur2.prochaineAction();
		}
		
		this.jeu.executerAction(prochaineAction);
	}


	private void creerBouton(double yBouton, String texte, Object callback) {
		
		
        StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.xNul, yBouton, this.largeurBoutons/2, this.hauteurBoutons/2);

        StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(this.xNul, yBouton, texte);
		
	}
	private void creeimage(double xImage,double yImage,String nomfichier, double largeur, double hauteur) {
	StdDraw.picture(xImage, yImage, nomfichier, largeur, hauteur);
	
	}
	
	
	private void lancerJoueurVSia() {
		// TODO Auto-generated method stub
		EcranJeu jVSia = new EcranJeu("InputIA");
		
		this.inputJoueur1=new InputJoueur(this.jeu, this.jeu.getPlongeurJoueur1());
		this.inputJoueur2=new InputIA(this.jeu, this.jeu.getPlongeurJoueur2());
		
		jVSia.lancer();
		
	}

	private void lancerJoueurVSJoueur() {
		// TODO Auto-generated method stub

		EcranJeu jVSia = new EcranJeu("Joueur");
		

		this.inputJoueur1=new InputJoueur(this.jeu, this.jeu.getPlongeurJoueur1());
		this.inputJoueur2=new InputJoueur(this.jeu, this.jeu.getPlongeurJoueur2());
		
		
		jVSia.lancer();
	}

	private boolean estDansBouton(double yBouton, double x, double y) {
		if(x >= this.xNul - this.largeurBoutons/2 && x <= this.xNul - this.largeurBoutons/2 && 
				y >= yBouton - this.hauteurBoutons/2 && y <= yBouton - this.hauteurBoutons/2 ) {
			return true;
		}else {
			return false;
		}
	}
	
*/
}
