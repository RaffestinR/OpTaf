package systeme;
//import java.lang.reflect.Array;
import systeme.SystemeElementaire;

import java.lang.Object;
import java.lang.reflect.Array;
import java.util.*;

public class RE {
    SystemeElementaire[] Systeme = new SystemeElementaire[0]; //?
    public String[] src;
    private String[] tgt;
    private HashMap<String, Integer> stateSet = new HashMap();
    private HashMap<String, Integer> stateSetP = new HashMap();
    private ArrayList<String> label = new ArrayList();
    private HashMap<String, Integer> labelSet = new HashMap();
    private ArrayList<Object> transition = new ArrayList();
    private HashMap<Object,Integer> transitionset = new HashMap();
    private ArrayList<String> processus = new ArrayList();
    private HashMap<String,Integer> processusSet = new HashMap();


    private ArrayList<Obj> Successeur = new ArrayList();
    private HashMap<Obj,Integer> SuccesseurSet = new HashMap();

  //  private transition ;
    private RE (String[] src, String[] tgt/*, Bdd init, Bdd relation, Bdd[] acc*/) {
        this.src = src;
        this.tgt = tgt;
       /* this.init = init;
        this.relation = relation;
        this.acc = acc;*/
        for (int i = 0; i < state.length; i++) {
            this.stateSet.put(state[i], Integer.valueOf(i));
            this.stateSetP.put(stateP[i], Integer.valueOf(i));
        }
    }


   /* private RE succ(int x){

    }*/
}

class Obj {
    ArrayList<Integer> etatSrc;
    ArrayList<Integer> etatTgt;
    ArrayList<SystemeElementaire[]> SystemeS;
   // ArrayList<label> labelSucc;

        public void ObjSucc(Obj o,int x){
            o.etatSrc.get(x);
            o.etatTgt.get(x);
            o.SystemeS.get(x);
       //     labelSucc.get(x);
        }

        public void ObjTrans(Obj o,int x) {
            o.etatSrc.get(x);
            o.etatTgt.get(x);
        }

        public Obj (RE s){
            Obj o;


        }
}

/*
public class RE {
    public final int etat;
    public final int etatI;
    //public final ArrayList<int, system, label> tableau[];

   // public final label action;
    public final Object transition;
    private ArrayList<transition> tableau = new ArrayList();

    private RE(int e, int i, ArrayList tab, Object t) {
        this.etat = e;
        this.etatI = i;
   //     this.action = a;
        this.transition = t;
        this.tableau = tab;
    }

 */
  //  private succ(){};



