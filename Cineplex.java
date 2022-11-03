import java.util.ArrayList;

public class Cineplex {
    
    // 3 cineplexes
    // One cineplex is one cinema at a location eg JEM cathay is 1 cineplex
    // each cineplex has 3 halls (cinema)

    private Cinema[] cinema = new Cinema[3];
    private String cineplexName;
    private int numOfHalls;

    public Cineplex(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public void setCineplexName(String cineplexName){
        this.cineplexName = cineplexName;
    }

    public String getCineplexName(){
        return cineplexName;
    }

}
