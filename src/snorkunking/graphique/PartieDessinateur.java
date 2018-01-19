package snorkunking.graphique;

import snorkunking.moteurjeu.Cave;
import snorkunking.moteurjeu.Partie;
import snorkunking.moteurjeu.Plongeur;

public class PartieDessinateur {

    public static Partie partieEnCours;

    public static void dessiner() {

        StdDraw.clear();

        for (int profondeur = 0; profondeur < partieEnCours.getCaves().size(); profondeur++)
            dessinerCave(partieEnCours.getCaves().get(profondeur), profondeur);

        dessinerOxygene(partieEnCours.getPhase().getOxygeneRestant());

        for (Plongeur plongeur : partieEnCours.getPlongeurs())
            dessinerPlongeur(plongeur);

        StdDraw.show();
    }


    private static void dessinerPlongeur(Plongeur plongeur) {

        PlongeurDessinateur.dessinerSprite(plongeur);

    }

    private static void dessinerOxygene(int oxygeneRestant) {
        StdDraw.text(0,290, "Oxygene restant: "+oxygeneRestant);
    }

    private static void dessinerCave(Cave cave, int profondeur) {
        CaveDessinateur.dessinerSprite(profondeur);

        double y = CaveDessinateur.YCave(profondeur) + CaveDessinateur.HauteurCave(profondeur)/2 - CaveDessinateur.HauteurNiveau(profondeur)/2;
        for (int niveau = 0; niveau < cave.getNbNiveaux(); niveau++) { // (pour chaque niveau)

            StdDraw.rectangle(0, y  ,FenetreDessinateur.LARGEUR/2, CaveDessinateur.HauteurNiveau(profondeur)/2);

            for(int i=0; i<cave.getNbCoffres(niveau); i++) {
                StdDraw.picture(i*CoffreDessinateur.COFFRE_LARGEUR, y, "image/coffre.png", CoffreDessinateur.COFFRE_LARGEUR, CoffreDessinateur.COFFRE_HAUTEUR);
            }

            y -= CaveDessinateur.HauteurNiveau(profondeur);
        }

    }
}
