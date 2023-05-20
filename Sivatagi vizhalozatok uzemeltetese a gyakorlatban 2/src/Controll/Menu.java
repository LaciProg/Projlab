package Controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import Controll.Controller;

public class Menu extends JFrame implements ActionListener {
    //private String currentTheme;
    private JButton newGame;
    //private JButton loadGame;
    private JButton exitGame;
    //private JButton theme;
    private JComboBox<Integer> mechanics;
    private JComboBox<Integer> saboteurs;
    //private JCheckBox isExtraGame;
    private JTextField mechanic;
    private JTextField saboteur;
    //private JTextField extraGame;

    /**
     * konstruktor
     * @param name az ablak neve
     * @param t a játék témája
     */
    public Menu(String name, String t) {
        //currentTheme = t;
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setBounds(700, 250, 500, 500);

        newGame = new JButton("New Game");
        newGame.setBounds(140, 120, 200, 60);
        newGame.addActionListener(this);

        //loadGame = new JButton("Load Game");
        //loadGame.setBounds(140, 230, 200, 60);
        //loadGame.addActionListener(this);

        exitGame = new JButton("Exit");
        exitGame.setBounds(140, 300, 200, 60);
        exitGame.addActionListener(this);

        //theme = new JButton("Change theme");
        //theme.setBounds(140, 300, 200, 60);
        //theme.addActionListener(this);

        add(newGame);
        //add(loadGame);
        add(exitGame);
        //add(theme);

        Integer[] numOfMechanics = {2, 3, 4, 5, 6, 7, 8, 9};
        mechanics = new JComboBox<Integer>(numOfMechanics);
        mechanics.setBounds(300, 195, 40, 20);

        Integer[] numOfSaboteurs = {2, 3, 4, 5, 6, 7, 8, 9};
        saboteurs = new JComboBox<Integer>(numOfSaboteurs);
        saboteurs.setBounds(300, 225, 40, 20);

        //isExtraGame = new JCheckBox();
        //isExtraGame.setBounds(300, 255, 40, 20);

        add(mechanics);
        add(saboteurs);
        //add(isExtraGame);

        mechanic = new JTextField("Number of mechanics:");
        mechanic.setBounds(140, 195, 160, 20);
        mechanic.setEditable(false);

        saboteur = new JTextField("Number of saboteurs:");
        saboteur.setBounds(140, 225, 160, 20);
        saboteur.setEditable(false);

        //extraGame = new JTextField("Do you want an extra game?");
        //extraGame.setBounds(140, 255, 160, 20);
        //extraGame.setEditable(false);

        add(mechanic);
        add(saboteur);
        //add(extraGame);

        /*if (currentTheme.equals("Black")) {
            getContentPane().setBackground(Color.darkGray);
            newGame.setBackground(Color.gray);
            loadGame.setBackground(Color.gray);
            exitGame.setBackground(Color.gray);
            theme.setBackground(Color.gray);
            players.setBackground(Color.gray);
            tokens.setBackground(Color.gray);
            isExtraGame.setBackground(Color.gray);
            player.setBackground(Color.gray);
            token.setBackground(Color.gray);
            extraGame.setBackground(Color.gray);
        }*/
        setVisible(false);
    }

    /**
     * láthatóvá válik a menü
     */
    public void showMenu() {
        setVisible(true);
    }

    /**
     * sötét téma be/ki kapcsolása
     */
    /*public void changeTheme() {
        if (currentTheme.equals("White")) {
            currentTheme = "Black";
            getContentPane().setBackground(Color.darkGray);
            newGame.setBackground(Color.gray);
            loadGame.setBackground(Color.gray);
            exitGame.setBackground(Color.gray);
            theme.setBackground(Color.gray);
            players.setBackground(Color.gray);
            tokens.setBackground(Color.gray);
            isExtraGame.setBackground(Color.gray);
            player.setBackground(Color.gray);
            token.setBackground(Color.gray);
            extraGame.setBackground(Color.gray);
        }
        else {
            currentTheme = "White";
            getContentPane().setBackground(null);
            newGame.setBackground(null);
            loadGame.setBackground(null);
            exitGame.setBackground(null);
            theme.setBackground(null);
            players.setBackground(null);
            tokens.setBackground(null);
            isExtraGame.setBackground(null);
            player.setBackground(null);
            token.setBackground(null);
            extraGame.setBackground(null);
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

        // új játék elkezdése a kiválasztott adatokkal
        if (e.getSource() == newGame) {

            //Controller.commandList.add("load palya.txt");
            Controller.load("palya.txt");

            if ((int)mechanics.getSelectedItem() > 2) {
                for (int i = 3; i <= (int)mechanics.getSelectedItem(); i++) {
                    Controller.commandList.add("mechanic Mechanic" + i + " E");
                }
            }
            if ((int)saboteurs.getSelectedItem() > 2) {
                for (int i = 3; i <= (int)saboteurs.getSelectedItem(); i++) {
                    Controller.commandList.add("saboteur Saboteur" + i + " B");
                }
            }
            Controller.commandList.add("create");
            this.dispose();

            try {
                Controller.Run();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            /*String[] colors = new String[24];
            for (int i = 0; i < 24; i++) {
                colors[i] = "empty";
            }
            boolean[] moves2Tokens = new boolean[24];
            for (int i = 0; i < 24; i++) {
                moves2Tokens[i] = false;
            }
            boolean[] jumpingTokens = new boolean[24];
            for (int i = 0; i < 24; i++) {
                jumpingTokens[i] = false;
            }
            Game newGame = new Game((int)players.getSelectedItem(), (int)tokens.getSelectedItem(), isExtraGame.isSelected(), colors, currentTheme, moves2Tokens, jumpingTokens, 0);
            try {
                newGame.start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.dispose();*/
        }
        /*
        // játék betöltése fájlból
        if (e.getSource() == loadGame) {
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showDialog(this, "Select");
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                FileInputStream f;
                ObjectInputStream ois;
                try {
                    f = new FileInputStream(chooser.getSelectedFile());
                    ois = new ObjectInputStream(f);
                    // Game beolvasása
                    int numOfPlayers = (int)ois.readObject();
                    int numOfTokens = (int)ois.readObject();
                    boolean isExtraGame = (boolean)ois.readObject();
                    int activePlayer = (int)ois.readObject();

                    // Game befejezve, Board beolvasása jön
                    int mill = (int)ois.readObject();

                    String[] colors = new String[24];
                    for (int i = 0; i < 24; i++) {
                        colors[i] = (String)ois.readObject();
                    }

                    boolean[] moves2Tokens = new boolean[24];
                    for (int i = 0; i < 24; i++) {
                        moves2Tokens[i] = (boolean)ois.readObject();
                    }

                    boolean[] jumpingTokens = new boolean[24];
                    for (int i = 0; i < 24; i++) {
                        jumpingTokens[i] = (boolean)ois.readObject();
                    }

                    int extraTokens = (int)ois.readObject();
                    int moved = (int)ois.readObject();
                    Game newGame = new Game(numOfPlayers, numOfTokens, isExtraGame, colors, currentTheme, moves2Tokens, jumpingTokens, moved);
                    newGame.setActivePlayer(activePlayer);
                    newGame.getBoard().setMill(mill);
                    newGame.getBoard().setExtraTokens(extraTokens);
                    newGame.start();
                    ois.close();
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        // téma változtatása
        if (e.getSource() == theme) {
            changeTheme();
        }
        */
        // kilépés a játékból
        if (e.getSource() == exitGame) {
            System.exit(0);
        }
    }
}