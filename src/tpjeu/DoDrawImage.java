/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;
import java.awt.image.BufferedImage ;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author axel
 */
public class DoDrawImage implements OnDrawActeur 
{
    public DoDrawImage( Acteur acteur, BufferedImage image )
    {
        this.image = image ;
        acteur.setWidth( image.getWidth() );
        acteur.setHeight( image.getHeight() );
    }
    
    public void onDraw( Graphics2D g, Acteur acteur, ImageObserver observer )
    {
        g.drawImage( this.image, (int)acteur.getX(), (int)acteur.getY(), observer) ;
    }
    
    public static BufferedImage loadImagei( BufferedImage image, String filePath )
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
                System.out.println( "L'image ne peut être chargée: " + error.getMessage() + " -- " + fImage.getPath() );
                return null ;
            }
        }
        else return image ;
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
            System.out.println( "L'image ne peut être chargée: " + error.getMessage() + " -- " + fImage.getPath() );
            return null ;
        }
    }
    
    
    private BufferedImage image ;
}
