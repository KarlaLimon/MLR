/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;

import java.util.Scanner;

/**
 *
 * @author morfeus
 */
public class Procesamiento {
    
    // Scanner
    Scanner inputs = new Scanner(System.in);
    
    //Atributes
    static double B0, B1, B2, DS;
    static double sumX1 = 0;
    static double sumX2 = 0;
    static double sumY = 0;
    static double sumX1sq = 0;
    static double sumX2sq = 0;
    static double sumX1Y = 0;
    static double sumX2Y = 0;
    static double sumX1X2 = 0;
    static double Mtx[][];
    static double Matrix[][];
    
    static DataSet dataset;
    
    // Constructor
    public Procesamiento(DataSet _dataset) {
        this.dataset = _dataset;
    }
    
    // Metodos
    // Procesamiento para realizar la mlr
    public static void sumatorias(){
        double[][] data = dataset.getData();
        
        for (int i = 0; i < data.length; i++) {
            sumX1 += data[i][0];
            sumX2 += data[i][1];
            sumY += data[i][2];
            sumX1sq += data[i][0] * data[i][0];
            sumX2sq += data[i][1] * data[i][1];
            sumX1Y += data[i][0] * data[i][2];
            sumX2Y += data[i][1] * data[i][2];
            sumX1X2 += data[i][0] * data[i][1];
        }
        
        double[][] Mtx = {
            {data.length, sumX1, sumX2, sumY},
            {sumX1, sumX1sq, sumX1X2, sumX1Y},
            {sumX2, sumX1X2, sumX2sq, sumX2Y}
        };
        
        Matrix = Mtx;
        Mtx = null;
    }
    
    // Matriz Determinante del sistema
    public static void CramerDS() {
       
        DS = (((Matrix[0][0] * Matrix[1][1] * Matrix[2][2])
        + (Matrix[0][1] * Matrix[1][2] * Matrix[0][2])
        + (Matrix[0][2] * Matrix[1][0] * Matrix[2][1]))
        - ((Matrix[2][0] * Matrix[1][1] * Matrix[0][2])
        + (Matrix[2][1] * Matrix[1][2] * Matrix[0][0])
        + (Matrix[2][2] * Matrix[1][0] * Matrix[0][1])));
    }
    
    //Matriz determinante de B0
    public static void CramerB0() {

        B0 = (((Matrix[0][3] * Matrix[1][1] * Matrix[2][2])
            + (Matrix[0][1] * Matrix[1][2] * Matrix[2][3])
            + (Matrix[0][2] * Matrix[1][3] * Matrix[2][1])
            - ((Matrix[2][3] * Matrix[1][1] * Matrix[0][2])
            + (Matrix[2][1] * Matrix[1][2] * Matrix[0][3])
            + (Matrix[2][2] * Matrix[1][3] * Matrix[0][1]))));
        B0 = B0 / DS;
    }
    
    //Matriz determinante de B0
    public static void CramerB1() {
        
        B1 = (((Matrix[0][0] * Matrix[1][3] * Matrix[2][2])
            + (Matrix[0][3] * Matrix[1][2] * Matrix[2][0])
            + (Matrix[0][2] * Matrix[1][0] * Matrix[2][3]))
            - ((Matrix[0][2] * Matrix[1][3] * Matrix[0][2])
            + (Matrix[2][3] * Matrix[1][2] * Matrix[0][0])
            + (Matrix[2][2] * Matrix[1][0] * Matrix[0][3])));
        B1 = B1 / DS;
    }
    
   //Matriz determinante de B0
    public static void CramerB2() {

        B2 = (((Matrix[0][0] * Matrix[1][1] * Matrix[2][3])
            + (Matrix[0][1] * Matrix[1][3] * Matrix[2][0])
            + (Matrix[0][3] * Matrix[1][0] * Matrix[2][1]))
            - ((Matrix[2][0] * Matrix[1][1] * Matrix[0][3])
            + (Matrix[2][1] * Matrix[1][3] * Matrix[0][0])
            + (Matrix[2][3] * Matrix[1][0] * Matrix[0][1])));
        B2 = B2 / DS;
    }  
    
    public static void Resultados(double x0, double x1) {
        double y = B0 + (B1 * x0) + (B2 * x1);
        System.out.println("Ecuación: " + "y = " + B0 + " + " + B1 + "x1 + " + B2 + "x2");
        System.out.println("y  = " + y);
    }
    
}
