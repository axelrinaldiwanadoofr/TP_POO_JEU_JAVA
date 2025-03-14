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
        GameSceneryFactory scfc = null ;
        
        TerrainDeJeu terrain = new TerrainDeJeu() ;
        
        //scfc = new GaScFcCasseBrique() ;
        //scfc.buildGameScenery( terrain.getScene() );

        scfc = new GaScFcMario2d() ;
        scfc.buildGameScenery( terrain.getScene() );
        
        JFrame frame = new JFrame();
        frame.add( terrain ) ;

        frame.setSize(30+31*32, 23*32);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
