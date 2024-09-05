grammar TrigGrammar;

@header {
package trig;
}

prog:   expr+ EOF;

expr:   'Sin' '(' expr ')'   # sinExpr
    |   'Cos' '(' expr ')'   # cosExpr
    |   'Tan' '(' expr ')'   # tanExpr
    |   NUMBER               # number
    ;

NUMBER: [0-9]+ ('.' [0-9]+)?;
WS: [ \t\r\n]+ -> skip;

