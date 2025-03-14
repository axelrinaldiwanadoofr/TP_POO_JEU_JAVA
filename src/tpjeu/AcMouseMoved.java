package tpjeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author axel
 */
public class AcMouseMoved extends Acteur 
{
    public AcMouseMoved( float x, float y )
    {
        super( x , y ) ;
        
        this.vx = 0.0f ;
        this.vy = 0.0f ;
        this.xMin = x ;
        this.xMax = x ;
        this.yMin = y ;
        this.yMax = y ;
    }
    
    public void setMoveOnX( float xMin, float xMax )
    {
        this.xMin = xMin ;
        this.xMax = xMax ;
    }

    public void setMoveOnY( float yMin, float yMax )
    {
        this.yMin = yMin ;
        this.yMax = yMax ;
    }
    
    public float getVx()
    {
        return vx ;
    }
    
    public float getVy()
    {
        return vy ;
    }
    
    public boolean onMouseMoved( Scene laScene, float x, float y )
    {
        if( x > this.xMax || x < this.xMin ) x = this.x ;
        if( y > this.yMax || y < this.yMin ) y = this.y ;
        return this.moveTo( laScene, x, y ) ;        
    }
    
    @Override
    public boolean moveTo( Scene laScene, float x, float y )
    {
        this.vx = x - this.x ;
        this.vy = y - this.y ;
        System.out.println( "v: " + this.vx + " " + this.vy );
        return super.moveTo( laScene, x, y) ;
    }
    
    protected float vx ;
    protected float vy ;
    
    protected float xMin ;
    protected float xMax ;
    protected float yMin ;
    protected float yMax ;
}
