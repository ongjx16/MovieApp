import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
//        PricingManager.createPricing(1f, 25f, 7f, 9f,
//                4f, 8.5f, 11f, 9.5f, 11f,
//                9.5f, 15f, 11f, 25f);
        System.out.println("Premium: " + PricingManager.readAllPricing().get(0).getPremium());
        System.out.println("Blockbuster: " + PricingManager.readAllPricing().get(0).getBlockbuster());
        System.out.println("getSeniorStandard2D: " + PricingManager.readAllPricing().get(0).getSeniorStandard2D());
        System.out.println("getStudentStandard2D: " +  PricingManager.readAllPricing().get(0).getStudentStandard2D());
        System.out.println("getStudentStandard3D: " + PricingManager.readAllPricing().get(0).getStudentStandard3D());
        System.out.println("getAdultMonWedStandard2D: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D());
        System.out.println("getAdultMonWedStandard3D: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D());
        System.out.println("getAdultThursStandard2D: " + PricingManager.readAllPricing().get(0).getAdultThursStandard2D());
        System.out.println("getAdultThursStandard3D: " + PricingManager.readAllPricing().get(0).getAdultThursStandard3D());
        System.out.println("getAdultFriStandard2D: " + PricingManager.readAllPricing().get(0).getAdultFriStandard2D());
        System.out.println("getAdultFriStandard3D: " + PricingManager.readAllPricing().get(0).getAdultFriStandard3D());
        System.out.println("getAdultWeekendStandard2D: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
        System.out.println("getAdultWeekendStandard3D: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D());
    }
}
