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
import java.awt.event.MouseListener ;
import java.awt.event.MouseMotionListener ;
import java.awt.event.MouseEvent ;
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
        
        float yO = 600.0f ;
        float xO = 20.0f ;
        
        // Crée des sols
        for( int i=0; i<20; i++ )
        {
            this.laScene.ajoute( new AcSol( xO+i*32, yO ));
        }
                                        
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
}
