package Boundary;


import Control.adminLogin;

import java.util.Scanner;

public class AdminUI {

    public static void AdminFunctions(){
        int choice;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        Scanner scan = new Scanner(System.in);

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
        int choose = 0;

        while (choose != 4) {


            System.out.println("1. Edit Movie Details\n");
            System.out.println("2. Edit Showtime Details\n");
            System.out.println("3. Edit System Settings\n");
            System.out.println("4. Quit \n");
            System.out.println("Enter a number of your choice: ");
            choose = scan.nextInt();

            if (choose == 1) {
                AdminMovieDetailsUI.AdminMovieFunctions();

            } else if (choose == 2) {
                AdminShowtimesUI.ShowtimeFunctions();
            }
            if (choose == 3) {

                int settingsChoice = 0;

                while (settingsChoice != 4) {

                    System.out.println("1. Edit Movie Prices\n");
                    System.out.println("2. Edit Holiday Dates\n");
                    System.out.println("3. Edit Top 5 Movie Filters\n");
                    System.out.println("4. Back\n");
                    System.out.println("Enter a number of your choice: ");
                    settingsChoice = scan.nextInt();


                    if (settingsChoice ==1 ){
                        //edit pricing
                        AdminSystemSettingsUI.editPricing();
                    }
                    else if (settingsChoice ==2){
                        //change holiday dates
                        AdminSystemSettingsUI.editHolidayDates();
                    }
                    else if (settingsChoice ==3){
                        //change filtering of top 5 movies
                        AdminSystemSettingsUI.editTop5Filtering();
                    }

                }

            }
            return;
        }
    }

}