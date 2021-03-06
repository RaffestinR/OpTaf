// Generated from C:/Users/User/OpTaf/outil\Syst.g4 by ANTLR 4.5

  package outil;
  import systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, NUM=21, ID=22, WS=23, COMMENT=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "NUM", "ID", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';;'", "'='", "'quit'", "'todot'", "'load'", "'/'", "'./'", "'../'", 
		"'.'", "'['", "']'", "'{'", "'}'", "','", "'etat'", "';'", "'init'", "'->'", 
		"'<'", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "NUM", "ID", "WS", 
		"COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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


	public SystLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Syst.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\6\26r\n\26\r\26\16\26s\3\27\3\27\7\27x\n\27\f\27\16\27{\13\27\3\30\6"+
		"\30~\n\30\r\30\16\30\177\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0088\n\31"+
		"\f\31\16\31\u008b\13\31\3\31\5\31\u008e\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u0095\n\31\f\31\16\31\u0098\13\31\3\31\3\31\5\31\u009c\n\31\3\31"+
		"\3\31\3\u0096\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\6"+
		"\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\f\"\"\4\2\f\f\17\17\u00a5\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\3\63\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\t=\3\2\2\2\13C\3\2\2\2\rH\3"+
		"\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31"+
		"W\3\2\2\2\33Y\3\2\2\2\35[\3\2\2\2\37]\3\2\2\2!b\3\2\2\2#d\3\2\2\2%i\3"+
		"\2\2\2\'l\3\2\2\2)n\3\2\2\2+q\3\2\2\2-u\3\2\2\2/}\3\2\2\2\61\u009b\3\2"+
		"\2\2\63\64\7=\2\2\64\65\7=\2\2\65\4\3\2\2\2\66\67\7?\2\2\67\6\3\2\2\2"+
		"89\7s\2\29:\7w\2\2:;\7k\2\2;<\7v\2\2<\b\3\2\2\2=>\7v\2\2>?\7q\2\2?@\7"+
		"f\2\2@A\7q\2\2AB\7v\2\2B\n\3\2\2\2CD\7n\2\2DE\7q\2\2EF\7c\2\2FG\7f\2\2"+
		"G\f\3\2\2\2HI\7\61\2\2I\16\3\2\2\2JK\7\60\2\2KL\7\61\2\2L\20\3\2\2\2M"+
		"N\7\60\2\2NO\7\60\2\2OP\7\61\2\2P\22\3\2\2\2QR\7\60\2\2R\24\3\2\2\2ST"+
		"\7]\2\2T\26\3\2\2\2UV\7_\2\2V\30\3\2\2\2WX\7}\2\2X\32\3\2\2\2YZ\7\177"+
		"\2\2Z\34\3\2\2\2[\\\7.\2\2\\\36\3\2\2\2]^\7g\2\2^_\7v\2\2_`\7c\2\2`a\7"+
		"v\2\2a \3\2\2\2bc\7=\2\2c\"\3\2\2\2de\7k\2\2ef\7p\2\2fg\7k\2\2gh\7v\2"+
		"\2h$\3\2\2\2ij\7/\2\2jk\7@\2\2k&\3\2\2\2lm\7>\2\2m(\3\2\2\2no\7@\2\2o"+
		"*\3\2\2\2pr\4\62;\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t,\3\2\2\2"+
		"uy\t\2\2\2vx\t\3\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z.\3\2\2\2"+
		"{y\3\2\2\2|~\t\4\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\30\2\2\u0082\60\3\2\2\2\u0083\u0084"+
		"\7\61\2\2\u0084\u0085\7\61\2\2\u0085\u0089\3\2\2\2\u0086\u0088\n\5\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\7\17\2\2"+
		"\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u009c"+
		"\7\f\2\2\u0090\u0091\7\61\2\2\u0091\u0092\7,\2\2\u0092\u0096\3\2\2\2\u0093"+
		"\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0097\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009a\7,\2\2\u009a\u009c\7\61\2\2\u009b\u0083\3\2\2\2\u009b\u0090\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009e\b\31\2\2\u009e\62\3\2\2\2\n\2sy\177"+
		"\u0089\u008d\u0096\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}