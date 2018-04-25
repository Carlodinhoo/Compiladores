%{
  import java.lang.Math;
  import java.io.*;
%}

%token IDENTIFICADOR ENTERO REAL BOOLEANO

/* Gramática con recursión izquierda */
%%
input : atom  { System.out.println("[OK] ");}
;

ffile_input: file_input  { System.out.println("[OK] ");}
;

file_input: SALTO 
          | file_input SALTO 
          | stmt 
          | test

;

stmt: simple_stmt 
    | compound_stmt;

simple_stmt: small_stmt SALTO;

small_stmt: expr_stmt 
    | print_stmt
;
expr_stmt: test IGUAL test
print_stmt: PRINT test
;

compound_stmt: if_stmt
             | while_stmt
;

if_stmt: IF test DOSPUNTOS suite [ELSE DOSPUNTOS suite];

while_stmt: WHILE test DOSPUNTOS suite
;

suite: simple_stmt 
        | SALTO INDENTA stmt aux0 DEINDENTA
;

/*Primer auxiliar  para + en suite*/
aux0: stmt
      | aux0 stmt
;

test: or_test
;

or_test: and_test
          | and_test aux1
;
aux1: OR and_test
      | aux1 OR and_test
;
and_test: not_test
          | not_test aux2
;
aux2: AND not_test
      | aux2 AND not_test
;
not_test: NOT not_test
          | comparison
;

comparison: expr
            | expr aux3
;

aux3: comp_op expr
      | comp_op expr aux3
;

comp_op: MENOR
        | MAYOR
        | IGUALIGUAL
        | MAYORIGUAL
        | MENORIGUAL
        | DISTINTO
;

expr: term
      | term aux4
;

aux4: MAS term
      | MENOS term
      | MAS term aux4
      | MENOS term aux4
;

term: factor 
        |factor aux5
;

aux9:  POR factor
     | DIVENTERA factor
     | MODULO factor
     | DIV factor
     | aux5 POR factor 
     | aux5 MODULO factor
     | aux5 DIV factor
;


factor: MAS factor
	| MENOS factor
	| power
;

power:  atom
      | atom POTENCIA factor
;


atom: IDENTIFICADOR
    | ENTERO
    | REAL
    | BOOLEAN
    | PARENTESIS1 test PARENTESIS2
;



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
