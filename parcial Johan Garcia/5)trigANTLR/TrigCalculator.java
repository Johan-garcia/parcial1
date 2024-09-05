package trig;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Math;

public class TrigCalculator {
    public static void main(String[] args) throws Exception {
        // Cargar el archivo de entrada
        InputStream is = new FileInputStream("expr.in");
        ANTLRInputStream input = new ANTLRInputStream(is);
        TrigGrammarLexer lexer = new TrigGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TrigGrammarParser parser = new TrigGrammarParser(tokens);
        
        // Analizar el archivo
        ParseTree tree = parser.prog();
        TrigGrammarBaseVisitor<Double> visitor = new TrigGrammarBaseVisitor<Double>() {
            @Override
            public Double visitSinExpr(TrigGrammarParser.SinExprContext ctx) {
                double value = visit(ctx.expr());
                return Math.sin(Math.toRadians(value));
            }
            
            @Override
            public Double visitCosExpr(TrigGrammarParser.CosExprContext ctx) {
                double value = visit(ctx.expr());
                return Math.cos(Math.toRadians(value));
            }
            
            @Override
            public Double visitTanExpr(TrigGrammarParser.TanExprContext ctx) {
                double value = visit(ctx.expr());
                return Math.tan(Math.toRadians(value));
            }
            
            @Override
            public Double visitNumber(TrigGrammarParser.NumberContext ctx) {
                return Double.parseDouble(ctx.getText());
            }
        };

        // Imprimir resultados
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree expr = tree.getChild(i);
            System.out.println(visitor.visit(expr));
        }
    }
}

