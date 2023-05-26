package Controll;

import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel {
    ViewGame viewGame;
    public BackGround(ViewGame vg){
        viewGame = vg;

    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        viewGame.DrawAll(g2d);
    }
}
