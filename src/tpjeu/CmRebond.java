/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */
public class CmRebond extends HittingManager 
{
    CmRebond( Class acMobileClass, Class acCibleClass, int collisionType )
    {
        super( acMobileClass, acCibleClass, collisionType ) ;
    }
    
    @Override
    public void manageCollisionByTop( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVy( -acm.getVy() ) ;
        }
    }

    @Override
    public void manageCollisionByBottom( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVy( -acm.getVy() ) ;
        }        
    }

    @Override
    public void manageCollisionByLeft( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVx( -acm.getVx() ) ;
        }
    }

    @Override
    public void manageCollisionByRight( Scene laScene, Acteur acMobile, Acteur acCible, int numCible )
    {
        if( acMobile instanceof AcPhysique )
        {
            AcPhysique acm = (AcPhysique)acMobile ;       
            if( numCible == 1 ) acm.setVx( -acm.getVx() ) ;
        }        
    }
}
