package ast.patron.visitante;

import java.util.Hashtable;

/**
 *
 * @author hectorsama
 */
public class TablaDeSimbolos {

    Hashtable h;
    //Constructor

    public TablaDeSimbolos() {
        //Creación de la tabla de símbolos
        h = new Hashtable<String, String>();
    }

    /*Regresa el valor asociado a name en la tabla de
    símbolos o null en caso de que no haya sido encontrado en la tabla.*/
    public String lookup(String name) {
        if (!this.h.containsKey(name)) {
            return null;
        }
        return (String) this.h.get(name);
    }

/*Guarda info en h(name).*/
    public void insert(String name, String info) {
        this.h.put(name, info);

    }
}
