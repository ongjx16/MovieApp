package Boundary;

import Control.MoviesManager;
import Entity.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class RateReviewMoviesUI {

    public static void rateMovies(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which movie would you like to rate?");
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // only adding movies with "Preview" and "Now Showing" status into filteredMovies array
        for (int i = 0; i < allMovies.size(); i++){
            filteredMovies = MoviesManager.filterByStatus();
        }

        // printing out all the filteredMovies for user to choose
        for (int i = 0; i < filteredMovies.size(); i++){
            int index = i+1;
            System.out.println("(" + index + ")" + filteredMovies.get(i).getName());
        }
        int movieToRate = scan.nextInt();
        System.out.println("What is your rating?");
        int newRating = scan.nextInt();
        // getting movie id of chosen movie to rate & rating it
        int filteredMovieId = filteredMovies.get(movieToRate-1).getMovieID();
        MoviesManager.updateRating(filteredMovieId, newRating);
    }

    public static void reviewMovies(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which movie would you like to review?");
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // only adding movies with "Preview" and "Now Showing" status into filteredMovies array
        for (int i = 0; i < allMovies.size(); i++){
            filteredMovies = MoviesManager.filterByStatus();
        }

        // printing out all the filteredMovies for user to choose
        for (int i = 0; i < filteredMovies.size(); i++){
            int index = i+1;
            System.out.println("(" + index + ") " + filteredMovies.get(i).getName());
        }
        int movieToRate = scan.nextInt();
        System.out.println("Enter your review: ");
        String newReview = scan.nextLine();
        scan.nextLine();
        // getting movie id of chosen movie to rate & rating it
        int filteredMovieId = filteredMovies.get(movieToRate-1).getMovieID();
        MoviesManager.addReviews(filteredMovieId, newReview);
    }
}
