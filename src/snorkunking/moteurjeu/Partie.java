package snorkunking.moteurjeu;


import javafx.util.Pair;
import snorkunking.graphique.FenetreDessinateur;
import snorkunking.graphique.PartieDessinateur;
import snorkunking.input.Input;

import java.util.*;

public class Partie {

    public static final int NUMBER_OF_CAVE = 3;

    private Phase phaseActuelle;
    private int numPhase = 0;
    private List<Plongeur> plongeurs = new ArrayList<>();
    private List<Cave> caves = new ArrayList<>(NUMBER_OF_CAVE);


    public Partie(Collection<Pair<String, Input>> joueurs) {
        for (Pair<String, Input> joueur : joueurs)
            plongeurs.add(new Plongeur(this, joueur.getKey(), joueur.getValue()));

        for (int i = 0; i < NUMBER_OF_CAVE; i++)
            caves.add(i, new Cave(i));

        this.phaseActuelle = new Phase(this);

        FenetreDessinateur.init();
        PartieDessinateur.partieEnCours = this;
    }

    public void lancer() {
        phaseActuelle.lancer();
    }


    public void phaseFinie() {
        if (numPhase == 2) {
            return;
        }
        numPhase++;

        for (Cave cave : caves)
            cave.mettreAJourNiveaux();

        this.phaseActuelle = new Phase(this);
        phaseActuelle.lancer();
    }


    public void faireTomberCoffres(Collection<Coffre> coffres) {
        caves.get(caves.size() - 1).mettreCoffresAuFond(coffres);
    }

    public Collection<Plongeur> getPlongeurs() {
        return plongeurs;
    }

    public List<Cave> getCaves() {
        return caves;
    }

    public Phase getPhase() {
        return phaseActuelle;
    }
}
