package snorkunking.graphique;

import snorkunking.moteurjeu.Plongeur;

public class PlongeurDessinateur {


    private static final int PLONGEUR_LARGEUR = 60;
    private static final int PLONGEUR_HAUTEUR = 30;


    public static void dessinerSprite(Plongeur plongeur) {
        double y = 0;
        if(plongeur.estDansLEau()){
            int profondeur = plongeur.getProfondeur();
            y = CaveDessinateur.YCave(profondeur) + CaveDessinateur.HauteurCave(profondeur)/2 - CaveDessinateur.HauteurNiveau(profondeur)/2;
            y -= CaveDessinateur.HauteurNiveau(profondeur)*plongeur.getNiveau();
        } else {
            y += CaveDessinateur.YCave(0) + PLONGEUR_HAUTEUR/2 + CaveDessinateur.HauteurCave(0)/2;
        }

        int x;
        if (plongeur.getNom().equals("plongeur1"))
            x = 150;
        else
            x = -150;

        StdDraw.picture(x, y, "image/"+plongeur.getNom() + ".png", PLONGEUR_LARGEUR, PLONGEUR_HAUTEUR);
        StdDraw.text(x, 270, "Score "+plongeur.getNom()+": "+plongeur.getNombreTresors());
        StdDraw.text(x, 280, "Nb tresors "+plongeur.getNom()+": "+plongeur.getNbCoffresSurSoi());
        if(plongeur.getNom().equals(PartieDessinateur.plongeurActuel.getNom()))
            StdDraw.text(x, 290, "A Votre Tour!");
    }

}
