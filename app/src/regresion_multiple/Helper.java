/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regresion_multiple;

import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class Helper {
    
    static Scanner sc = new Scanner(System.in);
    
    public static float[] fill_array(int tam){
        float _foo = 0.0f;
        int i = 1, j = 0;
        float[] aux = new float[tam];
        do {
            System.out.print("Ingresa la posicion [" + (j+1) + "] : ");
            while(!sc.hasNextFloat()){
                System.out.println("¡Ingresa un número valido!");
                sc.next();
            }
            
            _foo = sc.nextFloat();
            aux[j] = _foo;
            i++;
            j++;
        } while (i<= tam);

        return aux;
    }
    
    public static void clean_screen(){
        
        try{
            final String os = System.getProperty("os.name"); 
            if(os.contains("Windows")){
                //Runtime.getRuntime().exec("cls");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear"); 
            }
        }catch (final Exception e){
            e.printStackTrace();  
        }  
    }
    
    public static float[][] matriz_1(float[]a, float[]b){
        int i = 0;
        float[][] aux = new float[8][3];
        
        for (i = 0; i < 8; i++) {
            aux[i][0] = 1;
            aux[i][1] = a[i];
            aux[i][2] = b[i];
        }   
        
        return aux;
    }
    
    public static float[][] matriz_transpuesta(float[]a, float[]b){
        int j = 0;
        float[][] aux = new float[8][3];
        
        for (j = 0; j < 8; j++){
            aux[0][j] = 1;
            aux[1][j] = a[j];
            aux[2][j] = b[j];
        }
        
        return aux;
    } 
    
    public static void print_biderectional(float[][] aux){        
        for(float[] a : aux){
            for(float i : a){
                System.out.println(i + "\t");
            }
            
            System.out.println("\n");
        }
    }
    
    public static void print_uni(float[] aux){
        for(int x=0; x<aux.length; x++){
            System.out.println(aux[x] + "\t");
        }
    } 
    
    public static float[][] traspuestaXunitaria(float[][]a, float[][]b){
        int mul = 0;
        float[][] aux = new float[3][3];
        
        for(int i=0;i<3;i++){
             for(int k=0;k<3;k++){
                 for(int j=0;j<b[0].length;j++){                    
                      mul += b[i][j] * a[j][k];
                 }

                aux[i][k] = mul;
                System.out.print(mul+"  ");
                mul =0;
                //Para presentar mejor la matriz en consola
                if(k==2){
                  System.out.println("");  
                }
             }           
        }

        return aux;
    }
    
}
