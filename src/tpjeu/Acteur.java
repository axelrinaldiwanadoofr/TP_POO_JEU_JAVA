/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.Graphics2D;
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
        this.doOnDraw = new DoDrawRectangle() ;
    }

    public Acteur( float x, float y, float width, float height )
    {
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;
        this.doOnDraw = new DoDrawRectangle() ;
    }
    
    public void onDraw( Graphics2D g2d, ImageObserver observer )
    {
        this.doOnDraw.onDraw( g2d, this, observer ) ;
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
    
    public boolean isCollisionning( Acteur target )
    {
        if( target.x < this.x ) return false ;
        if( target.x > this.x + this.width ) return false ;
        if( target.y < this.y ) return false ;
        if( target.y > this.y + this.height ) return false ;
        return true ;
    }
        
    protected float x ;
    protected float y ;
    protected float width ;
    protected float height ;
    protected OnDrawActeur doOnDraw ;
}
