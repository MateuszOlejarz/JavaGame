/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.sql.Time;
import java.util.TimerTask;
import javax.swing.Timer;
import view.MainFrame;
import data.MatrixPanel;
/**
 *
 * @author Mati
 */
public class MojaGra {
       public static int wiersz = 0;
       public static int kolumna = 0;
    public static int pusteprzyciski=100;
    public static int iloscPunktow=0;
    public static int timer1=15000;//15 sekund
    public static int size=50;
    public static String error1=null;
    public static boolean koniec= false;
    public static void ZmienZegar(){
      if(iloscPunktow>10 && iloscPunktow <20){
      timer1=15000;
      }
      else if (iloscPunktow>20 && iloscPunktow <40){
          timer1=15000;
      }
      else if(iloscPunktow>40 && iloscPunktow <60){
          timer1=10000;
      }
      else{
          timer1=8000;
      }
    }
}
