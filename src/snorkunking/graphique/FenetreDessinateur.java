package snorkunking.graphique;

public class FenetreDessinateur {

    public static final int LARGEUR = 800;
    public static final int HAUTEUR = 800;

    public static void init() {

        StdDraw.setCanvasSize(LARGEUR, HAUTEUR);

        StdDraw.setScale(-300, +300);
        StdDraw.enableDoubleBuffering();


        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLUE);
        //StdDraw.filledRectangle(0, 0, LARGEUR/2, HAUTEUR/2);

    }
}
