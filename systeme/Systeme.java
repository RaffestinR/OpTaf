package systeme;



import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BooleanSupplier;

import systeme.SystemeElem;

/**
 * Created by User on 06/05/15.
 */
public class Systeme {

    String[] nomSousSysteme = new String[0];
    Systeme[] sousSysteme = new Systeme[0];
    private Integer nbEtat = 0;
    public ArrayList<Integer> etat = new ArrayList();;
    public ArrayList<Integer> init = new ArrayList();;
    public ArrayList<ArrayList<Boolean>> prop = new ArrayList();;

    public ArrayList<ArrayList<ArrayList<Integer>>> transEtiq = new ArrayList();;
    private type type;
    public SystemeElem se = new SystemeElem();


    public Systeme(Systeme s){
        this.nomSousSysteme = s.nomSousSysteme;
        this.sousSysteme = s.sousSysteme;
        this.nbEtat = s.nbEtat;
        this.etat = s.etat;
        this.init = s.init;
        this.prop = s.prop;
        this.transEtiq=s.transEtiq;
        this.se=s.se;
    }
//inutile
 /*
    public Systeme(SystemeElem s){
        this.se = s;
    }*/

    public Systeme(int nbState,Object[] property) {
        nbEtat = nbState;
        etat(nbEtat);
        ArrayList L = new ArrayList();
      //  System.out.println(nbEtat);
        //this.etat = new ArrayList<Integer>();
        for (int i = 0; i < property.length; i++) {
            //this.etat.add(i);
          //  System.out.println(property[i]);
            L.add(property[i]);
        }
     //   System.out.println(L);
      //  System.out.println(se.nomProp);
        this.se.nomProp = L;
      //  System.out.println(se.nomProp);


    }
/*
    public Systeme(int nbState,ArrayList property) {
        int nbVarState = nbState;
        this.etat = new ArrayList<Integer>();
        for (int i = 0; i < nbVarState; i++) {
            this.etat.add(i);
        }

        this.se.nomProp = property;

    }*/
    public void etat (int nbState){
        ArrayList L = new ArrayList();
        for(int i=0; i<nbState ;i++){
            L.add(i);
        }
        etat=L;
    }

    public ArrayList succ (Object i){//nouvelle version
        int x,u;
        ArrayList l = new ArrayList(), currentElem;
        ArrayList L= new ArrayList();
        ArrayList<ArrayList<Integer>> currentList;
        L.add(-1);
        if(i.getClass().equals(compareType(type.INT))){
            for (x=1;x<se.nomEtiq.size();x++) {
                currentList = transEtiq.get(x);
                currentElem = currentList.get((Integer) i);
                if(currentElem != L){
                    for(u=0; u<currentElem.size();u++) {
                        if (!l.contains(currentElem.get(u))) {
                            l.add(currentElem.get(u));
                        }
                    }
                }
            }
        }
        if(i.getClass().equals(compareType(type.STR))){
            int j;
            if (se.nomEtiq.contains(i) && se.nomProp.contains(i)){//1
                System.out.println("Probl�me de confusion lors des initialisations des propri�t�es et �tiquettes");//pour le moment � remplacer
            }else if (se.nomEtiq.contains(i)){
                x = 0;
                while(se.nomEtiq.get(x) != i){
                    x++;
                }
                currentList = transEtiq.get(x);
                for(j=0;j<currentList.size();j++){
                    currentElem=currentList.get(j);
                    if(currentElem != L){
                        for(u=0;u<currentElem.size();u++){
                            if (!l.contains(currentElem.get(u))) {
                                l.add(currentElem.get(u));
                            }
                        }
                    }
                }
            }else if (se.nomProp.contains(i)){
                int v,w;
                x = 0;

                ArrayList<Integer> tmp = new ArrayList();
                while (se.nomProp.get(x) != i) {
                    x++;
                }
                ArrayList<Boolean> B = prop.get(x);
                for(j=0;j<B.size();j++) {
                    if(B.get(j)==true){
                        tmp.add(j);
                    }
                }
                for(u=0;u<transEtiq.size();u++){
                    currentList = transEtiq.get(u);
                    for(v=0;v<tmp.size();v++){
                        currentElem=currentList.get(tmp.get(v));
                        if(currentElem!=L){
                            for(w=0;w<currentElem.size();w++){
                                if (!l.contains(currentElem.get(u))) {
                                    l.add(currentElem.get(u));
                                }
                            }
                        }
                    }
                }
            }else {
                System.out.println("Aucune solution");//pour le moment � remplacer
            }
        }
        Collections.sort(l);
        return l;
    }

