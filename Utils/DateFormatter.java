package Utils;

import Control.HolidayManager;
import Entity.Cinema;
import Entity.Movie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateFormatter {

    public DateFormatter() {
    }

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
    public String HourConverter(String x){
        String inputHr = x.substring(11,13);
        return inputHr;
    }
    public boolean isPremium(Cinema a){ // need to pull from enum movietype
        if (a.getType().toString().toUpperCase().contains("PREMIUM")){
            return true;
        }
        return false;
    }

    public boolean is3D(Movie y){
        if (y.getType().toString().toUpperCase().contains("3D")){
            return true;
        }
        return false;
    }

    public boolean isBlockbuster(Movie y){
        if (y.getType().toString().toUpperCase().contains("BLOCKBUSTER")){
            return true;
        }
        return false;
    }

    public boolean isWeekend(String x){
        if (Objects.equals(x, "Saturday") || Objects.equals(x, "Sunday")){
         return true;
        }
        return false;
    }
    public boolean isMonWed(String x){
        if (Objects.equals(x, "Monday") ||Objects.equals(x, "Tuesday") ||Objects.equals(x, "Wednesday")){
            return true;
        }
        return false;
    }
    public boolean isThur(String x){
        if (Objects.equals(x, "Thursday")){
            return true;
        }
        return false;
    }
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


    public boolean isHoliday(String x) throws ParseException {
        for (int i = 0; i < HolidayManager.readHolidays().size(); i++){
            String ds1 = HolidayManager.readHolidays().get(0).getDate().toString();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            String ds2 = sdf2.format(sdf1.parse(ds1));
            if (ds2.equals(x)){
                return true;
            }
        }
        return false;
    }
 }
