package Entity;

import java.io.Serializable;
import java.util.ArrayList;


public class UserAccount implements Serializable {
    private static final long serialVersionUID = 4L;
    private String username;
    private String password;

//    private String transactionID;

    private String name;

    private int phoneNumber;

    private String email;
    private int userId;

    private ArrayList<Booking> bookingHistory = new ArrayList<>();

    public UserAccount(String username, String password, String name, int phoneNumber, String email, int userId){
        this.username=username;
        this.password=password;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.userId=userId;
    }


    public void showBookingHistory(){
        for(int i=0; i<bookingHistory.size(); i++){
            System.out.print(bookingHistory.get(i).getName()+"\n");
        }

    }

    public void addBooking(Booking b){
        bookingHistory.add(b);
        System.out.println("Shown!");

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
