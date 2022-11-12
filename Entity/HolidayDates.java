package Entity;

import java.io.Serializable;
import java.time.LocalDate;

public class HolidayDates implements Serializable {

    private LocalDate holidayDate;

    public HolidayDates(LocalDate date) {
        holidayDate = date;
    }
    public void setDate(LocalDate holidayDate){
        this.holidayDate = holidayDate;
    }

    public LocalDate getDate(){
        return holidayDate;
    }
}