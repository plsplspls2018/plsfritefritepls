package snorkunking.input;

import snorkunking.moteurjeu.GererPartie;
import snorkunking.moteurjeu.Plongeur;

public abstract class Input {

    public static String actionMonter = "monter";
    public static String actionDescendre = "descendre";
    public static String actionRecuperer = "recuperer";

    public abstract String prochaineAction();

}
