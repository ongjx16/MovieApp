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
        for(int i=0;i<movies.length;i++){
            movies[i]= new Movie("Jurassic World");
        }
        for(int j=0;j<movies.length;j++){
            movieNames[j]= new Movie("Jurassic World").getName();
        }
        for(int i=0;i<cinemas.length;i++){
            cinemas[i]= new Cinema(this.cineplexName+ (i + 1));
        }
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
