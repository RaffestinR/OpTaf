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
    public ArrayList<ArrayList<Integer>> pred = new ArrayList();

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
        propP(S);
    }

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
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
        System.out.println("transP : " + transP);
        remplir(S);
        System.out.println("transP : " + transP);

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



    public ArrayList<ArrayList<ArrayList<Integer>>> transP (ArrayList<Systeme> S){
        System.out.println("transP : " + transP);
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
        }System.out.println("transP : " + transP);
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
        System.out.println("test3");
        this.test();
        System.out.println("test4");
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
    public void test(){
        //System.out.println("A");
        System.out.println("etatP : " + etatP);
        //T2.add(0);System.out.println("T2 : " + T2);
        ArrayList<Integer> T = new ArrayList();
        ArrayList<Integer> T2 = new ArrayList();
        ArrayList<Object> T3 = new ArrayList();
        ArrayList<Object> T4 = new ArrayList();
        T.add(1);
        T2.add(0);System.out.println("T2 : " + T2);
        succ(T2);

        System.out.println("succ(T2) ===========> " + succ(T2));
        T2.add(2);System.out.println("T2 : " + T2);
            succ(T2);System.out.println("succ(T2)2 ===========> " + succ(T2));
        T3.add(se.nomEtiq.get(0));
        etiquette(T3);
       System.out.println("etiquette(T3);[a] ===========> " + etiquette(T3));
        succ2(T3);System.out.println("succ2 etiq(T3)[a] ===========> " + succ2(T3));
        T3.add(se.nomEtiq.get(1));
        etiquette(T3);System.out.println("etiquette(T3)[a,c] ===========> " + etiquette(T3));
        succ2(T3);System.out.println("succ2 etiq(T3)[a,c] ===========> " + succ2(T3));
        T4.add(se.nomProp.get(1));
        succ2(T4);System.out.println("~~~~~~~~~~~~~~~~succ2 prop(T4)[x]~~~~~~~~~~~~~~~~~~~~~~");
        succ2(T4);System.out.println("succ2 prop(T4)[x] : " + succ2(T4));
        T4.add(se.nomProp.get(2));
        succ2(T4);System.out.println("~~~~~~~~~~~~~~~~succ2 prop(T4)[x,z]~~~~~~~~~~~~~~~~~~~~~~");
        succ2(T4);System.out.println("succ2 prop(T4)[x,z] : " + succ2(T4));

        //System.out.println("B");
        succ(T);
        //System.out.println("succ(1)" + succ(T));
        pred(etatP.size(), 0, 0);
        ArrayList<Object> TT = new ArrayList();
        TT.add(se.nomEtiq.get(0));
        //System.out.println("TT : " + TT);

        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        EX(TT);
        System.out.println("EX(TT)" + EX(TT));
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        AX(TT);
        System.out.println("AX(TT)" + AX(TT));
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        EXAX(TT);
        System.out.println("EXAX(TT)" + EXAX(TT));
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        AXEX(TT);
        System.out.println("AXEX(TT)" + AXEX(TT));


        //System.out.println("pred" + pred);

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
                res.append("_" + initP.get(x) + "[label= \"" + etatP.get(initP.get(x)) +" shape=none\"];\n");
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

    public ArrayList<Integer> succ (ArrayList<Integer> I){
        //System.out.println("-------Succ(int) départ  : ");
        ArrayList A = new ArrayList();
        ArrayList T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
        for(int x=0; x<I.size();x++){

            for(int y =0; y<transP.size();y++){
               // System.out.println("x/y :  " + x+"/"+y);
                //System.out.println("transEtiq  : " + transP);
                //System.out.println("I  : " + I);
                //System.out.println("I.get(x)  : " + I.get(x));
                //System.out.println("transEtiq.get(y);  : " + transP.get(y));

                //System.out.println("transEtiq.get(y).get(0);  : " + transP.get(y).get(0));//le tableau transP semble mal construit
                A=transP.get(y).get(0);
//                A=transP.get(y).get(I.get(x));
                if(!A.equals(T)){
                  //     System.out.println("L  : " + L);
                    //L.addAll(A);
                    //for (int z=0;z<A.size();z++){
                    //         System.out.println("L / A.get(z) : " + L+" / " +A.get(I.get(x)));
                        if (!L.contains(A.get(I.get(x))) && !A.get(I.get(x)).equals(T)){
                            L.add(A.get(I.get(x)));
                        }
                      //     System.out.println("L  : " + L);
                   // }
                    //System.out.println("L  : " + L);
                }

            }
        }System.out.println("succ 2  : " + L);
        return L;
    }

    public ArrayList<Integer> succ2 (ArrayList<Object> I){
        //System.out.println("-------Succ2 départ  : ");
        System.out.println("I  : " + I);

        ArrayList<Integer> A = new ArrayList();
        ArrayList<Integer> T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
//        System.out.println("se.nomEtiq.contains(I.get(0))  : " + se.nomEtiq.contains(I.get(0)));
//        System.out.println("se.nomProp.contains(I.get(0))  : " + se.nomProp.contains(I.get(0)));
//        System.out.println("se.nomEtiq.contains(I.get(0)) && se.nomProp.contains(I.get(0))  : " + (se.nomEtiq.contains(I.get(0)) && se.nomProp.contains(I.get(0))));
        if (se.nomEtiq.contains(I.get(0)) && se.nomProp.contains(I.get(0))){
            System.out.println("problème lors de la différenciation entre étiquette et propriété");
        }
       // System.out.println("nomEtiq" + se.nomEtiq);
        //System.out.println("transP" + transP);
        if (se.nomEtiq.contains(I.get(0))){

            for(int x=0;x<I.size();x++) {
               // System.out.println("x  : " + x);
                int a = se.nomEtiq.indexOf(I.get(x));
               // System.out.println("a  : " + a);
                A=transP.get(a).get(0);
                //System.out.println("A  : " + A);
                for(int y=0;y<etatP.size();y++){
//                    System.out.println("transP  : " + transP);
//                    System.out.println("transPgx  : " + transP.get(a));
//                    System.out.println("transPgxg0  : " + transP.get(a).get(0));
//                    System.out.println("transPgxg0gy  : " + transP.get(a).get(0).get(y));
//                    System.out.println("A.ghet(y)  : " + A.get(y));
//                    System.out.println("y  : " + y);
//                    System.out.println("L  : " + L);
//                    System.out.println("!A.equals(T) : " + (!A.equals(T) ));
//                    System.out.println("!L.contains(A.get(y))  : " + (!L.contains(A.get(0))));
                    //System.out.println("!A.get(y).equals(T) && !L.contains(A.get(y))  : " + (!A.get(0).equals(T) && !L.contains(A.get(y))));
                    if((!A.equals(T))){
                       // System.out.println("L  : " + L);
                        for (int z=0;z<A.size();z++){

                          //  System.out.println("A : " + A.get(0));
                           // System.out.println("Aget(y)  : " + A.get(z));
                            if((!L.contains(A.get(z))) ){

                               // System.out.println("(test)  : ");

                                L.add(A.get(z));
                            }
                            //System.out.println("L  : " + L);
                        }
                    }
                }

            }System.out.println("verif  : " );
            //return L;

        }else if (se.nomProp.contains(I.get(0))){
            System.out.println("verif2  : " );
            ArrayList<Integer> L2 = new ArrayList();
            ArrayList<Integer> L3 = new ArrayList();
            for(int x=0;x<I.size();x++) {
                int a = se.nomProp.indexOf(I.get(x));
                //System.out.println("a : "+a);
                A=transP.get(a).get(0);
                //System.out.println("A : "+A);
                for(int y =0;y<A.size();y++){
                    //System.out.println("prop.get(a).get(y) : "+prop.get(a).get(y));
                    if(propP.get(a).get(y)){
                        //System.out.println("L2 : "+L2);
                        L2.add(y);
                        //System.out.println("L2 : " + L2);
                    }
                }
                for(int y=0;y<L2.size();y++){
                    //System.out.println("L : "+L);
                    L3=succ(L2);
                    for(int z=0;z<L3.size();z++) {
                        if (!L.contains(L3.get(z))){
                            L.add(L3.get(z));
                        }
                    }
                    //System.out.println("L : "+L);
                }
            }
            //System.out.println("L F: "+L);
            //return L;

        }else System.out.print("Aucune solution possible avec cette entrée");
        System.out.println("LOLCAT  : ");
        //Collections.sort(L);
        L.remove(T);
        System.out.println("succ 2  : " + L);
      //  System.out.println("LOL  : ");
      //  L.remove(-1);
        return L;

    }
    public ArrayList<Integer> etiquette(ArrayList<Object> p){
        //System.out.println("A");
        ArrayList<Integer> L = new ArrayList();
        ArrayList T= new ArrayList();
        T.add(-1);
        //System.out.println("B p : " + p);
        for(int x=0;x<p.size();x++){
            System.out.println("C p.get(x) : " + p.get(x));
            //System.out.println("se.nomEtiq : " + se.nomEtiq);
            int a = se.nomEtiq.indexOf(p.get(x));

            System.out.println("transP  : " + transP);
                   System.out.println("transPgx  : " + transP.get(a));

            //System.out.println("D a : " + a + " / transE : " + transEtiq);
            ArrayList<ArrayList<Integer>> P = transP.get(a);
            System.out.println("P : " + P);
            for (int y=0; y<P.get(0).size();y++){
                // System.out.println("F");
                System.out.println("transPgxg0gy  : " + transP.get(a).get(0).get(y));
                ArrayList<Integer> Q = transP.get(a).get(0);//P.get(y);
                System.out.println("Q : " + Q);
                System.out.println("Qgy : " + Q.get(y));
                //System.out.println("G");
               // System.out.println("!Q.equals(T) : " + !Q.equals(T));

                    for(int z=0;z<Q.size();z++){
                      //  System.out.println("TEST: ");
                    if ((!L.contains(y))){
                    //for(int z=0; z<etatP.size();z++){
                        //if(!Q.get(z).equals(T)){
                    System.out.println("Lav : " + L);
                            L.add(y);
                    System.out.println("Lap : " + L);
                        // }


                    //System.out.println("I");
                }}
            }//System.out.println("J");
        }//System.out.println("OK etiq : " + L);
        L.remove(T);
        System.out.println("L : " + L);
        return L;
    }

    public ArrayList propriete(ArrayList<Object> p){
        ArrayList<Object> L = new ArrayList();

        for(int x=0;x<p.size();x++){
            int a = propP.indexOf(p.get(x));
            ArrayList<Boolean> P = propP.get(a);
            for (int y=0; y<P.size();y++){
                if (P.get(y)==true){
                    L.add(y);
                }
            }
        }//System.out.println("K prop : " + L);
        return L;
    }

    public ArrayList<ArrayList<Integer>> pred (/*Systeme S,*/int nbEtat, int ini, int N){
        //System.out.println("1");
        ArrayList T=new ArrayList();
        T.add(-1);
        //System.out.println("2");
        //System.out.println("pred" + pred);
        if(this.pred.isEmpty()){
            //System.out.println("3");
            for (int x = 0; x<nbEtat;x++){
                //System.out.println("4");
                pred.add(T);
                //System.out.println("5");
                //System.out.println("predIni : " + pred);
            }
            //System.out.println("6");
        }
        //System.out.println("7");
        //System.out.println("pred : " + pred);

        if(nbEtat==0){
            //System.out.println("8 if");
            return null;}
        else if (nbEtat==1){
            //System.out.println("9 else if");
            for(int x=0;x<transP.size();x++){
                //System.out.println("10.1 x: " + x);
                ArrayList<Integer> X=transP.get(x).get(ini);
                //System.out.println("10.2 X : " + X);
                if(!X.equals(T)){
                    //System.out.println("11");
                    for(int y=0;y<X.size();y++){
                        //System.out.println("12.1 y : " + y);
                        //System.out.println("12.2 pred.get(X.get(y)): " + pred.get(X.get(y)));
                        if(pred.get(X.get(y)).equals(T)){
                            //System.out.println("13 X.get(y) : " + X.get(y));
                            ArrayList<Integer> R = new ArrayList<Integer>();
                            R.add(ini);
                            //System.out.println("14 R : " + R);
                            pred.set(X.get(y), R);
                            //System.out.println("15 pred : " + pred);
                        }else {
                            //System.out.println("16");
                            if(!pred.get(X.get(y)).contains(ini)){
                                pred.get(X.get(y)).add(ini);
                            }
                            //System.out.println("17");
                        }
                    }
                }
            }
        }else {//System.out.println("18");
            int M = nbEtat / 2;
            N=N+M;
            //System.out.println("-----------19--------pred(/*S,*/M, ini, N) / M : "+M+" /ini : "+ini+" /N : "+ N);
            pred(/*S,*/M, ini, N);
            //System.out.println("-----------20-----------pred(/*S,*/nbEtat-M,ini+M,N) / M(nbE-ini) : " + (nbEtat - M) + " /ini+M : " + (ini+M)+" /N : "+ N);
            pred(/*S,*/nbEtat - M, ini + M, N);//System.out.println("21");
        }
        //System.out.println("22");
        return pred;
    }

    public ArrayList<Integer> EX(ArrayList<Object> p){
        // System.out.println("1");
        ArrayList<Integer> T = etiquette(p);
        //   System.out.println("2");
        ArrayList<Integer> L = new ArrayList();
        //   System.out.println("3");
        for(int x=0;x<transP.size();x++){
            //      System.out.println("4");
            for (int y=0; y<transP.get(x).size();y++){
                //       System.out.println("5");
                for(int z=0; z<T.size();z++) {
                    //          System.out.println("6");
                    if (transP.get(x).get(y).contains(T.get(z)) && !L.contains(y)){
                        //        System.out.println("7");
                        L.add(y);
                        //       System.out.println("8");
                        break;
                    }//System.out.println("9");
                }//System.out.println("10");
            }//System.out.println("11");
        }//System.out.println("12");
        Collections.sort(L);
        //  System.out.println("K EX : " + L);
        return L;

    }

    public ArrayList<Integer> AX(ArrayList<Object> p){
        ArrayList<Integer> T = etiquette(p);
        System.out.println("T : " + T);
        ArrayList<Integer> L = new ArrayList();
        int cpt;
        for(int x=0;x<transP.size();x++){
            // System.out.println("x : " + x);
            for (int y=0; y<transP.get(x).size();y++){
                // System.out.println("y : " + y);
                cpt=0;
                ArrayList<Integer> P = transP.get(x).get(y);
                // System.out.println("transEtiq.get(x).get(y) : " + transEtiq.get(x).get(y));
                for(int z=0;z<P.size();z++){
                    //  System.out.println("z : " + z);
                    //  System.out.println("P.get(z) : " + P.get(z));
                    if(T.contains(P.get(z))){
                        cpt++;
                    }else break;
                }//System.out.println("cpt : " + cpt);
                // System.out.println("P.size() : " + P.size());
                ArrayList M = new ArrayList();
                M.add(y);
                if (cpt==succ(M).size())
                    L.add(y);
            }
        }
        //  Collections.sort(L);System.out.println("K AX : " + L);
        return L;

    }

    public ArrayList<Integer> AXEX(ArrayList<Object> p){
        //System.out.println("_________________________");
        ArrayList T=new ArrayList();
        T.add(-1);
        ArrayList<Integer> L = new ArrayList();
        ArrayList<Integer> S = EX(p);
        ArrayList<Integer> A;
        // System.out.println("p : " + p);
        // System.out.println("S : " + S);

        if(pred.isEmpty()){
            pred(etatP.size(), 0, 0);}

        for (int x=0; x<etatP.size();x++){int cpt=0;
            ArrayList<Integer> B= new ArrayList<Integer>();
            // System.out.println("B état ini : " + B);
            B.add(x);
            // System.out.println("B état pick : " + B);
            A=succ(B);
            //  System.out.println("A succ(état) : " + A);

            //  System.out.println("S AX(p) : " + S);
            //   System.out.println("S.contains(A) : " + S.contains(A));
            /*if(S.contains(A)){
                L.add(etat.get(x));
            }*/
            for(int y=0; y<A.size();y++){
                //  System.out.println("S.contains(A) ac y : " + S.contains(A.get(y)));

                if(S.contains(A.get(y))){
                    cpt++;
                }
            }

            if (cpt==A.size()){
                L.add(x);
            }
        }
        //  System.out.println("L AXEX : " + L);
        return L;
    }

    public ArrayList<Integer> EXAX(ArrayList<Object> p) {
        // System.out.println("L : " + L);
        ArrayList T=new ArrayList();
        T.add(-1);
        ArrayList<Integer> L = new ArrayList();
        ArrayList<Integer> S = AX(p);
        if(pred.isEmpty()){
            pred(etatP.size(), 0, 0);}
        //System.out.println("pred : " + pred);
        //System.out.println("S : "+ S);
        for(int x=0;x<T.size();x++){
            ArrayList<Integer> M = new ArrayList<Integer>();
            M.add(S.get(x));
            //    System.out.println("M : " + M);
            //   System.out.println("T : " + T);
            //   System.out.println("M : " + M);
            //System.out.println("Lav : " + L);
//            if(!(pred.get(S.get(x))).equals(T)){
            //   System.out.println("succ(M) : " + succ(M));
            //   System.out.println("L : " + L);
            //  System.out.println("pred : " + pred);
            L.addAll(pred.get(S.get(x)));
            //  System.out.println("L : " + L);
            //System.out.println("Lap : " + L);
            // }
        }//System.out.println("LF : "+ L);
        //M=succ(L);//System.out.println("M EXAX : " + M);
        return L;
    }



}