package ast.patron.visitante;

import ast.patron.compuesto.*;

import java.util.Iterator;
import java.util.Hashtable;
import java.util.LinkedList;

/*La función visit sufrio un cambio en vez de ser void se cambio a que regresará un int  para faicilitar el obtener
 el tipo de los valores que se estan obteniendo dentro de la matriz*/
public class VisitanteTipo implements Visitor {

    private Hashtable<String, Integer> tabla;
    TestTipos test_tipos;

    public VisitanteTipo() {
        tabla = new Hashtable<String, Integer>();//con los metodos get(lookup) y put(insert)
        test_tipos = new TestTipos();

    }

    public int visit(AddNodo n) {

        if (n.getPrimerHijo() == null) {
            int hd = tabla.get(n.getUltimoHijo().getType());
            if (hd == 0) {

                System.out.println("Invalido");
            }
            System.out.println("Los siguientes son validos:  " + this.valorTipo(n.getPrimerHijo().getType()) + "  y  " + this.valorTipo(n.getUltimoHijo().getType()));
            int tipo1 = this.test_tipos.verificaU(hd);
            return tipo1;
        }
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        System.out.println("Los siguientes son validos: " + this.valorTipo(hijo_izquierdo) + "  y  " + this.valorTipo(hijo_derecho));
        int tipo = this.test_tipos.verificaAdd(hijo_izquierdo, hijo_derecho);
        //El valor de -1 es apartir de como definimos en la matriz de suma
        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + " + " + this.valorTipo(hijo_derecho));
            System.out.println("En el AddNodo");
            System.exit(0);
        }
        return tipo;
    }

    public int visit(Nodo n) {
        //No regresamos nada
        return 0;

    }

    public int visit(MultNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        System.out.println("Los siguientes son validos" + this.valorTipo(hijo_izquierdo) + "  y  " + this.valorTipo(hijo_derecho));
        int tipo = this.test_tipos.verificaMult(hijo_izquierdo, hijo_derecho);
        //El valor de -1 es apartir de como definimos en la matriz de suma
        if (tipo == -1) {
            System.out.println("Error : " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el MultNodo");
            System.exit(0);
        }
        return tipo;
    }

    public int visit(PotNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaPotencia(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {

            System.out.println("Error :" + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el PotNodo");
            System.exit(0);
        }

        return tipo;
    }

    public int visit(AndNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaAnd(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error : " + this.valorTipo(hijo_izquierdo) + " and " + this.valorTipo(hijo_derecho));
            System.out.println("En el AndNodo");
            System.exit(0);
        }

        return tipo;
    }

    public int visit(OrNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaOr(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error de tipos:" + this.valorTipo(hijo_izquierdo) + " and " + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;

    }

    public int visit(NotNodo n) {
        n.getPrimerHijo().accept(this);
        return 0;

    }

    public int visit(PrintnNodo n) {
        n.getPrimerHijo().accept(this);
        return 0;

    }

    public int visit(ModNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaModulo(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error : " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;
    }

    public int visit(MenorNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;
    }

    public int visit(MayorNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;

    }

    public int visit(WhileNodo n) {

        //System.out.println("[While]");
        // System.out.print("[Condition: ");
        n.getPrimerHijo().accept(this);
        //System.out.print("]");
        //System.out.print("[Do: ");
        n.getUltimoHijo().accept(this);
        //System.out.println("]");
        return 0;

    }

    public int visit(DiferenteNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;

    }

    public int visit(MenorIgualNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.exit(0);
        }

        return tipo;

    }

    public int visit(MayorIgualNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el MayorIgualNodo");
            System.exit(0);
        }

        return tipo;

    }

    public int visit(InNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el InNodo");
            System.exit(0);
        }

        return tipo;

    }

    public int visit(IgualIgualNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaCondicion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el IgualIgualNodo");
            System.exit(0);
        }

        return tipo;

    }

    public int visit(MasIgualNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        int tipo = this.test_tipos.verificaAsignacion(hijo_izquierdo, hijo_derecho);

        if (tipo == -1) {
            System.out.println("Error :  " + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el MasIgualNodo");
            System.exit(0);
        }

        return tipo;
    }

    public int visit(DivNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        System.out.println("Los siguientes son validos" + this.valorTipo(hijo_izquierdo) + "  y  " + this.valorTipo(hijo_derecho));
        int tipo = this.test_tipos.verificaDiv(hijo_izquierdo, hijo_derecho);
        //El valor de -1 es apartir de como definimos en la matriz de suma
        if (tipo == -1) {
            System.out.println("Error de tipos:" + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el DivNodo");
            System.exit(0);
        }
        return tipo;

    }

    public int visit(DivENodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        System.out.println("Los siguientes son validos" + this.valorTipo(hijo_izquierdo) + "  y  " + this.valorTipo(hijo_derecho));
        int tipo = this.test_tipos.verificaDivEntera(hijo_izquierdo, hijo_derecho);
        //El valor de -1 es apartir de como definimos en la matriz de suma
        if (tipo == -1) {
            System.out.println("Error de tipos:" + this.valorTipo(hijo_izquierdo) + this.valorTipo(hijo_derecho));
            System.out.println("En el DivENodo");
            System.exit(0);
        }
        return tipo;

    }

    public int visit(AsigNodo n) {
        int t = n.getUltimoHijo().accept(this);
        String id = n.getPrimerHijo().getNombre();

        if (this.tabla.get(id) == null) {
            this.tabla.put(id, t);
            return 0;
        }

        int tab = this.tabla.get(id);

        if (tab != t) {
            System.out.println("Error :" + this.valorTipo(tab) + "  y  " + this.valorTipo(t));
            System.out.println("En el AsigNodo");
            System.exit(0);
        }
        return 0;
    }

    public int visit(Compuesto n) {
        for (Iterator i = n.getHijos().iterator(); i.hasNext();) {
            Nodo hijo = (Nodo) i.next();
            //System.out.print("[");
            hijo.accept(this);
            //System.out.println("]");
        }
        return 0;

    }

    public int visit(DifNodo n) {
        int hijo_izquierdo = n.getPrimerHijo().accept(this);
        int hijo_derecho = n.getUltimoHijo().accept(this);
        System.out.println("Los siguientes son validos" + this.valorTipo(hijo_izquierdo) + "  y  " + this.valorTipo(hijo_derecho));
        int tipo = this.test_tipos.verificarR(hijo_izquierdo, hijo_derecho);
        //El valor de -1 es apartir de como definimos en la matriz de suma
        if (tipo == -1) {
            System.out.println("Error:" + this.valorTipo(hijo_izquierdo) + " + " + this.valorTipo(hijo_derecho));
            System.out.println("En el DifNodo");
            System.exit(0);
        }
        return tipo;
    }

    public int visit(IfNodo n) {
        //System.out.println("[If]");
        //En el caso de que sean 3 "condition" "then" "else"
        if (n.numeroHijos() == 3) {
            LinkedList<Nodo> hijos = n.getTotal();
            //System.out.print("[Condition: ");
            hijos.get(0).accept(this);
            //System.out.print("]");
            //System.out.print("[Then: ");
            hijos.get(1).accept(this);
            //System.out.print("]");
            //System.out.print("[Else: ");
            hijos.get(2).accept(this);
            //System.out.print("]");
        } else {
            //Cuando solo es "condition" y "then"
            LinkedList<Nodo> hijos = n.getTotal();
            //System.out.print("[Condition: ");
            hijos.get(0).accept(this);
            //System.out.print("]");
            //System.out.print("[Then: ");
            hijos.get(1).accept(this);
            //System.out.print("]");
        }
        return 0;
    }

    public int visit(ElseNodo n) {
        // System.out.println("[else]");
        //System.out.print("[");
        n.getPrimerHijo().accept(this);
        //System.out.print("]");
        n.getUltimoHijo().accept(this);
        return 0;
    }

    public int visit(Hoja n) {
        return 0;

    }

    public int visit(IdentifierHoja n) {
        if (this.tabla.get(n.getNombre()) == null) {
            System.out.println("Error : " + n.getNombre() + " Variable no definida");
            System.out.println("En el IdentifierHoja");
            System.exit(0);
        }

        return this.tabla.get(n.getNombre());
    }

    public int visit(IntHoja n) {
        return 1;

    }

    public int visit(FloatHoja n) {
        return 2;
    }

    public int visit(StringHoja n) {
        return 3;
    }

    public int visit(BoolHoja n) {
        return 0;
    }

    public int visit(NodoBinario n) {
        return 0;

    }

    public int visit(NodoStmts n) {
        return 0;
    }

    @Override
    public int visit(DosPuntosNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(PostNodo n) {
        n.getUltimoHijo().accept(this);
        return 0;
    }

    public int visit(NegNodo n) {
        n.getUltimoHijo().accept(this);
        return 0;
    }

    //Como tenemos definidos en 0 , 1 , 2,3 a booleano, entero , real, cadena respesctivamente
    public String valorTipo(int i) {
        switch (i) {
            case 0:
                return "Booleano";
            case 1:
                return "Entero";
            case 2:
                return "Real";
            case 3:
                return "Cadena";
        }
        return null;
    }

}
