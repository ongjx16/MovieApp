package Control;

import java.io.*;
import java.time.LocalDate;
import Entity.HolidayDates;
import java.util.ArrayList;

/**
 * HolidayManager has functions that allow creation, deletion, reading and getting of all cineplexes
 * HolidayManager reads from and writes to the HolidayDates.dat file
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class HolidayManager implements Serializable {
    /**
     * Creates HolidayDate
     * Adds new holiday to HolidayDates.dat
     * Admin privilege only
     * @param holidayDate
     */
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

    /**
     * Gets all holidays from HolidayDates.dat
     * @return Array list of all holiday dates
     */
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

    /**
     * Deletes holiday date
     * Removes specific holiday date from HolidayDates.dat
     * Admin privilege only
     * @param hol
     */
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

    /**
     * Edits existing holiday date
     * Updayes holiday date in HolidayDates.dat
     * @param hol1 Existing holiday date to replace
     * @param hol2 New holiday date to replace
     */
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

    /**
     * Checks if holiday date input is already a holiday date in HolidayDates.dat
     * @param date Date that needs to be checked
     */
    public static void holidayChecker(LocalDate date) {
        ArrayList<HolidayDates> allHols = readHolidays();
        for (int i = 0; i < allHols.size(); i++) {
            if (allHols.get(i).getDate().equals(date))
                System.out.println("True");
        }
        System.out.println("False");
    }

    /**
     * Prints out all holiday dates that are in HolidayDates.dat
     */
    public static void printHolidaydb() {
        ArrayList<HolidayDates> allHols = readHolidays();
        for (int i = 0; i < allHols.size(); i++) {
            System.out.println(allHols.get(i).getDate());
        }
    }
}

