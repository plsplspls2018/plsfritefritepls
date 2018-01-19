package snorkunking.moteurjeu;

import java.util.*;

public class Tour {

    private Phase phase;
    private List<Plongeur> plongeurs;
    private int plongeurActuel = 0;

    public Tour(Phase phase) {
        this.phase = phase;
        this.plongeurs = new ArrayList<>(phase.getPartie().getPlongeurs());
        this.plongeurs.sort(new Comparator<Plongeur>() {
            @Override
            public int compare(Plongeur p1, Plongeur p2) {
                return estPlusProfondQue(p1, p2) ? -1 : 1;
            }
        });

    }

    // lorsque la profondeur est egale, le choix se fait par nom. Il est donc important que deux plongeurs n'ai pas le meme nom.
    private boolean estPlusProfondQue(Plongeur p1, Plongeur p2) {
        if (p1.getProfondeur() == p2.getProfondeur()) {
            if (p1.getNiveau() == p2.getNiveau())
                return p1.getNom().compareTo(p2.getNom()) > 0;
            return p1.getNiveau() > p2.getNiveau();
        }

        return p1.getProfondeur() > p2.getProfondeur();
    }

    public void lancer() {
        for (Plongeur plongeur : plongeurs)
            plongeur.jouer();

        phase.tourFini();
    }
}
