// Generated from C:/Users/User/OpTaf/outil\Syst.g4 by ANTLR 4.5

  package outil;
  import systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SystParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, NUM=21, ID=22, WS=23, COMMENT=24;
	public static final int
		RULE_commandes = 0, RULE_commande = 1, RULE_fichier = 2, RULE_systeme = 3, 
		RULE_propS = 4, RULE_etatS = 5, RULE_initS = 6, RULE_etatPropS = 7, RULE_transitionS = 8, 
		RULE_synchro = 9, RULE_vecteur = 10;
	public static final String[] ruleNames = {
		"commandes", "commande", "fichier", "systeme", "propS", "etatS", "initS", 
		"etatPropS", "transitionS", "synchro", "vecteur"
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

	@Override
	public String getGrammarFileName() { return "Syst.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public SystParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandesContext extends ParserRuleContext {
		public List<CommandeContext> commande() {
			return getRuleContexts(CommandeContext.class);
		}
		public CommandeContext commande(int i) {
			return getRuleContext(CommandeContext.class,i);
		}
		public CommandesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterCommandes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitCommandes(this);
		}
	}

	public final CommandesContext commandes() throws RecognitionException {
		CommandesContext _localctx = new CommandesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_commandes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0)) {
				{
				{
				setState(22); 
				commande();
				setState(23); 
				match(T__0);
				}
				}
				setState(29);
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

	public static class CommandeContext extends ParserRuleContext {
		public Token i;
		public FichierContext f;
		public Token i2;
		public TerminalNode ID() { return getToken(SystParser.ID, 0); }
		public SystemeContext systeme() {
			return getRuleContext(SystemeContext.class,0);
		}
		public SynchroContext synchro() {
			return getRuleContext(SynchroContext.class,0);
		}
		public FichierContext fichier() {
			return getRuleContext(FichierContext.class,0);
		}
		public CommandeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commande; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterCommande(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitCommande(this);
		}
	}

	public final CommandeContext commande() throws RecognitionException {
		CommandeContext _localctx = new CommandeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commande);
		try {
			setState(50);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(30); 
				((CommandeContext)_localctx).i = match(ID);
				setState(31); 
				match(T__1);
				setState(38);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(32); 
					systeme();

					            tableS.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),resS);
					          
					}
					break;
				case T__18:
					{
					setState(35); 
					synchro();

					            table.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),P);
					          
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); 
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41); 
				match(T__3);
				setState(42); 
				((CommandeContext)_localctx).f = fichier();
				setState(43); 
				((CommandeContext)_localctx).i2 = match(ID);


				      Systeme s = tableS.get((((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null));
				      Produit p = table.get((((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null));
				      if (s!=null)
				        ecrire(((CommandeContext)_localctx).f.val,s.toDot());
				      else if (p!=null){
				        ecrire(((CommandeContext)_localctx).f.val,p.toDot());
				      }else{
				        System.err.println("La variable " + (((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null) + " n'existe pas.");
				      }

				  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46); 
				match(T__4);
				setState(47); 
				((CommandeContext)_localctx).f = fichier();

				  try {
				    parserFile(((CommandeContext)_localctx).f.val);
				  } catch (Exception e) {
				        System.err.println("problème de lecture du fichier " + (((CommandeContext)_localctx).f!=null?_input.getText(((CommandeContext)_localctx).f.start,((CommandeContext)_localctx).f.stop):null) + ".");
				  };
				  
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

	public static class FichierContext extends ParserRuleContext {
		public String val;
		public Token i;
		public Token i1;
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public FichierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fichier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterFichier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitFichier(this);
		}
	}

	public final FichierContext fichier() throws RecognitionException {
		FichierContext _localctx = new FichierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fichier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			    StringBuffer s= new StringBuffer();
			  
			setState(66);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(53); 
				match(T__5);

				    s.append("/");
				  
				}
				break;
			case T__6:
				{
				setState(55); 
				match(T__6);

				    s.append("./");
				  
				}
				break;
			case T__7:
				{
				setState(57); 
				match(T__7);

				    s.append("../");
				  
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(59); 
					match(T__7);

					    s.append("../");
					  
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(68); 
			((FichierContext)_localctx).i = match(ID);

			    s.append((((FichierContext)_localctx).i!=null?((FichierContext)_localctx).i.getText():null));
			  
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==T__8) {
				{
				{
				setState(74);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(70); 
					match(T__8);

					    s.append(".");
					  
					}
					break;
				case T__5:
					{
					setState(72); 
					match(T__5);

					    s.append("/");
					  
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); 
				((FichierContext)_localctx).i1 = match(ID);

				    s.append((((FichierContext)_localctx).i1!=null?((FichierContext)_localctx).i1.getText():null));
				  
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			    ((FichierContext)_localctx).val = s.toString();
			  
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

	public static class SystemeContext extends ParserRuleContext {
		public PropSContext p;
		public EtatSContext e;
		public InitSContext initS() {
			return getRuleContext(InitSContext.class,0);
		}
		public PropSContext propS() {
			return getRuleContext(PropSContext.class,0);
		}
		public EtatSContext etatS() {
			return getRuleContext(EtatSContext.class,0);
		}
		public List<EtatPropSContext> etatPropS() {
			return getRuleContexts(EtatPropSContext.class);
		}
		public EtatPropSContext etatPropS(int i) {
			return getRuleContext(EtatPropSContext.class,i);
		}
		public List<TransitionSContext> transitionS() {
			return getRuleContexts(TransitionSContext.class);
		}
		public TransitionSContext transitionS(int i) {
			return getRuleContext(TransitionSContext.class,i);
		}
		public SystemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systeme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterSysteme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitSysteme(this);
		}
	}

	public final SystemeContext systeme() throws RecognitionException {
		SystemeContext _localctx = new SystemeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_systeme);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			match(T__9);
			setState(86); 
			((SystemeContext)_localctx).p = propS();
			setState(87); 
			match(T__10);
			setState(88); 
			match(T__11);
			setState(89); 
			((SystemeContext)_localctx).e = etatS();

			      resS= new Systeme(((SystemeContext)_localctx).e.val,((SystemeContext)_localctx).p.val.toArray(new Object[]{}));
			  
			setState(91); 
			initS();
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92); 
					etatPropS();
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUM) {
				{
				{
				setState(98); 
				transitionS();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104); 
			match(T__12);
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

	public static class PropSContext extends ParserRuleContext {
		public ArrayList<Object> val;
		public Token i0;
		public Token i1;
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public PropSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterPropS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitPropS(this);
		}
	}

	public final PropSContext propS() throws RecognitionException {
		PropSContext _localctx = new PropSContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_propS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			switch (_input.LA(1)) {
			case T__10:
				{
				((PropSContext)_localctx).val =  new ArrayList<Object>();
				}
				break;
			case ID:
				{
				setState(107); 
				((PropSContext)_localctx).i0 = match(ID);

				    ((PropSContext)_localctx).val =  new ArrayList<Object>();
				    _localctx.val.add((((PropSContext)_localctx).i0!=null?((PropSContext)_localctx).i0.getText():null));

				  
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(109); 
					match(T__13);
					setState(110); 
					((PropSContext)_localctx).i1 = match(ID);

					    _localctx.val.add((((PropSContext)_localctx).i1!=null?((PropSContext)_localctx).i1.getText():null));

					  
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class EtatSContext extends ParserRuleContext {
		public int val;
		public Token n;
		public TerminalNode NUM() { return getToken(SystParser.NUM, 0); }
		public EtatSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etatS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterEtatS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitEtatS(this);
		}
	}

	public final EtatSContext etatS() throws RecognitionException {
		EtatSContext _localctx = new EtatSContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_etatS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); 
			match(T__14);
			setState(120); 
			match(T__1);
			setState(121); 
			((EtatSContext)_localctx).n = match(NUM);
			setState(122); 
			match(T__15);

			    ((EtatSContext)_localctx).val =  Integer.parseInt((((EtatSContext)_localctx).n!=null?((EtatSContext)_localctx).n.getText():null));
			  
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

	public static class InitSContext extends ParserRuleContext {
		public Token n0;
		public Token n1;
		public List<TerminalNode> NUM() { return getTokens(SystParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystParser.NUM, i);
		}
		public InitSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterInitS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitInitS(this);
		}
	}

	public final InitSContext initS() throws RecognitionException {
		InitSContext _localctx = new InitSContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_initS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			match(T__16);
			setState(126); 
			match(T__1);
			setState(127); 
			((InitSContext)_localctx).n0 = match(NUM);

			    if (resS.isState(Integer.parseInt((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null))))
			        resS.addInitState(Integer.parseInt((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null)));
			    else
			        System.err.println((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null) + " n'est pas un état.");
			  
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(129); 
				match(T__13);
				setState(130); 
				((InitSContext)_localctx).n1 = match(NUM);

				    if (resS.isState(Integer.parseInt((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null))))
				        resS.addInitState(Integer.parseInt((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null)));
				    else
				        System.err.println((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null) + " n'est pas un état.");
				  
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137); 
			match(T__15);
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

	public static class EtatPropSContext extends ParserRuleContext {
		public Token n;
		public Token i0;
		public Token i1;
		public TerminalNode NUM() { return getToken(SystParser.NUM, 0); }
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public EtatPropSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etatPropS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterEtatPropS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitEtatPropS(this);
		}
	}

	public final EtatPropSContext etatPropS() throws RecognitionException {
		EtatPropSContext _localctx = new EtatPropSContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_etatPropS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			((EtatPropSContext)_localctx).n = match(NUM);

			    int s = Integer.parseInt((((EtatPropSContext)_localctx).n!=null?((EtatPropSContext)_localctx).n.getText():null));
			    if (!resS.isState(s))
			        System.err.println(s + " n'est pas un état.");
			  
			setState(141); 
			match(T__1);
			setState(142); 
			((EtatPropSContext)_localctx).i0 = match(ID);

			    if (resS.isProp((((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null))){
			      resS.addStateProperty(s,(((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null));
			    }
			    else
			        System.err.println((((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null) + " n'est pas déclaré comme propriété.");
			    
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(144); 
				match(T__13);
				setState(145); 
				((EtatPropSContext)_localctx).i1 = match(ID);

				    if (resS.isProp((((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null))){
				        resS.addStateProperty(s,(((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null));}
				    else
				        System.err.println((((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null) + " n'est pas déclaré comme propriété.");
				  
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); 
			match(T__15);
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

	public static class TransitionSContext extends ParserRuleContext {
		public Token n0;
		public Token n1;
		public Token i0;
		public Token i1;
		public List<TerminalNode> NUM() { return getTokens(SystParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystParser.NUM, i);
		}
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public TransitionSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterTransitionS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitTransitionS(this);
		}
	}

	public final TransitionSContext transitionS() throws RecognitionException {
		TransitionSContext _localctx = new TransitionSContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transitionS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); 
			((TransitionSContext)_localctx).n0 = match(NUM);
			setState(155); 
			match(T__17);
			setState(156); 
			((TransitionSContext)_localctx).n1 = match(NUM);

			  int src = Integer.parseInt((((TransitionSContext)_localctx).n0!=null?((TransitionSContext)_localctx).n0.getText():null));
			  int tgt = Integer.parseInt((((TransitionSContext)_localctx).n1!=null?((TransitionSContext)_localctx).n1.getText():null));
			  boolean id = false;

			    if (!resS.isState(src))
			        System.err.println(src + " n'est pas un état.");
			    if (!resS.isState(tgt))
			        System.err.println(tgt + " n'est pas un état.");


			setState(170);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(158); 
				match(T__9);
				setState(159); 
				((TransitionSContext)_localctx).i0 = match(ID);

				  id = true;
				  resS.addTransition(src,tgt,(((TransitionSContext)_localctx).i0!=null?((TransitionSContext)_localctx).i0.getText():null));

				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(161); 
					match(T__13);
					setState(162); 
					((TransitionSContext)_localctx).i1 = match(ID);

					  resS.addTransition(src,tgt,(((TransitionSContext)_localctx).i1!=null?((TransitionSContext)_localctx).i1.getText():null));

					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169); 
				match(T__10);
				}
			}


			  if (!id)
			    resS.addTransition(src,tgt,"*");


			setState(173); 
			match(T__15);
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

	public static class SynchroContext extends ParserRuleContext {
		public Token i0;
		public Token i1;
		public Token i2;
		public Token i3;
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public List<VecteurContext> vecteur() {
			return getRuleContexts(VecteurContext.class);
		}
		public VecteurContext vecteur(int i) {
			return getRuleContext(VecteurContext.class,i);
		}
		public SynchroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterSynchro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitSynchro(this);
		}
	}

	public final SynchroContext synchro() throws RecognitionException {
		SynchroContext _localctx = new SynchroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_synchro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); 
			match(T__18);
			setState(176); 
			((SynchroContext)_localctx).i0 = match(ID);
			setState(177); 
			((SynchroContext)_localctx).i1 = match(ID);

			  ArrayList<Systeme> sys = new ArrayList<Systeme>();
			  ArrayList<String> nom = new ArrayList<String>();
			  sys.add(tableS.get((((SynchroContext)_localctx).i0!=null?((SynchroContext)_localctx).i0.getText():null)));
			  nom.add((((SynchroContext)_localctx).i1!=null?((SynchroContext)_localctx).i1.getText():null));

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(179); 
				match(T__13);
				setState(180); 
				((SynchroContext)_localctx).i2 = match(ID);
				setState(181); 
				((SynchroContext)_localctx).i3 = match(ID);

				  sys.add(tableS.get((((SynchroContext)_localctx).i2!=null?((SynchroContext)_localctx).i2.getText():null)));
				  nom.add((((SynchroContext)_localctx).i3!=null?((SynchroContext)_localctx).i3.getText():null));

				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			  P = new Produit(nom.toArray(new String[]{}), sys.toArray(new Systeme[]{}));

			setState(189); 
			match(T__19);
			setState(190); 
			match(T__11);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(191); 
				vecteur();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197); 
			match(T__12);

			     P.transP(sys);

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

	public static class VecteurContext extends ParserRuleContext {
		public Token i0;
		public Token i1;
		public List<TerminalNode> ID() { return getTokens(SystParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystParser.ID, i);
		}
		public VecteurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vecteur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).enterVecteur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystListener ) ((SystListener)listener).exitVecteur(this);
		}
	}

	public final VecteurContext vecteur() throws RecognitionException {
		VecteurContext _localctx = new VecteurContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vecteur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{


			  ArrayList<Object> synchro = new ArrayList<Object>();
			  
			setState(201); 
			match(T__18);
			setState(202); 
			((VecteurContext)_localctx).i0 = match(ID);

			  synchro.add((((VecteurContext)_localctx).i0!=null?((VecteurContext)_localctx).i0.getText():null));

			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(204); 
				match(T__13);
				setState(205); 
				((VecteurContext)_localctx).i1 = match(ID);

				  synchro.add((((VecteurContext)_localctx).i1!=null?((VecteurContext)_localctx).i1.getText():null));

				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212); 
			match(T__19);

			P.synchro(synchro);


			setState(214); 
			match(T__15);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00db\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3)\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\65\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13\4\5"+
		"\4E\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\4\3\4\7\4Q\n\4\f\4\16\4T\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5\16\5c\13\5\3\5"+
		"\7\5f\n\5\f\5\16\5i\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6s\n\6\f\6"+
		"\16\6v\13\6\5\6x\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\b\u0087\n\b\f\b\16\b\u008a\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\7\t\u0096\n\t\f\t\16\t\u0099\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00a7\n\n\f\n\16\n\u00aa\13\n\3\n\5\n\u00ad\n\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ba\n\13\f"+
		"\13\16\13\u00bd\13\13\3\13\3\13\3\13\3\13\7\13\u00c3\n\13\f\13\16\13\u00c6"+
		"\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d2\n\f\f\f\16"+
		"\f\u00d5\13\f\3\f\3\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2"+
		"\u00e5\2\35\3\2\2\2\4\64\3\2\2\2\6\66\3\2\2\2\bW\3\2\2\2\nw\3\2\2\2\f"+
		"y\3\2\2\2\16\177\3\2\2\2\20\u008d\3\2\2\2\22\u009c\3\2\2\2\24\u00b1\3"+
		"\2\2\2\26\u00ca\3\2\2\2\30\31\5\4\3\2\31\32\7\3\2\2\32\34\3\2\2\2\33\30"+
		"\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35"+
		"\3\2\2\2 !\7\30\2\2!(\7\4\2\2\"#\5\b\5\2#$\b\3\1\2$)\3\2\2\2%&\5\24\13"+
		"\2&\'\b\3\1\2\')\3\2\2\2(\"\3\2\2\2(%\3\2\2\2)\65\3\2\2\2*\65\7\5\2\2"+
		"+,\7\6\2\2,-\5\6\4\2-.\7\30\2\2./\b\3\1\2/\65\3\2\2\2\60\61\7\7\2\2\61"+
		"\62\5\6\4\2\62\63\b\3\1\2\63\65\3\2\2\2\64 \3\2\2\2\64*\3\2\2\2\64+\3"+
		"\2\2\2\64\60\3\2\2\2\65\5\3\2\2\2\66D\b\4\1\2\678\7\b\2\28E\b\4\1\29:"+
		"\7\t\2\2:E\b\4\1\2;<\7\n\2\2<A\b\4\1\2=>\7\n\2\2>@\b\4\1\2?=\3\2\2\2@"+
		"C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2\2D\67\3\2\2\2D9\3\2\2"+
		"\2D;\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\30\2\2GR\b\4\1\2HI\7\13\2\2IM\b\4"+
		"\1\2JK\7\b\2\2KM\b\4\1\2LH\3\2\2\2LJ\3\2\2\2MN\3\2\2\2NO\7\30\2\2OQ\b"+
		"\4\1\2PL\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\b"+
		"\4\1\2V\7\3\2\2\2WX\7\f\2\2XY\5\n\6\2YZ\7\r\2\2Z[\7\16\2\2[\\\5\f\7\2"+
		"\\]\b\5\1\2]a\5\16\b\2^`\5\20\t\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2bg\3\2\2\2ca\3\2\2\2df\5\22\n\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3"+
		"\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7\17\2\2k\t\3\2\2\2lx\b\6\1\2mn\7\30\2\2"+
		"nt\b\6\1\2op\7\20\2\2pq\7\30\2\2qs\b\6\1\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wl\3\2\2\2wm\3\2\2\2x\13\3\2\2\2yz\7\21"+
		"\2\2z{\7\4\2\2{|\7\27\2\2|}\7\22\2\2}~\b\7\1\2~\r\3\2\2\2\177\u0080\7"+
		"\23\2\2\u0080\u0081\7\4\2\2\u0081\u0082\7\27\2\2\u0082\u0088\b\b\1\2\u0083"+
		"\u0084\7\20\2\2\u0084\u0085\7\27\2\2\u0085\u0087\b\b\1\2\u0086\u0083\3"+
		"\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\22\2\2\u008c\17\3\2\2"+
		"\2\u008d\u008e\7\27\2\2\u008e\u008f\b\t\1\2\u008f\u0090\7\4\2\2\u0090"+
		"\u0091\7\30\2\2\u0091\u0097\b\t\1\2\u0092\u0093\7\20\2\2\u0093\u0094\7"+
		"\30\2\2\u0094\u0096\b\t\1\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7\22\2\2\u009b\21\3\2\2\2\u009c\u009d\7\27\2\2\u009d"+
		"\u009e\7\24\2\2\u009e\u009f\7\27\2\2\u009f\u00ac\b\n\1\2\u00a0\u00a1\7"+
		"\f\2\2\u00a1\u00a2\7\30\2\2\u00a2\u00a8\b\n\1\2\u00a3\u00a4\7\20\2\2\u00a4"+
		"\u00a5\7\30\2\2\u00a5\u00a7\b\n\1\2\u00a6\u00a3\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ad\7\r\2\2\u00ac\u00a0\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\n\1\2\u00af\u00b0\7\22\2\2\u00b0"+
		"\23\3\2\2\2\u00b1\u00b2\7\25\2\2\u00b2\u00b3\7\30\2\2\u00b3\u00b4\7\30"+
		"\2\2\u00b4\u00bb\b\13\1\2\u00b5\u00b6\7\20\2\2\u00b6\u00b7\7\30\2\2\u00b7"+
		"\u00b8\7\30\2\2\u00b8\u00ba\b\13\1\2\u00b9\u00b5\3\2\2\2\u00ba\u00bd\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00bf\b\13\1\2\u00bf\u00c0\7\26\2\2\u00c0\u00c4\7"+
		"\16\2\2\u00c1\u00c3\5\26\f\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c8\7\17\2\2\u00c8\u00c9\b\13\1\2\u00c9\25\3\2\2\2\u00ca"+
		"\u00cb\b\f\1\2\u00cb\u00cc\7\25\2\2\u00cc\u00cd\7\30\2\2\u00cd\u00d3\b"+
		"\f\1\2\u00ce\u00cf\7\20\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00d2\b\f\1\2\u00d1"+
		"\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\26\2\2\u00d7"+
		"\u00d8\b\f\1\2\u00d8\u00d9\7\22\2\2\u00d9\27\3\2\2\2\24\35(\64ADLRagt"+
		"w\u0088\u0097\u00a8\u00ac\u00bb\u00c4\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}