import java.io.Serializable;

public class Showtimes implements Serializable {

    private String showtime;

    private String moviename;
    private int movieID;
    private String cinemaID;

    public Showtimes(String showtime,String moviename, int movieID, String cinemaID) {
        this.showtime = showtime;
        this.moviename = moviename;
        this.movieID = movieID;
        this.cinemaID = cinemaID;
    }


    public void setShowtime(String showtime){
        this.showtime = showtime;
    }

    public String getShowtime(){
        return showtime;
    }

    public void setMoviename(String moviename){
        this.moviename = moviename;
    }

    public String getMoviename(){
        return moviename;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setCinemaID(String cinemaID){
        this.cinemaID = cinemaID;
    }


    public String getCinemaID(){
        return cinemaID;
    }










}
