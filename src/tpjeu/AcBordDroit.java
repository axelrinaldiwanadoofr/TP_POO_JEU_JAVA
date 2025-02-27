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
public class AcBordDroit extends Acteur 
{
    public AcBordDroit( float x, float y )
    {
        super( x, y ) ;        
        AcBordDroit.image = DoDrawImage.loadImage( AcBordDroit.image, "/media/axel/Data/java/TpJeu/images/bordright.png") ;
        this.doOnDraw = new DoDrawImage( this, AcBordDroit.image ) ;
    }
        
    static BufferedImage image = null ;
}
