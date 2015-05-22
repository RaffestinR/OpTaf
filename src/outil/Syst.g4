grammar Syst;

options {
  language = Java;
}

@header {
  package outil;
  import Systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;

}

/* @lexer::header{ package outil;
  import bdd.*;
  import mso.*;
  import systeme.*;
}

Automaton res;
static HashMap<String,Automaton> table = new HashMap<String,Automaton>();
*/
@members {

  Systeme resS;

  static HashMap<String,Systeme> tableS = new HashMap<String,Systeme>();


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

commande : (i=ID
    (

        ( systeme
        {
            tableS.put($i.text,resS);
        }
        | synchro
        {
            tableS.put($i.text,resS);
        }
        )
    )
  )

  |
  'quit'
  | 'todot' f=fichier i2=ID
  {

      Systeme s = tableS.get($i2.text);
      if (s!=null)
        ecrire($f.val,s.toDot());
      else {
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
      resS= new Systeme($e.val,$p.val.toArray(new String[]{}));
  }
  initS etatPropS* transitionS* '}'
  {
          resS.reduce();
  }
  ;

propS  returns [ArrayList<String> val]://on ne s'y interesse pas de suite
(    {$val = new ArrayList<String>();}

|
    i0=ID
  {
    $val = new ArrayList<String>();
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
    if (resS.isProp($i0.text))
        resS.addStateProperty(s,$i0.text);
    else
        System.err.println($i0.text + " n'est pas déclaré comme propriété.");
  }
  (',' i1=ID
  {
    if (resS.isProp($i1.text))
        resS.addStateProperty(s,$i1.text);
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

synchro  : '<' i0=ID  i1=ID // pas de modification ici dans l'imédiat.
{
  ArrayList<Systeme> sys = new ArrayList<Systeme>();
  ArrayList<String> nom = new ArrayList<String>();
  sys.add(tableS.get($i0.text));
  nom.add($i1.text);
}
(',' i2=ID  i3=ID
{
  sys.add(tableS.get($i2.text));
  nom.add($i3.text);
}
)*
{
  resS = new Systeme(nom.toArray(new String[]{}), sys.toArray(new Systeme[]{}));
}
'>' '{' vecteur* '}'
{
     resS.reduce();
}
;
//modif à réaliser. premier try

vecteur : {
  ArrayList<Object> synchro = new ArrayList<Object>();
  }
'<' i0=ID
{
  synchro.add($i0.text);
}
(',' i1=ID
{
  synchro.add($i1.text);
}
)* '>'
{
resS.addTransition(synchro);
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