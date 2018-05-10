/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import ast.patron.visitante.*;

/**
 *
 * @author hectorsama
 */
public class StringHoja extends Hoja
{
    public StringHoja(String i){
	valor = new Variable(i);
                    
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}