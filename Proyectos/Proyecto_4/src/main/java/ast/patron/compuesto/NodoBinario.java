package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoBinario extends Compuesto
{
    public NodoBinario(Nodo l, Nodo r){
	this.agregaHijoPrincipio(l);
	this.agregaHijoFinal(r);
    }

    public NodoBinario(Nodo l){
	this.agregaHijoPrincipio(l);
    }

    public NodoBinario(){
	super();
    }

    public int accept(Visitor v){
     	return v.visit(this);
    }
}
