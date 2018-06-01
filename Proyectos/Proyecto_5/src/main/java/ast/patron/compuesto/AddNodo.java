package ast.patron.compuesto;
import ast.patron.visitante.*;

public class AddNodo extends NodoBinario
{

    public AddNodo(Nodo l, Nodo r){
	super(l,r);
    }

    public int accept(Visitor v){
     	return v.visit(this);
    }
}
