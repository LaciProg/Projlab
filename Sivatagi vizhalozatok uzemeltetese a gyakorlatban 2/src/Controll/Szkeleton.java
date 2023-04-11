package Controll;

import Players.Saboteur;
import Fields.Pipe;

/**
 * Szkeleton class for testing purposes.
 * It contains the main method.
 * */
public class Szkeleton {
    public static int tabs = 0;
    /**
     * Main method.
     * @param args String[]
     */
    public static void main(String[] args) {
        TestBreakPipe();
    }

    public static void printTabs() {
        for (int i = 0; i < Szkeleton.tabs; i++) {
            System.out.print("\t");
        }
    }

    public static void TestBreakPipe() {
        Pipe pipe = new Pipe(34);
        Saboteur sab = new Saboteur(pipe);
        boolean result = false;
        result = sab.breakField();
    }
}