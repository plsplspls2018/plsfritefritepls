package snorkunking.graphique;

import snorkunking.moteurjeu.Cave;
import snorkunking.moteurjeu.Partie;
import snorkunking.moteurjeu.Plongeur;

public class PartieDessinateur {

    public void dessiner(Partie partie) {


        for (int profondeur = 0; profondeur < partie.getCaves().size(); profondeur++)
            dessinerCave(partie.getCaves().get(profondeur), profondeur);

        dessinerOxygene(partie.getPhase().getOxygeneRestant());

        for (Plongeur plongeur : partie.getPlongeurs())
            dessinerPlongeur(plongeur);

    }


    private void dessinerPlongeur(Plongeur plongeur) {

        plongeur.getNombreTresors(); //score a afficher, eventuellement a cote du nom
        plongeur.getNom();

        if(!plongeur.estDansLEau()) {
            //affiche le plongeur hors de l'eau
        } else {
            //afficher image du plongeur en se servant de sa position
            plongeur.getNiveau();
            plongeur.getProfondeur();

            //afficher le nombre de coffres actuellement portes
            plongeur.getNbCoffresSurSoi();
        }

    }

    private void dessinerOxygene(int oxygeneRestant) {
        //oxygeneRestant a afficher
    }

    private void dessinerCave(Cave cave, int profondeur) {
        //affiche le fond caveX.png, avec X = profondeur

        for (int niveau = 0; niveau < cave.getNbNiveaux(); niveau++) { // (pour chaque niveau)
            cave.getNbCoffres(niveau); // afficher autant de coffres que ce numero sur ce niveau

            //afficher la ligne de separation de ce niveau
        }

    }
}
