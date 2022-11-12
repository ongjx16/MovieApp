import Control.CinemaManager;
import Control.CineplexManager;
import Control.PricingManager;
import Entity.AdminAccount;
import Entity.Cinema;
import Entity.Cineplex;
import Utils.CinemaType;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Initialiser {
    public static void main (String[] args) {
        //populate database for pricing
        PricingManager.createPricing(1f, 25f, 7f, 9f, 4f, 8.5f, 11f, 9.5f, 11f, 9.5f, 15f, 11f, 15f);


//        //populate database for admin accounts
//        createAdminAccounts();
//
//        //populating database for cineplexes
//        CineplexManager.createCineplex("Jem");
//        CineplexManager.createCineplex("Parkway Parade");
//        CineplexManager.createCineplex("Tampines");
//
//        System.out.println("Cineplexes Created:");
//
//        ArrayList<Cineplex> CineplexOutput = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
//        for (int y = 0; y < CineplexOutput.size(); y++) {
//            System.out.println(CineplexOutput.get(y).getCineplexID());
//            System.out.println(CineplexOutput.get(y).getCineplexName());
//            System.out.println("\n");
//        }
////
//    //populating database for cinemas
//        CinemaManager.createCinema("Jem", "1", CinemaType.PREMIUM);
//        CinemaManager.createCinema("Jem", "2", CinemaType.STANDARD);
//        CinemaManager.createCinema("Jem", "3", CinemaType.STANDARD);
//        CinemaManager.createCinema("Parkway Parade", "1", CinemaType.STANDARD);
//        CinemaManager.createCinema("Parkway Parade", "2", CinemaType.STANDARD);
//        CinemaManager.createCinema("Parkway Parade", "3", CinemaType.PREMIUM);
//        CinemaManager.createCinema("Tampines", "1", CinemaType.PREMIUM);
//        CinemaManager.createCinema("Tampines", "2", CinemaType.STANDARD);
//        CinemaManager.createCinema("Tampines", "3", CinemaType.STANDARD);
//
//        System.out.println("Cinemas Created:");
//    ArrayList<Cinema> CinemaOutput = new ArrayList<Cinema>(CinemaManager.readAllCinemas());
//        for(int y=0; y<CinemaOutput.size(); y++){
//        System.out.println(CinemaOutput.get(y).getCinemaId());
//        System.out.println(CinemaOutput.get(y).getType());
//        System.out.println("\n");
//    }


//}
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
