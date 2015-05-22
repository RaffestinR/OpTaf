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
        '+='
        {
            resS = tableS.get($i.text);
        } j=ID '<-' ctlb=ctlformule
        {
            if (resS !=null) {
                resS.addStateProperty($ctlb.b,$j.text);
            }
            else {
                System.err.println("La variable " + $i.text + "n'existe pas.");
            }
        }
        |   '='
        (
        (j=ID
            ( '->'
            {
                resS = tableS.get($j.text);
                if (resS ==null) {
                    System.err.println("La variable " + $j.text + "n'existe pas.");
                }
            }
            ctlb=ctlformule
            {
                if (resS !=null) {
                    Systeme res = resS.path($ctlb.b);
                    tableS.put($i.text,res);
                }
            }
            | '|' b=formule
            {
                Systeme s = tableS.get($j.text);
                if (s!=null) {
                    Systeme res = s.restrict($b.b);
                    res.reduce();
                    tableS.put($i.text,res);
                }
                else {
                    System.err.println("La variable " + $i.text + "n'existe pas.");
                }
            }
            )
        )
        |(
            (
            {
            boolean reduce = false;
            }
                ('reduce'
                {
                    reduce = true;
                }
                )?
                ( m=mso
                {
                    res = $m.val;
                }
                | automate
                | 'automaton' i1=ID
                {
                    Systeme systeme = tableS.get($i1.text);
                    if (systeme == null)
                        System.err.println($i1.text + " n'est pas défini comme un système");
                    else
                        res = systeme.toAutomaton();
                }
            )
            {
                if (reduce)
                res.reduce();
                table.put($i.text,res);
            }
        )
        |
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
  ))
  |
  'quit'
  | 'todot' f=fichier i2=ID
  {
    Automaton a = table.get($i2.text);
    if (a!=null)
      ecrire($f.val,a.toDot());
    else {
      Systeme s = tableS.get($i2.text);
      if (s!=null)
        ecrire($f.val,s.toDot());
      else {
        System.err.println("La variable " + $i2.text + " n'existe pas.");
      }
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
/*
mso returns [Automaton val]: m0=msoSimple
  {
    $val = $m0.val;
  }
  ('&&' m1=msoSimple
  {
    $val = $val.and($m1.val);
  }
  )*

  |
   'E.' i=ID m=mso
   {
      $val = $m.val.exists($i.text);
   }
;

 msoSimple returns [Automaton val] :
 (i=ID
 {
    $val = table.get($i.text);
 }
 | '(' m=mso
 {
    $val= $m.val;
 }
 ')')
 ('[' i0=ID '<-' f0=formule
    {
      ArrayList<String> ident = new ArrayList<String>();
      ArrayList<Bdd> bdd = new ArrayList<Bdd>();
      ident.add($i0.text);
      bdd.add($f0.b);
    }
    (','i1=ID '<-' f1=formule
    {
      ident.add($i1.text);
      bdd.add($f1.b);
    }
    )*
    {
      $val = $val.substitute(ident.toArray(new String[]{}),bdd.toArray(new Bdd[]{}));
    }
  ']')?
 ;


automate : '{'etat acc
    {
      res = new Automaton($etat.val, $acc.val);
    }
    init transition* '}';

etat returns [int val] : 'etat' '=' NUM ';'
  {
    $val = Integer.parseInt($NUM.text);
  }
;

acc returns [int val] : 'acc' '=' NUM ';'
  {
    $val = Integer.parseInt($NUM.text);
  }
;

init : 'init' '=' n0=NUM
   {
     res.addInitState(Integer.parseInt($n0.text));
   }
(',' n1=NUM
   {
     res.addInitState(Integer.parseInt($n1.text));
   }

)* ';';

transition : src=NUM '-' f=formule '->' tgt=NUM
  {
    ArrayList<Integer> acc = new ArrayList<Integer>();
  }
  ('[' n0=NUM
  {
    acc.add(Integer.parseInt($n0.text));
  }
  (',' n1=NUM
  {
    acc.add(Integer.parseInt($n1.text));
  }
  )* ']')? ';'
  {
    int[] accInt = new int[acc.size()];
    for (int i=0; i<acc.size(); i++)
      accInt[i] = acc.get(i);
    res.addTransition(Integer.parseInt($src.text),Integer.parseInt($tgt.text),$f.b,accInt);
  }
;

formule returns [Bdd b]
  : f1=multerm2
  {
    $b = $f1.b;
  }
  ('||' f2=multerm2
  {
    $b = $b.or($f2.b);
  }
  )*
  ;

multerm2 returns [Bdd b]
  : f1=multerm1
  {
    $b = $f1.b;
  }
  ('<->' f2=multerm1
  {
    $b = $b.equiv($f2.b);
  }
  )*
  ;

multerm1 returns [Bdd b]
  : f1=multerm0
  {
    $b = $f1.b;
  }
  ('->' f2=multerm0
  {
    $b = $b.imply($f2.b);
  }
  )?
  ;

multerm0 returns [Bdd b]
  : f1=subterm
  {
    $b = $f1.b;
  }
  ('&&' f2=subterm
  {
    $b = $b.and($f2.b);
  }
  )*
  ;

subterm  returns [Bdd b]
  :   n0=ID
  {
    StringBuffer s = new StringBuffer($n0.text);
  }
  ('.' n1=ID
    {
    s.append("." + $n1.text);
  }
  )*
  {
    $b = Bdd.variable(s.toString());
  }
  |   'true'
  {
    $b = Bdd.TRUE;
  }
  |   'false'
  {
    $b = Bdd.FALSE;
  }
  | 'ite' '(' f1=formule ',' f2=formule ',' f3=formule ')'
  {
    $b = Bdd.ite($f1.b,$f2.b,$f3.b) ;
  }
  | '(' f=formule ')'
  {
    $b = $f.b;
  }
  | '!' a=subterm
  {
    $b = $a.b.not();
  }
  ;*/

/*  formule ctl  */
/*
ctlformule returns [Bdd b]
  : f1=ctlmulterm2
  {
    $b = $f1.b;
  }
  ('||' f2=ctlmulterm2
  {
    $b = $b.or($f2.b);
  }
  )*
  ;

ctlmulterm2 returns [Bdd b]
  : f1=ctlmulterm1
  {
    $b = $f1.b;
  }
  ('<->' f2=ctlmulterm1
  {
    $b = $b.equiv($f2.b);
  }
  )*
  ;

ctlmulterm1 returns [Bdd b]
  : f1=ctlmulterm0
  {
    $b = $f1.b;
  }
  ('->' f2=ctlmulterm0
  {
    $b = $b.imply($f2.b);
  }
  )?
  ;

ctlmulterm0 returns [Bdd b]
  : f1=ctlsubterm
  {
    $b = $f1.b;
  }
  ('&&' f2=ctlsubterm
  {
    $b = $b.and($f2.b);
  }
  )*
  ;

ctlsubterm  returns [Bdd b]
  :   n0=ID
  {
    StringBuffer s = new StringBuffer($n0.text);
  }
  ('.' n1=ID
    {
    s.append("." + $n1.text);
  }
  )*
  {
    if (resS.isProp(s.toString()))
        $b = resS.prop(s.toString());
    else {
        System.err.println("La propriété " + s.toString() + " n'existe pas.");
        $b = Bdd.FALSE;
    }
  }

  |   'true'
  {
    $b = Bdd.TRUE;
  }
  |   'false'
  {
    $b = Bdd.FALSE;
  }
  | 'init'
  {
    $b = resS.getInit();
  }
  | 'ite(' f1=ctlformule ',' f2=ctlformule ',' f3=ctlformule ')'
  {
    $b = Bdd.ite($f1.b,$f2.b,$f3.b) ;
  }
  | '(' f=ctlformule ')'
  {
    $b = $f.b;
  }
  | '!' a=ctlsubterm
  {
    $b = $a.b.not();
  }
  | 'EX(' f=ctlformule ')'
  {
     $b = resS.EX($f.b);
  }
  | 'AX(' f=ctlformule ')'
  {
     $b = resS.AX($f.b);
  }
  | 'E(' f=ctlformule 'U' g=ctlformule ')'
  {
     $b = resS.EU($f.b,$g.b);
  }
  | 'A(' f=ctlformule 'U' g=ctlformule ')'
  {
     $b = resS.AU($f.b,$g.b);
  }
  | 'EF(' f=ctlformule ')'
  {
     $b = resS.EU(Bdd.TRUE,$f.b);
  }
  | 'AF(' f=ctlformule ')'
  {
     $b = resS.AU(Bdd.TRUE,$f.b);
  }
  | 'EG(' f=ctlformule ')'
  {
     $b = resS.AU(Bdd.TRUE,$f.b.not()).not();
  }
  | 'AG(' f=ctlformule ')'
  {
     $b = resS.EU(Bdd.TRUE,$f.b.not()).not();
  }
  ;*/



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