package Controll;

import Enums.Fluid;
import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.ActiveFields.Spring;
import Fields.Field;
import Fields.Pipe;
import Interfaces.Steppable;
import Players.Mechanic;
import Players.Player;
import Players.Saboteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

@SuppressWarnings("DuplicatedCode")
public class Controller {
    /**
     * If true the game is random
     * */
    private static boolean random = true;
    /**
     * Getter for random
     * */
    public static boolean isRandom() {return random; }
    public static HashMap<String, Object> objectNames = new HashMap<>();

    public static HashMap<Object, String> objectReverseNames = new HashMap<>();
    /**
     * WaterCounter of the game
     * */
    public static WaterCounter waterCounter = new WaterCounter();
    /**
     * True if the game is tested
     * */
    private static boolean test = false;
    /**
     * Getter for test
     * */
    public static boolean isTest() {return test;}
    /**
     * Name of the used file
     * */
    private static String fileName="";
    /**
     * Path of the used file
     * */
    private static String filePath="";

    /**
     * List of the test result
     * */
    private static final ArrayList<String> outResults = new ArrayList<>();

    /**
    * List of the activePlayers
    * */
    private static final ArrayList<Player> activePlayers = new ArrayList<>();
  
    /**
    * Current Player
    * */
    private static Player currentPlayer;
  
    /**
     * List of the commands
     * */
    static ArrayList<String> commandList = new ArrayList<>();

    public static int pipes=0;
    public static int pumps=0;

    public static boolean gameMode = false;

    public static void main(String[] args) throws FileNotFoundException {
        Run();
    }
    /**
     *Function for controlling the game.
     *Reads a command than calls a function to execute it.
     * */
    public static void Run() throws FileNotFoundException {
        while(!gameMode) {
            Scanner stdInScanner = new Scanner(System.in);
            if (commandList.size() == 0){
                commandList.add(stdInScanner.nextLine());
            }
            String command = commandList.get(0);
            commandList.remove(0);
            String[] cmd = command.split(" ");
            switch(cmd[0]) {
                case("load"): load(cmd[1]); break;
                case("pipe"): pipe(cmd); break;
                case("pump"): pump(cmd); break;
                case("cistern"): cistern(cmd); break;
                case("spring"): spring(cmd); break;
                case("mechanic"): mechanic(cmd); break;
                case("saboteur"): saboteur(cmd); break;
                case("connectpipe"): connectpipe(cmd); break;
                case("random"): random(cmd); break;
                case("create"): create(cmd); break;
                case("show"): show(cmd); break;
                case("showobject"): showobject(cmd); break;
                case("move"): move(cmd); break;
                case("breakfield"): breakfield(cmd); break;
                case("repair"): repair(cmd); break;
                case("placepump"): placepump(cmd); break;
                case("set"): set(cmd); break;
                case("disconnect"): disconnect(cmd); break;
                case("connect"): connect(cmd); break;
                case("getpump"): getpump(cmd); break;
                case("pickuppipe"): pickuppipe(cmd); break;
                case("makesticky"): makesticky(cmd); break;
                case("makeslippery"): makeslippery(cmd); break;
                case("save"): save(cmd); break;
                case("testall"): testAll(cmd); break;
                case("list"): list(cmd); break;
                case("addplayer"): addplayer(cmd); break;
                case("step"): step(cmd); break;
                case("endturn"): endturn(cmd); break;
                case("count"): count(cmd); break;
                case("test"): test(cmd); break;
                case("setend"): setend(cmd); break;
                case("setpump"): setpump(cmd); break;
                case("restart"): restart(cmd); break;
                case("exit"): return;
                default: System.out.println("Hibás parancs.");
            }
        }
        Game();
    }

