package Systeme;

import java.util.ArrayList;

public class SystemeElem{
    public ArrayList<Boolean> nomProp;
    public ArrayList<Object> nomEtiq;

    public SystemeElem (SystemeElem s){
        this.nomProp=s.nomProp;
        this.nomEtiq=s.nomEtiq;
    }

    public ArrayList getNomEtiq() {
        return this.nomEtiq;

    }
}

