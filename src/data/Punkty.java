/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.awt.Point;
/**
 *
 * @author Mati
 */
public class Punkty {
    int a;
    int b;
    public Punkty() {
    int a=0;
    int b=0;
    }
    public Punkty(int a, int b) {
        this.a = a;
        this.b = b;
    }
       public Punkty(Punkty p) {
        this.a = p.a;
        this.b = p.b;
    }
    public int getX() {
        return a;
    }
    public void setX(int a) {
        this.a = a;
    }
    public int getY() {
        return b;
    }
    public void setY(int y) {
        this.b = b;
    }
}
