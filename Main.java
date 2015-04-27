import bdd.Bdd;

import java.io.File;
import java.io.PrintStream;

import mso.Automaton;

public class Main {
    public static void ecrire(String fichier, String texte) {
        try {
            PrintStream f = new PrintStream(new File(fichier));
            f.print(texte);
            f.close();
        } catch (Exception e) {
            System.err.println("Probleme d'ecriture !");
        }
    }

    static Automaton next(String xVar, String yVar) {
        Automaton a = new Automaton(1, 0);
        Bdd x = Bdd.variable(xVar);
        Bdd y = Bdd.variable(yVar);

        a.addInitState(0);
        a.addInitState(1);
        a.addTransition(0, 0, x.not().and(y.not()), new int[0]);
        a.addTransition(0, 1, x.not().and(y), new int[0]);
        a.addTransition(1, 0, x.and(y.not()), new int[0]);
        a.addTransition(1, 1, x.and(y), new int[0]);

        return a;
    }

    static Automaton until(String x0Var, String x1Var, String yVar) {
        Automaton a = new Automaton(1, 1);
        Bdd x0 = Bdd.variable(x0Var);
        Bdd x1 = Bdd.variable(x1Var);
        Bdd y = Bdd.variable(yVar);

        a.addInitState(0);
        a.addInitState(1);
        a.addTransition(0, 0, x1.not().and(y.not()), new int[1]);
        a.addTransition(0, 1, x0.not().and(x1.not().and(y.not())), new int[1]);
        a.addTransition(1, 0, x1.and(y), new int[1]);
        a.addTransition(1, 1, x1.and(y), new int[1]);
        a.addTransition(1, 1, x0.and(x1.not().and(y)), new int[0]);

        return a;
    }

    static Automaton first(String xVar) {
        Automaton a = new Automaton(1, 0);
        Bdd x = Bdd.variable(xVar);

        a.addInitState(0);
        a.addTransition(0, 1, x, new int[0]);
        a.addTransition(1, 1, Bdd.TRUE, new int[0]);

        return a;
    }

    static Automaton all(String xVar) {
        Automaton a = new Automaton(5, 0);
        Bdd x = Bdd.variable(xVar);

        a.addInitState(0);
        a.addTransition(0, 4, x, new int[0]);

        return a;
    }

    static Automaton et(String xVar0, String xVar1, String yVar) {
        Automaton a = new Automaton(0, 0);
        Bdd x0 = Bdd.variable(xVar0);
        Bdd x1 = Bdd.variable(xVar1);
        Bdd y = Bdd.variable(yVar);

        a.addInitState(0);
        a.addTransition(0, 0, x0.and(x1).equiv(y), new int[0]);

        return a;
    }

    static Automaton non(String xVar, String yVar) {
        Automaton a = new Automaton(0, 0);
        Bdd x = Bdd.variable(xVar);
        Bdd y = Bdd.variable(yVar);

        a.addInitState(0);
        a.addTransition(0, 0, x.equiv(y.not()), new int[0]);

        return a;
    }

    static Automaton F(String xVar, String yVar) {
        Automaton a = new Automaton(1, 1);
        Bdd x = Bdd.variable(xVar);
        Bdd y = Bdd.variable(yVar);

        a.addInitState(0);
        a.addInitState(1);

        a.addTransition(0, 0, x.not().and(y), new int[0]);
        a.addTransition(0, 0, x.and(y), new int[1]);
        a.addTransition(0, 1, x.and(y), new int[1]);
        a.addTransition(1, 1, x.not().and(y.not()), new int[1]);

        return a;
    }

    public static void main(String[] arg) {
        Automaton a = all("x");
        a = a.substitute(new String[]{"x"}, new Bdd[]{Bdd.variable("y")});
        ecrire("toto.dot", a.toDot());
    }
}

