package User;

public class tickets {
    private String movieChosen;
    private String cinemaChosen;
    private String dateChosen;
    private String timeChosen;
    private String seatId;
    private int age;
    private double price;

    public tickets(String movie, String cinemaCode, String date, String time, String seatID){
        this.movieChosen = movie;
        this.cinemaChosen = cinemaCode;
        this.dateChosen = date;
        this.timeChosen = time;
        this.seatId = seatID;
        System.out.println("---------------------");
        System.out.println("Movie: " + movieChosen + "\nCinema: " + cinemaChosen + "\nDate: " + dateChosen + "\nTime: " + timeChosen +"\nSeat: " + seatId);
        System.out.println("---------------------");
    }

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