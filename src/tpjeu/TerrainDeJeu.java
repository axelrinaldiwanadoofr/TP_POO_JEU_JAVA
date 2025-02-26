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
                
        // Dessine bord haut
        for( int i=0; i<30; i++ )
            this.laScene.ajoute( new AcBordHaut( 30+i*32, 10 ));
        
        // Dessine bords latéraux
        for( int i=0; i<20; i++ )
        {
            this.laScene.ajoute( new AcBordGauche( 0, 40+i*32 ));
            this.laScene.ajoute( new AcBordDroit( 28+30*32, 40+i*32 ));
        }
        
        // Balle
        AcBalle balle = new AcBalle( 100, 500, 3, -2, 0, 0 ) ;
        this.laScene.ajoute( balle );
        
        AcBordHaut bh = new AcBordHaut( 30, 10 ) ;
        AcBordGauche bg = new AcBordGauche( 30, 10 ) ;
        
        CollisionManager mgr = new CollisionManager( Acteur.class, AcBordHaut.class, CollisionManager.ParLeBas ) ;
                        
        if( mgr.canManageCollision(balle, bh, CollisionManager.ParLeBas ) )
        {
            System.out.println( "Collision ok" ) ;
        }
        
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
