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
public class AcRaquette extends AcMouseMoved 
{
    public AcRaquette( float x, float y )
    {
        super( x, y ) ;
        AcRaquette.image = Acteur.loadImage(AcRaquette.image, "/media/axel/Data/java/TpJeu/images/raquette.png") ;
        this.setImage(image);
    }
    
    static protected BufferedImage image ;
}
