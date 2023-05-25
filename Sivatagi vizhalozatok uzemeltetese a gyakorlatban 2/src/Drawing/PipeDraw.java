package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public class PipeDraw extends Drawable {
    private int xFrom;
    private int xTo;
    private int yFrom;
    private int yTo;
    //JButton pipe = new JButton();

    public PipeDraw(int x1, int y1, int x2, int y2) {
        xFrom = x1;
        yFrom = y1;
        xTo = x2;
        yTo = y2;
        //pipe.setBounds(x, y, 200, 200);
        //pipe.setVisible(true);
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g2d) {
        g2d.setColor(Color.black);

        //float[] dash1 = { 2f, 0f, 2f };

        g2d.drawLine(xFrom, yFrom, xTo, yTo); // TODO JPanel paint metódusában kéne elvileg kirajzolni
        //BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        //g2d.setStroke(bs1);
        //g2d.drawLine(20, 80, 250, 80);
    }
}
