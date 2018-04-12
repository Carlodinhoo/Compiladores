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
OPERADORES= \+|\*|\/
MENOS = \-
%%

a             { parser.yylval = new ParserVal(yytext()); return parser.NODO; }
{ENTERO}             { parser.yylval = new ParserVal(yytext()); return parser.ENTERO; }
{OPERADORES}             { parser.yylval = new ParserVal(yytext()); return parser.OPERADORES; }
{MENOS}             { parser.yylval = new ParserVal(yytext()); return parser.MENOS; }
.             { }
