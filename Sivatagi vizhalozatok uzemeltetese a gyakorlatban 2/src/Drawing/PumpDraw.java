package Drawing;

import Controll.ViewGame;
import Fields.ActiveFields.Pump;

import javax.swing.*;
import java.awt.*;

public class PumpDraw extends Drawable {
    static JButton pump = new JButton();
    public PumpDraw(int tmpX, int tmpY) {
            x = tmpX;
            y = tmpY;
        pump.setBounds(x, y, 200, 200);
        pump.setVisible(true);
    }

    public void Draw(ViewGame vg, Graphics2D g) {
        pump.setBounds(20, 20, 200, 200);
        vg.add(pump);
        System.out.println("FAAAAASZ");
    }
}
