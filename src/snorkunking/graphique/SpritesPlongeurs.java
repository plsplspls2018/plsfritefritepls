package snorkunking.graphique;

public class SpritesPlongeurs {
	private double largeurPlongeur, hauteurPlongeur;
	private double xPlongeur1, xPlongeur2;
	public SpritesPlongeurs(){
		this.largeurPlongeur=60;
		this.hauteurPlongeur=30;
		this.xPlongeur1= -150;
		this.xPlongeur2= +150;
	}
	
	public void afficherplongeur1(double yPlongeur) {
		this.creeimage(this.xPlongeur1, yPlongeur,"image/plongeur2.png", largeurPlongeur, hauteurPlongeur);
		
	}
	public void afficherplongeur2(double yPlongeur) {
		this.creeimage(this.xPlongeur2, yPlongeur, "image/plongeur1.png", largeurPlongeur, hauteurPlongeur);
		
	}
	private void creeimage(double xImage,double yImage,String nomfichier, double largeur, double hauteur) {
		StdDraw.picture(xImage, yImage, nomfichier, largeur, hauteur);
}
}
