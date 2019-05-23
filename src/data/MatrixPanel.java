/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import app.MojaGra;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import view.MainFrame;
/**
 *
 * @author Mati
 */
public class MatrixPanel extends JPanel {
    private MojaTablica  mojatablica;
    public MatrixPanel (MojaTablica  mojatablica) {
        this.mojatablica = mojatablica;
    }
    public MojaTablica  getMatrix() {
        return mojatablica;
    }
    public void seetMatrix(MojaTablica  matrix) {
        this.mojatablica = mojatablica;
    }
    int X;
    int Y;
    int kolor = 0;
    int X1;
    int Y1;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0, n = mojatablica.getRowCount(); i < n; i++) {
            for (int j = 0, m = mojatablica.getColCount(); j < m; j++) {
                switch (mojatablica.getElement(i, j)) {
                    case 0:
                        g.setColor(Color.white);
                        break;
                    case 1:
                        g.setColor(Color.ORANGE);
                        break;
                    case 2:
                        g.setColor(Color.BLACK);
                        break;
                    case 3:
                        g.setColor(Color.GREEN);
                        break;
                    case 4:
                        g.setColor(Color.MAGENTA);
                        break;
                    case 5:
                        g.setColor(Color.YELLOW);
                        break;
                }
                g.fillRect(j * MojaGra.size, i * MojaGra.size, MojaGra.size, MojaGra.size);
                g.setColor(Color.BLACK);
                g.drawRect(j * MojaGra.size, i * MojaGra.size, MojaGra.size, MojaGra.size);
            }
        }
        g.setColor(Color.darkGray);
        for (int k = 0; k < mojatablica.getDlugosc(); k++) {
            Y = mojatablica.getPunkty().get(0).getY();
            X = mojatablica.getPunkty().get(0).getX();
            X1 = mojatablica.getPunkty().get(k).getX();
            Y1 = mojatablica.getPunkty().get(k).getY();
            MainFrame.jPanel2.setBackground(mojatablica.GetColor());
            if (mojatablica.getDlugosc() > 1 && k >= 1) {
                g.drawLine(mojatablica.getPunkty().get(k - 1).getX(),
                        mojatablica.getPunkty().get(k - 1).getY(),
                        mojatablica.getPunkty().get(k).getX(),
                        mojatablica.getPunkty().get(k).getY());
                if (mojatablica.getPunkty().size() > 3 && X1 / 50
                        ==X / 50 && Y1 / 50 == Y / 50) {
                    mojatablica.LiczWynik();
                    mojatablica.Skasuj();
                    MainFrame.labelScore.setText(" " + MojaGra.iloscPunktow);
                    MainFrame.jPanel2.setBackground(Color.white);
                }
            }
        }
        repaint();
    }
}
