package Boundary;

import Control.UsersManager;
import Entity.Booking;

/**
 * User Interface when movie-goer chooses to view booking history
 * Implements DetailsInterface
 */
public class UserViewBookingDetailsUI implements DetailsInterface{
    private Booking toBook;

    public Booking getToBook() {
        return toBook;
    }

    /**
     * Change the booking to add to booking history
     * @param toBook Booking that needs to be added to booking history
     */

    public void setToBook(Booking toBook) {
        this.toBook = toBook;
    }

    /**
     * Displays booking details of booking chosen
     * Implements DetailsUIInterface
     */
    @Override
    public void display() {
        System.out.println("Transaction ID: " +toBook.getTXNid() );
        System.out.println("Location: " + Booking.getCineplexByBooking(toBook.getTXNid()) );
        System.out.println("Movie Name: "+toBook.getMovieName());
        System.out.println("Movie Date: " + toBook.getMovieDate());
        System.out.println("Movie Time: " + toBook.getMovieTime());
        System.out.println("No. of seats booked: " + toBook.getNoOfSeats()+"\n");
    }
}
