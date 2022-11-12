import java.io.Serializable;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1752384005199823622L;
    private String name; 
    private String email; 
    private long contactno;
    private float totalPrice;
    private String movieName;
    private String TXNid;
    private String movieDate;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    private String movieTime;

    public Booking(){}
    public Booking(String name, String email, long contactno, float totalPrice, String TXNid, String movieName, String movieDate, String movieTime){
        this.name=name;
        this.email=email;
        this.contactno=contactno;
        this.totalPrice=totalPrice;
        this.TXNid=TXNid;
        this.movieName=movieName;
        this.movieDate=movieDate;
        this.movieTime=movieTime;
    }

//    public static String getCineplexByBooking(String txnId){
//        String cineplex = txnId.substring(0,1);
//        if(cineplex.equals("1")){
//            return "Jem";
//        }
//        else if (cineplex.equals("2")){
//            return "Parkway Parade";
//        }
//        else{
//            return "Tampines";
//        }
    public static String getCineplexByBooking(String txnId) {
        char cineplex = txnId.charAt(0);
        for (int i = 0; i < CineplexManager.readAllCineplexes().size(); i++) {
            if (CineplexManager.readAllCineplexes().get(i).getCineplexID() == (cineplex - 49)) ;
            return CineplexManager.readAllCineplexes().get(i).getCineplexName();
        }
        return "No cineplex found";
    }



    public String getName() {
        return name;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTXNid() {
        return TXNid;
    }

    public void setTXNid(String TXNid) {
        this.TXNid = TXNid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}


