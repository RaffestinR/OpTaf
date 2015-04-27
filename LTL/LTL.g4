grammar LTL;

options {
  language = Java;
}
@header {
  package LTL;
}

// @lexer::header{ package LTL; }

@members {
  String res;
  
  public static String parserString(String s) throws Exception {
    CharStream input = new ANTLRInputStream(s);
    return parser(input);       
  }

  public static String parserFile(String s) throws Exception {
    CharStream input = new ANTLRFileStream(s);
    return parser(input);       
  }

  public static String parser(CharStream input) throws Exception {
    LTLLexer lexer = new LTLLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LTLParser parser = new LTLParser(tokens);
    parser.start();
       
      return parser.res;
  }
}
  
start   : f=formule
  {
    res = $f.b;
  }
  ;

formule returns [String b]
  : f1=multerm2 
  {
    $b = $f1.b;
  }
  ('||' f2=multerm2
  {
    $b = "|| " + $b + " " + $f2.b;
  }
  )*
  ;

multerm2 returns [String b]
  : f1=multerm1 
  {
    $b = $f1.b;
  }
  ('<->' f2=multerm1
  {
    $b = "<-> " + $b + " " + $f2.b;
  }
  )*
  ;



multerm1 returns [String b]
  : f1=multerm0 
  {
    $b = $f1.b;
  }
  ('->' f2=multerm0
  {
    $b = "-> " + $b + " " + $f2.b;
  }
  )?
  ;

multerm0 returns [String b]
  : f1=subterm 
  {
    $b = $f1.b;
  }  
 
  ('U' f2=subterm
  {
    $b = "U " + $f1.b + " " + $f2.b;
  }  
  )?
  ;

subterm returns [String b]
  : f1=atom
  {
    $b = $f1.b;
  }
  ('&&' f2=atom
  {
    $b = "&& " + $b + " " + $f2.b;
  }
  )*
  ;
    
atom  returns [String b]
  : 'X' f1=atom
  {
    $b = "X " + $f1.b;
  }
  | 'F' f1=atom
  {
    $b = "F " + $f1.b;
  }
  | 'G' f1=atom
  {
    $b = "G " + $f1.b;
  }
  | n=ID 
  {
    $b = "variable " + $n.text + " ";
  
  }
  |   'true'
  {
    $b = "true ";
  }
  |   'false'
  {
    $b = "false ";
  }
  | '(' f=formule ')'
  {
    $b = $f.b;
  }
  | '!' a=atom
  {
    $b = "! " + $a.b;
  }
  ;
  
NUM :('0'..'9')+
  ;
  
ID  :('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*
  ;

WS: (' '|'\t'|'\n')+  -> skip
  ; 
  
