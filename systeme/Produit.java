package systeme;


import java.util.ArrayList;
import java.lang.Object;
import java.util.Collections;

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

    /**
     * Constructeur du produit de synchronisation
     * @param nom
     * @param systeme
     */
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

    /**
     * remplis le tableau de syncrhonisation dans Antlr
     * @param synch
     */
    public void synchro (ArrayList<Object> synch){
        synchro.add(synch);
    }

    /**
     * Détermine les états initiaux à l'aide de deux systèmes
     * @param S
     * @param T
     * @return
     */
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

    /**
     * Détermine les états initiaux à l'aide d'un système et d'une list de systèmes
     * @param P
     * @param T
     * @return
     */
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
        }
        return K;
    }

    /**
     * Détermine les états initiaux à l'aide d'une list de systèmes
     * @param S
     * @return
     */
    public ArrayList initP(ArrayList<Systeme> S){
        ArrayList K;
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

    /**
     * Détermine les états existant dans le produit synchronisé à l'aide de deux systèmes
     * @param A
     * @param B
     * @return
     */
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

    /**
     * Détermine les états existant dans le produit synchronisé l'aide d'un système et d'une list de systèmes
     * @param X
     * @param B
     * @return
     */
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

    /**
     * Détermine les états existant dans le produit synchronisé l'aide dd'une list de systèmes
     * @param S
     * @return
     */
    public ArrayList etatP (ArrayList<Systeme> S){//si possible trier du plus grand au plus petit, et vice et versa
        ArrayList<ArrayList<Integer>> etatX;
        int x;
        etatX=etatP(S.get(0), S.get(1));
        for(x=2;x<S.size();x++){
            etatX=etatP(etatX,S.get(x));
        }
        return etatX;
    }

    /**
     * determine les propriété associé au produit
     * @param S
     * @return
     */
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

    /**
     * inisialise le tableau de transition du produit
      * @param S
     */
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

    /**
     * Détermine les relations de transitions du produit
     * @param S
     * @return
     */
    public ArrayList<ArrayList<ArrayList<Integer>>> transP (ArrayList<Systeme> S){
        System.out.println("transP : " + transP);
        Object etiq=0;
        int x, y, z, A, eti = -1, F, mark;
        Object Y;
        Object YT = null;
        ArrayList VS;
        Integer C;
        ArrayList<Integer> X,D, E;
        ArrayList<ArrayList<Integer>> B,G,K;
        ArrayList L = new ArrayList();
        L.add(-1);
        Systeme Z;
        for(y=0;y<synchro.size();y++){
            ArrayList H = new ArrayList();
            VS = synchro.get(y);
            for(x=0;x<etatP.size();x++){
                mark=0;
                G=new ArrayList<ArrayList<Integer>>();
                K = new ArrayList();
                X = etatP.get(x);
                for(z=0;z<nbSyst;z++){
                    Y =  VS.get(z);
                    if((YT == null) && !se.nomEtiq.contains(Y)){
                        YT=Y;
                    }
                    Z = S.get(z);
                    A = Z.se.nomEtiq.indexOf(Y);
                    if (A!=-1){
                        etiq=Y;
                    }
                    C = X.get(z);
                    if(A!=-1) {
                        B = Z.transEtiq.get(A);
                        E = B.get(C);
                        if(E.equals(L)){
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
                    }else {
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
                if(mark < nbSyst) {
                    for(int a=0;a<G.size();a++) {
                        F = etatP.indexOf(G.get(a));
                        F2.add(F);
                        eti = se.nomEtiq.indexOf(etiq);
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

    /**
     * vérifie si la propriété existe dans le système
     * @param i
     * @return
     */
    public boolean isPropP(Object i){
        return this.se.nomProp.contains(i);
    }

    /**
     * Initialise le tableau de booleans à false
     * @return
     */
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

    /**
     * Fonction déterminant le tableau de propriété du produit.
     * @param S
     */
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
                    X = propP.get(y+z+(M*cte));
                    A=etatP.get(x).get(y);
                    C=S.get(y).prop.get(z).get(A);
                    if (C==true) {
                        X.set(x, C);
                    }
                }
                cte++;
            }
        }
    }

    /**
     * Permet de distinguer les propriété de plusieurs système
     * @param S
     * @return
     */
    public ArrayList nomPropP(ArrayList<Systeme> S) {
        ArrayList X = new ArrayList();
        for (int x =0; x<S.size();x++){
            for (int y=0; y<S.get(x).se.nomProp.size();y++){
                X.add(S.get(x).se.nomProp.get(y) + "." + nomSysteme.get(x));
            }
        }
        return X;
    }

    /**
     * Ecrit le système dans un fichier
     * @return
     */
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

    /**
     * Ecrit les nouveaux états du système
     * @param res
     */
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

    /**
     * Ecrit les état initiaux
     * @param res
     */
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

    /**
     * Ecrit les relation de transition
     * @param res
     */
    private void toDotTransition(StringBuilder res) {
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

    /**
     * Détermine les états successeurs d'une liste d'état
     * @param I
     * @return
     */
    public ArrayList<Integer> succ (ArrayList<Integer> I){
        ArrayList A;
        ArrayList T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
        for(int x=0; x<I.size();x++){

            for(int y =0; y<transP.size();y++){
                A=transP.get(y).get(0);
                if(!A.equals(T)){
                        if (!L.contains(A.get(I.get(x))) && !A.get(I.get(x)).equals(T)){
                            L.add(A.get(I.get(x)));
                        }
                }

            }
        }System.out.println("succ 2  : " + L);
        return L;
    }

    /**
     * Détermine les états successeur d'un(des) états possédant une étiquette(propriété) de la liste
     * à finaliser
     * @param I
     * @return
     */
    public ArrayList<Integer> succ2 (ArrayList<Object> I){
        System.out.println("I  : " + I);
        ArrayList<Integer> A;
        ArrayList<Integer> T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
        if (se.nomEtiq.contains(I.get(0)) && se.nomProp.contains(I.get(0))){
            System.out.println("problème lors de la différenciation entre étiquette et propriété");
        }
        if (se.nomEtiq.contains(I.get(0))){
            for(int x=0;x<I.size();x++) {
                int a = se.nomEtiq.indexOf(I.get(x));
                A=transP.get(a).get(0);
                for(int y=0;y<etatP.size();y++){
                    if((!A.equals(T))){
                        for (int z=0;z<A.size();z++){
                            if((!L.contains(A.get(z))) ){
                                L.add(A.get(z));
                            }
                        }
                    }
                }
            }System.out.println("verif  : " );
        }else if (se.nomProp.contains(I.get(0))){
            System.out.println("verif2  : " );
            ArrayList<Integer> L2 = new ArrayList();
            ArrayList<Integer> L3;
            for(int x=0;x<I.size();x++) {
                int a = se.nomProp.indexOf(I.get(x));
                A=transP.get(a).get(0);
                for(int y =0;y<A.size();y++){
                    if(propP.get(a).get(y)){
                        L2.add(y);
                    }
                }
                for(int y=0;y<L2.size();y++){
                    L3=succ(L2);
                    for(int z=0;z<L3.size();z++) {
                        if (!L.contains(L3.get(z))){
                            L.add(L3.get(z));
                        }
                    }
                }
            }
        }else System.out.print("Aucune solution possible avec cette entrée");
        System.out.println("LOLCAT  : ");
        L.remove(T);
        System.out.println("succ 2  : " + L);
        return L;
    }

    /**
     * Permet de récupérer la liste des états src possédant au moins une étiquette donné en argument
     * @param p
     * @return
     */
    public ArrayList<Integer> etiquette(ArrayList<Object> p){
        //System.out.println("A");
        ArrayList<Integer> L = new ArrayList();
        ArrayList T= new ArrayList();
        T.add(-1);
        for(int x=0;x<p.size();x++){
            System.out.println("C p.get(x) : " + p.get(x));
            int a = se.nomEtiq.indexOf(p.get(x));
            System.out.println("transP  : " + transP);
                   System.out.println("transPgx  : " + transP.get(a));
            ArrayList<ArrayList<Integer>> P = transP.get(a);
            System.out.println("P : " + P);
            for (int y=0; y<P.get(0).size();y++){
                System.out.println("transPgxg0gy  : " + transP.get(a).get(0).get(y));
                ArrayList<Integer> Q = transP.get(a).get(0);
                System.out.println("Q : " + Q);
                System.out.println("Qgy : " + Q.get(y));
                    for(int z=0;z<Q.size();z++){
                    if ((!L.contains(y))){
                    System.out.println("Lav : " + L);
                            L.add(y);
                    System.out.println("Lap : " + L);
                }}
            }
        }
        L.remove(T);
        System.out.println("L : " + L);
        return L;
    }

    /**
     * Permet de récupérer la liste des états src possédant au moins une propriété donné en argument
     * @param p
     * @return
     */
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
        }
        return L;
    }

    /**
     * Détermine les élément précédent de l'ensemble du systeme
     * @param nbEtat
     * @param ini
     * @param N
     * @return
     */
    public ArrayList<ArrayList<Integer>> pred (int nbEtat, int ini, int N){
        ArrayList T=new ArrayList();
        T.add(-1);
        if(this.pred.isEmpty()){
            for (int x = 0; x<nbEtat;x++){
                pred.add(T);
            }
        }
        if(nbEtat==0){
            return null;}
        else if (nbEtat==1){
            for(int x=0;x<transP.size();x++){
                ArrayList<Integer> X=transP.get(x).get(ini);
                if(!X.equals(T)){
                    for(int y=0;y<X.size();y++){
                        if(pred.get(X.get(y)).equals(T)){
                            ArrayList<Integer> R = new ArrayList<Integer>();
                            R.add(ini);
                            pred.set(X.get(y), R);
                        }else {
                            if(!pred.get(X.get(y)).contains(ini)){
                                pred.get(X.get(y)).add(ini);
                            }
                        }
                    }
                }
            }
        }else {
            int M = nbEtat / 2;
            N=N+M;
            pred(M, ini, N);
            pred(nbEtat - M, ini + M, N);
        }
        return pred;
    }

    /**
     * Retourne les éléments successeurs vérifiant p
     * @param p
     * @return
     */
    public ArrayList<Integer> EX(ArrayList<Object> p){
        ArrayList<Integer> T = etiquette(p);
        ArrayList<Integer> L = new ArrayList();
        for(int x=0;x<transP.size();x++){
            for (int y=0; y<transP.get(x).size();y++){
                for(int z=0; z<T.size();z++) {
                    if (transP.get(x).get(y).contains(T.get(z)) && !L.contains(y)){
                        L.add(y);
                        break;
                    }
                }
            }
        }
        Collections.sort(L);
        return L;
    }

    /**
     * Retourne les éléments si TOUT les successeurs vérifiant p
     * @param p
     * @return
     */
    public ArrayList<Integer> AX(ArrayList<Object> p){
        ArrayList<Integer> T = etiquette(p);
        System.out.println("T : " + T);
        ArrayList<Integer> L = new ArrayList();
        int cpt;
        for(int x=0;x<transP.size();x++){
            for (int y=0; y<transP.get(x).size();y++){
                cpt=0;
                ArrayList<Integer> P = transP.get(x).get(y);
                for(int z=0;z<P.size();z++){
                    if(T.contains(P.get(z))){
                        cpt++;
                    }else break;
                }
                ArrayList M = new ArrayList();
                M.add(y);
                if (cpt==succ(M).size())
                    L.add(y);
            }
        }
        return L;
    }

    /**
     * Retourne les éléments pointant uniquement les élément de EX(p)
     * @param p
     * @return
     */
    public ArrayList<Integer> AXEX(ArrayList<Object> p){
        ArrayList T=new ArrayList();
        T.add(-1);
        ArrayList<Integer> L = new ArrayList();
        ArrayList<Integer> S = EX(p);
        ArrayList<Integer> A;
        if(pred.isEmpty()){
            pred(etatP.size(), 0, 0);}
        for (int x=0; x<etatP.size();x++){int cpt=0;
            ArrayList<Integer> B= new ArrayList<Integer>();
            B.add(x);
            A=succ(B);
            for(int y=0; y<A.size();y++){
                if(S.contains(A.get(y))){
                    cpt++;
                }
            }
            if (cpt==A.size()){
                L.add(x);
            }
        }
        return L;
    }

    /**
     * Retourne les éléments pointant les élément de AX(p)
     * @param p
     * @return
     */
    public ArrayList<Integer> EXAX(ArrayList<Object> p) {
        ArrayList T=new ArrayList();
        T.add(-1);
        ArrayList<Integer> L = new ArrayList();
        ArrayList<Integer> S = AX(p);
        if(pred.isEmpty()){
            pred(etatP.size(), 0, 0);}
        for(int x=0;x<T.size();x++){
            ArrayList<Integer> M = new ArrayList<Integer>();
            M.add(S.get(x));
            L.addAll(pred.get(S.get(x)));
        }
        return L;
    }
}