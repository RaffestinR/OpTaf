package systeme;

import systeme.SystemeElementaire;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class RE {

    private static Collator COLLATOR = Collator.getInstance(Locale.FRENCH);

    private List<Obj> ObjL = new ArrayList<Obj>();

  /*
  * initialisation à rajouter et autre fonction
  */

    public class Obj {
        private Integer srcO;
        private Integer tgtO;
        private SystemeElementaire systO;
      //  private label labelO;
        private boolean initO;
        private boolean accO;
        private String propO;
        private String procO;

        public Obj(Integer src, Integer tgt, SystemeElementaire syst,/*label label,*/ boolean init, boolean acc, String prop, String proc) {
            super();
            this.srcO = src;
            this.tgtO = tgt;
            this.systO = syst;
          //  this.labelO = label;
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

        public SystemeElementaire getSyst() {
            return this.systO;
        }

        public void setSyst(SystemeElementaire syst) {
            this.systO = syst;
        }

       /* public label getLabel(label label){
            this.labelO = label;
        }*/

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

        public void setPrenom(String proc) {
            this.procO = proc;
        }
    }


    public class ObjComparator implements Comparator<Obj> {

        private CompareType type;

        public ObjComparator(CompareType t) {
            this.type = t;
        }

        @Override
        public int compare(Obj o1, Obj o2) {

            switch (type) {
                case SRC:
                    int c = COLLATOR.compare(o1.getSrc(), o2.getSrc());
                    return c;


                case TGT:
                    c = COLLATOR.compare(o1.getTgt(), o2.getTgt());
                    return c;

                case SYST:
                    c = COLLATOR.compare(o1.getSyst(), o2.getSyst());
                    return c;

                /*case LABEL:
                    c = COLLATOR.compare(o1.getLabel(), o2.getLabel());
                    return c;
                    */
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
                    return 2; // à revoir par la suite

            }
        }
    }

    public enum CompareType {
        SRC,
        TGT,
        SYST,
        LABEL,
        INIT,
        ACC,
        PROP,
        PROC;
    }

}

/*
        à réutiliser par la suite


class Obj {
    ArrayList<Integer> srcO;
    ArrayList<Integer> tgtO;
    ArrayList<SystemeElementaire[]> systemeO;
   // ArrayList<label> labelO;
    ArrayList<Boolean> initO;
    ArrayList<Boolean> accO;
    ArrayList<String> propO;
    ArrayList<String> procO;

        public Obj (RE s){
            Obj o;
        }

        //Permet de récupérer les Successeurs
        public void ObjSucc(Obj o,int x){
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.tgtO.get(cpt);
                o.systemeO.get(cpt);
                //o.labelO.get(x);
                //le print
                cpt++;
            }
        }

        //Permet de récupérer les Predesseurs
        public void ObjPred(Obj o,int x){
             //tri en fonction des tgt
            int cpt=0;
            while (x != o.tgtO.get(cpt)){
                cpt++;
            }
            while (x == o.tgtO.get(cpt)){
                o.srcO.get(cpt);
                o.systemeO.get(cpt);
                //o.labelO.get(x);
                //le print
            cpt++;
        }
    }


        //Permet de récupérer les Trnasitions (utile?)
        public void ObjTrans(Obj o,int x) {
            //tri en fonction des src
            int cpt=0;
            while (x != o.srcO.get(cpt)){
                cpt++;
            }
            while (x == o.srcO.get(cpt)){
                o.srcO.get(cpt);
                o.tgtO.get(cpt);
                //print
                cpt++;
            }

        }

        //Permet de récupérer les états initiaux
        public void ObjInit(Obj o,int x){
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

        //Permet de récupérer les etats Accesseurs
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