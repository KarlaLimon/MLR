/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author morfeus
 */
public class MlrAgent extends Agent {
    
    private MlrGui myGui;
    
    // Put agent initializations here
    protected void setup() {
            addBehaviour(new mlrRegression());	
    }
        
    // Put agent clean-up operations here
    protected void takeDown() {

            // Close the GUI
            myGui.dispose();
            // Printout a dismissal message
            System.out.println("mlr-agent "+getAID().getName()+" terminating.");
    }        
    
    private class mlrRegression extends OneShotBehaviour {
    
        public void action() {
            myGui = new MlrGui(new MlrAgent());
            myGui.showGui();
        }
    }
}
