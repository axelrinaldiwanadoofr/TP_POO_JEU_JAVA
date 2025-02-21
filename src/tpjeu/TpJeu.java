/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpjeu;

import javax.swing.JFrame ;

        

/**
 *
 * @author axel
 */
public class TpJeu 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        
        JFrame frame = new JFrame();
        frame.add( new TerrainDeJeu() ) ;

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
