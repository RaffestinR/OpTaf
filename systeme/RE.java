
        package systeme;

        import java.text.Collator;
        import java.util.*;

public class RE {

    private static Collator COLLATOR = Collator.getInstance(Locale.FRENCH);

    private Données<Obj> ObjL = new Données<Obj>();

    private type dernierTri;

    /*public RE (){
        à faire une fois systeme elémentaire fait
    }*/

    //----------------------------------------------------------------------------

    //retourne les étas successeurs
    /*public ArrayList<Integer> ObjSucc(ArrayList<Integer> L){
        ObjL.search(L,type.SRC,type.SRC,type.TGT);
        return L;
    }*/

    public ArrayList<Integer> ObjSucc(ArrayList<Integer> L){
        return ObjL.search(L,type.SRC,type.SRC,type.TGT);
    }

    //retourne les label successeurs
    public ArrayList<Integer> ObjSuccL(ArrayList<String> L){
        return ObjL.search(L,type.LAB,type.SRC,type.TGT);
    }

    //retourne les étas Predesseurs
    public ArrayList<Integer> ObjPred(ArrayList<Integer> L){
        return ObjL.search(L,type.TGT,type.TGT,type.SRC);
    }

    //retourne les label Predesseurs
    public ArrayList<Integer> ObjPredL(ArrayList<String> L){
        return ObjL.search(L,type.LAB,type.TGT,type.LAB);
    }

    //Deux fonctions pas forcément utile
    public ArrayList<String> ObjLabel(ArrayList<Integer> L){
        return ObjL.search(L,type.SRC,type.SRC,type.LAB);
    }

    /*public ArrayList<Integer> ObjLabel(ArrayList<Integer> L){
        return ObjL.search(L,type.SRC,type.LAB,type.SRC);
    }*/

    //Permet de récupérer les src -> label
    public ArrayList<Integer> ObjLabelL(ArrayList<String> L){
        return ObjL.search(L,type.LAB,type.LAB,type.SRC);
    }

    //fonction retournant les solution de EX
    public ArrayList<Integer> EX(ArrayList<String> p) {
        return ObjPred(ObjSuccL(p));
    }

    public ArrayList<Integer> AX(ArrayList<String> p) {
        boolean B = true;
        ArrayList<Integer> L = ObjSuccL(p);
        int i=0,j, taille1 = L.size();
        ArrayList L2;
        ArrayList L3 = new ArrayList();
        while (i<taille1){
            j=0;
            L3.add(L.get(i));
            L2 = ObjLabel(L3);
            while (j<L2.size()){
                if (L2.get(i)!=p){
                    B=false;
                    break;
                }else j++;
            }
            if (B==false){
                L.remove(i);
                i--;
                taille1--;
            }
        }
        return L;
    }


/*
    //Permet de récupérer les états initiaux (utile?)
    public ArrayList<Integer> ObjInit(){
        //tri en fonction des src
        int cpt=0;
        while (x != o.srcO.get(cpt)){
            cpt++;
        }
        while (x == o.srcO.get(cpt)){
            o.srcO.get(cpt);
            //print
            cpt++;
        }
    }

    //Permet de récupérer les etats Accesseurs (utile?)
    public void ObjAcc(Obj o,int x) {
        //tri en fonction des src
        int cpt=0;
        while (x != o.srcO.get(cpt)){
            cpt++;
        }
        while (x == o.srcO.get(cpt)){
            o.srcO.get(cpt);
            //print
            cpt++;
        }
    }
    //Permet de récupérer les label
    public void ObjLabel(Obj o,label a){
        //tri en fonction des label
        int cpt=0;
        while (x != o.labelO.get(cpt)){
            cpt++;
        }
        while (x == o.labelO.get(cpt)){
            o.labelO.get(x);
        }
    }

    //Permet de récupérer les Propriétées
    public void ObjTProp(Obj o,int x) {
        o.propO.get(x);
    }

    //Permet de récupérer les Processus
    public void ObjTProc(Obj o,int x) {
        o.procO.get(x);
    }
*/
    //------------------------------------------------------------------------

    public class Obj {
        private Integer srcO;
        private Integer tgtO;
        private SystemElem systO;
        private String labelO;
        private boolean initO;
        private boolean accO;
        private String propO;
        private String procO;
        private type Type;

        public Obj(Integer src, Integer tgt, SystemElem syst,String label, boolean init, boolean acc, String prop, String proc) {
            super();
            this.srcO = src;
            this.tgtO = tgt;
            this.systO = syst;
            this.labelO = label;
            this.initO = init;
            this.accO = acc;
            this.propO = prop;
            this.procO = proc;
        }

        public Integer getSrc() {
            return this.srcO;
        }

        public void setSrc(Integer src) {
            this.srcO = src;
        }

        public Integer getTgt() {
            return this.tgtO;
        }

