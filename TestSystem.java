import bdd.Bdd;
import mso.Automaton;
import systeme.Systeme;

/**
 * Created by couvreur on 15/09/14.
 */
public class TestSystem {

    /*

    Case = []{
     etat=1;
     init =0;
     0->0 [u];
     0->0 [v];
     0->0 [w];
};;

todot systeme.dot Case;;

     */


    public static void main(String[] arg) {
/*
        Automaton toc = new Automaton(2,1);
        toc.addInitState(0);
        toc.addTransition(0,1,Bdd.TRUE,new int[]{0});

        String dot = toc.toDot();
        System.out.println(dot);
*/


        Systeme toc = new Systeme(2,new String[]{});
        toc.addInitState(0);
        toc.addTransition(0,1,"u");
        toc.addTransition(1,0);
        toc.addStateProperty(toc.getInit(),"init");

        String dotSynchro =toc.toDot();
        System.out.println(dotSynchro);

    }
}
