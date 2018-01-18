package snorkunking.graphique;

public class MenuAcceuil  {
	
	private double largeurBoutons;
	private double hauteurBoutons;
	private double xBoutons;
	private double yJIA;
	private double yJJ;
	private double yQ;
	


    public static void main(String[] args) {
    		MenuAcceuil ma = new MenuAcceuil();
    		ma.dispMenu();
    		
        }
    
    
	

	
    public MenuAcceuil() {
		this.largeurBoutons= 200;
		this.hauteurBoutons = 30;
		this.xBoutons = 0;
		this.yJIA=50;
		this.yJJ=0;
		this.yQ=-50;
		
	}
	
	public void dispMenu() {
		
		StdDraw.setScale(-300, +300);
 	   	StdDraw.enableDoubleBuffering();
 	 
 	       //StdDraw.pause(20);
 	       

	       StdDraw.clear();
	       StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledRectangle(0, 0, 300, 300);
		this.creerBouton(yJIA, "Joueur VS InputIA", null);
		this.creerBouton(yJJ, "Joueur VS Joueur", null);
		this.creerBouton(yQ, "Quitter", null);
		
		
	       StdDraw.show();
	}

	private void creerBouton(double yBouton, String texte, Object callback) {
		
		
        StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.xBoutons, yBouton, this.largeurBoutons/2, this.hauteurBoutons/2);

        StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(this.xBoutons, yBouton, texte);
		
		
	}



	
	private void lancerJoueurVSia() {
		// TODO Auto-generated method stub
		EcranJeu jVSia = new EcranJeu("InputIA");
		jVSia.lancer();
		
	}

	private void lancerJoueurVSJoueur() {
		// TODO Auto-generated method stub

		EcranJeu jVSia = new EcranJeu("Joueur");
		jVSia.lancer();
	}

	private boolean estDansBouton(double yBouton, double x, double y) {
		if(x >= this.xBoutons - this.largeurBoutons/2 && x <= this.xBoutons - this.largeurBoutons/2 && 
				y >= yBouton - this.hauteurBoutons/2 && y <= yBouton - this.hauteurBoutons/2 ) {
			return true;
		}else {
			return false;
		}
	}


	
	
}
