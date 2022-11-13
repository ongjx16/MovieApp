package Boundary;

import Control.MoviesManager;
import Entity.Movie;
import Utils.MovieStatus;
import Utils.MovieType;
import java.util.Scanner;

import java.util.ArrayList;

/**
 * User interface when admin chooses to edit movie details
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class AdminMovieDetailsUI implements CreateUIInterface,DeleteUIInterface,DetailsInterface,EditUIInterface{
    /**
     * Contains functions admin can use to edit movies available
     */
    public void AdminMovieFunctions(){
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {

            System.out.println("1. Create Movie\n");
            System.out.println("2. Edit Movie\n");
            System.out.println("3. Delete Movie\n");
            System.out.println("4. See List of Current Movies\n");
            System.out.println("5. Back\n\n");
            System.out.println("Enter a number of your choice: ");

            ExceptionHandler check = new ExceptionHandler();
            choice = check.checkNumberInput(choice, 5);

            if (choice == 1) {
                createNewObject();
            }
            else if (choice == 2) {
                editObjectUI();

            } else if (choice == 3) {
                //delete movie
                deleteObject();


            } else if (choice == 4) {
                // Movie[] MoviesArray;
                display();
            }
        }
    }

    /**
     * Creates a new movie
     * Implements CreateUIInterface
     */
    @Override
    public void createNewObject(){
        Scanner scan = new Scanner(System.in);
        String name;
        MovieType type;
        int showLength;
        MovieStatus showingStatus;
        String director;
        String synopsis;


        System.out.println("1. Enter Movie Name");
        name = scan.nextLine();

        System.out.println("2. Choose Movie Type");

        System.out.println("[1] " + MovieType.DIGITAL2D.toString());
        System.out.println("[2] " + MovieType.DIGITAL3D.toString());
        System.out.println("[3] " + MovieType.BLOCKBUSTER2D.toString());
        System.out.println("[4] " + MovieType.BLOCKBUSTER3D.toString());

        int typeChoice=0;
        ExceptionHandler check = new ExceptionHandler();
        typeChoice = check.checkNumberInput(typeChoice, 4);


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


        System.out.println("3. Enter Movie Length (in minutes)");

        showLength = scan.nextInt();
        scan.nextLine();
        System.out.println("4. Choose Movie Showing Status");

        System.out.println("[1] " + MovieStatus.PREVIEW.toString());
        System.out.println("[2] " + MovieStatus.NOW_SHOWING.toString());
        System.out.println("[3] " + MovieStatus.END_OF_SHOW.toString());

        int statusChoice = 0;
        statusChoice = check.checkNumberInput(statusChoice, 5);


        if (statusChoice == 1){
            showingStatus = MovieStatus.PREVIEW;
        }
        else if (statusChoice == 2){
            showingStatus = MovieStatus.NOW_SHOWING;
        }
        else {
            showingStatus = MovieStatus.END_OF_SHOW;
        }

        System.out.println("5. Enter Movie Director");

        scan.nextLine();
        director = scan.nextLine();

        System.out.println("6. Enter Movie Synopsis");

        synopsis = scan.nextLine();

        MoviesManager.createMovie(name, type, showLength, showingStatus, director, synopsis);
        System.out.println("Movie has been created!");
    }

    /**
     * Allows admin to edit specific movie
     * Implements EditUIInterface
     */
    @Override
    public void editObjectUI(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
        MoviesArray = MoviesManager.readAllMovies();
        for (int i = 0; i < MoviesArray.size(); i++) {
            System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());
        }
        System.out.println("Select Movie To Edit");
        int movie = 0;

        ExceptionHandler check = new ExceptionHandler();
        movie = check.checkNumberInput(movie,MoviesArray.size()+1);

        movie = movie-1;


        int toChange = 0;

        while (toChange != 7) {
            System.out.println("\nEditing: " + MoviesArray.get(movie).getName());
            System.out.println("\nWhich attribute would you like to edit?");
            System.out.println("1. Movie Name");
            System.out.println("2. Movie Type");
            System.out.println("3. Show Length");
            System.out.println("4. Showing Status");
            System.out.println("5. Director");
            System.out.println("6. Movie Synopsis");
            System.out.println("7. Save All Changes");

            toChange = check.checkNumberInput(toChange, 7);
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
    }

    /**
     * Displays all movies with movie details
     * Implements DetailsInterface
     */
    @Override
    public void display() {
        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
        MoviesArray = MoviesManager.readAllMovies();
        for (int i = 0; i < MoviesArray.size(); i++) {
            System.out.println("Name: " + MoviesArray.get(i).getName());
            System.out.println("Movie ID: " + MoviesArray.get(i).getMovieID());
            System.out.println("Type: " + MoviesArray.get(i).getType().toString());
            System.out.println("Length: " + MoviesArray.get(i).getShowLength());
            System.out.println("Status: " + MoviesArray.get(i).getShowingStatus().toString());
            System.out.println("Director: " + MoviesArray.get(i).getDirector());
            System.out.println("Synopsis: " + MoviesArray.get(i).getSynopsis() + "\n");
        }
    }

    /**
     * Deletes specific movie
     * Implements DeleteUIInterface
     */
    @Override
    public void deleteObject() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
        MoviesArray = MoviesManager.readAllMovies();
        for (int i = 0; i < MoviesArray.size(); i++) {
            System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());

        }
        System.out.println("\nSelect Movie To Delete");
        int movie = 0;
        ExceptionHandler check = new ExceptionHandler();
        movie = check.checkNumberInput(MoviesArray.size()+1, 5);
        MoviesManager.deleteMovie(movie - 1);
    }
}
