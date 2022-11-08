import java.io.Serializable;

public class Cinema implements Serializable {
    
    //each cinema has a seating plan, movies showing, showtimes, movie type (blockbuster etc)
    private String cinemaCode;
    private SeatingPlan seatingPlan;
    private CinemaType type;


    public Cinema(String n, SeatingPlan seatingPlan, CinemaType type){
        this.cinemaCode = n;
        this.seatingPlan = seatingPlan;
        this.type = type;
    }

    public void setCinemaCode(String n){
        this.cinemaCode = n;
    }

    public String getCinemaCode(){
        return cinemaCode;
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
