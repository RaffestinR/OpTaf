package systeme;


import java.util.ArrayList;
import java.lang.Object;
import java.util.Arrays;

public class Produit{
    public ArrayList<Systeme> S = new ArrayList();
    public ArrayList<ArrayList<Object>> synchro = new ArrayList();;
    public ArrayList<ArrayList<Integer>> etatP = new ArrayList();;
    public ArrayList<Integer> initP = new ArrayList();;
    public ArrayList<ArrayList<Integer>> transP = new ArrayList();;
    public ArrayList<ArrayList<Boolean>> propP = new ArrayList();;

    public SystemeElem se;
    private Integer nbSyst = 0;

    public Produit(Produit P){
        S=P.S;
        etatP=etatP(S);
        initP=initP(S);
        transP=transP(S);
        //propP=propP(S);
        this.se.nomEtiq=nomEtiqP(S);
        //this.se.nomProp=nomPropP(S);
        nbSyst=P.S.size();
    }

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
    }

    public ArrayList initP(ArrayList<Systeme> S){
        int X=1,Y,cpt,x,u,v;
        Systeme A;
        ArrayList<ArrayList> I = new ArrayList();
        ArrayList J = new ArrayList();
        int K;
        for(x=0;x<nbSyst;x++){
            A=S.get(x);
            X=X/(A.init.size());
        }
        Y=X;
        for(x=0;x<nbSyst;x++){
            cpt=0;
            A=S.get(x);
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

    public ArrayList etatP (ArrayList<Systeme> S){//si possible trier du plus grand au plus petit, et vice et versa
        Systeme X = null;
        int x;
        X.etat=etatP(S.get(0),S.get(1));
        for(x=2;x<S.size();x++){
            X.etat=etatP(X,S.get(x));
        }
        return X.etat;
    }

    public ArrayList nomEtiqP(ArrayList<Systeme> S){
        int x,y;
        ArrayList L = new ArrayList();
        for(x=0;x<S.size();x++){
            ArrayList currentList;
            currentList = S.get(x).se.nomEtiq;
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
    public ArrayList<ArrayList<Integer>> tradSynchro (ArrayList<Systeme> S){
       ArrayList<ArrayList<Integer>> F= new ArrayList();
       ArrayList<Integer> G= new ArrayList();
       int x,y;

       for(x=0;x<synchro.size();x++){
           ArrayList currentList = synchro.get(x);
           for(y=0;y<currentList.size();y++){
               G.add(S.get(y).se.nomEtiq.indexOf(currentList.get(y)));
           }
           F.add(G);
       }
       return F;
   }

    public ArrayList<ArrayList<ArrayList<Integer>>> remplir(ArrayList<Systeme> S){
        ArrayList<ArrayList<ArrayList<Integer>>> J = new ArrayList();

        ArrayList<Integer> I = new ArrayList();
        I.add(-1);
        int x=0,y=0;
        while (x<se.nomEtiq.size()){ // attention sens boucle
            ArrayList<ArrayList<Integer>> K = J.get(x);
            while(y<etatP.size()){
                ArrayList<Integer> L = K.get(y);
                L=I;
            }
        }
        return J;
    }

    //Attention, cette version ne prend pas encore en compte le cas suivant:
    //exemple:0->1[a]; 0->2[a]
    public ArrayList transP (ArrayList<Systeme> S){
        Object etiq=0;
        int x, y, z, A, eti, F, mark, u;
        Object Y;
        ArrayList VS,  G, H, E;
        Integer C = 0;
        ArrayList<Integer> X;
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
                    C = X.get(z);
                    if(A!=-1) {
                        //u = (int) C.get(0);
                        B = Z.transEtiq.get(A);
                        E = B.get(C);
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
                    F = etatP.indexOf(D);
                    eti = se.nomEtiq.indexOf(etiq);
                    G = transP.get(eti);
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
*/  public void synchro (ArrayList<Object> synch){
       synchro.add(synch);
    }


    public Produit(String[] nom, Systeme[] systeme){//surement des rajout à faire
        ArrayList L = new ArrayList();
        nbSyst = systeme.length;
        for(int i=0;i<nbSyst;i++){
            S.get(i).nomSousSysteme[0]=nom[i];
            S.get(i).sousSysteme[0]=systeme[i];
            L.add(systeme[i]);
        }
        initP = initP(L);
        etatP = etatP(L);
        transP = transP(L);
        //propP = propP(L);
        se.nomEtiq = nomEtiqP(L);
        //se.nomProp = nomPropP(L);

    }

    public String toDot() {
        if (initP==null) {
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
        if (initP == null) {
            return;
        }

        if (initP != null) {
            for(x=0;x<initP.size();x++) {
                res.append("_" + initP.get(x) + "[label=\"\", shape=none ];\n");
                res.append("_" + initP.get(x) + "->" + initP.get(x) + ";\n");
            }
        }
    }

    private void toDotTransition(StringBuilder res) {//à modifier
        int x, y, z;
        ArrayList J = new ArrayList();
        J.add(-1);
        ArrayList L;
        ArrayList M;
        for (x=0;x<transP.size();x++){
            L=transP.get(x);
            for (y=0;y<L.size();y++) {
                M = (ArrayList) L.get(y);
                if (L.get(y)!= J)
                    for (z = 0; z < M.size(); z++) {
                        res.append(y + "->" + M.get(z) + " [label= \"" + se.nomEtiq.get(x) + "\"];\n");
                    }
            }
        }
    }
}