package Controll;

import Enums.Fluid;
import Fields.Field;
import Fields.Pipe;
import Fields.ActiveFields.*;
import Interfaces.Steppable;
import Players.Mechanic;
import Players.Player;
import Players.Saboteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

@SuppressWarnings("DuplicatedCode")
public class Controller {
    private static boolean random = true;
    public static boolean isRandom() {return random; }
    public static HashMap<String, Object> objectNames = new HashMap<>();
    public static HashMap<Object, String> objectReverseNames = new HashMap<>();
    private static WaterCounter waterCounter = new WaterCounter();
    private static boolean test = false;

    public static boolean isTest() {return test;}
    private static String fileName="";

    private static String filePath="";

    private static ArrayList<String> outResults = new ArrayList<>();

    ArrayList<String> commandList = new ArrayList<>();

    public static int pipes=0;
    public static int pumps=0;

    public void Run() throws FileNotFoundException {
        while(true) {
            Scanner stdInScanner = new Scanner(System.in);
            if (commandList.size() == 0){
                commandList.add(stdInScanner.nextLine());
            }
            String command = commandList.get(0);
            commandList.remove(0);
            String[] cmd = command.split(" ");
            switch(cmd[0]) {
                case("load"): load(cmd); /*if(test) {save(cmd);}*/ break;
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
                /*case("testall"): testAll(cmd); break;*/
                case("list"): list(cmd); break;
                case("addplayer"): addplayer(cmd); break;
                case("step"): step(cmd); break;
                case("endturn"): endturn(cmd); break;
                case("count"): count(cmd); break;
                case("test"): test(cmd); break;
                case("setend"): setend(cmd); break;
                case("setpump"): setpump(cmd); break;
                case("restart"): restart(cmd); break;
                case("exit"): return; //System.exit(0); break;
            }
        }
    }

