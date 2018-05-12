package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{
    public void visit(MultNodo n){
        System.out.println("[*]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

        public void visit(PotNodo n){
       System.out.println("[**]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       }  
        
        
        public void visit(AndNodo n){
       System.out.println("[and]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       
    }   
        
     public void visit(OrNodo n){
       System.out.println("[or]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       
    }
     
      public void visit(NotNodo n){
       System.out.println("[not]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       
    }
        public void visit(PrintnNodo n){
        System.out.println("[print]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        
    }

      public void visit(ModNodo n){
        System.out.println("[%]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
      public void visit(MenorNodo n){
        System.out.println("[<]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
      
      public void visit(MayorNodo n){
        System.out.println("[<]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }   
        public void visit(WhileNodo n){
        System.out.println("[While]");
        System.out.print("[Condition: ");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[Do: ");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

      
      public void visit(DiferenteNodo n){
        System.out.println("[!=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    } 
      public void visit(MenorIgualNodo n){
        System.out.println("[<=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
        public void visit(MayorIgualNodo n){
        System.out.println("[>=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
        
        public void visit(InNodo n){
        System.out.println("[in]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
       public void visit(IgualIgualNodo n){
        System.out.println("[==]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
        public void visit(MasIgualNodo n){
        System.out.println("[+=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
       public void visit(DivNodo n){
       System.out.println("[/]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       
    }
       
       public void visit(DivENodo n){
       System.out.println("[//]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
       
    }
    public void visit(AddNodo n){
        System.out.println("[+]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
    public void visit(AsigNodo n){
        System.out.println("[=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");

    }
    public void visit(Compuesto n){
        for (Iterator i = n.getHijos().iterator(); i.hasNext(); ) {
            Nodo hijo = (Nodo) i.next();
            System.out.print("[");
            hijo.accept(this);
            System.out.println("]");
        }

    }
    public void visit(DifNodo n){
        System.out.println("[-]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
    }
    
 public void visit(IfNodo n){
        System.out.println("[If]");
        //En el caso de que sean 3 "condition" "then" "else"
        if(n.numeroHijos()==3){
            LinkedList<Nodo> hijos = n.getTotal();
            System.out.print("[Condition: ");
            hijos.get(0).accept(this);
            System.out.print("]");
            System.out.print("[Then: ");
            hijos.get(1).accept(this);
            System.out.print("]");
            System.out.print("[Else: ");
            hijos.get(2).accept(this);
            System.out.print("]");
        }else{
            //Cuando solo es "condition" y "then"
            LinkedList<Nodo> hijos = n.getTotal();
            System.out.print("[Condition: ");
            hijos.get(0).accept(this);
            System.out.print("]");
            System.out.print("[Then: ");
            hijos.get(1).accept(this);
            System.out.print("]");
        }
    }

    
    public void visit(ElseNodo n){
        System.out.println("[else]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
    }
    
    public void visit(DosPuntosNodo n){
        System.out.println("[:]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
    }
    
    public void visit(Hoja n){

    }
    public void visit(IdentifierHoja n){
	System.out.print("[Hoja Identificador] id: "+ n.getNombre());
    }
    public void visit(IntHoja n){
	System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }


     public void visit(FloatHoja n){
        System.out.print("[Hoja Rela] valor: " + n.getValor().dval);
    }
     public void visit(StringHoja n){
        System.out.print("[Hoja String] valor: " + n.getValor().sval);
    }
      public void visit(BoolHoja n){
        System.out.print("[Hoja Boolean] valor: " + n.getValor().bval);
    }


    public void visit(Nodo n){

    }
    public void visit(NodoBinario n){

    }
    public void visit(NodoStmts n){
    }
}
