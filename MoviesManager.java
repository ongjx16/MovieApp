import Admin.AdminAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;

public class MoviesManager {

    private static int number = 3;
    public static void create(String name, String type, String rating, int showLength, String showingStatus, String director, String synopsis){
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
            System.out.println("success 2");
        }catch(Exception e){System.out.println(e);}
    }

//    public static void main(String [] args){
//        try{
//            //Creating the object
//            Movie movie1 = new Movie("Harry Potter", "2D", "5", 120, "Now Showing", "Jing Xuan", "WOw!");
//            Movie movie2 = new Movie ("Harry Potter 2", "2D", "5", 120, "Now Showing", "Jing Xuan", "WOw!");
//            Movie movie3 = new Movie ("Harry Potter 3", "2D", "5", 120, "Now Showing", "Jing Xuan", "WOw!");
//
//
//            //Creating stream and writing the object
//            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
//            ObjectOutputStream out=new ObjectOutputStream(fout);
//            out.writeObject(movie1);
//            number++;
//            out.flush();
//            //closing the stream
//            out.close();
//            System.out.println("success 2");
//        }catch(Exception e){System.out.println(e);}
//    }

    public static Movie[] readAllMovies (){
        Movie[] movieOutput = new Movie[20];
        int i =0;
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
