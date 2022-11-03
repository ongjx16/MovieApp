import java.util.Scanner;
import Admin.adminLogin;
import User.UserLogin;

import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        int identity;
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

            //log in as admin
        } else if (identity == 2) {
            System.out.println("You are now a user\n");
            System.out.println("What would you like to do now \n");
            System.out.println("(1) Book a movie\n");
            System.out.println("(2) See History");
            int option = scan.nextInt();

            if (option == 1) {
                System.out.println("Here are the movies:");
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cineplexes.dat"));
                    try {
                        Cineplex c = (Cineplex) in.readObject();
                        System.out.println(c.getMovies());
                        System.out.println(c.getCineplexName());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
            else {
                return;
            }


        }
    }
}
