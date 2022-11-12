package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents the tickets after booking a movie in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Transaction implements Serializable {
    /**
     * The payment for the tickets
     */
    private boolean hasPaid;
    /**
     * The transaction ID
     */
    private String TXNid;


    // cineplex 1 JEM has 3 halls: cinemaId = 1A, 1B, 1C
    // cineplex 2 Cineleisure Orchard has 3 halls: 2A, 2B, 2C
    // cineplex 3 Parkway Parade has 3 halls: 3A, 3B, 3C

    /**
     * Creates a transaction ID
     * @param cinemaCode The cinema ID
     */
    public Transaction(String cinemaCode) {
        // transaction id is XXXYYYYMMDDhhmm (XXX is cinemaCode)
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        String formatted = currentTime.format(myFormat);
        this.TXNid = cinemaCode.concat(formatted);

    }

    /**
     * Get the transaction ID
     * @return
     */
    public String getTransactionId() {
        return TXNid;
    }
}


