package Controll;

import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Players.Mechanic;
import Players.Saboteur;
import Fields.Pipe;

import java.io.IOException;
import java.util.Scanner;

/**
 * Szkeleton class for testing purposes.
 * It contains the main method.
 * */
public class Szkeleton {
    public static int tabs = 0;
    public static int testcase = -1;
    /**
     * Main method.
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        testcase = scanner.nextInt();
        while (testcase != 0) {
            switch(testcase) {
                case(0) : break;
                case(1) : TestBreakPipe(); break;
                case(2) : TestBreakNotPipe(); break;
                case(3) : TestRepairPipe(); break;
                case(4) : TestRepairPump(); break;
                case(5) : TestRepairNotPipeAndPump(); break;
                case(6) : TestPlacePumpOnPipe(); break;
                case(7) : TestPlacePumpOnCistern(); break;
                case(8) : TestPickUpPumpFromCistern(); break;
                case(9) : TestPickUpPumpFromPipe(); break;
                case(10) : TestWaterFlowsFromSpring(); break;
                case(11) : TestWaterFlowsToCistern(); break;
                case(12) : TestDisconnectPipe(); break;
                case(13) : TestConnectPipe(); break;
                case(14) : TestPickUpPipeFromCistern(); break;
                case(15) : TestWorkingPumpPumping(); break;
                case(16) : TestBrokenPumpPumping(); break;
                case(17) : TestMechanicMoveFromPipeToPump(); break;
                case(18) : TestMechanicMoveFromPumpToPipe(); break;
                case(19) : TestMechanicMoveFromPumpToOccupiedPipe(); break;
                case(20) : TestSetPump(); break;
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
        Saboteur sab = new Saboteur(goodPipe);
        boolean result = false;
        result = sab.breakField();
        System.out.println(result);
    }

    public static void TestBreakNotPipe() {
        Cistern cistern = new Cistern();
        Saboteur sab = new Saboteur(cistern);
        boolean result = false;
        result = sab.breakField();
        System.out.println(result);
    }

    public static void TestRepairPipe() {
        Pipe brokenPipe = new Pipe(71);
        Mechanic mechanic = new Mechanic(brokenPipe);
        boolean result = false;
        result = mechanic.repair();
        System.out.println(result);
    }

    public static void TestRepairPump() {
        Pump brokenPump = new Pump();
        Mechanic mechanic = new Mechanic(brokenPump);
        boolean result = false;
        result = mechanic.repair();
        System.out.println(result);
    }

    public static void TestRepairNotPipeAndPump() {
        Cistern cistern = new Cistern();
        Mechanic mechanic = new Mechanic(cistern);
        boolean result = false;
        result = mechanic.repair();
        System.out.println(result);
    }

    public static void TestPlacePumpOnPipe() {
        Pump oldPump = new Pump();
        Pump newPump = new Pump();
        Pipe oldPipe = new Pipe(71);
        Mechanic mechanic = new Mechanic(oldPipe);
        mechanic.placePump();
    }

    public static void TestPlacePumpOnCistern() {}

    public static void TestPickUpPumpFromCistern() {}

    public static void TestPickUpPumpFromPipe() {}

    public static void TestWaterFlowsFromSpring() {}

    public static void TestWaterFlowsToCistern() {}

    public static void TestDisconnectPipe() {}

    public static void TestConnectPipe() {}

    public static void TestPickUpPipeFromCistern() {}

    public static void TestWorkingPumpPumping() {}

    public static void TestBrokenPumpPumping() {}

    public static void TestMechanicMoveFromPipeToPump() {}

    public static void TestMechanicMoveFromPumpToPipe() {}

    public static void TestMechanicMoveFromPumpToOccupiedPipe() {}

    public static void TestSetPump() {}
}