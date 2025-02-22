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
public class AcBordGauche extends Acteur 
{
    public AcBordGauche( float x, float y )
    {
        super( x, y ) ;
        if( AcBordGauche.image == null ) 
        {
            AcBordGauche.image = Acteur.loadImage( "/media/axel/Data/java/TpJeu/images/bordleft.png" ) ;
        }
        if( AcBordGauche.image != null )
        {
            this.width = (float)AcBordGauche.image.getWidth() ;
            this.height = (float)AcBordGauche.image.getHeight() ;
        }
    }
    
    @Override
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        g2d.drawImage(AcBordGauche.image, (int)this.x, (int)this.y, observer ) ;
    }
    
    static BufferedImage image = null ;
}
