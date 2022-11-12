package Entity;// import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a prices of the movies in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class Pricing implements Serializable {
    /**
     * The price of movie type is blockbuster
     */
    private float blockbuster;
    /**
     * The price for movie type is premium
     */
    private float premium;
    /**
     * The price for student movie-goer buying a ticket for Standard 2d movie
     */
    private float StudentStandard2D;
    /**
     * The price for student movie-goer buying a ticket for Standard 3d movie
     */
    private float StudentStandard3D;
    /**
     * The price of senior movie-goer buying a ticket for Standard 2d movie
     */
    private float SeniorStandard2D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 2d movie on Mon to Wed
     */
    private float AdultMonWedStandard2D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 3d movie on Mon to Wed
     */
    private float AdultMonWedStandard3D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 2d movie on Thurs
     */
    private float AdultThursStandard2D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 3d movie on Thurs
     */
    private float AdultThursStandard3D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 2d movie on Fri
     */
    private float AdultFriStandard2D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 3d movie on Fri
     */
    private float AdultFriStandard3D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 2d movie on Weekend
     */
    private float AdultWeekendStandard2D;
    /**
     * The price of adult movie-goer buying a ticket for Standard 3d movie on weekend
     */
    private float AdultWeekendStandard3D;

    /**
     * Creates a price for a booking
     * @param blockbuster the price for blockbuster
     * @param premium the price for premium
     * @param studentStandard2D The price for student movie-goer buying a ticket for Standard 3d movie
     * @param studentStandard3D the price for student movie-goer buying a ticket for Standard 2d movie
     * @param seniorStandard2D The price of senior movie-goer buying a ticket for Standard 2d movie
     * @param adultMonWedStandard2D The price of adult movie-goer buying a ticket for Standard 2d movie on Mon to Wed
     * @param adultMonWedStandard3D The price of adult movie-goer buying a ticket for Standard 3d movie on Mon to Wed
     * @param adultThursStandard2D The price of adult movie-goer buying a ticket for Standard 2d movie on Thurs
     * @param adultThursStandard3D The price of adult movie-goer buying a ticket for Standard 3d movie on Thurs
     * @param adultFriStandard2D The price of adult movie-goer buying a ticket for Standard 2d movie on Fri
     * @param adultFriStandard3D The price of adult movie-goer buying a ticket for Standard 3d movie on Fri
     * @param adultWeekendStandard2D The price of adult movie-goer buying a ticket for Standard 2d movie on Weekend
     * @param adultWeekendStandard3D The price of adult movie-goer buying a ticket for Standard 3d movie on weekend
     */
    public Pricing(float blockbuster, float premium, float studentStandard2D, float studentStandard3D, float seniorStandard2D, float adultMonWedStandard2D, float adultMonWedStandard3D, float adultThursStandard2D, float adultThursStandard3D, float adultFriStandard2D, float adultFriStandard3D, float adultWeekendStandard2D, float adultWeekendStandard3D) {
        this.blockbuster = blockbuster;
        this.premium = premium;
        StudentStandard2D = studentStandard2D;
        StudentStandard3D = studentStandard3D;
        SeniorStandard2D = seniorStandard2D;
        AdultMonWedStandard2D = adultMonWedStandard2D;
        AdultMonWedStandard3D = adultMonWedStandard3D;
        AdultThursStandard2D = adultThursStandard2D;
        AdultThursStandard3D = adultThursStandard3D;
        AdultFriStandard2D = adultFriStandard2D;
        AdultFriStandard3D = adultFriStandard3D;
        AdultWeekendStandard2D = adultWeekendStandard2D;
        AdultWeekendStandard3D = adultWeekendStandard3D;
    }

    /**
     *
     * @return
     */
    public float getBlockbuster() {
        return blockbuster;
    }

    public void setBlockbuster(float blockbuster) {
        this.blockbuster = blockbuster;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }

    public float getStudentStandard2D() {
        return StudentStandard2D;
    }

    public void setStudentStandard2D(float studentStandard2D) {
        StudentStandard2D = studentStandard2D;
    }

    public float getStudentStandard3D() {
        return StudentStandard3D;
    }

    public void setStudentStandard3D(float studentStandard3D) {
        StudentStandard3D = studentStandard3D;
    }

    public float getSeniorStandard2D() {
        return SeniorStandard2D;
    }

    public void setSeniorStandard2D(float seniorStandard2D) {
        SeniorStandard2D = seniorStandard2D;
    }

    public float getAdultMonWedStandard2D() {
        return AdultMonWedStandard2D;
    }

    public void setAdultMonWedStandard2D(float adultMonWedStandard2D) {
        AdultMonWedStandard2D = adultMonWedStandard2D;
    }

    public float getAdultMonWedStandard3D() {
        return AdultMonWedStandard3D;
    }

    public void setAdultMonWedStandard3D(float adultMonWedStandard3D) {
        AdultMonWedStandard3D = adultMonWedStandard3D;
    }

    public float getAdultThursStandard2D() {
        return AdultThursStandard2D;
    }

    public void setAdultThursStandard2D(float adultThursStandard2D) {
        AdultThursStandard2D = adultThursStandard2D;
    }

    public float getAdultThursStandard3D() {
        return AdultThursStandard3D;
    }

    public void setAdultThursStandard3D(float adultThursStandard3D) {
        AdultThursStandard3D = adultThursStandard3D;
    }

    public float getAdultFriStandard2D() {
        return AdultFriStandard2D;
    }

    public void setAdultFriStandard2D(float adultFriStandard2D) {
        AdultFriStandard2D = adultFriStandard2D;
    }

    public float getAdultFriStandard3D() {
        return AdultFriStandard3D;
    }

    public void setAdultFriStandard3D(float adultFriStandard3D) {
        AdultFriStandard3D = adultFriStandard3D;
    }

    public float getAdultWeekendStandard2D() {
        return AdultWeekendStandard2D;
    }

    public void setAdultWeekendStandard2D(float adultWeekendStandard2D) {
        AdultWeekendStandard2D = adultWeekendStandard2D;
    }

    public float getAdultWeekendStandard3D() {
        return AdultWeekendStandard3D;
    }

    public void setAdultWeekendStandard3D(float adultWeekendStandard3D) {
        AdultWeekendStandard3D = adultWeekendStandard3D;
    }
}