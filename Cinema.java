import java.io.Serializable;

public class Cinema implements Serializable {
    
    //each cinema has a seating plan, movies showing, showtimes, movie type (blockbuster etc)
    private String cinemaId;
    public Cinema(String n){
        this.cinemaId = n;
    }
    

}
