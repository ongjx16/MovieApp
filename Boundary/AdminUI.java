package Boundary;

import Control.MoviesManager;
import Control.ShowtimesManager;
import Control.UserLogin;
import Control.adminLogin;
import Entity.Movie;
import Entity.Showtimes;
import Utils.MovieStatus;
import Utils.MovieType;

import java.io.File;
import java.util.ArrayList;
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
                choice = 0;

                while (choice != 5) {

                    System.out.println("1. Create Movie\n");
                    System.out.println("2. Edit Movie\n");
                    System.out.println("3. Delete Movie\n");
                    System.out.println("4. See List of Current Movies\n");
                    System.out.println("5. Back\n\n");
                    System.out.println("Enter a number of your choice: ");
                    choice = scan.nextInt();


                    if (choice == 1) {
                        String name;
                        MovieType type;
                        String rating;
                        int showLength;
                        MovieStatus showingStatus;
                        String director;
                        String synopsis;

                        scan.nextLine();
                        System.out.println("1. Enter Movie Name");

                        name = scan.nextLine();

                        System.out.println("2. Choose Movie Type");

                        System.out.println("[1] " + MovieType.DIGITAL2D.toString());
                        System.out.println("[2] " + MovieType.DIGITAL3D.toString());
                        System.out.println("[3] " + MovieType.BLOCKBUSTER2D.toString());
                        System.out.println("[4] " + MovieType.BLOCKBUSTER3D.toString());

                        int typeChoice = scan.nextInt();

                        while(typeChoice<1 && typeChoice>4){
                            System.out.println("Invalid Choice. Choose Again.");
                            typeChoice = scan.nextInt();
                        }

                        if (typeChoice == 1){
                            type = MovieType.DIGITAL2D;
                        }
                        else if (typeChoice == 2){
                            type = MovieType.DIGITAL3D;
                        }
                        else if (typeChoice == 3){
                            type = MovieType.BLOCKBUSTER2D;
                        }
                        else {
                            type = MovieType.BLOCKBUSTER3D;
                        }


                        System.out.println("3. Enter src.Entity.Movie Length (in minutes)");

                        showLength = scan.nextInt();
                        scan.nextLine();
                        System.out.println("4. Choose src.Entity.Movie Showing Status");

                        System.out.println("[1] " + MovieStatus.COMING_SOON.toString());
                        System.out.println("[2] " + MovieStatus.NOW_SHOWING.toString());
                        System.out.println("[3] " + MovieStatus.END_OF_SHOW.toString());

                        int statusChoice = scan.nextInt();

                        while(statusChoice<1 && statusChoice>3){
                            System.out.println("Invalid Choice. Choose Again.");
                            statusChoice = scan.nextInt();
                        }

                        if (statusChoice == 1){
                            showingStatus = MovieStatus.COMING_SOON;
                        }
                        else if (statusChoice == 2){
                            showingStatus = MovieStatus.NOW_SHOWING;
                        }
                        else {
                            showingStatus = MovieStatus.END_OF_SHOW;
                        }

                        System.out.println("5. Enter src.Entity.Movie Director");

                        scan.nextLine();
                        director = scan.nextLine();

                        System.out.println("6. Enter src.Entity.Movie Synopsis");

                        synopsis = scan.nextLine();

                        MoviesManager.createMovie(name, type, showLength, showingStatus, director, synopsis);
                        System.out.println("src.Entity.Movie has been created!");
                    } else if (choice == 2) {
                        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                        MoviesArray = MoviesManager.readAllMovies();
                        for (int i = 0; i < MoviesArray.size(); i++) {
                            System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());
                        }
                        System.out.println("Select src.Entity.Movie To Edit");
                        int movie = scan.nextInt() - 1;
                        int toChange = 0;

                        while (toChange != 7) {
                            System.out.println("\nEditing: " + MoviesArray.get(movie).getName());
                            System.out.println("\nWhich attribute would you like to edit?");
                            System.out.println("1. src.Entity.Movie Name");
                            System.out.println("2. src.Entity.Movie Type");
                            System.out.println("3. Show Length");
                            System.out.println("4. Showing Status");
                            System.out.println("5. Director");
                            System.out.println("6. src.Entity.Movie Synopsis");
                            System.out.println("7. Save All Changes");

                            toChange = scan.nextInt();
                            if (toChange == 1) {
                                //name
                                MoviesManager.editMovie(movie, "name");
                            } else if (toChange == 2) {
                                //type
                                MoviesManager.editMovie(movie, "type");
                            } else if (toChange == 3) {
                                //length
                                MoviesManager.editMovie(movie, "length");
                            } else if (toChange == 4) {
                                //showing status
                                MoviesManager.editMovie(movie, "status");
                            } else if (toChange == 5) {
                                //director
                                MoviesManager.editMovie(movie, "director");
                            } else if (toChange == 6) {
                                //synopsis
                                MoviesManager.editMovie(movie, "synopsis");
                            }
                        }

                    } else if (choice == 3) {
                        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                        MoviesArray = MoviesManager.readAllMovies();
                        for (int i = 0; i < MoviesArray.size(); i++) {
                            System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());

                        }
                        System.out.println("\nSelect src.Entity.Movie To Delete");
                        int movie = scan.nextInt();
                        MoviesManager.deleteMovie(movie - 1);


                    } else if (choice == 4) {
                        // src.Entity.Movie[] MoviesArray;
                        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                        MoviesArray = MoviesManager.readAllMovies();
                        for (int i = 0; i < MoviesArray.size(); i++) {
                            System.out.println("Name: " + MoviesArray.get(i).getName());
                            System.out.println("src.Entity.Movie ID: " + MoviesArray.get(i).getMovieID());
                            System.out.println("Type: " + MoviesArray.get(i).getType().toString());
                            System.out.println("Length: " + MoviesArray.get(i).getShowLength());
                            System.out.println("Status: " + MoviesArray.get(i).getShowingStatus().toString());
                            System.out.println("Director: " + MoviesArray.get(i).getDirector());
                            System.out.println("Synopsis: " + MoviesArray.get(i).getSynopsis() + "\n");
                        }
                    }
                }
                choose = scan.nextInt();

            } else if (choose == 2) {
                System.out.println("1. Create Showtime\n");
                System.out.println("2. Edit Showtime\n");
                System.out.println("3. Delete Showtime\n");
                System.out.println("4. See List of Current src.Entity.Showtimes\n\n");
//                System.out.println("5. src.Entity.Seat tester");
                System.out.println("Enter a number of your choice: ");
                choice = scan.nextInt();

                if (choice == 1) {
                    int moviechoice;
                    //String showtime;
                    int movieid1;
                    String cinemaID;

                    scan.nextLine();
                    System.out.println("1. Choose src.Entity.Movie");

                    ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                    for (int i = 0; i < MoviesArray.size(); i++) {
                        System.out.println(Integer.toString(i + 1) + ". " + MoviesArray.get(i).getName());
                    }

                    moviechoice = scan.nextInt();

                    int x = moviechoice - 1;
                    String moviename = MoviesArray.get(x).getName();
                    movieid1 = MoviesArray.get(x).getMovieID();

                    scan.nextLine();

                    System.out.println("2. Enter Date- DD/MM/YYYY: ");

                    String date = scan.nextLine();

                    System.out.println("Choose a showtime from the following list:\n");

                    File f = new File("DATFiles/Showtimes.dat");


//                     initialise an array of timings for admin to choose from
                    String[] timings;
                    ArrayList<String> newTimings = new ArrayList<String>();
                    timings = new String[5];
                    timings[0] = "10:00";
                    timings[1] = "12:30";
                    timings[2] = "15:00";
                    timings[3] = "17:30";
                    timings[4] = "20:00";
                    int k = 1;

                    String showtime;
                    boolean toAdd;

                    if (f.exists()) {

                        ArrayList<Showtimes> arrayoftimes = new ArrayList<Showtimes>(ShowtimesManager.searchShowtimes(date, movieid1));
                        //System.out.println(arrayoftimes.size());
                        for (int j = 0; j < 5; j++) {
                            toAdd= true;
                            for (int i = 0; i < arrayoftimes.size(); i++ ) {
                                //System.out.println(arrayoftimes.get(i).getShowtime().substring(9));
                                if ((arrayoftimes.get(i).getShowtime().substring(11).equals(timings[j]))) {
                                    toAdd = false;
                                }
                                ;
                            }
                            if (toAdd == true){
                                System.out.println(Integer.toString(k) + ". " + timings[j]);
                                newTimings.add(timings[j]);
                                k++;
                            }

                        }
                        int choiceoftime = scan.nextInt();

                        showtime = date + " " + newTimings.get(choiceoftime - 1);

                    } else {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Integer.toString(k) + ". " + timings[j]);
                            k++;
                        }
                        int choiceoftime = scan.nextInt();
                        showtime = date + " " + timings[choiceoftime - 1];
                    }




                    //System.out.println(showtime);

                    scan.nextLine();
                    System.out.println("3. Enter src.Entity.Cinema ID: ");
                    cinemaID = scan.nextLine();

                    //src.Control.ShowtimesManager.initialiser();
                    ShowtimesManager.createShowtimes(showtime, moviename, cinemaID);
                    System.out.println("Showtime has been created!");
                    return;

                } else if (choice == 2) {
                    int editByWhat =0;

                    while (editByWhat !=3){
                        System.out.println("How would you like to edit your Showtime?\n");
                        System.out.println("1. By Movie");
                        System.out.println("2. By Cinema and Cineplex ID");
                        System.out.println("3. Save All Changes");

                        editByWhat = scan.nextInt();

                        if (editByWhat == 1){
                            ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                            for (int i = 0; i < MoviesArray.size(); i++) {
                                System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());
                            }

                            System.out.println("Select Movie To Edit");
                            int movie = scan.nextInt() - 1;
                            int toChange = 0;

                            while (toChange!=3){
                                System.out.println("\nWhich attribute would you like to edit?");
                                System.out.println("1. Movie Showtime");
                                System.out.println("2. Movie Cineplex ID");
                                System.out.println("3. Save All Changes");
//                                    System.out.println("2. Movie Name");
//                                    System.out.println("3. Cinema ID");
//                                    System.out.println("4. Save All Changes");

                                toChange = scan.nextInt();
                                if (toChange ==1){
                                    //name
                                    ShowtimesManager.editShowtime(movie, "showtime");

                                }

                                else if (toChange ==2){

                                    ShowtimesManager.editShowtime(movie, "cinemaID");

                                }
//
                            }


                        }

                        else if (editByWhat ==2){

                            ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                            //ArrayList<Showtimes> ShowtimesArrayChecker = src.Control.ShowtimesManager.readAllShowtimes();
                            int counter=0;
                            for (int i = 0; i < ShowtimesArray.size(); i++) {
                                int j;
                                for (j=0; j<i; j++){
                                    if (ShowtimesArray.get(i).getCinemaID().equals((ShowtimesArray.get(j).getCinemaID()))){
                                        break;
                                    }
                                }
                                if (i==j){
                                    System.out.println((counter + 1) + ". " + ShowtimesArray.get(i).getCinemaID());
                                    counter++;
                                }
                            }

                            System.out.println("Select Cinema ID which you want to edit: ");
                            int cinema = scan.nextInt() - 1;
                            int toChange = 0;

                            while (toChange!=3){
                                System.out.println("\nWhich attribute would you like to edit?");
                                System.out.println("1. Movie Showtime");
                                System.out.println("2. Movie Cineplex ID");
                                System.out.println("3. Save All Changes");
//

                                toChange = scan.nextInt();
                                if (toChange ==1){
                                    //name
                                    ShowtimesManager.editShowtime(cinema, "showtime2");

                                }

                                else if (toChange ==2){

                                    ShowtimesManager.editShowtime(cinema, "cinemaID");

                                }
//
                            }


                        }

                    }



                } else if (choice == 3) {
                    ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                    for (int i = 0; i < ShowtimesArray.size(); i++) {
                        System.out.println((i+1) +". " + ShowtimesArray.get(i).getMoviename()+ " "+ ShowtimesArray.get(i).getShowtime() + " " + ShowtimesArray.get(i).getCinemaID());

                    }
                    System.out.println("\nSelect Showtime To Delete");
                    int showtime = scan.nextInt();
                    ShowtimesManager.deleteShowtimes (showtime-1);


                } else if (choice == 4) {

                    ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                    ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();



                    for (int i = 0; i < ShowtimesArray.size(); i++) {
                        System.out.println("Movie Name: " + ShowtimesArray.get(i).getMoviename());
                        System.out.println("Showtime: " + ShowtimesArray.get(i).getShowtime());
                        System.out.println("Movie ID: " + ShowtimesArray.get(i).getMovieID());
                        System.out.println("Cinema ID: " + ShowtimesArray.get(i).getCinemaID()+"\n");
                    }
                }
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
