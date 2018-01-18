package moteurjeu;

import java.util.concurrent.ThreadLocalRandom;

public class Utilitaires {

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
