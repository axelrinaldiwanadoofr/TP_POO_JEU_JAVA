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
public class AcBordGauche extends Acteur 
{
    public AcBordGauche( float x, float y )
    {
        super( x, y ) ;        
        AcBordGauche.image = Acteur.loadImage( AcBordGauche.image, "/media/axel/Data/java/TpJeu/images/bordleft.png") ;
        this.setImage( AcBordGauche.image ) ;
    }
    
    
    static BufferedImage image = null ;
}
