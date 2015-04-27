// Generated from C:/Users/User/Desktop/OpTaf/outil\System.g4 by ANTLR 4.5

  package outil;
  import bdd.*;
  import mso.*;
  import systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;
  

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystemParser}.
 */
public interface SystemListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystemParser#commandes}.
	 * @param ctx the parse tree
	 */
	void enterCommandes(@NotNull SystemParser.CommandesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#commandes}.
	 * @param ctx the parse tree
	 */
	void exitCommandes(@NotNull SystemParser.CommandesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#commande}.
	 * @param ctx the parse tree
	 */
	void enterCommande(@NotNull SystemParser.CommandeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#commande}.
	 * @param ctx the parse tree
	 */
	void exitCommande(@NotNull SystemParser.CommandeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#fichier}.
	 * @param ctx the parse tree
	 */
	void enterFichier(@NotNull SystemParser.FichierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#fichier}.
	 * @param ctx the parse tree
	 */
	void exitFichier(@NotNull SystemParser.FichierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#systeme}.
	 * @param ctx the parse tree
	 */
	void enterSysteme(@NotNull SystemParser.SystemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#systeme}.
	 * @param ctx the parse tree
	 */
	void exitSysteme(@NotNull SystemParser.SystemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#propS}.
	 * @param ctx the parse tree
	 */
	void enterPropS(@NotNull SystemParser.PropSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#propS}.
	 * @param ctx the parse tree
	 */
	void exitPropS(@NotNull SystemParser.PropSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#etatS}.
	 * @param ctx the parse tree
	 */
	void enterEtatS(@NotNull SystemParser.EtatSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#etatS}.
	 * @param ctx the parse tree
	 */
	void exitEtatS(@NotNull SystemParser.EtatSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#initS}.
	 * @param ctx the parse tree
	 */
	void enterInitS(@NotNull SystemParser.InitSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#initS}.
	 * @param ctx the parse tree
	 */
	void exitInitS(@NotNull SystemParser.InitSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#etatPropS}.
	 * @param ctx the parse tree
	 */
	void enterEtatPropS(@NotNull SystemParser.EtatPropSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#etatPropS}.
	 * @param ctx the parse tree
	 */
	void exitEtatPropS(@NotNull SystemParser.EtatPropSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#transitionS}.
	 * @param ctx the parse tree
	 */
	void enterTransitionS(@NotNull SystemParser.TransitionSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#transitionS}.
	 * @param ctx the parse tree
	 */
	void exitTransitionS(@NotNull SystemParser.TransitionSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#synchro}.
	 * @param ctx the parse tree
	 */
	void enterSynchro(@NotNull SystemParser.SynchroContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#synchro}.
	 * @param ctx the parse tree
	 */
	void exitSynchro(@NotNull SystemParser.SynchroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#vecteur}.
	 * @param ctx the parse tree
	 */
	void enterVecteur(@NotNull SystemParser.VecteurContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#vecteur}.
	 * @param ctx the parse tree
	 */
	void exitVecteur(@NotNull SystemParser.VecteurContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#mso}.
	 * @param ctx the parse tree
	 */
	void enterMso(@NotNull SystemParser.MsoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#mso}.
	 * @param ctx the parse tree
	 */
	void exitMso(@NotNull SystemParser.MsoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#msoSimple}.
	 * @param ctx the parse tree
	 */
	void enterMsoSimple(@NotNull SystemParser.MsoSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#msoSimple}.
	 * @param ctx the parse tree
	 */
	void exitMsoSimple(@NotNull SystemParser.MsoSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#automate}.
	 * @param ctx the parse tree
	 */
	void enterAutomate(@NotNull SystemParser.AutomateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#automate}.
	 * @param ctx the parse tree
	 */
	void exitAutomate(@NotNull SystemParser.AutomateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#etat}.
	 * @param ctx the parse tree
	 */
	void enterEtat(@NotNull SystemParser.EtatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#etat}.
	 * @param ctx the parse tree
	 */
	void exitEtat(@NotNull SystemParser.EtatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#acc}.
	 * @param ctx the parse tree
	 */
	void enterAcc(@NotNull SystemParser.AccContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#acc}.
	 * @param ctx the parse tree
	 */
	void exitAcc(@NotNull SystemParser.AccContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull SystemParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull SystemParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(@NotNull SystemParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(@NotNull SystemParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#formule}.
	 * @param ctx the parse tree
	 */
	void enterFormule(@NotNull SystemParser.FormuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#formule}.
	 * @param ctx the parse tree
	 */
	void exitFormule(@NotNull SystemParser.FormuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void enterMulterm2(@NotNull SystemParser.Multerm2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void exitMulterm2(@NotNull SystemParser.Multerm2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void enterMulterm1(@NotNull SystemParser.Multerm1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void exitMulterm1(@NotNull SystemParser.Multerm1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void enterMulterm0(@NotNull SystemParser.Multerm0Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void exitMulterm0(@NotNull SystemParser.Multerm0Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#subterm}.
	 * @param ctx the parse tree
	 */
	void enterSubterm(@NotNull SystemParser.SubtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#subterm}.
	 * @param ctx the parse tree
	 */
	void exitSubterm(@NotNull SystemParser.SubtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#ctlformule}.
	 * @param ctx the parse tree
	 */
	void enterCtlformule(@NotNull SystemParser.CtlformuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#ctlformule}.
	 * @param ctx the parse tree
	 */
	void exitCtlformule(@NotNull SystemParser.CtlformuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#ctlmulterm2}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm2(@NotNull SystemParser.Ctlmulterm2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#ctlmulterm2}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm2(@NotNull SystemParser.Ctlmulterm2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#ctlmulterm1}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm1(@NotNull SystemParser.Ctlmulterm1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#ctlmulterm1}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm1(@NotNull SystemParser.Ctlmulterm1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#ctlmulterm0}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm0(@NotNull SystemParser.Ctlmulterm0Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#ctlmulterm0}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm0(@NotNull SystemParser.Ctlmulterm0Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystemParser#ctlsubterm}.
	 * @param ctx the parse tree
	 */
	void enterCtlsubterm(@NotNull SystemParser.CtlsubtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemParser#ctlsubterm}.
	 * @param ctx the parse tree
	 */
	void exitCtlsubterm(@NotNull SystemParser.CtlsubtermContext ctx);
}