// Generated from TrigGrammar.g4 by ANTLR 4.13.2

package trig;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TrigGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TrigGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TrigGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TrigGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sinExpr}
	 * labeled alternative in {@link TrigGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinExpr(TrigGrammarParser.SinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cosExpr}
	 * labeled alternative in {@link TrigGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCosExpr(TrigGrammarParser.CosExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tanExpr}
	 * labeled alternative in {@link TrigGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTanExpr(TrigGrammarParser.TanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TrigGrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(TrigGrammarParser.NumberContext ctx);
}