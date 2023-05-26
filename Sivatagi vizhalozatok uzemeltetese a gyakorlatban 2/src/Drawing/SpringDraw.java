package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class SpringDraw extends Drawable {
    JButton spring = new JButton();

    public SpringDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        spring.setVisible(true);
        spring.setBackground(new Color(150, 75, 0));
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g) {
        spring.setBounds(x, y, 50, 50);
        spring.setBorder(BorderFactory.createLineBorder(Color.white, 5));
        panel.add(spring);
        panel.repaint();
    }
}