/********************************************************************************
**  Analizador léxico para p, subconjunto de Python.	                       **
*********************************************************************************/
package asintactico;
import java.util.Stack;
import java.util.Arrays;
%%
%public
%class Flexer
%debug
%byaccj
%state NORMAL
%line
%unicode
%{
    private Parser yyparser;

    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   yyparser = parser;
    }

    /* Acumula todos los átomos de DEINDENTA que deben ser devueltos  */
    static String dedents = "";
    /* Estructura auxiliar para almacenar los bloques de indentación */
    static Stack<Integer> pila = new Stack<Integer>();
    /* Guarda el nivel actual de indentación */
    static Integer actual = 0;
    /** Función que maneja los niveles de indetación e imprime
    * átomos INDENTA y DEINDENTA.
    * @param int espacios - nivel de indetación actual.
    * @return boolean - true en caso que no haya errores léxicos,
    * 	      	      	 false en otro caso.
    */
    public static boolean indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));
        }

        Integer tope = pila.peek();

        if(tope != espacios){
	    //Se debe emitir un DEDENT por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    dedents += "DEINDENTA("+pila.pop()+")\n";
                }
                if(pila.peek() == espacios){
                    System.out.print(dedents);
                    dedents = "";
                    return true;
                }
                return false;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
            System.out.println("INDENTA("+actual+")");
            return true;
        }
	//El nivel actual es igual al anterior.
        return true;
    }
%}

PUNTO         =	\.
DIGIT         = [0-9]
CERO          = 0+
ENTERO        = {CERO} | {DIGIT}+
REAL          = {ENTERO}? {PUNTO} {ENTERO}?
IDENTIFIER    = ([:letter:] | "_")([:letter:] | "_" | [0-9])*
BOOLEAN      = ("True" | "False")
REAL          = {ENTERO}? \. {ENTERO}?
%%


<NORMAL>{
  \"                                {yybegin(CADENA);}
  {REAL}                            {return Parser.REAL;}
  {ENTERO}                          {return Parser.ENTERO;}

  "+"                               {return Parser.MAS;}
  "-"                               {return Parser.MENOS;}
  "*"                               {return Parser.POR;}
  "/"                               {return Parser.DIV;}
  "%"                               {return Parser.MODULO;}
  "**"                              {return Parser.POTENCIA;}
    
  ":"                               {return Parser.DOSPUNTOS;}
  "("                               {return Parser.PARENTESIS1;}
  ")"                               {return Parser.PARENTESIS2;}


  "or"                              {return Parser.OR;}
  "and"                             {return Parser.AND;}
  "not"                             {return Parser.NOT;}
  {BOOLEAN}                         {return Parser.BOOLEAN;}
  "=="                              {return Parser.IGUALIGUAL;}
  ">="                              {return Parser.MAYORIGUAL;}
  "<="                              {return Parser.MENORIGUAL;}
  "!="                              {return Parser.DISTINTO;}

  "print"                           {return Parser.PRINT;}
  "return"                           {return Parser.RETURN;}
  "if"                              {return Parser.IF;}
  "else"                            {return Parser.ELSE;}
  "while"                           {return Parser.WHILE;}

  {IDENTIFIER}                      {return Parser.IDENTIFIER;}
}


[^]                               {}

