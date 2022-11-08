import Admin.AdminAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviesManager {

    private static int number = 3;
    public static void createMovie(String name, String type, String rating, int showLength, String showingStatus, String director, String synopsis){
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


            Movie movie1 = new Movie(name, type, rating, showLength, showingStatus, director, synopsis, id);

            movieList.add(movie1);
//            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(movieList);
            number++;
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
            number++;
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
                String newType = scan.nextLine();
                movieList.get(index).setType(newType);
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
                String status = scan.nextLine();
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
            System.out.println("movie successfully removed");
        }catch(Exception e){}
    }








}
