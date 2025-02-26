/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */


public class CollisionManager 
{
    
    public CollisionManager( Class acteurMobileClass, Class acteurCibleClass, int collisionType )
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
    
    static public boolean isSuperClassOf( Class classe, Class parent )
    {
        if( classe == null ) return false ;
        if( parent == classe ) return true ;
        return CollisionManager.isSuperClassOf(classe.getSuperclass(), parent) ;
    }
    
    protected Class acteurMobileClass ;
    protected Class acteurCibleClass ;
    protected int collisionType ;
    
    static public int ParLeHaut = 0x01 ;
    static public int ParLeBas = 0x02 ;
    static public int ParLaGauche = 0x04 ;
    static public int ParLaDroite = 0x08 ;
}
