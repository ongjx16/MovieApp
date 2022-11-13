
import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Boundary.UserUI;
import Control.*;
import Boundary.AdminUI;

/**
 * main app file to run to start program.
 * @author jing xuan
 * @version 1.0
 * @since 2022-11-13
 */


public class MainApp {
    /**
     * Moblima program starts when this function is run. User can choose to use Moblima as an admin or movie-goer
     * @param args
     */
    public static void main(String[] args) {
        int identity = 0;
        Scanner scan = new Scanner(System.in);

        while (identity != 3) {
            System.out.println("\n");
            System.out.println("███╗░░░███╗░█████╗░██████╗░██╗░░░░░██╗███╗░░░███╗░█████╗░");
            System.out.println("████╗░████║██╔══██╗██╔══██╗██║░░░░░██║████╗░████║██╔══██╗");
            System.out.println("██╔████╔██║██║░░██║██████╦╝██║░░░░░██║██╔████╔██║███████║");
            System.out.println("██║╚██╔╝██║██║░░██║██╔══██╗██║░░░░░██║██║╚██╔╝██║██╔══██║");
            System.out.println("██║░╚═╝░██║╚█████╔╝██████╦╝███████╗██║██║░╚═╝░██║██║░░██║");
            System.out.println("╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚══════╝╚═╝╚═╝░░░░░╚═╝╚═╝░░╚═╝");
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
