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
            // lorsque la profondeur est egale, le choix se fait par nom. Il est donc important que deux plongeurs n'ai pas le meme nom.
            public int compare(Plongeur p1, Plongeur p2) {
                return p1.estPlusProfondQue(p2) ? -1 : 1;
            }
        });

    }

    public void lancer() {
        for (Plongeur plongeur : plongeurs)
            plongeur.jouer();

        phase.tourFini();
    }
}
