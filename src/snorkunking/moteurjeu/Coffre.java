package snorkunking.moteurjeu;

import snorkunking.Main;

public class Coffre {

    private int nbTresors;

    public Coffre(int profondeurCave) {

        if (profondeurCave == 0)
            this.nbTresors = Main.RandomInt(1, 3);
        else if (profondeurCave == 1)
            this.nbTresors = Main.RandomInt(5, 8);
        else if (profondeurCave == 2)
            this.nbTresors = Main.RandomInt(10, 12);
        else
            throw new RuntimeException("profondeur cave doit être entre 1 et 3 et non " + profondeurCave);
    }

    public int getNbTresors() {
        return this.nbTresors;
    }




}
