import java.util.Scanner;
import Admin.adminLogin;
import User.UserLogin;
import Admin.AdminAccount;

import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        int identity;
        int choice;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        UserLogin user = new UserLogin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you brother?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1) {
            System.out.println("Please enter your username");
            username1 = scan.next();

            while (!admin.verifyUsername(username1)) {
                if (admin.verifyUsername(username1)) {
                    System.out.println("Username is valid");
                } else {
                    System.out.println("Username is invalid, please key in again");
                    username1 = scan.next();
                }
            }

            System.out.println("Please enter your password");
            password1 = scan.next();
            while (!admin.verifyPassword(username1, password1)) {
                if (admin.verifyPassword(username1, password1)) {
                    System.out.println("Password is valid");
                } else {
                    System.out.println("Password is invalid, please key in again");
                    password1 = scan.next();
                }
            }

            System.out.println("1. Create Movie\n");
            System.out.println("2. Edit Movie\n");
            System.out.println("3. Delete Movie\n");
            System.out.println("4. See List of Current Movies\n\n");
            System.out.println("Enter a number of your choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                String name;
                String type;
                String rating;
                int showLength;
                String showingStatus;
                String director;
                String synopsis;

                scan.nextLine();
                System.out.println("1. Enter Movie Name");

                name = scan.nextLine();

                System.out.println("2. Enter Movie Type");

                type = scan.nextLine();

                System.out.println("3. Enter Movie Rating");

                rating = scan.nextLine();

                System.out.println("4. Enter Movie Length");

                showLength = scan.nextInt();
                scan.nextLine();
                System.out.println("5. Enter Movie Showing Status");

                showingStatus = scan.nextLine();

                System.out.println("6. Enter Movie Director");

                director = scan.nextLine();

                System.out.println("7. Enter Movie Synopsis");

                synopsis = scan.nextLine();

                MoviesManager.create(name, type, rating, showLength, showingStatus, director, synopsis);
                System.out.println("Movie has been created!");
                return;
            } else if (choice == 2) {


            } else if (choice == 3) {


            } else if (choice == 4) {
                int k = MoviesManager.getNumber();
                Movie[] MoviesArray;
                MoviesArray = MoviesManager.readAllMovies();
                for (int i = 0; i < k; i++) {
                    System.out.println(MoviesArray[i].getType());
                }
            } 
        }
            else if (identity == 2) {
                System.out.println("You are now a user\n");
                System.out.println("What would you like to do now \n");
                System.out.println("(1) Book a movie\n");
                System.out.println("(2) See History");
                int option = scan.nextInt();

                if (option == 1){
                    System.out.println("These are the cineplexes");
                    ReadCineplexes readCineplexes = new ReadCineplexes();
                    for(int i=0; i<readCineplexes.getCineplexes().length;i++){
                        System.out.println("[" + (i+1) + "] " + readCineplexes.getCineplexes()[i].getCineplexName() + "\n");
                    }
                    System.out.println("Choose your cineplex: ");
                    int a = scan.nextInt();
                    if (a> readCineplexes.getCineplexes().length || a < 1){
                        System.out.println("Invalid option, please choose again");
                        a = scan.nextInt();
                    }
                    System.out.println("Your choice is: " + readCineplexes.getCineplexes()[a-1].getCineplexName());
                    Cineplex userCineplex = new Cineplex(readCineplexes.getCineplexes()[a-1].getCineplexName());
                    System.out.println("Choose your movie! ");
                    for(int j=0; j<userCineplex.getMovies().length;j++){
                        System.out.println("[" + (j+1) + "] " + userCineplex.getMovies()[j] + "\n");
                    }
                    int b = scan.nextInt();
                    if (b > userCineplex.getMovies().length || b < 1){
                        System.out.println("Invalid choice, please choose again");
                        b = scan.nextInt();
                    }
                    System.out.println("Your choice is: " + userCineplex.getMovies()[b-1]);
                    System.out.println("Which date would you like to go and see the movie: ");

                }

                if (option == 2) {
                    System.out.println("Please enter your username");
                    username1 = scan.next();

                    while (!user.verifyUsername(username1)) {
                        if (user.verifyUsername(username1)) {
                            System.out.println("Username is valid");
                        } else {
                            System.out.println("Username is invalid, please key in again");
                            username1 = scan.next();
                        }
                    }

                    System.out.println("Please enter your password");
                    password1 = scan.next();
                    while (!user.verifyPassword(username1, password1)) {
                        if (user.verifyPassword(username1, password1)) {
                            System.out.println("Password is valid");

                        } else {
                            System.out.println("Password is invalid, please key in again");
                            password1 = scan.next();
                        }
                    }
                }
            } 
            else {
                return;
            }
    }
}
