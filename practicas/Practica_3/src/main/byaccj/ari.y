%{
  import java.lang.Math;
  import java.io.*;
%}

%token<sval> NODO ENTERO OPERADORES MENOS 
%type<sval> Lista, input, E, N, M, T, F 

/*Gramatica recursiva 1*/
%%
input : E {$$ = $1; System.out.println("[OK] "+ $$ );}
;

E : N T {$$ = $1 + $2;}
  | T {$$ = $1;}
;

N : E OPERADORES {$$ = $1 + $2;}
    | E OPERADORES N {$$ = $1 + $2 + $3;}
;

T : F {$$ = $1;}
    | M F {$$ = $1 + $2;}
;

M : T OPERADORES {$$ = $1 + $2;}
    | T OPERADORES M {$$ = $1 + $2 + $3;}
;

F : MENOS ENTERO {$$ = $1 + $2;}
;
%%

/*Gramatica recursiva 2*/
%%
input : E {$$ = $1; System.out.println("[OK] "+ $$ );}
;

E : T {$$ = $1;}
  | T N{$$ = $1 + $2;}
;

N : OPERADORES E {$$ = $1 + $2;}
    | OPERADORES E N {$$ = $1 + $2 + $3;}
;

T : F {$$ = $1;}
    | F M {$$ = $1 + $2;}
;

M : OPERADORES T {$$ = $1 + $2;}
    | OPERADORES T M {$$ = $1 + $2 + $3;}
;

F : MENOS ENTERO {$$ = $1 + $2;}
;
%%

/* Referencia a analizador léxico */
private Nodos lexer;

private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
}

/* Función para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR]  " + error);
    System.exit(1);
}

/* Constructor */
public Parser(Reader r) {
    lexer = new Nodos(r, this);
}

/* Creación del parser e inicialización del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();
}
