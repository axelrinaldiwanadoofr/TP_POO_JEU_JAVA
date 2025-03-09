/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpjeu;
import java.awt.Graphics2D ;
import java.awt.image.ImageObserver;

/**
 *
 * @author axel
 */
public interface OnDrawActeur 
{
    public abstract void onDraw( Graphics2D g, Acteur acteur, ImageObserver observer ) ;
}
