package Entity;

import java.io.Serializable;

/**
 * Represents a seat in a cinema under a cineplex in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Seat implements Serializable {
    private static final long serialVersionUID = -920862172244708410L;
    /**
     * The id of seat
     */
    private String seatId;
    /**
     * the status of seat
     */
    private boolean seatStatus = false; // false means unoccupied, true means occupied

    /**
     * Creates a seat
     * @param seatId id of seat
     */
    public Seat(String seatId){
        this.seatId = seatId;
    }

    /**
     * Gets the id of seat
     * @return the seat ID
     */
    public String getSeatId(){
        return seatId;
    }

    /**
     * Checks if seat is occupied
     * @return seatStatus
     */
    public boolean isOccupied(){
        return seatStatus;
    }

    /**
     * Assigns a seat
     */
    public void assign(){
        this.seatStatus = true;
        
    }

    /**
     * Unassigns a seat
     */
    public void unassign(){
        this.seatStatus = false;
    }
}
