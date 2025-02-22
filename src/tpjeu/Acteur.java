/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage ;
import java.awt.image.ImageObserver ;


/**
 *
 * @author axel
 */
public class Acteur 
{
    public Acteur( float x, float y )
    {
        this.x = x ;
        this.y = y ;
        this.width = 32.0f ;
        this.height = 32.0f ;
    }

    public Acteur( float x, float y, float width, float height )
    {
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;
    }
    
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        
    }
    
    public boolean onTimer( Scene laScene )
    {
        return false ;
    }
    
    public void moveTo( float x, float y )
    {
        this.x = x ;
        this.y = y ;
    }
    
    public boolean isCollisionning( Acteur target )
    {
        if( target.x < this.x ) return false ;
        if( target.x > this.x + this.width ) return false ;
        if( target.y < this.y ) return false ;
        if( target.y > this.y + this.height ) return false ;
        return true ;
    }
    
    public static BufferedImage loadImage( String filePath )
    {
        // Charge une image
        File fImage = new File( filePath ) ;
        try
        {
            return ImageIO.read( fImage );      
        }
        catch( IOException error )
        {
            System.out.println( "Acteur.loadImage: " + error.getMessage() + " -- " + fImage.getPath() );
            return null ;
        }
    }
    
    protected float x ;
    protected float y ;
    protected float width ;
    protected float height ;
}
