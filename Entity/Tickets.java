package Entity;

import Utils.CinemaType;

/**
 * Represents the tickets after booking a movie in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Tickets {
    /**
     * The movie chosen by movie-goer
     */
    private String movieChosen;
    /**
     * The cinema chosen by movie-goer
     */
    private String cinemaChosen;
    /**
     * The date chosen by movie-goer
     */
    private String dateChosen;
    /**
     * The time chosen by movie-goer
     */
    private String timeChosen;
    /**
     * The type of cinema chosen by movie-goer
     */
    private CinemaType type;
    /**
     * The seat ID chosen by movie-goer
     */
    private String seatId;
    /**
     * The age group chosen by movie-goer
     */
    private int age;
    /**
     * The price of ticket
     */
    private double price;

    /**
     * Creates a ticket
     * @param movie The movie chosen by movie-goer
     * @param cinemaCode The cinema ID
     * @param type The movie type chosen by movie-goer
     * @param date The date chosen by movie-goer
     * @param time The time chosen by movie-goer
     * @param seatID The seat ID chosen by movie-goer
     */
    public Tickets(String movie, String cinemaCode, CinemaType type, String date, String time, String seatID){
        this.movieChosen = movie;
        this.cinemaChosen = cinemaCode;
        this.type=type;
        this.dateChosen = date;
        this.timeChosen = time;
        this.seatId = seatID;
        System.out.println("Movie: " + movieChosen + "\nCinema: " + cinemaChosen +"\nCinema type: " + type.toString() + "\nDate: " + dateChosen + "\nTime: " + timeChosen + "\nSeat: " + seatId);
    }

    /**
     * Changes the movie chosen
     * @param x the movie chosen
     */
    public void setMovieChosen(String x){
        this.movieChosen = x;
    }

    /**
     * Changes the cinema chosen
     * @param y the cinema chosen
     */
    public void setCinemaChosen(String y){
        this.cinemaChosen = y;
    }

    /**
     * Changes the date chosen
     * @param z date chosen
     */
    public void setDateChosen(String z){
        this.dateChosen = z;
    }

    /**
     * Changes the time chosen
     * @param a time chosen
     */
    public void setTimeChosen(String a){
        this.timeChosen = a;
    }

    /**
     * Changes the age group of movie-goer
     * @param b age group
     */
    public void setage(int b){
        this.age = b; // this needs to be calculated based on the seat you've chosen or inside the seat class
    }

    /**
     * Change the price of ticket
     * @param c price
     */
    public void setPrice(double c){
        this.price = c; // this needs to be calculated based on the seat you've chosen or inside the seat class penispenis
    }
}