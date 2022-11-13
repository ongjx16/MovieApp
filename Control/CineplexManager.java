package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.Cineplex;

/**
 * CineplexManager has functions that allow creation, deletion, reading and getting of all cineplexes
 * CineplexManager reads from and writes to the AllCineplexes.dat file
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class CineplexManager {

    /**
     * Creates cineplex
     * Adds cineplex to AllCineplexes.dat
     * Admin privilege only
     * @param cineplexName
     */
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
            System.out.println("src.Entity.Cineplex created successfully. \n");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    /**
     * Gets all cineplexes from AllCineplexes.dat
     * @return Array list of all cineplexes
     */
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

    /**
     * Deletes cineplex
     * Removes cineplex from AllCineplxes.dat
     * Admin privilege only
     * Not used in the code but useful for extensibility of code
     * @param CineplexID
     */
    public static void deleteCineplex(int CineplexID) {
        try {

            // Getting All Cineplexes
            ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>(readAllCineplexes());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllCineplexes.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);
            int y;

            for (y = 0; y < cineplexList.size(); y++) {
                if (cineplexList.get(y).getCineplexID() == CineplexID) {
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
            System.out.println("src.Entity.Cineplex removed succesfully.\n");
        } catch (Exception e) {
        }
    }

    /**
     * Gets specific cineplex by its name
     * @param CineplexName Name of the cineplex wanted
     * @return Cineplex object wanted
     */
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
