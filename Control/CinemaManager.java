package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.Cinema;
import Utils.CinemaType;

/**
 * CinemaManager has functions that allow creation, deletion, reading and getting of all cinemas
 * CinemaManager reads from and writes to the AllCinemas.dat file
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */

public class CinemaManager {

    /**
     * Creates cinema
     * Updates AllCinemas.dat with the created cinema
     * Admin privilege only
     * @param cineplexName Name of cineplex that cinema is in
     * @param cinemaNo CinemaID of cinema created
     * @param cinemaType Cinema type of cinema created
     */
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
            System.out.println("src.Entity.Cinema created successfully. \n");
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    /**
     * Gets all cinemas from the AllCinemas.dat fie
     * @return An array list of Cinema objects
     */
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

    /**
     * Deletes cinema
     * Removes cinema chosen from AllCinemas.dat
     * Admin privilege only
     * @param CinemaID ID of cinema that needs to be removed
     */
    public static void deleteCinema(String CinemaID) {
        try {

            // Getting All Cinemas
            ArrayList<Cinema> cinemaList = new ArrayList<Cinema>(readAllCinemas());

            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllCinemas.dat"));
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
        } catch (Exception e) {
        }
    }

    /**
     * Gets specific cinema by its ID
     * @param CinemaID ID of cinema wanted
     * @return Cinema object needed
     */
    public static Cinema getCinemabyID(String CinemaID) {
        ArrayList<Cinema> cinemaOutput = new ArrayList<Cinema>(readAllCinemas());
        Cinema outputCinema = null;
        for (int i = 0; i < cinemaOutput.size(); i++) {
            if (cinemaOutput.get(i).getCinemaId().equals(CinemaID.toUpperCase())) {
                outputCinema = cinemaOutput.get(i);
                return outputCinema;
            }
        }

        return (outputCinema);
    }

}
