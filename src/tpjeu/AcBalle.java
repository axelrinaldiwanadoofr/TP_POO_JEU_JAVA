/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;
import java.awt.image.BufferedImage ;
import java.util.ArrayList ;

/**
 *
 * @author axel
 */
public class AcBalle extends AcPhysique 
{
    public AcBalle( float x, float y, float vx, float vy, float ax, float ay )
    {
        super( x, y, vx, vy, ax, ay ) ;
        
        AcBalle.image = Acteur.loadImage( AcBalle.image, "images/balleRouge.png" ) ;
        this.setImage( image ) ;
    }
    
    @Override
    public boolean onTimer( Scene laScene )
    {
        super.onTimer( laScene ) ;
     
        ArrayList<Acteur> list = laScene.whichCollideWith(this) ;
        
        if( !list.isEmpty() )
        {
            System.out.println( "collision" );
        }
                
        
        return true ;
    }
        
    protected static BufferedImage image ; 
}
