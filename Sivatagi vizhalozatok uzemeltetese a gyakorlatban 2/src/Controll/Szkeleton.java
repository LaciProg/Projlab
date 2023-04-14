package Controll;

import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.ActiveFields.Spring;
import Fields.Pipe;
import Players.Mechanic;
import Players.Saboteur;

import java.io.IOException;
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
            listTestNames();
            switch (testcase) {
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
                default: break;
            }
            testcase = scanner.nextInt();
        }
    }

    public static void listTestNames() {
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
        Saboteur sab = new Saboteur(goodPipe);
        objectNames.put(sab, "sab");
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
        Saboteur sab = new Saboteur(cistern);
        objectNames.put(sab, "sab");
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
        Mechanic mechanic = new Mechanic(brokenPipe);
        objectNames.put(mechanic, "mechanic");
        boolean result;

        System.out.println("\nTest:");
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairPump() {
        System.out.println("RepairPump\n");
        System.out.println("Initialization:");

        Pump brokenPump = new Pump();
        objectNames.put(brokenPump, "brokenPump");
        Mechanic mechanic = new Mechanic(brokenPump);
        objectNames.put(mechanic, "mechanic");
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
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");
        boolean result;

        System.out.println("\nTest:");
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestPlacePumpOnPipe() {
        System.out.println("PlacePumpOnPipe\n");
        System.out.println("Initialization:");

        Pump oldPump = new Pump();
        objectNames.put(oldPump, "oldPump");
        Pump newPump = new Pump();
        objectNames.put(newPump, "newPump");
        Pipe oldPipe = new Pipe(71);
        objectNames.put(oldPipe, "oldPipe");
        oldPipe.connect(oldPump);
        Mechanic mechanic = new Mechanic(oldPipe);
        objectNames.put(mechanic, "mechanic");

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
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");

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
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");

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
        Mechanic mechanic = new Mechanic(pipe);
        objectNames.put(mechanic, "mechanic");

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

    public static void TestWaterFlowsToCistern() {
        System.out.println("WaterFlowsToCistern\n");

        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestDisconnectPipe() {
        System.out.println("DisconnectPipe\n");

        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestConnectPipe() {
        System.out.println("ConnectPipe\n");

        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestPickUpPipeFromCistern() {
        System.out.println("PickUpPipeFromCistern\n");

        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestWorkingPumpPumping() {
        System.out.println("WorkingPumpPumping\n");


        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestBrokenPumpPumping() {
        System.out.println("BrokenPumpPumping\n");


        System.out.println("Initialization:");


        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPipeToPump() {
        System.out.println("MechanicMoveFromPipeToPump\n");

        System.out.println("Initialization:");

        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPumpToPipe() {
        System.out.println("MechanicMoveFromPumpToPipe\n");

        System.out.println("Initialization:");

        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestMechanicMoveFromPumpToOccupiedPipe() {
        System.out.println("MechanicMoveFromPumpToOccupiedPipe\n");

        System.out.println("Initialization:");

        System.out.println("\nTest:");

        objectNames.clear();
    }

    public static void TestSetPump() {
        System.out.println("SetPump\n");

        System.out.println("Initialization:");

        System.out.println("\nTest:");

        objectNames.clear();
    }
}