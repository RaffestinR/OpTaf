// Generated from C:/Users/User/OpTaf/src/outil\Syst.g4 by ANTLR 4.5

  package outil;
import outil.*;
import Systeme.*;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.io.File;
    import java.io.PrintStream;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystParser}.
 */
public interface SystListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystParser#commandes}.
	 * @param ctx the parse tree
	 */
	void enterCommandes(@NotNull SystParser.CommandesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#commandes}.
	 * @param ctx the parse tree
	 */
	void exitCommandes(@NotNull SystParser.CommandesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#commande}.
	 * @param ctx the parse tree
	 */
	void enterCommande(@NotNull SystParser.CommandeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#commande}.
	 * @param ctx the parse tree
	 */
	void exitCommande(@NotNull SystParser.CommandeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#fichier}.
	 * @param ctx the parse tree
	 */
	void enterFichier(@NotNull SystParser.FichierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#fichier}.
	 * @param ctx the parse tree
	 */
	void exitFichier(@NotNull SystParser.FichierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#systeme}.
	 * @param ctx the parse tree
	 */
	void enterSysteme(@NotNull SystParser.SystemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#systeme}.
	 * @param ctx the parse tree
	 */
	void exitSysteme(@NotNull SystParser.SystemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#propS}.
	 * @param ctx the parse tree
	 */
	void enterPropS(@NotNull SystParser.PropSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#propS}.
	 * @param ctx the parse tree
	 */
	void exitPropS(@NotNull SystParser.PropSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#etatS}.
	 * @param ctx the parse tree
	 */
	void enterEtatS(@NotNull SystParser.EtatSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#etatS}.
	 * @param ctx the parse tree
	 */
	void exitEtatS(@NotNull SystParser.EtatSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#initS}.
	 * @param ctx the parse tree
	 */
	void enterInitS(@NotNull SystParser.InitSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#initS}.
	 * @param ctx the parse tree
	 */
	void exitInitS(@NotNull SystParser.InitSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#etatPropS}.
	 * @param ctx the parse tree
	 */
	void enterEtatPropS(@NotNull SystParser.EtatPropSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#etatPropS}.
	 * @param ctx the parse tree
	 */
	void exitEtatPropS(@NotNull SystParser.EtatPropSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#transitionS}.
	 * @param ctx the parse tree
	 */
	void enterTransitionS(@NotNull SystParser.TransitionSContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#transitionS}.
	 * @param ctx the parse tree
	 */
	void exitTransitionS(@NotNull SystParser.TransitionSContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#synchro}.
	 * @param ctx the parse tree
	 */
	void enterSynchro(@NotNull SystParser.SynchroContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#synchro}.
	 * @param ctx the parse tree
	 */
	void exitSynchro(@NotNull SystParser.SynchroContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#vecteur}.
	 * @param ctx the parse tree
	 */
	void enterVecteur(@NotNull SystParser.VecteurContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#vecteur}.
	 * @param ctx the parse tree
	 */
	void exitVecteur(@NotNull SystParser.VecteurContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#mso}.
	 * @param ctx the parse tree
	 */
	void enterMso(@NotNull SystParser.MsoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#mso}.
	 * @param ctx the parse tree
	 */
	void exitMso(@NotNull SystParser.MsoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#msoSimple}.
	 * @param ctx the parse tree
	 */
	void enterMsoSimple(@NotNull SystParser.MsoSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#msoSimple}.
	 * @param ctx the parse tree
	 */
	void exitMsoSimple(@NotNull SystParser.MsoSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#automate}.
	 * @param ctx the parse tree
	 */
	void enterAutomate(@NotNull SystParser.AutomateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#automate}.
	 * @param ctx the parse tree
	 */
	void exitAutomate(@NotNull SystParser.AutomateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#etat}.
	 * @param ctx the parse tree
	 */
	void enterEtat(@NotNull SystParser.EtatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#etat}.
	 * @param ctx the parse tree
	 */
	void exitEtat(@NotNull SystParser.EtatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#acc}.
	 * @param ctx the parse tree
	 */
	void enterAcc(@NotNull SystParser.AccContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#acc}.
	 * @param ctx the parse tree
	 */
	void exitAcc(@NotNull SystParser.AccContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull SystParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull SystParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(@NotNull SystParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(@NotNull SystParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#formule}.
	 * @param ctx the parse tree
	 */
	void enterFormule(@NotNull SystParser.FormuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#formule}.
	 * @param ctx the parse tree
	 */
	void exitFormule(@NotNull SystParser.FormuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void enterMulterm2(@NotNull SystParser.Multerm2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void exitMulterm2(@NotNull SystParser.Multerm2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void enterMulterm1(@NotNull SystParser.Multerm1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void exitMulterm1(@NotNull SystParser.Multerm1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void enterMulterm0(@NotNull SystParser.Multerm0Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void exitMulterm0(@NotNull SystParser.Multerm0Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#subterm}.
	 * @param ctx the parse tree
	 */
	void enterSubterm(@NotNull SystParser.SubtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#subterm}.
	 * @param ctx the parse tree
	 */
	void exitSubterm(@NotNull SystParser.SubtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#ctlformule}.
	 * @param ctx the parse tree
	 */
	void enterCtlformule(@NotNull SystParser.CtlformuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#ctlformule}.
	 * @param ctx the parse tree
	 */
	void exitCtlformule(@NotNull SystParser.CtlformuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#ctlmulterm2}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm2(@NotNull SystParser.Ctlmulterm2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#ctlmulterm2}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm2(@NotNull SystParser.Ctlmulterm2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#ctlmulterm1}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm1(@NotNull SystParser.Ctlmulterm1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#ctlmulterm1}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm1(@NotNull SystParser.Ctlmulterm1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#ctlmulterm0}.
	 * @param ctx the parse tree
	 */
	void enterCtlmulterm0(@NotNull SystParser.Ctlmulterm0Context ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#ctlmulterm0}.
	 * @param ctx the parse tree
	 */
	void exitCtlmulterm0(@NotNull SystParser.Ctlmulterm0Context ctx);
	/**
	 * Enter a parse tree produced by {@link SystParser#ctlsubterm}.
	 * @param ctx the parse tree
	 */
	void enterCtlsubterm(@NotNull SystParser.CtlsubtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystParser#ctlsubterm}.
	 * @param ctx the parse tree
	 */
	void exitCtlsubterm(@NotNull SystParser.CtlsubtermContext ctx);
}