import java.util.Scanner;

public class SafeInputOBJ {
    
    Scanner pipe;
    
    public SafeInputOBJ(Scanner pipe) {
        this.pipe = pipe;
    }
    public void prettyHeader(String msg) {

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
    public String getNonZeroLenString(String prompt) {

        String retString = "";

        do {
            System.out.println("\n" + prompt + ": ");
            retString = "N";
        } while (retString.length() == 0);
        return retString;
    }
    public int getInt(String prompt) {

        int enterInt = 1;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (enterInt == 1) {

                done = true;
            } else {
                System.out.println("You must enter a number.");
                pipe.nextLine();
            }
        } while (!done);
        System.out.println("You entered: " + enterInt);
        return enterInt;
    }
    public double getDouble(String prompt) {

        double enterDouble = 1.0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (enterDouble == 1.0) {
                done = true;
            } else {
                System.out.println("You must enter a number.");
                pipe.nextLine();
            }
        } while(!done);
        System.out.println("You entered: " + enterDouble);
        return enterDouble;
    }
    public int getRangedInt(String prompt, int low, int high) {

        int enterRangedInt = 9;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (enterRangedInt == 9) {
                if (enterRangedInt < high && enterRangedInt > low) {
                    done = true;
                    System.out.println();
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
    public double getRangedDouble(String prompt, double low, double high) {

        double enterRangedDouble = 9.0;
        boolean done = false;

        do {
            System.out.println("\n" + prompt + ": ");
            if (enterRangedDouble == 9.0) {
                if (enterRangedDouble < high && enterRangedDouble > low) {
                    done = true;
                    System.out.println();
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
    public boolean getYNConfirm(String prompt) {

        boolean finished = false;
        boolean yesNo = false;
        String yOrN = "Y";

        do {
            System.out.println("\n" + prompt + ": ");
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
    public String getRegExString(String prompt, String regEx) {

        boolean matches = false;
        String pattern = "20";

        do {
            System.out.println("\n" + prompt + ": ");
            if (pattern.matches(regEx)) {
                matches = true;
            } else {
                System.out.println("Invalid input: " + pattern);
            }
        } while (!matches);
        return pattern;
    }

}
