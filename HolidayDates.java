import java.io.Serializable;
import java.time.LocalDate;

public class HolidayDates implements Serializable {

    private LocalDate holidayDate;

    HolidayDates(LocalDate date) {
        holidayDate = date;
    }
    public void setDate(LocalDate holidayDate){
        this.holidayDate = holidayDate;
    }

    public LocalDate getDate(){
        return holidayDate;
    }
}