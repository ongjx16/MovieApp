import java.io.Serializable;
import java.util.ArrayList;
import java.lang.String;
import java.io.Serializable;
public class Cineplex implements Serializable {
    private static final long serialVersionUID = 4L;
    // 3 cineplexes
    // One cineplex is one cinema at a location eg JEM cathay is 1 cineplex
    // each cineplex has 3 halls (cinema)

    private Cinema[] cinemas = new Cinema[3];
    private Movie[] movies = new Movie[5];
    private String[] movieNames = new String[5];
    private String cineplexName;
    private int numOfHalls;


    public Cineplex(String cineplexName) {
        this.cineplexName = cineplexName;
        numOfHalls=3;
        movies[0]= new Movie("Jurassic Park", MovieType.BLOCKBUSTER2D, 3, MovieStatus.NOW_SHOWING, "Steven Spielberg",
                "In Steven Spielberg's massive blockbuster, " +
                        "paleontologists Alan Grant (Sam Neill) and Ellie Sattler (Laura Dern) " +
                        "and mathematician Ian Malcolm (Jeff Goldblum) are among a select group " +
                        "chosen to tour an island theme park populated by dinosaurs created from " +
                        "prehistoric DNA. While the park's mastermind, billionaire John Hammond " +
                        "(Richard Attenborough), assures everyone that the facility is safe, they " +
                        "find out otherwise when various ferocious predators break free and go on " +
                        "the hunt.", 1);

        movies[1]= new Movie("Black Panther");
        movies[2]= new Movie("The Intern");
        movies[3]= new Movie("Avengers: End Game");
        movies[4]= new Movie("Sully");

        movieNames[0]= new Movie("Jurassic World").getName();
        movieNames[1]= new Movie("Black Panther").getName();
        movieNames[2]= new Movie("The Intern").getName();
        movieNames[3]= new Movie("Avengers: End Game").getName();
        movieNames[4]= new Movie("Sully").getName();

        for(int i=0;i<cinemas.length;i++){
            cinemas[i]= new Cinema(this.cineplexName+ (i + 1), new SeatingPlan(9, 9), CinemaType.STANDARD);
        }
    }

    public Movie getMovieDetails(int a){
        return movies[a-1];
    }

    public String[] getMovies() {
        for(int i=0;i<movies.length;i++){
            movieNames[i]=movies[i].getName();
        }
        return movieNames;

    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public void setCineplexName(String cineplexName){
        this.cineplexName = cineplexName;
    }

    public String getCineplexName(){
        return cineplexName;
    }

}
