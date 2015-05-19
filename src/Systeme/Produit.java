package Systeme;


import java.util.ArrayList;
import java.lang.Object;

public class Produit{
    public ArrayList<Systeme> S;
    public ArrayList<ArrayList<Object>> synchro;
    public ArrayList<ArrayList<Integer>> etatP;
    public ArrayList<Integer> initP;
    public ArrayList<ArrayList<Integer>> transP;
    public ArrayList<ArrayList<Boolean>> propP;
    public Integer trans[][][];
    public SystemeElem se;
    private Integer nbSyst = 0;

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
/*
    public ArrayList<ArrayList> repairEtiq(Produit P){
        ArrayList<ArrayList<Integer>> X = new ArrayList();
        int x,y;
        for(x=0;x<P.S.size();x++){


            for(y=0;y<P.S.get(x).se.nomEtiq.size();y++){
                ArrayList<Integer> Y = new ArrayList();
                Y.add(P.S.get(x).se.nomEtiq.indexOf(P.se.nomEtiq.get(y)));
            }
        }

    }

        */

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

    public ArrayList<ArrayList<ArrayList<Integer>>> remplir(Produit P){
        ArrayList<ArrayList<ArrayList<Integer>>> J = new ArrayList();

        ArrayList<Integer> I = new ArrayList();
        I.add(-1);
        int x=0,y=0;
        while (x<P.se.nomEtiq.size()){ // attention sens boucle
            ArrayList<ArrayList<Integer>> K = J.get(x);
            while(y<P.etatP.size()){
                ArrayList<Integer> L = K.get(y);
                L=I;
            }
        }
        return J;
    }


    public ArrayList transP (Produit P){
        Object etiq=0;
        int x, y, z, A, eti, F, mark, u;
        Object Y;
        ArrayList X, VS, C = null, G, H, E;
        ArrayList<ArrayList<Integer>> B;
        ArrayList D;
        ArrayList L = new ArrayList();
        L.add(-1);
        Systeme Z;
        for(x=0;x<etatP.size();x++){
            X = etatP.get(x);
            for(y=0;y<synchro.size();y++){
                mark=0;
                VS = synchro.get(y);
                D = new ArrayList();
                for(z=0;z<nbSyst;z++){
                    Y =  VS.get(z);
                    Z = S.get(z);
                    A = Z.se.nomEtiq.indexOf(Y);
                    if (A!=-1){
                        etiq=Y;
                    }
                    C = (ArrayList) X.get(z);
                    if(A!=-1) {
                        u = (int) C.get(0);
                        B = Z.transEtiq.get(A);
                        E = B.get(u);
                        if(E!=L){
                            D.add(E);
                        }else{
                            D.add(C);
                            mark++;
                        }
                    }else{
                        D.add(C);
                        mark++;
                    }
                }
                if(mark < nbSyst){
                    F = P.etatP.indexOf(D);
                    eti = P.se.nomEtiq.indexOf(etiq);
                    G = P.transP.get(eti);
                    H= (ArrayList) G.get(x);
                    if (H == L){
                        H.remove(-1);
                        H.add(F);
                    }
                }
            }
        }return transP;
    }
}