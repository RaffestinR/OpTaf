// Generated from C:/Users/User/OpTaf/src/outil\Syst.g4 by ANTLR 4.5

  package outil;
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
}