    public ArrayList<Integer> succ (ArrayList p){
        int x;
        ArrayList l2 = new ArrayList();
        for (x=0 ; x<p.size();x++) {
            l2.add(succ(p.get(x)));
        }
        Collections.sort(l2);
        return l2;
    }

    public String toDot() {
        if (init==null) {
            return "digraph system {\n empty [shape=box]}\n";
        }
        StringBuilder res = new StringBuilder();
        res.append("digraph system {\n");

        recToDotState(res);

        toDotTransition(res);

        res.append("}\n");
        return res.toString();
    }


    private void recToDotState(StringBuilder res) {
        int x;
        if (init == null) {
            return;
        }

            if (init != null) {
                for(x=0;x<init.size();x++) {
                    res.append("_" + init.get(x) + "[label=\"\", shape=none ];\n");
                    res.append("_" + init.get(x) + "->" + init.get(x) + ";\n");
                }
            }
    }

    private void toDotTransition(StringBuilder res) {
        int x, y, z;
        ArrayList J = new ArrayList();
        J.add(-1);
        ArrayList L;
        ArrayList M;
        for (x=0;x<transEtiq.size();x++){
            L=transEtiq.get(x);
            for (y=0;y<L.size();y++) {
                M = (ArrayList) L.get(y);
                if (!L.get(y).equals(J))
                    for (z = 0; z < M.size(); z++) {
                        res.append(y + "->" + M.get(z) + " [label= \"" + se.nomEtiq.get(x) + "\"];\n");
                }
            }
        }
    }
    //--------------------------------------------------

    public Object compareType(type t) {
        Integer i = 0;
        String s = "s";

        switch (type) {
            case INT:
                return i.getClass();

            case STR:
                return s.getClass();

            default:
                return null;
        }
    }

    public boolean isState(int n) {
        if(etat.contains(n)){
            return true;
        }
        else return false;
    }

    public void addInitState(int s) {
        this.init.add(s);
    }

    /*public void addTransition(int src, int tgt) {
        addTransition(src, tgt, "*");
    }*/
//    public ArrayList<ArrayList<ArrayList<Integer>>> initTrans(Systeme S){
//        System.out.println("\n" + "initTrans Debut: ");
//        System.out.println("transEtiq : " + transEtiq);
//        ArrayList<ArrayList<ArrayList<Integer>>> J = new ArrayList();
//
//        ArrayList<Integer> I = new ArrayList();
//        I.add(-1);
//        System.out.println("I : " + I);
//        int x=0,y=0;
//        System.out.println("se.nomEtiq : " + se.nomEtiq);
//        System.out.println("etatq : " + etat);
//        while (x<se.nomEtiq.size()){ // attention sens boucle
//            ArrayList<ArrayList<Integer>> K = new ArrayList<ArrayList<Integer>>();
//            while(y<etat.size()){
//                System.out.println("K AV : " + K);
//                K.add(I);
//                System.out.println("K AP : " + K);
//            }
//            System.out.println("J AV : " + J);
//            J.add(K);
//            System.out.println("J AP : " + J);
//        }
//        transEtiq = J;
//        System.out.println("transEtiq : " + transEtiq);
//        System.out.println("initTrans Fin: \n");
//        return transEtiq;
//    }

    public void ajoutEtiqTrans (){
//        System.out.println("\n" + "ajoutEtiq Debut : ");
        ArrayList<ArrayList<Integer>> L = new ArrayList();
        ArrayList<Integer> K = new ArrayList();
//        System.out.println("K : " + K);
        K.add(-1);
//        System.out.println("K : " + K);
//        System.out.println("L : " + L);
        for (int x = 0 ; x < etat.size() ; x++){
            L.add(K);
//            System.out.println("L["+x+"] : " + L);
        }
//        System.out.println("transEtiq AV : " + transEtiq);
        transEtiq.add(L);
//        System.out.println("transEtiq AP : " + transEtiq);
//        System.out.println("ajoutEtiq Fin : \n");
    }

