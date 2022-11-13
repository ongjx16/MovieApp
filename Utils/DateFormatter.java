package Utils;

import Control.HolidayManager;
import Control.ShowtimesManager;
import Entity.Cinema;
import Entity.Movie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * Represents the date formatter of movie-goers and admin's inputs for dates
 * @author htut
 * @version 1.0
 * @since 2022-11-13
 */
public class DateFormatter {
    /**
     * Constructor
     */
    public DateFormatter() {
    }

    /**
     * Converts the string input of date into dd/MM/yyyy format
     * @param x date String
     * @return the day
     */
    public String DayConverter(String x){ //asking for string input pulled from showtimes containing date and time
        String inputDate = x.substring(0,10);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = null;
        try {
            dt1 = format1.parse(inputDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    /**
     * Converts the date into  format
     * @param x date
     * @return the hour
     */
    public String HourConverter(String x){
        String inputHr = x.substring(11,13);
        return inputHr;
    }

    /**
     * Checks if the cinema is Premium type
     * @param associatedCinema Cinema object
     * @return true is cinema type is premium
     */
    public boolean isPremium(Cinema associatedCinema){ // need to pull from enum movietype
        if (associatedCinema.getType() == CinemaType.PREMIUM){
            return true;
        }
        return false;
    }

    /**
     * Checks if movie is 3D
     * @param y Movie object
     * @return true if movie type is 3D
     */
    public boolean is3D(Movie y){
        if (y.getType().toString().toUpperCase().contains("3D")){
            return true;
        }
        return false;
    }

    /**
     * Checks if movie is a blockbuster
     * @param y Movie object
     * @return true if movie is blockbuster
     */
    public boolean isBlockbuster(Movie y){
        if (y.getType().toString().toUpperCase().contains("BLOCKBUSTER")){
            return true;
        }
        return false;
    }

    /**
     * Checks if day input is a weekend
     * @param x day
     * @return true if it is weekend
     */
    public boolean isWeekend(String x){
        if (Objects.equals(x, "Saturday") || Objects.equals(x, "Sunday")){
         return true;
        }
        return false;
    }

    /**
     * Checks is day input is Monday, Tuesday or Wednesday
     * @param x day
     * @return true if it is Monday, Tuesday or Wednesday
     */
    public boolean isMonWed(String x){
        if (Objects.equals(x, "Monday") ||Objects.equals(x, "Tuesday") ||Objects.equals(x, "Wednesday")){
            return true;
        }
        return false;
    }

    /**
     * Checks is day input is Thursday
     * @param x day
     * @return true if it is Thursday
     */
    public boolean isThur(String x){
        if (Objects.equals(x, "Thursday")){
            return true;
        }
        return false;
    }

    /**
     * Checks is day input is Friday
     * @param x day
     * @return true if it is Friday
     */
    public boolean isFri(String x, String y){
        if (Objects.equals(x, "Friday")){
            String hour = y.substring(0,2);
            int hours = Integer.parseInt(hour);
            if (hours < 18){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks is day input is Friday and if it is before 6pm Friday
     * @param x day
     * @return true if it is before Friday 6pm
     */
    public boolean isFri6pm(String x, String y){
        if (Objects.equals(x, "Friday")){
            String hour = y.substring(0,2);
            int hours = Integer.parseInt(hour);
            if (hours >= 18){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the day is a holiday
     * @param x day
     * @return returns true id it is a holiday
     */
    public boolean isHoliday(String x){
        for (int i = 0; i < HolidayManager.readHolidays().size(); i++){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String ds1 = HolidayManager.readHolidays().get(i).getDate().format(formatter);
            if (ds1.equals(x)){
                return true;
            }
        }
        return false;
    }
 }
