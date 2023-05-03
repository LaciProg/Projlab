package Controll;

import Fields.Pipe;
import Fields.ActiveFields.*;

import java.util.HashMap;
import java.util.Scanner;

public class Controller {

    public static HashMap<String, Object> objectNames = new HashMap<>();
    public static HashMap<Object, String> objectReverseNames = new HashMap<>();

    public void Run(){
        while(true) {
            Scanner stdInScanner = new Scanner(System.in);
            //Scanner fileScanner = new Scanner();

            String line = stdInScanner.nextLine();
            String cmd[] = line.split(" ");

            switch(cmd[0]) {
                case("load"): break;
                case("pipe"): break;
                case("pump"): pump(cmd); break;
                case("cistern"): cistern(cmd); break;
                case("spring"): break;
                case("mechanic"): break;
                case("saboteur"): break;
                case("connectpipe"): break;
                case("random"): break;
                case("create"): create(cmd); break;
                case("show"): break;
                case("showobject"): showobject(cmd); break;
                case("move"): break;
                case("breakfield"): break;
                case("repair"): break;
                case("placepump"): break;
                case("set"): break;
                case("disconnect"): break;
                case("connect"): break;
                case("getpump"): break;
                case("pickuppipe"): break;
                case("makesticky"): break;
                case("makeslippery"): break;
                case("save"): break;
                case("list"): break;
                case("addplayer"): break;
                case("step"): break;
                case("endturn"): break;
                case("count"): break;
                case("test"): break;
                case("setend"): break;
                case("setpump"): break;
                case("restart"): break;
                case("exit"): return; //System.exit(0); break;
            }
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
        System.out.println("Sikeres művelet");
    }

    private void pipe(String[] cmd){
        Pipe tmp = new Pipe(Integer.parseInt(cmd[2]));
        String[][] commands = new String[cmd.length-3][2];
        for(int i=3; i<cmd.length; i++){
            commands[i-3] = cmd[i].split(":");
        }
        for(int i=0; i<commands.length; i++){
            switch (commands[0][0]){
                //case "fluid": tmp.setFluid(Integer.parseInt(commands[i][1])); break;
                //case "rfluidtime": tmp.setFluidTime(Integer.parseInt(commands[i][2])); break;
                case "breakable": tmp.setWater(Integer.parseInt(commands[0][1])); break;
                //case "broken": tmp.setWater(Integer.parseInt(commands[0][1])); break;
                //case "water": tmp.setWater(Integer.parseInt(commands[0][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        System.out.println("Sikeres művelet");
    }

    private void cistern(String[] cmd){
        Cistern tmp = new Cistern();
        String[][] commands = new String[cmd.length-2][2];
        for(int i=2; i<cmd.length; i++){
            commands[i-2] = cmd[i].split(":");
        }
        for(int i=0; i<commands.length; i++) {
            switch (commands[0][0]) {
                case "water":
                    tmp.setWater(Integer.parseInt(commands[0][1])); break;
            }
        }
        objectNames.put(cmd[1], tmp);
        objectReverseNames.put(tmp, cmd[1]);
        System.out.println("Sikeres művelet");
    }

    private void create(String[] cmd) {
        System.out.println("A pálya létrehozása sikeresen lezajlott. Kezdődhet a játék!");
    }

    private void showobject(String[] cmd){
        Object object = objectNames.get(cmd[1]);
        System.out.println(object);
    }
}
