
import java.util.Scanner;

import Boundary.ExceptionHandler;
import Boundary.UserUI;
import Boundary.AdminUI;

/**
 * main app file to run to start program.
 * @author jing xuan
 * @version 1.0
 * @since 2022-11-13
 */


public class MainApp {
    /**
     * Moblima program starts when this function is run. An initialiser is called to populate our database when the program first starts.  User can choose to use Moblima as an admin or movie-goer
     * @param args
     */
    public static void main(String[] args) {

        Initialiser initialiser = new Initialiser();
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

            ExceptionHandler check = new ExceptionHandler();
            identity = check.checkNumberInput(identity, 3);

            if (identity == 1) {
                AdminUI.AdminFunctions();
                 }
            else if (identity == 2) {
                UserUI.UserFunctions();
            }
        }
    }
}
