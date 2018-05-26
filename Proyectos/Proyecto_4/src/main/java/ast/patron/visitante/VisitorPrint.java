package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{
    public int visit(MultNodo n){
        System.out.println("[*]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }

        public int visit(PotNodo n){
       System.out.println("[**]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       }  
        
        
        public int visit(AndNodo n){
       System.out.println("[and]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       
    }   
        
     public int visit(OrNodo n){
       System.out.println("[or]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       
    }
     
      public int visit(NotNodo n){
       System.out.println("[not]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       
    }
        public int visit(PrintnNodo n){
        System.out.println("[print]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        return 0;
        
    }

      public int visit(ModNodo n){
        System.out.println("[%]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
      public int visit(MenorNodo n){
        System.out.println("[<]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
      
      public int visit(MayorNodo n){
        System.out.println("[<]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }   
        public int visit(WhileNodo n){
        System.out.println("[While]");
        System.out.print("[Condition: ");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[Do: ");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }

      
      public int visit(DiferenteNodo n){
        System.out.println("[!=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    } 
      public int visit(MenorIgualNodo n){
        System.out.println("[<=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
        public int visit(MayorIgualNodo n){
        System.out.println("[>=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
        
        public int visit(InNodo n){
        System.out.println("[in]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
       public int visit(IgualIgualNodo n){
        System.out.println("[==]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
        public int visit(MasIgualNodo n){
        System.out.println("[+=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
       public int visit(DivNodo n){
       System.out.println("[/]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       
    }
       
       public int visit(DivENodo n){
       System.out.println("[//]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
       
    }
    public int visit(AddNodo n){
        System.out.println("[+]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;
    }
    public int visit(AsigNodo n){
        System.out.println("[=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
        return 0;

    }
    public int visit(Compuesto n){
        for (Iterator i = n.getHijos().iterator(); i.hasNext(); ) {
            Nodo hijo = (Nodo) i.next();
            System.out.print("[");
            hijo.accept(this);
            System.out.println("]");
        }
        return 0;

    }
    public int visit(DifNodo n){
        System.out.println("[-]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
        return 0;
    }
    
 public int visit(IfNodo n){
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
        return 0;
    }

    
    public int visit(ElseNodo n){
        System.out.println("[else]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
        return 0;
    }
    
    public int visit(DosPuntosNodo n){
        System.out.println("[:]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
        return 0;
    }
    
    public int visit(Hoja n){
        return 0;

    }
    public int visit(IdentifierHoja n){
	System.out.print("[Hoja Identificador] id: "+ n.getNombre());
        return 0;
    }
    public int visit(IntHoja n){
	System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
        return 0;
    }


     public int visit(FloatHoja n){
        System.out.print("[Hoja Rela] valor: " + n.getValor().dval);
        return 0;
    }
     public int visit(StringHoja n){
        System.out.print("[Hoja String] valor: " + n.getValor().sval);
        return 0;
    }
      public int visit(BoolHoja n){
        System.out.print("[Hoja Boolean] valor: " + n.getValor().bval);
        return 0;
    }


    public int visit(Nodo n){
        return 0;

    }
    public int visit(NodoBinario n){
        return 0;

    }
    public int visit(NodoStmts n){
        return 0;
    }

    public int visit(PostNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int visit(NegNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
