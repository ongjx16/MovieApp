
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CineplexManager {

    public static void createCineplex(String cineplexName) {
        try {

            // Getting All Cineplexes
            ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>(readAllCineplexes());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllCineplexes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int id;
            if (cineplexList.size() > 0) {
                id = cineplexList.get(cineplexList.size() - 1).getCineplexID() + 1;
            } else {
                id = 1;
            }

            Cineplex cineplexToAdd = new Cineplex(cineplexName, id);

            cineplexList.add(cineplexToAdd);
            // ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(cineplexList);
            out.flush();
            // closing the stream
            // out.reset();
            out.close();
            System.out.println("Cineplex created successfully. \n");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    // done
    public static ArrayList<Cineplex> readAllCineplexes() {
        ArrayList<Cineplex> CineplexOutput = new ArrayList<Cineplex>();
        try {
            // Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllCineplexes.dat"));
            CineplexOutput = (ArrayList<Cineplex>) in.readObject();
            in.close();
        } catch (Exception e) {
        }
        return (CineplexOutput);
    }

    // done
    public static void deleteCinema(int CinemaID) {
        try {

            // Getting All Cineplexes
            ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>(readAllCineplexes());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllCineplexes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);
            int y;

            for (y = 0; y < cineplexList.size(); y++) {
                if (cineplexList.get(y).getCineplexID() == CinemaID) {
                    break;
                }
            }

            cineplexList.remove(y);

            out.writeObject(cineplexList);
            out.flush();
            // closing the stream
            // out.reset();
            fout.close();
            out.close();
            System.out.println("Cineplex removed succesfully.\n");
        } catch (Exception e) {
        }
    }

    // done
    public static int getCineplexIDByName(String CineplexName) {
        ArrayList<Cineplex> cineplexOutput = new ArrayList<Cineplex>(readAllCineplexes());
        int IDOutput = 0;

        for (int i = 0; i < cineplexOutput.size(); i++) {
            if (cineplexOutput.get(i).getCineplexName().toLowerCase().equals(CineplexName.toLowerCase())) {
                IDOutput = cineplexOutput.get(i).getCineplexID();
                return IDOutput;
            }
        }

        return (IDOutput);
    }

}
