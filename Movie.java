import java.io.Serializable;

<<<<<<< HEAD
public class Movie  implements Serializable {
    private static final long serialVersionUID = -3185918430309702988L;
    private String name;
    private String type;
    private String rating;
    private int showLength;
    private String showingStatus;
    private String director;
    private String synopsis;

    //GET METHODS
=======
public class Movie implements Serializable {
    private String name;

>>>>>>> f2e38669dd69f8725192748250663cf754bef35f
    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public String getType() {
        return type;
    }

    public String getRating() {
        return rating;
    }

    public int getShowLength() {
        return showLength;
    }

    public String getShowingStatus() {
        return showingStatus;
    }


    //SET METHODS
=======
>>>>>>> f2e38669dd69f8725192748250663cf754bef35f
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public void setType(String type) {
        this.type = type;
    }

    public void setRating(String rating) {
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

    //CONSTRUCTOR

    public Movie(String name, String type, String rating, int showLength, String showingStatus, String director, String synopsis) {
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.showLength = showLength;
        this.showingStatus = showingStatus;
        this.director = director;
        this.synopsis = synopsis;
    }





=======
    public Movie(String n){
        this.name = n;
    }
>>>>>>> f2e38669dd69f8725192748250663cf754bef35f
}
