package User;
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

    private ArrayList<Booking> bookingHistory = new ArrayList<>();

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

    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void showBookingHistory(){
//        for(int i=0; i<bookingHistory.size(); i++){
//            System.out.print(bookingHistory.get(i).getTXNid());
//        }

    }

    public ArrayList<Booking> addBooking(Booking b){
        bookingHistory.add(b);
        System.out.println("Shown!");
        return bookingHistory;
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
