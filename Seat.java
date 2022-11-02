public class Seat {
    private String seatId;
    private boolean seatStatus = false; // false means unoccupied, true means occupied

    public Seat(String seatId){
        this.seatId = seatId;
    }

    public boolean isOccupied(){
        return seatStatus;
    }

    public void assign(){
        this.seatStatus = true;
    }

    public void unassign(){
        this.seatStatus = false;
    }
}
