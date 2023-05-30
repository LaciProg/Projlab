package Controll;

import Drawing.*;
import Enums.Fluid;
import Fields.*;
import Fields.ActiveFields.*;
import Fields.ActiveFields.Spring;
import Players.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewGame extends JFrame implements ActionListener {

    private Controller controller;
    private static boolean isChosen = false;
    private JPanel gameBackground;

    public static HashMap<Drawable, Object> objectDrawNames = new HashMap<>();

    public static HashMap<Object, Drawable> objectDrawReverseNames = new HashMap<>();
    
    public static ViewGame vg;

    static JLabel activePlayer;
    JLabel labelPoints;
    static JLabel mecPoints;
    static JLabel sabPoints;
    static JLabel successLabel;
    JButton moveButton;
    JButton repairButton;
    JButton breakButton;
    JButton makeSlipperyButton;
    JButton makeStickyButton;
    JButton pickUpButton;
    JButton putDownButton;
    JButton setPumpButton;
    
    static JButton lastAction; //utoljára megnyomott gomb
    static ArrayList<Object> selectSequence = new ArrayList<Object>(); //kiválasztott elemek, kiválasztásuk sorrendjében
    public static HashMap<JButton, Drawable> buttonToElement = new HashMap<JButton, Drawable>(); //kiválasztó gomb -> kiválasztott rajz
    
    
    // Ez hívodik, amikor kiválasztunk egy elemet
    public static ActionListener selectListener = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			Drawable selectedDrawing = buttonToElement.get(e.getSource());
			Object selected = objectDrawNames.get(selectedDrawing); //a kiválasztott elem
			selectSequence.add(selected);
			String[] cmd = new String[10];
			
			
			//Ez egy nagyon szar módja a feltételnek
			//De így megússzuk, hogy az összes gombot static-á tegyük
			if(lastAction.getText().equals("Pick up")) {
				cmd[1] = Controller.getActivePlayerName();
				cmd[2] = Controller.objectReverseNames.get(selected);				
				Controller.disconnect(cmd);
				//Ha elvégeztük a teendőt, ezzel kell befejezni
				isChosen = false;
				selectSequence.clear();
                changeText(cmd);
			}
			if(lastAction.getText().equals("Set pump") && selectSequence.size() == 2) {
				cmd[1] = Controller.getActivePlayerName();
				cmd[2] = Controller.objectReverseNames.get(selectSequence.get(0));
				cmd[3] = Controller.objectReverseNames.get(selectSequence.get(1));
				Controller.set(cmd);
				isChosen = false;
				selectSequence.clear();
                changeText(cmd);
			}
			if(lastAction.getText().equals("Move")){
                cmd[1] = Controller.getActivePlayerName();
                cmd[2] = Controller.objectReverseNames.get(selectSequence.get(0));
                Controller.move(cmd);
                isChosen = false;
                selectSequence.clear();
                changeText(cmd);
            }

			vg.repaint();
		}
    };
    
    public static void main(String[] args){
        Menu menu = new Menu("Menu", "White");
        menu.showMenu();
    }

    public static void setDrawsNames(Drawable d, Object o) { objectDrawNames.put(d, o); }

    public static void setDrawsReverseNames(Object o, Drawable d) { objectDrawReverseNames.put(o, d); }

    public static boolean getChosen(){
        return isChosen;
    }
    
    public ViewGame() {
        setTitle("Sivatagi vízhálózatok üzemeltetése a gyakorlatban 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setBounds(400, 150, 1000, 700);
        setLayout(new BorderLayout());
        //setLayout(null);
        gameBackground = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(Color.black);
                super.paintComponent(g2d);
                int i = 0;
                for (Drawable draw : objectDrawReverseNames.values()){
                    if (draw instanceof PipeDraw) {
                        Pipe p = (Pipe)ViewGame.objectDrawNames.get(draw);
                        float[] dash1 = { 2f, 0f, 2f };
                        if (p.isBroken()) g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3.0f, dash1, 2f));
                        else g2d.setStroke(new BasicStroke(5));
                        if (p.getFluid().equals(Fluid.DRY)) g2d.setColor(Color.black);
                        else if (p.getFluid().equals(Fluid.SLIPPERY)) g2d.setColor(Color.blue);
                        else if (p.getFluid().equals(Fluid.STICKY)) g2d.setColor(Color.yellow);
                        g2d.drawLine(((PipeDraw) draw).getxFrom(), ((PipeDraw) draw).getYFrom(), ((PipeDraw) draw).getxTo(), ((PipeDraw) draw).getYTo());
                    }
                }
            }
        };
        gameBackground.setBounds(0,0, 800, 500);
        gameBackground.setLayout(null);
        add(gameBackground, BorderLayout.CENTER);


        JPanel controllButtons = new JPanel();
        controllButtons.setLayout(new GridLayout(1,7));
        moveButton = new JButton("Move");
        repairButton = new JButton("Repair");
        setPumpButton = new JButton("Set pump");
        breakButton  = new JButton("Break");
        makeSlipperyButton = new JButton("Make Slippery");
        makeStickyButton = new JButton("Make Sticky");
        pickUpButton = new JButton("Pick up");
        putDownButton = new JButton("Put down");
        moveButton.addActionListener(this);
        repairButton.addActionListener(this);
        setPumpButton.addActionListener(this);
        breakButton.addActionListener(this);
        makeSlipperyButton.addActionListener(this);
        makeStickyButton.addActionListener(this);
        pickUpButton.addActionListener(this);
        putDownButton.addActionListener(this);
        controllButtons.add(moveButton);
        controllButtons.add(repairButton);
        controllButtons.add(setPumpButton);
        controllButtons.add(breakButton);
        controllButtons.add(makeSlipperyButton);
        controllButtons.add(makeStickyButton);
        controllButtons.add(pickUpButton);
        controllButtons.add(putDownButton);
        add(controllButtons,BorderLayout.SOUTH);

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(4,1));
        activePlayer = new JLabel("Active Player:   ");
        labelPoints = new JLabel("Points:     ");
        mecPoints = new JLabel("Mechanic:    ");
        sabPoints = new JLabel("Saboteur:    ");
        successLabel= new JLabel("Last Action:      ");
        text.add(activePlayer);
        JPanel points = new JPanel();
        points.setLayout(new GridLayout(3,1));
        points.add(labelPoints);
        points.add(mecPoints);
        points.add(sabPoints);
        text.add(successLabel);
        text.add(points);
        add(text,BorderLayout.EAST);

        /*JPanel EastPanel = new JPanel();
        EastPanel.setBounds(0,0, 200, 700);
        JButton east = new JButton("FASZ");
        east.setPreferredSize(new Dimension(200, 700));
        EastPanel.add(east);
        JButton south = new JButton("KUKI");//TODO Ilyenek ne maradjanak bent a végén
        south.setPreferredSize(new Dimension(1000,200));

        JPanel SouthPanel = new JPanel();
        SouthPanel.add(south);
        SouthPanel.setBounds(0,0, 1000, 200);
        add(EastPanel, BorderLayout.EAST);
        add(SouthPanel, BorderLayout.SOUTH);*/
        activePlayer.setText("Active Player: "+ Controller.getActivePlayerName());
        gameBackground.setBackground(new Color(150, 75, 0));
        setVisible(true);
        repaint();
        vg = this;
    }

    public void setController(Controller c){
        controller = c;
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
        for (Drawable draw : objectDrawReverseNames.values()) {
            draw.Draw(gameBackground, g);
        }
    }

    public void DisplayChosen() {
        //TODO gombok megjelenítése amikor valamit változtatni kell
    }

    public void actionPerformed(ActionEvent e) {
        String[] cmd = new String[10];
        lastAction = (JButton)e.getSource(); //innen tudjuk, melyik gombot lett utoljára nyomva
        isChosen = false; //ha esetleg meggondolnánk magunk
        boolean successful = false;
        if(e.getSource() == moveButton){
            isChosen = true;
        }
        if(e.getSource() == repairButton){
            cmd[1] = Controller.getActivePlayerName();
            Controller.repair(cmd);
            successful = true;
        }
        if(e.getSource() == setPumpButton){
            //e gombra kattintva kéne a pumpát átállítani
        	//Úgy lenne a legkényelmesebb, ha először kiválasztjuk honnan, aztán hová
        	isChosen = true;
        }
        if(e.getSource() == breakButton){
            cmd[1] = Controller.getActivePlayerName();
            Controller.breakfield(cmd);
            successful = true;
        }
        if(e.getSource() == makeSlipperyButton){
            cmd[1] = Controller.getActivePlayerName();
            Controller.makeslippery(cmd);
            successful = true;
        }
        if(e.getSource() == makeStickyButton){
            cmd[1] = Controller.getActivePlayerName();
            Controller.makesticky(cmd);
            successful = true;
        }
        if(e.getSource() == pickUpButton){
        	if(Controller.GetActivePlayer().getStandingField() instanceof Cistern) {
        		cmd[1] = Controller.getActivePlayerName();
				Controller.getpump(cmd);
				Controller.pickuppipe(cmd);
				successful = true;
        	} else isChosen = true;
        }
        if(e.getSource() == putDownButton){
        	cmd[1] = Controller.getActivePlayerName();
        	if(Controller.GetActivePlayer().getStandingField() instanceof Pipe) Controller.placepump(cmd);
        	else Controller.connect(cmd);
        	successful = true;
        }
        if(successful) {
            changeText(cmd);
        }
        this.repaint();
    }

    public static void changeText(String[] cmd){
        boolean b = Controller.changeActivePlayer();
        activePlayer.setText("Active Player: " + Controller.getActivePlayerName());
        if (b) {
            Controller.endturn(cmd);
            mecPoints.setText("Mechanic: " + Controller.waterCounter.getMechanic());
            sabPoints.setText("Saboteur: " + Controller.waterCounter.getSaboteur());
        }
        if(Controller.getLastResult()){
            successLabel.setText("Last Action: Successful");
        }else{
            successLabel.setText("Last Action: Unsuccessful");
        }
    }
}
