package snorkunking.moteurjeu;

public class Phase {

    private final Partie partie;
    private int oxygeneRestant;
    private Tour tourActuel;


    public Phase(Partie partie) {
        this.partie = partie;

        oxygeneRestant = 0;
        for (Cave cave : partie.getCaves())
            oxygeneRestant += 2 * cave.getNbNiveaux();

        this.tourActuel = new Tour(this);
    }

    public void lancer() {
        tourActuel.lancer();
    }

    public void consomerOxygene(int nombre) {
        oxygeneRestant -= nombre;
        if (oxygeneRestant <= 0) {
            oxygeneRestant = 0;
            finirPhase();
        }

    }

    public void tourFini() {
        this.tourActuel = new Tour(this);
        lancer();
    }

    private void finirPhase() {
        for (Plongeur p : partie.getPlongeurs())
            if (p.estDansLEau())
                p.seFaireBaiser();

        partie.phaseFinie();
    }

    public int getOxygeneRestant() {
        return oxygeneRestant;
    }

    public Partie getPartie() {
        return partie;
    }
}
