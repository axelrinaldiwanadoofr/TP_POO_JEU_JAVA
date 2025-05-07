/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver ;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author axel
 */
public class Acteur 
{
    public Acteur()
    {
        this.x = 0.0f ;
        this.y = 0.0f ;
        this.width = 32.0f ;
        this.height = 32.0f ;
        this.image = null ;
    }
    
    public Acteur( float x, float y )
    {
        this.x = x ;
        this.y = y ;
        this.width = 32.0f ;
        this.height = 32.0f ;
        this.image = null ;
    }

    public Acteur( float x, float y, float width, float height )
    {
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;
        this.image = null ;
    }
    
    public void setImage( BufferedImage image )
    {
        if( image != null )
        {
            this.width = image.getWidth() ;
            this.height = image.getHeight() ;
            this.image = image ;
        }
    }
    
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        if( this.image != null )
        {
            g2d.drawImage( this.image, (int)this.x, (int)this.y, observer) ;        
        }
    }
    
    public boolean onTimer( Scene laScene )
    {
        return false ;
    }
    
    public boolean moveTo( Scene laScene, float x, float y )
    {
        if( this.x != x || this.y != y )
        {
            this.x = x ;
            this.y = y ;
            return true ;
        }
        return false ;
    }
    
    public float getX() 
    {
        return this.x ;
    }

    public float getY() 
    {
        return this.y ;
    }
    
    public float getWidth()
    {
        return this.width ;
    }
    
    public void setWidth( float w )
    {
        this.width = w ;
    }

    public float getHeight()
    {
        return this.height ;
    }

    public void setHeight( float h )
    {
        this.height = h ;
    }
    
    boolean collideWith(Acteur cible){
        if (this.x + this.width < cible.x) return false;
        if (this.y + this.height < cible.y) return false;
        if (this.x > cible.x + cible.width) return false;
        if (this.y > cible.y + cible.height) return false;
        
        return true;
    }
        
    public static BufferedImage loadImage( BufferedImage image, String filePath )
    {
        if( image == null )
        {
            // Charge une image
            File fImage = new File( filePath ) ;
            
            try
            {
                return ImageIO.read( fImage );      
            }
            catch( IOException error )
            {
                System.out.println( "Acteur.loadImage: L'image ne peut être chargée: " + error.getMessage() + " -- " + fImage.getPath() );
                return null ;
            }
        }
        else return image ;
    }
    
        
    protected float x ;
    protected float y ;
    protected float width ;
    protected float height ;
    protected BufferedImage image ;
}
