import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pricing implements Serializable {
// yet to include holiday conditional statement
    private String movietype; //3d, not 3d, etc.
    private String movieClass; //platinum or not platinum
    private String age; // student, senior citizen, adult
    private boolean blockbuster;
    private String weekday; //weekday or weekend

    public Pricing() {

    }

    private boolean holiday; //non-public holiday or public holiday
    private boolean before6pm;
    private float finalprice = 0;
    public float obtainPricing(String movietype, String movieClass, String age, boolean blockbuster,
                               boolean holiday, String weekday, boolean before6pm) {
            if (Objects.equals(age, "elderly") && (weekday != "SAT" || weekday != "SUN") && Objects.equals(movietype, "normal") && !holiday
                    && before6pm) {
                finalprice = 4.00f;
            } else if (Objects.equals(age, "student") && (weekday != "SAT" || weekday != "SUN") && Objects.equals(movietype, "normal") && !holiday
                    && before6pm) {
                finalprice = 7.00f;
            } else if (Objects.equals(age, "student") && (weekday != "SAT" || weekday != "SUN") && movietype == "3D" && holiday == false
                    && before6pm) {
                finalprice = 9.00f;
            } else if ((Objects.equals(weekday, "MON") || Objects.equals(weekday, "TUE") || Objects.equals(weekday, "WED")) && Objects.equals(movietype, "normal")) {
                finalprice = 8.50f;
            } else if (Objects.equals(weekday, "THU") && Objects.equals(movietype, "digital")) {
                finalprice = 9.50f;
            } else if (Objects.equals(weekday, "THU") && Objects.equals(movietype, "3D")) {
                finalprice = 11.00f;
            } else if (Objects.equals(weekday, "FRI") && Objects.equals(movietype, "digital") && before6pm) {
                finalprice = 9.50f;
            } else if (Objects.equals(weekday, "FRI") && Objects.equals(movietype, "3D") && before6pm) {
                finalprice = 11.00f;
            } else if (Objects.equals(weekday, "FRI") && Objects.equals(movietype, "digital") && !before6pm) {
                finalprice = 11.00f;
            } else if (Objects.equals(weekday, "FRI") && Objects.equals(movietype, "3D") && !before6pm) {
                finalprice = 14.00f;
            } else if ((Objects.equals(weekday, "SAT") || Objects.equals(weekday, "SUN")) && Objects.equals(movietype, "digital")) {
                finalprice = 11.00f;
            } else if ((Objects.equals(weekday, "SAT") || Objects.equals(weekday, "SUN")) && Objects.equals(movietype, "3D")) {
                finalprice = 15.00f;
            }
        if (!blockbuster) {
            finalprice = finalprice + 1;
        }
        return finalprice;
    }

    public String getMovieType() {
        return movietype;
    }

    public void setMovieType(String type) {
        this.movietype = type;
    }

    public String getMovieClass() {
        return movieClass;
    }

    public void setMovieClass(String movieClass) {
        this.movieClass = movieClass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isBlockbuster() {
        return blockbuster;
    }

    public void setBlockbuster(boolean blockbuster) {
        this.blockbuster = blockbuster;
    }

    public String isWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public float getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(float finalprice) {
        this.finalprice = finalprice;
    }

    public boolean isBefore6pm() {
        return before6pm;
    }

    public void setBefore6pm(boolean before6pm) {
        this.before6pm = before6pm;
    }
}
