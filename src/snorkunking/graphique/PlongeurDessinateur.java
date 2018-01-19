package snorkunking.graphique;

import snorkunking.moteurjeu.Plongeur;

public class PlongeurDessinateur {


    private static final int PLONGEUR_LARGEUR = 60;
    private static final int PLONGEUR_HAUTEUR = 30;


    public static void dessinerSprite(Plongeur plongeur) {
        double y = 0;
        if(plongeur.estDansLEau()){
            for (int profondeur = 0; profondeur < plongeur.getProfondeur(); profondeur++)
                y += CaveDessinateur.HauteurCave(profondeur);
            y += CaveDessinateur.HauteurNiveau(plongeur.getProfondeur());
        } else {
            y += CaveDessinateur.YCave(0) + PLONGEUR_HAUTEUR/2 + CaveDessinateur.YCave(0)/2;
        }

        int x;
        if (plongeur.getNom().equals("plongeur1"))
            x = 150;
        else
            x = -150;

        StdDraw.picture(x, y, "image/"+plongeur.getNom() + ".png", PLONGEUR_LARGEUR, PLONGEUR_HAUTEUR);
        StdDraw.text(x, 250, "Score "+plongeur.getNom()+": "+plongeur.getNombreTresors());
        StdDraw.text(x, 260, "Nb tresors "+plongeur.getNom()+": "+plongeur.getNbCoffresSurSoi());
    }

}
