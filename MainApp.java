

import java.util.Scanner;
import Admin.*;

public class MainApp{
    public static void main (String[] args){
        int choice;
        int identity;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you brother?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1){
            System.out.println("Please enter your username");
            username1 = scan.next();

            while (admin.verifyUsername(username1) == false){
                if (admin.verifyUsername(username1)){
                    System.out.println("Username is valid");
                }
                else{
                    System.out.println("Username is invalid, please key in again");
                    username1 = scan.next();
                }
            }

            System.out.println("Please enter your password");
            password1 = scan.next();
            while (admin.verifyPassword(username1, password1) == false){
                if (admin.verifyPassword(username1, password1)){
                    System.out.println("Password is valid");
                }
                else{
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

            if (choice ==1){
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
            }

            else if (choice ==2){




            }

            else if (choice ==3){


            }

            else if (choice ==4){
                int k = MoviesManager.getNumber();
                Movie[] MoviesArray;
                MoviesArray = MoviesManager.readAllMovies();
                for (int i =0; i< k; i++){
                    System.out.println(MoviesArray[i].getType());
                }
            }

            //log in as admin
        }
        else if (identity ==2){
            System.out.println("i am movie goer\n");
        }
        else{
            return;
        }
    
    
    }
}