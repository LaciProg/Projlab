package Drawing;

import Controll.ViewGame;
import Fields.ActiveFields.Pump;
import Fields.Pipe;

import javax.swing.*;
import java.awt.*;

public class PumpDraw extends Drawable {
    JButton pump = new JButton();
    public PumpDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        pump.setVisible(true);
        pump.setBackground(new Color(150, 75, 0));
    }

    public void Draw(JPanel panel, Graphics2D g) {
        pump.setBounds(x, y, 50, 50);
        Pump p = (Pump)ViewGame.objectDrawNames.get(this);
        if (p.isBroken()) pump.setBorder(BorderFactory.createDashedBorder(Color.black, 5, 2, 2, false));
        else pump.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        panel.add(pump);
        panel.repaint();
    }
}
