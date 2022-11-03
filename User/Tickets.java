package User;

public class Tickets {
    private String movieChosen;
    private String cinemaChosen;
    private String dateChosen;
    private String timeChosen;
    private String [] Seat;
    private int age;
    private double price;

    public void setMovieChosen(String x){
        this.movieChosen = x;
    }
    public void setCinemaChosen(String y){
        this.cinemaChosen = y;
    }
    public void setDateChosen(String z){
        this.dateChosen = z;
    }
    public void setTimeChosen(String a){
        this.timeChosen = a;
    }
    public void setage(int b){
        this.age = b; // this needs to be calculated based on the seat you've chosen or inside the seat class
    }
    public void setPrice(double c){
        this.price = c; // this needs to be calculated based on the seat you've chosen or inside the seat class penispenis
    }
}