package Drawing;

import Controll.Controller;
import Controll.ViewGame;
import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.ActiveFields.Spring;
import Fields.Field;
import Fields.Pipe;
import Players.Player;
import Players.Saboteur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SaboteurDraw extends Drawable {
    String sabName = "";
    JButton sab = new JButton();

    public SaboteurDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        //sab.setBounds(x, y, 200, 200);
        sab.setVisible(true);
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g) {
        Saboteur s = (Saboteur)ViewGame.objectDrawNames.get(this);
        sabName = Controller.objectReverseNames.get(s);
        sab.setText(sabName);
        Field f = s.getStandingField();
        if (f instanceof Pipe) {
            PipeDraw pd = (PipeDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(s);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        else if (f instanceof Pump) {
            PumpDraw pd = (PumpDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(s);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        else if (f instanceof Cistern) {
            CisternDraw pd = (CisternDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(s);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        else if (f instanceof Spring) {
            SpringDraw pd = (SpringDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(s);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        sab.setBounds(x, y, 50, 20);
        sab.setBorder(BorderFactory.createLineBorder(Color.green, 5));
        //sab.setBackground(new Color(150, 75, 0));
        panel.add(sab);
        panel.repaint();
    }
}
