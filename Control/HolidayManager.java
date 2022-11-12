package Control;

import java.io.*;
import java.time.LocalDate;
import Entity.HolidayDates;
import java.util.ArrayList;

public class HolidayManager implements Serializable {

    public static void createHolidays(LocalDate holidayDate) {
        try {

            //Creating the object
            ArrayList<HolidayDates> holList = new ArrayList<HolidayDates>(readHolidays());

            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("DATFiles/HolidayDates.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int id;

            HolidayDates hol1 = new HolidayDates(holidayDate);

            holList.add(hol1);

            out.writeObject(holList);
            out.flush();
            //closing the stream

            out.close();
            System.out.println("Created Holiday Successfully.");
        } catch (Exception e) {
            // e.printStackTrace(
            // );
        }
    }

    public static ArrayList<HolidayDates> readHolidays() {
        ArrayList<HolidayDates> holDates = new ArrayList<HolidayDates>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/HolidayDates.dat"));
            holDates = (ArrayList<HolidayDates>) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace(
            );
        }
        return (holDates);
    }

    // enter date of holiday to be deleted
    public static void deleteHoliday(LocalDate hol) {
        ArrayList<HolidayDates> allHols = new ArrayList<HolidayDates>(readHolidays());
        ArrayList<HolidayDates> returnHols = new ArrayList<HolidayDates>();
        for (int n = 0; n < allHols.size(); n++) {
            HolidayDates holNo = allHols.get(n);
            if (!(holNo.getDate().equals(hol))) {
                returnHols.add(holNo);
            }
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DATFiles/HolidayDates.dat"));
            out.writeObject(returnHols);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted holiday successfully");
    }

    // enter date to replace the specific date with another
    public static void replaceHoliday(LocalDate hol1, LocalDate hol2) {
        ArrayList<HolidayDates> allHols = new ArrayList<HolidayDates>(readHolidays());
        ArrayList<HolidayDates> returnHols = new ArrayList<HolidayDates>();
        HolidayDates replacement = new HolidayDates(hol2);
        for (int n = 0; n < allHols.size(); n++) {
            if (!(allHols.get(n).getDate().equals(hol1))) {
                returnHols.add(allHols.get(n));
            }
            else{
                returnHols.add(replacement);
            }
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DATFiles/HolidayDates.dat"));
            out.writeObject(returnHols);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Replaced holiday successfully");
    }

    // checks if date entered is a holiday
    public static void holidayChecker(LocalDate date) {
        ArrayList<HolidayDates> allHols = readHolidays();
        for (int i = 0; i < allHols.size(); i++) {
            if (allHols.get(i).getDate().equals(date))
                System.out.println("True");
//                return true;
        }
//        return false;
        System.out.println("False");
    }

    public static void printHolidaydb() {
        ArrayList<HolidayDates> allHols = readHolidays();
        for (int i = 0; i < allHols.size(); i++) {
            System.out.println(allHols.get(i).getDate());
        }
    }
}

// TESTING SCRIPT
//        src.Control.HolidayManager.deleteHoliday(LocalDate.of(2022, 2, 1));
//        src.Control.HolidayManager.deleteHoliday(LocalDate.of(2022, 2, 2));
//        src.Control.HolidayManager.deleteHoliday(LocalDate.of(2022, 1, 1));
//        System.out.println("Create Holiday");
//        src.Control.HolidayManager.createHolidays(LocalDate.of(2022, 1, 1));
//        src.Control.HolidayManager.createHolidays(LocalDate.of(2022, 2, 1));
//        src.Control.HolidayManager.createHolidays(LocalDate.of(2022, 2, 2));
//        src.Control.HolidayManager.printHolidaydb();
//        System.out.println("Delete Holiday");
//        src.Control.HolidayManager.deleteHoliday(LocalDate.of(2022, 2, 1));
//        src.Control.HolidayManager.printHolidaydb();
//        System.out.println("Replace Holiday");
//        src.Control.HolidayManager.replaceHoliday(LocalDate.of(2022, 2, 2));
//        src.Control.HolidayManager.printHolidaydb();
//        System.out.println("Check if isHoliday");
//        src.Control.HolidayManager.holidayChecker(LocalDate.of(2022, 1, 1));
//        src.Control.HolidayManager.holidayChecker(LocalDate.of(2022, 12, 12));
//        src.Control.HolidayManager.printHolidaydb();


//    public String[] getHoliday() {
//        String[] holiday = new String[11];
//        int i = 0;
//        boolean cont = true;
//        try {
//            //Creating stream to read the object
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src.Entity.HolidayDates.dat"));
//
//            while (cont) {
//                src.Entity.HolidayDates hol= null;
//                try {
//                    hol = (src.Entity.HolidayDates) in.readObject();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace(
//                    );
//                }
//                catch (EOFException efe){
//                    System.out.print("");
//                }
//                if (hol != null) {
//                    holiday[i] = hol.getDate();
//                    i++;
//
//                } else {
//                    cont = false;
//                }
//            }
//            in.close();
//        }catch(Exception e){System.out.println(e);}
//
//        return(holiday);
//
//    }
//}