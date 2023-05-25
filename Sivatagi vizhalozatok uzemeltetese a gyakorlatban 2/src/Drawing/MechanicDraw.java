package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class MechanicDraw extends Drawable {
    JButton mech = new JButton();

    public MechanicDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        mech.setBounds(x, y, 200, 200);
        mech.setVisible(true);
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g) {
        return;
    }
}
