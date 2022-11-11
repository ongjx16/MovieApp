import java.util.ArrayList;

public class Initialiser {
    public static void main (String[] args){
        //populating database for cineplexes
        CineplexManager.createCineplex("Jem");
        CineplexManager.createCineplex("Parkway Parade");
        CineplexManager.createCineplex("Tampines");

        System.out.println("Cineplexes Created:");
        ArrayList<Cineplex> CineplexOutput = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
        for (int y=0; y<CineplexOutput.size(); y++){
            System.out.println(CineplexOutput.get(y).getCineplexID());
            System.out.println(CineplexOutput.get(y).getCineplexName());
            System.out.println("\n");
        }

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
        for (int y=0; y<CinemaOutput.size(); y++){
            System.out.println(CinemaOutput.get(y).getCinemaId());
            System.out.println(CinemaOutput.get(y).getType());
            System.out.println("\n");
        }


    }
}
