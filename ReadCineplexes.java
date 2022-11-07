import java.io.*;
public class ReadCineplexes {

    public Cineplex[] getCineplexes() {
        Cineplex[] allCineplexes = new Cineplex[2];
        int i = 0;
        boolean cont = true;
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cineplexes.dat"));

            while (cont) {
                Cineplex c = null;
                try {
                    c = (Cineplex) in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace(
                    );
                }
                catch (EOFException efe){
                    System.out.print("");;
                }
                if (c != null) {
                    allCineplexes[i] = c;
                    i++;

                } else {
                    cont = false;
                }
            }


            //closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return (allCineplexes);
    }
}