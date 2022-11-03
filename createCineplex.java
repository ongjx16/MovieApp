import java.io.*;

public class createCineplex{
    public static void main(String args[]) {
        try {
            //Creating the object
            Cineplex cineplex1 = new Cineplex("Jem");
            Cineplex cineplex2 = new Cineplex("Parkway Parade");
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("Cineplexes.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(cineplex1);
            out.writeObject(cineplex2);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }

        {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cineplexes.dat"));
                try {
                    Cineplex c = (Cineplex)in.readObject();
                    Cineplex c1 = (Cineplex)in.readObject();
                    System.out.println(c.getMovies());
                    System.out.println(c.getCineplexName());
                    System.out.println(c1.getMovies());
                    System.out.println(c1.getCineplexName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
