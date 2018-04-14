package asintactico;
%%
%{
    private Parser parser;

    public Nodos (java.io.Reader r, Parser p){
    	   this(r);
    	   parser = p;
    }

%}
%class Nodos
%standalone
%public
%unicode
ENTERO  = [1-9][0-9]* | 0+
MAS= \+
MULT= \*
DIV= \/
MENOS =\-
%%

a             { parser.yylval = new ParserVal(yytext()); return parser.NODO; }
{ENTERO}   {  parser.yylval = new ParserVal(Integer.parseInt(yytext()) );
          return parser.ENTERO ; 
       }
{MAS}             { parser.yylval = new ParserVal(yytext()); return parser.MAS; }
{MENOS}             { parser.yylval = new ParserVal(yytext()); return parser.MENOS; }
{MULT}             { parser.yylval = new ParserVal(yytext()); return parser.MULT; }
{DIV}             { parser.yylval = new ParserVal(yytext()); return parser.DIV; }

.             { }
