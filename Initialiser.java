import Control.*;
import Entity.AdminAccount;
import Entity.Cinema;
import Entity.Cineplex;
import Utils.CinemaType;
import Utils.MovieStatus;
import Utils.MovieType;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Initialiser {
    public static void main (String[] args) {
        //populate database for pricing
        PricingManager.createPricing(1f, 25f, 7f, 9f, 4f, 8.5f, 11f, 9.5f, 11f, 9.5f, 15f, 11f, 15f);


        //populate database for admin accounts
        createAdminAccounts();

        //populating database for cineplexes
        CineplexManager.createCineplex("Jem");
        CineplexManager.createCineplex("Parkway Parade");
        CineplexManager.createCineplex("Tampines");

        MoviesManager.createMovie("Jurassic Park", MovieType.DIGITAL2D, 140, MovieStatus.NOW_SHOWING, "Steven Spielberg", "Dinosaurs attacking people");
        MoviesManager.createMovie("The Intern", MovieType.DIGITAL3D, 150, MovieStatus.NOW_SHOWING, "Nancy Meyers", "Old man hustling");
        MoviesManager.createMovie("Toy Story", MovieType.BLOCKBUSTER2D, 120, MovieStatus.NOW_SHOWING, "John Lasseter", "Toys uniting to infinity and beyond");
        MoviesManager.createMovie("The Dictator", MovieType.BLOCKBUSTER3D, 130, MovieStatus.NOW_SHOWING, "Larry Charles", "Wadiya leader goes crazy");
        MoviesManager.createMovie("Home Alone 20", MovieType.DIGITAL2D, 110, MovieStatus.PREVIEW, "Chris Columbus", "The parents just suck at this point to have made 20 such movies");
        MoviesManager.createMovie("Finding Nemo", MovieType.DIGITAL2D, 110, MovieStatus.END_OF_SHOW, "Andrew Stanton", "Fish father missing");

        ShowtimesManager.createShowtimes("20/11/2022 10:00", "Jurassic Park", "1C1");
        ShowtimesManager.createShowtimes("20/11/2022 17:00", "The Intern", "1C2");
        ShowtimesManager.createShowtimes("20/11/2022 20:00", "Toy Story", "1C3");
        ShowtimesManager.createShowtimes("21/11/2022 10:00", "The Dictator", "2C1");
        ShowtimesManager.createShowtimes("30/11/2022 17:00", "Home Alone 20", "2C2");
        ShowtimesManager.createShowtimes("10/11/2022 10:00", "Finding Nemo", "2C3");


        System.out.println("Cineplexes Created:");

        ArrayList<Cineplex> CineplexOutput = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
        for (int y = 0; y < CineplexOutput.size(); y++) {
            System.out.println(CineplexOutput.get(y).getCineplexID());
            System.out.println(CineplexOutput.get(y).getCineplexName());
            System.out.println("\n");
        }
//
    //populating database for cinemas
        CinemaManager.createCinema("Jem", "1", CinemaType.PREMIUM);
        CinemaManager.createCinema("Jem", "2", CinemaType.STANDARD);
        CinemaManager.createCinema("Jem", "3", CinemaType.STANDARD);
        CinemaManager.createCinema("Parkway Parade", "1", CinemaType.STANDARD);
        CinemaManager.createCinema("Parkway Parade", "2", CinemaType.STANDARD);
        CinemaManager.createCinema("Parkway Parade", "3", CinemaType.PREMIUM);
        CinemaManager.createCinema("Tampines", "1", CinemaType.PREMIUM);
        CinemaManager.createCinema("Tampines", "2", CinemaType.STANDARD);
        CinemaManager.createCinema("Tampines", "3", CinemaType.STANDARD);

        System.out.println("Cinemas Created:");
    ArrayList<Cinema> CinemaOutput = new ArrayList<Cinema>(CinemaManager.readAllCinemas());
        for(int y=0; y<CinemaOutput.size(); y++){
        System.out.println(CinemaOutput.get(y).getCinemaId());
        System.out.println(CinemaOutput.get(y).getType());
        System.out.println("\n");
    }
}
    public static void createAdminAccounts(){
            try{
                //Creating the object
                AdminAccount admin =new AdminAccount("jx", "test");
                AdminAccount admin2 = new AdminAccount("somesh","test");
                AdminAccount admin3 = new AdminAccount("murong","password");
                AdminAccount admin4 = new AdminAccount("shubu","password2");
                AdminAccount admin5 = new AdminAccount("htut","password3");
                //Creating stream and writing the object
                FileOutputStream fout=new FileOutputStream("DATFiles/AdminAccounts.dat");
                ObjectOutputStream out=new ObjectOutputStream(fout);
                out.writeObject(admin);
                out.writeObject(admin2);
                out.writeObject(admin3);
                out.writeObject(admin4);
                out.writeObject(admin5);
                out.flush();
                //closing the stream
                out.close();
                System.out.println("success");
            }catch(Exception e){System.out.println(e);}
        }



}
