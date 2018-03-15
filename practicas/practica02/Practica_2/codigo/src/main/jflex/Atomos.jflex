package testmaven;
import java.util.Stack;
import java.util.Arrays;
%%
%class AnalizadorPython
%public
%standalone
%unicode
%{


static Stack<Integer> pila = new Stack<Integer>();
static int espacios=0;
static int t;
static boolean p = true;

public static void recorre(int espa){
    if(pila.empty()){
        pila.push(espa);
        System.out.print("IDENTACION "+pila.peek());
    }else{
        if(espa > pila.peek()){
            int identacion = pila.push(espa);
            System.out.print("IDENTACION "+identacion);
        }else{
            if(espa <= pila.peek()){
                while(!pila.empty()){
                        pila.pop();
                    if(pila.empty()){
                        System.out.print("Error");
                    }
                }
            }
            System.out.print("DEIDENTACION "+espa); 
        }
        
    }
    espacios = 0;   
}


%}
%x otro
PUNTO   = \.
ENTERO  = [1-9][0-9]* | 0+
COMENTARIO = #.*
FLOTANTE = [1-9][0-9]*\.[1-9][0-9]* | 0+\.[1-9][0-9]*
OPERADORES= <|>|=|<=|>=|\+|\-|\*|\**|\/| \/\/|\=\=|\!|\%
RESERVADA =and| as| assert| break |class| continue| def| del| elif| else| except| exec| finally| for |from |global |if |import |in |is |lambda| not| or| pass| print| raise| return| try |while |with |yield
CADENA ="\"" [^\\"\""]* "\""
IDENTIFICADORES = ([A-Z]| [a-z])([A-Z]| [a-z]|[0-9])*
SALTO = \n  
SEPARADOR = \:
BOOLEANO = True | False
%%
{ENTERO}      { System.out.print("ENTERO("+yytext() + ")"); }
{COMENTARIO}      { System.out.print("COMENTARIO("+yytext() + ")"); }
{FLOTANTE}      { System.out.print("FLOTANTE("+yytext() + ")"); }
{RESERVADA}      { System.out.print("RESERVADA("+yytext() + ")"); }
{CADENA}    { System.out.print("CADENA("+yytext() + ")");}
{IDENTIFICADORES}      { System.out.print("IDENTIFICADORES("+yytext() + ")"); }
{OPERADORES}    { System.out.print("OPERADORES("+yytext() + ")");}
{SALTO}    { System.out.print("SALTO("+yytext() + ")");
                    yybegin(otro);}

{SEPARADOR} { System.out.print("SEPARADOR(" + yytext() + ")"); }
{BOOLEANO} { System.out.print("BOOLEANO(" + yytext() + ")"); }
<otro>{
" " {espacios++;}
"/t" {espacios+=4;}
. {yybegin(YYINITIAL);
  recorre(espacios);}
}
.             { }


