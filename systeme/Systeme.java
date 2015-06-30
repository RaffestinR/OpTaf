package systeme;



import java.util.*;

/**
 * Created by RAFFESTIN on 06/05/15.
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

    /**
     * Fonction appelée dans la pertie ANTLR afin d'initialiser le système
     * @param nbState
     * @param property
     */
    public Systeme(int nbState,Object[] property) {
        nbEtat = nbState;
        etat(nbEtat);
        ArrayList L = new ArrayList();
        for (int i = 0; i < property.length; i++) {
            L.add(property[i]);
        }
        this.se.nomProp = L;
    }

    /**
     * Initialisation des états
     * @param nbState
     */
    public void etat (int nbState){
        ArrayList L = new ArrayList();
        for(int i=0; i<nbState ;i++){
            L.add(i);
        }
        etat=L;
    }

    /**
     * Fonction nous permettant de déterminer les successeurs d'une liste d'état
     * @param I
     * @return
     */
    public ArrayList<Integer> succ (ArrayList<Integer> I){
        ArrayList A;
        ArrayList T = new ArrayList();
        ArrayList L = new ArrayList();
        T.add(-1);
        for(int x=0; x<I.size();x++){
            for(int y =0; y<transEtiq.size();y++){
                A=transEtiq.get(y).get(I.get(x));
                if(!A.equals(T)){
                    for (int z=0;z<A.size();z++){
                       if (!L.contains(A.get(z))){
                            L.add(A.get(z));
                        }
                    }
                }
            }
        }
        return L;
    }

    /**
     * Fonction nous permettant de déterminer les successeurs d'une liste d'étiquettes ou une liste de propriétées
     * @param I
     * @return
     */
    public ArrayList<Integer> succ2 (ArrayList<Object> I){
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
        }else if (se.nomProp.contains(I.get(0))){
            ArrayList<Integer> L2 = new ArrayList();
            ArrayList<Integer> L3 = new ArrayList();
            for(int x=0;x<I.size();x++) {
                int a = se.nomProp.indexOf(I.get(x));
                A=transEtiq.get(a);
                for(int y =0;y<A.size();y++){
                    if(prop.get(a).get(y)){
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
        Collections.sort(L);
        return L;
    }

    /**
     * Fonction qui nous permet d'écrire le système de trtansition dans un fichier .dot
     * @return
     */
    public String toDot() {
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

    /**
     * Enregistrement des états initiaux
     * @param res
     */
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

    /**
     * Enregistrement des relations de transitions
     * @param res
     */
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

    /**
     * Vérifie si un l'état existe
     * @param n
     * @return
     */
    public boolean isState(int n) {
        if(etat.contains(n)){
            return true;
        }
        else return false;
    }

    /**
     * Ajout d'un état initial
     * @param s
     */
    public void addInitState(int s) {
        this.init.add(s);
    }

    /**
     * Initialise le tableau de transition
     */
    public void ajoutEtiqTrans (){
        ArrayList<ArrayList<Integer>> L = new ArrayList();
        ArrayList<Integer> K = new ArrayList();
        K.add(-1);
        for (int x = 0 ; x < etat.size() ; x++){
            L.add(K);
        }
        transEtiq.add(L);
    }

    /**
     * Ajout d'une relation de transition
     * @param src
     * @param tgt
     * @param l
     */
    public void addTransition(int src, int tgt, Object l) {
        int a = se.nomEtiq.indexOf(l);
        if(a==-1){
            se.nomEtiq.add(l);
            a = se.nomEtiq.indexOf(l);
            ajoutEtiqTrans();
        }
        ArrayList<ArrayList<Integer>> T = transEtiq.get(a);
        int b = etat.indexOf(src);
        if(b==-1){
            etat.add(src);
            b = etat.indexOf(src);
        }
        ArrayList<Integer> U;
        ArrayList<Integer> L = new ArrayList();
        L.add(-1);
        if(T.get(b).equals(L)){
            T.remove(b);
            ArrayList K = new ArrayList();
            K.add(tgt);
            T.add(b, K);
        }
        else{
            U = T.get(b);
            if(!U.contains(tgt)){
                U.add(tgt);
                T.remove(b);
                T.add(b, U);
            }
            transEtiq.remove(a);
            transEtiq.add(a,T);
        }
    }

    /**
     * Retourne true si la propriété est déjà présente, false sinon
     * @param i
     * @return
     */
    public boolean isProp(Object i){
        return this.se.nomProp.contains(i);
    }

    /**
     * Initialise le tableau de booleans à false
     * @return
     */
    public ArrayList<ArrayList<Boolean>> initStateProperty() {
        int x,y;
        ArrayList<ArrayList<Boolean>> T = new ArrayList<ArrayList<Boolean>>();
        for(x=0;x<se.nomProp.size();x++){
            ArrayList<Boolean> S = new ArrayList();
            for(y=0;y<etat.size();y++){
                S.add(false);
            }
            T.add(S);
        }
        prop = T;
        return prop;
    }

    /**
     * Mis à true de l'emplacement src/propriété si elle existe
     * @param src
     * @param i
     */
    public void addStateProperty(int src, Object i) {
        if (prop.isEmpty()){
            prop=initStateProperty();
        }
        int a = se.nomProp.indexOf(i);
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
    }

    /**
     * Permet de récupérer la liste des états src possédant au moins une étiquette donné en argument
     * @param p
     * @return
     */
    public ArrayList etiquette(ArrayList<Object> p){
        ArrayList<Integer> L = new ArrayList();
        ArrayList T= new ArrayList();
        T.add(-1);
        for(int x=0;x<p.size();x++){
            int a = se.nomEtiq.indexOf(p.get(x));
            ArrayList<ArrayList<Integer>> P = transEtiq.get(a);
            for (int y=0; y<P.size();y++){
                ArrayList<Integer> Q = P.get(y);
                if (!Q.equals(T)){
                    L.add(y);
                }
            }
        }
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
            int a = prop.indexOf(p.get(x));
            ArrayList<Boolean> P = prop.get(a);
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
            for(int x=0;x<transEtiq.size();x++){
                ArrayList<Integer> X=transEtiq.get(x).get(ini);
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
        ArrayList<Object> T = etiquette(p);
        ArrayList<Integer> L = new ArrayList();
        for(int x=0;x<transEtiq.size();x++){
            for (int y=0; y<transEtiq.get(x).size();y++){
                for(int z=0; z<T.size();z++) {
                    if (transEtiq.get(x).get(y).contains(T.get(z)) && !L.contains(y)){
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
        ArrayList<Object> T = etiquette(p);
        System.out.println("T : " + T);
        ArrayList<Integer> L = new ArrayList();
        int cpt;
        for(int x=0;x<transEtiq.size();x++){
            for (int y=0; y<transEtiq.get(x).size();y++){
                cpt=0;
                ArrayList<Integer> P = transEtiq.get(x).get(y);
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
            pred(nbEtat, 0, 0);}
        for (int x=0; x<etat.size();x++){int cpt=0;
            ArrayList<Integer> B= new ArrayList<Integer>();
            B.add(etat.get(x));
            A=succ(B);
            for(int y=0; y<A.size();y++){
                if(S.contains(A.get(y))){
                    cpt++;
                }
            }
            if (cpt==A.size()){
                L.add(etat.get(x));
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
        pred(nbEtat, 0, 0);}
        for(int x=0;x<T.size();x++){
            ArrayList<Integer> M = new ArrayList<Integer>();
            M.add(S.get(x));
                L.addAll(pred.get(S.get(x)));
        }
    return L;
    }
}