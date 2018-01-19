package snorkunking.moteurjeu;

import snorkunking.graphique.PartieDessinateur;
import snorkunking.input.Input;

import java.util.ArrayList;
import java.util.List;

public class Plongeur {

    private final String nom;
    private final Partie partie;
    private List<Coffre> coffresSurSoi = new ArrayList<>();
    private int nombreTresors = 0;
    private int niveauActuel = 0;
    private int profondeurActuelle = -1;
    private Input input;

    public Plongeur(Partie partie, String nom, Input input) {
        this.partie = partie;
        this.nom = nom;
        this.input = input;
    }


    public boolean estDansLEau() {
        return profondeurActuelle > -1;
    }


    public void seFaireBaiser() {
        niveauActuel = 0;
        profondeurActuelle = -1;
        partie.faireTomberCoffres(coffresSurSoi);
        coffresSurSoi.clear();
    }

    public void jouer() {

        PartieDessinateur.dessiner();
        boolean aFaitAction;
        do {
            String action = input.prochaineAction(partie, this);
            if (action == Input.actionMonter)
                aFaitAction = monter();
            else if (action == Input.actionDescendre)
                aFaitAction = descendre();
            else if (action == Input.actionRecuperer)
                aFaitAction = recupererCoffre();
            else
                throw new RuntimeException("Action invalide: " + action);
        } while (aFaitAction);
    }


    /**
     * Chaque action retourne false si son execution est impossible et n'as pas ete faite
     **/

    private boolean monter() {
        if (estDansLEau())
            return false;

        //monte d'une cave
        if (niveauActuel == 0) {
            profondeurActuelle--;
            if (estDansLEau())
                niveauActuel = getCave().getNbNiveaux() - 1;
            else
                ouvrirCoffres();

        } else {
            niveauActuel--;
        }

        partie.getPhase().consomerOxygene(1 + coffresSurSoi.size());

        return true;
    }

    private boolean descendre() {
        if (partie.getCaves().size() == profondeurActuelle - 1)
            return false;

        //descend d'une cave
        if (!estDansLEau() || getCave().getNbNiveaux() == niveauActuel - 1) {
            profondeurActuelle++;
            niveauActuel = 0;
        } else {
            niveauActuel++;
        }

        partie.getPhase().consomerOxygene(1 + coffresSurSoi.size());

        return true;
    }


    private boolean recupererCoffre() {
        if (!estDansLEau())
            return true; // on reste sur place et on ne consomme pas doxygene

        try {
            coffresSurSoi.add(getCave().prendreCoffre(niveauActuel));
        } catch (IllegalStateException e) {
            return false;
        }

        partie.getPhase().consomerOxygene(1);
        return true;
    }

    /**
     * Attention, ne marche que si on est dans l'eau => il faut toujours tester avant
     */
    private Cave getCave() {
        return partie.getCaves().get(profondeurActuelle);
    }

    private void ouvrirCoffres() {
        for (Coffre coffre : coffresSurSoi)
            nombreTresors += coffre.getNbTresors();
        coffresSurSoi.clear();
    }

    public int getNombreTresors() {
        return nombreTresors;
    }

    public int getNiveau() {
        return niveauActuel;
    }

    public int getProfondeur() {
        return profondeurActuelle;
    }

    public int getNbCoffresSurSoi() {
        return coffresSurSoi.size();
    }


    public String getNom() {
        return nom;
    }



}
