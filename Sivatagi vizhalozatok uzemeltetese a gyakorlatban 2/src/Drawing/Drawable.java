package Drawing;

import Controll.ViewGame;

import javax.swing.*;
import java.awt.*;

public abstract class Drawable {
    protected int x;
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void Draw(ViewGame vg, Graphics2D g) {
        System.out.println("Goldi kurva anyád");
    }
}
