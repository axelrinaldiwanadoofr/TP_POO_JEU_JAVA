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
public class AcSol extends Acteur 
{
    public AcSol( float x, float y )
    {
        super( x, y ) ;        
        AcSol.image = Acteur.loadImage( AcSol.image, "/media/axel/Data/java/TpJeu/images/sol.png") ;
        this.setImage(image);
    }
        
    static BufferedImage image = null ;
}
