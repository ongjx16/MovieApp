package Boundary;

import Control.MoviesManager;
import Entity.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class UserViewMovieDetailsUI implements DetailsInterface{
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void display(){

        System.out.println("\nYou've chosen: " + movie.getName());
        System.out.println("Here are the associated movie details!\n");
        System.out.println("Type: " + movie.getType());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Duration: " + movie.getShowLength());
        System.out.println("Synopsis: " + movie.getSynopsis());
        System.out.println("Status: " + movie.getShowingStatus());
        if (movie.getRating()[0]>1){
            System.out.println("Rating: " + movie.getRating()[1]);
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
