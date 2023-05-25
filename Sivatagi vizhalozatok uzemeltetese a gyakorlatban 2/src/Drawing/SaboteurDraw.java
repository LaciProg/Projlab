package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class SaboteurDraw extends Drawable {
    JButton sab = new JButton();

    public SaboteurDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        sab.setBounds(x, y, 200, 200);
        sab.setVisible(true);


    }

    @Override
    public void Draw(JPanel panel, Graphics2D g) {
    }
}
