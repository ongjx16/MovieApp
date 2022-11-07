public class Pricing {
// yet to include holiday conditional statement
    private String movietype; //3d, not 3d, etc.
    private String movieClass; //platinum or not platinum
    private String age; // student, senior citizen, adult
    private boolean blockbuster;
    private String weekday; //weekday or weekend
    private boolean holiday; //non-public holiday or public holiday
    private boolean before6pm;
    private float finalprice = 0;
    public float obtainPricing(String movietype, String movieClass, String age, boolean blockbuster,
                               boolean holiday, String weekday, boolean before6pm) {
            if (age == "elderly" && (weekday != "SAT" || weekday != "SUN") && movietype == "normal" && holiday == false
                    && before6pm == true) {
                finalprice = 4.00f;
            } else if (age == "student" && (weekday != "SAT" || weekday != "SUN") && movietype == "normal" && holiday == false
                    && before6pm == true) {
                finalprice = 7.00f;
            } else if (age == "student" && (weekday != "SAT" || weekday != "SUN") && movietype == "3D" && holiday == false
                    && before6pm == true) {
                finalprice = 9.00f;
            } else if ((weekday == "MON" || weekday == "TUE" || weekday == "WED") && movietype == "normal") {
                finalprice = 8.50f;
            } else if (weekday == "THU" && movietype == "digital") {
                finalprice = 9.50f;
            } else if (weekday == "THU" && movietype == "3D") {
                finalprice = 11.00f;
            } else if (weekday == "FRI" && movietype == "digital" && before6pm == true) {
                finalprice = 9.50f;
            } else if (weekday == "FRI" && movietype == "3D" && before6pm == true) {
                finalprice = 11.00f;
            } else if (weekday == "FRI" && movietype == "digital" && before6pm == false) {
                finalprice = 11.00f;
            } else if (weekday == "FRI" && movietype == "3D" && before6pm == false) {
                finalprice = 14.00f;
            } else if ((weekday == "SAT" || weekday == "SUN") && movietype == "digital") {
                finalprice = 11.00f;
            } else if ((weekday == "SAT" || weekday == "SUN") && movietype == "3D") {
                finalprice = 15.00f;
            }
            if (blockbuster){
                return finalprice;
            }
            else if (!blockbuster){
                finalprice = finalprice + 1;
                return finalprice;
            }
        return 0;
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

    public boolean isWeekday() {
        return weekday;
    }

    public void setWeekday(boolean weekday) {
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
}
