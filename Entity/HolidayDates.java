package Entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents the holiday dates in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class HolidayDates implements Serializable {

    /**
     * The holiday date
     */
    private LocalDate holidayDate;

    /**
     * Creates a holiday date
     * @param date the date to make into holiday
     */
    public HolidayDates(LocalDate date) {
        holidayDate = date;
    }

    /**
     * Change the holiday date
     * @param holidayDate the date to make into holiday
     */
    public void setDate(LocalDate holidayDate){
        this.holidayDate = holidayDate;
    }

    /**
     * Gets the holiday date
     * @return the holiday date
     */
    public LocalDate getDate(){
        return holidayDate;
    }
}