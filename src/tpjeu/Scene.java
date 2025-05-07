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
        this.collideManagers = new ArrayList<CollideManager>() ;
    }
    
    public void ajoute( Acteur unActeur )
    {
        this.acteurs.add( unActeur ) ;
    }
    
    public void remove( Acteur unActeur )
    {
        int index = this.acteurs.indexOf( unActeur ) ;
        if( index >= 0 ) this.acteurs.remove(index) ;
    }
    
    public void ajoute( CollideManager cm )
    {
        this.collideManagers.add( cm ) ;
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
    
    public ArrayList<Acteur> whichCollideWith( Acteur unActeur )
    {
        ArrayList<Acteur> liste = new ArrayList<Acteur>();
        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        while( i.hasNext() )
        {
            Acteur cible = i.next() ;
            
            if(cible.collideWith(unActeur) && unActeur != cible)
            {
                liste.add( cible );
            }
        }
        return liste;
    }
    
    public boolean manageCollide( Acteur mobile, ArrayList<Acteur> cibles, int collideType )
    {
        // On parcours tous acteurs qui ont été collisionnés
        int numCible = 0 ;
        ListIterator<Acteur> i = cibles.listIterator() ;
        while( i.hasNext() )
        {
            Acteur cible = i.next() ;
            
            // On recherche le gestionnaire de collision capable de traiter la collision
            ListIterator<CollideManager> cmi = this.collideManagers.listIterator() ;
            while( cmi.hasNext() )
            {
                CollideManager cm = cmi.next() ;
                
                // On vérifie que le gestionnaire de collision est capable de gérer la collision
                if( cm.canManageCollide(mobile, cible, collideType) )
                {
                    switch( collideType )
                    {
                        case CollideManager.ByLeft -> {
                            return cm.manageCollideByLeft(this, mobile, cible, numCible) ;
                        }
                        case CollideManager.ByRight -> {
                            return cm.manageCollideByRight(this, mobile, cible, numCible) ;
                        }
                        case CollideManager.ByTop -> {
                            return cm.manageCollideByTop(this, mobile, cible, numCible) ;
                        }
                        case CollideManager.ByBottom -> {
                            return cm.manageCollideByBottom(this, mobile, cible, numCible) ;
                        }
                    }
                }
            }
            numCible++ ;
        }
        return false ;
    }        
    
    protected LinkedList<Acteur> acteurs ;
    protected ArrayList<CollideManager> collideManagers ;
}
