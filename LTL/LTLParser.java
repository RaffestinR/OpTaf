// Generated from /home/couvreur/enseignement/M1-Verification/VeriTaf/LTL/LTL.g4 by ANTLR 4.4.1-dev

  package LTL;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, NUM=14, ID=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "'->'", "'||'", "')'", "'G'", "'<->'", "'F'", "'('", "'X'", 
		"'U'", "'false'", "'true'", "'!'", "'&&'", "NUM", "ID", "WS"
	};
	public static final int
		RULE_start = 0, RULE_formule = 1, RULE_multerm2 = 2, RULE_multerm1 = 3, 
		RULE_multerm0 = 4, RULE_subterm = 5, RULE_atom = 6;
	public static final String[] ruleNames = {
		"start", "formule", "multerm2", "multerm1", "multerm0", "subterm", "atom"
	};

	@Override
	public String getGrammarFileName() { return "LTL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public LTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public FormuleContext f;
		public FormuleContext formule() {
			return getRuleContext(FormuleContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); ((StartContext)_localctx).f = formule();

			    res = ((StartContext)_localctx).f.b;
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormuleContext extends ParserRuleContext {
		public String b;
		public Multerm2Context f1;
		public Multerm2Context f2;
		public List<Multerm2Context> multerm2() {
			return getRuleContexts(Multerm2Context.class);
		}
		public Multerm2Context multerm2(int i) {
			return getRuleContext(Multerm2Context.class,i);
		}
		public FormuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterFormule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitFormule(this);
		}
	}

	public final FormuleContext formule() throws RecognitionException {
		FormuleContext _localctx = new FormuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); ((FormuleContext)_localctx).f1 = multerm2();

			    ((FormuleContext)_localctx).b =  ((FormuleContext)_localctx).f1.b;
			  
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(19); match(T__11);
				setState(20); ((FormuleContext)_localctx).f2 = multerm2();

				    ((FormuleContext)_localctx).b =  "|| " + _localctx.b + " " + ((FormuleContext)_localctx).f2.b;
				  
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multerm2Context extends ParserRuleContext {
		public String b;
		public Multerm1Context f1;
		public Multerm1Context f2;
		public Multerm1Context multerm1(int i) {
			return getRuleContext(Multerm1Context.class,i);
		}
		public List<Multerm1Context> multerm1() {
			return getRuleContexts(Multerm1Context.class);
		}
		public Multerm2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multerm2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterMulterm2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitMulterm2(this);
		}
	}

	public final Multerm2Context multerm2() throws RecognitionException {
		Multerm2Context _localctx = new Multerm2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_multerm2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); ((Multerm2Context)_localctx).f1 = multerm1();

			    ((Multerm2Context)_localctx).b =  ((Multerm2Context)_localctx).f1.b;
			  
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(30); match(T__8);
				setState(31); ((Multerm2Context)_localctx).f2 = multerm1();

				    ((Multerm2Context)_localctx).b =  "<-> " + _localctx.b + " " + ((Multerm2Context)_localctx).f2.b;
				  
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multerm1Context extends ParserRuleContext {
		public String b;
		public Multerm0Context f1;
		public Multerm0Context f2;
		public List<Multerm0Context> multerm0() {
			return getRuleContexts(Multerm0Context.class);
		}
		public Multerm0Context multerm0(int i) {
			return getRuleContext(Multerm0Context.class,i);
		}
		public Multerm1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multerm1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterMulterm1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitMulterm1(this);
		}
	}

	public final Multerm1Context multerm1() throws RecognitionException {
		Multerm1Context _localctx = new Multerm1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_multerm1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); ((Multerm1Context)_localctx).f1 = multerm0();

			    ((Multerm1Context)_localctx).b =  ((Multerm1Context)_localctx).f1.b;
			  
			setState(45);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(41); match(T__12);
				setState(42); ((Multerm1Context)_localctx).f2 = multerm0();

				    ((Multerm1Context)_localctx).b =  "-> " + _localctx.b + " " + ((Multerm1Context)_localctx).f2.b;
				  
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multerm0Context extends ParserRuleContext {
		public String b;
		public SubtermContext f1;
		public SubtermContext f2;
		public List<SubtermContext> subterm() {
			return getRuleContexts(SubtermContext.class);
		}
		public SubtermContext subterm(int i) {
			return getRuleContext(SubtermContext.class,i);
		}
		public Multerm0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multerm0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterMulterm0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitMulterm0(this);
		}
	}

	public final Multerm0Context multerm0() throws RecognitionException {
		Multerm0Context _localctx = new Multerm0Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_multerm0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); ((Multerm0Context)_localctx).f1 = subterm();

			    ((Multerm0Context)_localctx).b =  ((Multerm0Context)_localctx).f1.b;
			  
			setState(53);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(49); match(T__4);
				setState(50); ((Multerm0Context)_localctx).f2 = subterm();

				    ((Multerm0Context)_localctx).b =  "U " + ((Multerm0Context)_localctx).f1.b + " " + ((Multerm0Context)_localctx).f2.b;
				  
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtermContext extends ParserRuleContext {
		public String b;
		public AtomContext f1;
		public AtomContext f2;
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public SubtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterSubterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitSubterm(this);
		}
	}

	public final SubtermContext subterm() throws RecognitionException {
		SubtermContext _localctx = new SubtermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); ((SubtermContext)_localctx).f1 = atom();

			    ((SubtermContext)_localctx).b =  ((SubtermContext)_localctx).f1.b;
			  
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(57); match(T__0);
				setState(58); ((SubtermContext)_localctx).f2 = atom();

				    ((SubtermContext)_localctx).b =  "&& " + _localctx.b + " " + ((SubtermContext)_localctx).f2.b;
				  
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public String b;
		public AtomContext f1;
		public Token n;
		public FormuleContext f;
		public AtomContext a;
		public FormuleContext formule() {
			return getRuleContext(FormuleContext.class,0);
		}
		public TerminalNode ID() { return getToken(LTLParser.ID, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); match(T__5);
				setState(67); ((AtomContext)_localctx).f1 = atom();

				    ((AtomContext)_localctx).b =  "X " + ((AtomContext)_localctx).f1.b;
				  
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(T__7);
				setState(71); ((AtomContext)_localctx).f1 = atom();

				    ((AtomContext)_localctx).b =  "F " + ((AtomContext)_localctx).f1.b;
				  
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(74); match(T__9);
				setState(75); ((AtomContext)_localctx).f1 = atom();

				    ((AtomContext)_localctx).b =  "G " + ((AtomContext)_localctx).f1.b;
				  
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(78); ((AtomContext)_localctx).n = match(ID);

				    ((AtomContext)_localctx).b =  "variable " + (((AtomContext)_localctx).n!=null?((AtomContext)_localctx).n.getText():null) + " ";
				  
				  
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(80); match(T__2);

				    ((AtomContext)_localctx).b =  "true ";
				  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 6);
				{
				setState(82); match(T__3);

				    ((AtomContext)_localctx).b =  "false ";
				  
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(84); match(T__6);
				setState(85); ((AtomContext)_localctx).f = formule();
				setState(86); match(T__10);

				    ((AtomContext)_localctx).b =  ((AtomContext)_localctx).f.b;
				  
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 8);
				{
				setState(89); match(T__1);
				setState(90); ((AtomContext)_localctx).a = atom();

				    ((AtomContext)_localctx).b =  "! " + ((AtomContext)_localctx).a.b;
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4%\n\4"+
		"\f\4\16\4(\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\68\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7@\n\7\f\7\16\7C\13\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2f"+
		"\2\20\3\2\2\2\4\23\3\2\2\2\6\36\3\2\2\2\b)\3\2\2\2\n\61\3\2\2\2\f9\3\2"+
		"\2\2\16_\3\2\2\2\20\21\5\4\3\2\21\22\b\2\1\2\22\3\3\2\2\2\23\24\5\6\4"+
		"\2\24\33\b\3\1\2\25\26\7\4\2\2\26\27\5\6\4\2\27\30\b\3\1\2\30\32\3\2\2"+
		"\2\31\25\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5\3\2\2"+
		"\2\35\33\3\2\2\2\36\37\5\b\5\2\37&\b\4\1\2 !\7\7\2\2!\"\5\b\5\2\"#\b\4"+
		"\1\2#%\3\2\2\2$ \3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\7\3\2\2\2(&"+
		"\3\2\2\2)*\5\n\6\2*/\b\5\1\2+,\7\3\2\2,-\5\n\6\2-.\b\5\1\2.\60\3\2\2\2"+
		"/+\3\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\61\62\5\f\7\2\62\67\b\6\1\2\63\64"+
		"\7\13\2\2\64\65\5\f\7\2\65\66\b\6\1\2\668\3\2\2\2\67\63\3\2\2\2\678\3"+
		"\2\2\28\13\3\2\2\29:\5\16\b\2:A\b\7\1\2;<\7\17\2\2<=\5\16\b\2=>\b\7\1"+
		"\2>@\3\2\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\r\3\2\2\2CA\3\2"+
		"\2\2DE\7\n\2\2EF\5\16\b\2FG\b\b\1\2G`\3\2\2\2HI\7\b\2\2IJ\5\16\b\2JK\b"+
		"\b\1\2K`\3\2\2\2LM\7\6\2\2MN\5\16\b\2NO\b\b\1\2O`\3\2\2\2PQ\7\21\2\2Q"+
		"`\b\b\1\2RS\7\r\2\2S`\b\b\1\2TU\7\f\2\2U`\b\b\1\2VW\7\t\2\2WX\5\4\3\2"+
		"XY\7\5\2\2YZ\b\b\1\2Z`\3\2\2\2[\\\7\16\2\2\\]\5\16\b\2]^\b\b\1\2^`\3\2"+
		"\2\2_D\3\2\2\2_H\3\2\2\2_L\3\2\2\2_P\3\2\2\2_R\3\2\2\2_T\3\2\2\2_V\3\2"+
		"\2\2_[\3\2\2\2`\17\3\2\2\2\b\33&/\67A_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}