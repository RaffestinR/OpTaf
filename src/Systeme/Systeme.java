package Systeme;

import Systeme.SystemeElem;

import java.util.*;

/**
 * Created by User on 06/05/15.
 */
public class Systeme {
    String[] nomSousSysteme = new String[0];
    Systeme[] sousSysteme = new Systeme[0];
    private Integer nbEtat = 0;
    public ArrayList<Integer> etat;
    public ArrayList<Integer> init;
    public ArrayList<ArrayList<Integer>> trans;
    public ArrayList<ArrayList<Boolean>> prop;

    public ArrayList<ArrayList<ArrayList<Integer>>> transEtiq;
    //public ArrayList<ArrayList<ArrayList<String>>> transEtiq2;
    //ou:  public ArrayList<ArrayList<ArrayList<Object>>> transProp;
    private type type;
    public SystemeElem se;


    public Systeme(Systeme s){
        this.nomSousSysteme = s.nomSousSysteme;
        this.sousSysteme = s.sousSysteme;
        this.nbEtat = s.nbEtat;
        this.etat = s.etat;
        this.init = s.init;
        this.trans = s.trans;
        this.prop = s.prop;
        this.transEtiq=s.transEtiq;
    }

    public Systeme(SystemeElem s){
        this.se = s;
    }

    public ArrayList succ (Integer i){ // ordre à revoir
        int x,lt;
        ArrayList l = new ArrayList();
        //ArrayList lt = new ArrayList();
        if(i.getClass().equals(compareType(type.INT))){
            ArrayList<Integer> currentList;
            currentList = trans.get(i);
            for (x=1;x<currentList.size();x++) {
                if(currentList.get(x) != -1){
                    l.add(currentList.get(x));
                }
            }
        }

        if(i.getClass().equals(compareType(type.STR))){
            //à revoir si bo parcour de tableau
            boolean y=false;
            int j,z;
            if (se.nomEtiq.contains(i) && se.nomProp.contains(i)){//1
                System.out.println("Problème de confusion lors des initialisations des propriétées et étiquettes");

            }else if (se.nomEtiq.contains(i)){//3
                x = 0;
                while(y==false){
                    if (se.nomEtiq.get(x) == i){
                        y=true;
                    }else x++;
                }
                for (j=1;j<transEtiq.size();j++){
                    ArrayList<ArrayList<Integer>> currentList = transEtiq.get(j);
                    ArrayList<Integer> currentElem = currentList.get(x);
                    if (currentElem.get(0) != -1){
                        for(z=0;z<currentElem.size();z++){
                            if (!l.contains(currentElem.get(z))){
                                l.add(currentElem.get(z));
                            }
                        }
                    }
                }
            }else if (se.nomProp.contains(i)){//4
                x = 0;
                ArrayList<Integer> tmp = new ArrayList();
                while(y==false){
                    if (se.nomProp.get(x) == i){
                        y=true;
                    }else x++;
                }
                ArrayList< Boolean> X = prop.get(x);
                for(z=0;z<X.size();z++){
                    if (X.get(i)==true){
                        tmp.add(i);
                    }
                }
                for (j=0;j<trans.size();j++){
                    ArrayList<Integer> currentList = trans.get(j);
                    while(currentList.get(j) != -1){
                        if (!l.contains(currentList.get(j))){
                            l.add(currentList.get(j));
                        }
                        j++;
                    }
                }
                Collections.sort(l);

            }else {//2
                System.out.println("Aucune solution");

            }
        }


        Collections.sort(l);
        return l;
    }




    //(obj1.getClass().equals(obj2.getClass())

    public ArrayList<Integer> succ (ArrayList<Integer> p){
        int x;
        ArrayList l;
        ArrayList l2 = new ArrayList();
        for (x=1;x<p.size();x++) {
            l = succ(p.get(x));
            l2.addAll(l);
        }
        Collections.sort(l2);
        return l2;
    }

    public ArrayList<Integer> pred (Integer i) {
        int x,y;
        ArrayList l = new ArrayList();
        ArrayList<Integer> currentList;
        for (x=1;x<trans.size();x++) {
            currentList = trans.get(x);
            for (y = 1; y < currentList.size(); y++) {
                if (i == currentList.get(y)) {
                    l.add(x);
                }
            }
        }
        //Collections.sort(l);
        return l;
    }

    public ArrayList<Integer> pred (ArrayList<Integer> p) {
        int x;
        ArrayList l;
        ArrayList l2 = new ArrayList();
        for (x=1;x<p.size();x++) {
            l = pred(p.get(x));
            l2.addAll(l);
        }
        Collections.sort(l2);
        return l2;
    }



//iterate on the general list
 /*   for(int i = 0 ; i < collection.size() ; i++) {
        ArrayList<String> currentList = collection.get(i);
        //now iterate on the current list
        for (int j = 0; j < currentList.size(); j++) {
            String s = currentList.get(1);
        }
    }

// initialise the collection
    collection = new ArrayList<ArrayList<String>>();
// iterate
    for (ArrayList<String> innerList : collection) {
        for (String string : innerList) {
            // do stuff with string
        }
    }*/

public Object compareType(type t) {
    Integer i = 0;
    String s = "s";
    Boolean b = true;
    switch (type) {
        case INT:
            return i.getClass();

        case STR:
            return s.getClass();

        case BOO:
            return b.getClass();


        default:
            return null;
    }

}

    public enum type {
        INT,
        STR,
        BOO;
    }


}



