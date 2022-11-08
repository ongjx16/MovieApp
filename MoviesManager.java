import Admin.AdminAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MoviesManager {

    private static int number = 3;
    public static void createMovie(String name, String type, String rating, int showLength, String showingStatus, String director, String synopsis){
        try{

            //Creating the object
            ArrayList<Movie> movieList = new ArrayList<Movie>();
            movieList.add(new Movie ("jurassic world", "awfwf", "afwf", 123, "afaw","afwf","afawfew"));
            movieList.add(new Movie ("harry potter", "awfwf", "afwf", 123, "afaw","afwf","afawfew"));
//            Movie movie1 = new Movie(name, type, rating, showLength, showingStatus, director, synopsis);

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"), true);
            ObjectOutputStream out = new ObjectOutputStream(fout);
//            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(movieList);
            number++;
            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("create movie success");
        }catch(Exception e){System.out.println(e);}
    }

    public static void initialiseMovies(){
        try{

            //Creating the object

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"), true);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.close();

            System.out.println("intialise movies success");
        }catch(Exception e){System.out.println(e);}
    }

    public static ArrayList<Movie> readAllMovies (){
//        Movie[] movieOutput = new Movie[2];
        ArrayList<Movie> movieOutput = new ArrayList<Movie>();
        int i =0;
        boolean cont = true;
        try{
            //Creating stream to read the object
            FileInputStream fis = new FileInputStream("DATFiles/AllMovies.dat");
            ObjectInputStream in=new ObjectInputStream(fis);
            movieOutput = (ArrayList<Movie>) in.readObject();
            System.out.println(movieOutput);
//            while (cont){
//                Movie movie = null;
//                try{
//                    movie = (Movie)in.readObject();
//                }
//                catch(ClassNotFoundException e){
//                    e.printStackTrace(
//                    );
//                }
//                if(movie!=null){
//                    movieOutput[i] = movie;
//                    System.out.println(i);
//                    System.out.println(movieOutput[i].getName());
//                    i++;
//
//                }
//                else{
//                    cont = false;
//                }
//            }
//            Movie counter = new Movie(null, null, null, i, null, null, null);
//            movieOutput[0] = counter



            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}

//        for (int l = 0; l < movieOutput.size(); l++) {
//            System.out.println(l);
//            System.out.println(movieOutput.get(l).getName());
//        }
        System.out.println(movieOutput);

        return(movieOutput);

    }

    public static int getNumber() {
        return number;
    }

    public static class AppendingObjectOutputStream extends ObjectOutputStream {

        public AppendingObjectOutputStream(FileOutputStream out2) throws IOException {
            super(out2);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header, but reset:
            // this line added after another question
            // showed a problem with the original
            reset();
        }

    }



}
