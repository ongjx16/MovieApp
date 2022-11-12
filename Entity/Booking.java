package Entity;

import Control.CineplexManager;

import java.io.Serializable;

/**
 * Represents a booking made in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Booking implements Serializable {
    private static final long serialVersionUID = 1752384005199823622L;
    /**
     * The name of the movie-goer
     */
    private String name;
    /**
     * The email of the movie-goer
     */
    private String email;
    /**
     * The contact number of the movie-goer
     */
    private long contactno;
    /**
     * The name of the movie-goer
     */
    private float totalPrice;
    /**
     * The name of the movie chosen by the movie-goer
     */
    private String movieName;
    /**
     * The transaction ID of a booking
     */
    private String TXNid;
    /**
     * The movie date chosen by the movie-goer
     */
    private String movieDate;
    /**
     * The number of seats booked by the movie-goer
     */
    private int noOfSeats;
    /**
     * The showtime of the movie
     */
    private String movieTime;

    /**
     * Gets the number of seats the movie-goer wants to book
     * @return the number of seats to book
     */
    public int getNoOfSeats() {
        return noOfSeats;
    }

    /**
     * Changes the number of seats
     * @param noOfSeats the total number of seats to book
     */
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    /**
     * Gets the name of movie chosen by movie-goer
     * @return the name of movie
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Changes the name of movie chosen
     * @param movieName The movie name
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * Creates a booking
     * @param name The name of movie-goer
     * @param email The email of movie-goer
     * @param contactno The contact number of movie-goer
     * @param totalPrice The total price of booking
     * @param TXNid The transaction ID of the booking
     * @param movieName The name of the movie
     * @param movieDate The date of the movie showing
     * @param movieTime The showtime of the movie
     * @param noOfSeats The number of seats booked
     */
    public Booking(String name, String email, long contactno, float totalPrice, String TXNid, String movieName, String movieDate, String movieTime, int noOfSeats){
        this.name=name;
        this.email=email;
        this.contactno=contactno;
        this.totalPrice=totalPrice;
        this.TXNid=TXNid;
        this.movieName=movieName;
        this.movieDate=movieDate;
        this.movieTime=movieTime;
        this.noOfSeats=noOfSeats;
    }

    /**
     * Gets the cineplex where booking is made. This is obtained from transsaction ID.
     * @param txnId The transaction ID of the booking
     * @return The cineplex name where the booking is made if there is an existing cineplex
     */
    public static String getCineplexByBooking(String txnId) {
        char cineplex = txnId.charAt(0);
        for (int i = 0; i < CineplexManager.readAllCineplexes().size(); i++) {
            if (CineplexManager.readAllCineplexes().get(i).getCineplexName().equals(cineplex - 49)) ;
            return CineplexManager.readAllCineplexes().get(i).getCineplexName();
        }
        return "No cineplex found";
    }

    /**
     * Gets the name of the movie-goer who made the booking
     * @return The movie-goer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the date of the movie
     * @return The movie's date
     */
    public String getMovieDate() {
        return movieDate;
    }

    /**
     * Changes the movie date for the booking
     * @param movieDate The movie's date
     */
    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    /**
     * Gets the showtime of the movie
     * @return The movie showtime
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * Changes the movie's showtime for the booking
     * @param movieTime The showtime of movie time
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    /**
     * Changes the name of the movie-goer
     * @param name The name of movie-goer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the transaction ID of the booking
     * @return The transaction ID
     */
    public String getTXNid() {
        return TXNid;
    }

    /**
     * Changes the transaction ID for the booking
     * @param TXNid The transaction ID
     */
    public void setTXNid(String TXNid) {
        this.TXNid = TXNid;
    }

    /**
     * Gets the email of the movie-goer
     * @return The movie-goer's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the email of the movie-goer
     * @param email The movie-goer's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the contact number of the movie-goer
     * @return the movie-goer's contact number
     */
    public long getContactno() {
        return contactno;
    }

    /**
     * Changes the contact number of the movie-goer
     * @param contactno The movie-goer's contact number
     */
    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    /**
     * Gets the total price of the booking
     * @return the total price
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Changes the total price of the booking based on number of seats movie-goer has chosen
     * @param totalPrice The total price of booking
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}


