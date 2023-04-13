package Controll;

import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.Pipe;
import Players.Mechanic;
import Players.Saboteur;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Szkeleton class for testing purposes.
 * It contains the main method.
 * */
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
        testcase = scanner.nextInt();
        while (testcase != 0) {
            switch (testcase) {
                case (1) -> TestBreakPipe();
                case (2) -> TestBreakNotPipe();
                case (3) -> TestRepairPipe();
                case (4) -> TestRepairPump();
                case (5) -> TestRepairNotPipeAndPump();
                case (6) -> TestPlacePumpOnPipe();
                case (7) -> TestPlacePumpOnCistern();
                case (8) -> TestPickUpPumpFromCistern();
                case (9) -> TestPickUpPumpFromPipe();
                case (10) -> TestWaterFlowsFromSpring();
                case (11) -> TestWaterFlowsToCistern();
                case (12) -> TestDisconnectPipe();
                case (13) -> TestConnectPipe();
                case (14) -> TestPickUpPipeFromCistern();
                case (15) -> TestWorkingPumpPumping();
                case (16) -> TestBrokenPumpPumping();
                case (17) -> TestMechanicMoveFromPipeToPump();
                case (18) -> TestMechanicMoveFromPumpToPipe();
                case (19) -> TestMechanicMoveFromPumpToOccupiedPipe();
                case (20) -> TestSetPump();
            }
            testcase = scanner.nextInt();
        }
    }

    public static void printTabs() {
        for (int i = 0; i < Szkeleton.tabs; i++) {
            System.out.print("\t");
        }
    }

    public static void TestBreakPipe() {
        Pipe goodPipe = new Pipe(34);
        objectNames.put(goodPipe, "goodPipe");
        Saboteur sab = new Saboteur(goodPipe);
        objectNames.put(sab, "sab");
        boolean result;
        result = sab.breakField();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestBreakNotPipe() {
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Saboteur sab = new Saboteur(cistern);
        objectNames.put(sab, "sab");
        boolean result;
        result = sab.breakField();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairPipe() {
        Pipe brokenPipe = new Pipe(71);
        objectNames.put(brokenPipe, "brokenPipe");
        Mechanic mechanic = new Mechanic(brokenPipe);
        objectNames.put(mechanic, "mechanic");
        boolean result;
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairPump() {
        Pump brokenPump = new Pump();
        objectNames.put(brokenPump, "brokenPump");
        Mechanic mechanic = new Mechanic(brokenPump);
        objectNames.put(mechanic, "mechanic");
        boolean result;
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    public static void TestRepairNotPipeAndPump() {
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");
        boolean result;
        result = mechanic.repair();
        System.out.println(result);
        objectNames.clear();
    }

    //TODO ez még nem jó
    public static void TestPlacePumpOnPipe() {
        Pump oldPump = new Pump();
        objectNames.put(oldPump, "oldPump");
        Pump newPump = new Pump();
        objectNames.put(newPump, "newPump");
        Pipe oldPipe = new Pipe(71);
        objectNames.put(oldPipe, "oldPipe");
        oldPipe.connect(oldPump);
        Mechanic mechanic = new Mechanic(oldPipe);
        objectNames.put(mechanic, "mechanic");
        mechanic.setHoldingPump(newPump);
        Pipe newPipe = mechanic.placePump();
        objectNames.clear();
    }

    public static void TestPlacePumpOnCistern() {
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");
        Pipe newPipe = mechanic.placePump();
        objectNames.clear();
    }

    public static void TestPickUpPumpFromCistern() {
        Cistern cistern = new Cistern();
        objectNames.put(cistern, "cistern");
        Mechanic mechanic = new Mechanic(cistern);
        objectNames.put(mechanic, "mechanic");
        Pump newPump = mechanic.getPump();
        objectNames.clear();
    }

    public static void TestPickUpPumpFromPipe() {
        Pipe pipe = new Pipe(65);
        objectNames.put(pipe, "pipe");
        Mechanic mechanic = new Mechanic(pipe);
        objectNames.put(mechanic, "mechanic");
        Pump newPump = mechanic.getPump();
        objectNames.clear();
    }

    public static void TestWaterFlowsFromSpring() {}

    public static void TestWaterFlowsToCistern() {}

    public static void TestDisconnectPipe() {

    }

    public static void TestConnectPipe() {}

    public static void TestPickUpPipeFromCistern() {}

    public static void TestWorkingPumpPumping() {}

    public static void TestBrokenPumpPumping() {}

    public static void TestMechanicMoveFromPipeToPump() {}

    public static void TestMechanicMoveFromPumpToPipe() {}

    public static void TestMechanicMoveFromPumpToOccupiedPipe() {}

    public static void TestSetPump() {}
}