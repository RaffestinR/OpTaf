package systeme;

import java.util.ArrayList;

public class SystemeElem{
    public ArrayList<Object> nomProp = new ArrayList();;
    public ArrayList<Object> nomEtiq = new ArrayList();;

    public SystemeElem (SystemeElem s){
        this.nomProp=s.nomProp;
        this.nomEtiq=s.nomEtiq;
    }

    public ArrayList getNomEtiq() {
        return this.nomEtiq;

    }


}

