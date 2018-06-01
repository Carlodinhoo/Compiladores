/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

import ast.patron.compuesto.AddNodo;
import ast.patron.compuesto.AndNodo;
import ast.patron.compuesto.AsigNodo;
import ast.patron.compuesto.BoolHoja;
import ast.patron.compuesto.Compuesto;
import ast.patron.compuesto.DifNodo;
import ast.patron.compuesto.DiferenteNodo;
import ast.patron.compuesto.DivENodo;
import ast.patron.compuesto.DivNodo;
import ast.patron.compuesto.DosPuntosNodo;
import ast.patron.compuesto.ElseNodo;
import ast.patron.compuesto.FloatHoja;
import ast.patron.compuesto.Hoja;
import ast.patron.compuesto.IdentifierHoja;
import ast.patron.compuesto.IfNodo;
import ast.patron.compuesto.IgualIgualNodo;
import ast.patron.compuesto.InNodo;
import ast.patron.compuesto.IntHoja;
import ast.patron.compuesto.MasIgualNodo;
import ast.patron.compuesto.MayorIgualNodo;
import ast.patron.compuesto.MayorNodo;
import ast.patron.compuesto.MenorIgualNodo;
import ast.patron.compuesto.MenorNodo;
import ast.patron.compuesto.ModNodo;
import ast.patron.compuesto.MultNodo;
import ast.patron.compuesto.NegNodo;
import ast.patron.compuesto.Nodo;
import ast.patron.compuesto.NodoBinario;
import ast.patron.compuesto.NodoStmts;
import ast.patron.compuesto.NotNodo;
import ast.patron.compuesto.OrNodo;
import ast.patron.compuesto.PostNodo;
import ast.patron.compuesto.PotNodo;
import ast.patron.compuesto.PrintnNodo;
import ast.patron.compuesto.StringHoja;
import ast.patron.compuesto.WhileNodo;
import java.util.Iterator;

/**
 *
 * @author juan
 */
public class VisitanteGenerador implements Visitor {

    Registros reg = new Registros();
    String instrucciones = "main:\n"+".data\n";
    
    public String Imprime(){
        return instrucciones;
    }
    
    public int visit(DifNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        int tipo = n.getType();
        boolean entero =  tipo ==2 ? false : true;

        String objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2, entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0], entero);
        hi.accept(this);

        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1], entero);
        hd.accept(this);

        String opcode;
        if (tipo == 2) {
            opcode = "sub.s";
        } else {
            opcode = "sub";
        }

        System.out.println(opcode + " " + objetivo + ", "
                + siguientes[0] + ", " + siguientes[1]);
        return 0;
    }

    public int visit(AddNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        int tipo = n.getType();
        boolean entero =  tipo ==2 ? false : true;

        String objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2, entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0], entero);
        hi.accept(this);

        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1], entero);
        hd.accept(this);

        String opcode;
        if (tipo == 2) {
            opcode = "add.s";
        } else {
            opcode = "add";
        }

        System.out.println(opcode + " " + objetivo + ", "
                + siguientes[0] + ", " + siguientes[1]);
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MultNodo n) {

        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        int tipo = n.getType();
        boolean entero =  tipo ==2 ? false : true;

        String objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2, entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0], entero);
        hi.accept(this);

        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1], entero);
        hd.accept(this);

        String opcode;
        if (tipo == 2) {
            opcode = "mul.s";
        } else {
            opcode = "mul";
        }

        System.out.println(opcode + " " + objetivo + ", "
                + siguientes[0] + ", " + siguientes[1]);
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(DivNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        int tipo = n.getType();
        boolean entero =  tipo ==2 ? false : true;

        String objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2, entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0], entero);
        hi.accept(this);

        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1], entero);
        hd.accept(this);

        String opcode;
        if (tipo == 2) {
            opcode = "div.s";
        } else {
            opcode = "div";
        }

        System.out.println(opcode + " " + objetivo + ", "
                + siguientes[0] + ", " + siguientes[1]);
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int visit(DivENodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(ModNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(PotNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(AndNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(OrNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(NotNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MenorNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MayorNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MenorIgualNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MayorIgualNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(IgualIgualNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(InNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(FloatHoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(MasIgualNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(BoolHoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(WhileNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(PrintnNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        int tipo = n.getType();
        boolean entero =  tipo ==2 ? false : true;

        String objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2, entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0], entero);
        hi.accept(this);

        if (entero) {
            instrucciones += "move $a0 "+objetivo;
        } else {
            instrucciones += "move $f12 "+ objetivo+
                    " li $v0 1" + 
                    "syscall";
            
        }
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(StringHoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(DiferenteNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(AsigNodo n) {
        String hijo_izq = n.getPrimerHijo().getNombre();
        Nodo hijo_der = n.getUltimoHijo();
        //INCOMPLETO
        
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(Hoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(IdentifierHoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(IntHoja n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(Nodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(NodoBinario n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(NodoStmts n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(IfNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(DosPuntosNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(ElseNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(PostNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(NegNodo n) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
    public int visit(Compuesto n){
        
        return 0;
    }

}

