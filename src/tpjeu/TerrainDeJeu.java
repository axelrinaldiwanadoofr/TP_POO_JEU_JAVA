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


import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author axel
 */
public class TerrainDeJeu extends JPanel implements MouseMotionListener 
{
    public TerrainDeJeu()
    {
        super() ;
        
        Acteur a = new Acteur() ;
        
        System.out.println( "width: " + a.width );
        
        System.out.println( "x: " + a.getX() );
        
        
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
        AcBalle balle = new AcBalle( 700, 700, 6, -4, 0, 0 ) ;
        this.laScene.ajoute( balle );
        
        // Raquette
        AcRaquette raquette = new AcRaquette( 28+15*32, 20*32 ) ;
        raquette.setMoveOnX( 30, 28+30*32-raquette.getWidth() ) ;
        raquette.setMoveOnY( 20*32-60, 20*32 );
        this.laScene.ajoute( raquette );
        
        this.laScene.ajoute( new HmRebond( AcBalle.class, AcBordHaut.class, HittingManager.ByBottom ));
        this.laScene.ajoute( new HmRebond( AcBalle.class, AcBordGauche.class, HittingManager.ByRight ));
        this.laScene.ajoute( new HmRebond( AcBalle.class, AcBordDroit.class, HittingManager.ByLeft ));
        this.laScene.ajoute( new HmRebond( AcBalle.class, AcRaquette.class, 
                HittingManager.ByLeft | HittingManager.ByTop | HittingManager.ByRight ));
                
        this.timer = new Timer() ;
        this.tache = new JeuTachePrincipale( this ) ;
        
        this.timer.schedule( this.tache, 10, 20 );
        
        addMouseMotionListener( this ) ;        
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
        
        /*
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.RED);
        //g2d.drawLine(10, 10, 300, 100);
        //g2d.drawRect( 100, 100, 100, 50 ) ;


        g2d.translate(50, 200);
        g2d.rotate(Math.toRadians(30), getWidth() / 2.0, getHeight() / 2.0);
        g2d.clip(new Rectangle(-110, 110, 80, 110));
        g2d.fill(new Rectangle(-100, 100, 100, 100));
        */
        
        
    }   
    
    public void mouseMoved( MouseEvent e )
    {
        if( this.laScene.onMouseMoved( e.getX(), e.getY() ) )
            this.repaint() ;
    }

    public void mouseDragged( MouseEvent e )
    {
        
    }
    
    protected Scene laScene ;
    
    protected Timer timer ;
    protected JeuTachePrincipale tache ;
}
