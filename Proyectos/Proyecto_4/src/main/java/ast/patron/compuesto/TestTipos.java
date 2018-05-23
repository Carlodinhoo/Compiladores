/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class TestTipos {
    
    ArrayList<String> lista;
  
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
    //Tabla de tipo 
    private int[][] div = new int[][]{{1,1,2,-1},
                                      {1,1,2,-1},
                                      {2,2,2,-1},
                                      {-1,-1,-1,-1}};
}