    public static void Game() throws FileNotFoundException {
        int moves = 0;
        while(gameMode) {
            currentPlayer = activePlayers.get(0); // az első játékos a sor végére rakom, jelenleg ő az aktív
            activePlayers.remove(0);
            activePlayers.add(currentPlayer);
            moves++;
            Scanner stdInScanner = new Scanner(System.in);
            if (commandList.size() == 0){
                commandList.add(stdInScanner.nextLine());
            }
            String command = commandList.get(0);
            commandList.remove(0);
            String[] cmd = command.split(" ");
            switch(cmd[0]) {
                case("show"): show(cmd); break;
                case("showobject"): showobject(cmd); break;
                case("move"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else move(cmd); break;
                case("breakfield"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else breakfield(cmd); break;
                case("repair"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else repair(cmd); break;
                case("placepump"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else placepump(cmd); break;
                case("set"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else set(cmd); break;
                case("disconnect"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else disconnect(cmd); break;
                case("connect"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else connect(cmd); break;
                case("getpump"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else getpump(cmd); break;
                case("pickuppipe"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!");else pickuppipe(cmd); break;
                case("makesticky"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else makesticky(cmd); break;
                case("makeslippery"): if (!((Player)objectNames.get(cmd[1])).equals(currentPlayer)) System.out.println("Nem te vagy a soron következő játékos!"); else makeslippery(cmd); break;
                case("save"): save(cmd); break;
                case("testall"): testAll(cmd); break;
                case("list"): list(cmd); break;
                case("addplayer"): addplayer(cmd); break;
                case("step"): step(cmd); break;
                case("endturn"): endturn(cmd); break;
                case("count"): count(cmd); break;
                case("test"): test(cmd); break;
                case("setend"): setend(cmd); break;
                case("setpump"): setpump(cmd); break;
                case("restart"): restart(cmd); break;
                case("exit"): return;
                default: System.out.println("Hibás parancs.");
            }
            if (moves == activePlayers.size()) {
                moves = 0;
                endturn(cmd);
            }
        }
        Run();
    }
    /**
     * Function for loading a file.
     * */
    private static void load(String cmd){
        try {
            outResults.clear();
            Scanner scanner = new Scanner(new File(cmd));
            filePath = cmd;
            String separator = "\\";
            String[] tmp=cmd.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            fileName = tmp[tmp.length-1];
            while (scanner.hasNextLine()){
                commandList.add(scanner.nextLine());
            }
            if (test) {
                commandList.add("save " + filePath.replace(".in", ".out"));
            }
        } catch (FileNotFoundException e) {
          
        }
    }
    /**
     * Function for creating a pump.
     * */
    private static void pump(String[] cmd){
        Pump tmp = new Pump(Integer.parseInt(cmd[2]));
        String[][] commands = new String[cmd.length-3][2];
        for(int i=3; i<cmd.length; i++){
            commands[i-3] = cmd[i].split(":");
        }

        for(int i=0; i<commands.length; i++){
            switch (commands[i][0]){
                case "water": tmp.setWater(Integer.parseInt(commands[i][1])); break;
                case "broken": tmp.setBroken(Boolean.parseBoolean(commands[i][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for creating a pipe.
     * */
    private static void pipe(String[] cmd){
        Pipe tmp = new Pipe(Integer.parseInt(cmd[2]));
        String[][] commands = new String[cmd.length-3][2];
        for(int i=3; i<cmd.length; i++){
            commands[i-3] = cmd[i].split(":");
        }
        for(int i=0; i<commands.length; i++){
            switch (commands[i][0]){
                case "fluid":
                    switch (commands[i][1]){
                        case "dry": tmp.setFluid(Fluid.DRY); break;
                        case "sticky": tmp.setFluid(Fluid.STICKY); break;
                        case "slippery": tmp.setFluid(Fluid.SLIPPERY); break;
                    }
                    break;
                case "rfluidtime": tmp.setFluidTime(Integer.parseInt(commands[i][1])); break;
                case "breakable": tmp.setBreakable(Integer.parseInt(commands[i][1])); break;
                case "broken": tmp.setBroken(Boolean.parseBoolean(commands[i][1])); break;
                case "water": tmp.setWater(Integer.parseInt(commands[i][1])); break;
                case "leave": tmp.setLeave(Boolean.parseBoolean(commands[i][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        waterCounter.addPipe(tmp);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for creating a cistern.
     * */
    private static void cistern(String[] cmd){
        Cistern tmp = new Cistern();
        String[][] commands = new String[cmd.length-2][2];
        for(int i=2; i<cmd.length; i++){
            commands[i-2] = cmd[i].split(":");
        }
        for(int i=0; i<commands.length; i++) {
            switch (commands[i][0]) {
                case "water":
                    tmp.setWater(Integer.parseInt(commands[0][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        waterCounter.addCistern(tmp);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for creating a spring.
     * */
    private static void spring(String[] cmd){
        Spring tmp = new Spring(Integer.parseInt(cmd[2]));
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for creating a saboteur.
     * */
    private static void saboteur(String[] cmd){
        Saboteur tmp = new Saboteur();
        Field f = (Field)objectNames.get(cmd[2]);
        tmp.setStandingField(f);
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
        activePlayers.add(tmp);
    }
    /**
     * Function for creating a mechanic.
     * */
    private static void mechanic(String[] cmd){
        Mechanic tmp = new Mechanic();
        Field f = (Field)objectNames.get(cmd[2]);
        tmp.setStandingField(f);
        String[][] commands = new String[cmd.length-3][2];
        for(int i=3; i<cmd.length; i++){
            commands[i-3] = cmd[i].split(":");
        }
        for(int i=0; i<commands.length; i++) {
            switch (commands[i][0]) {
                case "pump":
                    tmp.setHoldingPump((Pump)objectNames.get(commands[i][1]));
                    break;
                case "pipe":
                    tmp.setHoldingPipe((Pipe)objectNames.get(commands[i][1]));
                    break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
        activePlayers.add(tmp);
    }
    /**
     * Function for connecting a pipe to an active field.
     * */
    private static void connectpipe(String[] cmd){
        Pipe pipe = (Pipe)objectNames.get(cmd[1]);
        ActiveFields activeField = (ActiveFields)objectNames.get(cmd[2]);
        pipe.setFields(activeField);
        activeField.addPipe(pipe);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for switching random off and on.
     * */
    private static void random(String[] cmd){
        if (test) {
            if(cmd.length == 2){
                switch (cmd[1]){
                    case "false": random = false;
                        outResults.add("A véletlen események ki lettek kapcsolva."); break;
                    case "true": random = true;
                        outResults.add("A véletlen események be lettek kapcsolva."); break;
                }
            }else {
                random=true;
                outResults.add("A véletlen események be lettek kapcsolva.");
            }
        }
        else {
            if(cmd.length == 2){
                switch (cmd[1]){
                    case "false": random = false;
                        System.out.println("A véletlen események ki lettek kapcsolva."); break;
                    case "true": random = true;
                        System.out.println("A véletlen események be lettek kapcsolva."); break;
                }
            }else {
                random=true;
                System.out.println("A véletlen események be lettek kapcsolva.");
            }
        }

    }
    /**
     * Function for starting the game.
     * */
    private static void create(String[] cmd) {
        objectNames.put("wc", waterCounter);
        objectReverseNames.put(waterCounter, "wc");
        if (test) outResults.add("A pálya létrehozása sikeresen lezajlott. Kezdődhet a játék!");
        else System.out.println("A pálya létrehozása sikeresen lezajlott. Kezdődhet a játék!");
        if(!test) gameMode = true;
    }
    /**
     * Function for showing where a player stands.
     * */
    private static void show(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        String[] commands = cmd[2].split(":");
        switch (commands[1]){
            case "player":
                if (test) outResults.add(p.toString());
                else System.out.println(p);
                break;
            case "field":
                if (test) outResults.add(objectReverseNames.get(p.getStandingField()).toString());
                else System.out.println(objectReverseNames.get(p.getStandingField()));
                break;
        }
    }
    /**
     * Function for displaying important information about the object.
     * */
    private static void showobject(String[] cmd){
        Object object = objectNames.get(cmd[1]);
        if (test) outResults.add(object.toString());
        else System.out.println(object.toString());
    }
    /**
     * Function for moving a player to a field.
     * */
    private static void move(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        Field f = (Field)objectNames.get(cmd[2]);
        if(p.move(f)){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for breaking a field by a player.
     * */
    private static void breakfield(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        if(p.breakField()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for repairing a field by a player.
     * */
    private static void repair(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        if(p.repair()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for placing a pump by a player.
     * */
    private static void placepump(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        Pipe pipe = p.placePump();
        if(pipe != null ){
            pipes++;
            String s = "newPipe"+pipes;
            objectNames.put(s, pipe);
            objectReverseNames.put(pipe, s);
            waterCounter.addPipe(pipe);
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for setting a pump by a player.
     * */
    private static void set(String[] cmd){
         Player player = (Player)objectNames.get(cmd[1]);
         if(player.getStandingField().set((Pipe)objectNames.get(cmd[2]), (Pipe)objectNames.get(cmd[3]))){
             if (test) outResults.add("Sikeres művelet");
             else System.out.println("Sikeres művelet");
         }else  {
             if (test) outResults.add("Sikertelen művelet");
             else System.out.println("Sikertelen művelet");
         }
    }
    /**
     * Function for disconnecting a pipe by a player.
     * */
    private static void disconnect(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.disconnect((Pipe)objectNames.get(cmd[2]))){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for connecting a pipe by a player.
     * */
    private static void connect(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.connect()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for getting a pump by a player.
     * */
    private static void getpump(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        Pump pump = p.getPump();
        if(pump != null ){
            pumps++;
            String s = "newPump"+pumps;
            objectNames.put(s, pump);
            objectReverseNames.put(pump, s);
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function picking up a pipe by a player.
     * */
    private static void pickuppipe(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.pickUpPipe()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for making a pipe sticky by a player.
     * */
    private static void makesticky(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.makeSticky()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for making a pipe slippery by a player.
     * */
    private static void makeslippery(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.makeSlippery()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
    /**
     * Function for saving the results of a test.
     * The fuction compares the output of the game to the expected output.
     * The result of the comparison is shown on the console.
     * */
    private static void save(String[] cmd) {
        try (PrintWriter out = new PrintWriter(cmd[1].replace(".in", ".out"))) {
            for (int i = 0; i < outResults.size(); i++) {
                out.println(outResults.get(i));
            }
        }
        catch(FileNotFoundException e) {
           
        }
        try {
            Scanner scannerResult = new Scanner(new File(cmd[1]));
            Scanner scannerExpected = new Scanner((new File(cmd[1].replace(".out", ".test"))));
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> expected = new ArrayList<>();
            while (scannerResult.hasNextLine()){
                result.add(scannerResult.nextLine().strip());
            }
            while (scannerExpected.hasNextLine()){
                expected.add(scannerExpected.nextLine().strip());
            }
            String separator = "\\";
            String[] tmp=cmd[1].replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            fileName = tmp[tmp.length-1];
            System.out.println("Test name: " + fileName.replace(".out", ""));
            if (result.size() != expected.size()) {
                System.out.println("Test failed. The 2 files do not have the same amount of lines.");
                return;
            }
            int errors = 0;
            if (result.size() > 0 && expected.size() > 0) {
                for (int i = 0; i < expected.size(); i++) {
                    if (!result.get(i).equals(expected.get(i))) {
                        System.out.println("Error in line " + (i+1) + ".\nExpected: " + expected.get(i) + ", but got: " + result.get(i));
                        errors++;
                    }
                }
            }
            if (errors == 0 && result.size() > 0 && expected.size() > 0) {
                System.out.println("Test succeeded.\n");
            }
            else {
                System.out.println("Test failed.\n");
            }
            pipes=pumps=0;
            waterCounter.reset();
            objectNames.clear();
            objectReverseNames.clear();
        }
        catch(FileNotFoundException e) {
            
        }
        outResults.clear();
    }
    /**
     * Function for doing all the tests.
     * */
    private static void testAll(String[] cmd) {
        try {
            Scanner scanner = new Scanner(new File(cmd[1] + "\\Alltests.txt"));
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                load(cmd[1] + "\\" + line);
            }
        } catch (FileNotFoundException e) {
           
          
        }
    }
    /**
     * Function for listing all objects in the game.
     * */
    private static void list(String[] cmd){
        for (Object obj : objectNames.values()) {
            System.out.print(objectReverseNames.get(obj) + " ");
        }
    }
    /**
     * Function for putting a player on a field.
     * */
    private static void addplayer(String[] cmd) {
        Field f = (Field) objectNames.get(cmd[1]);
        Player p = (Player) objectNames.get(cmd[2]);
        if(f.accept(p) != null) {
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private static void step(String[] cmd){
        Steppable s = (Steppable)objectNames.get(cmd[1]);
        s.step();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for ending a turn.
     * Responsible for calling the step function for all steppable objects.
     * */
    private static void endturn(String[] cmd){
        //elvégzi a kör végével járó lépéseket (vízszámolás, objektumok step függvényének hívása stb…)
        //vízszámlálás
        //water counter lehet hogy üres
        waterCounter.count();
        //léptetés

        Iterator<Object> iter = objectNames.values().iterator();
        //Iterator iter = objectNames.entrySet().iterator();
        int i = 1;
        while(iter.hasNext()) {
            Object obj = iter.next();
            if (obj instanceof Steppable) {
                Steppable value = (Steppable) obj;
                value.step();

                System.out.println("asd" + i++ + " " + objectReverseNames.get(obj));
            }
            iter.remove();
        }
       /* int i = 0;
         for (Object obj : objectNames.values()) {
            if(obj instanceof Steppable) {
                Steppable value = (Steppable)obj;
                value.step();
                System.out.println(i++);
            }
        }*/
        System.out.println("Sikeres művelet");
    }
    /**
     * Function for countig the points for the two sides.
     * */
    private static void count(String[] cmd){
        waterCounter.count();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for restaring the game.
     * */
    private static void restart(String[] cmd){
        //TODO
        random = true;
        objectNames.clear();
        objectReverseNames.clear();
        waterCounter.reset();
        test = false;
        pumps=pipes=0;
        System.out.println("Sikeres művelet");
        if(!test) gameMode = false;
    }
    /**
     * Function for putting the game into test mode.
     * */
    private static void test(String[] cmd){
        if(cmd[1].equals("true")) test=true;
        else if(cmd[1].equals("false")) test=false;
        System.out.println("Sikeres művelet");
    }
    /**
     * Function for signaling to the watercounter that the game ended.
     * */
    private static void setend(String[] cmd){
        waterCounter.setEnd();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }
    /**
     * Function for setting the in/out pipes of a pump.
     * */
    private static void setpump(String[] cmd){
        Pump pump = (Pump)objectNames.get(cmd[1]);
        if(pump.set((Pipe)objectNames.get(cmd[2]), (Pipe)objectNames.get(cmd[3]))){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }
}
