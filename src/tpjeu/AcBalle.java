/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;
import java.awt.image.BufferedImage ;

/**
 *
 * @author axel
 */
public class AcBalle extends AcPhysique 
{
    public AcBalle( float x, float y, float vx, float vy, float ax, float ay )
    {
        super( x, y, vx, vy, ax, ay ) ;
        
        AcBalle.image = DoDrawImage.loadImage( AcBalle.image, "/media/axel/Data/java/TpJeu/images/balleRouge.png" ) ;        
        this.doOnDraw = new DoDrawImage( this, AcBalle.image ) ;
    }
        
    protected static BufferedImage image ; 
}
