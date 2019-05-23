/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import app.MojaGra;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Mati 
 */
public class Układanie {
    protected int[][] tab;
    ArrayList<Punkty> punkty;
    protected Układanie() {
    }
    public int getDlugosc() {
        return punkty.size();
    }
    public ArrayList<Punkty> getPunkty() {
        return punkty;
    }
    public void setPoints(ArrayList<Punkty> points) {
        this.punkty = punkty;
    }
    public void setElement(int wiersz, int kolumna, int value) {
        Kontroluj(wiersz, kolumna);
        tab[wiersz][kolumna] = value;
    }
    public int getElement(int wiersz, int kolumna) {
        Kontroluj(wiersz, kolumna);
        return tab[wiersz][kolumna];
    }
    public boolean JakiKolor(int wiersz, int kolumna) {
        if (punkty.size() == 0) {
            if (LiczWynik(wiersz, kolumna) && getElement(wiersz / 40, kolumna / 40) != 0) {
                return true;
            }
            else if(LiczWynik(wiersz, kolumna) && getElement(wiersz / 40, kolumna / 40) == 0){
                MojaGra.error1="No jeszcze nie teraz!!!!!!!!";
                  JOptionPane.showMessageDialog(null, MojaGra.error1);
                return false;
            }
        }
        int pierwszyElementY = punkty.get(0).getY() / MojaGra.size;
        int pierwszyElementX = punkty.get(0).getX() / MojaGra.size;
        int kolor = getElement(pierwszyElementY, pierwszyElementX);
        if (punkty.size() > 0 && getElement(wiersz / MojaGra.size, kolumna / MojaGra.size) != kolor) {
            MojaGra.error1 = "Nie możesz zmieniać koloru";
              JOptionPane.showMessageDialog(null, MojaGra.error1);
            return false;
        } else if (kolor == 0 && punkty.size() > 0) {
            MojaGra.error1 = "Nie możesz wybrać koloru białego";
              JOptionPane.showMessageDialog(null, MojaGra.error1);
            return false;
        }
        return true;
    }
    public double dlugoscLamanej() {
        double suma = 0;
        double dlugoscOdcinka = 0;
        for (int i = 0; i < punkty.size(); i++) {
            if (i + 1 < punkty.size()) {
                dlugoscOdcinka = Math.sqrt( (punkty.get(i + 1).getX() - punkty.get(i).getX()) * (punkty.get(i + 1).getX() - punkty.get(i).getX())
                  + (punkty.get(i + 1).getY() - punkty.get(i).getY()) * (punkty.get(i + 1).getY() - punkty.get(i).getY()));
                suma = suma + dlugoscOdcinka;
            }
        }
        return suma;
    }
  public  void LiczWynik(){
        double vertex= dlugoscLamanej();
       int wynik= (int) (vertex / (10 * Math.pow(punkty.size()-1, 3)));
        MojaGra.iloscPunktow += wynik;
    }
    public boolean LiczWynik(int wiersz, int kolumna) {
        if (wiersz < 0 || wiersz > getRowCount() * MojaGra.size) {
            MojaGra.error1 = "Nie wychodz poza planszę!";
           JOptionPane.showMessageDialog(null, MojaGra.error1);
            return false;
        } else if (kolumna < 0 || kolumna > getColCount() * MojaGra.size) {
            MojaGra.error1 = "Nie wychodź po za plaszę!";
             JOptionPane.showMessageDialog(null, MojaGra.error1);
            return false;
        } else if (punkty.size() > 0) {
            int rowIndex = wiersz / 40;
            int colIndex = kolumna / 40;
            for (int i = 0; i < punkty.size(); i++) {
                if (punkty.size()<3){
                if (  punkty.get(i).getY() / 40 == rowIndex && punkty.get(i).getX() / 40 == colIndex ) {
                    MojaGra.error1 = "Bez powtarzania miejsc";
                    JOptionPane.showMessageDialog(null, MojaGra.error1);
                    return false;
                }
                }
                else if (punkty.size()>=3){
                    for (int k=1;k<punkty.size();k++){
                        if(punkty.get(k).getY() / 40 == rowIndex && punkty.get(k).getX() / 40 == colIndex){
                             MojaGra.error1 = "Bez powtarzania miejsc";
                              JOptionPane.showMessageDialog(null, MojaGra.error1);
                            return false;
                        }
                        else if(punkty.get(0).getY() / 40 == rowIndex && punkty.get(0).getX() / 40 == colIndex){
                            return true;
                        }
                    }
                }
                }
            }
return true;
        }
    private void Kontroluj(int wiersz, int kolumna) throws IllegalArgumentException {
        if (wiersz < 0 || wiersz >= getRowCount()) {
            throw new IllegalArgumentException("Zły indeks wiersza!!!");
        }
        if (kolumna < 0 || kolumna >= getColCount()) {
            throw new IllegalArgumentException("Zły indeks kolumny!!!");
        }
    }
    public int getRowCount() {
        return tab.length;
    }
    public int getColCount() {
        return tab[0].length;
    }
}