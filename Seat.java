import java.io.Serializable;
import User.tickets;

public class Seat implements Serializable {
    private int seatId;
    private boolean seatStatus = false; // false means unoccupied, true means occupied

    public Seat(int seatId){
        this.seatId = seatId;
    }

    public int getSeatId(){
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
