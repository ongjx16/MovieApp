package Boundary;

import Control.HolidayManager;
import Control.PricingManager;
import Entity.HolidayDates;
import Utils.RatingFilterType;
import Entity.FilterPermissions;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminSystemSettingsUI {

    public static void editPricing() {
        Scanner scan = new Scanner(System.in);
        int mainPriceOption = 0;
        while (mainPriceOption != 7) {
            System.out.println("Choose which price category you'd like to edit: ");
            System.out.println("1. Blockbuster movies");
            System.out.println("2. Premium cinemas");
            System.out.println("3. Adult prices");
            System.out.println("4. Student prices");
            System.out.println("5. Senior citizen prices");
            System.out.println("6. Show all current prices");
            System.out.println("7. Back");
            mainPriceOption = scan.nextInt();
            if (mainPriceOption == 1) {
                PricingManager.editPricing(0, "blockbuster");
                System.out.println(
                        "Blockbuster price has been set to: " + PricingManager.readAllPricing().get(0).getBlockbuster());
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
                    System.out.println("Adult mon-wed 2D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D());
                }
                if (adultpriceoption == 2) {
                    PricingManager.editPricing(0, "AdultMonWedStandard3D");
                    System.out.println("Adult mon-wed 3D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D());
                }
                if (adultpriceoption == 3) {
                    PricingManager.editPricing(0, "AdultThuStandard2D");
                    System.out.println("Adult Thur 2D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultThursStandard2D());
                }
                if (adultpriceoption == 4) {
                    PricingManager.editPricing(0, "AdultThuStandard3D");
                    System.out.println("Adult Thur 3D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultThursStandard3D());
                }
                if (adultpriceoption == 5) {
                    PricingManager.editPricing(0, "AdultFriStandard2D");
                    System.out.println("Adult Fri (Before 6pm) 2D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultFriStandard2D());
                }
                if (adultpriceoption == 6) {
                    PricingManager.editPricing(0, "AdultFriStandard3D");
                    System.out.println("Adult Fri (Before 6pm) 3D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultFriStandard3D());
                }
                if (adultpriceoption == 7) {
                    PricingManager.editPricing(0, "AdultWeekendStandard2D");
                    System.out.println("Adult Fri (Aft 6pm) - Weekend 2D has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
                }
                if (adultpriceoption == 8) {
                    PricingManager.editPricing(0, "AdultWeekendStandard3D");
                    System.out.println("Adult Fri (Aft 6pm) - Weekend 3D has been set to: "
                            + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
                }
            } else if (mainPriceOption == 4) {
                System.out.println("Which student price would you like to adjust");
                System.out.println("1. Student 2D");
                System.out.println("2. Student 3D");
                int studentoption = scan.nextInt();
                if (studentoption == 1) {
                    PricingManager.editPricing(0, "StudentStandard2D");
                    System.out.println("Student 2D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getStudentStandard2D());
                }
                if (studentoption == 2) {
                    PricingManager.editPricing(0, "StudentStandard3D");
                    System.out.println("Student 3D price has been set to: "
                            + PricingManager.readAllPricing().get(0).getStudentStandard3D());
                }
            } else if (mainPriceOption == 5) {
                PricingManager.editPricing(0, "SeniorStandard2D");
                System.out.println(
                        "Senior 2D price has been set to: " + PricingManager.readAllPricing().get(0).getSeniorStandard2D());
            } else if (mainPriceOption == 6) {
                System.out.println("Premium Cinemas: " + PricingManager.readAllPricing().get(0).getPremium());
                System.out.println("Blockbuster Price addition: " + PricingManager.readAllPricing().get(0).getBlockbuster());
                System.out.println("Student 2D: " + PricingManager.readAllPricing().get(0).getStudentStandard2D());
                System.out.println("Student 3D: " + PricingManager.readAllPricing().get(0).getStudentStandard3D());
                System.out.println("Senior 2D: " + PricingManager.readAllPricing().get(0).getSeniorStandard2D());
                System.out.println("Fri(6pm onwards)/Weekend/Holiday 2D: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D());
                System.out.println("Fri(6pm onwards)/Weekend/Holiday 3D: " + PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D());
                System.out.println("Adult Fri(Before 6pm) 2D: " + PricingManager.readAllPricing().get(0).getAdultFriStandard2D());
                System.out.println("Adult Fri(Before 6pm) 3D: " + PricingManager.readAllPricing().get(0).getAdultFriStandard3D());
                System.out.println("Thursday 2D " + PricingManager.readAllPricing().get(0).getAdultThursStandard2D());
                System.out.println("Thursday 3D: " + PricingManager.readAllPricing().get(0).getAdultThursStandard3D());
                System.out.println("Adult Mon-Wed 2D: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D());
                System.out.println("Adult Mon-Wed 3D: " + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D());

            }
        }
    }

    public static void editHolidayDates() {
        Scanner scan1 = new Scanner(System.in);
        int editChoice = 0;

        System.out.println("Choose what to do with holidays: ");
        System.out.println("1. Create New Holiday");
        System.out.println("2. Edit Existing Holiday");
        System.out.println("3. Delete A Holiday");
        System.out.println("4. View All Holiday Dates");
        System.out.println("5. Back");
        editChoice = scan1.nextInt();

        while (editChoice != 5) {
            if (editChoice == 1) {
                // create new holiday
                String holiday;
                System.out.println("Enter new holiday date in DD/MM/YYYY: ");
                scan1.nextLine();
                holiday = scan1.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate holidayDate = LocalDate.parse(holiday, formatter);
                HolidayManager.createHolidays(holidayDate);
            }
            else if(editChoice ==2){
                //edit existing holiday
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Choose a holiday to delete:");
                ArrayList<HolidayDates> allHols = new ArrayList<HolidayDates>(HolidayManager.readHolidays());
                for (int i = 0; i<allHols.size(); i++){
                    System.out.println((i+1) + ". " + allHols.get(i).getDate().format(formatter));
                }

                int holChoice = scan1.nextInt();
                LocalDate targetDate = allHols.get(holChoice-1).getDate();

                System.out.println("\nEditing: " + targetDate.format(formatter));
                
                System.out.println("\nEnter New Date in DD/MM/YYYY: ");
                scan1.nextLine();
                String newChoice = scan1.nextLine();
                LocalDate replacementDate = LocalDate.parse(newChoice, formatter);

                HolidayManager.replaceHoliday(targetDate, replacementDate);

            }
            else if(editChoice ==3){
                //delete holiday
                System.out.println("Choose a holiday to delete:");
                ArrayList<HolidayDates> allHols = new ArrayList<HolidayDates>(HolidayManager.readHolidays());
                for (int i = 0; i<allHols.size(); i++){
                    System.out.println((i+1) + ". " + allHols.get(i).getDate());
                }

                int holChoice = scan1.nextInt();

                HolidayManager.deleteHoliday(allHols.get(holChoice-1).getDate());
                
            }
            else if(editChoice ==4){
                //view all holidays
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("\nAll Holidays:");
                ArrayList<HolidayDates> allHols = new ArrayList<HolidayDates>(HolidayManager.readHolidays());
                for (int i = 0; i<allHols.size(); i++){
                    System.out.println((i+1) + ": " + allHols.get(i).getDate().format(formatter));
                }
                
            }
            System.out.println("\nChoose what to do with holidays: \n");
        System.out.println("1. Create New Holiday");
        System.out.println("2. Edit Existing Holiday");
        System.out.println("3. Delete A Holiday");
        System.out.println("4. View All Holiday Dates");
        System.out.println("5. Back\n");
        editChoice = scan1.nextInt();
            

        }

    }

    public static void editTop5Filtering() {
        ListTop5MoviesUI listTop5 = new ListTop5MoviesUI();

        Scanner scan1 = new Scanner(System.in);
        int filterChoice = 0;

        while (filterChoice != 3) {
            System.out.println("\nChoose your function: \n");
            System.out.println("1. View Top 5 Movies");
            System.out.println("2. Edit User Access to Filters");
            System.out.println("3. Back\n");
            filterChoice = scan1.nextInt();

            if (filterChoice == 1) {
                // view top 5 by filter
                int secondFilterChoice = 0;


                while (secondFilterChoice != 3) {
                    System.out.println("\nChoose filter: \n");
                    System.out.println("1. See Top 5 Movies by Sales");
                    System.out.println("2. See Top 5 Movies by Ratings");
                    System.out.println("3. Back\n");
                    secondFilterChoice = scan1.nextInt();
                    // if (secondFilterChoice < 1 && secondFilterChoice > 3) {
                    //     System.out.println("Invalid Input. Choose Again");
                    //     filterChoice = scan.nextInt();
                    // } 
                   if (secondFilterChoice == 1) {
                       listTop5.sortBySales();
                    }
                   else if (secondFilterChoice == 2) {
                       listTop5.sortByRatings();
                   }
                }

            }
            else if (filterChoice == 2) {
                int editChoice = 0;

                while (editChoice!=3) {
                    System.out.println("\nChoose option: ");
                    System.out.println("\n1. Edit User Access to Ratings Filter");
                    System.out.println("2. Edit User Access to Sales Filter");
                    System.out.println("3. Back\n");
                    editChoice = scan1.nextInt();

                    if (editChoice == 1) {
                        // edit ratings Filter
                        if (FilterPermissions.isAccessRatingsFilter()) {
                            System.out.println("Current Filter by Ratings: Allowed");
                        } else {
                            System.out.println("Current Filter by Ratings: Blocked");
                        }

                        System.out.println("\nConfirm Change in Access?");
                        System.out.println("\n1. Yes");
                        System.out.println("2. Back\n");
                        int cfmChoice = scan1.nextInt();
                        if (cfmChoice == 1) {
                            FilterPermissions
                                    .setAccessRatingsFilter(!FilterPermissions.isAccessRatingsFilter());
                            if (FilterPermissions.isAccessRatingsFilter()) {
                                System.out.println("Ratings filter successfully enabled.");
                            } else {
                                System.out.println("Ratings filter successfully disabled.");
                            }
                        } else {
                            // if cfmChoice not =1 return
                            editChoice=3;
                            break;
                        }

                    }

                    else if (editChoice == 2) {
                        // edit sales filter
                        if (FilterPermissions.isAccessSalesFilter()) {
                            System.out.println("Current Filter by Sales: Allowed");
                        } else {
                            System.out.println("Current Filter by Sales: Blocked");
                        }

                        System.out.println("\nConfirm Change in Access?\n");
                        System.out.println("1. Yes");
                        System.out.println("2. Back\n");
                        int cfmChoice = scan1.nextInt();
                        if (cfmChoice == 1) {
                            FilterPermissions.setAccessSalesFilter(!FilterPermissions.isAccessSalesFilter());
                            if (FilterPermissions.isAccessSalesFilter()) {
                                System.out.println("Sales filter successfully enabled.");
                            } else {
                                System.out.println("Sales filter successfully disabled.");
                            }
                        } else {
                            break;
                        }
                    }

                }
            }
        }

    }
}
