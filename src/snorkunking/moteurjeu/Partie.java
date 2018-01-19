package snorkunking.moteurjeu;


import javafx.util.Pair;
import snorkunking.graphique.PartieDessinateur;
import snorkunking.input.Input;

import java.util.*;

public class Partie {

    private Phase phaseActuelle;
    private int numPhase = 0;
    private Map<Plongeur, Integer> scorePlongeurs = new HashMap<>();
    private List<Cave> caves = new ArrayList<>(3);


    public Partie(Collection<Pair<String, Input>> joueurs) {
        for (Pair<String, Input> joueur : joueurs)
            scorePlongeurs.put(new Plongeur(this, joueur.getKey(), joueur.getValue()), 0);

        for (int i = 0; i < caves.size(); i++)
            caves.set(i, new Cave(i));

        this.phaseActuelle = new Phase(this);

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

    public void augmenterScore(Plongeur j, int score) {
        scorePlongeurs.put(j, scorePlongeurs.get(j) + score);
    }

    public void faireTomberCoffres(Collection<Coffre> coffres) {
        caves.get(caves.size() - 1).mettreCoffresAuFond(coffres);
    }

    public Collection<Plongeur> getPlongeurs() {
        return scorePlongeurs.keySet();
    }

    public List<Cave> getCaves() {
        return caves;
    }

    public Phase getPhase() {
        return phaseActuelle;
    }
}
