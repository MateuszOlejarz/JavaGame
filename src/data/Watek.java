/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import app.MojaGra;
import com.sun.prism.paint.Gradient;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.misc.FpUtils;
import view.MainFrame;
/**
 *
 * @author Mati
 */
public class Watek extends Thread{
private MojaTablica  mojatablica;
    private MatrixPanel  panel1;
    private JPanel jPanel;
    private ObsługaZdarzenKlikaniaMyszka mouseListener;
    public ObsługaZdarzenKlikaniaMyszka getMouseListener() {
        return mouseListener;
    }
    public void setMouseListener(ObsługaZdarzenKlikaniaMyszka mouseListener) {
        this.mouseListener = mouseListener;
    }
    public JPanel getjPanel() {
        return jPanel;
    }
    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }
    public MojaTablica  getMojaTablica() {
        return mojatablica;
    }
    public void setMojaTablica(MojaTablica  matrix) {
        this.mojatablica = matrix;
    }
    public MatrixPanel  getPanel() {
        return panel1;
    }
    public void setPanel(MatrixPanel  panel) {
        this.panel1 = panel;
    }
    @Override
       public void run() {
        super.run();
           mojatablica.randomElements();
           while (true) {
         try {
                Thread.sleep(MojaGra.timer1);
                 mojatablica.MechanizmPrzywracania(); 
            } catch (InterruptedException e) {
            }
            if(MojaGra.pusteprzyciski==0){
              JOptionPane.showMessageDialog(null, "Za późno");
                MojaGra.koniec=true;
                break;
            }
    }
    }
}
