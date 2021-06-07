/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;

/**
 *
 * @author morfeus
 */
public class MLR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Obtenemos los datos
        DataSet data = new DataSet();
        
        // Procesamiento para mlr
        Procesamiento procesamiento = new Procesamiento(data);
        procesamiento.sumatorias();
        procesamiento.CramerDS();
        procesamiento.CramerB0();
        procesamiento.CramerB1();
        procesamiento.CramerB2();
        procesamiento.Resultados(56.01, 56.29);
    }
    
}
