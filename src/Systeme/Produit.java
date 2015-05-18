package Systeme;

import java.util.ArrayList;
import java.lang.Object;

public class Produit{
    public ArrayList<Systeme> S;
    public ArrayList<ArrayList<Object>> synchro;
    public ArrayList<Integer> etatP;
    public ArrayList<Integer> initP;
    public ArrayList<ArrayList<Integer>> transP;
    public ArrayList<ArrayList<Boolean>> propP;

    public Produit(Produit P){
        this.S=P.S;
        this.synchro = P.synchro;
    }
/*
    public ArrayList<Systeme> getSyst() {
        return this.S;
    }
*/
    public void setSyst(ArrayList<Systeme> S) {
        this.S = S;
    }


    // à revoir
    public ArrayList etatP(Systeme A, Systeme B){
        ArrayList<ArrayList<Integer>> etatNouveau = new ArrayList();
        int x=0,y;
        while (x<B.etat.size()){
            for(y=0;y<A.etat.size();y++){
                ArrayList etatCourant = new ArrayList();
                etatCourant.add(A.etat.get(y));
                etatCourant.add(B.etat.get(x));
                etatNouveau.add(etatCourant);
            }
            x++;
        }
        return etatNouveau;
    }

    public ArrayList etatP (Produit P){//si possible trier du plus grand au plus petit, et vice et versa
        Systeme X = null;
        int x;
        X.etat=etatP(P.S.get(0),P.S.get(1));
        for(x=2;x<P.S.size();x++){
            X.etat=etatP(X,P.S.get(x));
        }
        return X.etat;
    }

    public ArrayList nomEtiqP(Produit P){
        int x,y;
        ArrayList L = new ArrayList();
        for(x=0;x<P.S.size();x++){
            ArrayList currentList;
            currentList = P.S.get(x).se.nomEtiq;
            for (y=0; y<currentList.size(); y++){
                if (! L.contains(currentList.get(y))){
                    L.add(currentList.get(y));
                }
            }
        }
        return L;
    }

    public ArrayList<ArrayList<Integer>> tradSynchro (Produit P){
       ArrayList<ArrayList<Integer>> F= new ArrayList();
       ArrayList<Integer> G= new ArrayList();
       int x,y;

       for(x=0;x<P.synchro.size();x++){
           ArrayList currentList = P.synchro.get(x);
           for(y=0;y<currentList.size();y++){
               G.add(P.S.get(y).se.nomEtiq.indexOf(currentList.get(y)));
           }
           F.add(G);
       }
       return F;
   }







}