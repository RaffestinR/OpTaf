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
        for (int i = 0; i < src.length; i++) {
            this.stateSet.put(src[i], Integer.valueOf(i));
            this.stateSetP.put(tgt[i], Integer.valueOf(i));
        }
    }


   /* private RE succ(int x){

    }*/
}

class Obj {
    ArrayList<Integer> srcO;
    ArrayList<Integer> tgtO;
    ArrayList<SystemeElementaire[]> systemeO;
   // ArrayList<label> labelO;
    ArrayList<Boolean> initO;
    ArrayList<Boolean> accO;
    ArrayList<String> propO;
    ArrayList<String> procO;

        public Obj (RE s){
            Obj o;
        }

        //Permet de récupérer les Successeurs
        public void ObjSucc(Obj o,int x){
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.tgtO.get(cpt);
                o.systemeO.get(cpt);
                //o.labelO.get(x);
                //le print
                cpt++;
            }
        }

        //Permet de récupérer les Predesseurs
        public void ObjPred(Obj o,int x){
             //tri en fonction des tgt
            int cpt=0;
            while (x != o.tgtO.get(cpt)){
                cpt++;
            }
            while (x == o.tgtO.get(cpt)){
                o.srcO.get(cpt);
                o.systemeO.get(cpt);
                //o.labelO.get(x);
                //le print
            cpt++;
        }
    }


        //Permet de récupérer les Trnasitions (utile?)
        public void ObjTrans(Obj o,int x) {
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.srcO.get(cpt);
                o.tgtO.get(cpt);
                //print
                cpt++;
            }

        }

        //Permet de récupérer les états initiaux
        public void ObjInit(Obj o,int x){
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.srcO.get(cpt);
                //print
                cpt++;
            }
        }

        //Permet de récupérer les etats Accesseurs
        public void ObjAcc(Obj o,int x) {
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.srcO.get(cpt);
                //print
                cpt++;
            }
        }
        //Permet de récupérer les label
    /*  public void ObjLabel(Obj o,label a){
            //tri en fonction des label
            int cpt=0;
            while (x != o.labelO.get(cpt)){
                cpt++;
            }
            while (x == o.labelO.get(cpt)){
                o.labelO.get(x);
            }
        }*/

        //Permet de récupérer les Propriétées
        public void ObjTProp(Obj o,int x) {
            o.propO.get(x);
        }

        //Permet de récupérer les Processus
        public void ObjTProc(Obj o,int x) {
            o.procO.get(x);
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



