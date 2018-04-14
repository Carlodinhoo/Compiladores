%{
  import java.lang.Math;
  import java.io.*;
%}

%token<ival> NODO ENTERO 
%token MAS MENOS MULT DIV 
%type<ival> Lista, E, N, M, T, F, D ,C
%type<sval> input

/*Gramatica recursiva 1 por la izquierda*/
%%
input : E {$$ = Integer.toString($1); System.out.println("[OK] "+ $$ );          }
;
/*
  E: 	T {$$ = $1; }
  	|E MAS T {$$ = $1 + $3; }
        |E MAS E2 T {$$ = $1 + $3 + ;}
  ;

  N:	E MAS {$$ = $1; }
  	|E MENOS {$$ = $1*-1; }
  	|N E MAS {$$ = $1 + $2; }
  	|N E MENOS {$$ = ($1 + $2)*-1; }
  ;

  T: F {$$ = $1; }
  	|M F {$$ = $1 * $2; }
        |D F {$$ = $1 / $2; } 
  ;

  M:	T MULT {$$ = $1; }
        | M T MULT {$$ = $1 * $2 ; }
  ;

  D:    T DIV {$$ = $1; }
  	|D T DIV {$$ = $1 / $2; }
  ;

  F: MENOS ENTERO {$$ = $2 * -1; }
  	| ENTERO {$$ = $1; }
  ;
*/




    
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
