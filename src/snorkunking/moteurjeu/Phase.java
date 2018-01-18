package snorkunking.moteurjeu;

public class Phase {

    private final Partie partie;
    private final Oxygene oxygene;
    private Tour tourActuel;


    public Phase(Partie partie) {
        this.partie = partie;

        int maxOxygen = 0;
        for (Cave cave : partie.getCaves())
            maxOxygen += 2 * cave.getNbNiveaux();
        this.oxygene = new Oxygene(maxOxygen);

        this.tourActuel = new Tour(this);
    }

    public void lancer() {
        tourActuel.lancer();
    }

    public void consomerOxygene(int nombre) {
        oxygene.consommer(nombre);
        if (oxygene.getRestant() == 0)
            finirPhase();

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


    public Partie getPartie() {
        return partie;
    }
}
