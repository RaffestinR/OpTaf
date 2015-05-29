//package Systeme;
//
//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}

package systeme;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

//import mso.Automaton;

public class Main
{
    public static void ecrire(String fichier, String texte)
    {
        try
        {
            PrintStream f = new PrintStream(new File(fichier));
            f.print(texte);
            f.close();
        }
        catch (Exception e)
        {
            System.err.println("Probleme d'ecriture !");
        }
    }

    public static void main(String[] args)
    {
        Systeme s1 = new Systeme(2, new String[] { "p", "q" });
        s1.addInitState(0);
        s1.addStateProperty(0, "p");
        s1.addStateProperty(1, "q");
        s1.addTransition(0, 1, "*");
        s1.addTransition(1, 0, "a");

        Systeme s2 = new Systeme(2, new String[] { "p", "q" });
        s2.addInitState(0);
        s2.addStateProperty(0, "p");
        s2.addStateProperty(1, "q");
        s2.addTransition(0, 1, "b");
        s2.addTransition(1, 0, "*");


        Produit synchro = new Produit(new String[] { "a", "b" }, new Systeme[] { s1, s2 });
        ArrayList L = new ArrayList();
        L.add("a");
        L.add("b");
        synchro.synchro(L);

        ecrire("toto.dot", synchro.toDot());

        /*
        Automaton a = synchro.toAutomaton();
        ecrire("titi.dot", a.toDot());
        System.out.println(a.toDot());*/

        //System.out.println(synchro.state.length);
    }
}

