/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.util.TimerTask;

/**
 *
 * @author axel
 */
public class JeuTachePrincipale extends TimerTask 
{
    public JeuTachePrincipale( TerrainDeJeu terrain )
    {
        this.terrain = terrain ;
    }
    
    public void run()
    {
        if( this.terrain.getScene().onTimer() )
        {
            this.terrain.repaint();
        }
        
        System.out.print( "!");
    }       
    
    private TerrainDeJeu terrain ;
            
}
