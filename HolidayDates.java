import java.io.Serializable;

public class HolidayDates implements Serializable {

    private String holidayDate;

    HolidayDates(String date) {
        holidayDate = date;
    }
    public void setDate(String holidayDate){
        this.holidayDate = holidayDate;
    }

    public String getDate(){
        return holidayDate;
    }
}
