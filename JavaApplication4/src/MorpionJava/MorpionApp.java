/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MorpionJava;

import javax.swing.SwingUtilities;

/**
 *
 * @author lesei
 */
public class MorpionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assuming InterfaceMorpion constructor takes a String argument
                int size = 5;
                new InterfaceMorpion(size);
            }
        });
    }
    
}
