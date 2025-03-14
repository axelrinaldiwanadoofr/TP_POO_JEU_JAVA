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
public class AcBordHaut extends Acteur 
{
    public AcBordHaut( float x, float y )
    {
        super( x, y ) ;        
        AcBordHaut.image = Acteur.loadImage( AcBordHaut.image, "/media/axel/Data/java/TpJeu/images/bordtop.png") ;
        this.setImage( AcBordHaut.image ) ;
    }
    
    static BufferedImage image = null ;
}
