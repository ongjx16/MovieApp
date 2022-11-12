package Entity;

import Utils.CinemaType;
import Control.CineplexManager;

import java.io.Serializable;

/**
 * Represents a cinema in one of the Cineplexes in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Cinema implements Serializable {
    /**
     * The cinema ID of a cinema under a cineplex
     */
    private String cinemaId;
    /**
     * The type of the cinema: Standard & Premium
     */
    private CinemaType type;
    /**
     * The cinema number represents a cinema within each cineplex
     */
    private String cinemaNo;
    /**
     * The name of the cineplex
     */
    private String cineplexName;

    /**
     * Creates a cinema
     * @param cineplexName the name of cineplex the cinema is from
     * @param cinemaNo the number representing a cinema
     * @param type the type of cinema
     */
    public Cinema(String cineplexName, String cinemaNo, CinemaType type){
        this.cinemaId = Integer.toString(CineplexManager.getCineplexIDByName(cineplexName)) + "C" + cinemaNo;
        this.type = type;
        this.cinemaNo = cinemaNo;
        this.cineplexName = cineplexName;
    }

    /**
     * Gets the cinema ID under a cineplex
     * @return the cinema ID
     */
    public String getCinemaId() {
        return cinemaId;
    }

    /**
     * Changes the cinema ID of a cinema
     * @param cinemaId the cinema ID
     */
    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * Gets the type of cinema
     * @return the cinema type
     */
    public CinemaType getType() {
        return type;
    }

    /**
     * Changes the type of the cinema
     * @param type the cinema type
     */
    public void setType(CinemaType type) {
        this.type = type;
    }

    /**
     * Gets the cinema number of the cinema under a cineplex
     * @return the cinema number
     */
    public String getCinemaNo() {
        return cinemaNo;
    }

    /**
     * Changes the cinema number of the cinema under a cineplex
     * @param cinemaNo
     */
    public void setCinemaNo(String cinemaNo) {
        this.cinemaNo = cinemaNo;
    }

    /**
     * Gets the name of the cineplex the cinema is under
     * @return the cineplex name
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Changes the cineplex name the cinema is under
     * @param cineplexName The name of the cineplex
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
}
