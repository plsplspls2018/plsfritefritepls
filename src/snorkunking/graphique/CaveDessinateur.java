package snorkunking.graphique;

public class CaveDessinateur {


    public static double HauteurCave(int profondeur) {
        if(profondeur == 0)
            return 250;
        if(profondeur == 1)
            return 150;
        if(profondeur == 2)
            return 100;

        throw new RuntimeException("profondeur invalide");
    }

    public static double YCave(int profondeur) {
        if(profondeur == 0)
            return 110;
        if(profondeur == 1)
            return YCave(0) - HauteurCave(0)/2 - HauteurCave(1)/2;
        if(profondeur == 2)
            return YCave(1) - HauteurCave(1)/2 - HauteurCave(2)/2;

        throw new RuntimeException("profondeur invalide");
    }

    public static double HauteurNiveau(int profondeur) {
        return  HauteurCave(profondeur)/PartieDessinateur.partieEnCours.getCaves().get(profondeur).getNbNiveaux();
    }


    public static void dessinerSprite(int profondeur) {
        StdDraw.picture(0,YCave(profondeur), "image/cave"+(profondeur+1)+".png", FenetreDessinateur.LARGEUR, HauteurCave(profondeur));
    }
}
