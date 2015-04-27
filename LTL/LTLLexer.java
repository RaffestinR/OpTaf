// Generated from /home/couvreur/enseignement/M1-Verification/VeriTaf/LTL/LTL.g4 by ANTLR 4.4.1-dev

  package LTL;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, NUM=14, ID=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "NUM", "ID", "WS"
	};


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


	public LTLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LTL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\6\17K\n\17\r\17\16\17L\3\20\3\20\7\20Q\n\20\f\20\16"+
		"\20T\13\20\3\21\6\21W\n\21\r\21\16\21X\3\21\3\21\2\2\22\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2"+
		"\5\4\2C\\c|\5\2\62;C\\c|\4\2\13\f\"\"^\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5&\3\2\2\2\7)\3\2\2\2\t+\3\2"+
		"\2\2\13-\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23\67\3\2\2"+
		"\2\259\3\2\2\2\27?\3\2\2\2\31D\3\2\2\2\33F\3\2\2\2\35J\3\2\2\2\37N\3\2"+
		"\2\2!V\3\2\2\2#$\7/\2\2$%\7@\2\2%\4\3\2\2\2&\'\7~\2\2\'(\7~\2\2(\6\3\2"+
		"\2\2)*\7+\2\2*\b\3\2\2\2+,\7I\2\2,\n\3\2\2\2-.\7>\2\2./\7/\2\2/\60\7@"+
		"\2\2\60\f\3\2\2\2\61\62\7H\2\2\62\16\3\2\2\2\63\64\7*\2\2\64\20\3\2\2"+
		"\2\65\66\7Z\2\2\66\22\3\2\2\2\678\7W\2\28\24\3\2\2\29:\7h\2\2:;\7c\2\2"+
		";<\7n\2\2<=\7u\2\2=>\7g\2\2>\26\3\2\2\2?@\7v\2\2@A\7t\2\2AB\7w\2\2BC\7"+
		"g\2\2C\30\3\2\2\2DE\7#\2\2E\32\3\2\2\2FG\7(\2\2GH\7(\2\2H\34\3\2\2\2I"+
		"K\4\62;\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\36\3\2\2\2NR\t\2\2"+
		"\2OQ\t\3\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S \3\2\2\2TR\3\2\2"+
		"\2UW\t\4\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\21"+
		"\2\2[\"\3\2\2\2\6\2LRX\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}