    private void load(String[] cmd){
        try {
            //System.out.println("ITT");
            //System.out.println(cmd[1] + "\n");
            outResults.clear();
            Scanner scanner = new Scanner(new File(cmd[1]));
            filePath = cmd[1];
            String separator = "\\";
            String[] tmp=cmd[1].replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            fileName = tmp[tmp.length-1];
            while (scanner.hasNextLine()){
                commandList.add(scanner.nextLine());
            }
            if (test) {
                commandList.add("save " + filePath.replace(".in", ".out"));
                //save(cmd);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Bánat");
        }
    }

    private void pump(String[] cmd){
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

    private void pipe(String[] cmd){
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
                case "rfluidtime": tmp.setFluidTime(Integer.parseInt(commands[i][2])); break;
                case "breakable": tmp.setBreakable(Integer.parseInt(commands[i][1])); break;
                case "broken": tmp.setBroken(Boolean.parseBoolean(commands[i][1])); break;
                case "water": tmp.setWater(Integer.parseInt(commands[i][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void cistern(String[] cmd){
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
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void spring(String[] cmd){
        Spring tmp = new Spring(Integer.parseInt(cmd[2]));
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void saboteur(String[] cmd){
        Saboteur tmp = new Saboteur();
        Field f = (Field)objectNames.get(cmd[2]);
        tmp.setStandingField(f);
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void mechanic(String[] cmd){
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
    }

    private void connectpipe(String[] cmd){
        Pipe pipe = (Pipe)objectNames.get(cmd[1]);
        ActiveFields activeField = (ActiveFields)objectNames.get(cmd[2]);
        pipe.setFields(activeField);
        activeField.addPipe(pipe);
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void random(String[] cmd){
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
    private void create(String[] cmd) {
        if (test) outResults.add("A pálya létrehozása sikeresen lezajlott. Kezdődhet a játék!");
        else System.out.println("A pálya létrehozása sikeresen lezajlott. Kezdődhet a játék!");
    }

    private void show(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        String[] commands = cmd[2].split(":");
        switch (commands[1]){
            case "player":
                if (test) outResults.add(p.toString()); //TODO jó-e így?
                else System.out.println(p);
                //System.out.println(p);
                break;
            case "field":
                if (test) outResults.add(objectReverseNames.get(p.getStandingField()).toString()); //TODO jó-e így?
                else System.out.println(objectReverseNames.get(p.getStandingField()));
                break;
        }
    }

    private void showobject(String[] cmd){
        Object object = objectNames.get(cmd[1]);
        //System.out.println(cmd[1]);
        if (test) outResults.add(object.toString());
        else System.out.println(object.toString()); //TODO tesztre
    }

    private void move(String[] cmd){
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

    private void breakfield(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        if(p.breakField()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void repair(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        if(p.repair()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void placepump(String[] cmd){
        Player p = (Player)objectNames.get(cmd[1]);
        Pipe pipe = p.placePump();
        if(pipe != null ){
            pipes++;
            String s = "newPipe"+pipes;
            objectNames.put(s, pipe);
            objectReverseNames.put(pipe, s);
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void set(String[] cmd){
         Player player = (Player)objectNames.get(cmd[1]);
         if(player.getStandingField().set((Pipe)objectNames.get(cmd[2]), (Pipe)objectNames.get(cmd[3]))){
             if (test) outResults.add("Sikeres művelet");
             else System.out.println("Sikeres művelet");
         }else  {
             if (test) outResults.add("Sikertelen művelet");
             else System.out.println("Sikertelen művelet");
         }
    }

    private void disconnect(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.disconnect((Pipe)objectNames.get(cmd[2]))){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void connect(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.connect()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void getpump(String[] cmd){
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

    private void pickuppipe(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.pickUpPipe()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void makesticky(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.makeSticky()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void makeslippery(String[] cmd){
        Player player = (Player)objectNames.get(cmd[1]);
        if(player.makeSlippery()){
            if (test) outResults.add("Sikeres művelet");
            else System.out.println("Sikeres művelet");
        }else  {
            if (test) outResults.add("Sikertelen művelet");
            else System.out.println("Sikertelen művelet");
        }
    }

    private void save(String[] cmd) {
        try (PrintWriter out = new PrintWriter(cmd[1].replace(".in", ".out"))) {
            for (int i = 0; i < outResults.size(); i++) {
                out.println(outResults.get(i));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Nagyobb bánat");
        }
        try {
            Scanner scannerResult = new Scanner(new File(filePath.replace(".in", ".out")));
            Scanner scannerExpected = new Scanner(new File(filePath.replace(".in", ".test")));
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> expected = new ArrayList<>();
            while (scannerResult.hasNextLine()){
                result.add(scannerResult.nextLine().strip());
            }
            while (scannerExpected.hasNextLine()){
                expected.add(scannerExpected.nextLine().strip());
            }
            System.out.println("Test name: " + fileName.replace(".in", ""));
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
        }
        catch(FileNotFoundException e) {
            System.out.println("Még nagyobb bánat");
        }
    }

    //TODO lehetőség az összes teszt meghivására, nem követelmény szóval csak ha lesz rá idő xd
    /*private void testAll(String[] cmd) {
        commandList.add("load " + cmd[1] + "\\1SaboteurBreakPipe.in");
        commandList.add("save " + cmd[1] + "\\1SaboteurBreakPipe.out");
        commandList.add("load " + cmd[1] + "\\2BreakCistern.in");
        commandList.add("save " + cmd[1] + "\\2BreakCistern.out");
        commandList.add("load " + cmd[1] + "\\3RepairPipe.in");
        commandList.add("save " + cmd[1] + "\\3RepairPipe.out");
        String[] tmp = {"load", cmd[1] + "\\1SaboteurBreakPipe.in"};
        load(tmp);
        tmp[1] = cmd[1] + "\\2BreakCistern.in";
        load(tmp);
        tmp[1] = "\\3RepairPipe.in";
        load(tmp);
        //System.out.println(commandList);
    }*/

    private void list(String[] cmd){
        ArrayList<String> values = (ArrayList<String>)objectReverseNames.values();
        for(String s : values){
            System.out.print(s+" "); //TODO tesztre
        }
    }

    private void addplayer(String[] cmd) {
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

    private void step(String[] cmd){
        Steppable s = (Steppable)objectNames.get(cmd[1]);
        s.step();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void endturn(String[] cmd){
        //TODO
        System.out.println("Sikeres művelet");
    }

    private void count(String[] cmd){
        waterCounter.count();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void restart(String[] cmd){
        pumps=pipes=0;
        objectNames.clear();
        objectReverseNames.clear();
        random = true;
        //TODO
        System.out.println("Sikeres művelet");
    }

    private void test(String[] cmd){
        if(cmd[1].equals("true")) test=true;
        else if(cmd[1].equals("false")) test=false;
        System.out.println("Sikeres művelet");
    }

    private void setend(String[] cmd){
        waterCounter.setEnd();
        if (test) outResults.add("Sikeres művelet");
        else System.out.println("Sikeres művelet");
    }

    private void setpump(String[] cmd){
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
