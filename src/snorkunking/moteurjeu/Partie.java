package snorkunking.moteurjeu;


import java.util.*;

public class Partie {

    private Phase phaseActuelle;
    private Map<Plongeur, Integer> scorePlongeurs = new HashMap<>();
    private List<Cave> caves = new ArrayList<>(3);


    public Partie(Collection<String> joueurs) {
        for(String nomJoueur: joueurs)
            scorePlongeurs.put(new Plongeur(nomJoueur), 0);
        this.phaseActuelle = new Phase(this);

        for(int i=0; i<caves.size(); i++)
            caves.set(i, new Cave(i));

    }


    public void phaseFinie() {
        for(Cave cave: caves)
            cave.mettreAJour();

        this.phaseActuelle = new Phase(this);
    }

    public void augmenterScore(Plongeur j, int score) {
        scorePlongeurs.put(j, scorePlongeurs.get(j)+score);
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
