package Systeme;


import java.util.ArrayList;
import java.lang.Object;
import java.util.Arrays;

public class Produit{
    public ArrayList<Systeme> S;
    public ArrayList<ArrayList<Object>> synchro;
    public ArrayList<ArrayList<Integer>> etatP;
    public ArrayList<Integer> initP;
    public ArrayList<ArrayList<Integer>> transP;
    public ArrayList<ArrayList<Boolean>> propP;

    public SystemeElem se;
    private Integer nbSyst = 0;

    public Produit(Produit P){
        S=P.S;
        etatP=etatP(P);
        initP=initP(P);
        transP=transP(P);
        //propP=propP(P);
        this.se.nomEtiq=nomEtiqP(P);
        //this.se.nomProp=nomPropP(P);
        nbSyst=P.S.size();
    }

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
    }

    public ArrayList initP(Produit P){
        int X=1,Y,cpt,x,u,v;
        Systeme A;
        ArrayList<ArrayList> I = new ArrayList();
        ArrayList J = new ArrayList();
        int K;
        for(x=0;x<nbSyst;x++){
            A=P.S.get(x);
            X=X/(A.init.size());
        }
        Y=X;
        for(x=0;x<nbSyst;x++){
            cpt=0;
            A=P.S.get(x);
            while(cpt<Y){
                for(v=0;v<A.init.size();u++){
                    for(u=0;u<X;u++){
                        J=I.get(cpt);
                        J.add(A.init.get(v));
                        I.add(cpt,J);
                    }
                }
            }
        }
        for (x=0;x<I.size();x++){
            K=etatP.indexOf(I.get(x));
            J.add(x,K);//J.add(K);
        }
        return J;
    }

    // � revoir
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
    //n'est plus utile
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

    //Attention, cette version ne prend pas encore en compte le cas suivant:
    //exemple:0->1[a]; 0->2[a]
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
                if(mark < nbSyst){//
                    F = P.etatP.indexOf(D);
                    eti = P.se.nomEtiq.indexOf(etiq);
                    G = P.transP.get(eti);
                    H= (ArrayList) G.get(x);
                    if (H == L){
                        H.remove(-1);
                    }H.add(F);
                }
            }
        }return transP;
    }
/*inutile finalement
    public Boolean verifE(Object o){
        Object t = '_';
        if(o==t) {
            return false;
        }
        else return true;
    }
*/

    public void addTransition(ArrayList sync) {
        synchro.add(sync);
    }

   /* public void addTransition(ArrayList sync, String l) {
        assert (synchro.length == this.sousSysteme.length);
        Bdd res = Bdd.TRUE;
        int cpt = 0;
        for (int s = 0; s < synchro.length; s++) {
            Bdd tmp = synchro[s].equals("_") ? this.sousSysteme[s].boucle() :
                    (Bdd) this.sousSysteme[s].relation.get(((Integer) this.sousSysteme[s].labelSet.get(synchro[s])).intValue());
            tmp = tmp.substitute(this.sousSysteme[s].state, (String[]) Arrays.copyOfRange(this.state, cpt, cpt + this.sousSysteme[s].state.length));
            tmp = tmp.substitute(this.sousSysteme[s].stateP, (String[]) Arrays.copyOfRange(this.stateP, cpt, cpt + this.sousSysteme[s].stateP.length));
            cpt += this.sousSysteme[s].state.length;
            res = res.and(tmp);
        }
        Integer index = (Integer) this.labelSet.get(l);
        if (index == null) {
            this.labelSet.put(l, Integer.valueOf(this.label.size()));
            this.label.add(l);
            this.relation.add(res);
        } else {
            this.relation.set(index.intValue(), ((Bdd) this.relation.get(index.intValue())).or(res));
        }
        initCompleteRelation();
    }*/
}