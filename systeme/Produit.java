package systeme;


import java.util.ArrayList;
import java.lang.Object;
import java.util.Arrays;
import java.util.Collections;
import systeme.SystemeElem;

public class Produit{
    public ArrayList<Systeme> S = new ArrayList();
    public ArrayList<String> nomSysteme = new ArrayList();
    public ArrayList<ArrayList<Object>> synchro = new ArrayList();;
    public ArrayList<ArrayList<Integer>> etatP = new ArrayList();;
    public ArrayList<Integer> initP = new ArrayList();;
    public ArrayList<ArrayList<ArrayList<Integer>>> transP = new ArrayList();;
    public ArrayList<ArrayList<Boolean>> propP = new ArrayList();;

    public SystemeElem se = new SystemeElem();

    private Integer nbSyst = 0;

    public Produit(Produit P){
        S=P.S;
        nbSyst=P.S.size();
        etatP=etatP(S);
        initP=initP(S);
        this.se.nomEtiq=nomEtiqP(S);
        this.se.nomProp=nomPropP(S);
        transP=transP(S);
        //propP=propP(S);
    }

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
    }
//inutil
    public void initSe(){
        se.nomEtiq = new ArrayList();
        se.nomProp = new ArrayList();
    }

    public Produit(String[] nom, Systeme[] systeme){
        ArrayList L = new ArrayList();
        nbSyst = systeme.length;
        Collections.addAll(S, systeme);
        Collections.addAll(nomSysteme, nom);
        etatP = etatP(S);
        initP = initP(S);
        this.se.nomEtiq = nomEtiqP(S);
        this.se.nomProp = nomPropP(S);
        propP(S);
        remplir(S);

    }

    public void synchro (ArrayList<Object> synch){
        synchro.add(synch);
    }

    public ArrayList initP(Systeme S, Systeme T){
        ArrayList<ArrayList> K = new ArrayList();
        ArrayList V=new ArrayList();
        for(int x=0;x<S.init.size();x++) {
            if (V.isEmpty()){
                V.addAll(S.init);}

                for (int y = 0; y < T.init.size(); y++) {
                    ArrayList L = new ArrayList();
                    L.add(V.get(x));

                    L.add(T.init.get(y));
                    K.add(L);
                }

//            }
        }
        return K;
    }

    public ArrayList initP(ArrayList P, Systeme T){ // à finaliser
        ArrayList<ArrayList> K = new ArrayList();
        ArrayList V=new ArrayList();
        for(int x=0;x<K.size();x++) {
            if (V.isEmpty()){
                V.addAll(K);}

            for (int y = 0; y < T.init.size(); y++) {
                ArrayList L = new ArrayList();
                L.add(V.get(x));

                L.add(T.init.get(y));
                K.add(L);
            }

//            }
        }
        return K;
    }

    public ArrayList initP(ArrayList<Systeme> S){
        ArrayList K = new ArrayList();
        K=initP(S.get(0),S.get(1));
        for (int x=2;x<S.size();x++){
            K=initP(K,S.get(x));
        }
        for (int x=0;x<K.size();x++){
            int i = etatP.indexOf(K.get(x));
            initP.add(i);
        }
        return initP;
    }


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

    public ArrayList etatP(ArrayList<ArrayList<Integer>> X, Systeme B){
        ArrayList<ArrayList<Integer>> etatNouveau = new ArrayList();
        int x=0,y;
        while (x<B.etat.size()){
            for(y=0;y<X.size();y++){
                ArrayList etatCourant = new ArrayList();
                etatCourant.add(X.get(y));
                etatCourant.add(B.etat.get(x));
                etatNouveau.add(etatCourant);
            }
            x++;
        }
        return etatNouveau;
    }

    public ArrayList etatP (ArrayList<Systeme> S){//si possible trier du plus grand au plus petit, et vice et versa
        ArrayList<ArrayList<Integer>> etatX;
        int x;
        etatX=etatP(S.get(0), S.get(1));
        for(x=2;x<S.size();x++){
            etatX=etatP(etatX,S.get(x));
        }
        return etatX;
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

    public void remplir(ArrayList<Systeme> S){
        ArrayList<Integer> I = new ArrayList();
        I.add(-1);
        int x=0,y=0;
        for(x=0;x<se.nomEtiq.size();x++){ // attention sens boucle
            ArrayList<ArrayList<Integer>> K = new ArrayList<ArrayList<Integer>>();
            for(y=0;y<etatP.size();y++){
                K.add(I);
            }
            transP.add(K);
        }
    }

    public ArrayList transP (ArrayList<Systeme> S){
        Object etiq=0;
        int x, y, z, A, eti = -1, F, mark, u;
        Object Y=null;
        Object YT = null;
        ArrayList VS;
        Integer C;
        ArrayList<Integer> X,D, E;
        ArrayList<ArrayList<Integer>> B,G,K,J=new ArrayList();
        ArrayList L = new ArrayList();
        L.add(-1);
        Systeme Z;
        for(y=0;y<synchro.size();y++){//on boncle sur les synchro afin de les faire toute
            ArrayList H = new ArrayList();
            VS = synchro.get(y);//VS est un vecteur de synchro choisis dans l'ordre
            for(x=0;x<etatP.size();x++){//on boucle sur les �tat cons�cutivement
                mark=0;
                G=new ArrayList<ArrayList<Integer>>();
                D = new ArrayList();
                K = new ArrayList();
                X = etatP.get(x); //X est un �tat choisis dans l'ordre
                for(z=0;z<nbSyst;z++){//on boucle sur le nombre de systeme afin de trouver l'�lem suivant cde chaque coord
                    Y =  VS.get(z);//Y est une valeur du vecteur de synchro choisis dans l'ordre
                    if((YT == null) && !se.nomEtiq.contains(Y)){
                        YT=Y;
                    }
                    Z = S.get(z);//on pick le systeme associ�
                    A = Z.se.nomEtiq.indexOf(Y);//A vaut la valeur de l'�tiq dans son propre se.etiq
                    if (A!=-1){//donc elle existe
                        etiq=Y;//???????
                    }

                    C = X.get(z);//prend la coordonn� (int) associ� sur l'�tat choisis
                    if(A!=-1) {
                        B = Z.transEtiq.get(A);//r�cup�re la transisiton avec �tiquette a pour les systeme choisis
                        E = B.get(C);//pick la case concern�
                        if(E.equals(L)){//1
                            mark++;
                            if(Y.equals(YT)) {
                                if(G.isEmpty()){
                                    D=new ArrayList();
                                    D.add(C);
                                    G.add(D);
                                }else{
                                    for(int a = 0;a<G.size();a++){
                                        D=G.get(a);
                                        D.add(C);
                                        G.set(a, D);
                                    }

                                }
                            }else{
                                if(G.isEmpty()){
                                    D=new ArrayList();
                                    D.add(-1);
                                    G.add(D);
                                }else{
                                    for(int a = 0;a<G.size();a++){
                                        D=G.get(a);
                                        D.add(-1);
                                        G.set(a, D);
                                    }
                                }
                            }
                        }else{
                            if(G.isEmpty()){
                                for(int b=0;b<E.size();b++) {
                                    D = new ArrayList();
                                    D.add(E.get(b));
                                    G.add(D);
                                }
                            }else{
                                for (int b = 0; b < E.size(); b++) {
                                    for(int a = 0;a<G.size();a++) {
                                        D=new ArrayList<Integer>();
                                        ArrayList<Integer> tmp = G.get(a);
                                        Integer elem = tmp.get(0);
                                        Integer elemCopy=Integer.valueOf(elem);
                                        D.add(elemCopy);
                                        D.add(E.get(b));
                                        K.add(D);
                                    }
                                }
                                G=K;
                            }
                        }
                    }else {//1
                        mark++;
                        if(Y.equals(YT)) {
                            if(G.isEmpty()){
                                D=new ArrayList();
                                D.add(C);
                                G.add(D);
                            }else{
                                for(int a = 0;a<G.size();a++){
                                    D=G.get(a);
                                    D.add(C);
                                    G.set(a, D);
                                }

                            }
                        }else{
                            if(G.isEmpty()){
                                D=new ArrayList();
                                D.add(-1);
                                G.add(D);
                            }else{
                                for(int a = 0;a<G.size();a++){
                                    D=G.get(a);
                                    D.add(-1);
                                    G.set(a, D);
                                }

                            }
                        }
                    }
                }
                ArrayList F2 = new ArrayList();
                if(mark < nbSyst) {//nous permet ici de transformer les (x,y,z) en t, le if semble quant � lui iutile
                    for(int a=0;a<G.size();a++) {
                        F = etatP.indexOf(G.get(a));//r�cup�re l'indice de l'�tat afin d'avoir le changement de "notation"
                        F2.add(F);
                        eti = se.nomEtiq.indexOf(etiq);//r�cup�re l'indice de l'�tiquette dans le celle du produit
                    }
                } else {
                    F2.add(-1);
                }
                H.add(F2);
            }
            ArrayList<ArrayList<Integer>> T = new ArrayList();
            T.add(H);
            transP.remove(eti);
            transP.add(eti, T);
        }
        return transP;
    }


    public boolean isPropP(Object i){
        return this.se.nomProp.contains(i);
    }

    public ArrayList<ArrayList<Boolean>> initStatePropertyP() {

        int x,y;
        ArrayList<ArrayList<Boolean>> T = new ArrayList<ArrayList<Boolean>>();
        for(x=0;x<se.nomProp.size();x++){
            ArrayList<Boolean> S = new ArrayList();
            for(y=0;y<etatP.size();y++){
                S.add(false);
            }
            T.add(S);
        }
        propP = T;
        return propP;
    }

    public void propP(ArrayList<Systeme> S) {
        ArrayList<Boolean> X;
        Boolean C;
        int cte;
        Integer A;
        if (propP.isEmpty()){
            propP=initStatePropertyP();
        }
        for(int x=0;x<etatP.size();x++){
            cte =0;
            for (int y=0;y<nbSyst;y++){
                int M = S.get(y).se.nomProp.size()-1;

                for(int z=0;z<S.get(y).se.nomProp.size();z++){
                    X = propP.get(y+z+(M*cte));//c'est une ligne de propP
                    A=etatP.get(x).get(y);//une "coordonnée" de l'etat
                    C=S.get(y).prop.get(z).get(A);
                    if (C==true) {
                        X.set(x, C);//on modifie X au point y+z+cte
                    }
                }
                cte++;
            }
        }
    }

    public ArrayList nomPropP(ArrayList<Systeme> S) {
        ArrayList X = new ArrayList();
        for (int x =0; x<S.size();x++){
            for (int y=0; y<S.get(x).se.nomProp.size();y++){
                X.add(S.get(x).se.nomProp.get(y) + "." + nomSysteme.get(x));
            }
        }
        return X;
    }


    public String toDot() {
        if (initP==null) {
            return "digraph system {\n empty [shape=box]}\n";
        }
        StringBuilder res = new StringBuilder();
        res.append("digraph system {\n");

        recToDotState(res);

        recToDotProp(res);

        toDotTransition(res);

        res.append("}\n");
        return res.toString();
    }


    private void recToDotProp(StringBuilder res) {
        int x,y,Y=0;
        Boolean X;
        if (propP == null) {
            return;
        }
        if (propP != null) {
            for (y=0;y<propP.get(0).size();y++){
                ArrayList L = new ArrayList();
                for(x=0;x<propP.size();x++) {
                    X=propP.get(x).get(y);
                    if(X==true){
                        L.add(se.nomProp.get(x));
                        Y = y;
                    }
                }
                res.append(Y + " [label= \"" + etatP.get(Y) + L +"\"];\n");
            }
        }
    }


    private void recToDotState(StringBuilder res) {
        int x;
        if (initP == null) {
            return;
        }

        if (initP != null) {
            for(x=0;x<initP.size();x++) {
                res.append("_" + initP.get(x) + "[[label= \"" + etatP.get(initP.get(x)) +" shape=none\"];\n");
                res.append("_" + initP.get(x) + "->" + initP.get(x) + ";\n");
            }
        }
    }

    private void toDotTransition(StringBuilder res) {//� modifier
        int x, y, z;
        ArrayList J = new ArrayList();
        J.add(-1);
        ArrayList L;
        ArrayList<ArrayList> M;
        for (x=0;x<transP.size();x++){
            L=transP.get(x);
            for (y=0;y<L.size();y++) {
                M = (ArrayList) L.get(y);
                if (L.get(y)!= J)
                    for (z = 0; z < M.size(); z++) {
                        if (!M.get(z).equals(J)){
                            for(int u = 0;u<M.get(z).size();u++){
                                if (!M.get(z).get(u).equals(-1)){
                                    res.append(z + "->" + M.get(z).get(u) + " [label= \"" + se.nomEtiq.get(x) + "\"];\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }