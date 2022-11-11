
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CinemaManager {

    //done
    public static void createCinema(String cineplexName, String cinemaNo, CinemaType cinemaType) {
        try {

            // Creating the object
            ArrayList<Cinema> cinemaList = new ArrayList<Cinema>(readAllCinemas());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllCinemas.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            
            Cinema cinemaToAdd = new Cinema(cineplexName,cinemaNo,cinemaType);

            cinemaList.add(cinemaToAdd);
            // ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(cinemaList);
            out.flush();
            // closing the stream
            // out.reset();
            out.close();
            System.out.println("Cinema created successfully. \n");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //done
    public static ArrayList<Cinema> readAllCinemas() {
        ArrayList<Cinema> CinemaOutput = new ArrayList<Cinema>();
        try {
            // Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllCinemas.dat"));
            CinemaOutput = (ArrayList<Cinema>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
        return (CinemaOutput);
    }

    //done
    public static void deleteCinema(String CinemaID) {
        try {

            // Getting All Cinemas
            ArrayList<Cinema> cinemaList = new ArrayList<Cinema>(readAllCinemas());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllMovies.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);
            int y;
            for (y = 0; y < cinemaList.size(); y++) {
                if (cinemaList.get(y).getCinemaId().equals(CinemaID)) {
                    break;
                }
            }
            cinemaList.remove(y);

            out.writeObject(cinemaList);
            out.flush();
            // closing the stream
            // out.reset();
            fout.close();
            out.close();
            System.out.println("Cinema removed succesfully.\n");
        } catch (Exception e) {
        }
    }

    //done
    public static Cinema getCinemabyID(String CinemaID) {
        ArrayList<Cinema> cinemaOutput = new ArrayList<Cinema>(readAllCinemas());
        Cinema outputCinema = null;

        for (int i = 0; i < cinemaOutput.size(); i++) {
            if (cinemaOutput.get(i).getCinemaId() == CinemaID) {
                outputCinema = cinemaOutput.get(i);
                return outputCinema;
            }
        }

        return (outputCinema);
    }

}
