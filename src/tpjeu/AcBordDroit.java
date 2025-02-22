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
public class AcBordDroit extends Acteur 
{
    public AcBordDroit( float x, float y )
    {
        super( x, y ) ;
        if( AcBordDroit.image == null ) 
        {
            AcBordDroit.image = Acteur.loadImage( "/media/axel/Data/java/TpJeu/images/bordright.png" ) ;
        }
        if( AcBordDroit.image != null )
        {
            this.width = (float)AcBordDroit.image.getWidth() ;
            this.height = (float)AcBordDroit.image.getHeight() ;
        }
    }
    
    @Override
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        g2d.drawImage(AcBordDroit.image, (int)this.x, (int)this.y, observer ) ;
    }
    
    static BufferedImage image = null ;
}
