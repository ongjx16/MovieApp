// import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pricing implements Serializable {
    private float blockbuster;
    private float premium;
    private float StudentStandard2D;
    private float StudentStandard3D;
    private float SeniorStandard2D;
    private float AdultMonWedStandard2D;
    private float AdultMonWedStandard3D;
    private float AdultThursStandard2D;
    private float AdultThursStandard3D;
    private float AdultFriStandard2D;
    private float AdultFriStandard3D;
    private float AdultWeekendStandard2D;
    private float AdultWeekendStandard3D;

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