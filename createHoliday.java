import java.io.*;
import java.lang.String;

public class createHoliday{

    public static void main(String args[]) {
        try {
            //Creating the object
            HolidayDates hol1 = new HolidayDates("01/01");
            HolidayDates hol2 = new HolidayDates("01/02");
            HolidayDates hol3 = new HolidayDates("02/02");
            HolidayDates hol4 = new HolidayDates("15/04");
            HolidayDates hol5 = new HolidayDates("01/05");
            HolidayDates hol6 = new HolidayDates("03/05");
            HolidayDates hol7 = new HolidayDates("15/05");
            HolidayDates hol8 = new HolidayDates("10/07");
            HolidayDates hol9 = new HolidayDates("09/08");
            HolidayDates hol10 = new HolidayDates("24/10");
            HolidayDates hol11 = new HolidayDates("25/12");
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("HolidayDates.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(hol1); // DD/MM
            out.writeObject(hol2);
            out.writeObject(hol3);
            out.writeObject(hol4);
            out.writeObject(hol5);
            out.writeObject(hol6);
            out.writeObject(hol7);
            out.writeObject(hol8);
            out.writeObject(hol9);
            out.writeObject(hol10);
            out.writeObject(hol11);
            out.flush();
            //closing the stream
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        HolidayManager readHolidays = new HolidayManager();
        for(int i=0; i<readHolidays.getHoliday().length;i++){
            System.out.println(readHolidays.getHoliday()[i]);
        }
    }
}