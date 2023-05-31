package Drawing;

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

    public void Draw(JPanel panel, Graphics2D g) {
    }
}
