package systeme;



import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BooleanSupplier;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import systeme.SystemeElem;

/**
 * Created by User on 06/05/15.
 */
public class Systeme {

    String[] nomSousSysteme = new String[0];
    Systeme[] sousSysteme = new Systeme[0];
    private Integer nbEtat = 0;
    public ArrayList<Integer> etat = new ArrayList();
    public ArrayList<Integer> init = new ArrayList();
    public ArrayList<ArrayList<Boolean>> prop = new ArrayList();
    public ArrayList<ArrayList<Integer>> pred = new ArrayList();
    public ArrayList<ArrayList<ArrayList<Integer>>> transEtiq = new ArrayList();

    private type type;
    public SystemeElem se = new SystemeElem();


    public Systeme(Systeme s){
        this.nomSousSysteme = s.nomSousSysteme;
        this.sousSysteme = s.sousSysteme;
        this.nbEtat = s.nbEtat;
        this.etat = s.etat;
        this.init = s.init;
        this.prop = s.prop;
        this.transEtiq=s.transEtiq;
        this.se=s.se;
    }

    public Systeme(int nbState,Object[] property) {
        nbEtat = nbState;
        etat(nbEtat);
        ArrayList L = new ArrayList();
      //  System.out.println(nbEtat);
        //this.etat = new ArrayList<Integer>();
        for (int i = 0; i < property.length; i++) {
            //this.etat.add(i);
          //  System.out.println(property[i]);
            L.add(property[i]);
        }
     //   System.out.println(L);
      //  System.out.println(se.nomProp);
        this.se.nomProp = L;
      //  System.out.println(se.nomProp);


    }

    public void etat (int nbState){
        ArrayList L = new ArrayList();
        for(int i=0; i<nbState ;i++){
            L.add(i);
        }
        etat=L;
    }

    public ArrayList<Integer> succ (ArrayList<Integer> I){
        //System.out.println("-------Succ(int) départ  : ");
        ArrayList A = new ArrayList();
        ArrayList T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
        for(int x=0; x<I.size();x++){

            for(int y =0; y<transEtiq.size();y++){
                //System.out.println("x/y :  " + x+"/"+y);
                //System.out.println("transEtiq  : " + transEtiq);
                //System.out.println("I  : " + I);
                //System.out.println("I.get(x)  : " + I.get(x));
                //System.out.println("transEtiq.get(y).get(x);  : " + transEtiq.get(y).get(x));
                A=transEtiq.get(y).get(I.get(x));
                if(!A.equals(T)){
                 //   System.out.println("L  : " + L);
                    //L.addAll(A);
                    for (int z=0;z<A.size();z++){
                   //     System.out.println("L / A.get(z) : " + L+" / " +A.get(z));
                        if (!L.contains(A.get(z))){
                            L.add(A.get(z));
                        }
                     //   System.out.println("L  : " + L);
                    }
                    //System.out.println("L  : " + L);
                }

            }
        }//System.out.println("succ 2  : " + L);
        return L;
    }

