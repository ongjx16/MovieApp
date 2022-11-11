import java.util.Scanner;

public class SystemSettings {

    public static void editPricing(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose which price category you'd like to edit: ");
        System.out.println("1. Blockbuster movies");
        System.out.println("2. Premium cinemas");
        System.out.println("3. Adult prices");
        System.out.println("4. Student prices");
        System.out.println("5. Senior citizen prices");
        int mainPriceOption = scan.nextInt();
        if (mainPriceOption == 1) {
            PricingManager.editPricing(0, "blockbuster");
            System.out.println("Blockbuster price has been set to: " + PricingManager.readAllPricing().get(0).getBlockbuster());
        }
        if (mainPriceOption == 2) {
            PricingManager.editPricing(0, "premium");
            System.out.println("Premium price has been set to: " + PricingManager.readAllPricing().get(0).getPremium());
        }
        if (mainPriceOption == 3) {
            System.out.println("Which day would you like to change prices for");
            System.out.println("1. Adult Mon-Wed 2D");
            System.out.println("2. Adult Mon-Wed 3D");
            System.out.println("3. Adult Thurs 2D");
            System.out.println("4. Adult Thurs 3D");
            System.out.println("5. Adult Fri (Before 6pm) 2D");
            System.out.println("6. Adult Fri (Before 6pm) 3D");
            System.out.println("7. Adult Fri(6pm onwards) - Weekend 2D");
            System.out.println("8. Adult Fri(6pm onwards) - Weekend 2D");
            System.out.println("What is your choice: ");
            int adultpriceoption = scan.nextInt();
            if (adultpriceoption == 1) {
                PricingManager.editPricing(0, "AdultMonWedStandard2D");
                System.out.println("Adult mon-wed 2D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D());
            }
            if (adultpriceoption == 2) {
                PricingManager.editPricing(0, "AdultMonWedStandard3D");
                System.out.println("Adult mon-wed 3D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D());
            }
            if (adultpriceoption == 3) {
                PricingManager.editPricing(0, "AdultThuStandard2D");
                System.out.println("Adult Thur 2D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultThursStandard2D());
            }
            if (adultpriceoption == 4) {
                PricingManager.editPricing(0, "AdultThuStandard3D");
                System.out.println("Adult Thur 3D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultThursStandard3D());
            }
            if (adultpriceoption == 5) {
                PricingManager.editPricing(0, "AdultFriStandard2D");
                System.out.println("Adult Fri (Before 6pm) 2D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultFriStandard2D());
            }
            if (adultpriceoption == 6) {
                PricingManager.editPricing(0, "AdultFriStandard3D");
                System.out.println("Adult Fri (Before 6pm) 3D price has been set to: " + PricingManager.readAllPricing().get(0).getAdultFriStandard3D());
            }
            if (adultpriceoption == 7) {
                PricingManager.editPricing(0, "AdultWeekendStandard2D");
                System.out.println("Adult Fri (Aft 6pm) - Weekend 2D has been set to: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
            }
            if (adultpriceoption == 8) {
                PricingManager.editPricing(0, "AdultWeekendStandard3D");
                System.out.println("Adult Fri (Aft 6pm) - Weekend 3D has been set to: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
            }
        } else if (mainPriceOption == 4) {
            System.out.println("Which student price would you like to adjust");
            System.out.println("1. Student 2D");
            System.out.println("2. Student 3D");
            int studentoption = scan.nextInt();
            if (studentoption == 1) {
                PricingManager.editPricing(0, "StudentStandard2D");
                System.out.println("Student 2D price has been set to: " + PricingManager.readAllPricing().get(0).getStudentStandard2D());
            }
            if (studentoption == 2) {
                PricingManager.editPricing(0, "StudentStandard3D");
                System.out.println("Student 3D price has been set to: " + PricingManager.readAllPricing().get(0).getStudentStandard3D());
            }
        } else if (mainPriceOption == 5) {
            PricingManager.editPricing(0, "SeniorStandard2D");
            System.out.println("Senior 2D price has been set to: " + PricingManager.readAllPricing().get(0).getSeniorStandard2D());
        }
    }


    public static void editHolidayDates(){

    }

    public static void editTop5Filtering(){

    }
}
