package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Utils.MovieStatus;
import Utils.MovieType;
import Entity.Movie;

public class MoviesManager {


    public static void createMovie(String name, MovieType type, int showLength, MovieStatus showingStatus, String director, String synopsis){
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int id;
        if(movieList.size()>0){
            id = movieList.get(movieList.size()-1).getMovieID() +1 ;
        }
        else{
            id = 1;
        }


            Movie movie1 = new Movie(name, type, showLength, showingStatus, director, synopsis, id);

            movieList.add(movie1);
//            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(movieList);
            out.flush();
            //closing the stream
            //out.reset();
            out.close();
            System.out.println("create movie success");
        }catch(Exception e){e.printStackTrace(
        );}
    }

    public static ArrayList<Movie> readAllMovies () {
//        Movie[] movieOutput = new Movie[2];
        ArrayList<Movie> movieOutput = new ArrayList<Movie>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllMovies.dat"));
            movieOutput = (ArrayList<Movie>) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace(
        );}
        return (movieOutput);
    }

    public static void deleteMovie (int index) {
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            movieList.remove(index);

            out.writeObject(movieList);
            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("movie successfully removed");
        }catch(Exception e){}
    }

    public static void editMovie (int index, String attribute) {
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);

            if (attribute == "name"){
                System.out.println("Current: " + movieList.get(index).getName());
                System.out.println("Enter new name: ");
                String newName = scan.nextLine();
                movieList.get(index).setName(newName);
            }
            else if (attribute == "type"){
                System.out.println("Current: " + movieList.get(index).getType());
                System.out.println("Enter updated movie type: ");
                System.out.println("[1] " + MovieType.DIGITAL2D.toString());
                System.out.println("[2] " + MovieType.DIGITAL3D.toString());
                System.out.println("[3] " + MovieType.BLOCKBUSTER2D.toString());
                System.out.println("[4] " + MovieType.BLOCKBUSTER3D.toString());

                int typeChoice = scan.nextInt();
                MovieType type;

                while(typeChoice<1 && typeChoice>4){
                    System.out.println("Invalid Choice. Choose Again.");
                    typeChoice = scan.nextInt();
                }

                if (typeChoice == 1){
                    type = MovieType.DIGITAL2D;
                }
                else if (typeChoice == 2){
                    type = MovieType.DIGITAL3D;
                }
                else if (typeChoice == 3){
                    type = MovieType.BLOCKBUSTER2D;
                }
                else {
                    type = MovieType.BLOCKBUSTER3D;
                }
                movieList.get(index).setType(type);
            }
            else if (attribute == "length"){
                System.out.println("Current: " + movieList.get(index).getShowLength());
                System.out.println("Enter updated show length in minutes: ");
                int length = scan.nextInt();
                movieList.get(index).setShowLength(length);
            }
            else if (attribute == "status"){
                System.out.println("Current: " + movieList.get(index).getShowingStatus());
                System.out.println("Enter updated showing status: ");
                System.out.println("[1] " + MovieStatus.PREVIEW.toString());
                System.out.println("[2] " + MovieStatus.NOW_SHOWING.toString());
                System.out.println("[3] " + MovieStatus.END_OF_SHOW.toString());

                int statusChoice = scan.nextInt();
                MovieStatus status;

                while(statusChoice<1 && statusChoice>3){
                    System.out.println("Invalid Choice. Choose Again.");
                    statusChoice = scan.nextInt();
                }

                if (statusChoice == 1){
                    status = MovieStatus.PREVIEW;
                }
                else if (statusChoice == 2){
                    status = MovieStatus.NOW_SHOWING;
                }
                else {
                    status = MovieStatus.END_OF_SHOW;
                }
                movieList.get(index).setShowingStatus(status);
            }
            else if (attribute == "director"){
                System.out.println("Current: " + movieList.get(index).getDirector());
                System.out.println("Enter updated director name: ");
                String director = scan.nextLine();
                movieList.get(index).setDirector(director);
            }
            else if (attribute == "synopsis"){
                System.out.println("Current: " + movieList.get(index).getSynopsis());
                System.out.println("Enter updated synopsis: ");
                String synopsis = scan.nextLine();
                movieList.get(index).setSynopsis(synopsis);
            }

            out.writeObject(movieList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("Movie has been successfully deleted!");
        }catch(Exception e){}
    }

    public static ArrayList<Movie> filterByStatus (ArrayList<Movie>moviesInput) {
        ArrayList<Movie> filteredOutput = new ArrayList<Movie>();
        for(int i =0; i<moviesInput.size();i++){
            if(!moviesInput.get(i).getShowingStatus().equals(MovieStatus.END_OF_SHOW)){
                filteredOutput.add(moviesInput.get(i));
            }

        }

        return (filteredOutput);
    }

    public static Movie getMoviebyID (int MovieID) {
        ArrayList<Movie> movieOutput = new ArrayList<Movie>(readAllMovies());
        Movie outputMovie = null;

        for (int i = 0; i<movieOutput.size(); i++){
            if (movieOutput.get(i).getMovieID() == MovieID){
                outputMovie = movieOutput.get(i);
                return outputMovie;
            }
        }

        return (outputMovie);
    }

    public static void increaseSales (int MovieID, int toAdd) {
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int y;
           for (y=0; y<movieList.size(); y++){
               if (movieList.get(y).getMovieID() == MovieID){
                   break;
               }
           }

           int newSales = movieList.get(y).getSales()+toAdd;
            movieList.get(y).setSales(newSales);

            out.writeObject(movieList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println(movieList.get(y).getMovieID());
            System.out.println("Movie Sales Successfully Updated.");
        }catch(Exception e){}
    }

    public static void addReviews (int MovieID, String newReview) {
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int y;
            for (y=0; y<movieList.size(); y++){
                if (movieList.get(y).getMovieID() == MovieID){
                    break;
                }
            }

            ArrayList<String> reviews = new ArrayList<String>(movieList.get(y).getReviews());

            reviews.add(newReview);

            movieList.get(y).setReviews(reviews);

            out.writeObject(movieList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("Movie review successfully added!");
        }catch(Exception e){}
    }

    public static void updateRating (int MovieID, float newRating) {
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllMovies());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int y;
            for (y=0; y<movieList.size(); y++){
                if (movieList.get(y).getMovieID() == MovieID){
                    break;
                }
            }

            float[] currentRating = movieList.get(y).getRating();
            float[] updated = new float[2];

            if (currentRating[0] ==0){
                updated[0] = 1;
                updated[1] = newRating;
            }
            else{
                //return average rating with new rating included
                updated[0] = (currentRating[0])+1;
                updated[1] = (currentRating[1]+newRating)/(updated[0]);
            }

            movieList.get(y).setRating(updated);

            out.writeObject(movieList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
//            System.out.println(movieList.get(y).getMovieID());
            System.out.println("Movie ratings successfully updated!");
        }catch(Exception e){}
    }



}
