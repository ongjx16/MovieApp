package Boundary;

import Control.CinemaManager;
import Control.CineplexManager;
import Control.MoviesManager;
import Control.ShowtimesManager;
import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
import Entity.Showtimes;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminShowtimesUI {
    public static void ShowtimeFunctions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Create Showtime\n");
        System.out.println("2. Edit Showtime\n");
        System.out.println("3. Delete Showtime\n");
        System.out.println("4. See List of Current Showtimes\n\n");
//                System.out.println("5. Seat tester");
        System.out.println("Enter a number of your choice: ");
        int choice = scan.nextInt();

        if (choice == 1) {
            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
            System.out.println("hello"+ShowtimesArray.size());
            createShowtimeUI();
        } else if (choice == 2) {
            editShowtimeUI();
        } else if (choice == 3) {
            //delete showtime
            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
            for (int i = 0; i < ShowtimesArray.size(); i++) {
                System.out.println((i+1) +". " + ShowtimesArray.get(i).getMoviename()+ " "+ ShowtimesArray.get(i).getShowtime() + " " + ShowtimesArray.get(i).getCinemaID());

            }
            System.out.println("\nSelect Showtime To Delete");
            int showtime = scan.nextInt();
            ShowtimesManager.deleteShowtimes (showtime-1);


        } else if (choice == 4) {
            //print all showtimes
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

    public static void createShowtimeUI(){
        Scanner scan = new Scanner(System.in);
        int moviechoice;
        //String showtime;
        int movieid1;
        String cinemaID;

        System.out.println("1. Choose Movie");

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

        System.out.println("Please choose the cineplex to assign the showtime: ");
        ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
        ArrayList<Cinema> cinemas = new ArrayList<Cinema>(CinemaManager.readAllCinemas());
        ArrayList<Cinema> cinemasInChosenCineplex = new ArrayList<Cinema>();
        for(int i=0; i< CineplexManager.readAllCineplexes().size();i++){
            System.out.println("["+(i+1)+"]"+ cineplexes.get(i).getCineplexName());
        }
        int cineplexChoice = scan.nextInt();

        for(int i=0; i< CinemaManager.readAllCinemas().size();i++){
            if(cinemas.get(i).getCineplexName().equals( cineplexes.get(cineplexChoice-1).getCineplexName())){
                cinemasInChosenCineplex.add(cinemas.get(i));
            }
        }

        System.out.println("Please choose cinema to assign the showtime: ");
        for(int i=0; i<cinemasInChosenCineplex.size();i++){
            System.out.println("["+(i+1)+"]"+cinemasInChosenCineplex.get(i).getCinemaId());
        }
        int cinemaChoice = scan.nextInt();

        //src.Control.ShowtimesManager.initialiser();
        ShowtimesManager.createShowtimes(showtime, moviename, cinemasInChosenCineplex.get(cinemaChoice).getCinemaId());
        System.out.println("Showtime has been created!");
    }

    public static void editShowtimeUI(){
        Scanner scan = new Scanner(System.in);
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
    }
}
