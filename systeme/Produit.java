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
        etatP=etatP(S);
        initP=initP(S);
        transP=transP(S);
        //propP=propP(S);
        this.se.nomEtiq=nomEtiqP(S);
        //this.se.nomProp=nomPropP(S);
        nbSyst=P.S.size();
    }
   // P = new Produit(nom.toArray(new String[]{}), sys.toArray(new Systeme[]{}));
//    public Produit(String[] nom,Systeme[] syst) {
//        nbSyst = syst.length;
//        etat(nbEtat);
//        ArrayList L = new ArrayList();
//        //  System.out.println(nbEtat);
//        //this.etat = new ArrayList<Integer>();
//        for (int i = 0; i < property.length; i++) {
//            //this.etat.add(i);
//            //  System.out.println(property[i]);
//            L.add(property[i]);
//        }
//        //   System.out.println(L);
//        //  System.out.println(se.nomProp);
//        this.se.nomProp = L;
//        //  System.out.println(se.nomProp);
//
//
//    }

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
    }
//inutil
    public void initSe(){
        System.out.println("se : " + se);
        System.out.println("se.nomEtiq AV : " + se.nomEtiq);
        System.out.println("se.nomProp AV : " + se.nomProp);
        se.nomEtiq = new ArrayList();
        System.out.println("se.nomEtiq AV : " + se.nomEtiq);
        se.nomProp = new ArrayList();
        System.out.println("se.nomProp AV : " + se.nomProp);
    }

    public Produit(String[] nom, Systeme[] systeme){//surement des rajout à faire
        System.out.println("--Produit Debut--");
        ArrayList L = new ArrayList();
        System.out.println("L : " + L);
        nbSyst = systeme.length;
        System.out.println("nbSyst : " + nbSyst);
        Collections.addAll(S, systeme);
        System.out.println("S : " + S);
        Collections.addAll(nomSysteme, nom);
        System.out.println("nomSysteme : " + nomSysteme);

//        for(int i=0;i<nbSyst;i++){//ici à modifier comme les fonctions dans systeme (S
//            S.get(i).nomSousSysteme[0]=nom[i];
//            S.get(i).sousSysteme[0]=systeme[i];
//            L.add(systeme[i]);
//        }
        System.out.println("    -ensemble des fonctions- ");
        System.out.println("etatP AV : " + etatP);
        etatP = etatP(S);
        System.out.println("etatP AP : " + etatP);
        System.out.println("initP AV : " + initP);
        initP = initP(S);
        System.out.println("initP AP : " + initP);
//        System.out.println("etatP AV : " + etatP);
//        etatP = etatP(S);
//        System.out.println("etatP AP : " + etatP);

        //propP = propP(L);
       // initSe();
        System.out.println("se.nomEtiq AV : " + se.nomEtiq);
        this.se.nomEtiq = nomEtiqP(S);
        System.out.println("se.nomEtiq AP : " + se.nomEtiq);
        System.out.println("transP AV : " + transP);
        remplir(S);
        //transP = transP(S);
        System.out.println("transP AP : " + transP);
        //se.nomProp = nomPropP(L);
        System.out.println("--Produit Fin--");

    }

    public void synchro (ArrayList<Object> synch){
        System.out.println("synchro AP : " + synchro);
        synchro.add(synch);
        System.out.println("synchro AP : " + synchro);
    }

    public ArrayList initP(ArrayList<Systeme> S){
        //System.out.println("--initP Debut--");
        int X=1,Y=0,cpt,x,u,v;
        Systeme A = null;

        ArrayList<ArrayList> I = new ArrayList();
        //System.out.println("I : " + I);

        ArrayList J = new ArrayList();
        //System.out.println("J : " + J);
        int K;
        //System.out.println("nbSyst : " + nbSyst);
        for(x=0;x<nbSyst;x++){
            //System.out.println("A AV [" + x + "]: " + A);
            A=S.get(x);
            //System.out.println("A AP [" + x + "]: " + A);
            //System.out.println("X [" + x + "]: " + X);
            X=X/(A.init.size());
            //System.out.println("X [" + x + "]: " + X);
        }
        //System.out.println("Y AV : " + Y);
        Y=X;
        //System.out.println("Y AP : " + Y);
        //System.out.println("nbSyst : " + nbSyst);
        for(x=0;x<nbSyst;x++){
            //System.out.println("x : " + x);

            //System.out.println("A : " + A);
            A=S.get(x);
            for(cpt=0;cpt<Y;cpt++){
                //System.out.println("cpt : " + cpt);
                for(v=0;v<A.init.size();v++){
                    //System.out.println("v : " + v);
                    for(u=0;u<X;u++){
                        //System.out.println("I AV [" + u + "]: " + I);
                        //System.out.println("J AV [" + u + "]: " + J);
                        if (J==null) {System.out.println("-> if");
                            J=I.get(cpt);}
                        //System.out.println("J MID [" + u + "]: " + J);
                        J.add(A.init.get(v));
                        //System.out.println("J AP [" + u + "]: " + J);
                        if (!I.contains(J)){
                        I.add(cpt, J);}
                        //System.out.println("I AP [" + u + "]: " + I);
                    }
                }
            }
        }
        //System.out.println("I : " + I);
        //System.out.println("J : " + J);
        J = new ArrayList();
        //System.out.println("J : " + J);
        for (x=0;x<I.size();x++){
            //System.out.println("I.get(x) : " + I.get(x));
            K=etatP.indexOf(I.get(x));
            //System.out.println("K [" + x + "]: " + K);
            J.add(x, K);//J.add(K);
            //System.out.println("J [" + x + "]: " + J);
        }
        //System.out.println("J : " + J);
        //System.out.println("--initP Fin--");
        return J;
    }

    // à revoir
    public ArrayList etatP(Systeme A, Systeme B){
        //System.out.println("--etatP(syst) Debut--");
        ArrayList<ArrayList<Integer>> etatNouveau = new ArrayList();
        int x=0,y;
        while (x<B.etat.size()){
            //System.out.println("B.etat : " + B.etat);
            for(y=0;y<A.etat.size();y++){
                ArrayList etatCourant = new ArrayList();
                etatCourant.add(A.etat.get(y));
                //System.out.println("etatCourant : " + etatCourant);
                etatCourant.add(B.etat.get(x));
                //System.out.println("etatCourant 2 : " + etatCourant);
                etatNouveau.add(etatCourant);
                //System.out.println("etatNouveau : " + etatNouveau);
            }
            x++;
        }
        //System.out.println("etatNouveau : " + etatNouveau);
        //System.out.println("--etatP(syst) Fin--");
        return etatNouveau;
    }

    public ArrayList etatP(ArrayList<ArrayList<Integer>> X, Systeme B){
        //System.out.println("--etatP(syst) Debut--");
        ArrayList<ArrayList<Integer>> etatNouveau = new ArrayList();
        int x=0,y;
        while (x<B.etat.size()){
            //System.out.println("B.etat : " + B.etat);
            for(y=0;y<X.size();y++){
                ArrayList etatCourant = new ArrayList();
                etatCourant.add(X.get(y));
                //System.out.println("etatCourant : " + etatCourant);
                etatCourant.add(B.etat.get(x));
                //System.out.println("etatCourant 2 : " + etatCourant);
                etatNouveau.add(etatCourant);
                //System.out.println("etatNouveau : " + etatNouveau);
            }
            x++;
        }
//        System.out.println("etatNouveau : " + etatNouveau);
//        System.out.println("--etatP(syst) Fin--");
        return etatNouveau;
    }

    public ArrayList etatP (ArrayList<Systeme> S){//si possible trier du plus grand au plus petit, et vice et versa
//        System.out.println("--etatP(AL) Debut--");
//        Systeme X = null;
//        int x; // modif ci dessous
//        X.etat=etatP(S.get(0), S.get(1));
//        System.out.println("X : " + X);
//        for(x=2;x<S.size();x++){
//            X.etat=etatP(X,S.get(x));
//            System.out.println("X : " + X);
//        }
//        System.out.println("X : " + X);
//        System.out.println("--etatP(AL) Fin--");
//        return X.etat;

        //System.out.println("--etatP(AL) Debut--");
        ArrayList<ArrayList<Integer>> etatX = new ArrayList<ArrayList<Integer>>();
        //System.out.println("etatX : " + etatX);
        Systeme X;
        int x; // modif ci dessous
        //System.out.println("etatP : " + etatP);
        etatX=etatP(S.get(0), S.get(1));
        //System.out.println("etatP : " + etatP);
        //System.out.println("etatX : " + etatX);
        //System.out.println("X : " + X);
        //etatX=etatP;
        for(x=2;x<S.size();x++){
            etatX=etatP(etatX,S.get(x));
            //System.out.println("etatX : " + etatX);
            //System.out.println("X : " + X);
        }
//        System.out.println("etatX : " + etatX);
//        System.out.println("--etatP(AL) Fin--");
        return etatX;
    }

    public ArrayList nomEtiqP(ArrayList<Systeme> S){
        //System.out.println("--nomEtiq Debut--");
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
        //System.out.println("--nomEtiq Fin--");
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

    /*public ArrayList<ArrayList<ArrayList<Integer>>> remplir(ArrayList<Systeme> S){
        System.out.println("--remplir Debut--");
        ArrayList<ArrayList<ArrayList<Integer>>> J = new ArrayList();
        ArrayList<ArrayList<Integer>> K = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> I = new ArrayList();
        I.add(-1);
        int x=0,y=0;
        while (x<se.nomEtiq.size()){ // attention sens boucle

            while(y<etatP.size()){
                K.add(I);
            }
            J.add(K);
        }
//        while (x<se.nomEtiq.size()){ // attention sens boucle
//            ArrayList<ArrayList<Integer>> K = J.get(x);
//            while(y<etatP.size()){
//                ArrayList<Integer> L = K.get(y);
//                L=I;
//            }
//        }
        transP=J;
        System.out.println("--remplir Fin--");
        return transP;//return??
    }*/

    public void remplir(ArrayList<Systeme> S){
        System.out.println("--remplir Debut--");
        //ArrayList<ArrayList<ArrayList<Integer>>> J = new ArrayList();
        //ArrayList<ArrayList<Integer>> K = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> I = new ArrayList();
        //System.out.println("transP ini : " +transP);
        //System.out.println("I AV : " + I);
        I.add(-1);
        //System.out.println("I AV : " +I);
        int x=0,y=0;
        //System.out.println("se.nomEtiq : " + se.nomEtiq);
        //System.out.println("etatP : " + etatP);
        for(x=0;x<se.nomEtiq.size();x++){ // attention sens boucle
            ArrayList<ArrayList<Integer>> K = new ArrayList<ArrayList<Integer>>();
            //System.out.println("K[x]["+x+"] ini : " +K);
            for(y=0;y<etatP.size();y++){
                K.add(I);
                //System.out.println("K[x,y] [" + x + "," + y + "] : " + K);
            }

            transP.add(K);
            //System.out.println("transP[x] [" + x + ": " + transP);
        }
        /*while (x<se.nomEtiq.size()){ // attention sens boucle
            ArrayList<ArrayList<Integer>> K = J.get(x);
            while(y<etatP.size()){
                ArrayList<Integer> L = K.get(y);
                L=I;
            }
        }*/
        //transP=J;
        System.out.println("transP Final : " +transP);
        System.out.println("--remplir Fin--");
    }

    //Attention, cette version ne prend pas encore en compte le cas suivant:
    //exemple:0->1[a]; 0->2[a]
    public ArrayList transP (ArrayList<Systeme> S){
        System.out.println("--transP Debut--");

        Object etiq=0;
        int x, y, z, A, eti, F, mark, u;
        Object Y;
        ArrayList VS,  H = null, E;
        Integer C = 0;

        ArrayList<Integer> X;
        ArrayList<ArrayList<Integer>> B,G;
        ArrayList D;
        ArrayList L = new ArrayList();

        L.add(-1);
        Systeme Z;
        System.out.println("etatP : " +etatP);
        for(x=0;x<etatP.size();x++){//on boucle sur les état consécutivement
            X = etatP.get(x); //X est un état choisis dans l'ordre
            //System.out.println("=========X[x] [" + x + "] : " +X+"=========");
            //System.out.println("synchro : " + synchro+"\n");
            ArrayList N = new ArrayList();
            System.out.println("N ini : " +N);
            for(y=0;y<synchro.size();y++){//on boncle sur les synchro afin de les faire toute
                mark=0;
                VS = synchro.get(y);//VS est un vecteur de synchro choisis dans l'ordre
                System.out.println("VS[y] [" + y + "] : " +VS +"\n");
                D = new ArrayList();

                for(z=0;z<nbSyst;z++){//on boucle sur le nombre de systeme afin de trouver l'élem suivant cde chaque coord
                    //ArrayList C2=new ArrayList();
                    Y =  VS.get(z);//Y est une valeur du vecteur de synchro choisis dans l'ordre
                    System.out.println("=========");
                    System.out.println("Y[z] [" + z + "] : " +Y);
                    Z = S.get(z);//on pick le systeme associé
                    //W = nomSysteme.get(z);
                    //System.out.println("W[z] [" + z + "] : " +W);
                    //System.out.println("Z[z] [" + z + "] : " +Z);
                    A = Z.se.nomEtiq.indexOf(Y);//A vaut la valeur de l'étiq dans son propre se.etiq
                    System.out.println("A[z] [" + z + "] : " +A);
                    if (A!=-1){//donc elle existe
                        etiq=Y;//???????
                        System.out.println(" if(etiq) " +etiq);
                    }
                    System.out.println(" X.get(z) " +X.get(z));
                    C = X.get(z);//prend la coordonné (int) associé sur l'état choisis
                    //C2.add(X.get(z));//prend la coordonné (AL) associé sur l'état choisis
                    //System.out.println("C2[z] [" + z + "] : " + C2);

                    System.out.println("C[z] [" + z + "] : " +C);
                    if(A!=-1) {
                        //u = (int) C.get(0);
                        B = Z.transEtiq.get(A);//récupère la transisiton avec étiquette a pour les systeme choisis
                        System.out.println("B[z] [" + z + "] : " +B);
                        E = B.get(C);//pick la case concerné
                        System.out.println("L : " +L);
                        System.out.println("E[z] [" + z + "] : " +E);
                        if(E.equals(L)){

                            //erreur ici
//                            D.add(E);//récupère la valeur du succ concerné
                            D.add(C);//récupère la valeur du succ concerné
                            System.out.println("D(if(if))[z] [" + z + "] : " + D);
                        }else{
//                            D.add(C);//mais oui c'est clair
                            D.add(E.get(0));//mais oui c'est clair
                            System.out.println("D(if(else))[z] [" + z + "] : " + D);
                            mark++;//on augmente mark de 1 mais pourquoi?
                            System.out.println("mark(if(else))[z] [" + z + "] : " + mark);
                        }
                    }else{
                        D.add(C);//mais oui c'est clair
                        System.out.println("D(else)[z] [" + z + "] : " + D);
                        mark++;//on augmente mark de 1 mais pourquoi? il mpe semble que c'est pour leur donné un numéros d'état "convenable"
                        System.out.println("mark(else)[z] [" + z + "] : " + mark);

                    }
                    System.out.println("N[z]av  : " + N );
                }
                System.out.println("N[y]av [" + y + "] : " + N );
                if(!N.contains(D)){
                N.add(D);}
                System.out.println("N[y]ap [" + y + "] : " + N );

                //System.out.println("mark : " + mark+"\n");
/* LE PB EST ICI!!! */
                if(mark < nbSyst){//nous permet ici de transformer les (x,y,z) en t, le if semble quant à lui iutile
                    F = etatP.indexOf(D);//récupère l'indice de l'état afin d'avoir le changement de "notation"
                    //System.out.println("F[mark] [" + mark + "] : " + F);
                    //System.out.println("se.nomEtiq : " + se.nomEtiq);
                    eti = se.nomEtiq.indexOf(etiq);//récupère l'indice de l'étiquette dans le celle du produit
                    //System.out.println("eti[mark] [" + mark + "] : " + eti);
                    //System.out.println("transP : " + transP);


                    G = transP.get(eti);
                    //System.out.println("G[mark] [" + mark + "] : " + G);
                    H= (ArrayList) G.get(x);
                    //System.out.println("H[mark] [" + mark + "] : " + H);
                    if (H == L){
                        //System.out.println("H(if)[mark] [" + mark + "] : " + H);
                        H.remove(-1);
                        //System.out.println("H[mark] [" + mark + "] : " + H);
                    }//System.out.println("H AV[mark] [" + mark + "] : " + H);
                    H.add(F);
                    //System.out.println("H AP[mark] [" + mark + "] : " + H);
                }
            }
        }System.out.println("--transP Fin--");
        System.out.println("H : " + H);
        System.out.println("transP : " + transP);
        return transP;
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

    public boolean isPropP(Object i){
//        System.out.println("\n    isProp Debut");
//        System.out.println("se.nomProp : " + se.nomProp);
//        System.out.println("Object : " +i);
//        System.out.println("contains : " + this.se.nomProp.contains(i)+ "\n");
//        System.out.println("    isProp Fin \n");
        return this.se.nomProp.contains(i);
    }

    public ArrayList<ArrayList<Boolean>> initStatePropertyP() {

//        System.out.println("\n    initStateProperty Debut");
        int x,y;
//        System.out.println("etat : " + etat);
//        System.out.println("nomProp : " + se.nomProp);

        ArrayList<ArrayList<Boolean>> T = new ArrayList<ArrayList<Boolean>>();
        for(x=0;x<se.nomProp.size();x++){
            ArrayList<Boolean> S = new ArrayList();
            for(y=0;y<etatP.size();y++){
                S.add(false);
            }
            T.add(S);
        }
//        System.out.println("T : " + T);
//        System.out.println("prop AV : " + prop);
        propP = T;
//        System.out.println("prop AP : " + prop + "\n");
//        System.out.println("    initStateProperty Fin \n");
        return propP;
    }

    public void addStatePropertyP(int src, Object i) {
//        System.out.println("\n    addStateProperty Debut");
//        System.out.println("prop : "+ prop+ "\n");
        if (propP.isEmpty()){
//            System.out.println("prop AV(if) " + prop);
            propP=initStatePropertyP();
//            System.out.println("prop AP(if) : "+ prop);
        }
        else {
//            System.out.println("prop (else) "+ prop);
        }//ceci est assez étrange, mais celà fonctionne
        int a = se.nomProp.indexOf(i);
//            System.out.println("index prop : "+ a+ "\n");
        if(a!=-1){
            ArrayList<Boolean> T = propP.get(a);
            propP.remove(a);
            Boolean U = T.get(src);
            T.remove(src);
            if(U==false){
                U=true;
            }
            T.add(src,U);
            propP.add(a,T);
        }
        else System.out.println("La propri?t? n'?xiste pas");
//        System.out.println("Final : " + prop + "\n");
//        System.out.println("initStateProperty Fin \n");

    }

    public void addPropP(Object o) {
        if (o == null && !se.nomProp.contains('*')) {
            se.nomProp.add('*');
        } else if (o != null && !se.nomProp.contains(o)) {
            se.nomProp.add(o);
        }
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