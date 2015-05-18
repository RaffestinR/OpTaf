package Systeme;

import Systeme.SystemeElem;

import java.lang.reflect.Array;
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

    public ArrayList succ (Object i){
        int x,lt;
        ArrayList l = new ArrayList();
        if(i.getClass().equals(compareType(type.INT))){
            ArrayList<Integer> currentList;
            currentList = trans.get(i);// à corriger
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
                    ArrayList<ArrayList<Integer>> currentList = transEtiq.get(j);//attention au type du table potentiellement un string
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
                for(z=0;z<X.size();z++){//warning sur z, i avant
                    if (X.get(z)==true){
                        tmp.add(z);
                    }
                }
                for (j=0;j<trans.size();j++){
                    ArrayList<Integer> currentList = trans.get(j);
                    while(currentList.get(j) != -1){//on doit retirer la première ligne du tableau
                        if (!l.contains(currentList.get(j))){
                            l.add(currentList.get(j));
                        }
                        j++;
                    }
                }
            }else {//2
                System.out.println("Aucune solution");
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

    public ArrayList<Integer> predFct (Object i,type t){
        int x,y;
        ArrayList l = new ArrayList();
        ArrayList currentList;
        for (x=1; x<selectType(t).size() ;x++) {
            currentList = (ArrayList) selectType(t).get(x);
            for (y = 1; y < currentList.size(); y++) {
                if (i == currentList.get(y) && !l.contains(currentList.get(y))) {
                    l.add(x);
                }
            }
        }
        return l;
    }

    public ArrayList pred (Object i) {
        ArrayList l = new ArrayList();
        if(i.getClass().equals(compareType(type.INT))){
            l= predFct(i,type.INT);
        }
        if(i.getClass().equals(compareType(type.STR))){
            if (se.nomEtiq.contains(i) && se.nomProp.contains(i)){
                System.out.println("Problème de confusion lors des initialisations des propriétées et étiquettes");
                l = null;
            }else if (se.nomEtiq.contains(i)){
                l= predFct(i,type.STR);//attrention à vérifier avec la construction du tableau (ici string) surement à changer.
            }else if (se.nomProp.contains(i)){
                int x,y,z;
                ArrayList S = new ArrayList();
                ArrayList T;

                for(x=0;x<se.nomProp.size();x++){
                    if (se.nomProp.get(x)==i){
                        break;
                    }
                }
                for (y=0; y<prop.size() ; y++){
                    T=prop.get(y);
                    if(T.get(x)==i){
                        S.add(y);
                    }
                }
                for (z=0;z<S.size();z++){
                    l.addAll(predFct(S.get(z),type.INT));
                }
            }else {//2
                System.out.println("Aucune solution");
                l = null;
            }
        }
        Collections.sort(l);
        return l;
    }

    public ArrayList<Integer> pred (ArrayList p){
        int x;
        ArrayList l2 = new ArrayList();
        for (x=0 ; x<p.size();x++) {
            l2.add(pred(p.get(x)));
        }
        Collections.sort(l2);
        return l2;
    }

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

    public ArrayList selectType(type t) {

        switch (t) {
            case INT:
                return trans;

            case STR:
                return transEtiq;

            default:
                return null;
        }
    }

    public enum type {
        INT,
        STR;
    }
}