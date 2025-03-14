/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */
public class GaScFcCasseBrique extends GameSceneryFactory
{
    public GaScFcCasseBrique()
    {
        
    }
    
    public void buildGameScenary( Scene laScene )
    {
        // Dessine bord haut
        for( int i=0; i<30; i++ )
            laScene.ajoute( new AcBordHaut( 30+i*32, 10 ));
        
        // Dessine bords latéraux
        for( int i=0; i<20; i++ )
        {
            laScene.ajoute( new AcBordGauche( 0, 40+i*32 ));
            laScene.ajoute( new AcBordDroit( 28+30*32, 40+i*32 ));
        }
        
        // Balle
        AcBalle balle = new AcBalle( 700, 700, 6, -4, 0, 0 ) ;
        laScene.ajoute( balle );
        
        // Raquette
        AcRaquette raquette = new AcRaquette( 28+15*32, 20*32 ) ;
        raquette.setMoveOnX( 30, 28+30*32-raquette.getWidth() ) ;
        raquette.setMoveOnY( 20*32-60, 20*32 );
        laScene.ajoute( raquette );
        
        laScene.ajoute( new HmRebond( AcBalle.class, AcBordHaut.class, HittingManager.ByBottom ));
        laScene.ajoute( new HmRebond( AcBalle.class, AcBordGauche.class, HittingManager.ByRight ));
        laScene.ajoute( new HmRebond( AcBalle.class, AcBordDroit.class, HittingManager.ByLeft ));
        laScene.ajoute( new HmRebond( AcBalle.class, AcRaquette.class, 
                HittingManager.ByLeft | HittingManager.ByTop | HittingManager.ByRight ));
        
    }
    
}