    public ArrayList<Integer> succ2 (ArrayList<Object> I){
        //System.out.println("-------Succ2 départ  : ");
        ArrayList<ArrayList<Integer>> A = new ArrayList();
        ArrayList<Integer> T = new ArrayList();
        ArrayList<Integer> L = new ArrayList();
        T.add(-1);
        if (se.nomEtiq.contains(I.get(0)) && se.nomProp.contains(I.get(0))){
            System.out.print("problème lors de la différenciation entre étiquette et propriété");
        }
        if (se.nomEtiq.contains(I.get(0))){
            for(int x=0;x<I.size();x++) {
                int a = se.nomEtiq.indexOf(I.get(x));
                A=transEtiq.get(a);
                for(int y=0;y<A.size();y++){
                    if(!A.get(y).equals(T) && !L.contains(A.get(y))){
                        L.addAll(A.get(y));
                    }
                }

            }
            //return L;

        }else if (se.nomProp.contains(I.get(0))){
            ArrayList<Integer> L2 = new ArrayList();
            ArrayList<Integer> L3 = new ArrayList();
            for(int x=0;x<I.size();x++) {
                int a = se.nomProp.indexOf(I.get(x));
                //System.out.println("a : "+a);
                A=transEtiq.get(a);
                //System.out.println("A : "+A);
                for(int y =0;y<A.size();y++){
                    //System.out.println("prop.get(a).get(y) : "+prop.get(a).get(y));
                    if(prop.get(a).get(y)){
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

        Collections.sort(L);
        //System.out.println("succ 2  : " + L);
        return L;
    }

    public String toDot() {
//        System.out.println("test");
//        this.test();
        System.out.println("test2");
        System.out.println("transE : " + transEtiq);
        System.out.println("transEg : " + transEtiq.get(0));
        System.out.println("transEgg : " + transEtiq.get(0).get(0));

        if (init==null) {
            return "digraph system {\n empty [shape=box]}\n";
        }
        StringBuilder res = new StringBuilder();
        res.append("digraph system {\n");

        recToDotStateP(res);

        toDotTransitionP(res);

        res.append("}\n");
        //System.out.println("trans : " + transEtiq);
        return res.toString();
    }

    public void test(){
        //System.out.println("A");
        ArrayList<Integer> T = new ArrayList();
        ArrayList<Integer> T2 = new ArrayList();
        ArrayList<Object> T3 = new ArrayList();
        ArrayList<Object> T4 = new ArrayList();
        T.add(1);
//        T2.add(0);System.out.println("T2 : " + T2);
        succ(T2);
        //System.out.println("succ(T2) : " + succ(T2));
        T2.add(2);//System.out.println("T2 : " + T2);
    //    succ(T2);System.out.println("succ(T2)2 : " + succ(T2));
        T3.add(se.nomEtiq.get(0));
    //    succ2(T3);System.out.println("succ2 etiq(T3)[a] : " + succ2(T3));
        T3.add(se.nomEtiq.get(1));
      //  succ2(T3);System.out.println("succ2 etiq(T3)[a,e] : " + succ2(T3));
        //T4.add(se.nomProp.get(1));
       // succ2(T4);System.out.println("~~~~~~~~~~~~~~~~succ2 prop(T4)[x]~~~~~~~~~~~~~~~~~~~~~~");
      //  succ2(T4);System.out.println("succ2 prop(T4)[x] : " + succ2(T4));
       // T4.add(se.nomProp.get(2));
     //   succ2(T4);System.out.println("~~~~~~~~~~~~~~~~succ2 prop(T4)[x,z]~~~~~~~~~~~~~~~~~~~~~~");
      //  succ2(T4);System.out.println("succ2 prop(T4)[x,z] : " + succ2(T4));

        //System.out.println("B");
        succ(T);
        //System.out.println("succ(1)" + succ(T));
        pred(nbEtat, 0, 0);
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

    private void recToDotStateP(StringBuilder res) {
        int x;
        if (init == null) {
            return;
        }

            if (init != null) {
                for(x=0;x<init.size();x++) {
                    res.append("_" + init.get(x) + "[label=\"\", shape=none ];\n");
                    res.append("_" + init.get(x) + "->" + init.get(x) + ";\n");
                }
            }
    }

    private void toDotTransitionP(StringBuilder res) {
        int x, y, z;
        ArrayList J = new ArrayList();
        J.add(-1);
        ArrayList L;
        ArrayList M;
        for (x=0;x<transEtiq.size();x++){
            L=transEtiq.get(x);
            for (y=0;y<L.size();y++) {
                M = (ArrayList) L.get(y);
                if (!L.get(y).equals(J))
                    for (z = 0; z < M.size(); z++) {
                        res.append(y + "->" + M.get(z) + " [label= \"" + se.nomEtiq.get(x) + "\"];\n");
                }
            }
        }
    }
    //--------------------------------------------------

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

    public boolean isState(int n) {
        if(etat.contains(n)){
            return true;
        }
        else return false;
    }

    public void addInitState(int s) {
        this.init.add(s);
    }

    public void ajoutEtiqTrans (){
//        System.out.println("\n" + "ajoutEtiq Debut : ");
        ArrayList<ArrayList<Integer>> L = new ArrayList();
        ArrayList<Integer> K = new ArrayList();
//        System.out.println("K : " + K);
        K.add(-1);
//        System.out.println("K : " + K);
//        System.out.println("L : " + L);
        for (int x = 0 ; x < etat.size() ; x++){
            L.add(K);
//            System.out.println("L["+x+"] : " + L);
        }
//        System.out.println("transEtiq AV : " + transEtiq);
        transEtiq.add(L);
//        System.out.println("transEtiq AP : " + transEtiq);
//        System.out.println("ajoutEtiq Fin : \n");
    }

//    public void addTransition(int src, int tgt) {
//        Object l = '*';
//        addTransition( src,  tgt, l);
//    }

    public void addTransition(int src, int tgt, Object l) {
//        System.out.println("\n" + "    addTransition Debut : ");
//        System.out.println("transEtiq AV : " + transEtiq);
        int a = se.nomEtiq.indexOf(l);
//        System.out.println("étiquette a : " + a);

        if(a==-1){
//            System.out.println("se.nomEtiq : " + se.nomEtiq);
            se.nomEtiq.add(l);
//            System.out.println("se.nomEtiq : " + se.nomEtiq);
            a = se.nomEtiq.indexOf(l);
//            System.out.println("index étiquette a : " + a);
            ajoutEtiqTrans();
        }

//        System.out.println("transEtiq : " + transEtiq);
        ArrayList<ArrayList<Integer>> T = transEtiq.get(a);
//        System.out.println("transEtiq.get(a) : " + transEtiq.get(a));
//        System.out.println("T : " + T);
        int b = etat.indexOf(src);
//        System.out.println("index etat b : " + b);
        if(b==-1){
//            System.out.println("etat : " + etat);
            etat.add(src);
//            System.out.println("etat : " + etat);
            b = etat.indexOf(src);
//            System.out.println("index etat b : " + b);
        }
//        System.out.println("AV U : ");
//        System.out.println("T : " + T);
//        System.out.println("T.get(b) : " + T.get(b));
        ArrayList<Integer> U = new ArrayList<Integer>();
//        System.out.println("U ini : " + U);
        ArrayList<Integer> L = new ArrayList();
        L.add(-1);
//        System.out.println("L : " + L);
//        System.out.println(" /n premier problème ici /n");


        if(T.get(b).equals(L)){
//            System.out.println("T1 : " + T);
            T.remove(b);
//            System.out.println("T2 : " + T);
            ArrayList K = new ArrayList();
//            System.out.println("K : " + K);
            K.add(tgt);
//            System.out.println("K : " + K);
            T.add(b, K);
//            System.out.println("T3 : " + T);
        }
        else{
//            System.out.println("U : " + U);
            U = T.get(b);
//            System.out.println("U AV : " + U);
//            System.out.println("U contient? : " + U.contains(tgt));
            if(!U.contains(tgt)){
                U.add(tgt);
//                System.out.println("U : " + U);
//                System.out.println("T4 : " + T);
                T.remove(b);
//                System.out.println("T5 : " + T);
                T.add(b, U);
//                System.out.println("T6 : " + T);
//                System.out.println("U AP : " + U);
            }
            transEtiq.remove(a);
            transEtiq.add(a,T);
        }
//        System.out.println("transEtiq Final : " + transEtiq);
//        System.out.println("    addTransition Fin : \n");

//        U = T.get(b);
//        System.out.println("U AV : " + U);
//        System.out.println("U contient? : " + U.contains(tgt));
//        if(!U.contains(tgt)){
//            U.add(tgt);
//            System.out.println("U AP : " + U);
//        }
//        System.out.println("addTransition Fin : \n");
    }

    public boolean isProp(Object i){
//        System.out.println("\n    isProp Debut");
//        System.out.println("se.nomProp : " + se.nomProp);
//        System.out.println("Object : " +i);
//        System.out.println("contains : " + this.se.nomProp.contains(i)+ "\n");
//        System.out.println("    isProp Fin \n");
        return this.se.nomProp.contains(i);
    }

    public ArrayList<ArrayList<Boolean>> initStateProperty() {

//        System.out.println("\n    initStateProperty Debut");
        int x,y;
//        System.out.println("etat : " + etat);
//        System.out.println("nomProp : " + se.nomProp);

        ArrayList<ArrayList<Boolean>> T = new ArrayList<ArrayList<Boolean>>();
//        for(x=0;x<etat.size();x++){
//            ArrayList<Boolean> S = new ArrayList();
//            for(y=0;y<se.nomProp.size();y++){
//                S.add(false);
//            }
//            T.add(S);
//        }
        for(x=0;x<se.nomProp.size();x++){
            ArrayList<Boolean> S = new ArrayList();
            for(y=0;y<etat.size();y++){
                S.add(false);
            }
            T.add(S);
        }
//        System.out.println("T : " + T);
//        System.out.println("prop AV : " + prop);
        prop = T;
//        System.out.println("prop AP : " + prop + "\n");
//        System.out.println("    initStateProperty Fin \n");
        return prop;
    }

    public void addStateProperty(int src, Object i) {
//        System.out.println("\n    addStateProperty Debut");
//        System.out.println("prop : "+ prop+ "\n");
        if (prop.isEmpty()){
//            System.out.println("prop AV(if) " + prop);
            prop=initStateProperty();
//            System.out.println("prop AP(if) : "+ prop);
        }
        else {
//            System.out.println("prop (else) "+ prop);
             }//ceci est assez étrange, mais celà fonctionne
            int a = se.nomProp.indexOf(i);
//            System.out.println("index prop : "+ a+ "\n");
            if(a!=-1){
            ArrayList<Boolean> T = prop.get(a);
            prop.remove(a);
            Boolean U = T.get(src);
            T.remove(src);
            if(U==false){
               U=true;
            }
            T.add(src,U);
            prop.add(a,T);

        }
        else System.out.println("La propri�t� n'�xiste pas");
//        System.out.println("Final : " + prop + "\n");
//        System.out.println("initStateProperty Fin \n");

    }

    public void addProp(Object o) {
        if (o == null && !se.nomProp.contains('*')) {
            se.nomProp.add('*');
        } else if (o != null && !se.nomProp.contains(o)) {
            se.nomProp.add(o);
        }
    }

    public ArrayList etiquette(ArrayList<Object> p){
        //System.out.println("A");
        ArrayList<Integer> L = new ArrayList();
        ArrayList T= new ArrayList();
        T.add(-1);
        //System.out.println("B p : " + p);
        for(int x=0;x<p.size();x++){
            //System.out.println("C p.get(x) : " + p.get(x));
            //System.out.println("se.nomEtiq : " + se.nomEtiq);
            int a = se.nomEtiq.indexOf(p.get(x));

            //System.out.println("D a : " + a + " / transE : " + transEtiq);
            ArrayList<ArrayList<Integer>> P = transEtiq.get(a);
           //System.out.println("E");
            for (int y=0; y<P.size();y++){
               // System.out.println("F");
                ArrayList<Integer> Q = P.get(y);
                //System.out.println("G");

                if (!Q.equals(T)){//System.out.println("H");
                    L.add(y);
                    //System.out.println("I");
                }
            }//System.out.println("J");
        }//System.out.println("OK etiq : " + L);
        return L;
    }

    public ArrayList propriete(ArrayList<Object> p){
        ArrayList<Object> L = new ArrayList();

        for(int x=0;x<p.size();x++){
            int a = prop.indexOf(p.get(x));
            ArrayList<Boolean> P = prop.get(a);
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
            for(int x=0;x<transEtiq.size();x++){
                //System.out.println("10.1 x: " + x);
                ArrayList<Integer> X=transEtiq.get(x).get(ini);
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
        ArrayList<Object> T = etiquette(p);
     //   System.out.println("2");
        ArrayList<Integer> L = new ArrayList();
     //   System.out.println("3");
        for(int x=0;x<transEtiq.size();x++){
      //      System.out.println("4");
            for (int y=0; y<transEtiq.get(x).size();y++){
         //       System.out.println("5");
                for(int z=0; z<T.size();z++) {
          //          System.out.println("6");
                    if (transEtiq.get(x).get(y).contains(T.get(z)) && !L.contains(y)){
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
        ArrayList<Object> T = etiquette(p);
        System.out.println("T : " + T);
        ArrayList<Integer> L = new ArrayList();
        int cpt;
        for(int x=0;x<transEtiq.size();x++){
           // System.out.println("x : " + x);
            for (int y=0; y<transEtiq.get(x).size();y++){
               // System.out.println("y : " + y);
                cpt=0;
                ArrayList<Integer> P = transEtiq.get(x).get(y);
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
            pred(nbEtat, 0, 0);}

        for (int x=0; x<etat.size();x++){int cpt=0;
            ArrayList<Integer> B= new ArrayList<Integer>();
           // System.out.println("B état ini : " + B);
            B.add(etat.get(x));
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
                L.add(etat.get(x));
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
        pred(nbEtat, 0, 0);}
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

    public enum type {
        INT,
        STR;
    }
}