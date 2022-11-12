package Entity;

import java.io.Serializable;

/**
 * Represents the showtimes of movies in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Showtimes implements Serializable {
    private static final long serialVersionUID = -9144363532793385492L;
    /**
     * The showtime of the movie
     */
    private String showtime;
    /**
     * The movie name
     */
    private String moviename;
    /**
     * The id of the movie
     */
    private int movieID;
    /**
     * The id of the cinema
     */
    private String cinemaID;
    /**
     * The seats in the cinema
     */
    private SeatingPlan seats;
    /**
     * The id of the showtime
     */
    private int showtimeID;

    /**
     * Creates a showtime for a movie
     * @param showtime the showtime of a movie
     * @param moviename the name of movie
     * @param movieID the id of movie
     * @param cinemaID the ID of cinema
     * @param showtimeID the ID of showtime
     */
    public Showtimes(String showtime,String moviename, int movieID, String cinemaID, int showtimeID) {
        this.showtime = showtime;
        this.moviename = moviename;
        this.movieID = movieID;
        this.cinemaID = cinemaID;
        this.seats = new SeatingPlan(16,16);
        this.showtimeID = showtimeID;
    }

    /**
     * Changes the showtime
     * @param showtime showtime of movie
     */
    public void setShowtime(String showtime){
        this.showtime = showtime;
    }

    /**
     * Gets the showtime
     * @return showtime of movie
     */
    public String getShowtime(){
        return showtime;
    }

    /**
     * Changes the movie name
     * @param moviename movie name
     */
    public void setMoviename(String moviename){
        this.moviename = moviename;
    }

    /**
     *  Gets the movie name
     * @return the movie name
     */
    public String getMoviename(){
        return moviename;
    }

    /**
     * Gets the movie ID
     * @return movie ID
     */
    public int getMovieID() {
        return movieID;
    }

    /**
     * Changes the seats in seating plan
     * @param seats the seat
     */
    public void setSeats(SeatingPlan seats) {
        this.seats = seats;
    }

    /**
     * Changes the movie ID
     * @param movieID movie ID
     */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    /**
     * Changes the cinema ID
     * @param cinemaID cinema ID
     */
    public void setCinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }

    /**
     * Gets the cinema ID
     * @return cinema ID
     */
    public String getCinemaID(){
        return cinemaID;
    }

    /**
     * Gets the seats in seating plan
     * @return seats
     */
    public SeatingPlan getSeats(){
        return seats;
    }

    /**
     * Gets the showtime ID
     * @return showtime ID
     */
    public int getShowtimeID() {
        return showtimeID;
    }

    /**
     * Changes the showtime ID
     * @param showtimeID showtimeID
     */
    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }
}
