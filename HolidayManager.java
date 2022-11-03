import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class HolidayManager {

    public String[] getHoliday() {
        String[] holiday = new String[11];
        int i = 0;
        boolean cont = true;
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("HolidayDates.dat"));

            while (cont) {
                HolidayDates hol= null;
                try {
                    hol = (HolidayDates) in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace(
                    );
                }
                catch (EOFException efe){
                    System.out.print("");
                }
                if (hol != null) {
                    holiday[i] = hol.getDate();
                    i++;

                } else {
                    cont = false;
                }
            }
            in.close();
            }catch(Exception e){System.out.println(e);}

            return(holiday);

        }
    }
