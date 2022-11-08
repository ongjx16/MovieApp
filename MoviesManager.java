import Admin.AdminAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;

public class MoviesManager {

    private static int number = 3;
    public static void createMovie(String name, String type, String rating, int showLength, String showingStatus, String director, String synopsis){
        try{

            //Creating the object
            Movie movie1 = new Movie(name, type, rating, showLength, showingStatus, director, synopsis);

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"), true);
            AppendingObjectOutputStream out = new AppendingObjectOutputStream(fout);
//            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(movie1);
            number++;
            out.flush();
            //closing the stream
            //out.reset();
//            fout.close();
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
            out.reset();

            System.out.println("intialise movies success");
        }catch(Exception e){System.out.println(e);}
    }

    public static Movie[] readAllMovies (){
        Movie[] movieOutput = new Movie[20];
        int i =1;
        boolean cont = true;
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("DATFiles/AllMovies.dat"));

            while (cont){
                Movie movie = null;
                try{
                    movie = (Movie)in.readObject();
                }
                catch(ClassNotFoundException e){
                    e.printStackTrace(
                    );
                }
                if(movie!=null){
                    movieOutput[i] = movie;
                    i++;

                }
                else{
                    cont = false;
                }
            }
            Movie counter = new Movie(null, null, null, i, null, null, null);
            movieOutput[0] = counter;


            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}

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
