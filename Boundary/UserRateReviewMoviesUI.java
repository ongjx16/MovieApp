package Boundary;

import Control.MoviesManager;
import Entity.Movie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boundary class that movie-goer interacts with when movie-goer chooses to Rate/Review movies
 * @author shubham
 * @version 1.0
 * @since 2022-11-13
 */
public class UserRateReviewMoviesUI {
    /**
     * Allows movie=goer to rate specific movie
     * Rating give is in range [1,10]
     * Rating updated by writing to AllMovies.dat
     */
    public static void rateMovies(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which movie would you like to rate?");
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // only adding movies with "Preview" and "Now Showing" status into filteredMovies array
        for (int i = 0; i < allMovies.size(); i++){
            filteredMovies = MoviesManager.filterByStatus(MoviesManager.readAllMovies());
        }

        // printing out all the filteredMovies for user to choose
        for (int i = 0; i < filteredMovies.size(); i++){
            int index = i+1;
            System.out.println("(" + index + ")" + filteredMovies.get(i).getName());
        }

        int movieToRate = 0;
        ExceptionHandler check = new ExceptionHandler();
        movieToRate = check.checkNumberInput(movieToRate, filteredMovies.size()+1);

        System.out.println("What is your rating? (1 to 10)");
        int newRatings = 0;
        newRatings = check.checkNumberInput(newRatings, 10);
        float newRating = (float)newRatings;
        // getting movie id of chosen movie to rate & rating it
        int filteredMovieId = filteredMovies.get(movieToRate-1).getMovieID();
        MoviesManager.updateRating(filteredMovieId, newRating);
    }

    /**
     * Allows movie-goer to leave reviews on specific movies
     * Reviews updated to show under movie details
     * Reviews added by writing to AllMovies.dat
     */
    public static void reviewMovies(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which movie would you like to review?");
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // only adding movies with "Preview" and "Now Showing" status into filteredMovies array
        for (int i = 0; i < allMovies.size(); i++){
            filteredMovies = MoviesManager.filterByStatus(MoviesManager.readAllMovies());
        }

        // printing out all the filteredMovies for user to choose
        for (int i = 0; i < filteredMovies.size(); i++){
            int index = i+1;
            System.out.println("(" + index + ") " + filteredMovies.get(i).getName());
        }
        int movieToRate = 0;
        ExceptionHandler check = new ExceptionHandler();
        movieToRate = check.checkNumberInput(movieToRate, filteredMovies.size()+1);
        System.out.println("Enter your review: ");
        String newReview = scan.nextLine();
        scan.nextLine();
        // getting movie id of chosen movie to rate & rating it
        int filteredMovieId = filteredMovies.get(movieToRate-1).getMovieID();
        MoviesManager.addReviews(filteredMovieId, newReview);
    }
}
