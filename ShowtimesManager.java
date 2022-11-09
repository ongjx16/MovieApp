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


    public static void createShowtimes(String showtime,String moviename,int movieID, String cinemaID){
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

            Showtimes showtime1 = new Showtimes(showtime, moviename, movieid, cinemaID);

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
                if (date.equals((showtimeList.get(i).getShowtime()).substring(0,8)) && showtimeList.get(i).getMovieID() == movieid){
                    arraytoadd.add(showtimeList.get(i));
                }
            }
        } catch (Exception e) {e.printStackTrace(
        );}
        return arraytoadd;


    }








}
