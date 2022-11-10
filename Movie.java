import java.io.Serializable;
import java.util.ArrayList;

public class Movie  implements Serializable {
    private static final long serialVersionUID = -3185918430309702988L;
    private String name;
    private String type;
    private int[] rating;
    private int showLength;
    private String showingStatus;
    private String director;
    private String synopsis;
    private int movieID;

    private ArrayList<String> reviews;

    private int sales;

    //GET METHODS

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int[] getRating() {
        return rating;
    }

    public int getShowLength() {
        return showLength;
    }

    public String getShowingStatus() {
        return showingStatus;
    }

    public int getMovieID() {
        return movieID;
    }



    //SET METHODS

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }

    public void setShowLength(int showLength) {
        this.showLength = showLength;
    }

    public void setShowingStatus(String showingStatus) {
        this.showingStatus = showingStatus;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setMovieID(){
        this.movieID = movieID;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public int getSales() {
        return sales;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    //CONSTRUCTOR

    public Movie(String name, String type, int showLength, String showingStatus, String director, String synopsis, int movieID) {
        this.name = name;
        this.type = type;
        this.showLength = showLength;
        this.showingStatus = showingStatus;
        this.director = director;
        this.synopsis = synopsis;
        this.movieID = movieID;
        this.reviews=new ArrayList<String>();
        this.sales=0;
        this.rating = new int[]{0,0};
    }
    public Movie(String n){
        this.name = n;
    }


}
