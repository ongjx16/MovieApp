import java.io.Serializable;

public class Cinema implements Serializable {
    
    //each cinema has a seating plan, movies showing, showtimes, movie type (blockbuster etc)
    private String cinemaId;
    private SeatingPlan seatingPlan;
    private CinemaType type;


    public Cinema(String n, SeatingPlan seatingPlan, CinemaType type){
        this.cinemaId = n;
        this.seatingPlan = seatingPlan;
        this.type = type;
    }

    public void setCinemaCode(String n){
        this.cinemaId = n;
    }

    public String getCinemaCode(){
        return cinemaId;
    }

    public void setSeatingPlan(){
        this.seatingPlan = seatingPlan;
    }

    public SeatingPlan getSeatingPan(){
        return seatingPlan;
    }

    public void setType(CinemaType type){
        this.type = type;
    }

    public CinemaType getType(){
        return type;
    }
    

}
