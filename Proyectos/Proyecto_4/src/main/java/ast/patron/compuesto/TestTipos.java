/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import java.util.ArrayList;

/**
 *
 * @author juan_Ricky_Riquín_Canallín
 */
public class TestTipos {
    
    ArrayList<String> lista_tipos;
    
    
    /*
    Se define como:
    0=booleano
    1=entero
    2=real
    3=cadena
    -1=invalido
    */
  
    //Tabla de tipo para la resta
    private int[][] resta = new int[][]{{0,1,2,3},
                                        {1,1,2,3},
                                        {2,2,2,3},
                                        {3,3,3,3}};
    //Tabla de tipo para la suma
    private int[][] suma = new int[][]{{0,1,2,3},
                                       {1,1,2,3},
                                       {2,2,2,3},
                                       {3,3,3,3}};
    //Tabla de tipo para la multiplicacion
    private int[][] multiplicacion = new int[][]{{1,1,2,3},
                                                 {1,1,2,-1},
                                                 {2,2,2,-1},
                                                 {3,-1,-1,-1}};
    //Tabla de tipo para la division
    private int[][] div = new int[][]{
                                      {1,1,2,-1},
                                      {1,1,2,-1},
                                      {2,2,2,-1},
                                      {-1,-1,-1,-1}};
    
    //Tabla de modulo
    private int[][] mod= new int [][]{
                                               {1, 1, 2, -1},
                                               {1, 1, 2, -1},
                                               {2, 2, 2, -1},
                                               {-1,-1,-1,-1} };
    
    //Tabla de comparaciones
    private int [][] com= new int[][]{
                                        {0, 0, 0, 0},
                                        {0, 0, 0, 0},
                                        {0, 0, 0, 0},
                                        {0, 0, 0, 0}};
    
    
    
    //Tabla para la operacion  unaria
  private final byte[] unarios = new byte[] {1,1,2,-1};

    
    //Constructor
    public TestTipos() {
    lista_tipos = new ArrayList<String>();
    lista_tipos.add("Booleano");
    lista_tipos.add("Entero");
    lista_tipos.add("Real");
    lista_tipos.add("Cadena");
  }


}
