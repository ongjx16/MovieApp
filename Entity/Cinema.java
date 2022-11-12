package Entity;

import Utils.CinemaType;
import Control.CineplexManager;

import java.io.Serializable;

public class Cinema implements Serializable {
    
    //each cinema has a seating plan, movies showing, showtimes, movie type (blockbuster etc)
    private String cinemaId;
    private CinemaType type;
    private String cinemaNo;
    private String cineplexName;


    public Cinema(String cineplexName, String cinemaNo, CinemaType type){
        this.cinemaId = Integer.toString(CineplexManager.getCineplexIDByName(cineplexName)) + "C" + cinemaNo;
        this.type = type;
        this.cinemaNo = cinemaNo;
        this.cineplexName = cineplexName;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public CinemaType getType() {
        return type;
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public String getCinemaNo() {
        return cinemaNo;
    }

    public void setCinemaNo(String cinemaNo) {
        this.cinemaNo = cinemaNo;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
}
