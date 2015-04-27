// Generated from /home/couvreur/enseignement/M1-Verification/VeriTaf/LTL/LTL.g4 by ANTLR 4.4.1-dev

  package LTL;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LTLParser}.
 */
public interface LTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LTLParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void enterMulterm0(@NotNull LTLParser.Multerm0Context ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#multerm0}.
	 * @param ctx the parse tree
	 */
	void exitMulterm0(@NotNull LTLParser.Multerm0Context ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull LTLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull LTLParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void enterMulterm1(@NotNull LTLParser.Multerm1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#multerm1}.
	 * @param ctx the parse tree
	 */
	void exitMulterm1(@NotNull LTLParser.Multerm1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void enterMulterm2(@NotNull LTLParser.Multerm2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#multerm2}.
	 * @param ctx the parse tree
	 */
	void exitMulterm2(@NotNull LTLParser.Multerm2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#formule}.
	 * @param ctx the parse tree
	 */
	void enterFormule(@NotNull LTLParser.FormuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#formule}.
	 * @param ctx the parse tree
	 */
	void exitFormule(@NotNull LTLParser.FormuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull LTLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull LTLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#subterm}.
	 * @param ctx the parse tree
	 */
	void enterSubterm(@NotNull LTLParser.SubtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#subterm}.
	 * @param ctx the parse tree
	 */
	void exitSubterm(@NotNull LTLParser.SubtermContext ctx);
}