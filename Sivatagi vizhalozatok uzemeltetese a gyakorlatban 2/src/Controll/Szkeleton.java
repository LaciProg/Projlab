package Controll;

import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.ActiveFields.Spring;
import Fields.Pipe;
import Players.Mechanic;
import Players.Saboteur;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Szkeleton class for testing purposes.
 * It contains the main method.
 * */


@SuppressWarnings("DuplicatedCode")
public class Szkeleton {
    public static int tabs = 0;
    public static int testcase = -1;

    public static HashMap<Object, String> objectNames = new HashMap<>();

    /**
     * Main method.
     * @param args String[]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        listTestNames();
        testcase = scanner.nextInt();
        while (testcase != 0) {
            switch (testcase) {
                case(-1): listTestNames(); break;
                case (1): TestBreakPipe(); break;
                case (2): TestBreakCistern(); break;
                case (3): TestRepairPipe(); break;
                case (4): TestRepairPump(); break;
                case (5): TestRepairCistern(); break;
                case (6): TestPlacePumpOnPipe(); break;
                case (7): TestPlacePumpOnCistern(); break;
                case (8): TestPickUpPumpFromCistern(); break;
                case (9): TestPickUpPumpFromPipe(); break;
                case (10): TestWaterFlowsFromSpring(); break;
                case (11): TestWaterFlowsToCistern(); break;
                case (12): TestDisconnectPipe(); break;
                case (13): TestConnectPipe(); break;
                case (14): TestPickUpPipeFromCistern(); break;
                case (15): TestWorkingPumpPumping(); break;
                case (16): TestBrokenPumpPumping(); break;
                case (17): TestMechanicMoveFromPipeToPump(); break;
                case (18): TestMechanicMoveFromPumpToPipe(); break;
                case (19): TestMechanicMoveFromPumpToOccupiedPipe(); break;
                case (20): TestSetPump(); break;
                case (21): TestSaboteurMoveFromPipeToPump(); break;
                case (22): TestSaboteurMoveFromPumpToPipe(); break;
                case (23): TestSaboteurMoveFromPumpToOccupiedPipe(); break;
                case (24): TestWaterFlowsToFullPipe(); break;
                case (25): TestWaterFlowsToEmptyPipe(); break;
                case (26): TestWaterFlowsToBrokenPipe(); break;
                case (27): TestWaterFlowsToDisconnectedPipe(); break;
                case (28): TestPumpBreak100Chance(); break;
                case (29): TestSaboteursGetsPoints(); break;
                case (30): TestMechanicGetsPoints(); break;
                default: break;
            }
            testcase = scanner.nextInt();
        }
    }

    public static void listTestNames() {
        System.out.println("-1. Test Case List");
        System.out.println("0. Exit");
        System.out.println("1. BreakPipe");
        System.out.println("2. BreakCistern");
        System.out.println("3. RepairPipe");
        System.out.println("4. RepairPump");
        System.out.println("5. RepairCistern");
        System.out.println("6. PlacePumpOnPipe");
        System.out.println("7. PlacePumpOnCistern");
        System.out.println("8. PickUpPumpFromCistern");
        System.out.println("9. PickUpPumpFromPipe");
        System.out.println("10. WaterFlowsFromSpring");
        //TODO Csak függvények
        System.out.println("11. WaterFlowsToCistern");
        System.out.println("12. DisconnectPipe");
        System.out.println("13. ConnectPipe");
        System.out.println("14. PickUpPipeFromCistern");
        System.out.println("15. WorkingPumpPumping");
        System.out.println("16. BrokenPumpPumping");
        System.out.println("17. MechanicMoveFromPipeToPump");
        System.out.println("18. MechanicMoveFromPumpToPipe");
        System.out.println("19. MechanicMoveFromPumpToOccupiedPipe");
        System.out.println("20. SetPump");
        //TODO szekvenciák is
        System.out.println("21. SaboteurMoveFromPipeToPump");
        System.out.println("22. SaboteurMoveFromPumpToPipe");
        System.out.println("23. SaboteurMoveFromPumpToOccupiedPipe");
        System.out.println("24. WaterFlowsToFullPipe");
        System.out.println("25. WaterFlowsToEmptyPipe");
        System.out.println("26. WaterFlowsToBrokenPipe");
        System.out.println("27. WaterFlowsToDisconnectedPipe");
        System.out.println("28. PumpBreak100%Chance");
        System.out.println("29. SaboteursGetsPoints");
        System.out.println("30. MechanicGetsPoints");
    }

    public static void printTabs() {
        for (int i = 0; i < Szkeleton.tabs; i++) {
            System.out.print("\t");
        }
    }

    public static void TestBreakPipe() {
        System.out.println("BreakPipe\n");

        System.out.println("Initialization:");
        Pipe goodPipe = new Pipe(34);
        objectNames.put(goodPipe, "goodPipe");
        Saboteur sab = new Saboteur();
        objectNames.put(sab, "sab");
        sab.setStandingField(goodPipe);
        boolean result;
        System.out.println("\nTest:");

        result = sab.breakField();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestBreakCistern() {
        System.out.println("BreakCistern\n");
        System.out.println("Initialization:");

        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Saboteur sab = new Saboteur();
        objectNames.put(sab, "sab");
        sab.setStandingField(cistern);
        boolean result;

        System.out.println("\nTest:");
        result = sab.breakField();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairPipe() {
        System.out.println("RepairPipe\n");
        System.out.println("Initialization:");

        Pipe brokenPipe = new Pipe(71);
        objectNames.put(brokenPipe, "brokenPipe");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(brokenPipe);
        boolean result;

        System.out.println("\nTest:");
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairPump() {
        System.out.println("RepairPump\n");
        System.out.println("Initialization:");

        Pump brokenPump = new Pump(100);
        objectNames.put(brokenPump, "brokenPump");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(brokenPump);
        boolean result;

        System.out.println("\nTest:");
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairCistern() {
        System.out.println("RepairCistern\n");
        System.out.println("Initialization:");

        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(cistern);
        boolean result;

        System.out.println("\nTest:");
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestPlacePumpOnPipe() {
        System.out.println("PlacePumpOnPipe\n");
        System.out.println("Initialization:");

        Pump oldPump = new Pump(100);
        objectNames.put(oldPump, "oldPump");
        Pump newPump = new Pump(100);
        objectNames.put(newPump, "newPump");
        Pipe oldPipe = new Pipe(71);
        objectNames.put(oldPipe, "oldPipe");
        oldPipe.connect(oldPump);
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(oldPipe);


        System.out.println("\nTest:");
        mechanic.setHoldingPump(newPump);
        Pipe newPipe = mechanic.placePump();
        System.out.println(newPipe);
        objectNames.clear();
    }

    public static void TestPlacePumpOnCistern() {
        System.out.println("PlacePumpOnCistern\n");
        System.out.println("Initialization:");

        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(cistern);

        System.out.println("\nTest:");
        Pipe newPipe = mechanic.placePump();
        System.out.println(newPipe);
        objectNames.clear();
    }

    public static void TestPickUpPumpFromCistern() {
        System.out.println("PickUpPumpFromCistern\n");
        System.out.println("Initialization:");

        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(cistern);

        System.out.println("\nTest:");
        Pump newPump = mechanic.getPump();
        System.out.println(newPump);
        objectNames.clear();
    }

    public static void TestPickUpPumpFromPipe() {
        System.out.println("PickUpPumpFromPipe\n");
        System.out.println("Initialization:");

        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        mechanic.setStandingField(pipe);

        System.out.println("\nTest:");
        Pump newPump = mechanic.getPump();
        System.out.println(newPump);
        objectNames.clear();
    }

    public static void TestWaterFlowsFromSpring() {
        System.out.println("WaterFlowsFromSpring\n");

        System.out.println("Initialization:");
        Spring spring = new Spring(200);
        objectNames.put(spring, "spring");
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        spring.addPipe(pipe);
        pipe.connect(spring);

        System.out.println("\nTest:");
        spring.step();
        objectNames.clear();
    }

    //Csuti innentől
    public static void TestWaterFlowsToCistern() {
        System.out.println("WaterFlowsToCistern\n");

        System.out.println("Initialization:");
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        cistern.addPipe(pipe);
        pipe.connect(cistern);


        System.out.println("\nTest:");
        cistern.step();

        objectNames.clear();
    }

    public static void TestDisconnectPipe() {
        System.out.println("DisconnectPipe\n");

        System.out.println("Initialization:");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Pump standingField = new Pump(100);
        objectNames.put(standingField, "standingField");
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        standingField.addPipe(pipe);
        pipe.connect(standingField);
        mechanic.setStandingField(standingField);
        standingField.accept(mechanic);


        System.out.println("\nTest:");
        boolean returned = mechanic.disconnect(pipe);
        System.out.println(returned);

        objectNames.clear();
    }

    public static void TestConnectPipe() {
        System.out.println("ConnectPipe\n");

        System.out.println("Initialization:");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Pump standingField = new Pump(100);
        objectNames.put(standingField, "standingField");
        Pipe holdingPipe = new Pipe(65);
        objectNames.put(holdingPipe, "holdingPipe");
        standingField.addPipe(holdingPipe);
        holdingPipe.connect(standingField);
        mechanic.setStandingField(standingField);
        mechanic.disconnect(holdingPipe);

        System.out.println("\nTest:");
        boolean returned = mechanic.connect();
        System.out.println(returned);

        objectNames.clear();
    }

    public static void TestPickUpPipeFromCistern() {
        System.out.println("PickUpPipeFromCistern\n");

        System.out.println("Initialization:");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        mechanic.setStandingField(cistern);
        cistern.accept(mechanic);

        System.out.println("\nTest:");
        boolean returned = mechanic.pickUpPipe();
        System.out.println(returned);

        objectNames.clear();
    }

    public static void TestWorkingPumpPumping() {
        System.out.println("WorkingPumpPumping\n");


        System.out.println("Initialization:");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        Pipe from = new Pipe(65);
        objectNames.put(from, "from");
        Pipe to = new Pipe(65);
        objectNames.put(to, "to");
        pump.addPipe(from);
        from.connect(pump);
        pump.addPipe(to);
        to.connect(pump);
        pump.set(from, to);

        System.out.println("\nTest:");
        pump.step();

        objectNames.clear();
    }

    public static void TestBrokenPumpPumping() {
        System.out.println("BrokenPumpPumping\n");


        System.out.println("Initialization:");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        Pipe from = new Pipe(65);
        objectNames.put(from, "from");
        Pipe to = new Pipe(65);
        objectNames.put(to, "to");
        pump.addPipe(from);
        from.connect(pump);
        pump.addPipe(to);
        to.connect(pump);
        pump.set(from, to);
        pump.setBroken(true);

        System.out.println("\nTest:");
        pump.step();

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPipeToPump() {
        System.out.println("MechanicMoveFromPipeToPump\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        pump.addPipe(pipe);
        mechanic.setStandingField(pipe);
        pipe.accept(mechanic);


        System.out.println("\nTest:");
        boolean ret = mechanic.move(pump);
        System.out.println(ret);

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPumpToPipe() {
        System.out.println("MechanicMoveFromPumpToPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        pump.addPipe(pipe);
        mechanic.setStandingField(pump);
        pump.accept(mechanic);

        System.out.println("\nTest:");
        boolean ret = mechanic.move(pipe);
        System.out.println(ret);

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPumpToOccupiedPipe() {
        System.out.println("MechanicMoveFromPumpToOccupiedPipe\n");

        System.out.println("Initialization:");
        //objektumok létrehozása
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic, "mechanic");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        Saboteur saboteur = new Saboteur();
        objectNames.put(saboteur, "saboteur");
        //cső-pumpa összekötése
        pipe.connect(pump);
        pump.addPipe(pipe);
        saboteur.setStandingField(pipe);	//sabotőr rááll a csőre
        pipe.accept(saboteur);
        mechanic.setStandingField(pump);	//mechanic pedig a pumpára
        pump.accept(mechanic);


        System.out.println("\nTest:");
        boolean ret = mechanic.move(pipe);
        System.out.println(ret);

        objectNames.clear();
    }

    public static void TestSetPump() {
        System.out.println("SetPump\n");

        System.out.println("Initialization:");
        //objektumok létrehozása
        Mechanic mechanic = new Mechanic();
        objectNames.put(mechanic , "mechanic");
        Pump pump = new Pump(100);
        objectNames.put(pump , "pump");
        Pipe oldinput = new Pipe(65);
        objectNames.put(oldinput , "oldinput");
        Pipe oldoutput = new Pipe(65);
        objectNames.put(oldoutput , "oldoutput");
        Pipe input = new Pipe(65);
        objectNames.put(input , "input");
        Pipe output = new Pipe(65);
        objectNames.put(output , "output");
        //szerelő rááll a pumpára
        mechanic.setStandingField(pump);
        pump.accept(mechanic);
        //pumpa - csövek összeközése
        pump.addPipe(oldinput);
        pump.addPipe(oldoutput);
        pump.addPipe(input);
        pump.addPipe(output);
        pump.set(oldinput, oldoutput);
        oldinput.connect(pump);
        oldoutput.connect(pump);
        input.connect(pump);
        output.connect(pump);

        System.out.println("\nTest:");
        boolean ret = mechanic.set(input, output);
        System.out.println(ret);

        objectNames.clear();
    }
    //Csuti idáig
    
    public static void TestSaboteurMoveFromPipeToPump() {
        System.out.println("SaboteurMoveFromPipeToPump\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(20);
        objectNames.put(pipe, "pipe");
        Saboteur saboteur = new Saboteur();
        saboteur.setStandingField(pipe);
        objectNames.put(saboteur, "saboteur");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        pump.addPipe(pipe);
        boolean result;
        
        System.out.println("\nTest:");
        result = saboteur.move(pump);
        System.out.println(result);
        objectNames.clear();
    }
    
    public static void TestSaboteurMoveFromPumpToPipe() {
        System.out.println("SaboteurMoveFromPumpToPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(48);
        objectNames.put(pipe, "pipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        Saboteur saboteur = new Saboteur();
        saboteur.setStandingField(pump);
        objectNames.put(saboteur, "saboteur");
        pipe.connect(pump);
        pump.addPipe(pipe);
        boolean result;
        
        System.out.println("\nTest:");
        result = saboteur.move(pipe);
        System.out.println(result);
        objectNames.clear();
    }
    
    public static void TestSaboteurMoveFromPumpToOccupiedPipe() {
        System.out.println("SaboteurMoveFromPumpToOccupiedPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(44);
        objectNames.put(pipe, "pipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        Saboteur saboteur = new Saboteur();
        saboteur.setStandingField(pump);
        objectNames.put(saboteur, "saboteur");
        pipe.connect(pump);
        pump.addPipe(pipe);
        pipe.setOccupied(true);
        boolean result;
        
        System.out.println("\nTest:");
        result = saboteur.move(pipe);
        System.out.println(result);
        objectNames.clear();
    }
    
    public static void TestWaterFlowsToFullPipe() {
        System.out.println("WaterFlowsToFullPip\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(50);
        objectNames.put(pipe, "pipe");
        Pipe fullPipe = new Pipe(40);
        objectNames.put(fullPipe, "fullPipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        fullPipe.connect(pump);
        pump.addPipe(pipe);
        pump.addPipe(fullPipe);
        pump.set(pipe, fullPipe);
        fullPipe.setWater(40);
        
        System.out.println("\nTest:");
        pump.step();
        objectNames.clear();
    }
    
    public static void TestWaterFlowsToEmptyPipe() {
        System.out.println("WaterFlowsToEmptyPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(50);
        objectNames.put(pipe, "pipe");
        Pipe emptyPipe = new Pipe(40);
        objectNames.put(emptyPipe, "emptyPipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        emptyPipe.connect(pump);
        pump.addPipe(pipe);
        pump.addPipe(emptyPipe);
        pump.set(pipe, emptyPipe);
        emptyPipe.setWater(0);
        
        System.out.println("\nTest:");
        pump.step();
        objectNames.clear();
    }

    public static void TestWaterFlowsToBrokenPipe() {
        System.out.println("WaterFlowsToBrokenPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(50);
        objectNames.put(pipe, "pipe");
        Pipe brokenPipe = new Pipe(40);
        objectNames.put(brokenPipe, "brokenPipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        brokenPipe.connect(pump);
        pump.addPipe(pipe);
        pump.addPipe(brokenPipe);
        pump.set(pipe, brokenPipe);
        brokenPipe.setWater(0);

        System.out.println("\nTest:");
        pump.step();
        objectNames.clear();
    }

    public static void TestWaterFlowsToDisconnectedPipe() {
        System.out.println("WaterFlowsToDisconnectedPipe\n");

        System.out.println("Initialization:");
        Pipe pipe = new Pipe(50);
        objectNames.put(pipe, "pipe");
        Pipe disconnectedPipe = new Pipe(40);
        objectNames.put(disconnectedPipe, "disconnectedPipe");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");
        pipe.connect(pump);
        disconnectedPipe.connect(pump);
        pump.addPipe(pipe);
        pump.addPipe(disconnectedPipe);
        pump.set(pipe, disconnectedPipe);
        disconnectedPipe.setWater(0);

        System.out.println("\nTest:");
        pump.step();
        objectNames.clear();
    }

    public static void TestPumpBreak100Chance() {
        System.out.println("TestPumpBreak100%Chance\n");

        System.out.println("Initialization:");
        Pump pump = new Pump(100);
        objectNames.put(pump, "pump");

        System.out.println("\nTest:");
        boolean result = pump.breakField(); // Ez a step függvényben lesz később implementálva. Ez a teszteset azt mutatja, hogy el lehet törni egy pumpát.
        System.out.println(result); //TODO
        objectNames.clear();
    }

    public static void TestSaboteursGetsPoints() {
        System.out.println("TestSabouteursGetPoints\n");
        System.out.println("Initialization:");
        WaterCounter waterCounter = new WaterCounter();
        objectNames.put(waterCounter, "waterCounter");
        Pipe goodPipe = new Pipe(50);
        objectNames.put(goodPipe, "goodPipe");
        Pipe brokenPipe = new Pipe(50);
        objectNames.put(brokenPipe, "brokenPipe");
        brokenPipe.breakField();
        Pipe disconnectedPipe = new Pipe(50);
        objectNames.put(disconnectedPipe, "disconnectedPipe");
        Pump p1 = new Pump(100);
        objectNames.put(p1, "p1");
        Pump p2 = new Pump(100);
        objectNames.put(p2, "p2");
        goodPipe.setWater(12);
        brokenPipe.setWater(21);
        disconnectedPipe.setWater(30);
        p1.addPipe(goodPipe);
        goodPipe.connect(p1);
        p1.addPipe(brokenPipe);
        brokenPipe.connect(p1);
        p1.addPipe(disconnectedPipe);
        disconnectedPipe.connect(p1);
        p2.addPipe(goodPipe);
        goodPipe.connect(p2);
        p2.addPipe(brokenPipe);
        brokenPipe.connect(p2);
        waterCounter.addPipe(goodPipe);
        waterCounter.addPipe(brokenPipe);
        waterCounter.addPipe(disconnectedPipe);

        System.out.println("\nTest:");
        waterCounter.count();
        objectNames.clear();
    }

    public static void TestMechanicGetsPoints() {
        System.out.println("TestMechanicsGetPoints\n");
        System.out.println("Initialization:");
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        WaterCounter waterCounter = new WaterCounter();
        objectNames.put(waterCounter, "waterCounter");
        waterCounter.addCistern(cistern);
        waterCounter.setEnd();

        System.out.println("\nTest:");
        waterCounter.count();
        objectNames.clear();
    }


}