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
public class AcBordHaut extends Acteur 
{
    public AcBordHaut( float x, float y )
    {
        super( x, y ) ;
        if( AcBordHaut.image == null ) 
        {
            AcBordHaut.image = Acteur.loadImage( "/media/axel/Data/java/TpJeu/images/bordtop.png" ) ;
        }
        if( AcBordHaut.image != null )
        {
            this.width = (float)AcBordHaut.image.getWidth() ;
            this.height = (float)AcBordHaut.image.getHeight() ;
        }
    }
    
    @Override
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        g2d.drawImage(AcBordHaut.image, (int)this.x, (int)this.y, observer ) ;
    }
    
    static BufferedImage image = null ;
}
