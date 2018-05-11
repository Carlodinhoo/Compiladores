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
public class BoolHoja extends Hoja
{
    public BoolHoja(String i){
        if (i.equals("False")){
            valor = new Variable(false);
        } else{
            valor = new Variable(true);
        }
        tipo = 1;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}
