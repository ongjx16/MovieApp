package User;
import java.io.Serializable;


public class UserAccount implements Serializable {
    private static final long serialVersionUID = 4L;
    private String username;
    private String password;

//    private String transactionID;

    private String name;

    private int phoneNumber;

    private String email;

    private String bookingHistory;

    private int overallRatings;

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

    public String getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(String bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public int getOverallRatings() {
        return overallRatings;
    }

    public void setOverallRatings(int overallRatings) {
        this.overallRatings = overallRatings;
    }
    UserAccount(String u, String p){
        this.username = u;
        this.password = p;
        this.bookingHistory = "3 movies seen thus far";
        this.email = "shubhangam@gmail.com";
        this.name = "Shubhangam";
        this.phoneNumber = 87805205;
        this.overallRatings = 4;
    }

    public String getUserUsername(){
        return username;
    }

    public String getUserPassword(){
        return password;
    }




}
