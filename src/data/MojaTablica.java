/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import data.Punkty;
import app.MojaGra;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Mati
 */
public class MojaTablica  extends Układanie {
    public MojaTablica (int wiersz, int kolumny) {
        if (wiersz <= 0 || wiersz <= 0) {
            throw new IllegalArgumentException("Nie te wymiary!!!");
        }
        tab = new int[wiersz][wiersz];
        punkty = new ArrayList<>();
    }
    public void MechanizmPrzywracania() {
        MojaGra.pusteprzyciski = 0;
        int wylosowana = 0;
       ArrayList<Punkty> wylosowane= new ArrayList<>();
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                if (getElement(i, j) == 0) {
                    MojaGra.pusteprzyciski++;
                    wylosowane.add(new Punkty(j, i));
                }
            }
        }
    }
   public Color GetColor(){
   Color color=null;
         switch (getElement(punkty.get(0).getY()/MojaGra.size, punkty.get(0).getX()/MojaGra.size)) {
                    case 0:
                        color=Color.WHITE;
                        break;
                    case 1:
                        color=Color.ORANGE;
                        break;
                    case 2:
                     color=Color.BLACK;
                        break;
                    case 3:
                        color=Color.GREEN;
                        break;
                    case 4:
                        color=Color.MAGENTA;
                        break;
                    case 5:
                        color=Color.YELLOW;
                        break;
   }
         return color;
   } 
    public void Skasuj() {
        for (int z = punkty.size() - 1; z > 0; z--) {
            setElement(punkty.get(z).getY() / 30,
                    punkty.get(z).getX() / 30, 0);
            punkty.remove(z);
            if (z == 1) {
                punkty.remove(0);
            }
        }
    }
    public int randomElement(int from, int to) {
        Random rand = new Random();
        int liczba = (rand.nextInt(Integer.MAX_VALUE)) % (to - from + 1) + from;
        return liczba;
    }
    public void randomElements() {
        randomElements(1, 5);
    }
    public void randomElements(int from, int to) {
        Random rand = new Random();
        for (int i = 0, n = getRowCount(); i < n; i++) {
            for (int j = 0, m = getColCount(); j < m; j++) {
                tab[i][j] = (rand.nextInt(Integer.MAX_VALUE)) % (to - from + 1) + from;
            }
        }
    }
}
