/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.util.ArrayList ;

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
    
    @Override
    public boolean onTimer( Scene laScene )
    {
        boolean changed = false ;
        boolean isDestroyed = false ;
        
        if( this.vx != 0.0f || this.vy != 0.0f )
        {            
            float x = this.x + this.vx ;
            this.moveTo( laScene, x, this.y ) ;
            ArrayList<Acteur> cibles = laScene.whichCollideWith(this) ;   
            if( !cibles.isEmpty() )
            {
                if( this.vx > 0 )
                {
                    // Collision par la gauche
                    isDestroyed = laScene.manageCollide(this, cibles, CollideManager.ByLeft ) ;  
                }
                else
                {
                    // Collision par la droite
                    isDestroyed = laScene.manageCollide(this, cibles, CollideManager.ByRight ) ;  
                }
            }
            
            float y = this.y + this.vy ;
            this.moveTo( laScene, this.x, y ) ;          
            cibles = laScene.whichCollideWith(this) ;       
            if( !cibles.isEmpty() )
            {
                if( this.vy > 0 )
                {
                    // Collision par le haut
                    isDestroyed = laScene.manageCollide(this, cibles, CollideManager.ByTop ) ;  
                }
                else
                {
                    // Collision par le bas
                    isDestroyed = laScene.manageCollide(this, cibles, CollideManager.ByBottom ) ;  
                }
            }
            
            changed = true ;
        }
        
        if( !isDestroyed )
        {
            this.vx += this.ax ;
            this.vy += this.ay ;
        }
        return changed ;
    }

    protected float vx ;
    protected float vy ;
    protected float ax ;
    protected float ay ;       
}
