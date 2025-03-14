/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.util.ArrayList;
import java.util.Iterator ;

/**
 *
 * @author axel
 */
public class AcPhysique extends Acteur 
{
    public AcPhysique( float x, float y, float vx, float vy, float ax, float ay )
    {
        super( x, y ) ;
        this.vx = vx ;
        this.vy = vy ;
        this.ax = ax ;
        this.ay = ay ;
    }

    public AcPhysique( float x, float y, float width, float height, float vx, float vy, float ax, float ay )
    {
        super( x, y, width, height ) ;
        this.vx = vx ;
        this.vy = vy ;
        this.ax = ax ;
        this.ay = ay ;
    }
    
    public float getVx()
    {
        return this.vx ;
    }

    public float getVy()
    {
        return this.vy ;
    }
    
    public void setVx( float v )
    {
        this.vx = v ;
    }

    public void setVy( float v )
    {
        this.vy = v ;
    }
    
    @Override
    public boolean onTimer( Scene laScene )
    {
        boolean changed = false ;
        boolean acteurKilled = false ;
        
        if( this.vx != 0.0f || this.vy != 0.0f )
        {            
            // Test de collision sur un déplacement horizontal
            this.x += this.vx ;
            ArrayList<Acteur> cibles = laScene.whoIsHittingBy( this ) ;
            this.x -= this.vx ;

            // Traiter la ou les collisions éventuelles
            if( !cibles.isEmpty() )
            {
                int cibleNum = 1 ;

                Iterator<Acteur> i = cibles.iterator() ;
                while( i.hasNext() ) 
                {
                    Acteur cible = i.next() ;

                    if( cible.x > this.x )
                    {                    
                        acteurKilled = laScene.manageHitting( this, cible, HittingManager.ByLeft, cibleNum ) ;
                    }
                    else
                    {
                        acteurKilled = laScene.manageHitting( this, cible, HittingManager.ByRight, cibleNum ) ;
                    }
                    cibleNum++ ;
                }
            }

            // Test de collision sur un déplacement vertical
            this.y += this.vy ;
            cibles = laScene.whoIsHittingBy( this ) ;
            this.y -= this.vy ;

            // Traiter la ou les collisions éventuelles
            if( !cibles.isEmpty() )
            {
                int cibleNum = 1 ;

                Iterator<Acteur> i = cibles.iterator() ;
                while( i.hasNext() ) 
                {
                    Acteur cible = i.next() ;

                    if( cible.y > this.y )
                    {                    
                        acteurKilled = laScene.manageHitting( this, cible, HittingManager.ByTop, cibleNum ) ;
                    }
                    else
                    {
                        acteurKilled = laScene.manageHitting( this, cible, HittingManager.ByBottom, cibleNum ) ;
                    }
                    cibleNum++ ;
                }
            }
            
            if( ! acteurKilled )
            {
                float x = this.getX() + this.vx ;
                float y = this.getY() + this.vy ;
                this.moveTo( laScene, x, y ) ;
                changed = true ;
            }
        }
        
        this.vx += this.ax ;
        this.vy += this.ay ;
        return changed ;
    }
    
    protected float vx ;
    protected float vy ;
    protected float ax ;
    protected float ay ;   
}
