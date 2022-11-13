import Control.*;
import Entity.*;
import Utils.CinemaType;
import Utils.MovieStatus;
import Utils.MovieType;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;

public class Initialiser {
    public static void main (String[] args) {
        //populate database for pricing
        File pricing= new File("DATFiles/AllPricing.dat");
        pricing.delete();
        PricingManager.createPricing(1f, 25f, 7f, 9f, 4f, 8.5f, 11f, 9.5f, 11f, 9.5f, 15f, 11f, 15f);


        //populate database for admin accounts
        File admin= new File("DATFiles/AdminAccounts.dat");
        admin.delete();
        createAdminAccounts();

        //populating database for cineplexes
        File cineplexes= new File("DATFiles/AllCineplexes.dat");
        cineplexes.delete();
        CineplexManager.createCineplex("Jem");
        CineplexManager.createCineplex("Parkway Parade");
        CineplexManager.createCineplex("Tampines");

        System.out.println("Cineplexes Created:");

        ArrayList<Cineplex> CineplexOutput = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
        for (int y = 0; y < CineplexOutput.size(); y++) {
            System.out.println(CineplexOutput.get(y).getCineplexID());
            System.out.println(CineplexOutput.get(y).getCineplexName());
            System.out.println("\n");
        }

        //populating movies
        File movie= new File("DATFiles/ALlMovies.dat");
        movie.delete();
        MoviesManager.createMovie("Jurassic Park", MovieType.DIGITAL2D, 140, MovieStatus.NOW_SHOWING, "Steven Spielberg", "Dinosaurs attacking people");
        MoviesManager.createMovie("The Intern", MovieType.DIGITAL3D, 150, MovieStatus.NOW_SHOWING, "Nancy Meyers", "Old man hustling");
        MoviesManager.createMovie("Toy Story", MovieType.BLOCKBUSTER2D, 120, MovieStatus.NOW_SHOWING, "John Lasseter", "Toys uniting to infinity and beyond");
        MoviesManager.createMovie("The Dictator", MovieType.BLOCKBUSTER3D, 130, MovieStatus.NOW_SHOWING, "Larry Charles", "Wadiya leader goes crazy");
        MoviesManager.createMovie("Home Alone 20", MovieType.DIGITAL2D, 110, MovieStatus.PREVIEW, "Chris Columbus", "The parents just suck at this point to have made 20 such movies");
        MoviesManager.createMovie("Finding Nemo", MovieType.DIGITAL2D, 110, MovieStatus.END_OF_SHOW, "Andrew Stanton", "Fish father missing");

        //for video
        MoviesManager.createMovie("Avengers", MovieType.DIGITAL2D, 110, MovieStatus.NOW_SHOWING, "Andrew Garfield", "Avengers fighting");


        //populate ratings
        MoviesManager.updateRating(1, 10);
        MoviesManager.updateRating(1, 8);
        MoviesManager.updateRating(2, 6);
        MoviesManager.updateRating(2, 7);
        MoviesManager.updateRating(3, 9);
        MoviesManager.updateRating(3, 10);
        MoviesManager.updateRating(5, 5);
        MoviesManager.updateRating(5, 7);
        MoviesManager.updateRating(6, 3);
        MoviesManager.updateRating(6, 4);

        //populate reviews
        MoviesManager.addReviews(1, "Great movie! Thoroughly enjoyed it.");
        MoviesManager.addReviews(1, "Loved the movie! My friends and I all enjoyed it.");
        MoviesManager.addReviews(2, "Great movie! Thoroughly enjoyed it.");
        MoviesManager.addReviews(2, "Loved the movie! My friends and I all enjoyed it.");
        MoviesManager.addReviews(4, "Great movie! Thoroughly enjoyed it.");
        MoviesManager.addReviews(4, "Loved the movie! My friends and I all enjoyed it.");
        MoviesManager.addReviews(6, "Great movie! Thoroughly enjoyed it.");
        MoviesManager.addReviews(6, "Loved the movie! My friends and I all enjoyed it.");


        //populating showtimes
        File showtimes= new File("DATFiles/Showtimes.dat");
        showtimes.delete();
        //for video
        ShowtimesManager.createShowtimes("21/11/2022 10:00", "Jurassic Park", "1C3");
        ShowtimesManager.createShowtimes("21/11/2022 12:30", "Jurassic Park", "1C2");
        ShowtimesManager.createShowtimes("21/11/2022 15:00", "Jurassic Park", "1C1");
        ShowtimesManager.createShowtimes("22/11/2022 15:00", "Jurassic Park", "1C3");
        ShowtimesManager.createShowtimes("23/11/2022 15:00", "Jurassic Park", "1C3");
        ShowtimesManager.createShowtimes("23/11/2022 15:00", "Avengers", "1C1");


        ShowtimesManager.createShowtimes("22/11/2022 10:00", "Jurassic Park", "1C1"); //change date back to 20/11/2022
        ShowtimesManager.createShowtimes("20/11/2022 17:30", "The Intern", "1C2");
        ShowtimesManager.createShowtimes("20/11/2022 20:00", "Toy Story", "1C3");
        ShowtimesManager.createShowtimes("21/11/2022 10:00", "The Dictator", "2C1");
        ShowtimesManager.createShowtimes("30/11/2022 17:30", "Home Alone 20", "2C2");
        ShowtimesManager.createShowtimes("10/11/2022 10:00", "Finding Nemo", "2C3");





        //populating holidays
        File holidays= new File("DATFiles/HolidayDates.dat");
        holidays.delete();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        HolidayManager.createHolidays(LocalDate.parse("01/01/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("01/02/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("15/04/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("02/05/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("04/05/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("16/05/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("11/07/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("09/08/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("24/10/2022", formatter));
        HolidayManager.createHolidays(LocalDate.parse("25/12/2022", formatter));

        //populate users
        File users= new File("DATFiles/AllUsers.dat");
        users.delete();
        UsersManager.createUser("shubu", "test", "Shubu", 87805205, "shubu@gmail.com");
        UsersManager.createUser("murong", "test", "Mu Rong", 83586561, "murong@gmail.com");

//
    //populating database for cinemas
        File cinema= new File("DATFiles/AllCinemas.dat");
        cinema.delete();
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
