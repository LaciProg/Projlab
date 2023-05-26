package Drawing;

import Controll.Controller;
import Controll.ViewGame;
import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.ActiveFields.Spring;
import Fields.Field;
import Fields.Pipe;
import Players.Mechanic;
import Players.Player;
import Players.Saboteur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MechanicDraw extends Drawable {
    String mecName = "";
    JButton mec = new JButton();

    public MechanicDraw(int tmpX, int tmpY) {
        x = tmpX;
        y = tmpY;
        mec.setVisible(true);
    }

    @Override
    public void Draw(JPanel panel, Graphics2D g) {
        Mechanic m = (Mechanic)ViewGame.objectDrawNames.get(this);
        mecName = Controller.objectReverseNames.get(m);
        mec.setText(mecName);
        Field f = m.getStandingField();
        if (f instanceof Pipe) {
            PipeDraw pd = (PipeDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(m);
            x = (pd.getxFrom()+pd.getxTo())/2-25;
            y = (pd.getYFrom()+pd.getYTo())/2 - (i+1)*25;
        }
        else if (f instanceof Pump) {
            PumpDraw pd = (PumpDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(m);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        else if (f instanceof Cistern) {
            CisternDraw pd = (CisternDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(m);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        else if (f instanceof Spring) {
            SpringDraw pd = (SpringDraw)ViewGame.objectDrawReverseNames.get(f);
            ArrayList<Player> players = f.getPlayers();
            int i = players.indexOf(m);
            x = pd.getX();
            y = pd.getY() - (i+1)*25;
        }
        mec.setBounds(x, y, 50, 20);
        mec.setBorder(BorderFactory.createLineBorder(Color.green, 5));
        //mec.setBackground(new Color(150, 75, 0));
        panel.add(mec);
        panel.repaint();
    }
}