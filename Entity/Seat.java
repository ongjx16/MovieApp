package Entity;

import java.io.Serializable;

public class Seat implements Serializable {
    private static final long serialVersionUID = -920862172244708410L;

    private String seatId;
    private boolean seatStatus = false; // false means unoccupied, true means occupied

    public Seat(String seatId){
        this.seatId = seatId;
    }

    public String getSeatId(){
        return seatId;
    }

    // to check if the seat is occupied
    public boolean isOccupied(){
        return seatStatus;
    }

    // assign if seat empty after checking w isOccupied()
    public void assign(){
        this.seatStatus = true;
        
    }
    
    public void unassign(){
        this.seatStatus = false;
    }
}
