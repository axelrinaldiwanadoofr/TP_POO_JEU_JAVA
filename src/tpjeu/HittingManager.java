/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */


public class HittingManager 
{
    
    public HittingManager( Class acteurMobileClass, Class acteurCibleClass, int collisionType )
    {
        this.acteurMobileClass = acteurMobileClass ;
        this.acteurCibleClass = acteurCibleClass ;
        this.collisionType = collisionType ;
    }
    
    public boolean canManageCollision( Acteur acteurMobile, Acteur acteurCible, int collisionType )
    {
        if( !isSuperClassOf( acteurMobile.getClass(), this.acteurMobileClass) ) return false ;
        if( !isSuperClassOf( acteurCible.getClass(), this.acteurCibleClass) ) return false ;
        int v = collisionType & this.collisionType ;
        if( v > 0 ) return true ;
        return false ;
    }
    
    public void manageCollisionByTop( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        
    }

    public void manageCollisionByBottom( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        
    }

    public void manageCollisionByLeft( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        
    }

    public void manageCollisionByRight( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        
    }
    
    static public boolean isSuperClassOf( Class classe, Class parent )
    {
        if( classe == null ) return false ;
        if( parent == classe ) return true ;
        return HittingManager.isSuperClassOf(classe.getSuperclass(), parent) ;
    }
    
    protected Class acteurMobileClass ;
    protected Class acteurCibleClass ;
    protected int collisionType ;
    
    final static public int ByTop = 0x01 ;
    final static public int ByBottom = 0x02 ;
    final static public int ByLeft = 0x04 ;
    final static public int ByRight = 0x08 ;
}
