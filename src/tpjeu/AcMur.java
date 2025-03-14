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
public class AcMur extends Acteur 
{
    public AcMur( float x, float y )
    {
        super( x, y ) ;        
        AcMur.image = Acteur.loadImage( AcMur.image, "/media/axel/Data/java/TpJeu/images/mur.bmp") ;
        this.setImage(image);
    }

    private static BufferedImage image ;
}
