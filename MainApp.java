
import java.text.ParseException;
import java.util.Scanner;

import Boundary.UserUI;
import Control.*;
import Boundary.AdminUI;


public class MainApp {
    public static void main(String[] args) throws ParseException {
        int identity = 0;
        Scanner scan = new Scanner(System.in);


        while (identity != 3) {
            System.out.println("\n" +
        "███╗░░░███╗░█████╗░██████╗░██╗░░░░░██╗███╗░░░███╗░█████╗░\n" +
        "████╗░████║██╔══██╗██╔══██╗██║░░░░░██║████╗░████║██╔══██╗\n" +
        "██╔████╔██║██║░░██║██████╦╝██║░░░░░██║██╔████╔██║███████║\n" +
        "██║╚██╔╝██║██║░░██║██╔══██╗██║░░░░░██║██║╚██╔╝██║██╔══██║\n" +
        "██║░╚═╝░██║╚█████╔╝██████╦╝███████╗██║██║░╚═╝░██║██║░░██║\n" +
        "╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚══════╝╚═╝╚═╝░░░░░╚═╝╚═╝░░╚═╝");
        System.out.println("Welcome to Moblima!\n");
            System.out.println("1. Admin");
            System.out.println("2. Movie Goer");
            System.out.println("3. Exit\n");
            System.out.println("Enter a number of your choice: ");
            identity = scan.nextInt();

            if (identity == 1) {
                AdminUI.AdminFunctions();
                 }
            else if (identity == 2) {
                UserUI.UserFunctions();
            }
        }
    }
}