        public void setTgt(Integer tgt) {
            this.tgtO = tgt;
        }

        public SystemElem getSyst() {
            return this.systO;
        }

        public void setSyst(SystemElem syst) {
            this.systO = syst;
        }

        public String getLabel(){
            return this.labelO;
        }

        public void setLabel(String label){
            this.labelO = label;
        }

        public boolean getInit() {
            return this.initO;
        }

        public void setInit(boolean init) {
            this.initO = init;
        }

        public boolean getAcc() {
            return this.accO;
        }

        public void setAcc(boolean acc) {
            this.accO = acc;
        }

        public String getProp() {
            return this.propO;
        }

        public void setProp(String prop) {
            this.propO = prop;
        }

        public String getProc() {
            return this.procO;
        }

        public void setProc(String proc) {
            this.procO = proc;
        }

        public Obj selectType(type t) {
            switch (Type) {
                case SRC:
                    getSrc();

                case TGT:
                    getTgt();

                case SYST:
                    getSyst();

                case LAB:
                    getLabel();

                case INIT:
                    getInit();

                case ACC:
                    getAcc();

                case PROP:
                    getProp();

                case PROC:
                    getProc();

                default:
                    System.out.println("Invalid type");
            }
            return null;
        }
    }


    public class ObjComparator implements Comparator<Obj> {

        private type Type;

        public ObjComparator(type t) {
            this.Type = t;
        }

        @Override
        public int compare(Obj o1, Obj o2) {

            switch (Type) {
                case SRC:
                    int c = COLLATOR.compare(o1.getSrc(), o2.getSrc());
                    return c;

                case TGT:
                    c = COLLATOR.compare(o1.getTgt(), o2.getTgt());
                    return c;

                case SYST:
                    c = COLLATOR.compare(o1.getSyst(), o2.getSyst());
                    return c;

                case LAB:
                    c = COLLATOR.compare(o1.getLabel(), o2.getLabel());
                    return c;

                case INIT:
                    c = COLLATOR.compare(o1.getInit(), o2.getInit());
                    return c;

                case ACC:
                    c = COLLATOR.compare(o1.getAcc(), o2.getAcc());
                    return c;

                case PROP:
                    c = COLLATOR.compare(o1.getProp(), o2.getProp());
                    return c;

                case PROC:
                    c = COLLATOR.compare(o1.getProc(), o2.getProc());
                    return c;

                default:
                    System.out.println("Invalid choice");
                    return -2; // à revoir par la suite
            }
        }

    }
    //Class utile pour les fonctions succ, pred (pour le moment) a venir pour le reste des bonctions
    public class Données<E> extends ArrayList<E>{

        public Données() {
            super();
        }

        public ArrayList search(ArrayList L, type t1, type t2, type t3){
            ArrayList L2 = new ArrayList<Integer>();
            int cpt = 0,cptL=0, x=0, taille = L.size(),tailleL=ObjL.size(),i=0;
            boolean y = false, labelB = false;
            Iterator it = ObjL.iterator();
            //tri données
            if (t1==type.LAB){
                labelB = true;

            }
            if (dernierTri != t1) {
                //Collections.sort(ObjL, new ObjComparator(type.SRC));//tri en fonction des src
                Collections.sort(ObjL, new ObjComparator(t1));
                dernierTri = t1;
            }
            while (cpt<taille){
                while (cptL<tailleL){
                    if(L.get(cpt)==ObjL.get(cptL).selectType(t2)){
                        x = cptL;
                        break;
                    }
                    else x = -1;
                    cptL++;
                }
                if (x != -1){
                    y = true;
                    //print
                    if (labelB==true){
                        L2.add(ObjL.get(x).selectType(t3));
                    }
                    else {
                        L.add(ObjL.get(x).selectType(t3));
                    }
                    while (y == true) {
                        if (it.next() != L.get(cpt)){
                            y = false;
                            cptL++;
                            //supp tête list
                        }
                        else {
                            //print
                            if (labelB==true){
                                L2.add(ObjL.get(cpt).selectType(t3));
                            }
                            else {
                                L.add(ObjL.get(cpt).selectType(t3));
                            }
                            cptL++;
                        }
                    }
                }
                cpt++;
            }
            while(i<taille){

                L.remove(i);
                i++;
            }
            //Pas besoin de trier puisque que le tableau de donnée l'est, donc entré dans la liste trié
            if (labelB==true){
                return L2;
            }
            else {
                return L;
            }
        }
    }

    public enum type {
        SRC,    //DernierTri <=> 1
        TGT,    //DernierTri <=> 2
        SYST,   //DernierTri <=> 3
        LAB,  //DernierTri <=> 4
        INIT,   //DernierTri <=> 5
        ACC,    //DernierTri <=> 6
        PROP,   //DernierTri <=> 7
        PROC;   //DernierTri <=> 8
    }

}

