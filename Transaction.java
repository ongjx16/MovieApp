import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {

    private boolean hasPaid;
    private String TXNid;


    // cineplex 1 JEM has 3 halls: cinemaId = 1A, 1B, 1C
    // cineplex 2 Cineleisure Orchard has 3 halls: 2A, 2B, 2C
    // cineplex 3 Parkway Parade has 3 halls: 3A, 3B, 3C

    public Transaction(String cinemaCode) {
        // transaction id is XXXYYYYMMDDhhmm (XXX is cinemaCode)
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        String formatted = currentTime.format(myFormat);
        this.TXNid = cinemaCode.concat(formatted);

    }

    public String getTransactionId() {
        return TXNid;
    }

    ;
}


