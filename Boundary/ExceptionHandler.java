package Boundary;

import java.util.Scanner;

public class ExceptionHandler {

    public ExceptionHandler() {
    }

    public int checkNumberInput(int intVar, int size){
        while (true){
            Scanner s = new Scanner(System.in);
            String input = s.next();
            try {
                intVar = Integer.parseInt(input);
                if (intVar > size || intVar < 0) {
                    System.out.println("Current input is not a valid number, please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Current input is not a number, please key in a valid number!");
            }
        }
        return intVar;
    }
}
