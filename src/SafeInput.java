import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    public static void prettyHeader(String msg) {

        //************************************************************
        //***               Message Centered Here                  ***
        //************************************************************
        for (int i=1; i<=3; i++) {
            for (int row = 1; row <= 60; row++) {
                if (i==1) {
                    System.out.print("*");
                } else if (i==2) {
                    if (row<=3) {
                        System.out.print("*");
                    } else if (row<58) {
                        if (row==60%msg.length()) {
                            System.out.print(msg);
                            row+=msg.length();
                        }
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retString = "";

        do {
            System.out.println("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {

        int enterInt = 0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                enterInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("You must enter a number.");
                pipe.nextLine();
            }
        } while (!done);
        System.out.println("You entered: " + enterInt);
        return enterInt;
    }
    public static double getDouble(Scanner pipe, String prompt) {

        double enterDouble = 0.0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                enterDouble = pipe.nextDouble();
                done = true;
            } else {
                System.out.println("You must enter a number.");
                pipe.nextLine();
            }
        } while(!done);
        System.out.println("You entered: " + enterDouble);
        return enterDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        int enterRangedInt = 0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                enterRangedInt = pipe.nextInt();
                if (enterRangedInt < high && enterRangedInt > low) {
                    done = true;
                    System.out.println();
                    pipe.nextLine();
                } else {
                    System.out.println("You must enter a number between " + low + " and " + high);
                    pipe.nextLine();
                }
            } else {
                System.out.println("You must enter a number between " + low + " and " + high);
                pipe.nextLine();
            }
        } while (!done);
        return enterRangedInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        double enterRangedDouble = 0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                enterRangedDouble = pipe.nextDouble();
                if (enterRangedDouble < high && enterRangedDouble > low) {
                    done = true;
                    System.out.println();
                    pipe.nextLine();
                } else {
                    System.out.println("You must enter a number between " + low + " and " + high);
                    pipe.nextLine();
                }
            } else {
                System.out.println("You must enter a number between " + low + " and " + high);
                pipe.nextLine();
            }
        } while (!done);
        return enterRangedDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {

        boolean finished = false;
        boolean yesNo = false;
        String yOrN = "";

        do {
            System.out.println("\n" + prompt + ": ");
            yOrN = pipe.nextLine();
            if (yOrN.equalsIgnoreCase("Y")) {
                yesNo = true;
                finished = true;
            } else if (yOrN.equalsIgnoreCase("N")) {
                finished = true;
            } else {
                System.out.println("You must enter Y or N");
            }
        } while (!finished);
        return yesNo;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {

        boolean matches = false;
        String pattern = "";

        do {
            System.out.println("\n" + prompt + ": ");
            pattern = pipe.nextLine();
            if (pattern.matches(regEx)) {
                matches = true;
            } else {
                System.out.println("Invalid input: " + pattern);
            }
        } while (!matches);
        return pattern;
    }
}