    public void addTransition(int src, int tgt, Object l) {
//        System.out.println("\n" + "    addTransition Debut : ");
//        System.out.println("transEtiq AV : " + transEtiq);
        int a = se.nomEtiq.indexOf(l);
//        System.out.println("étiquette a : " + a);

        if(a==-1){
//            System.out.println("se.nomEtiq : " + se.nomEtiq);
            se.nomEtiq.add(l);
//            System.out.println("se.nomEtiq : " + se.nomEtiq);
            a = se.nomEtiq.indexOf(l);
//            System.out.println("index étiquette a : " + a);
            ajoutEtiqTrans();
        }

//        System.out.println("transEtiq : " + transEtiq);
        ArrayList<ArrayList<Integer>> T = transEtiq.get(a);
//        System.out.println("transEtiq.get(a) : " + transEtiq.get(a));
//        System.out.println("T : " + T);
        int b = etat.indexOf(src);
//        System.out.println("index etat b : " + b);
        if(b==-1){
//            System.out.println("etat : " + etat);
            etat.add(src);
//            System.out.println("etat : " + etat);
            b = etat.indexOf(src);
//            System.out.println("index etat b : " + b);
        }
//        System.out.println("AV U : ");
//        System.out.println("T : " + T);
//        System.out.println("T.get(b) : " + T.get(b));
        ArrayList<Integer> U = new ArrayList<Integer>();
//        System.out.println("U ini : " + U);
        ArrayList<Integer> L = new ArrayList();
        L.add(-1);
//        System.out.println("L : " + L);
//        System.out.println(" /n premier problème ici /n");


        if(T.get(b).equals(L)){
//            System.out.println("T1 : " + T);
            T.remove(b);
//            System.out.println("T2 : " + T);
            ArrayList K = new ArrayList();
//            System.out.println("K : " + K);
            K.add(tgt);
//            System.out.println("K : " + K);
            T.add(b, K);
//            System.out.println("T3 : " + T);
        }
        else{
//            System.out.println("U : " + U);
            U = T.get(b);
//            System.out.println("U AV : " + U);
//            System.out.println("U contient? : " + U.contains(tgt));
            if(!U.contains(tgt)){
                U.add(tgt);
//                System.out.println("U : " + U);
//                System.out.println("T4 : " + T);
                T.remove(b);
//                System.out.println("T5 : " + T);
                T.add(b, U);
//                System.out.println("T6 : " + T);
//                System.out.println("U AP : " + U);
            }
            transEtiq.remove(a);
            transEtiq.add(a,T);
        }
//        System.out.println("transEtiq Final : " + transEtiq);
//        System.out.println("    addTransition Fin : \n");

//        U = T.get(b);
//        System.out.println("U AV : " + U);
//        System.out.println("U contient? : " + U.contains(tgt));
//        if(!U.contains(tgt)){
//            U.add(tgt);
//            System.out.println("U AP : " + U);
//        }
//        System.out.println("addTransition Fin : \n");
    }

    public boolean isProp(Object i){
//        System.out.println("\n    isProp Debut");
//        System.out.println("se.nomProp : " + se.nomProp);
//        System.out.println("Object : " +i);
//        System.out.println("contains : " + this.se.nomProp.contains(i)+ "\n");
//        System.out.println("    isProp Fin \n");
        return this.se.nomProp.contains(i);
    }

    public ArrayList<ArrayList<Boolean>> initStateProperty() {

//        System.out.println("\n    initStateProperty Debut");
        int x,y;
//        System.out.println("etat : " + etat);
//        System.out.println("nomProp : " + se.nomProp);

        ArrayList<ArrayList<Boolean>> T = new ArrayList<ArrayList<Boolean>>();
//        for(x=0;x<etat.size();x++){
//            ArrayList<Boolean> S = new ArrayList();
//            for(y=0;y<se.nomProp.size();y++){
//                S.add(false);
//            }
//            T.add(S);
//        }
        for(x=0;x<se.nomProp.size();x++){
            ArrayList<Boolean> S = new ArrayList();
            for(y=0;y<etat.size();y++){
                S.add(false);
            }
            T.add(S);
        }
//        System.out.println("T : " + T);
//        System.out.println("prop AV : " + prop);
        prop = T;
//        System.out.println("prop AP : " + prop + "\n");
//        System.out.println("    initStateProperty Fin \n");
        return prop;
    }

    public void addStateProperty(int src, Object i) {
        System.out.println("\n    addStateProperty Debut");
        System.out.println("prop : "+ prop+ "\n");
        if (prop.isEmpty()){
            System.out.println("prop AV(if) " + prop);
            prop=initStateProperty();
            System.out.println("prop AP(if) : "+ prop);
        }
        else {
            System.out.println("prop (else) "+ prop);}
            int a = se.nomProp.indexOf(i);
            System.out.println("index prop : "+ a+ "\n");
            if(a!=-1){
            ArrayList<Boolean> T = prop.get(a);
            prop.remove(a);
            Boolean U = T.get(src);
            T.remove(src);
            if(U==false){
               U=true;
            }
            T.add(src,U);
            prop.add(a,T);
        }
        else System.out.println("La propri�t� n'�xiste pas");
        System.out.println("Final : " + prop + "\n");
        System.out.println("initStateProperty Fin \n");

    }

    public void addProp(Object o) {
        if (o == null && !se.nomProp.contains('*')) {
            se.nomProp.add('*');
        } else if (o != null && !se.nomProp.contains(o)) {
            se.nomProp.add(o);
        }
    }



    public enum type {
        INT,
        STR;
    }
}