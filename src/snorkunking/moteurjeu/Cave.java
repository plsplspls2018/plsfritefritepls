package snorkunking.moteurjeu;

import snorkunking.Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Cave {

    private List<List<Coffre>> coffresParNiveau;


    public Cave(int profondeur) {
        int nbNiveaux;
        if (profondeur == 0)
            nbNiveaux = Main.RandomInt(9, 12);
        else if (profondeur == 1)
            nbNiveaux = Main.RandomInt(6, 19);
        else if (profondeur == 2)
            nbNiveaux = Main.RandomInt(3, 6);
        else
            throw new RuntimeException("profondeur cave doit être entre 1 et 3 et non " + profondeur);

        coffresParNiveau = new ArrayList<>(nbNiveaux);
        for (int niveau = 0; niveau < nbNiveaux; niveau++)
            coffresParNiveau.add(new ArrayList<>(Collections.singletonList(new Coffre(profondeur))));


    }

    public int getNbNiveaux() {
        return this.coffresParNiveau.size();
    }

    public Coffre prendreCoffre(int niveau) throws IllegalStateException {
        if (coffresParNiveau.get(niveau).isEmpty())
            throw new IllegalStateException("Impossible de prendre un coffre la ou il n'y en a pas (niveau " + niveau + ")");

        return coffresParNiveau.get(niveau).remove(0);
    }

    public void mettreCoffresAuFond(Collection<Coffre> coffres) {
        coffresParNiveau.get(coffresParNiveau.size() - 1).addAll(coffres);
    }

    /**
     * Supprime les niveaux sans coffres
     **/
    public void mettreAJourNiveaux() {
        coffresParNiveau.removeIf(new Predicate<List<Coffre>>() {
            @Override
            public boolean test(List<Coffre> coffres) {
                return coffres.isEmpty();
            }
        });
    }

    public int getNbCoffres(int niveau) {
        return coffresParNiveau.get(niveau).size();
    }


}
