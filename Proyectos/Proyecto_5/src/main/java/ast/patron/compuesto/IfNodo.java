/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import ast.patron.visitante.*;
import java.util.LinkedList;

/**
 *
 * @author juan
 */
public class IfNodo extends Compuesto
{
    //El compuesto esta contruido por Hijos
    public IfNodo(){
	super();
    }
    
    //Se obtine el total de hijos que estan en la lista tipo Nodo
    public LinkedList<Nodo> getTotal(){
        return hijos.getAll();
    }
    
    //Obtenenmos el numero de hijos para saber en que caso va a entrar.
    public int numeroHijos(){
        return hijos.size();
    }

    public int accept(Visitor v){
     	return v.visit(this);
    }
}

