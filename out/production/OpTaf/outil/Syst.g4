grammar Syst;

options {

  language = Java;

}

@header {
  package outil;
  import systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;

}

@members {
  Systeme resS;
  Produit P;
  static HashMap<String,Systeme> tableS = new HashMap<String,Systeme>();
  static HashMap<String,Produit> table = new HashMap<String,Produit>();

  public static void parserString(String s) throws Exception {
    CharStream input = new ANTLRInputStream(s);
    parser(input);
  }

  public static void parserFile(String s) throws Exception {
    CharStream input = new ANTLRFileStream(s);
    parser(input);
  }

  public static void parser(CharStream input) throws Exception {
    SystLexer lexer = new SystLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    SystParser parser = new SystParser(tokens);
    parser.commandes();
  }

    public static void ecrire(String fichier, String texte) {
    try {
      PrintStream f = new PrintStream(new File(fichier));
      f.print(texte);
      f.close();
    } catch (Exception e) {
      System.err.println("Probleme d'ecriture !");
    }
  }
}

commandes : (commande ';;')*;

commande : (i=ID   '='
          ( systeme
          {
            tableS.put($i.text,resS);
          }
          | synchro
          {
            table.put($i.text,P);
          }
          )

    )
  |
  'quit'
  | 'todot' f=fichier i2=ID
  {

      Systeme s = tableS.get($i2.text);
      Produit p = table.get($i2.text);
      if (s!=null)
        ecrire($f.val,s.toDot());
      else if (p!=null){
        ecrire($f.val,p.toDot());
      }else{
        System.err.println("La variable " + $i2.text + " n'existe pas.");
      }

  }
  | 'load' f=fichier
  {
  try {
    parserFile($f.val);
  } catch (Exception e) {
        System.err.println("problème de lecture du fichier " + $f.text + ".");
  };
  }
  ;

  fichier returns [String val]:
  {
    StringBuffer s= new StringBuffer();
  }
  ('/'
  {
    s.append("/");
  }
  |'./'
  {
    s.append("./");
  }
  | '../'
  {
    s.append("../");
  }
  ('../'
  {
    s.append("../");
  }
  )*

  )? i=ID
  {
    s.append($i.text);
  }
  (('.'
  {
    s.append(".");
  }
  |'/'
  {
    s.append("/");
  }
  ) i1=ID
  {
    s.append($i1.text);
  }

  )*
  {
    $val=s.toString();
  };

//---------------------------------------------

systeme : '[' p=propS ']' '{' e=etatS

  {
      resS= new Systeme($e.val,$p.val.toArray(new Object[]{}));
  }
  initS etatPropS* transitionS* '}'
  /*{
          resS.reduce();
  }*/
  ;
//resS.addProp($i0.text);
//resS.addProp($i1.text);
propS  returns [ArrayList<Object> val]://on ne s'y interesse pas de suite
(    {$val = new ArrayList<Object>();}//précedemment String et non Object

|
    i0=ID //première ligne au dessous semble obligatoire,si non à modofer
  {
    $val = new ArrayList<Object>();
    $val.add($i0.text);

  }
   (',' i1=ID
  {
    $val.add($i1.text);

  }
   )*
   )
;
//surement à modifier
etatS returns [int val]: 'etat' '=' n=NUM ';'
  {
    $val = Integer.parseInt($n.text);
  }
;


initS :'init' '=' n0=NUM
  {
    if (resS.isState(Integer.parseInt($n0.text)))
        resS.addInitState(Integer.parseInt($n0.text));
    else
        System.err.println($n0.text + " n'est pas un état.");
  }
  (',' n1=NUM
  {
    if (resS.isState(Integer.parseInt($n1.text)))
        resS.addInitState(Integer.parseInt($n1.text));
    else
        System.err.println($n1.text + " n'est pas un état.");
  }
  )* ';'
  ;

