package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public void visit(AddNodo n);  //
    public void visit(MultNodo n);
    public void visit(DivNodo n);
    public void visit(DivENodo n);
    public void visit(ModNodo n);
    public void visit(PotNodo n);
    public void visit(AndNodo n);
    public void visit(OrNodo n);
    public void visit(NotNodo n);
    public void visit(MenorNodo n);
    public void visit(MayorNodo n);
    public void visit(MenorIgualNodo n);
    public void visit(MayorIgualNodo n);
    public void visit(IgualIgualNodo n);
    public void visit(InNodo n);
    public void visit(FloatHoja n);
    public void visit(MasIgualNodo n);
    public void visit(BoolHoja n);
    public void visit(WhileNodo n);
    public void visit(PrintnNodo n);
    public void visit(StringHoja n);
    public void visit(DiferenteNodo n);    
    public void visit(AsigNodo n);
    public void visit(Compuesto n);
    public void visit(DifNodo n);  //
    public void visit(Hoja n);
    public void visit(IdentifierHoja n);
    public void visit(IntHoja n);
    public void visit(Nodo n);
    public void visit(NodoBinario n);
    public void visit(NodoStmts n);
    public void visit(IfNodo n);
    public void visit(DosPuntosNodo n);
    public void visit(ElseNodo n);
    
}
