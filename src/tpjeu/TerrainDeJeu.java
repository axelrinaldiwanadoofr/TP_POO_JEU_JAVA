package tpjeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package tpjeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Timer ;

/**
 *
 * @author axel
 */
public class TerrainDeJeu extends JPanel
{
    public TerrainDeJeu()
    {
        super() ;
                
        this.laScene = new Scene() ;
        
        // Ligne de sol
        for( int i=0; i<40; i++ )
        {
            this.laScene.ajoute( new AcSol( 10.0f+i*32.0f, 632.0f )) ;
        }
        
        // Ajoute une balle
        this.laScene.ajoute( new AcBalle( 10.0f, 600.0f, 3.0f, -8.0f, 0.0f, 0.1f ));
                                
        this.timer = new Timer() ;
        this.threadJeu = new JeuTask( this ) ;
        
        this.timer.schedule( this.threadJeu, 10, 20 );        
    }
    
    public Scene getScene()
    {
        return laScene ;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setBackground( Color.WHITE ) ;
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        this.laScene.onDraw(g2d, this);
                
        
    }   
        
    protected Scene laScene ;
    
    protected Timer timer ;
    protected JeuTask threadJeu ;
}
