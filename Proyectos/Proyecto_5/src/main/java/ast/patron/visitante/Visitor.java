package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public int visit(AddNodo n);  //
    public int visit(MultNodo n);
    public int visit(DivNodo n);
    public int visit(DivENodo n);
    public int visit(ModNodo n);
    public int visit(PotNodo n);
    public int visit(AndNodo n);
    public int visit(OrNodo n);
    public int visit(NotNodo n);
    public int visit(MenorNodo n);
    public int visit(MayorNodo n);
    public int visit(MenorIgualNodo n);
    public int visit(MayorIgualNodo n);
    public int visit(IgualIgualNodo n);
    public int visit(InNodo n);
    public int visit(FloatHoja n);
    public int visit(MasIgualNodo n);
    public int visit(BoolHoja n);
    public int visit(WhileNodo n);
    public int visit(PrintnNodo n);
    public int visit(StringHoja n);
    public int visit(DiferenteNodo n);    
    public int visit(AsigNodo n);
    public int visit(Compuesto n);
    public int visit(DifNodo n);  //
    public int visit(Hoja n);
    public int visit(IdentifierHoja n);
    public int visit(IntHoja n);
    public int visit(Nodo n);
    public int visit(NodoBinario n);
    public int visit(NodoStmts n);
    public int visit(IfNodo n);
    public int visit(DosPuntosNodo n);
    public int visit(ElseNodo n);
    public int visit(PostNodo n);
    public int visit(NegNodo n);
    
    
}
