import Admin.AdminAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowtimesManager {


    public static void createShowtimes(String showtime,String moviename,String cinemaID){
        try{

            //Creating the object
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);


            int movieid =0;
            ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
            for (int i = 0; i < MoviesArray.size(); i++) {
                if (moviename.equals(MoviesArray.get(i).getName())){
                    movieid = MoviesArray.get(i).getMovieID();
                }
            };

            int showtimeID =0;
            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
            if(ShowtimesArray.size()>0){
                showtimeID = ShowtimesArray.get(ShowtimesArray.size()-1).getShowtimeID() +1 ;
            }
            else{
                showtimeID = 1;
            }

            Showtimes showtime1 = new Showtimes(showtime, moviename, movieid, cinemaID, showtimeID);

            showtimeList.add(showtime1);
//            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(showtimeList);
            out.flush();
            //closing the stream
            //out.reset();
            out.close();
            System.out.println("create showtime success");
        }catch(Exception e){e.printStackTrace(
        );}
    }

    public static ArrayList<Showtimes> readAllShowtimes () {
//        Movie[] movieOutput = new Movie[2];
        ArrayList<Showtimes> showtimesOutput = new ArrayList<Showtimes>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/Showtimes.dat"));
            showtimesOutput = (ArrayList<Showtimes>) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace(
        );}
        return (showtimesOutput);
    }

    public static void initialiser () {
//        Movie[] movieOutput = new Movie[2];
        try {
            //Creating stream to read the object
            ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream("DATFiles/Showtimes.dat"));
            in.close();
        } catch (Exception e) {e.printStackTrace(
        );}
    }

    public static void deleteShowtimes (int index) {
        try{

            //Creating the object
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            showtimeList.remove(index);

            out.writeObject(showtimeList);
            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("Showtime successfully removed");
        }catch(Exception e){}
    }

    public static void editShowtime (int index, String attribute) {
        try{

            //Creating the object
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);

            if (attribute == "showtime"){
                System.out.println("Current: " + showtimeList.get(index).getShowtime());
                System.out.println("Enter new showtime in this format- DD/MM/YYYY HH:mm: ");
                String newShowtime = scan.nextLine();
                showtimeList.get(index).setShowtime(newShowtime);
            }
            else if (attribute == "moviename"){
                System.out.println("Current: " + showtimeList.get(index).getMoviename());
                System.out.println("Enter updated movie name: ");
                String newName = scan.nextLine();
                showtimeList.get(index).setMoviename(newName);
            }
            else if (attribute == "movieID"){
                System.out.println("Current: " + showtimeList.get(index).getMovieID());
                System.out.println("Enter updated movie ID ");
                int newmovieID = scan.nextInt();
                showtimeList.get(index).setMovieID(newmovieID);
            }
            else if (attribute == "cinemaID"){
                System.out.println("Current: " + showtimeList.get(index).getCinemaID());
                System.out.println("Enter updated cinema ID: ");
                String status = scan.nextLine();
                showtimeList.get(index).setCinemaID(status);
            }


            out.writeObject(showtimeList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("showtime successfully removed");
        }catch(Exception e){}
    }

    public static ArrayList<Showtimes> searchShowtimes(String date, int movieid){
        ArrayList<Showtimes> arraytoadd = new ArrayList<Showtimes>();
        try {
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());
            for (int i =0; i< showtimeList.size(); i++){
                //System.out.println((showtimeList.get(i).getShowtime()).substring(0,10));
                if (date.equals((showtimeList.get(i).getShowtime()).substring(0,10)) && showtimeList.get(i).getMovieID() == movieid){
                    arraytoadd.add(showtimeList.get(i));
                }
            }
        } catch (Exception e) {e.printStackTrace(
        );}
        return arraytoadd;


    }

    public static void updateSeats(int showtimeID, int row, String col){
        //ArrayList<Showtimes> arraytoadd = new ArrayList<Showtimes>();
        try {

            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());

            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);

            int i;
            for (i =0; i< showtimeList.size(); i++){
                //System.out.println((showtimeList.get(i).getShowtime()).substring(0,10));
                if (showtimeList.get(i).getShowtimeID() == showtimeID){
                    //arraytoadd.add(showtimeList.get(i));
                    break;
                }
            }
            showtimeList.get(i).getSeats().assignSeat(row,col);
            out.writeObject(showtimeList);
            out.close();
        } catch (Exception e) {e.printStackTrace(
        );}





    }

    public static ArrayList<Integer> moviesByCineplex(int cineplex){
        ArrayList<Showtimes> filterarray = new ArrayList<Showtimes>();
        ArrayList<Integer> moviesarray = new ArrayList<Integer>();
        try {
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());
            for (int i =0; i< showtimeList.size(); i++){
                //System.out.println((showtimeList.get(i).getShowtime()).substring(0,10));
                if (String.valueOf(showtimeList.get(i).getCinemaID().charAt(0)).equals(String.valueOf(cineplex))){
                    filterarray.add(showtimeList.get(i));
                }
            }

            for (int y = 0; y< filterarray.size(); y++){
                if (!moviesarray.contains(filterarray.get(y).getMovieID())){
                    moviesarray.add(filterarray.get(y).getMovieID());
                }
            }

        } catch (Exception e) {e.printStackTrace(
        );}
        return moviesarray;


    }
    public static ArrayList<Showtimes> showtimesByMovieAndCineplex(int cineplex, int movieId){

        ArrayList<Showtimes> filteredShowtimes = new ArrayList<Showtimes>();
        try {
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());
            for (int i =0; i< showtimeList.size(); i++){
                //System.out.println((showtimeList.get(i).getShowtime()).substring(0,10));
                if (showtimeList.get(i).getMovieID()==movieId && String.valueOf(showtimeList.get(i).getCinemaID().charAt(0)).equals(String.valueOf(cineplex))){
                    filteredShowtimes.add(showtimeList.get(i));
                }
            }

        } catch (Exception e) {e.printStackTrace(
        );}
        return filteredShowtimes;


    }

    public static ArrayList<String> showtimeDates(ArrayList<Showtimes> showtimesAvailable ){

        ArrayList<String> dates = new ArrayList<String>();

        for (int i =0; i< showtimesAvailable.size(); i++){
            boolean repeat = false;
            for (int y = 0; y<dates.size(); y++){
                if ((showtimesAvailable.get(i).getShowtime().substring(0,10)).equals(dates.get(y))){
                    repeat = true;
                }
            }

            if (repeat == false){
                dates.add(showtimesAvailable.get(i).getShowtime().substring(0,10));
            }

        }

        return dates;


    }




}
