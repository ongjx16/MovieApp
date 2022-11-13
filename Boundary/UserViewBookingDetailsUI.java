package Boundary;

import Control.UsersManager;
import Entity.Booking;

public class UserViewBookingDetailsUI implements DetailsInterface{
    private Booking toBook;

    public Booking getToBook() {
        return toBook;
    }

    public void setToBook(Booking toBook) {
        this.toBook = toBook;
    }

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
