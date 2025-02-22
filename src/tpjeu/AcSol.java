/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.image.BufferedImage ;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;


/**
 *
 * @author axel
 */
public class AcSol extends Acteur 
{
    public AcSol( float x, float y )
    {
        super( x, y ) ;
        if( AcSol.image == null ) 
        {
            AcSol.image = Acteur.loadImage( "/media/axel/Data/java/TpJeu/images/sol.png" ) ;
        }
        if( AcSol.image != null )
        {
            this.width = (float)AcSol.image.getWidth() ;
            this.height = (float)AcSol.image.getHeight() ;
        }
    }
    
    @Override
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        g2d.drawImage( AcSol.image, (int)this.x, (int)this.y, observer ) ;
    }
    
    static BufferedImage image = null ;
}
