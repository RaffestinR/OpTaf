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

    public Produit(ArrayList<Systeme> P){
        S=P;
        nbSyst=P.size();
    }
//inutil
    public void initSe(){
//        System.out.println("se : " + se);
//        System.out.println("se.nomEtiq AV : " + se.nomEtiq);
//        System.out.println("se.nomProp AV : " + se.nomProp);
        se.nomEtiq = new ArrayList();
        //System.out.println("se.nomEtiq AV : " + se.nomEtiq);
        se.nomProp = new ArrayList();
        //System.out.println("se.nomProp AV : " + se.nomProp);
    }

    public Produit(String[] nom, Systeme[] systeme){//surement des rajout � faire
        //System.out.println("--Produit Debut--");
        ArrayList L = new ArrayList();
        //System.out.println("L : " + L);
        nbSyst = systeme.length;
        //System.out.println("nbSyst : " + nbSyst);
        Collections.addAll(S, systeme);
        //System.out.println("S : " + S);
        Collections.addAll(nomSysteme, nom);
        //System.out.println("nomSysteme : " + nomSysteme);

//        for(int i=0;i<nbSyst;i++){//ici � modifier comme les fonctions dans systeme (S
//            S.get(i).nomSousSysteme[0]=nom[i];
//            S.get(i).sousSysteme[0]=systeme[i];
//            L.add(systeme[i]);
//        }
        //System.out.println("    -ensemble des fonctions- ");
        //System.out.println("etatP AV : " + etatP);
        etatP = etatP(S);
        //System.out.println("etatP AP : " + etatP);
        //System.out.println("initP AV : " + initP);
        initP = initP(S);
        //System.out.println("initP AP : " + initP);
//        System.out.println("etatP AV : " + etatP);
//        etatP = etatP(S);
//        System.out.println("etatP AP : " + etatP);

        //propP = propP(L);
       // initSe();
        //System.out.println("se.nomEtiq AV : " + se.nomEtiq);
        this.se.nomEtiq = nomEtiqP(S);
        //System.out.println("se.nomEtiq AP : " + se.nomEtiq);
        //System.out.println("transP AV : " + transP);
        remplir(S);
       // System.out.println("transP AP : " + transP);
        //System.out.println("--Produit Fin--");

    }

    public void synchro (ArrayList<Object> synch){
        //System.out.println("synchro AP : " + synchro);
        synchro.add(synch);
        //System.out.println("synchro AP : " + synchro);
    }

    public ArrayList initP(ArrayList<Systeme> S){
        int X=1,Y=0,cpt,x,u,v;
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
            A=S.get(x);
            for(cpt=0;cpt<Y;cpt++){
                for(v=0;v<A.init.size();v++){
                    for(u=0;u<X;u++){
                        if (J==null) {System.out.println("-> if");
                            J=I.get(cpt);}
                        J.add(A.init.get(v));
                        if (!I.contains(J)){
                        I.add(cpt, J);}
                    }
                }
            }
        }
        J = new ArrayList();
        for (x=0;x<I.size();x++){
            K=etatP.indexOf(I.get(x));
            J.add(x, K);//J.add(K);
        }
        return J;
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

    public void remplir(ArrayList<Systeme> S){
        //System.out.println("--remplir Debut--");
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
        //System.out.println("transP Final : " +transP);
        //System.out.println("--remplir Fin--");
    }

    public ArrayList transP (ArrayList<Systeme> S){
        //System.out.println("--transP Debut--");
        Object etiq=0;
        int x, y, z, A, eti = -1, F, mark, u;
        Object Y;
        Object YT = null;
        ArrayList VS, E;
        Integer C = 0;
        ArrayList<Integer> X;
        ArrayList<ArrayList<Integer>> B,G;
        ArrayList D;
        ArrayList L = new ArrayList();
        L.add(-1);
        Systeme Z;
        //System.out.println("etatP : " +etatP);
        for(y=0;y<synchro.size();y++){//on boncle sur les synchro afin de les faire toute
            ArrayList H = new ArrayList();
            VS = synchro.get(y);//VS est un vecteur de synchro choisis dans l'ordre
            //System.out.println("VS[y] [" + y + "] : " +VS +"\n");
            for(x=0;x<etatP.size();x++){//on boucle sur les �tat cons�cutivement
                mark=0;
                D = new ArrayList();
                X = etatP.get(x); //X est un �tat choisis dans l'ordre
                //System.out.println("=========X[x] [" + x + "] : " +X+"=========");
                for(z=0;z<nbSyst;z++){//on boucle sur le nombre de systeme afin de trouver l'�lem suivant cde chaque coord
                    //System.out.println("[y][x][z] : "+"y=" + y +"  x="+x+"  z="+z);
                    Y =  VS.get(z);//Y est une valeur du vecteur de synchro choisis dans l'ordre
                    //System.out.println("Y AV : " + Y);
                    if((YT == null) && !se.nomEtiq.contains(Y)){
                        //System.out.println("Y AV/AP : " + Y);
                        YT=Y;
                        //System.out.println("Y AP : " + Y);
                        //System.out.println("YT : " + YT);
                        //System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§");
                    }//else System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    //System.out.println("=========");
                    //System.out.println("Y[z] [" + z + "] : " +Y);
                    Z = S.get(z);//on pick le systeme associ�
                    A = Z.se.nomEtiq.indexOf(Y);//A vaut la valeur de l'�tiq dans son propre se.etiq
                    //System.out.println("A[z] [" + z + "] : " +A);
                    if (A!=-1){//donc elle existe
                        etiq=Y;//???????
                    }

                    C = X.get(z);//prend la coordonn� (int) associ� sur l'�tat choisis
                    //System.out.println("C[z] [" + z + "] : " +C);
                    if(A!=-1) {
                        B = Z.transEtiq.get(A);//r�cup�re la transisiton avec �tiquette a pour les systeme choisis
                        E = B.get(C);//pick la case concern�
                        //System.out.println("E[z] [" + z + "] : " +E);
                        if(E.equals(L)){
                            mark++;
                            //System.out.println("Y" + Y);
                            //System.out.println("YT" + YT);
                            if(Y.equals(YT)) {
                                //System.out.println("T R U E equals");
                                D.add(C);//mais oui c'est clair
                            }else{
                                //System.out.println("F A L S E equals");
                                D.add(-1);
                            }
                            //System.out.println("D(if(if))[z] [" + z + "] : " + D);
                        }else{
                            D.add(E.get(0));//mais oui c'est clair
                            //System.out.println("D(if(else))[z] [" + z + "] : " + D);
                        }
                    }else {
                        mark++;
                        //System.out.println("Y" + Y);
                       // System.out.println("YT" + YT);
                        if(Y.equals(YT)) {
                            //System.out.println("T R U E equals");
                            D.add(C);//mais oui c'est clair
                        }else{
                            //System.out.println("F A L S E equals");
                            D.add(-1);
                        }
                    }
                }
                ArrayList F2 = new ArrayList();
                if(mark < nbSyst) {//nous permet ici de transformer les (x,y,z) en t, le if semble quant � lui iutile
                    F = etatP.indexOf(D);//r�cup�re l'indice de l'�tat afin d'avoir le changement de "notation"

                    F2.add(F);
                    //System.out.println("F[mark] [" + mark + "] : " + F);
                    //System.out.println("F2[mark] [" + mark + "] : " + F2);
                    eti = se.nomEtiq.indexOf(etiq);//r�cup�re l'indice de l'�tiquette dans le celle du produit
                    //System.out.println("transP : " + transP);
                } else {
                    F2.add(-1);
                }
                H.add(F2);
            }
            G = new ArrayList<ArrayList<Integer>>();
            G.add(H);
            transP.remove(eti);
            transP.add(eti,G);
        }
        //System.out.println("--transP Fin--");
        //System.out.println("transP : " + transP);
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
        }//ceci est assez �trange, mais cel� fonctionne
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

    private void toDotTransition(StringBuilder res) {//� modifier
        int x, y, z;
        ArrayList J = new ArrayList();
        J.add(-1);
        ArrayList L;
        ArrayList M;
        for (x=0;x<transP.size();x++){
            //System.out.println("x : " + x);
            L=transP.get(x);
           // System.out.println("L : " + L);
            for (y=0;y<L.size();y++) {
                //System.out.println("y : " + y);
                M = (ArrayList) L.get(y);
                //System.out.println("M : " + M);
                //System.out.println("L.get(y) : " + L.get(y));
                if (L.get(y)!= J)
                    for (z = 0; z < M.size(); z++) {
                        //System.out.println("z : " + z);
                        //System.out.println("M.get(z) : " + M.get(z));
                        if (!M.get(z).equals(J)){
                            res.append(z + "->" + M.get(z) + " [label= \"" + se.nomEtiq.get(x) + "\"];\n");
                        }

                    }
            }
        }
    }
}