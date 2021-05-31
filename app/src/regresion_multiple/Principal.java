/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regresion_multiple;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int _n = 0, _cot = 0;
        float _y[], _x1[], _x2[];
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.print("Ingresa el tamaño del arreglo: ");
            while(!sc.hasNextInt()){
                System.out.println("¡Ingresa un número entero valido!");
                sc.next();
            }
        _n = sc.nextInt();
        }while(_n <=0);
        
        _y = new float[_n];
        _x1 = new float[_n];
        _x2 = new float[_n];
        
//        System.out.println("Ingresa los valores de la variable dependiente");
//        _y = Helper.fill_array(_n);
//        Helper.clean_screen();
        
        System.out.println("Ingresa los valores de la variable independiente x1");
        _x1 = Helper.fill_array(_n);
        Helper.clean_screen();
        
        System.out.println("Ingresa los valores de la variable independiente x2");
        _x2 = Helper.fill_array(_n);
        Helper.clean_screen();
        
        // Agregamos una matriz con 1 y x1, x2
        float[][] unitaria = Helper.matriz_1(_x1, _x2);
        //Helper.print_biderectional(unitaria);
        
        // Obtenemos matrz transpuesta
        float[][] traspuesta = Helper.matriz_transpuesta(_x1, _x2);
        
        /* Una multiplicacion de matrices es un sumatoria que se multiplica 
        entre si */
        /* En una multplicacion de matrices se multiplica la fila de la matriz
        primaria, por la columna de la matriz secundaria y se suman sus 
        productos
        */
        
        // Matriz traspuesta por matriz unitaria
        float[][] traspuestaXunitaria = Helper.traspuestaXunitaria(unitaria,traspuesta);
    }
    
}
