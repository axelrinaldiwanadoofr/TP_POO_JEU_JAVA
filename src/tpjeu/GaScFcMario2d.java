/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpjeu;

/**
 *
 * @author axel
 */
public class GaScFcMario2d extends GameSceneryFactory 
{
    public GaScFcMario2d()
    {
        
    }
    
    @Override
    public void buildGameScenery( Scene laScene )
    {
        float yO = 600.0f ;
        float xO = 20.0f ;
        
        // Crée des sols
        for( int i=0; i<20; i++ )
        {
            laScene.ajoute( new AcSol( xO+i*32, yO ));
            laScene.ajoute( new AcSol( xO+10*32+i*32, yO-4*32 ));
        }

        // Crée un mur
        laScene.ajoute( new AcMur( xO+3*32, yO-32 ));
        laScene.ajoute( new AcMur( xO+3*32, yO-32*2 ));

        // Crée un autre mur
        laScene.ajoute( new AcMur( xO+13*32, yO-5*32 ));
        laScene.ajoute( new AcMur( xO+13*32, yO-6*32 ));
    }
}
