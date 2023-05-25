package Controll;

import Drawing.*;
import Fields.*;
import Fields.ActiveFields.*;
import Fields.ActiveFields.Spring;
import Players.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewGame extends JFrame {
    private boolean isChosen = false;
    private JPanel gameBackground;

    public static HashMap<Drawable, Object> objectDrawNames = new HashMap<>();

    public static HashMap<Object, Drawable> objectDrawReverseNames = new HashMap<>();

    public static void main(String[] args){
        Menu menu = new Menu("Menu", "White");
        menu.showMenu();
    }

    public static void setDrawsNames(Drawable d, Object o) { objectDrawNames.put(d, o); }

    public static void setDrawsReverseNames(Object o, Drawable d) { objectDrawReverseNames.put(o, d); }

    public ViewGame() {
        setTitle("Sivatagi vízhálózatok üzemeltetése a gyakorlatban 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setBounds(400, 150, 1000, 700);
        //setLayout(new BorderLayout());
        setLayout(null);
        gameBackground = new JPanel();
        gameBackground.setBounds(0,0, 800, 500);
        gameBackground.setLayout(null);
        //add(gameBackground, BorderLayout.CENTER);
        add(gameBackground);

        /*JPanel EastPanel = new JPanel();
        EastPanel.setBounds(0,0, 200, 700);
        JButton east = new JButton("FASZ");
        east.setPreferredSize(new Dimension(200, 700));
        EastPanel.add(east);
        JButton south = new JButton("KUKI");
        south.setPreferredSize(new Dimension(1000,200));

        JPanel SouthPanel = new JPanel();
        SouthPanel.add(south);
        SouthPanel.setBounds(0,0, 1000, 200);
        add(EastPanel, BorderLayout.EAST);
        add(SouthPanel, BorderLayout.SOUTH);*/
        gameBackground.setBackground(new Color(150, 75, 0));
        setVisible(true);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        DrawAll(g2d);

        /*g2d.setColor(Color.GRAY);
        //g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, 0));

        float[] dash1 = { 2f, 0f, 2f };

        g2d.drawLine(20, 40, 250, 40);
        BasicStroke bs1 = new BasicStroke(1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                dash1,
                2f);
        //g2d.setStroke(bs1);
        g2d.drawLine(20, 80, 250, 80);*/
    }

    public void setBackgroundColor(String theme) {
        if (theme.equals("Black")) getContentPane().setBackground(Color.darkGray);
    }

    public void DrawAll(Graphics2D g) {
        System.out.println(objectDrawReverseNames.size());
        for (Drawable draw : objectDrawReverseNames.values()) {
            draw.Draw(gameBackground, g);
            //gameBackground.repaint();
        }

    }

    public void DisplayChosen() {
        //TODO gombok megjelenítése amikor valamit változtatni kell
    }
}
