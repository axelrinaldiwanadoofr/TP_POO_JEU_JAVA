/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author arinaldi7
 */
public class CollideManager 
{
    public CollideManager( int collideType )
    {
        this.collideType = collideType ;
    }
    
    // Renvoie true si le gestionnaire de collision est capable
    // de gérer la collision
    public boolean canManageCollide( Acteur mobile, Acteur cible, int collideType )
    {
        return false ;
    }
    
    public boolean manageCollideByTop( Scene laScene, Acteur mobile, Acteur cible, int numCible )
    {
        return false ;
    }

    public boolean manageCollideByLeft( Scene laScene, Acteur mobile, Acteur cible, int numCible )
    {
        return false ;
    }

    public boolean manageCollideByRight( Scene laScene, Acteur mobile, Acteur cible, int numCible )
    {
        return false ;
    }

    public boolean manageCollideByBottom( Scene laScene, Acteur mobile, Acteur cible, int numCible )
    {
        return false ;
    }
    
    protected int collideType ;
    
    final static public int ByTop = 0x01 ;
    final static public int ByBottom = 0x02 ;
    final static public int ByLeft = 0x04 ;
    final static public int ByRight = 0x08 ;
}
