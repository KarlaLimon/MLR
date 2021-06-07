/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;

/**
 *
 * @author morfeus
 * Guarda los datos de arreglo bidimencional
 */
public class DataSet {
    double [][] data;
    
    public DataSet(){
        this.data = this.getDataExample();
    }
    
    private double [][] getDataExample(){
        
        double [][] example_data = {
//           x1  x2   y               
            {66, 66, 66},
            {70, 63.5, 63.5},
            {70, 63.7, 62.2},
            {71, 64, 65.5},
            {68, 65, 72},
            {70.5, 64, 65},
            {69.5, 62, 69},
            {68.2, 63.5, 65.5},
            {72.5, 62, 71},
            {71, 69, 67},
            {65.5, 63, 69},
            {69, 63.5, 61},
            {71, 63, 63},
            {66.5, 63, 65},
            {66, 59, 58},
            {68.5, 65, 69.2},
            {71, 67, 69},
            {70, 60, 65},
            {69, 63.5, 70.5},
            {69, 62.5, 71},};   
            
        return example_data;
    }
    
    public double[][] getData(){
        return data;
    }
    
    public void setData(double [][] data){
        this.data = data;
    }
}
