package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class CisternDraw extends Drawable {
    JButton cistern = new JButton();
    JButton cisternB = new JButton();

    public CisternDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        cistern.setVisible(true);
        cistern.setBackground(new Color(150, 75, 0));
    }

    public void Draw(JPanel panel, Graphics2D g) {
        cistern.setBounds(x, y, 50, 50);
        cistern.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        
        if(ViewGame.getChosen()) {
        	cisternB.setVisible(true);
        	cisternB.setBackground(new Color(255, 0, 0));
        	cisternB.setBounds(x, y, 50, 50);
        	cisternB.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        	panel.add(cisternB);
        } else {
        	cisternB.setVisible(false);
        	panel.remove(cisternB);
        }
      
        panel.add(cistern);
        panel.repaint();
    }
}
