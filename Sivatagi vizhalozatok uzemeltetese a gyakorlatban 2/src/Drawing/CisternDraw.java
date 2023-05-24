package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class CisternDraw extends Drawable {
    static JButton cistern = new JButton();

    public CisternDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        cistern.setBounds(0, 0, 200, 200);
        cistern.setVisible(true);
    }

    public void Draw(ViewGame vg, Graphics2D g) {
        //cistern.setBounds(40, 40, 200, 200);
        System.out.println("FAAAAASZ");
        vg.add(cistern);
    }
}
