/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.LinkedList ;
import java.util.ListIterator ;

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
        
    public void onDraw( Graphics2D g2d, ImageObserver observer  )
    {
        ListIterator<Acteur> i = this.acteurs.listIterator() ;
        
        while( i.hasNext() ) i.next().onDraw( g2d, observer ) ;
    }

    protected LinkedList<Acteur> acteurs ;
}
