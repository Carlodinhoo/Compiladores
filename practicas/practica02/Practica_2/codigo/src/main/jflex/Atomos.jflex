package testmaven;
%%
%class AnalizadorPython
%public
%standalone
%unicode
PUNTO   = \.
ENTERO  = [1-9][0-9]* | 0+
COMENTARIO = #.*
FLOTANTE = [1-9][0-9]*\.[1-9][0-9]* | 0+\.[1-9][0-9]*
RESERVADA =and| as| assert| break |class| continue| def| del| elif| else| except| exec| finally| for |from |global |if |import |in |is |lambda| not| or| pass| print| raise| return| try |while |with |yield
IDENTIFICADORES = ([A-Z]| [a-z])([A-Z]| [a-z]|[0-9])*
%%
{ENTERO}      { System.out.print("ENTERO("+yytext() + ")"); }
{COMENTARIO}      { System.out.print("COMENTARIO("+yytext() + ")"); }
{FLOTANTE}      { System.out.print("FLOTANTE("+yytext() + ")"); }
{RESERVADA}      { System.out.print("RESERVADA("+yytext() + ")"); }
{IDENTIFICADORES}      { System.out.print("IDENTIFICADORES("+yytext() + ")"); }
.             { }