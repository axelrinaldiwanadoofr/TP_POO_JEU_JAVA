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


import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author axel
 */
public class TerrainDeJeu extends JPanel 
{
    public TerrainDeJeu()
    {
        this.laScene = new Scene() ;
        
        this.laScene.ajoute( new AcSol( 100, 100 ));
        
        for( int i=0; i<20; i++)
            this.laScene.ajoute( new AcBalle( 10, 10+i*30, 3+i, 2, 0, 0 ));
        
        this.timer = new Timer() ;
        this.tache = new JeuTachePrincipale( this ) ;
        
        this.timer.schedule( this.tache, 10, 20 );
        
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
        
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.RED);
        //g2d.drawLine(10, 10, 300, 100);
        //g2d.drawRect( 100, 100, 100, 50 ) ;


        g2d.translate(50, 200);
        g2d.rotate(Math.toRadians(30), getWidth() / 2.0, getHeight() / 2.0);
        g2d.clip(new Rectangle(-110, 110, 80, 110));
        g2d.fill(new Rectangle(-100, 100, 100, 100));
        
        
    }   
    
    protected Scene laScene ;
    
    protected Timer timer ;
    protected JeuTachePrincipale tache ;
}
