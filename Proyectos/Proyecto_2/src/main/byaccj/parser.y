%{
  import java.lang.Math;
  import java.io.*;
%}

%token IDENTIFICADOR ENTERO REAL BOOLEANO

/* Gramática con recursión izquierda */
%%
input : atom  { System.out.println("[OK] ");}
;

atom: IDENTIFICADOR
    | ENTERO
    | REAL
    | BOOLEANO
;

stmt: simple_stmt 
    | compound_stmt;

simple_stmt: small_stmt SALTO;

small_stmt: expr_stmt 
    | print_stmt;
expr_stmt: test IGUAL test
print_stmt: 'print' test

compound_stmt: if_stmt
             | while_stmt
%%
/* Referencia a analizador léxico */
private Flexer lexer;

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
    lexer = new Flexer(r, this);
}

/* Creación del parser e inicialización del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader("src/main/resources/test.txt"));
    parser.yydebug = true;
    parser.yyparse();
}
