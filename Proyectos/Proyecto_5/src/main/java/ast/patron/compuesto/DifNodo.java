package ast.patron.compuesto;
import ast.patron.visitante.*;

public class DifNodo extends NodoBinario
{

    public DifNodo(Nodo l, Nodo r){
	super(l,r);
    }

    public int accept(Visitor v){
     	return v.visit(this);
    }
}