etatPropS: n=NUM//on ne s'y interesse pas de suite
  {
    int s = Integer.parseInt($n.text);
    if (!resS.isState(s))
        System.err.println(s + " n'est pas un état.");
  }
  '=' i0=ID
  {
    if (resS.isProp($i0.text)){
      resS.addStateProperty(s,$i0.text);
    }
    else
        System.err.println($i0.text + " n'est pas déclaré comme propriété.");
    }

  (',' i1=ID
  {
    if (resS.isProp($i1.text)){
        resS.addStateProperty(s,$i1.text);}
    else
        System.err.println($i1.text + " n'est pas déclaré comme propriété.");
  }
  )* ';';

transitionS: n0=NUM '->' n1=NUM //fonction addTransition associé réalisé. Aucune modif apporté ici.
{
  int src = Integer.parseInt($n0.text);
  int tgt = Integer.parseInt($n1.text);
  boolean id = false;

    if (!resS.isState(src))
        System.err.println(src + " n'est pas un état.");
    if (!resS.isState(tgt))
        System.err.println(tgt + " n'est pas un état.");

}
('[' i0=ID
{
  id = true;
  resS.addTransition(src,tgt,$i0.text);
}
(',' i1=ID
{
  resS.addTransition(src,tgt,$i1.text);
}
)* ']')?
{
  if (!id)
    resS.addTransition(src,tgt,"*");

}
';';

synchro  : '<' i0=ID  i1=ID
{System.out.println("\n -  Synchro Debut(g4)  - \n");
  ArrayList<Systeme> sys = new ArrayList<Systeme>();
  System.out.println("system : " + sys);
  ArrayList<String> nom = new ArrayList<String>();
  System.out.println("nomSystem : " + nom);
  sys.add(tableS.get($i0.text));
  System.out.println("system : " + sys);
  nom.add($i1.text);
  System.out.println("nomSystem : " + nom);
}
(',' i2=ID  i3=ID
{
  sys.add(tableS.get($i2.text));
  System.out.println("system : " + sys);
  nom.add($i3.text);
  System.out.println("nomSystem : " + nom);
}
)*//.toArray(new Systeme[]{})
{System.out.println("system : " + sys);
   System.out.println("nomSystem : " + nom);
  P = new Produit(nom.toArray(new String[]{}), sys.toArray(new Systeme[]{}));
  System.out.println("Produit : " + P);
  System.out.println("\n -  Synchro Phase 2(g4)  - \n");
}
'>' '{' vecteur* '}'
{
     System.out.println("transP AV(g4) : " +P.transP);
     P.transP(sys);
     System.out.println("transP AV(g4) : " +P.transP);
     System.out.println("\n -  Synchro Fin(g4)  - \n");
}
;

//modif à réaliser. premier try

vecteur : {
System.out.println("\n -- Vecteur Debut(g4) -- \n");
  ArrayList<Object> synchro = new ArrayList<Object>();
  System.out.println("synchro ini : " + synchro);
  }
'<' i0=ID
{System.out.println("synchro AV : " + synchro);
  synchro.add($i0.text);
  System.out.println("synchro AP : " + synchro);
}
(',' i1=ID
{System.out.println("synchro AV : " + synchro);
  synchro.add($i1.text);
  System.out.println("synchro AP : " + synchro);
}
)*
'>'

/*{
resS.addTransition(synchro);
}*/
{
System.out.println("synchro Final : " + synchro);
System.out.println("\n ---Synchro(fct) Debut(g4)--- \n");
P.synchro(synchro);
System.out.println("\n ---Synchro(fct) Fin(g4)--- \n");
System.out.println("\n -- Vecteur Fin(g4) -- \n");

}

';'

;


NUM :('0'..'9')+
  ;

ID  :('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
  ;


WS: (' '|'\t'|'\n')+  -> skip
  ;

  COMMENT
      :   ( '//' ~[\r\n]* '\r'? '\n'
          | '/*' .*? '*/'
          ) -> skip
      ;