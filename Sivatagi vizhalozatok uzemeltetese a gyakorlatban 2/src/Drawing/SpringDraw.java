package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class SpringDraw extends Drawable {
    static JButton spring = new JButton();

    public SpringDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        spring.setBounds(200, 200, 200, 200);
        spring.setVisible(true);
    }

    @Override
    public void Draw(ViewGame vg, Graphics2D g) {
        //spring.setBounds(140, 140, 200, 200);
        System.out.println("FAAAAASZ");
        vg.add(spring);
    }
}
