package Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents the user account of movie-goer in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 4L;
    /**
     * The username of the movie-goer
     */
    private String username;
    /**
     * The password of the movie-goer
     */
    private String password;
    /**
     * the name of movie-goer
     */
    private String name;
    /**
     * the phone number of movie-goer
     */
    private int phoneNumber;
    /**
     * the email of movie-goer
     */
    private String email;
    /**
     * the user ID of movie-goer
     */
    private int userId;

    /**
     * the booking history of movie-goer
     */
    private ArrayList<Booking> bookingHistory = new ArrayList<>();

    /**
     * Creates a user account
     * @param username username of movie-goer
     * @param password password of movie-goer
     * @param name name of movie-goer
     * @param phoneNumber phone number of movie-goer
     * @param email email of movie-goer
     * @param userId user ID of movie-goer
     */
    public UserAccount(String username, String password, String name, int phoneNumber, String email, int userId){
        this.username=username;
        this.password=password;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.userId=userId;
    }

    /**
     * Show booking history of the movie-goer
     */
    public void showBookingHistory(){
        for(int i=0; i<bookingHistory.size(); i++){
            System.out.print(bookingHistory.get(i).getName()+"\n");
        }

    }

    /**
     * Add the booking to the booking history of movie-goer
     * @param b
     */
    public void addBooking(Booking b){
        bookingHistory.add(b);
    }

    /**
     * Gets the username of movie-goer
     * @return the username of movie-goer
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes the username of movie-goer
     * @param username the username of movie-goer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of movie-goer
     * @return the password of movie-goer
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes the password of movie-goer
     * @param password the password of movie-goer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets name of movie-goer
     * @return name of movie-goer
     */
    public String getName() {
        return name;
    }

    /**
     * Gets name of movie-goer
     * @param name name of movie-goer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets phone number of movie-goer
     * @return phone number of movie-goer
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Changes phone number of movie-goer
     * @param phoneNumber phone number of movie-goer
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email of movie-goer
     * @return email of movie-goer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the email of movie-goer
     * @param email email of movie-goer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user ID of movie-goer
     * @return user ID of movie-goer
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Changes user ID of movie-goer
     * @param userId user ID of movie-goer
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the booking history of movie-goer
     * @return array of booking history of movie-goer
     */
    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    /**
     * Changes the booking history of movie-goer
     * @param bookingHistory array of booking history of movie-goer
     */
    public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
