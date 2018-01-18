package snorkunking;

import snorkunking.graphique.Snorkunking;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Snorkunking ma = new Snorkunking();
        ma.dispMenu();

    }

    public static int RandomInt(int max) {
        return RandomInt(0, max);
    }

    /**
     * random int between min and max, included.
     */
    public static int RandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}
