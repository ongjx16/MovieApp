import java.io.Serializable;

public class Movie implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String n){
        this.name = n;
    }
}
