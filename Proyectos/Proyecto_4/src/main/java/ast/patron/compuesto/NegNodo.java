/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author hectorsama
 */
public class NegNodo extends Compuesto{

    public NegNodo(Nodo l){
	super(l);
    }

    public int accept(Visitor v){
     	return v.visit(this);
    }
}
