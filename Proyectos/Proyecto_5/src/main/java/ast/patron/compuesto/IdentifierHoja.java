package ast.patron.compuesto;
import ast.patron.visitante.*;

public class IdentifierHoja extends Hoja
{

    public IdentifierHoja(String id){
	name = id;
    }
    public int accept(Visitor v){
     	return v.visit(this);
    }
}
