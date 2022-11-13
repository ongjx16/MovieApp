package Boundary;

import Control.MoviesManager;
import Entity.Movie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boundary class that movie-goer interacts with when movie-goer chooses to view movie details
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class UserViewMovieDetailsUI implements DetailsInterface{
    private Movie movie;

    /**
     * Gets the movie the movie-goer chooses
     * @return Movie object of movie chosen by movie-goer
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie whose details we want to display
     * @param movie Movie object of movie chosen by movie-goer
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Displays details of the movie chosen
     * Implements DetailsInterfaceUI
     */
    public void display(){

        System.out.println("\nYou've chosen: " + movie.getName());
        System.out.println("Here are the associated movie details!\n");
        System.out.println("Type: " + movie.getType());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Duration: " + movie.getShowLength());
        System.out.println("Synopsis: " + movie.getSynopsis());
        System.out.println("Status: " + movie.getShowingStatus());
        if (movie.getRating()[0]>1){
            System.out.println("Rating: " + String.format("%.1f", movie.getRating()[1]));
        }
        else{
            System.out.println("Rating: No Available Ratings Yet.");
        }

        ArrayList<String> reviews = new ArrayList<String>(movie.getReviews());

        if (reviews.size() ==0){
            System.out.println("Reviews: No Reviews Yet");
        }
        else{
            System.out.println("All Reviews: ");
            for (int z = 0; z< reviews.size(); z++){
                System.out.println("Review " + (z+1) + ": "+ reviews.get(z));
            }
        }

        System.out.println("\n");
    }
}
