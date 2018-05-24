/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

import java.util.ArrayList;

/**
 *
 * @author juan_Ricky_Riquín_Canallín
 */
public class TestTipos {

    ArrayList<String> lista_tipos = new ArrayList();
    
    //Constructor
    public TestTipos() {
        ArrayList lista = lista_tipos;
        lista.add("Booleano");
        lista.add("Entero");
        lista.add("Real");
        lista.add("Cadena");
    }

    //Tabla de tipo para la resta
    private int[][] resta = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 2, -1},
    {-1, 2, 2, -1},
    {-1, -1, -1, -1}};
    //Tabla de tipo para la suma
    private int[][] suma = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 2, -1},
    {-1, 2, 2, -1},
    {-1, -1, -1, 3}};
    //Tabla de tipo para la multiplicacion
    private int[][] multiplicacion = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 2, -1},
    {-1, 2, 2, -1},
    {-1, -1, -1, -1}};
    //Tabla de tipo para la division
    private int[][] div = new int[][]{{-1, -1, -1, -1},
    {-1, 2, 2, -1},
    {-1, 2, 2, -1},
    {-1, -1, -1, -1}};

    //Tabla de modulo
    private int[][] mod = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 2, -1},
    {-1, 2, 2, -1},
    {-1, -1, -1, -1}};

    private int[][] divEntera = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 1, -1},
    {-1, 1, 1, -1},
    {-1, -1, -1, -1}
    };

    private int[][] potencia = new int[][]{{-1, -1, -1, -1},
    {-1, 1, 1, -1},
    {-1, 1, 1, -1},
    {-1, -1, -1, -1}
    };

    //Tabla para la operación de and
    private final int[][] and = new int[][]{
        {0, 1, 2, 3},
        {0, 1, 2, 3},
        {0, 1, 2, 3},
        {0, 1, 2, 3}
    };

    //Tabla para la operación de or
    private final int[][] or = new int[][]{
        {0, 0, 0, 0},
        {1, 1, 1, 1},
        {2, 2, 2, 2},
        {3, 3, 3, 3}
    };

    //Tabla para la operacion  unaria
    private final int[] unarios = new int[]{1, 1, 2, -1};

    //Metodo donde vemos si son validas las operaciones
    public String validacion(String op, String left, String right) {
        
        String resultado = "";
        if (lista_tipos.contains(left) && lista_tipos.contains(right)) {
            int tipo = 0;
            switch (op) {
                case "+":
                    tipo = suma[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "-":
                    tipo = resta[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "*":
                    tipo = multiplicacion[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "**":
                    tipo = potencia[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "/":
                    tipo = div[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "//":
                    tipo = divEntera[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "%":
                    tipo = mod[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "and":
                    tipo = and[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                case "or":
                    tipo = or[lista_tipos.indexOf(left)][lista_tipos.indexOf(right)];
                    break;
                default:
                    break;
            }
            if (tipo >= 0) {
                resultado = lista_tipos.get(tipo);
            } else {
                System.exit(1);
            }
        }
        return resultado;
    }


}
