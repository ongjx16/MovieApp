package Entity;

import java.io.Serializable;
import java.util.ArrayList;

import Utils.MovieStatus;
import Utils.MovieType;

/**
 * Represents a movie listed in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Movie  implements Serializable {
    private static final long serialVersionUID = -3185918430309702988L;
    /**
     * The name of the movie
     */
    private String name;
    /**
     * The type of movie: Standard, Premium
     */
    private MovieType type;
    /**
     * The ratings of the movie
     */
    private int[] rating;
    /**
     * The duration of the movie
     */
    private int showLength;
    /**
     * The show status of the movie: END_OF_SHOWING, PREVIEW, NOW SHOWING
     */
    private MovieStatus showingStatus;
    /**
     * The director of movie
     */
    private String director;
    /**
     * The sypnosis of the movie
     */
    private String synopsis;
    /**
     * The ID of the movie
     */
    private int movieID;
    /**
     * The reviews of the movie given by movie-goers
     */
    private ArrayList<String> reviews;
    /**
     * The ticket sales of the movie
     */
    private int sales;

    /**
     * Gets the movie name
     * @return the movie name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the movie type
     * @return the movie type
     */
    public MovieType getType() {
        return type;
    }

    /**
     * Gets the rating of the movie given by movie-goers
     * @return the movie rating
     */
    public int[] getRating() {
        return rating;
    }

    /**
     * Gets the duration of the movie
     * @return the mocie duration
     */
    public int getShowLength() {
        return showLength;
    }

    /**
     * Gets the movie status
     * @return the movie status
     */
    public MovieStatus getShowingStatus() {
        return showingStatus;
    }

    /**
     * Gets the ID of the movie
     * @return the movie id
     */
    public int getMovieID() {
        return movieID;
    }



    //SET METHODS

    /**
     * Changes the name of movie
     * @param name movie name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the type of movie
     * @param type the movie type
     */
    public void setType(MovieType type) {
        this.type = type;
    }

    /**
     * Changes the rating of the movie
     * @param rating the movie ratings given by movie-goers
     */
    public void setRating(int[] rating) {
        this.rating = rating;
    }

    /**
     * Changes the duration of the movie
     * @param showLength duration of movie
     */
    public void setShowLength(int showLength) {
        this.showLength = showLength;
    }

    /**
     * Changes the status of movie
     * @param showingStatus the movie status
     */
    public void setShowingStatus(MovieStatus showingStatus) {
        this.showingStatus = showingStatus;
    }

    /**
     * Changes the director of movie
     * @param director the movie director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Changes the synopsis of movie
     * @param synopsis the synopsis movie
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Gets the director of the movie
     * @return the movie director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Gets the synopsis of movie
     * @return the movie synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Get the reviews of the movie
     * @return the movie reviews
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * Get the ticket sales of the movie
     * @return the ticket sales
     */
    public int getSales() {
        return sales;
    }

    /**
     * Changes the reviews of movie
     * @param reviews reviews by movie-goers
     */
    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    /**
     * Change the ticket sales of movie
     * @param sales the ticket sales
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    //CONSTRUCTOR

    /**
     * Creates the movie
     * @param name the movie name
     * @param type the movie type
     * @param showLength the duration of movie
     * @param showingStatus the showing status of movie
     * @param director the director of movie
     * @param synopsis the synopsis of movie
     * @param movieID the movieID
     */
    public Movie(String name, MovieType type, int showLength, MovieStatus showingStatus, String director, String synopsis, int movieID) {
        this.name = name;
        this.type = type;
        this.showLength = showLength;
        this.showingStatus = showingStatus;
        this.director = director;
        this.synopsis = synopsis;
        this.movieID = movieID;
        this.reviews=new ArrayList<String>();
        this.sales=0;
        this.rating = new int[]{0,0};
    }

}
