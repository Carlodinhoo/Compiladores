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
input: E {$$ = Integer.toString($1); System.out.println("[OK] "+ $$  );};

E : E MAS T   {$$ = $1 + $3; dump_stacks(stateptr);}
  | E MENOS T  {$$ = $1 - $3; dump_stacks(stateptr);}
  | T          {$$ = $1; dump_stacks(stateptr);}
;

T : T MULT F {$$ = $1 * $3; dump_stacks(stateptr);}
  | T DIV F  {if ($3 != 0 ){$$ = $1 / $3;} else {yyerror("Div 0"); dump_stacks(stateptr);}}
  | F        {$$ = $1; dump_stacks(stateptr);}
;

F : ENTERO         {$$ = $1;  dump_stacks(stateptr);}
   | MENOS ENTERO  {$$ = $2*-1; dump_stacks(stateptr);}

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
