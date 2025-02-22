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
public class AcBalle extends AcPhysique 
{
    public AcBalle( float x, float y, float vx, float vy, float ax, float ay )
    {
        super( x, y, vx, vy, ax, ay ) ;
        
        if( AcBalle.image == null ) 
        {
            AcBalle.image = Acteur.loadImage( "/media/axel/Data/java/TpJeu/images/balleRouge.png" ) ;
        }
        if( AcBalle.image != null )
        {
            this.width = (float)AcBalle.image.getWidth() ;
            this.height = (float)AcBalle.image.getHeight() ;
        }
    }
    
    @Override
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        g2d.drawImage( AcBalle.image, (int)this.x, (int)this.y, observer ) ;
    }
    
    
    protected static BufferedImage image ; 
}
