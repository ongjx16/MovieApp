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

/**
 * Boundary class that admin interacts with when admin chooses to edit showtime details
 * @author somesh
 * @version 1.0
 * @since 2022-11-13
 */
public class AdminShowtimesUI implements CreateUIInterface,DeleteUIInterface,DetailsInterface,EditUIInterface{
    /**
     * Contains functions available for admin to edit showtimes available
     */

    public void ShowtimeFunctions(){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Create Showtime\n");
            System.out.println("2. Edit Showtime\n");
            System.out.println("3. Delete Showtime\n");
            System.out.println("4. See List of Current Showtimes\n");
            System.out.println("5. Back");
//                System.out.println("5. Seat tester");
            System.out.println("Enter a number of your choice: ");
            ExceptionHandler check = new ExceptionHandler();
            choice = check.checkNumberInput(choice, 5);

            if (choice == 1) {
                createNewObject();
            } else if (choice == 2) {
                editObjectUI();
            } else if (choice == 3) {
                //delete showtime
                deleteObject();


            } else if (choice == 4) {
                //print all showtimes
                display();

            } else if (choice == 5) return;
        }
    }

    /**
     * Creates new showtime
     * Implements CreateUIInterface
     * Admin chooses Cineplex, enters desired date then chooses showtime and associated cinema
     */

    @Override
    public void createNewObject(){
        Scanner scan = new Scanner(System.in);
        int moviechoice;
        //String showtime;
        int movieid1;
        String cinemaID;

        System.out.println("Choose Movie");

        ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
        for (int i = 0; i < MoviesArray.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". " + MoviesArray.get(i).getName());
        }

        ExceptionHandler check = new ExceptionHandler();
        moviechoice = check.checkNumberInput(MoviesArray.size()+1, 5);

        int x = moviechoice - 1;
        String moviename = MoviesArray.get(x).getName();
        movieid1 = MoviesArray.get(x).getMovieID();


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
            int choiceoftime = 0;
            choiceoftime = check.checkNumberInput(choiceoftime, arrayoftimes.size()+1);

            showtime = date + " " + newTimings.get(choiceoftime - 1);

        } else {
            for (int j = 0; j < 5; j++) {
                System.out.println(Integer.toString(k) + ". " + timings[j]);
                k++;
            }
            int choiceoftime = 0;
            choiceoftime = check.checkNumberInput(choiceoftime, 5);
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
        int cineplexChoice = 0;
        cineplexChoice = check.checkNumberInput(cineplexChoice,CineplexManager.readAllCineplexes().size()+1);

        for(int i=0; i< CinemaManager.readAllCinemas().size();i++){
            if(cinemas.get(i).getCineplexName().equals( cineplexes.get(cineplexChoice-1).getCineplexName())){
                cinemasInChosenCineplex.add(cinemas.get(i));
            }
        }

        System.out.println("Please choose cinema to assign the showtime: ");
        for(int i=0; i<cinemasInChosenCineplex.size();i++){
            System.out.println("["+(i+1)+"]"+cinemasInChosenCineplex.get(i).getCinemaId());
        }
        int cinemaChoice = 0;
        cinemaChoice = check.checkNumberInput(cinemaChoice,CineplexManager.readAllCineplexes().size()+1);

        //src.Control.ShowtimesManager.initialiser();
        ShowtimesManager.createShowtimes(showtime, moviename, cinemasInChosenCineplex.get(cinemaChoice-1).getCinemaId());
        System.out.println("Showtime has been created!");
    }

    /**
     * Allows admin to edit specific showtime that already exists in the database
     * Implements EditUIInterface
     * Admin can edit by movie or by cinema and cineplex ID
     * Admin can edit showtime and cineplex ID
     * Admin can save changes once done
     */
    @Override
    public void editObjectUI(){
        Scanner scan = new Scanner(System.in);
        int editByWhat =0;

        int cineplex0 = 0;
        int cinema0;
        System.out.println("Enter the desired Cineplex");
        ExceptionHandler check = new ExceptionHandler();
        cineplex0 = check.checkNumberInput(cineplex0,3);

//                        System.out.println("Enter the desired Cinema");
//                        cinema0 = scan.nextInt();


        while (editByWhat !=3){
            System.out.println("How would you like to edit your Showtime?\n");
            System.out.println("1. By Movie");
            System.out.println("2. By Cinema and Cineplex ID");
            System.out.println("3. Save All Changes");

            editByWhat = check.checkNumberInput(editByWhat,3);

            if (editByWhat == 1){
                ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                ArrayList<Integer> arraykek = ShowtimesManager.moviesByCineplex(cineplex0);// array containing all the movie IDs for the Cineplex in question
//                                for (int i =0; i< arraykek.size(); i++){
//                                    System.out.println(arraykek.get(i));
//                                }
                ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();

//                                ArrayList<Showtimes> CineplexArray = ShowtimesManager.showtimesByMovieAndCineplex(cineplex0, arraykek.get());

//                                for (int i = 0; i < MoviesArray.size(); i++) {
//                                    System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());
//                                }
                for (int i =0; i < arraykek.size(); i++){
                    System.out.println((i+1) + ". " + MoviesManager.getMoviebyID(arraykek.get(i)).getName());
                }

                System.out.println("Select Movie To Edit");
                int movie = 0;
                movie = check.checkNumberInput(movie, arraykek.size()+1);
                movie = movie - 1;

                int toChange = 0;

                while (toChange!=3){
                    System.out.println("\nWhich attribute would you like to edit?");
                    System.out.println("1. Movie Showtime");
                    System.out.println("2. Movie Cineplex ID");
                    System.out.println("3. Save All Changes");
//                                    System.out.println("2. Movie Name");
//                                    System.out.println("3. Cinema ID");
//                                    System.out.println("4. Save All Changes");
                    toChange = check.checkNumberInput(toChange, 3);
                    if (toChange ==1){
                        //name
                        ShowtimesManager.editShowtime(movie, "showtime", cineplex0);

                    }

                    else if (toChange ==2){

                        ShowtimesManager.editShowtime(movie, "cinemaID", cineplex0);

                    }
//
                }


            }

            else if (editByWhat ==2){

                ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                //ArrayList<Showtimes> ShowtimesArrayChecker = ShowtimesManager.readAllShowtimes();
                int DesiredCinemaID =0;
                int counter=0;
                for (int i = 0; i < ShowtimesArray.size(); i++) {
                    int j;
                    for (j=0; j<i; j++){
                        if (ShowtimesArray.get(i).getCinemaID().equals((ShowtimesArray.get(j).getCinemaID()))){
                            break;
                        }
                    }
                    if (i==j && Integer.parseInt(ShowtimesArray.get(i).getCinemaID().substring(0,1)) == cineplex0){
                        System.out.println((counter + 1) + ". " + ShowtimesArray.get(i).getCinemaID());
                        DesiredCinemaID = Integer.parseInt(ShowtimesArray.get(i).getCinemaID().substring(0,1));

                        counter++;
                    }
                }

                System.out.println("Select Cinema ID which you want to edit: ");
                int cinema = 0;
                cinema = check.checkNumberInput(cinema, ShowtimesArray.size()+1);
                cinema = cinema - 1;
                int toChange = 0;

                while (toChange!=3){
                    System.out.println("\nWhich attribute would you like to edit?");
                    System.out.println("1. Movie Showtime");
                    System.out.println("2. Movie Cineplex ID");
                    System.out.println("3. Save All Changes");
//
                    toChange = check.checkNumberInput(toChange, 3);
                    if (toChange ==1){
                        //name
                        ShowtimesManager.editShowtime(cinema, "showtime2", cineplex0);

                    }

                    else if (toChange ==2){

                        ShowtimesManager.editShowtime(DesiredCinemaID, "cinemaID", cineplex0);

                    }
//
                }


            }

        }




    }

    /**
     * Displays all showtimes with showtime details
     * Implements DetailsUIInterface
     */
    @Override
    public void display() {
        ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
        ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();

        for (int i = 0; i < ShowtimesArray.size(); i++) {
            System.out.println("Movie Name: " + MoviesManager.getMoviebyID(ShowtimesArray.get(i).getMovieID()).getName());
            System.out.println("Showtime: " + ShowtimesArray.get(i).getShowtime());
            System.out.println("Movie ID: " + ShowtimesArray.get(i).getMovieID());
            System.out.println("Cinema ID: " + ShowtimesArray.get(i).getCinemaID()+"\n");
        }
    }

    /**
     * Allows admin to delete a specific showtime by selecting one from all showtimes
     * Implements DeleteUIInterface
     */
    @Override
    public void deleteObject() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
        for (int i = 0; i < ShowtimesArray.size(); i++) {
            System.out.println((i+1) +". " + ShowtimesArray.get(i).getMoviename()+ " "+ ShowtimesArray.get(i).getShowtime() + " " + ShowtimesArray.get(i).getCinemaID());

        }
        System.out.println("\nSelect Showtime To Delete");
        int showtime = 0;
        ExceptionHandler check = new ExceptionHandler();
        showtime = check.checkNumberInput(showtime, (ShowtimesArray.size()+1));
        ShowtimesManager.deleteShowtimes (showtime-1);
    }
}
