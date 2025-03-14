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
    
    public HittingManager( Class acteurMobileClass, Class acteurCibleClass, int hittingType )
    {
        this.acteurMobileClass = acteurMobileClass ;
        this.acteurCibleClass = acteurCibleClass ;
        this.hittingType = hittingType ;
    }
    
    public boolean canManageHitting( Acteur acteurMobile, Acteur acteurCible, int hittingType )
    {
        if( !isSuperClassOf( acteurMobile.getClass(), this.acteurMobileClass) ) return false ;
        if( !isSuperClassOf( acteurCible.getClass(), this.acteurCibleClass) ) return false ;
        int v = hittingType & this.hittingType ;
        if( v > 0 ) return true ;
        return false ;
    }
    
    public boolean manageHittingByTop( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        return false ;
    }

    public boolean manageHittingByBottom( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        return false ;
    }

    public boolean manageHittingByLeft( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        return false ;
    }

    public boolean manageHittingByRight( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        return false ;
    }
    
    static public boolean isSuperClassOf( Class classe, Class parent )
    {
        if( classe == null ) return false ;
        if( parent == classe ) return true ;
        return HittingManager.isSuperClassOf(classe.getSuperclass(), parent) ;
    }
    
    protected Class acteurMobileClass ;
    protected Class acteurCibleClass ;
    protected int hittingType ;
    
    final static public int ByTop = 0x01 ;
    final static public int ByBottom = 0x02 ;
    final static public int ByLeft = 0x04 ;
    final static public int ByRight = 0x08 ;
}
