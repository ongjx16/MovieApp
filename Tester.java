//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Scanner;
//
//public class src.Tester {
//    public static void main(String[] args) throws ParseException {
//        DateFormatter d1 = new DateFormatter();
//        System.out.println(d1.DayConverter("11/11/2022 10:12"));
//
//        String x = "Jewel Changi premiu Movies";
//        System.out.println(d1.isPremium(x));
//
//        String ds1 = src.Control.HolidayManager.readHolidays().get(0).getDate().toString();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
//        String ds2 = sdf2.format(sdf1.parse(ds1));
//        System.out.println(ds2);
//    }
//}

import Control.PricingManager;

public class Tester {
    public static void main (String[] args){
        PricingManager.createPricing(1f, 25f, 7f, 9f,
                4f, 8.5f, 11f, 9.5f, 11f,
                9.5f, 15f, 11f, 15f);
    }
}