import java.io.Serializable;

public class Showtimes implements Serializable {
    private static final long serialVersionUID = -9144363532793385492L;

    private String showtime;

    private String moviename;
    private int movieID;
    private String cinemaID;

    private SeatingPlan seats;

    private int showtimeID;

    public Showtimes(String showtime,String moviename, int movieID, String cinemaID, int showtimeID) {
        this.showtime = showtime;
        this.moviename = moviename;
        this.movieID = movieID;
        this.cinemaID = cinemaID;
        this.seats = new SeatingPlan(15,15);
        this.showtimeID = showtimeID;
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

    public SeatingPlan getSeats(){
        return seats;
    }

    public int getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }
}
