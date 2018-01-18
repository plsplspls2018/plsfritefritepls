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
                return 0;
            }
        });

        this.jouer();
    }

    public void jouer() {
        plongeurs.get(plongeurActuel).jouer();

        plongeurActuel++;
        if(plongeurActuel > plongeurs.size())
            phase.tourFini();
    }
}
