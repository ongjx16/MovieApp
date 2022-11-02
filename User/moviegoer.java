import java.util.*;

// need username and passwords
// need to figure out the function that pulls the booking history from the database
// need to figure out the function that pulls overall ratings thus far from the database


package User;

public class moviegoer {
    private String transactionID;
    private String name;
    private int phoneNumber;
    private String email;
    private int age;
    private String [] bookingHistory;
    private int overallRatings;

    public moviegoer(String name, int phoneNumber, String email, int age){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.transactionID = "";
    }

    public String getName (){
        return name;
    }
    public int getAge (){
        return age;
    }
    public String[] showBookingHistory (){
        return bookingHistory;
    }
    public void addBookingHistory(String a){
        // idk what to add here
    }
    public int getOverallRatings(){
        // idk what to add here
    }
}

