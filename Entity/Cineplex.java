package Entity;

import java.io.Serializable;

/**
 * Represents a cineplexes in the MOBLIMA app
 * @author somesh
 * @version 1.0
 * @since 2022-11-12
 */
public class Cineplex implements Serializable {
    /**
     * The name of the cineplex
     */
    private String cineplexName;
    /**
     * The id of the cineplex
     */
    private int CineplexID;

    /**
     * Creates a cineplex
     * @param cineplexName the cineplex's name
     * @param CineplexID the cineplex's ID
     */
    public Cineplex(String cineplexName, int CineplexID){
        this.cineplexName = cineplexName;
        this.CineplexID = CineplexID;
    }

    /**
     * Gets the name of the cineplex
     * @return the cineplex's name
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Changes the name of the cineplex
     * @param cineplexName the cineplex's name
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * Gets the id of the cineplex
     * @return the cineplex's ID
     */
    public int getCineplexID() {
        return CineplexID;
    }

    /**
     * Changes the cineplex id
     * @param cineplexID the cinplex's ID
     */
    public void setCineplexID(int cineplexID) {
        this.CineplexID = cineplexID;
    }
}