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

E : T {$$ = $1; dump_stacks(stateptr);}
  | T N{$$ = $1 + $2;dump_stacks(stateptr);}
  
;

N : MAS E {$$ = $2;dump_stacks(stateptr);}
    | MENOS E {$$ = $2*-1;dump_stacks(stateptr);}
    | MAS E N {$$ = $2 + $3;dump_stacks(stateptr);}
    | MENOS E N {$$ = ($2 + $3)*-1;dump_stacks(stateptr);}
;

T : F {$$ = $1;dump_stacks(stateptr);}
    | F M {$$ = $1 * $2;dump_stacks(stateptr);}
    | F D {$$ = $1 / $2;dump_stacks(stateptr);}
;

M : MULT T {$$ = $2;dump_stacks(stateptr);}
    | MULT T M {$$ = $2 * $3;dump_stacks(stateptr);}
    
;

D : DIV T {$$ = $2;dump_stacks(stateptr);}
    | DIV T D {if ($3 != 0 ){$$ = $2 / $3;} else {yyerror("Div 0");}dump_stacks(stateptr);}
              
;

F : MENOS ENTERO  {$$ = $2 * -1; dump_stacks(stateptr);}
    |ENTERO {$$ = $1;dump_stacks(stateptr);}
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
