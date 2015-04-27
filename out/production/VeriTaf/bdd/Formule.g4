grammar Formule;
@header {
	package bdd;
}

// @lexer::header{ package bdd; }

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
		FormuleLexer lexer = new FormuleLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FormuleParser parser = new FormuleParser(tokens);
		parser.start();
       
	    return parser.res;
	}
}

start 	: f=formule
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
	| 'E' '.' n=ID f=formule 
	{
		$b = "E " + $n.text + " " + $f.b;
	}
	| 'A' '.' n=ID f=formule 
	{
		$b = "A " + $n.text + " " + $f.b;
	}
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
	('&&' f2=subterm
	{
		$b = "&& " + $b + " " + $f2.b;
	}
	)*
	;
	
subterm returns [String b]
	: f1=atom 
	{
		$b = $f1.b;
		String sub = "";

	}
	( '[' n=ID '<-' f2=formule ']'
	{
		sub = sub + "sub " + $n.text + " " + $f2.b;
	}
	)*
	{
		if (!sub.equals(""))
			$b = sub + $b;
	}
	;
	
atom  returns [String b]
	: 	n=ID 
	{
		$b = "variable " + $n.text + " ";
	
	}
	| 	'true'
	{
		$b = "true ";
	}
	| 	'false'
	{
		$b = "false ";
	}
	|	'ite' '(' f1=formule ',' f2=formule ',' f3=formule ')'
	{
		$b = "ite " + $f1.b +$f2.b + $f3.b ;
	}
	|	'neg' '(' f=formule ',' n=ID ')'
	{
		$b = "neg " + $f.b + $n.text + " ";
	}
	| 	'pos' '(' f=formule ',' n=ID ')'
	{
		$b = "pos " + $f.b + $n.text + " ";
	}
	|	'(' f=formule ')'
	{
		$b = $f.b;
	}
	|	'!' a=atom
	{
		$b = "! " + $a.b;
	}
	;
	
NUM	:('0'..'9')+
 	;
 	
ID	:('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*
	;

WS: (' '|'\t'|'\n')+  -> skip
	;	
	
