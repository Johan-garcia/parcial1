%{
#include <stdio.h>
int error = 0;
%}

%%
[a-zA-Z][a-zA-Z0-9]*  { printf("Identificador\n"); }
lambda               { printf("Lambda\n"); }
=                   { printf("Asignacion\n"); }
:                   { printf("Dos puntos\n"); }
[0-9]+               { printf("Numero\n"); }
[ \t\n]              ;
.                   { printf("Error lexico\n"); error = 1; }
%%

int yywrap() {
    return 1;
}

int main(int argc, char *argv[]) {
    ++argv, --argc;  /* skip program name */
    if (argc != 1) {
        fprintf(stderr, "Uso: %s archivo.txt\n", argv[0]);
        return 1;
    }
    yyin = fopen(argv[0], "r");
    yylex();
    fclose(yyin);
    if (error == 0) {
        printf("ACEPTA\n");
    } else {
        printf("NO ACEPTA\n");
    }
    return 0;
}
