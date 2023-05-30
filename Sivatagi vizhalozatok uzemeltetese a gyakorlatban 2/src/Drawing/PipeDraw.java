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
    JButton pipeB = new JButton();

    public int getxFrom() { return xFrom; }
    public int getxTo() { return xTo; }
    public int getYFrom() { return yFrom; }
    public int getYTo() { return yTo; }

    public PipeDraw(int x1, int y1, int x2, int y2) {
        xFrom = x1;
        yFrom = y1;
        xTo = x2;
        yTo = y2;
        //pipe.setBounds(x, y, 200, 200);

        ViewGame.buttonToElement.put(pipeB, this);
        pipeB.addActionListener(ViewGame.selectListener);
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g2d) {
        //g2d.setColor(Color.black);

        //float[] dash1 = { 2f, 0f, 2f };

        //g2d.drawLine(xFrom, yFrom, xTo, yTo); // TODO JPanel paint metódusában kéne elvileg kirajzolni
        //BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        //g2d.setStroke(bs1);
        //g2d.drawLine(20, 80, 250, 80);
    	
    	if(ViewGame.getChosen()) {
    		pipeB.setVisible(true);
    		pipeB.setBackground(new Color(255, 0, 0));
    		pipeB.setBounds(xFrom + (xTo - xFrom) / 2 - 25, yFrom + (yTo - yFrom) / 2 - 12, 50, 25);
    		pipeB.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        	panel.add(pipeB);
        } else {
        	pipeB.setVisible(false);
        	panel.remove(pipeB);
        }
    	
    	panel.repaint();
    }
}
