%{
  import java.lang.Math;
  import java.io.*;
%}

%token<ival> NODO ENTERO 
%token MAS MENOS MULT DIV 
%type<ival> Lista, E, N, M, T, F, D 
%type<sval> input

/*Gramatica recursiva 2 por la derecha*/
%%
input : E {$$ = Integer.toString($1); System.out.println("[OK] "+ $$ );          }
;

E : T {$$ = $1;}
  | T N{$$ = $1 + $2;}
  
;

N : MAS E {$$ = $2;}
    | MENOS E {$$ = $2*-1;}
    | MAS E N {$$ = $2 + $3;}
    | MENOS E N {$$ = ($2 + $3)*-1;}
;

T : F {$$ = $1;}
    | F M {$$ = $1 * $2;}
    | F D {$$ = $1 / $2;}
;

M : MULT T {$$ = $2;}
    | MULT T M {$$ = $2 * $3;}
    
;

D : DIV T {$$ = $2;}
    | DIV T D {$$ = $2 / $3;}
;

F : MENOS ENTERO  {$$ = $2 * -1; }
    |ENTERO {$$ = $1;}
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