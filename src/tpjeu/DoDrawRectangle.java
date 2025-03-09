/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.awt.Color ;

/**
 *
 * @author axel
 */
public class DoDrawRectangle implements OnDrawActeur 
{
    public DoDrawRectangle()
    {
        this.color = Color.BLACK ;
    }

    public DoDrawRectangle( Color color )
    {
        this.color = color ;
    }
    
    public void onDraw( Graphics2D g, Acteur acteur, ImageObserver observer )
    {
        g.setColor( this.color );
        g.drawRect( (int)acteur.getX(), (int)acteur.getY(), (int)acteur.getWidth(), (int)acteur.getHeight() );
    }    
    
    protected Color color ;
}
