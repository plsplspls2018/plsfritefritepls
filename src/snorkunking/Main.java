package snorkunking;

import javafx.util.Pair;
import snorkunking.input.Input;
import snorkunking.input.InputJoueur;
import snorkunking.moteurjeu.Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        /*
        Snorkunking ma = new Snorkunking();
        ma.dispMenu();
        */
        List<Pair<String, Input>> joueurs = new ArrayList<>();
        joueurs.add(new Pair<>("Bob", new InputJoueur()));
        joueurs.add(new Pair<>("Alice", new InputJoueur()));
        new Partie(joueurs).lancer();
    }

    public static int RandomInt(int max) {
        return RandomInt(0, max);
    }

    /**
     * random int between min and max, included.
     */
    public static int RandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
