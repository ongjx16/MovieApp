package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.Movie;
import Entity.Showtimes;

public class ShowtimesManager {


    public static void createShowtimes(String showtime,String moviename,String cinemaID){
        try{

            //Creating the object
            ArrayList<Showtimes> showtimeList = new ArrayList<Showtimes>(readAllShowtimes());
            System.out.println("hello33" + showtimeList.size());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);


            int movieid =0;
            ArrayList<Movie> MoviesArray = new ArrayList<Movie>(MoviesManager.readAllMovies());
            for (int i = 0; i < MoviesArray.size(); i++) {
                if (moviename.equals(MoviesArray.get(i).getName())){
                    movieid = MoviesArray.get(i).getMovieID();
                }
            };

            int showtimeID =0;
            System.out.println(ShowtimesManager.readAllShowtimes().size());
            System.out.println(showtimeList.size());
            if(showtimeList.size()>0){
                showtimeID = showtimeList.get(showtimeList.size()-1).getShowtimeID() +1 ;
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
        }catch(Exception e){
        //     e.printStackTrace(
        // );
    }
    }

    public static ArrayList<Showtimes> readAllShowtimes () {
//        src.Entity.Movie[] movieOutput = new src.Entity.Movie[2];
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
//        src.Entity.Movie[] movieOutput = new src.Entity.Movie[2];
        try {
            //Creating stream to read the object
            ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream("DATFiles/Showtimes.dat"));
            in.close();
        } catch (Exception e) {
        //     e.printStackTrace(
        // )
        ;}
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
            ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/Showtimes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            String date;
            Scanner scan = new Scanner(System.in);
            int indexForShowtimes =1;

            if (attribute == "showtime"){
                System.out.println("Current: ");
                //System.out.println(showtimeList.size());
                for (int i =0; i<showtimeList.size(); i++){
                    //System.out.println(showtimeList.get(i).getShowtime());
                    if(MoviesArray.get(index).getMovieID()==(showtimeList.get(i).getMovieID())){
                        System.out.println(Integer.toString(indexForShowtimes) +". "+ MoviesArray.get(index).getName()+ " " + showtimeList.get(i).getShowtime() + " " + showtimeList.get(i).getCinemaID());
                        indexForShowtimes++;
                    }
                    else {
                        //System.out.println("No Showtime for src.Entity.Movie found!");
                        //return;
                    }
                }

                System.out.println("Choose which Showtime you want to edit: ");
                int showtimeChoice = scan.nextInt() - 1;

//                System.out.println("Enter new showtime in this format- DD/MM/YYYY HH:mm: ");
//                scan.nextLine();
//                String newShowtime = scan.nextLine();



                System.out.println("Enter Date in this format- DD/MM/YYYY: ");
                scan.nextLine();
                date = scan.nextLine();


                System.out.println("Choose a showtime from the following list:\n");


//                     initialise an array of timings for admin to choose from
                String[] timings;
                ArrayList<String> newTimings = new ArrayList<String>();
                timings = new String[5];
                timings[0] = "10:00";
                timings[1] = "12:30";
                timings[2] = "15:00";
                timings[3] = "17:30";
                timings[4] = "20:00";
                int k = 1;

                boolean toAdd;

                    ArrayList<Showtimes> arrayoftimes = new ArrayList<Showtimes>(ShowtimesManager.searchShowtimes(date, 1));
                    for (int j = 0; j < 5; j++) {
                        toAdd= true;
                        for (int i = 0; i < arrayoftimes.size(); i++ ) {
                            if ((arrayoftimes.get(i).getShowtime().substring(11).equals(timings[j]))) { // arrayoftimes.get(i).getShowtime().substring(0,11).equals(showtimeList.get(index).getShowtime().substring(0,11))
                                toAdd = false;
                            }
                            ;
                        }
                        if (toAdd == true){
                            System.out.println(Integer.toString(k) + ". " + timings[j]);
                            newTimings.add(timings[j]);
                            k++;
                        }

                    }
                    int choiceoftime = scan.nextInt();


                    String newShowtime = date + " " + newTimings.get(choiceoftime - 1);


                showtimeList.get(showtimeChoice).setShowtime(newShowtime);
//                for (int i =0; i<showtimeList.size(); i++){
//                    System.out.println(showtimeList.get(i).getShowtime());
//                }
            }



