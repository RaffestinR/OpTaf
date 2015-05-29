package systeme;



import java.lang.reflect.Array;
import java.util.*;
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
        //this.etat = new ArrayList<Integer>();
        for (int i = 0; i < nbEtat; i++) {
            //this.etat.add(i);
            this.se.nomProp.add(property[i]);
        }



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
                if (L.get(y)!= J)
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

    /* a revoir */
    public void addTransition(int src, int tgt, String l) {
        int a = se.nomEtiq.indexOf(l);
        if(a==-1){
            se.nomEtiq.add(l);
            a = se.nomEtiq.indexOf(l);
        }
        ArrayList<ArrayList<Integer>> T = transEtiq.get(a);
        int b = etat.indexOf(src);
        if(b==-1){
            etat.add(src);
            b = etat.indexOf(src);
        }
        ArrayList<Integer> U = T.get(b);
        if(!U.contains(tgt)){
            U.add(tgt);
        }
    }

    public boolean isProp(Object i){
        if (se.nomEtiq.contains(i)){
            return true;
        }else return false;
    }

    public ArrayList<ArrayList<Boolean>> initStateProperty() {
        int x,y;
        for (x=0;x<etat.size();x++){
            ArrayList<Boolean> T= prop.get(x);
            for (y=0;y<se.nomProp.size();y++){
                Boolean U = T.get(y);
                U=false;
            }
        }
        return prop;
    }

    public void addStateProperty(int src, Object i) {
        if (prop==null){
            prop=initStateProperty();
        }
        int a = se.nomProp.indexOf(i);
        if(a!=-1){
            ArrayList<Boolean> T = prop.get(a);
            Boolean U = T.get(src);
            if(U==false){
               U=true;
            }
        }
        else System.out.println("La propri�t� n'�xiste pas");

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