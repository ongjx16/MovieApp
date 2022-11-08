import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment implements Serializable {
    
    private boolean hasPaid;
    private String TXNid;
    private int totalPrice;
    private Movie movie;
    private String name;
    private String mobileNo;
    private String email;

    // cineplex 1 JEM has 3 halls: cinemaId = 1A, 1B, 1C
    // cineplex 2 Cineleisure Orchard has 3 halls: 2A, 2B, 2C
    // cineplex 3 Parkway Parade has 3 halls: 3A, 3B, 3C

    public Payment(String cinemaCode, Movie movie, String name, String email, String mobileNo){
        // transaction id is XXXYYYYMMDDhhmm (XXX is cinemaCode)
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        String formatted = currentTime.format(myFormat);
        this.TXNid = cinemaCode.concat(formatted);
        this.movie = movie;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getTransactionId(){
        return TXNid;
    };

    public String getMobileNo(){
        return mobileNo;
    }

    public Movie getMovie(){
        return movie;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

}
