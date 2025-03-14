/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */
public class HmRebond extends HittingManager 
{
    HmRebond( Class acMobileClass, Class acCibleClass, int hittingType )
    {
        super( acMobileClass, acCibleClass, hittingType ) ;
    }
    
    @Override
    public boolean manageHittingByTop( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVy( -acm.getVy() ) ;
        }
        return false ;
    }

    @Override
    public boolean manageHittingByBottom( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVy( -acm.getVy() ) ;
        }        
        return false ;
    }

    @Override
    public boolean manageHittingByLeft( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVx( -acm.getVx() ) ;
        }
        return false ;
    }

    @Override
    public boolean manageHittingByRight( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVx( -acm.getVx() ) ;
        }        
        return false ;
    }
}
