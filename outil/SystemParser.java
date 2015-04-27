// Generated from C:/Users/User/Desktop/OpTaf/outil\System.g4 by ANTLR 4.5

  package outil;
  import bdd.*;
  import mso.*;
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
public class SystemParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, NUM=48, ID=49, WS=50, COMMENT=51;
	public static final int
		RULE_commandes = 0, RULE_commande = 1, RULE_fichier = 2, RULE_systeme = 3, 
		RULE_propS = 4, RULE_etatS = 5, RULE_initS = 6, RULE_etatPropS = 7, RULE_transitionS = 8, 
		RULE_synchro = 9, RULE_vecteur = 10, RULE_mso = 11, RULE_msoSimple = 12, 
		RULE_automate = 13, RULE_etat = 14, RULE_acc = 15, RULE_init = 16, RULE_transition = 17, 
		RULE_formule = 18, RULE_multerm2 = 19, RULE_multerm1 = 20, RULE_multerm0 = 21, 
		RULE_subterm = 22, RULE_ctlformule = 23, RULE_ctlmulterm2 = 24, RULE_ctlmulterm1 = 25, 
		RULE_ctlmulterm0 = 26, RULE_ctlsubterm = 27;
	public static final String[] ruleNames = {
		"commandes", "commande", "fichier", "systeme", "propS", "etatS", "initS", 
		"etatPropS", "transitionS", "synchro", "vecteur", "mso", "msoSimple", 
		"automate", "etat", "acc", "init", "transition", "formule", "multerm2", 
		"multerm1", "multerm0", "subterm", "ctlformule", "ctlmulterm2", "ctlmulterm1", 
		"ctlmulterm0", "ctlsubterm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';;'", "'+='", "'<-'", "'='", "'->'", "'|'", "'reduce'", "'automaton'", 
		"'quit'", "'todot'", "'load'", "'/'", "'./'", "'../'", "'.'", "'['", "']'", 
		"'{'", "'}'", "','", "'etat'", "';'", "'init'", "'<'", "'>'", "'&&'", 
		"'E.'", "'('", "')'", "'acc'", "'-'", "'||'", "'<->'", "'true'", "'false'", 
		"'ite'", "'!'", "'ite('", "'EX('", "'AX('", "'E('", "'U'", "'A('", "'EF('", 
		"'AF('", "'EG('", "'AG('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUM", "ID", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "System.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  Automaton res;
	  Systeme resS;
	  static HashMap<String,Automaton> table = new HashMap<String,Automaton>();
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
	    AutomateLexer lexer = new AutomateLexer(input);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    AutomateParser parser = new AutomateParser(tokens);
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

	public SystemParser(TokenStream input) {
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCommandes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCommandes(this);
		}
	}

	public final CommandesContext commandes() throws RecognitionException {
		CommandesContext _localctx = new CommandesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_commandes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << ID))) != 0)) {
				{
				{
				setState(56); 
				commande();
				setState(57); 
				match(T__0);
				}
				}
				setState(63);
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
		public Token j;
		public CtlformuleContext ctlb;
		public FormuleContext b;
		public MsoContext m;
		public Token i1;
		public FichierContext f;
		public Token i2;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public CtlformuleContext ctlformule() {
			return getRuleContext(CtlformuleContext.class,0);
		}
		public SystemeContext systeme() {
			return getRuleContext(SystemeContext.class,0);
		}
		public SynchroContext synchro() {
			return getRuleContext(SynchroContext.class,0);
		}
		public FormuleContext formule() {
			return getRuleContext(FormuleContext.class,0);
		}
		public AutomateContext automate() {
			return getRuleContext(AutomateContext.class,0);
		}
		public MsoContext mso() {
			return getRuleContext(MsoContext.class,0);
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCommande(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCommande(this);
		}
	}

	public final CommandeContext commande() throws RecognitionException {
		CommandeContext _localctx = new CommandeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commande);
		int _la;
		try {
			setState(124);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(64); 
				((CommandeContext)_localctx).i = match(ID);
				setState(112);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(65); 
					match(T__1);

					            resS = tableS.get((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null));
					        
					setState(67); 
					((CommandeContext)_localctx).j = match(ID);
					setState(68); 
					match(T__2);
					setState(69); 
					((CommandeContext)_localctx).ctlb = ctlformule();

					            if (resS !=null) {
					                resS.addStateProperty(((CommandeContext)_localctx).ctlb.b,(((CommandeContext)_localctx).j!=null?((CommandeContext)_localctx).j.getText():null));
					            }
					            else {
					                System.err.println("La variable " + (((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null) + "n'existe pas.");
					            }
					        
					}
					break;
				case T__3:
					{
					setState(72); 
					match(T__3);
					setState(110);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						{
						setState(73); 
						((CommandeContext)_localctx).j = match(ID);
						setState(83);
						switch (_input.LA(1)) {
						case T__4:
							{
							setState(74); 
							match(T__4);

							                resS = tableS.get((((CommandeContext)_localctx).j!=null?((CommandeContext)_localctx).j.getText():null));
							                if (resS ==null) {
							                    System.err.println("La variable " + (((CommandeContext)_localctx).j!=null?((CommandeContext)_localctx).j.getText():null) + "n'existe pas.");
							                }
							            
							setState(76); 
							((CommandeContext)_localctx).ctlb = ctlformule();

							                if (resS !=null) {
							                    Systeme res = resS.path(((CommandeContext)_localctx).ctlb.b);
							                    tableS.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),res);
							                }
							            
							}
							break;
						case T__5:
							{
							setState(79); 
							match(T__5);
							setState(80); 
							((CommandeContext)_localctx).b = formule();

							                Systeme s = tableS.get((((CommandeContext)_localctx).j!=null?((CommandeContext)_localctx).j.getText():null));
							                if (s!=null) {
							                    Systeme res = s.restrict(((CommandeContext)_localctx).b.b);
							                    res.reduce();
							                    tableS.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),res);
							                }
							                else {
							                    System.err.println("La variable " + (((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null) + "n'existe pas.");
							                }
							            
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						break;
					case 2:
						{
						setState(108);
						switch (_input.LA(1)) {
						case T__6:
						case T__7:
						case T__17:
						case T__26:
						case T__27:
						case ID:
							{
							{

							            boolean reduce = false;
							            
							setState(88);
							_la = _input.LA(1);
							if (_la==T__6) {
								{
								setState(86); 
								match(T__6);

								                    reduce = true;
								                
								}
							}

							setState(97);
							switch (_input.LA(1)) {
							case T__26:
							case T__27:
							case ID:
								{
								setState(90); 
								((CommandeContext)_localctx).m = mso();

								                    res = ((CommandeContext)_localctx).m.val;
								                
								}
								break;
							case T__17:
								{
								setState(93); 
								automate();
								}
								break;
							case T__7:
								{
								setState(94); 
								match(T__7);
								setState(95); 
								((CommandeContext)_localctx).i1 = match(ID);

								                    Systeme systeme = tableS.get((((CommandeContext)_localctx).i1!=null?((CommandeContext)_localctx).i1.getText():null));
								                    if (systeme == null)
								                        System.err.println((((CommandeContext)_localctx).i1!=null?((CommandeContext)_localctx).i1.getText():null) + " n'est pas défini comme un système");
								                    else
								                        res = systeme.toAutomaton();
								                
								}
								break;
							default:
								throw new NoViableAltException(this);
							}

							                if (reduce)
							                res.reduce();
							                table.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),res);
							            
							}
							}
							break;
						case T__15:
						case T__23:
							{
							setState(106);
							switch (_input.LA(1)) {
							case T__15:
								{
								setState(100); 
								systeme();

								            tableS.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),resS);
								        
								}
								break;
							case T__23:
								{
								setState(103); 
								synchro();

								            tableS.put((((CommandeContext)_localctx).i!=null?((CommandeContext)_localctx).i.getText():null),resS);
								        
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(114); 
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(115); 
				match(T__9);
				setState(116); 
				((CommandeContext)_localctx).f = fichier();
				setState(117); 
				((CommandeContext)_localctx).i2 = match(ID);

				    Automaton a = table.get((((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null));
				    if (a!=null)
				      ecrire(((CommandeContext)_localctx).f.val,a.toDot());
				    else {
				      Systeme s = tableS.get((((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null));
				      if (s!=null)
				        ecrire(((CommandeContext)_localctx).f.val,s.toDot());
				      else {
				        System.err.println("La variable " + (((CommandeContext)_localctx).i2!=null?((CommandeContext)_localctx).i2.getText():null) + " n'existe pas.");
				      }
				    }
				  
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(120); 
				match(T__10);
				setState(121); 
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
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public FichierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fichier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterFichier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitFichier(this);
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
			  
			setState(140);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(127); 
				match(T__11);

				    s.append("/");
				  
				}
				break;
			case T__12:
				{
				setState(129); 
				match(T__12);

				    s.append("./");
				  
				}
				break;
			case T__13:
				{
				setState(131); 
				match(T__13);

				    s.append("../");
				  
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(133); 
					match(T__13);

					    s.append("../");
					  
					}
					}
					setState(139);
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
			setState(142); 
			((FichierContext)_localctx).i = match(ID);

			    s.append((((FichierContext)_localctx).i!=null?((FichierContext)_localctx).i.getText():null));
			  
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__14) {
				{
				{
				setState(148);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(144); 
					match(T__14);

					    s.append(".");
					  
					}
					break;
				case T__11:
					{
					setState(146); 
					match(T__11);

					    s.append("/");
					  
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(150); 
				((FichierContext)_localctx).i1 = match(ID);

				    s.append((((FichierContext)_localctx).i1!=null?((FichierContext)_localctx).i1.getText():null));
				  
				}
				}
				setState(156);
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterSysteme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitSysteme(this);
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
			setState(159); 
			match(T__15);
			setState(160); 
			((SystemeContext)_localctx).p = propS();
			setState(161); 
			match(T__16);
			setState(162); 
			match(T__17);
			setState(163); 
			((SystemeContext)_localctx).e = etatS();

			      resS= new Systeme(((SystemeContext)_localctx).e.val,((SystemeContext)_localctx).p.val.toArray(new String[]{}));
			  
			setState(165); 
			initS();
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166); 
					etatPropS();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUM) {
				{
				{
				setState(172); 
				transitionS();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178); 
			match(T__18);

			          resS.reduce();
			  
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
		public ArrayList<String> val;
		public Token i0;
		public Token i1;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public PropSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterPropS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitPropS(this);
		}
	}

	public final PropSContext propS() throws RecognitionException {
		PropSContext _localctx = new PropSContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_propS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			switch (_input.LA(1)) {
			case T__16:
				{
				((PropSContext)_localctx).val =  new ArrayList<String>();
				}
				break;
			case ID:
				{
				setState(182); 
				((PropSContext)_localctx).i0 = match(ID);

				    ((PropSContext)_localctx).val =  new ArrayList<String>();
				    _localctx.val.add((((PropSContext)_localctx).i0!=null?((PropSContext)_localctx).i0.getText():null));
				  
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(184); 
					match(T__19);
					setState(185); 
					((PropSContext)_localctx).i1 = match(ID);

					    _localctx.val.add((((PropSContext)_localctx).i1!=null?((PropSContext)_localctx).i1.getText():null));
					  
					}
					}
					setState(191);
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
		public TerminalNode NUM() { return getToken(SystemParser.NUM, 0); }
		public EtatSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etatS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterEtatS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitEtatS(this);
		}
	}

	public final EtatSContext etatS() throws RecognitionException {
		EtatSContext _localctx = new EtatSContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_etatS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); 
			match(T__20);
			setState(195); 
			match(T__3);
			setState(196); 
			((EtatSContext)_localctx).n = match(NUM);
			setState(197); 
			match(T__21);

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
		public List<TerminalNode> NUM() { return getTokens(SystemParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystemParser.NUM, i);
		}
		public InitSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterInitS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitInitS(this);
		}
	}

	public final InitSContext initS() throws RecognitionException {
		InitSContext _localctx = new InitSContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_initS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); 
			match(T__22);
			setState(201); 
			match(T__3);
			setState(202); 
			((InitSContext)_localctx).n0 = match(NUM);

			    if (resS.isState(Integer.parseInt((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null))))
			        resS.addInitState(Integer.parseInt((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null)));
			    else
			        System.err.println((((InitSContext)_localctx).n0!=null?((InitSContext)_localctx).n0.getText():null) + " n'est pas un état.");
			  
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(204); 
				match(T__19);
				setState(205); 
				((InitSContext)_localctx).n1 = match(NUM);

				    if (resS.isState(Integer.parseInt((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null))))
				        resS.addInitState(Integer.parseInt((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null)));
				    else
				        System.err.println((((InitSContext)_localctx).n1!=null?((InitSContext)_localctx).n1.getText():null) + " n'est pas un état.");
				  
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212); 
			match(T__21);
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
		public TerminalNode NUM() { return getToken(SystemParser.NUM, 0); }
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public EtatPropSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etatPropS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterEtatPropS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitEtatPropS(this);
		}
	}

	public final EtatPropSContext etatPropS() throws RecognitionException {
		EtatPropSContext _localctx = new EtatPropSContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_etatPropS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); 
			((EtatPropSContext)_localctx).n = match(NUM);

			    int s = Integer.parseInt((((EtatPropSContext)_localctx).n!=null?((EtatPropSContext)_localctx).n.getText():null));
			    if (!resS.isState(s))
			        System.err.println(s + " n'est pas un état.");
			  
			setState(216); 
			match(T__3);
			setState(217); 
			((EtatPropSContext)_localctx).i0 = match(ID);

			    if (resS.isProp((((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null)))
			        resS.addStateProperty(s,(((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null));
			    else
			        System.err.println((((EtatPropSContext)_localctx).i0!=null?((EtatPropSContext)_localctx).i0.getText():null) + " n'est pas déclaré comme propriété.");
			  
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(219); 
				match(T__19);
				setState(220); 
				((EtatPropSContext)_localctx).i1 = match(ID);

				    if (resS.isProp((((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null)))
				        resS.addStateProperty(s,(((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null));
				    else
				        System.err.println((((EtatPropSContext)_localctx).i1!=null?((EtatPropSContext)_localctx).i1.getText():null) + " n'est pas déclaré comme propriété.");
				  
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227); 
			match(T__21);
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
		public List<TerminalNode> NUM() { return getTokens(SystemParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystemParser.NUM, i);
		}
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public TransitionSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterTransitionS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitTransitionS(this);
		}
	}

	public final TransitionSContext transitionS() throws RecognitionException {
		TransitionSContext _localctx = new TransitionSContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transitionS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); 
			((TransitionSContext)_localctx).n0 = match(NUM);
			setState(230); 
			match(T__4);
			setState(231); 
			((TransitionSContext)_localctx).n1 = match(NUM);

			  int src = Integer.parseInt((((TransitionSContext)_localctx).n0!=null?((TransitionSContext)_localctx).n0.getText():null));
			  int tgt = Integer.parseInt((((TransitionSContext)_localctx).n1!=null?((TransitionSContext)_localctx).n1.getText():null));
			  boolean id = false;

			    if (!resS.isState(src))
			        System.err.println(src + " n'est pas un état.");
			    if (!resS.isState(tgt))
			        System.err.println(tgt + " n'est pas un état.");


			setState(245);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(233); 
				match(T__15);
				setState(234); 
				((TransitionSContext)_localctx).i0 = match(ID);

				  id = true;
				  resS.addTransition(src,tgt,(((TransitionSContext)_localctx).i0!=null?((TransitionSContext)_localctx).i0.getText():null));

				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(236); 
					match(T__19);
					setState(237); 
					((TransitionSContext)_localctx).i1 = match(ID);

					  resS.addTransition(src,tgt,(((TransitionSContext)_localctx).i1!=null?((TransitionSContext)_localctx).i1.getText():null));

					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244); 
				match(T__16);
				}
			}


			  if (!id)
			    resS.addTransition(src,tgt);

			setState(248); 
			match(T__21);
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
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterSynchro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitSynchro(this);
		}
	}

	public final SynchroContext synchro() throws RecognitionException {
		SynchroContext _localctx = new SynchroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_synchro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); 
			match(T__23);
			setState(251); 
			((SynchroContext)_localctx).i0 = match(ID);
			setState(252); 
			((SynchroContext)_localctx).i1 = match(ID);

			   ArrayList<Systeme> sys = new ArrayList<Systeme>();
			   ArrayList<String> nom = new ArrayList<String>();
			   sys.add(tableS.get((((SynchroContext)_localctx).i0!=null?((SynchroContext)_localctx).i0.getText():null)));
			   nom.add((((SynchroContext)_localctx).i1!=null?((SynchroContext)_localctx).i1.getText():null));
			 
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(254); 
				match(T__19);
				setState(255); 
				((SynchroContext)_localctx).i2 = match(ID);
				setState(256); 
				((SynchroContext)_localctx).i3 = match(ID);

				   sys.add(tableS.get((((SynchroContext)_localctx).i2!=null?((SynchroContext)_localctx).i2.getText():null)));
				   nom.add((((SynchroContext)_localctx).i3!=null?((SynchroContext)_localctx).i3.getText():null));
				 
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			   resS = new Systeme(nom.toArray(new String[]{}), sys.toArray(new Systeme[]{}));
			 
			setState(264); 
			match(T__24);
			setState(265); 
			match(T__17);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(266); 
				vecteur();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272); 
			match(T__18);

			      resS.reduce();
			 
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
		public Token i2;
		public Token i3;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public VecteurContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vecteur; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterVecteur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitVecteur(this);
		}
	}

	public final VecteurContext vecteur() throws RecognitionException {
		VecteurContext _localctx = new VecteurContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vecteur);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			   ArrayList<String> synchro = new ArrayList<String>();
			   
			setState(276); 
			match(T__23);
			setState(277); 
			((VecteurContext)_localctx).i0 = match(ID);

			   synchro.add((((VecteurContext)_localctx).i0!=null?((VecteurContext)_localctx).i0.getText():null));
			 
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(279); 
				match(T__19);
				setState(280); 
				((VecteurContext)_localctx).i1 = match(ID);

				   synchro.add((((VecteurContext)_localctx).i1!=null?((VecteurContext)_localctx).i1.getText():null));
				 
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287); 
			match(T__24);

			   boolean id = false;
			 
			setState(300);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(289); 
				match(T__4);
				setState(290); 
				((VecteurContext)_localctx).i2 = match(ID);

				   id = true;
				   resS.addTransition(synchro.toArray(new String[]{}),(((VecteurContext)_localctx).i2!=null?((VecteurContext)_localctx).i2.getText():null));
				 
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(292); 
					match(T__19);
					setState(293); 
					((VecteurContext)_localctx).i3 = match(ID);

					   resS.addTransition(synchro.toArray(new String[]{}),(((VecteurContext)_localctx).i3!=null?((VecteurContext)_localctx).i3.getText():null));
					 
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(302); 
			match(T__21);

			   if (!id)
			     resS.addTransition(synchro.toArray(new String[]{}));
			 
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

	public static class MsoContext extends ParserRuleContext {
		public Automaton val;
		public MsoSimpleContext m0;
		public MsoSimpleContext m1;
		public Token i;
		public MsoContext m;
		public List<MsoSimpleContext> msoSimple() {
			return getRuleContexts(MsoSimpleContext.class);
		}
		public MsoSimpleContext msoSimple(int i) {
			return getRuleContext(MsoSimpleContext.class,i);
		}
		public TerminalNode ID() { return getToken(SystemParser.ID, 0); }
		public MsoContext mso() {
			return getRuleContext(MsoContext.class,0);
		}
		public MsoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterMso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitMso(this);
		}
	}

	public final MsoContext mso() throws RecognitionException {
		MsoContext _localctx = new MsoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mso);
		int _la;
		try {
			setState(321);
			switch (_input.LA(1)) {
			case T__27:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(305); 
				((MsoContext)_localctx).m0 = msoSimple();
				 
				    ((MsoContext)_localctx).val =  ((MsoContext)_localctx).m0.val;
				  
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__25) {
					{
					{
					setState(307); 
					match(T__25);
					setState(308); 
					((MsoContext)_localctx).m1 = msoSimple();

					    ((MsoContext)_localctx).val =  _localctx.val.and(((MsoContext)_localctx).m1.val);
					  
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(316); 
				match(T__26);
				setState(317); 
				((MsoContext)_localctx).i = match(ID);
				setState(318); 
				((MsoContext)_localctx).m = mso();

				      ((MsoContext)_localctx).val =  ((MsoContext)_localctx).m.val.exists((((MsoContext)_localctx).i!=null?((MsoContext)_localctx).i.getText():null));
				   
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

	public static class MsoSimpleContext extends ParserRuleContext {
		public Automaton val;
		public Token i;
		public MsoContext m;
		public Token i0;
		public FormuleContext f0;
		public Token i1;
		public FormuleContext f1;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public MsoContext mso() {
			return getRuleContext(MsoContext.class,0);
		}
		public List<FormuleContext> formule() {
			return getRuleContexts(FormuleContext.class);
		}
		public FormuleContext formule(int i) {
			return getRuleContext(FormuleContext.class,i);
		}
		public MsoSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msoSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterMsoSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitMsoSimple(this);
		}
	}

	public final MsoSimpleContext msoSimple() throws RecognitionException {
		MsoSimpleContext _localctx = new MsoSimpleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_msoSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(323); 
				((MsoSimpleContext)_localctx).i = match(ID);

				    ((MsoSimpleContext)_localctx).val =  table.get((((MsoSimpleContext)_localctx).i!=null?((MsoSimpleContext)_localctx).i.getText():null));
				 
				}
				break;
			case T__27:
				{
				setState(325); 
				match(T__27);
				setState(326); 
				((MsoSimpleContext)_localctx).m = mso();

				    ((MsoSimpleContext)_localctx).val =  ((MsoSimpleContext)_localctx).m.val;
				 
				setState(328); 
				match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(351);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(332); 
				match(T__15);
				setState(333); 
				((MsoSimpleContext)_localctx).i0 = match(ID);
				setState(334); 
				match(T__2);
				setState(335); 
				((MsoSimpleContext)_localctx).f0 = formule();

				      ArrayList<String> ident = new ArrayList<String>();
				      ArrayList<Bdd> bdd = new ArrayList<Bdd>();
				      ident.add((((MsoSimpleContext)_localctx).i0!=null?((MsoSimpleContext)_localctx).i0.getText():null));
				      bdd.add(((MsoSimpleContext)_localctx).f0.b);
				    
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(337); 
					match(T__19);
					setState(338); 
					((MsoSimpleContext)_localctx).i1 = match(ID);
					setState(339); 
					match(T__2);
					setState(340); 
					((MsoSimpleContext)_localctx).f1 = formule();

					      ident.add((((MsoSimpleContext)_localctx).i1!=null?((MsoSimpleContext)_localctx).i1.getText():null));
					      bdd.add(((MsoSimpleContext)_localctx).f1.b);
					    
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				      ((MsoSimpleContext)_localctx).val =  _localctx.val.substitute(ident.toArray(new String[]{}),bdd.toArray(new Bdd[]{}));
				    
				setState(349); 
				match(T__16);
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

	public static class AutomateContext extends ParserRuleContext {
		public EtatContext etat;
		public AccContext acc;
		public EtatContext etat() {
			return getRuleContext(EtatContext.class,0);
		}
		public AccContext acc() {
			return getRuleContext(AccContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public AutomateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterAutomate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitAutomate(this);
		}
	}

	public final AutomateContext automate() throws RecognitionException {
		AutomateContext _localctx = new AutomateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_automate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353); 
			match(T__17);
			setState(354); 
			((AutomateContext)_localctx).etat = etat();
			setState(355); 
			((AutomateContext)_localctx).acc = acc();

			      res = new Automaton(((AutomateContext)_localctx).etat.val, ((AutomateContext)_localctx).acc.val); 
			    
			setState(357); 
			init();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUM) {
				{
				{
				setState(358); 
				transition();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364); 
			match(T__18);
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

	public static class EtatContext extends ParserRuleContext {
		public int val;
		public Token NUM;
		public TerminalNode NUM() { return getToken(SystemParser.NUM, 0); }
		public EtatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterEtat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitEtat(this);
		}
	}

	public final EtatContext etat() throws RecognitionException {
		EtatContext _localctx = new EtatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_etat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); 
			match(T__20);
			setState(367); 
			match(T__3);
			setState(368); 
			((EtatContext)_localctx).NUM = match(NUM);
			setState(369); 
			match(T__21);

			    ((EtatContext)_localctx).val =  Integer.parseInt((((EtatContext)_localctx).NUM!=null?((EtatContext)_localctx).NUM.getText():null));
			  
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

	public static class AccContext extends ParserRuleContext {
		public int val;
		public Token NUM;
		public TerminalNode NUM() { return getToken(SystemParser.NUM, 0); }
		public AccContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterAcc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitAcc(this);
		}
	}

	public final AccContext acc() throws RecognitionException {
		AccContext _localctx = new AccContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_acc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372); 
			match(T__29);
			setState(373); 
			match(T__3);
			setState(374); 
			((AccContext)_localctx).NUM = match(NUM);
			setState(375); 
			match(T__21);

			    ((AccContext)_localctx).val =  Integer.parseInt((((AccContext)_localctx).NUM!=null?((AccContext)_localctx).NUM.getText():null));
			  
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

	public static class InitContext extends ParserRuleContext {
		public Token n0;
		public Token n1;
		public List<TerminalNode> NUM() { return getTokens(SystemParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystemParser.NUM, i);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); 
			match(T__22);
			setState(379); 
			match(T__3);
			setState(380); 
			((InitContext)_localctx).n0 = match(NUM);

			     res.addInitState(Integer.parseInt((((InitContext)_localctx).n0!=null?((InitContext)_localctx).n0.getText():null)));
			   
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(382); 
				match(T__19);
				setState(383); 
				((InitContext)_localctx).n1 = match(NUM);

				     res.addInitState(Integer.parseInt((((InitContext)_localctx).n1!=null?((InitContext)_localctx).n1.getText():null)));
				   
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(390); 
			match(T__21);
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

	public static class TransitionContext extends ParserRuleContext {
		public Token src;
		public FormuleContext f;
		public Token tgt;
		public Token n0;
		public Token n1;
		public List<TerminalNode> NUM() { return getTokens(SystemParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(SystemParser.NUM, i);
		}
		public FormuleContext formule() {
			return getRuleContext(FormuleContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_transition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); 
			((TransitionContext)_localctx).src = match(NUM);
			setState(393); 
			match(T__30);
			setState(394); 
			((TransitionContext)_localctx).f = formule();
			setState(395); 
			match(T__4);
			setState(396); 
			((TransitionContext)_localctx).tgt = match(NUM);

			    ArrayList<Integer> acc = new ArrayList<Integer>();
			  
			setState(410);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(398); 
				match(T__15);
				setState(399); 
				((TransitionContext)_localctx).n0 = match(NUM);

				    acc.add(Integer.parseInt((((TransitionContext)_localctx).n0!=null?((TransitionContext)_localctx).n0.getText():null)));
				  
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19) {
					{
					{
					setState(401); 
					match(T__19);
					setState(402); 
					((TransitionContext)_localctx).n1 = match(NUM);

					    acc.add(Integer.parseInt((((TransitionContext)_localctx).n1!=null?((TransitionContext)_localctx).n1.getText():null)));
					  
					}
					}
					setState(408);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(409); 
				match(T__16);
				}
			}

			setState(412); 
			match(T__21);

			    int[] accInt = new int[acc.size()];
			    for (int i=0; i<acc.size(); i++)
			      accInt[i] = acc.get(i);
			    res.addTransition(Integer.parseInt((((TransitionContext)_localctx).src!=null?((TransitionContext)_localctx).src.getText():null)),Integer.parseInt((((TransitionContext)_localctx).tgt!=null?((TransitionContext)_localctx).tgt.getText():null)),((TransitionContext)_localctx).f.b,accInt);
			  
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
		public Bdd b;
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterFormule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitFormule(this);
		}
	}

	public final FormuleContext formule() throws RecognitionException {
		FormuleContext _localctx = new FormuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_formule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); 
			((FormuleContext)_localctx).f1 = multerm2();

			    ((FormuleContext)_localctx).b =  ((FormuleContext)_localctx).f1.b;
			  
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(417); 
				match(T__31);
				setState(418); 
				((FormuleContext)_localctx).f2 = multerm2();

				    ((FormuleContext)_localctx).b =  _localctx.b.or(((FormuleContext)_localctx).f2.b);
				  
				}
				}
				setState(425);
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
		public Bdd b;
		public Multerm1Context f1;
		public Multerm1Context f2;
		public List<Multerm1Context> multerm1() {
			return getRuleContexts(Multerm1Context.class);
		}
		public Multerm1Context multerm1(int i) {
			return getRuleContext(Multerm1Context.class,i);
		}
		public Multerm2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multerm2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterMulterm2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitMulterm2(this);
		}
	}

	public final Multerm2Context multerm2() throws RecognitionException {
		Multerm2Context _localctx = new Multerm2Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_multerm2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426); 
			((Multerm2Context)_localctx).f1 = multerm1();

			    ((Multerm2Context)_localctx).b =  ((Multerm2Context)_localctx).f1.b;
			  
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(428); 
				match(T__32);
				setState(429); 
				((Multerm2Context)_localctx).f2 = multerm1();

				    ((Multerm2Context)_localctx).b =  _localctx.b.equiv(((Multerm2Context)_localctx).f2.b);
				  
				}
				}
				setState(436);
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
		public Bdd b;
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterMulterm1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitMulterm1(this);
		}
	}

	public final Multerm1Context multerm1() throws RecognitionException {
		Multerm1Context _localctx = new Multerm1Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_multerm1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); 
			((Multerm1Context)_localctx).f1 = multerm0();

			    ((Multerm1Context)_localctx).b =  ((Multerm1Context)_localctx).f1.b;
			  
			setState(443);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(439); 
				match(T__4);
				setState(440); 
				((Multerm1Context)_localctx).f2 = multerm0();

				    ((Multerm1Context)_localctx).b =  _localctx.b.imply(((Multerm1Context)_localctx).f2.b);
				  
				}
				break;
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
		public Bdd b;
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
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterMulterm0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitMulterm0(this);
		}
	}

	public final Multerm0Context multerm0() throws RecognitionException {
		Multerm0Context _localctx = new Multerm0Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_multerm0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445); 
			((Multerm0Context)_localctx).f1 = subterm();

			    ((Multerm0Context)_localctx).b =  ((Multerm0Context)_localctx).f1.b;
			  
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(447); 
				match(T__25);
				setState(448); 
				((Multerm0Context)_localctx).f2 = subterm();

				    ((Multerm0Context)_localctx).b =  _localctx.b.and(((Multerm0Context)_localctx).f2.b);
				  
				}
				}
				setState(455);
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

	public static class SubtermContext extends ParserRuleContext {
		public Bdd b;
		public Token n0;
		public Token n1;
		public FormuleContext f1;
		public FormuleContext f2;
		public FormuleContext f3;
		public FormuleContext f;
		public SubtermContext a;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public List<FormuleContext> formule() {
			return getRuleContexts(FormuleContext.class);
		}
		public FormuleContext formule(int i) {
			return getRuleContext(FormuleContext.class,i);
		}
		public SubtermContext subterm() {
			return getRuleContext(SubtermContext.class,0);
		}
		public SubtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterSubterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitSubterm(this);
		}
	}

	public final SubtermContext subterm() throws RecognitionException {
		SubtermContext _localctx = new SubtermContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subterm);
		int _la;
		try {
			setState(490);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(456); 
				((SubtermContext)_localctx).n0 = match(ID);

				    StringBuffer s = new StringBuffer((((SubtermContext)_localctx).n0!=null?((SubtermContext)_localctx).n0.getText():null));
				  
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(458); 
					match(T__14);
					setState(459); 
					((SubtermContext)_localctx).n1 = match(ID);

					    s.append("." + (((SubtermContext)_localctx).n1!=null?((SubtermContext)_localctx).n1.getText():null));
					  
					}
					}
					setState(465);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				    ((SubtermContext)_localctx).b =  Bdd.variable(s.toString());
				  
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(467); 
				match(T__33);

				    ((SubtermContext)_localctx).b =  Bdd.TRUE;
				  
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(469); 
				match(T__34);

				    ((SubtermContext)_localctx).b =  Bdd.FALSE;
				  
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 4);
				{
				setState(471); 
				match(T__35);
				setState(472); 
				match(T__27);
				setState(473); 
				((SubtermContext)_localctx).f1 = formule();
				setState(474); 
				match(T__19);
				setState(475); 
				((SubtermContext)_localctx).f2 = formule();
				setState(476); 
				match(T__19);
				setState(477); 
				((SubtermContext)_localctx).f3 = formule();
				setState(478); 
				match(T__28);

				    ((SubtermContext)_localctx).b =  Bdd.ite(((SubtermContext)_localctx).f1.b,((SubtermContext)_localctx).f2.b,((SubtermContext)_localctx).f3.b) ;
				  
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(481); 
				match(T__27);
				setState(482); 
				((SubtermContext)_localctx).f = formule();
				setState(483); 
				match(T__28);

				    ((SubtermContext)_localctx).b =  ((SubtermContext)_localctx).f.b;
				  
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(486); 
				match(T__36);
				setState(487); 
				((SubtermContext)_localctx).a = subterm();

				    ((SubtermContext)_localctx).b =  ((SubtermContext)_localctx).a.b.not();
				  
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

	public static class CtlformuleContext extends ParserRuleContext {
		public Bdd b;
		public Ctlmulterm2Context f1;
		public Ctlmulterm2Context f2;
		public List<Ctlmulterm2Context> ctlmulterm2() {
			return getRuleContexts(Ctlmulterm2Context.class);
		}
		public Ctlmulterm2Context ctlmulterm2(int i) {
			return getRuleContext(Ctlmulterm2Context.class,i);
		}
		public CtlformuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlformule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCtlformule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCtlformule(this);
		}
	}

	public final CtlformuleContext ctlformule() throws RecognitionException {
		CtlformuleContext _localctx = new CtlformuleContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ctlformule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492); 
			((CtlformuleContext)_localctx).f1 = ctlmulterm2();

			    ((CtlformuleContext)_localctx).b =  ((CtlformuleContext)_localctx).f1.b;
			  
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(494); 
				match(T__31);
				setState(495); 
				((CtlformuleContext)_localctx).f2 = ctlmulterm2();

				    ((CtlformuleContext)_localctx).b =  _localctx.b.or(((CtlformuleContext)_localctx).f2.b);
				  
				}
				}
				setState(502);
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

	public static class Ctlmulterm2Context extends ParserRuleContext {
		public Bdd b;
		public Ctlmulterm1Context f1;
		public Ctlmulterm1Context f2;
		public List<Ctlmulterm1Context> ctlmulterm1() {
			return getRuleContexts(Ctlmulterm1Context.class);
		}
		public Ctlmulterm1Context ctlmulterm1(int i) {
			return getRuleContext(Ctlmulterm1Context.class,i);
		}
		public Ctlmulterm2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlmulterm2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCtlmulterm2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCtlmulterm2(this);
		}
	}

	public final Ctlmulterm2Context ctlmulterm2() throws RecognitionException {
		Ctlmulterm2Context _localctx = new Ctlmulterm2Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_ctlmulterm2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503); 
			((Ctlmulterm2Context)_localctx).f1 = ctlmulterm1();

			    ((Ctlmulterm2Context)_localctx).b =  ((Ctlmulterm2Context)_localctx).f1.b;
			  
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(505); 
				match(T__32);
				setState(506); 
				((Ctlmulterm2Context)_localctx).f2 = ctlmulterm1();

				    ((Ctlmulterm2Context)_localctx).b =  _localctx.b.equiv(((Ctlmulterm2Context)_localctx).f2.b);
				  
				}
				}
				setState(513);
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

	public static class Ctlmulterm1Context extends ParserRuleContext {
		public Bdd b;
		public Ctlmulterm0Context f1;
		public Ctlmulterm0Context f2;
		public List<Ctlmulterm0Context> ctlmulterm0() {
			return getRuleContexts(Ctlmulterm0Context.class);
		}
		public Ctlmulterm0Context ctlmulterm0(int i) {
			return getRuleContext(Ctlmulterm0Context.class,i);
		}
		public Ctlmulterm1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlmulterm1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCtlmulterm1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCtlmulterm1(this);
		}
	}

	public final Ctlmulterm1Context ctlmulterm1() throws RecognitionException {
		Ctlmulterm1Context _localctx = new Ctlmulterm1Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_ctlmulterm1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514); 
			((Ctlmulterm1Context)_localctx).f1 = ctlmulterm0();

			    ((Ctlmulterm1Context)_localctx).b =  ((Ctlmulterm1Context)_localctx).f1.b;
			  
			setState(520);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(516); 
				match(T__4);
				setState(517); 
				((Ctlmulterm1Context)_localctx).f2 = ctlmulterm0();

				    ((Ctlmulterm1Context)_localctx).b =  _localctx.b.imply(((Ctlmulterm1Context)_localctx).f2.b);
				  
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

	public static class Ctlmulterm0Context extends ParserRuleContext {
		public Bdd b;
		public CtlsubtermContext f1;
		public CtlsubtermContext f2;
		public List<CtlsubtermContext> ctlsubterm() {
			return getRuleContexts(CtlsubtermContext.class);
		}
		public CtlsubtermContext ctlsubterm(int i) {
			return getRuleContext(CtlsubtermContext.class,i);
		}
		public Ctlmulterm0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlmulterm0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCtlmulterm0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCtlmulterm0(this);
		}
	}

	public final Ctlmulterm0Context ctlmulterm0() throws RecognitionException {
		Ctlmulterm0Context _localctx = new Ctlmulterm0Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_ctlmulterm0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522); 
			((Ctlmulterm0Context)_localctx).f1 = ctlsubterm();

			    ((Ctlmulterm0Context)_localctx).b =  ((Ctlmulterm0Context)_localctx).f1.b;
			  
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(524); 
				match(T__25);
				setState(525); 
				((Ctlmulterm0Context)_localctx).f2 = ctlsubterm();

				    ((Ctlmulterm0Context)_localctx).b =  _localctx.b.and(((Ctlmulterm0Context)_localctx).f2.b);
				  
				}
				}
				setState(532);
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

	public static class CtlsubtermContext extends ParserRuleContext {
		public Bdd b;
		public Token n0;
		public Token n1;
		public CtlformuleContext f1;
		public CtlformuleContext f2;
		public CtlformuleContext f3;
		public CtlformuleContext f;
		public CtlsubtermContext a;
		public CtlformuleContext g;
		public List<TerminalNode> ID() { return getTokens(SystemParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SystemParser.ID, i);
		}
		public List<CtlformuleContext> ctlformule() {
			return getRuleContexts(CtlformuleContext.class);
		}
		public CtlformuleContext ctlformule(int i) {
			return getRuleContext(CtlformuleContext.class,i);
		}
		public CtlsubtermContext ctlsubterm() {
			return getRuleContext(CtlsubtermContext.class,0);
		}
		public CtlsubtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctlsubterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).enterCtlsubterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SystemListener ) ((SystemListener)listener).exitCtlsubterm(this);
		}
	}

	public final CtlsubtermContext ctlsubterm() throws RecognitionException {
		CtlsubtermContext _localctx = new CtlsubtermContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ctlsubterm);
		int _la;
		try {
			setState(612);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(533); 
				((CtlsubtermContext)_localctx).n0 = match(ID);

				    StringBuffer s = new StringBuffer((((CtlsubtermContext)_localctx).n0!=null?((CtlsubtermContext)_localctx).n0.getText():null));
				  
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(535); 
					match(T__14);
					setState(536); 
					((CtlsubtermContext)_localctx).n1 = match(ID);

					    s.append("." + (((CtlsubtermContext)_localctx).n1!=null?((CtlsubtermContext)_localctx).n1.getText():null));
					  
					}
					}
					setState(542);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}

				    if (resS.isProp(s.toString()))
				        ((CtlsubtermContext)_localctx).b =  resS.prop(s.toString());
				    else {
				        System.err.println("La propriété " + s.toString() + " n'existe pas.");
				        ((CtlsubtermContext)_localctx).b =  Bdd.FALSE;
				    }
				  
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(544); 
				match(T__33);

				    ((CtlsubtermContext)_localctx).b =  Bdd.TRUE;
				  
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(546); 
				match(T__34);

				    ((CtlsubtermContext)_localctx).b =  Bdd.FALSE;
				  
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 4);
				{
				setState(548); 
				match(T__22);

				    ((CtlsubtermContext)_localctx).b =  resS.getInit();
				  
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 5);
				{
				setState(550); 
				match(T__37);
				setState(551); 
				((CtlsubtermContext)_localctx).f1 = ctlformule();
				setState(552); 
				match(T__19);
				setState(553); 
				((CtlsubtermContext)_localctx).f2 = ctlformule();
				setState(554); 
				match(T__19);
				setState(555); 
				((CtlsubtermContext)_localctx).f3 = ctlformule();
				setState(556); 
				match(T__28);

				    ((CtlsubtermContext)_localctx).b =  Bdd.ite(((CtlsubtermContext)_localctx).f1.b,((CtlsubtermContext)_localctx).f2.b,((CtlsubtermContext)_localctx).f3.b) ;
				  
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(559); 
				match(T__27);
				setState(560); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(561); 
				match(T__28);

				    ((CtlsubtermContext)_localctx).b =  ((CtlsubtermContext)_localctx).f.b;
				  
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 7);
				{
				setState(564); 
				match(T__36);
				setState(565); 
				((CtlsubtermContext)_localctx).a = ctlsubterm();

				    ((CtlsubtermContext)_localctx).b =  ((CtlsubtermContext)_localctx).a.b.not();
				  
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 8);
				{
				setState(568); 
				match(T__38);
				setState(569); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(570); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.EX(((CtlsubtermContext)_localctx).f.b);
				  
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 9);
				{
				setState(573); 
				match(T__39);
				setState(574); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(575); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.AX(((CtlsubtermContext)_localctx).f.b);
				  
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 10);
				{
				setState(578); 
				match(T__40);
				setState(579); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(580); 
				match(T__41);
				setState(581); 
				((CtlsubtermContext)_localctx).g = ctlformule();
				setState(582); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.EU(((CtlsubtermContext)_localctx).f.b,((CtlsubtermContext)_localctx).g.b);
				  
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 11);
				{
				setState(585); 
				match(T__42);
				setState(586); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(587); 
				match(T__41);
				setState(588); 
				((CtlsubtermContext)_localctx).g = ctlformule();
				setState(589); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.AU(((CtlsubtermContext)_localctx).f.b,((CtlsubtermContext)_localctx).g.b);
				  
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 12);
				{
				setState(592); 
				match(T__43);
				setState(593); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(594); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.EU(Bdd.TRUE,((CtlsubtermContext)_localctx).f.b);
				  
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 13);
				{
				setState(597); 
				match(T__44);
				setState(598); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(599); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.AU(Bdd.TRUE,((CtlsubtermContext)_localctx).f.b);
				  
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 14);
				{
				setState(602); 
				match(T__45);
				setState(603); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(604); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.AU(Bdd.TRUE,((CtlsubtermContext)_localctx).f.b.not()).not();
				  
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 15);
				{
				setState(607); 
				match(T__46);
				setState(608); 
				((CtlsubtermContext)_localctx).f = ctlformule();
				setState(609); 
				match(T__28);

				     ((CtlsubtermContext)_localctx).b =  resS.EU(Bdd.TRUE,((CtlsubtermContext)_localctx).f.b.not()).not();
				  
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u0269\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3V\n\3\3\3\3\3\3\3\5\3[\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3d\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3m\n\3\5\3o\n\3\5\3q\n\3\5\3s"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\177\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\5\4\u008f\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0097\n\4\3\4\3\4\7\4\u009b\n\4\f\4\16\4"+
		"\u009e\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00aa\n\5\f\5"+
		"\16\5\u00ad\13\5\3\5\7\5\u00b0\n\5\f\5\16\5\u00b3\13\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\5\6\u00c3\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00d2\n\b\f\b\16"+
		"\b\u00d5\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00e1\n\t\f"+
		"\t\16\t\u00e4\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u00f2\n\n\f\n\16\n\u00f5\13\n\3\n\5\n\u00f8\n\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0105\n\13\f\13\16\13\u0108\13\13"+
		"\3\13\3\13\3\13\3\13\7\13\u010e\n\13\f\13\16\13\u0111\13\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u011d\n\f\f\f\16\f\u0120\13\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u012a\n\f\f\f\16\f\u012d\13\f\5\f\u012f"+
		"\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u013a\n\r\f\r\16\r\u013d"+
		"\13\r\3\r\3\r\3\r\3\r\3\r\5\r\u0144\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u014d\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u015a\n\16\f\16\16\16\u015d\13\16\3\16\3\16\3\16\5\16\u0162"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u016a\n\17\f\17\16\17\u016d\13"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0184\n\22\f\22\16\22\u0187"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u0197\n\23\f\23\16\23\u019a\13\23\3\23\5\23\u019d\n\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u01a8\n\24\f\24\16\24\u01ab"+
		"\13\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01b3\n\25\f\25\16\25\u01b6"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01be\n\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\7\27\u01c6\n\27\f\27\16\27\u01c9\13\27\3\30\3\30\3\30\3"+
		"\30\3\30\7\30\u01d0\n\30\f\30\16\30\u01d3\13\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\5\30\u01ed\n\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\7\31\u01f5\n\31\f\31\16\31\u01f8\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\7\32\u0200\n\32\f\32\16\32\u0203\13\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u020b\n\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0213\n\34\f"+
		"\34\16\34\u0216\13\34\3\35\3\35\3\35\3\35\3\35\7\35\u021d\n\35\f\35\16"+
		"\35\u0220\13\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u0267\n\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668\2\2\u0291\2?\3\2\2\2\4~\3\2\2\2\6\u0080\3"+
		"\2\2\2\b\u00a1\3\2\2\2\n\u00c2\3\2\2\2\f\u00c4\3\2\2\2\16\u00ca\3\2\2"+
		"\2\20\u00d8\3\2\2\2\22\u00e7\3\2\2\2\24\u00fc\3\2\2\2\26\u0115\3\2\2\2"+
		"\30\u0143\3\2\2\2\32\u014c\3\2\2\2\34\u0163\3\2\2\2\36\u0170\3\2\2\2 "+
		"\u0176\3\2\2\2\"\u017c\3\2\2\2$\u018a\3\2\2\2&\u01a1\3\2\2\2(\u01ac\3"+
		"\2\2\2*\u01b7\3\2\2\2,\u01bf\3\2\2\2.\u01ec\3\2\2\2\60\u01ee\3\2\2\2\62"+
		"\u01f9\3\2\2\2\64\u0204\3\2\2\2\66\u020c\3\2\2\28\u0266\3\2\2\2:;\5\4"+
		"\3\2;<\7\3\2\2<>\3\2\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3"+
		"\2\2\2A?\3\2\2\2Br\7\63\2\2CD\7\4\2\2DE\b\3\1\2EF\7\63\2\2FG\7\5\2\2G"+
		"H\5\60\31\2HI\b\3\1\2Is\3\2\2\2Jp\7\6\2\2KU\7\63\2\2LM\7\7\2\2MN\b\3\1"+
		"\2NO\5\60\31\2OP\b\3\1\2PV\3\2\2\2QR\7\b\2\2RS\5&\24\2ST\b\3\1\2TV\3\2"+
		"\2\2UL\3\2\2\2UQ\3\2\2\2Vq\3\2\2\2WZ\b\3\1\2XY\7\t\2\2Y[\b\3\1\2ZX\3\2"+
		"\2\2Z[\3\2\2\2[c\3\2\2\2\\]\5\30\r\2]^\b\3\1\2^d\3\2\2\2_d\5\34\17\2`"+
		"a\7\n\2\2ab\7\63\2\2bd\b\3\1\2c\\\3\2\2\2c_\3\2\2\2c`\3\2\2\2de\3\2\2"+
		"\2eo\b\3\1\2fg\5\b\5\2gh\b\3\1\2hm\3\2\2\2ij\5\24\13\2jk\b\3\1\2km\3\2"+
		"\2\2lf\3\2\2\2li\3\2\2\2mo\3\2\2\2nW\3\2\2\2nl\3\2\2\2oq\3\2\2\2pK\3\2"+
		"\2\2pn\3\2\2\2qs\3\2\2\2rC\3\2\2\2rJ\3\2\2\2s\177\3\2\2\2t\177\7\13\2"+
		"\2uv\7\f\2\2vw\5\6\4\2wx\7\63\2\2xy\b\3\1\2y\177\3\2\2\2z{\7\r\2\2{|\5"+
		"\6\4\2|}\b\3\1\2}\177\3\2\2\2~B\3\2\2\2~t\3\2\2\2~u\3\2\2\2~z\3\2\2\2"+
		"\177\5\3\2\2\2\u0080\u008e\b\4\1\2\u0081\u0082\7\16\2\2\u0082\u008f\b"+
		"\4\1\2\u0083\u0084\7\17\2\2\u0084\u008f\b\4\1\2\u0085\u0086\7\20\2\2\u0086"+
		"\u008b\b\4\1\2\u0087\u0088\7\20\2\2\u0088\u008a\b\4\1\2\u0089\u0087\3"+
		"\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0081\3\2\2\2\u008e\u0083\3\2"+
		"\2\2\u008e\u0085\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\7\63\2\2\u0091\u009c\b\4\1\2\u0092\u0093\7\21\2\2\u0093\u0097\b"+
		"\4\1\2\u0094\u0095\7\16\2\2\u0095\u0097\b\4\1\2\u0096\u0092\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\63\2\2\u0099\u009b\b"+
		"\4\1\2\u009a\u0096\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\b\4"+
		"\1\2\u00a0\7\3\2\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3\5\n\6\2\u00a3\u00a4"+
		"\7\23\2\2\u00a4\u00a5\7\24\2\2\u00a5\u00a6\5\f\7\2\u00a6\u00a7\b\5\1\2"+
		"\u00a7\u00ab\5\16\b\2\u00a8\u00aa\5\20\t\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b1\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00b0\5\22\n\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3"+
		"\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\b\5\1\2\u00b6\t\3\2\2"+
		"\2\u00b7\u00c3\b\6\1\2\u00b8\u00b9\7\63\2\2\u00b9\u00bf\b\6\1\2\u00ba"+
		"\u00bb\7\26\2\2\u00bb\u00bc\7\63\2\2\u00bc\u00be\b\6\1\2\u00bd\u00ba\3"+
		"\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00b7\3\2\2\2\u00c2\u00b8\3\2"+
		"\2\2\u00c3\13\3\2\2\2\u00c4\u00c5\7\27\2\2\u00c5\u00c6\7\6\2\2\u00c6\u00c7"+
		"\7\62\2\2\u00c7\u00c8\7\30\2\2\u00c8\u00c9\b\7\1\2\u00c9\r\3\2\2\2\u00ca"+
		"\u00cb\7\31\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\7\62\2\2\u00cd\u00d3\b"+
		"\b\1\2\u00ce\u00cf\7\26\2\2\u00cf\u00d0\7\62\2\2\u00d0\u00d2\b\b\1\2\u00d1"+
		"\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\30\2\2\u00d7"+
		"\17\3\2\2\2\u00d8\u00d9\7\62\2\2\u00d9\u00da\b\t\1\2\u00da\u00db\7\6\2"+
		"\2\u00db\u00dc\7\63\2\2\u00dc\u00e2\b\t\1\2\u00dd\u00de\7\26\2\2\u00de"+
		"\u00df\7\63\2\2\u00df\u00e1\b\t\1\2\u00e0\u00dd\3\2\2\2\u00e1\u00e4\3"+
		"\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00e6\7\30\2\2\u00e6\21\3\2\2\2\u00e7\u00e8\7\62"+
		"\2\2\u00e8\u00e9\7\7\2\2\u00e9\u00ea\7\62\2\2\u00ea\u00f7\b\n\1\2\u00eb"+
		"\u00ec\7\22\2\2\u00ec\u00ed\7\63\2\2\u00ed\u00f3\b\n\1\2\u00ee\u00ef\7"+
		"\26\2\2\u00ef\u00f0\7\63\2\2\u00f0\u00f2\b\n\1\2\u00f1\u00ee\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2"+
		"\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\7\23\2\2\u00f7\u00eb\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\b\n\1\2\u00fa\u00fb\7\30"+
		"\2\2\u00fb\23\3\2\2\2\u00fc\u00fd\7\32\2\2\u00fd\u00fe\7\63\2\2\u00fe"+
		"\u00ff\7\63\2\2\u00ff\u0106\b\13\1\2\u0100\u0101\7\26\2\2\u0101\u0102"+
		"\7\63\2\2\u0102\u0103\7\63\2\2\u0103\u0105\b\13\1\2\u0104\u0100\3\2\2"+
		"\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\b\13\1\2\u010a\u010b\7\33\2\2"+
		"\u010b\u010f\7\24\2\2\u010c\u010e\5\26\f\2\u010d\u010c\3\2\2\2\u010e\u0111"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\7\25\2\2\u0113\u0114\b\13\1\2\u0114\25\3\2"+
		"\2\2\u0115\u0116\b\f\1\2\u0116\u0117\7\32\2\2\u0117\u0118\7\63\2\2\u0118"+
		"\u011e\b\f\1\2\u0119\u011a\7\26\2\2\u011a\u011b\7\63\2\2\u011b\u011d\b"+
		"\f\1\2\u011c\u0119\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\33"+
		"\2\2\u0122\u012e\b\f\1\2\u0123\u0124\7\7\2\2\u0124\u0125\7\63\2\2\u0125"+
		"\u012b\b\f\1\2\u0126\u0127\7\26\2\2\u0127\u0128\7\63\2\2\u0128\u012a\b"+
		"\f\1\2\u0129\u0126\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0123\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\7\30\2\2\u0131"+
		"\u0132\b\f\1\2\u0132\27\3\2\2\2\u0133\u0134\5\32\16\2\u0134\u013b\b\r"+
		"\1\2\u0135\u0136\7\34\2\2\u0136\u0137\5\32\16\2\u0137\u0138\b\r\1\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0135\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u0144\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u013f\7\35\2\2\u013f\u0140\7\63\2\2\u0140\u0141\5\30\r\2\u0141\u0142"+
		"\b\r\1\2\u0142\u0144\3\2\2\2\u0143\u0133\3\2\2\2\u0143\u013e\3\2\2\2\u0144"+
		"\31\3\2\2\2\u0145\u0146\7\63\2\2\u0146\u014d\b\16\1\2\u0147\u0148\7\36"+
		"\2\2\u0148\u0149\5\30\r\2\u0149\u014a\b\16\1\2\u014a\u014b\7\37\2\2\u014b"+
		"\u014d\3\2\2\2\u014c\u0145\3\2\2\2\u014c\u0147\3\2\2\2\u014d\u0161\3\2"+
		"\2\2\u014e\u014f\7\22\2\2\u014f\u0150\7\63\2\2\u0150\u0151\7\5\2\2\u0151"+
		"\u0152\5&\24\2\u0152\u015b\b\16\1\2\u0153\u0154\7\26\2\2\u0154\u0155\7"+
		"\63\2\2\u0155\u0156\7\5\2\2\u0156\u0157\5&\24\2\u0157\u0158\b\16\1\2\u0158"+
		"\u015a\3\2\2\2\u0159\u0153\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u015f\b\16\1\2\u015f\u0160\7\23\2\2\u0160\u0162\3\2\2\2\u0161\u014e\3"+
		"\2\2\2\u0161\u0162\3\2\2\2\u0162\33\3\2\2\2\u0163\u0164\7\24\2\2\u0164"+
		"\u0165\5\36\20\2\u0165\u0166\5 \21\2\u0166\u0167\b\17\1\2\u0167\u016b"+
		"\5\"\22\2\u0168\u016a\5$\23\2\u0169\u0168\3\2\2\2\u016a\u016d\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016e\u016f\7\25\2\2\u016f\35\3\2\2\2\u0170\u0171\7\27\2\2\u0171"+
		"\u0172\7\6\2\2\u0172\u0173\7\62\2\2\u0173\u0174\7\30\2\2\u0174\u0175\b"+
		"\20\1\2\u0175\37\3\2\2\2\u0176\u0177\7 \2\2\u0177\u0178\7\6\2\2\u0178"+
		"\u0179\7\62\2\2\u0179\u017a\7\30\2\2\u017a\u017b\b\21\1\2\u017b!\3\2\2"+
		"\2\u017c\u017d\7\31\2\2\u017d\u017e\7\6\2\2\u017e\u017f\7\62\2\2\u017f"+
		"\u0185\b\22\1\2\u0180\u0181\7\26\2\2\u0181\u0182\7\62\2\2\u0182\u0184"+
		"\b\22\1\2\u0183\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2"+
		"\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189"+
		"\7\30\2\2\u0189#\3\2\2\2\u018a\u018b\7\62\2\2\u018b\u018c\7!\2\2\u018c"+
		"\u018d\5&\24\2\u018d\u018e\7\7\2\2\u018e\u018f\7\62\2\2\u018f\u019c\b"+
		"\23\1\2\u0190\u0191\7\22\2\2\u0191\u0192\7\62\2\2\u0192\u0198\b\23\1\2"+
		"\u0193\u0194\7\26\2\2\u0194\u0195\7\62\2\2\u0195\u0197\b\23\1\2\u0196"+
		"\u0193\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2"+
		"\2\2\u0199\u019b\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019d\7\23\2\2\u019c"+
		"\u0190\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7\30"+
		"\2\2\u019f\u01a0\b\23\1\2\u01a0%\3\2\2\2\u01a1\u01a2\5(\25\2\u01a2\u01a9"+
		"\b\24\1\2\u01a3\u01a4\7\"\2\2\u01a4\u01a5\5(\25\2\u01a5\u01a6\b\24\1\2"+
		"\u01a6\u01a8\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\'\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01ad\5*\26\2\u01ad\u01b4\b\25\1\2\u01ae\u01af\7#\2\2\u01af\u01b0\5*"+
		"\26\2\u01b0\u01b1\b\25\1\2\u01b1\u01b3\3\2\2\2\u01b2\u01ae\3\2\2\2\u01b3"+
		"\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5)\3\2\2\2"+
		"\u01b6\u01b4\3\2\2\2\u01b7\u01b8\5,\27\2\u01b8\u01bd\b\26\1\2\u01b9\u01ba"+
		"\7\7\2\2\u01ba\u01bb\5,\27\2\u01bb\u01bc\b\26\1\2\u01bc\u01be\3\2\2\2"+
		"\u01bd\u01b9\3\2\2\2\u01bd\u01be\3\2\2\2\u01be+\3\2\2\2\u01bf\u01c0\5"+
		".\30\2\u01c0\u01c7\b\27\1\2\u01c1\u01c2\7\34\2\2\u01c2\u01c3\5.\30\2\u01c3"+
		"\u01c4\b\27\1\2\u01c4\u01c6\3\2\2\2\u01c5\u01c1\3\2\2\2\u01c6\u01c9\3"+
		"\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8-\3\2\2\2\u01c9\u01c7"+
		"\3\2\2\2\u01ca\u01cb\7\63\2\2\u01cb\u01d1\b\30\1\2\u01cc\u01cd\7\21\2"+
		"\2\u01cd\u01ce\7\63\2\2\u01ce\u01d0\b\30\1\2\u01cf\u01cc\3\2\2\2\u01d0"+
		"\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\3\2"+
		"\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01ed\b\30\1\2\u01d5\u01d6\7$\2\2\u01d6"+
		"\u01ed\b\30\1\2\u01d7\u01d8\7%\2\2\u01d8\u01ed\b\30\1\2\u01d9\u01da\7"+
		"&\2\2\u01da\u01db\7\36\2\2\u01db\u01dc\5&\24\2\u01dc\u01dd\7\26\2\2\u01dd"+
		"\u01de\5&\24\2\u01de\u01df\7\26\2\2\u01df\u01e0\5&\24\2\u01e0\u01e1\7"+
		"\37\2\2\u01e1\u01e2\b\30\1\2\u01e2\u01ed\3\2\2\2\u01e3\u01e4\7\36\2\2"+
		"\u01e4\u01e5\5&\24\2\u01e5\u01e6\7\37\2\2\u01e6\u01e7\b\30\1\2\u01e7\u01ed"+
		"\3\2\2\2\u01e8\u01e9\7\'\2\2\u01e9\u01ea\5.\30\2\u01ea\u01eb\b\30\1\2"+
		"\u01eb\u01ed\3\2\2\2\u01ec\u01ca\3\2\2\2\u01ec\u01d5\3\2\2\2\u01ec\u01d7"+
		"\3\2\2\2\u01ec\u01d9\3\2\2\2\u01ec\u01e3\3\2\2\2\u01ec\u01e8\3\2\2\2\u01ed"+
		"/\3\2\2\2\u01ee\u01ef\5\62\32\2\u01ef\u01f6\b\31\1\2\u01f0\u01f1\7\"\2"+
		"\2\u01f1\u01f2\5\62\32\2\u01f2\u01f3\b\31\1\2\u01f3\u01f5\3\2\2\2\u01f4"+
		"\u01f0\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2"+
		"\2\2\u01f7\61\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fa\5\64\33\2\u01fa"+
		"\u0201\b\32\1\2\u01fb\u01fc\7#\2\2\u01fc\u01fd\5\64\33\2\u01fd\u01fe\b"+
		"\32\1\2\u01fe\u0200\3\2\2\2\u01ff\u01fb\3\2\2\2\u0200\u0203\3\2\2\2\u0201"+
		"\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\63\3\2\2\2\u0203\u0201\3\2\2"+
		"\2\u0204\u0205\5\66\34\2\u0205\u020a\b\33\1\2\u0206\u0207\7\7\2\2\u0207"+
		"\u0208\5\66\34\2\u0208\u0209\b\33\1\2\u0209\u020b\3\2\2\2\u020a\u0206"+
		"\3\2\2\2\u020a\u020b\3\2\2\2\u020b\65\3\2\2\2\u020c\u020d\58\35\2\u020d"+
		"\u0214\b\34\1\2\u020e\u020f\7\34\2\2\u020f\u0210\58\35\2\u0210\u0211\b"+
		"\34\1\2\u0211\u0213\3\2\2\2\u0212\u020e\3\2\2\2\u0213\u0216\3\2\2\2\u0214"+
		"\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\67\3\2\2\2\u0216\u0214\3\2\2"+
		"\2\u0217\u0218\7\63\2\2\u0218\u021e\b\35\1\2\u0219\u021a\7\21\2\2\u021a"+
		"\u021b\7\63\2\2\u021b\u021d\b\35\1\2\u021c\u0219\3\2\2\2\u021d\u0220\3"+
		"\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220"+
		"\u021e\3\2\2\2\u0221\u0267\b\35\1\2\u0222\u0223\7$\2\2\u0223\u0267\b\35"+
		"\1\2\u0224\u0225\7%\2\2\u0225\u0267\b\35\1\2\u0226\u0227\7\31\2\2\u0227"+
		"\u0267\b\35\1\2\u0228\u0229\7(\2\2\u0229\u022a\5\60\31\2\u022a\u022b\7"+
		"\26\2\2\u022b\u022c\5\60\31\2\u022c\u022d\7\26\2\2\u022d\u022e\5\60\31"+
		"\2\u022e\u022f\7\37\2\2\u022f\u0230\b\35\1\2\u0230\u0267\3\2\2\2\u0231"+
		"\u0232\7\36\2\2\u0232\u0233\5\60\31\2\u0233\u0234\7\37\2\2\u0234\u0235"+
		"\b\35\1\2\u0235\u0267\3\2\2\2\u0236\u0237\7\'\2\2\u0237\u0238\58\35\2"+
		"\u0238\u0239\b\35\1\2\u0239\u0267\3\2\2\2\u023a\u023b\7)\2\2\u023b\u023c"+
		"\5\60\31\2\u023c\u023d\7\37\2\2\u023d\u023e\b\35\1\2\u023e\u0267\3\2\2"+
		"\2\u023f\u0240\7*\2\2\u0240\u0241\5\60\31\2\u0241\u0242\7\37\2\2\u0242"+
		"\u0243\b\35\1\2\u0243\u0267\3\2\2\2\u0244\u0245\7+\2\2\u0245\u0246\5\60"+
		"\31\2\u0246\u0247\7,\2\2\u0247\u0248\5\60\31\2\u0248\u0249\7\37\2\2\u0249"+
		"\u024a\b\35\1\2\u024a\u0267\3\2\2\2\u024b\u024c\7-\2\2\u024c\u024d\5\60"+
		"\31\2\u024d\u024e\7,\2\2\u024e\u024f\5\60\31\2\u024f\u0250\7\37\2\2\u0250"+
		"\u0251\b\35\1\2\u0251\u0267\3\2\2\2\u0252\u0253\7.\2\2\u0253\u0254\5\60"+
		"\31\2\u0254\u0255\7\37\2\2\u0255\u0256\b\35\1\2\u0256\u0267\3\2\2\2\u0257"+
		"\u0258\7/\2\2\u0258\u0259\5\60\31\2\u0259\u025a\7\37\2\2\u025a\u025b\b"+
		"\35\1\2\u025b\u0267\3\2\2\2\u025c\u025d\7\60\2\2\u025d\u025e\5\60\31\2"+
		"\u025e\u025f\7\37\2\2\u025f\u0260\b\35\1\2\u0260\u0267\3\2\2\2\u0261\u0262"+
		"\7\61\2\2\u0262\u0263\5\60\31\2\u0263\u0264\7\37\2\2\u0264\u0265\b\35"+
		"\1\2\u0265\u0267\3\2\2\2\u0266\u0217\3\2\2\2\u0266\u0222\3\2\2\2\u0266"+
		"\u0224\3\2\2\2\u0266\u0226\3\2\2\2\u0266\u0228\3\2\2\2\u0266\u0231\3\2"+
		"\2\2\u0266\u0236\3\2\2\2\u0266\u023a\3\2\2\2\u0266\u023f\3\2\2\2\u0266"+
		"\u0244\3\2\2\2\u0266\u024b\3\2\2\2\u0266\u0252\3\2\2\2\u0266\u0257\3\2"+
		"\2\2\u0266\u025c\3\2\2\2\u0266\u0261\3\2\2\2\u02679\3\2\2\2\61?UZclnp"+
		"r~\u008b\u008e\u0096\u009c\u00ab\u00b1\u00bf\u00c2\u00d3\u00e2\u00f3\u00f7"+
		"\u0106\u010f\u011e\u012b\u012e\u013b\u0143\u014c\u015b\u0161\u016b\u0185"+
		"\u0198\u019c\u01a9\u01b4\u01bd\u01c7\u01d1\u01ec\u01f6\u0201\u020a\u0214"+
		"\u021e\u0266";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}