            else if (attribute == "cinemaID"){
                System.out.println("Current src.Entity.Cineplex ID: " + showtimeList.get(index).getCinemaID().substring(0,2));
                System.out.println("Current src.Entity.Showtimes for Selected src.Entity.Cineplex: " );
                for (int i =0; i<showtimeList.size(); i++){
                    if(showtimeList.get(index).getCinemaID().substring(0,2).equals((showtimeList.get(i).getCinemaID()).substring(0,2))){
                        System.out.println(Integer.toString(i+1)+ ". "+ showtimeList.get(i).getMoviename()+ " " + showtimeList.get(i).getShowtime() + " " + showtimeList.get(i).getCinemaID());
                    }
                    else {
                            System.out.println("No Showtime for src.Entity.Cineplex ID found!");
                            //return;
                    }
                }

                System.out.println("Choose which showtime you would like to change the src.Entity.Cinema ID for:  ");
                int showtimeChoice = scan.nextInt() -1 ;




                System.out.println("Select New src.Entity.Cinema ID to Change To: \n");
                String[] CIDs;
                CIDs = new String[9];
                CIDs[0] = "1C1";
                CIDs[1] = "1C2";
                CIDs[2] = "1C3";
                CIDs[3] = "2C1";
                CIDs[4] = "2C2";
                CIDs[5] = "2C3";
                CIDs[6] = "3C1";
                CIDs[7] = "3C2";
                CIDs[8] = "3C3";

                for (int i =0; i < CIDs.length; i++){
                    System.out.println(Integer.toString(i+1)+ ". " + CIDs[i]);
                }

                int cinemareplace = scan.nextInt() - 1;
                String newCinema = CIDs[cinemareplace];
                showtimeList.get(showtimeChoice).setCinemaID(newCinema);
                System.out.println("src.Entity.Cinema you have changed to is: "+ newCinema);

            }

            else if (attribute == "showtime2"){
                System.out.println("Current: ");
                //System.out.println(showtimeList.size());
                for (int i =0; i<showtimeList.size(); i++){
                    //System.out.println(showtimeList.get(i).getShowtime());
                    //if(MoviesArray.get(index).getMovieID()==(showtimeList.get(i).getMovieID())){
                    if (showtimeList.get(index).getCinemaID().equals(showtimeList.get(i).getCinemaID())){
                        System.out.println(Integer.toString(i + 1) +". "+ showtimeList.get(i).getMoviename()+ " " + showtimeList.get(i).getShowtime() + " " + showtimeList.get(i).getCinemaID());
                    }
                    //}
//                    else {
//                        //System.out.println("No Showtime for src.Entity.Movie found!");
//                        return;
//                    }
                }
                System.out.println("Choose which Showtime you want to edit: ");
                int showtimeChoice = scan.nextInt() - 1;
                System.out.println("Enter new showtime in this format- DD/MM/YYYY HH:mm: ");
                scan.nextLine();
                String newShowtime = scan.nextLine();
                showtimeList.get(showtimeChoice).setShowtime(newShowtime);
//                for (int i =0; i<showtimeList.size(); i++){
//                    System.out.println(showtimeList.get(i).getShowtime());
//                }
            }

            out.writeObject(showtimeList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("showtime successfully edited");
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
        } catch (Exception e) {
        //     e.printStackTrace(
        // );
    }
        return arraytoadd;


    }

    public static void updateSeats(int showtimeID, int row, String col){
        //ArrayList<src.Entity.Showtimes> arraytoadd = new ArrayList<src.Entity.Showtimes>();
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
        } catch (Exception e) {
        //     e.printStackTrace(
        // );
    }





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
