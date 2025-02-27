/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.LinkedList ;
import java.util.ListIterator ;
import java.util.ArrayList ;

/**
 *
 * @author axel
 */
public class Scene 
{
    public Scene()
    {
        this.acteurs = new LinkedList<Acteur>() ;
    }
    
    public void ajoute( Acteur unActeur )
    {
        this.acteurs.add( unActeur ) ;
    }
    
    public void ajoute( CollisionManager cm )
    {
        this.collisionManagers.add( cm ) ;
    }
    
    public void onDraw( Graphics2D g2d, ImageObserver observer  )
    {
        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        while( i.hasNext() ) i.next().onDraw( g2d, observer ) ;
    }

    public boolean onTimer()
    {
        boolean changed = false ;
        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        while( i.hasNext() ) if( i.next().onTimer( this ) ) changed = true ;
        return changed ;
    }
    
    public void manageCollision( Acteur acteurMobile, Acteur acteurCible, int collisionType, int cibleNum )
    {
        ListIterator<CollisionManager> i = this.collisionManagers.listIterator() ;

        while( i.hasNext() ) 
        {
            CollisionManager cm = i.next() ;

            if( cm.canManageCollision( acteurMobile, acteurCible, collisionType ) )
            {
                switch( collisionType )
                {
                    case CollisionManager.ByLeft:
                        cm.manageCollisionByLeft( this, acteurMobile, acteurCible, cibleNum ) ;
                        break ;
                    case CollisionManager.ByRight:
                        cm.manageCollisionByRight( this, acteurMobile, acteurCible, cibleNum ) ;
                        break ;
                    case CollisionManager.ByTop:
                        cm.manageCollisionByTop( this, acteurMobile, acteurCible, cibleNum ) ;
                        break ;
                    case CollisionManager.ByBottom:
                        cm.manageCollisionByBottom( this, acteurMobile, acteurCible, cibleNum ) ;
                        break ;
                }
                //if( cm.stop ) return ;
            }
        }
    }
    
    
    protected LinkedList<Acteur> acteurs ;
    protected ArrayList<CollisionManager> collisionManagers ;
}
