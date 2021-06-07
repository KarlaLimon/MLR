/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author morfeus
 */
public class MlrGui extends JFrame{
    
    // Atributos
    private MlrAgent myAgent;
    
    // Constructor
    public MlrGui(MlrAgent _mlrAgent) {
        super(_mlrAgent.getLocalName());
        
        myAgent = _mlrAgent;
        
        JPanel panel = new JPanel();
        JTextField texto1, texto2;
        
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Agrega el valor de x0: "));
        texto1 = new JTextField(15);
        panel.add(texto1);
        panel.add(new JLabel("Agrega el valor de x1: "));
        texto2 = new JTextField(15);
        panel.add(texto2);
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JButton addButton = new JButton("Calcular");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                    try {
                        DataSet data = new DataSet();
                        String x0Val = texto1.getText().trim();
                        double x0 = Double.parseDouble(x0Val);
                        texto1.setText("");
                        
                        String x1Val = texto2.getText().trim();
                        double x1 = Double.parseDouble(x1Val);
                        texto2.setText("");
                        
                        Procesamiento procesamiento = new Procesamiento(data);
                        procesamiento.sumatorias();
                        procesamiento.CramerDS();
                        procesamiento.CramerB0();
                        procesamiento.CramerB1();
                        procesamiento.CramerB2();
                        procesamiento.Resultados(x0, x1);
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(MlrGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }
        } );
        
        panel = new JPanel();
        panel.add(addButton);
        getContentPane().add(panel, BorderLayout.SOUTH);   
        
        addWindowListener(new	WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                        myAgent.doDelete();
                }
        } );   
        
        setResizable(false);
    }
    
    // Metodos
    public void showGui() {
        pack();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerX = (int)screenSize.getWidth() / 2;
            int centerY = (int)screenSize.getHeight() / 2;
            setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
            super.setVisible(true);
    }
}
