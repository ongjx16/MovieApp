package Entity;

import java.io.Serializable;

public class Cineplex implements Serializable {
    private String cineplexName;
    private int CineplexID;

    public Cineplex(String cineplexName, int CineplexID){
        this.cineplexName = cineplexName;
        this.CineplexID = CineplexID;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public int getCineplexID() {
        return CineplexID;
    }

    public void setCineplexID(int cineplexID) {
        this.CineplexID = cineplexID;
    }
}