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
%state NORMAL CADENA  INDENT DEDENT
%line
%unicode
%{
  // Parser
  private Parser yyparser;

  /**
  * Nuevo constructor
  * @param FileReader r
  * @param Parser parser - parser
  */
  public Flexer(java.io.Reader r, Parser parser){
    this(r);
    this.yyparser = parser;
  }

  // Variables auxiliares para la indentación
  static Stack<Integer> pila = new Stack<Integer>();
  static Integer actual = 0;
  static String cadena = "";
  static int dedents = 0;
  static int indents = 0;

  /**
  * Función que maneja los niveles de indentación y regresa átomos INDENT y DEDENT
  * @param int espacios - nivel de indetación actual.
  * @return void
  */
  public void indentacion(int espacios){
    if(pila.empty()){ //ponerle un cero a la pila si esta vacia
      pila.push(new Integer(0));             
    }

    Integer tope = pila.peek();

    if(tope != espacios){
      //Se debe emitir un DEDENT por cada nivel mayor al actual
      if(tope > espacios){
        while(pila.peek() > espacios &&  pila.peek()!=0 ){
          pila.pop();             
          dedents += 1;                                 
        }

        if(pila.peek() == espacios){
          yybegin(DEDENT);	       
        }else{
          System.out.println("IndentationError: line "+(yyline+1));
          System.exit(1);		    
        }

        return;
      }

      //El nivel actual de indentación es mayor a los anteriores.
      pila.push(espacios);
      yybegin(NORMAL);
      indents = 1;
    }else yybegin(NORMAL);
  }

%}

PUNTO         = \.
DIGIT         = [0-9]
CERO          = 0+
ENTERO        = {CERO} | {DIGIT}+
REAL          = {ENTERO}? {PUNTO} {ENTERO}?
IDENTIFICADOR    = ([:letter:] | "_")([:letter:] | "_" | [0-9])*
BOOLEAN      = ("True" | "False")
REAL          = {ENTERO}? \. {ENTERO}?
COMENTARIO = "#".*{NEWLINE}
CHAR_LITERAL  = ([:letter:] | [:digit:] | "_" | "$" | " " | "#" | {OPERADOR} | {SEPARADOR})
OPERADOR      = ("+" | "-" | "*" | "**" | "/" | "//" | "%" | "<" | ">" | "<=" | "+=" | "-=" | ">=" | "==" | "!=" | "<>" | "=" )			
SEPARADOR     = ("(" | ")" | ":"  | ";" )
NEWLINE       = "\n"

%%

{COMENTARIO}        {}



<CADENA>{
  {CHAR_LITERAL}*\"			{ yybegin(NORMAL); return Parser.CADENA;}
  {NEWLINE}				{ System.out.println("Cadena mal construida, linea " + (yyline+1) ); System.exit(1);}

}



<YYINITIAL>{
  (" " | "\t" )+[^" ""\t""#""\n"]         { System.out.println("Error de indentación. Línea "+(yyline+1));
					    System.exit(1);}
  {NEWLINE}                                 {}
  [^" ""\t"]                              { yypushback(1); yybegin(NORMAL);}
}






<NORMAL>{
  \"                                 {yybegin(CADENA);}
  {REAL}                         {return Parser.REAL;}
  {ENTERO}                    {return Parser.ENTERO;}
 "+"                              {return Parser.MAS;}
 "-"                               {return Parser.MENOS;}
 "*"                               {return Parser.POR;}
 "/"                               {return Parser.DIV;}
 "%"                              {return Parser.MODULO;}
 "**"                             {return Parser.POTENCIA;} 
 ":"                               {return Parser.DOSPUNTOS;}
 "("                               {return Parser.PARENTESIS1;}
 ")"                               {return Parser.PARENTESIS2;}
 "or"                             {return Parser.OR;}
 "and"                          {return Parser.AND;}
 "not"                           {return Parser.NOT;}
 {BOOLEAN}                {return Parser.BOOLEAN;}
"<"                               {return Parser.MENOR;}
">"                                {return Parser.MAYOR;}
"="                                {return Parser.IGUAL;}  
 "=="                           {return Parser.IGUALIGUAL;}
 ">="                           {return Parser.MAYORIGUAL;}
 "<="                           {return Parser.MENORIGUAL;}
 "!="                             {return Parser.DISTINTO;}
 "print"                         {return Parser.PRINT;}
 "return"                       {return Parser.RETURN;}
 "if"                               {return Parser.IF;}
 "else"                           {return Parser.ELSE;}
 "while"                         {return Parser.WHILE;}
 {IDENTIFICADOR}        {return Parser.IDENTIFICADOR;}
  {NEWLINE}                   { yybegin(INDENT); actual=0; return Parser.NEWLINE;}
" " { }
}
<INDENT>{
  {NEWLINE}                         {actual = 0;}
  " "                               {actual++;}
  \t                                {actual += 4;}
  .                                 {yypushback(1);
                                     this.indentacion(actual);
                                     //yybegin(NORMAL);
                                     if(indents == 1){
                                      indents = 0;
                                      return Parser.INDENT;
                                     }
                                    }
}

<DEDENT>{
  .                                 {yypushback(1);
                                     if(dedents > 0){
                                      dedents--;
                                      return Parser.DEDENT;
                                     }
                                     yybegin(NORMAL);}
}


<<EOF>>                                   { this.indentacion(0);
                                                     if(dedents > 0){
			     dedents--;
			     return Parser.DEDENT;
			 }else{
                                                                    return 0;
                                                         }
                                                        }
.                           		 { return Parser.OTRO;}

