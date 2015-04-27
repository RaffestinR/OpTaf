package systeme;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.regexp.internal.RE;


public class SystemeElementaire {
    String[] nomSousSysteme = new String[0];
    SystemeElementaire[] sousSysteme = new SystemeElementaire[0];
    public String[] src;
    private String[] tgt;
    private HashMap<String, Integer> stateSet = new HashMap();
    private HashMap<String, Integer> stateSetP = new HashMap();
    private ArrayList<String> label = new ArrayList();
    private HashMap<String, Integer> labelSet = new HashMap();
    private String[] property;
   /* Bdd init = Bdd.FALSE;-
    Bdd stateProperty;
    surAccState;
    ArrayList<Bdd> relation = new ArrayList();
    Bdd completeRelation;
   private static final String STATE = "_SYSTEM";
    private static final String LABELNOTVISIBLE = "*";
    private static final String LABELNOP = "_";

     public Bdd getInit() {
          return init;
      }*/

    private SystemeElementaire(SystemeElementaire s) {
        this.nomSousSysteme = s.nomSousSysteme;
        this.sousSysteme = s.sousSysteme;
        this.src = s.src;
        this.tgt = s.tgt;
        this.stateSet = s.stateSet;
        this.stateSetP = s.stateSetP;
        this.label = s.label;
        this.labelSet=s.labelSet;
        this.property=s.property;
        /*this.init=s.init;
        this.stateProperty=s.stateProperty;
        this.surAccState=s.surAccState;
        this.relation=s.relation;
        this.completeRelation = s.completeRelation;*/
    }

    /*private RE succ (RE s){

    }*/
}