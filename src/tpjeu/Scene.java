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
        this.hittingManagers = new ArrayList<HittingManager>() ;
    }
    
    public void ajoute( Acteur unActeur )
    {
        this.acteurs.add( unActeur ) ;
    }
    
    public void ajoute( HittingManager cm )
    {
        this.hittingManagers.add( cm ) ;
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

    public boolean onMouseMoved( int x, int y )
    {
        boolean changed = false ;
        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        while( i.hasNext() ) if( i.next().onMouseMoved( this, x, y ) ) changed = true ;
        return changed ;
    }
    
    public ArrayList<Acteur> whoIsHittingBy( Acteur unActeur )
    {
        ArrayList<Acteur> cibles = new ArrayList<Acteur>() ;

        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        while( i.hasNext() )
        {
            Acteur cible = i.next() ;
            
            if( cible != unActeur )
            {
                if( unActeur.isHitting( cible ) )
                {
                    cibles.add( cible ) ;
                }
            }
        }
        return cibles ;
    }
    
    
    public boolean manageHitting( Acteur acteurMobile, Acteur acteurCible, int hittingType, int cibleNum )
    {
        boolean acteurMobileKilled = false ; 
        ListIterator<HittingManager> i = this.hittingManagers.listIterator() ;

        while( i.hasNext() ) 
        {
            HittingManager cm = i.next() ;

            if( cm.canManageHitting( acteurMobile, acteurCible, hittingType ) )
            {
                switch( hittingType )
                {
                    case HittingManager.ByLeft:
                        if( cm.manageHittingByLeft( this, acteurMobile, acteurCible, cibleNum ) ) 
                            acteurMobileKilled = true ;
                        break ;
                    case HittingManager.ByRight:
                        if( cm.manageHittingByRight(this, acteurMobile, acteurCible, cibleNum ) )
                            acteurMobileKilled = true ;
                        break ;
                    case HittingManager.ByTop:
                        if( cm.manageHittingByTop(this, acteurMobile, acteurCible, cibleNum ) )
                            acteurMobileKilled = true ;
                        break ;
                    case HittingManager.ByBottom:
                        if( cm.manageHittingByBottom(this, acteurMobile, acteurCible, cibleNum ) )
                            acteurMobileKilled = true ;
                        break ;
                }
                //if( cm.stop ) return ;
            }
        }
        return acteurMobileKilled ;
    }
    
    
    protected LinkedList<Acteur> acteurs ;
    protected ArrayList<HittingManager> hittingManagers ;
}
