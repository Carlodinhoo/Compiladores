//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package asintactico;



//#line 2 "/Users/hectorsama/Documents/Repositorios/Compiladores/Proyectos/Proyecto_2/src/main/byaccj/parser.y"
  import java.lang.Math;
  import java.io.*;
//#line 20 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short IDENTIFICADOR=257;
public final static short ENTERO=258;
public final static short REAL=259;
public final static short CADENA=260;
public final static short ENDMARKER=261;
public final static short DEDENT=262;
public final static short INDENT=263;
public final static short OR=264;
public final static short AND=265;
public final static short NOT=266;
public final static short NEWLINE=267;
public final static short IGUAL=268;
public final static short PRINT=269;
public final static short IF=270;
public final static short DOSPUNTOS=271;
public final static short ELSE=272;
public final static short WHILE=273;
public final static short MENOR=274;
public final static short MAYOR=275;
public final static short IGUALIGUAL=276;
public final static short DISTINTO=277;
public final static short MAS=278;
public final static short MENOS=279;
public final static short POR=280;
public final static short MODULO=281;
public final static short DIV=282;
public final static short POTENCIA=283;
public final static short PARENTESIS1=284;
public final static short PARENTESIS2=285;
public final static short RETURN=286;
public final static short MAYORIGUAL=287;
public final static short MENORIGUAL=288;
public final static short BOOLEAN=289;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    0,    0,    0,    0,    1,    1,    3,
    5,    5,    6,    7,    4,    4,    8,    9,   10,   10,
   11,   11,    2,   12,   12,   14,   14,   13,   13,   16,
   16,   15,   15,   17,   17,   19,   19,   20,   20,   20,
   20,   20,   20,   18,   18,   22,   22,   22,   22,   21,
   21,   24,   24,   24,   24,   24,   24,   23,   23,   23,
   25,   25,   26,   26,   26,   26,   26,
};
final static short yylen[] = {                            2,
    2,    2,    1,    1,    2,    1,    1,    1,    1,    2,
    1,    1,    3,    2,    1,    1,    7,    4,    1,    5,
    1,    2,    1,    1,    2,    2,    3,    1,    2,    2,
    3,    2,    1,    1,    2,    2,    3,    1,    1,    1,
    1,    1,    1,    1,    2,    2,    2,    3,    3,    1,
    2,    2,    2,    2,    3,    3,    3,    2,    2,    1,
    1,    3,    1,    1,    1,    1,    3,
};
final static short yydefred[] = {                         0,
   63,   64,   65,    3,    0,    0,    0,    0,    0,    0,
    0,    0,   66,    0,    0,    0,    8,    9,    0,   11,
   12,   15,   16,   23,    0,    0,   33,    0,    0,    0,
   60,    0,   32,    0,   14,    0,    0,   58,   59,    0,
    5,    0,    0,   10,    0,    0,    0,    0,   38,   39,
   40,   43,   41,   42,   35,    0,    0,    0,   45,    0,
    0,    0,    0,    0,    0,    0,   67,   13,   26,    0,
   30,    0,    0,    0,    0,   52,   53,   54,    0,    0,
    0,   62,    0,    0,   19,    0,   18,   27,   31,   37,
   48,   49,   55,   56,   57,    0,    0,    0,    0,   21,
    0,   17,   20,   22,
};
final static short yydgoto[] = {                         14,
   15,   84,   17,   18,   19,   20,   21,   22,   23,   86,
  101,   24,   25,   46,   26,   48,   27,   28,   55,   56,
   29,   59,   30,   63,   31,   32,
};
final static short yysindex[] = {                      -189,
    0,    0,    0,    0,  -99, -189,  -99,  -99,  -99,  -96,
  -96,  -99,    0, -251, -189, -246,    0,    0, -240,    0,
    0,    0,    0,    0, -228, -227,    0, -256, -249, -247,
    0, -242,    0, -251,    0, -221, -214,    0,    0, -226,
    0, -251,  -99,    0,  -99, -204,  -99, -203,    0,    0,
    0,    0,    0,    0,    0,  -96,  -96,  -96,    0,  -96,
  -96,  -96, -233,  -96, -113, -113,    0,    0,    0,  -99,
    0,  -99, -256, -249, -249,    0,    0,    0,  -96,  -96,
  -96,    0, -202, -246,    0, -209,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -141, -206, -141, -113,    0,
 -165,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,   66,    0,    0,    0,    0,
    0,    0,    0,    0,   71,    3,    0,    0,    0,    0,
    0,    0,    0,    0,   39,  133,    0,  121,   76,   26,
    0,    1,    0,   79,    0,    0,    0,    0,    0,    0,
    0,   82,    0,    0,    0,   64,    0,  141,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   51,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  131,   91,  106,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         9,
  -73,    2,  -59,    0,    0,    0,    0,    0,    0,  -53,
    0,    0,  -33,    0,   -5,    0,    0,   27,   12,    0,
  -14,  -22,   -6,    0,    0,    0,
};
final static int YYTABLESIZE=426;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         33,
   61,   16,    7,   38,   39,   85,   85,   16,   35,   36,
   37,   69,   87,   40,   34,   41,   16,   49,   50,   51,
   52,   43,   98,   42,  100,   50,   44,  104,   57,   58,
   53,   54,   60,   61,   62,   45,   88,   47,   24,   85,
   64,   71,   74,   75,   68,  102,   79,   80,   81,   65,
   51,   91,   92,   76,   77,   78,   66,   82,   67,   70,
   96,   72,   97,   25,   99,    4,   89,    1,    2,    3,
    6,    4,   93,   94,   95,   44,    5,    6,    1,    7,
    8,    2,   73,    9,   90,    0,    0,    0,   10,   11,
   46,    1,    2,    3,   12,    0,  103,    0,    0,   13,
    5,    0,    0,    7,    8,   47,    0,    9,    0,    0,
    0,    0,   10,   11,    0,    1,    2,    3,   12,    0,
   34,    0,    0,   13,    5,    0,    0,    7,    8,    0,
   36,    9,   28,    0,    0,    0,   10,   11,    0,    0,
   29,    0,   12,    1,    2,    3,    0,   13,    0,    0,
    0,    0,    5,   83,    0,    7,    0,    1,    2,    3,
    1,    2,    3,    0,   10,   11,    5,    0,    0,    0,
   12,    0,    0,    0,    0,   13,    0,    0,   10,   11,
    0,   10,   11,    0,   12,    0,    0,   12,    0,   13,
    0,    0,   13,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   61,   61,    0,   61,   61,    7,
    0,   61,    0,    0,   61,   61,   61,   61,   61,   61,
   61,   61,   61,    0,    0,   61,    0,   61,   61,   50,
   50,    0,   50,   50,    0,    0,   50,    0,    0,   50,
   50,   50,   50,   50,   50,   24,   24,    0,    0,   24,
   50,    0,   50,   50,   51,   51,    0,   51,   51,    0,
    0,   51,    0,   24,   51,   51,   51,   51,   51,   51,
   25,   25,    0,    0,   25,   51,    0,   51,   51,   44,
   44,    0,   44,   44,    0,    0,   44,    0,   25,   44,
   44,   44,   44,    0,   46,   46,    0,   46,   46,    0,
   44,   46,   44,   44,   46,   46,   46,   46,    0,   47,
   47,    0,   47,   47,    0,   46,   47,   46,   46,   47,
   47,   47,   47,    0,   34,   34,    0,   34,   34,    0,
   47,   34,   47,   47,   36,   36,   28,   36,   36,   28,
   28,   36,    0,   28,   29,   34,    0,   29,   29,    0,
    0,   29,    0,    0,    0,   36,    0,   28,    0,    0,
    0,    0,    0,    0,    0,   29,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          5,
    0,    0,    0,   10,   11,   65,   66,    6,    7,    8,
    9,   45,   66,   12,    6,  267,   15,  274,  275,  276,
  277,  268,   96,   15,   98,    0,  267,  101,  278,  279,
  287,  288,  280,  281,  282,  264,   70,  265,    0,   99,
  283,   47,   57,   58,   43,   99,  280,  281,  282,  271,
    0,   74,   75,   60,   61,   62,  271,   64,  285,  264,
  263,  265,  272,    0,  271,    0,   72,  257,  258,  259,
    0,  261,   79,   80,   81,    0,  266,  267,    0,  269,
  270,    0,   56,  273,   73,   -1,   -1,   -1,  278,  279,
    0,  257,  258,  259,  284,   -1,  262,   -1,   -1,  289,
  266,   -1,   -1,  269,  270,    0,   -1,  273,   -1,   -1,
   -1,   -1,  278,  279,   -1,  257,  258,  259,  284,   -1,
    0,   -1,   -1,  289,  266,   -1,   -1,  269,  270,   -1,
    0,  273,    0,   -1,   -1,   -1,  278,  279,   -1,   -1,
    0,   -1,  284,  257,  258,  259,   -1,  289,   -1,   -1,
   -1,   -1,  266,  267,   -1,  269,   -1,  257,  258,  259,
  257,  258,  259,   -1,  278,  279,  266,   -1,   -1,   -1,
  284,   -1,   -1,   -1,   -1,  289,   -1,   -1,  278,  279,
   -1,  278,  279,   -1,  284,   -1,   -1,  284,   -1,  289,
   -1,   -1,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  264,  265,   -1,  267,  268,  267,
   -1,  271,   -1,   -1,  274,  275,  276,  277,  278,  279,
  280,  281,  282,   -1,   -1,  285,   -1,  287,  288,  264,
  265,   -1,  267,  268,   -1,   -1,  271,   -1,   -1,  274,
  275,  276,  277,  278,  279,  267,  268,   -1,   -1,  271,
  285,   -1,  287,  288,  264,  265,   -1,  267,  268,   -1,
   -1,  271,   -1,  285,  274,  275,  276,  277,  278,  279,
  267,  268,   -1,   -1,  271,  285,   -1,  287,  288,  264,
  265,   -1,  267,  268,   -1,   -1,  271,   -1,  285,  274,
  275,  276,  277,   -1,  264,  265,   -1,  267,  268,   -1,
  285,  271,  287,  288,  274,  275,  276,  277,   -1,  264,
  265,   -1,  267,  268,   -1,  285,  271,  287,  288,  274,
  275,  276,  277,   -1,  264,  265,   -1,  267,  268,   -1,
  285,  271,  287,  288,  264,  265,  264,  267,  268,  267,
  268,  271,   -1,  271,  264,  285,   -1,  267,  268,   -1,
   -1,  271,   -1,   -1,   -1,  285,   -1,  285,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  285,
};
}
final static short YYFINAL=14;
final static short YYMAXTOKEN=289;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"IDENTIFICADOR","ENTERO","REAL","CADENA","ENDMARKER","DEDENT",
"INDENT","OR","AND","NOT","NEWLINE","IGUAL","PRINT","IF","DOSPUNTOS","ELSE",
"WHILE","MENOR","MAYOR","IGUALIGUAL","DISTINTO","MAS","MENOS","POR","MODULO",
"DIV","POTENCIA","PARENTESIS1","PARENTESIS2","RETURN","MAYORIGUAL","MENORIGUAL",
"BOOLEAN",
};
final static String yyrule[] = {
"$accept : file_input",
"file_input : NEWLINE file_input",
"file_input : stmt file_input",
"file_input : ENDMARKER",
"file_input : NEWLINE",
"file_input : file_input NEWLINE",
"file_input : stmt",
"file_input : test",
"stmt : simple_stmt",
"stmt : compound_stmt",
"simple_stmt : small_stmt NEWLINE",
"small_stmt : expr_stmt",
"small_stmt : print_stmt",
"expr_stmt : test IGUAL test",
"print_stmt : PRINT test",
"compound_stmt : if_stmt",
"compound_stmt : while_stmt",
"if_stmt : IF test DOSPUNTOS suite ELSE DOSPUNTOS suite",
"while_stmt : WHILE test DOSPUNTOS suite",
"suite : simple_stmt",
"suite : NEWLINE INDENT stmt aux0 DEDENT",
"aux0 : stmt",
"aux0 : aux0 stmt",
"test : or_test",
"or_test : and_test",
"or_test : and_test aux1",
"aux1 : OR and_test",
"aux1 : aux1 OR and_test",
"and_test : not_test",
"and_test : not_test aux2",
"aux2 : AND not_test",
"aux2 : aux2 AND not_test",
"not_test : NOT not_test",
"not_test : comparison",
"comparison : expr",
"comparison : expr aux3",
"aux3 : comp_op expr",
"aux3 : comp_op expr aux3",
"comp_op : MENOR",
"comp_op : MAYOR",
"comp_op : IGUALIGUAL",
"comp_op : MAYORIGUAL",
"comp_op : MENORIGUAL",
"comp_op : DISTINTO",
"expr : term",
"expr : term aux4",
"aux4 : MAS term",
"aux4 : MENOS term",
"aux4 : MAS term aux4",
"aux4 : MENOS term aux4",
"term : factor",
"term : factor aux5",
"aux5 : POR factor",
"aux5 : MODULO factor",
"aux5 : DIV factor",
"aux5 : aux5 POR factor",
"aux5 : aux5 MODULO factor",
"aux5 : aux5 DIV factor",
"factor : MAS factor",
"factor : MENOS factor",
"factor : power",
"power : atom",
"power : atom POTENCIA factor",
"atom : IDENTIFICADOR",
"atom : ENTERO",
"atom : REAL",
"atom : BOOLEAN",
"atom : PARENTESIS1 test PARENTESIS2",
};

//#line 136 "/Users/hectorsama/Documents/Repositorios/Compiladores/Proyectos/Proyecto_2/src/main/byaccj/parser.y"
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
//#line 417 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
