
// need username and passwords
// need to figure out the function that pulls the booking history from the database
// need to figure out the function that pulls overall ratings thus far from the databas
package User;
public class Moviegoer {
    private String transactionID;
    private String name;
    private int phoneNumber;
    private String email;
    private int myAge;
    private String [] bookingHistory;
    private int overallRatings;

    public Moviegoer(String name, int phoneNumber, String email, int myAge){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.myAge = myAge;
    }

    public String getName (){
        return name;
    }
    public int getAge (){
        return myAge;
    }
    public String[] showBookingHistory (){
        return bookingHistory;
    }

    public void setTransactionID(String x){
        this.transactionID = x;
    }
    public void addBookingHistory(String a){
        // idk what to add here
    }
    public int getOverallRatings(){
        // idk what to add here
        return 1;
    }
}

