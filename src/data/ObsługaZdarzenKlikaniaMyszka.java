/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import app.MojaGra;
import data.Punkty;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 *
 * @author Mati
 */
public class ObsługaZdarzenKlikaniaMyszka  implements  MouseListener{
   private Układanie ułożenie;
    public Układanie getMatrix() {
        return ułożenie;
    }
     @Override
    public void mousePressed(MouseEvent me) {
    }
    public void setMatrix(Układanie matrix) {
        this.ułożenie = matrix;
    }
    @Override
    public void mouseClicked(MouseEvent me) {
    }
    @Override
    public void mouseReleased(MouseEvent me) {
    Punkty p= new Punkty();
    int a=me.getX();
    int b=me.getY();
    if(ułożenie.LiczWynik(b,a) &&  ułożenie.JakiKolor(b, a)){
    ułożenie.punkty.add(new Punkty(a, b));
    }
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mouseExited(MouseEvent me) {
    }
}