package tpjeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package tpjeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage ;
import java.util.Timer ;
/**
 *
 * @author axel
 */
public class TerrainDeJeu extends JPanel 
{
    public TerrainDeJeu()
    {
        // Charge une image
        File fImage = new File("/media/axel/Data/java/TpJeu/images/sol.png") ;
        try
        {
            this.img = ImageIO.read( fImage );      
        }
        catch( IOException error )
        {
            System.out.println( "Erreur chargement fichier image: " + error.getMessage() + " -- " + fImage.getPath() );
        }
        
        this.x = 200 ;
        this.y = 200 ;
        
        this.timer = new Timer() ;
        this.tache = new JeuTachePrincipale( this ) ;
        
        this.timer.schedule( this.tache, 1000, 500 );
        
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setBackground( Color.WHITE ) ;
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.RED);
        g2d.drawLine(10, 10, 300, 100);
        g2d.drawRect( 100, 100, 100, 50 ) ;
        g2d.drawImage(img, this.x += 10, this.y, this);


        g2d.translate(50, 200);
        g2d.rotate(Math.toRadians(30), getWidth() / 2.0, getHeight() / 2.0);
        g2d.drawImage(img, 0, 0, this);
        g2d.clip(new Rectangle(-110, 110, 80, 110));
        g2d.fill(new Rectangle(-100, 100, 100, 100));
    }   
    
    private BufferedImage img ;
    private int x ;
    private int y ;
    
    private Timer timer ;
    private JeuTachePrincipale tache ;
}
