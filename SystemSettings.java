import java.util.Scanner;

public class SystemSettings {


    public static void editPricing() {
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


    public static void editHolidayDates() {

    }

    public static void editTop5Filtering() {


        Scanner scan = new Scanner(System.in);
        int filterChoice = 0;

        System.out.println("Choose your function: ");
        System.out.println("1. View Top 5 Movies");
        System.out.println("2. Edit Filter Controls For User");
        System.out.println("3. Back");
        filterChoice = scan.nextInt();

//        boolean chooseFunctions = true;

        while (filterChoice!=3) {

            if (filterChoice == 1) {
                //view top 5 by filter
                int secondFilterChoice = 0;

                System.out.println("Choose filter: ");
                System.out.println("1. See Top 5 Movies by Sales");
                System.out.println("2. See Top 5 Movies by Ratings");
                System.out.println("3. Back");

                while (true) {
                    secondFilterChoice = scan.nextInt();
                    if (secondFilterChoice < 1 && secondFilterChoice > 3) {
                        System.out.println("Invalid Input. Choose Again");
                        filterChoice = scan.nextInt();
                    }
                    if (secondFilterChoice ==1){
                        ListTop5MoviesUI.sortBySales();
                    }
                    else if (secondFilterChoice ==2){
                        ListTop5MoviesUI.sortByRatings();
                    }
                    else if (secondFilterChoice ==3){
                        break;
                    }

                }

            } else if (filterChoice == 2) {
                int secondFilterChoice = 0;

                System.out.println("Choose your function: ");
                System.out.println("1. Edit Default Display For Users ");
                System.out.println("2. Edit Filter Controls For User");
                System.out.println("3. Back");

                while (true) {
                    secondFilterChoice = scan.nextInt();
                    if (secondFilterChoice < 1 && secondFilterChoice > 3) {
                        System.out.println("Invalid Input. Choose Again");
                        filterChoice = scan.nextInt();
                    }

                    if (secondFilterChoice == 1) {
                        //change default filter
                        RatingFilterType nonDefaultFilter;
                        System.out.println("Current Default Filter: " + FilterPermissions.getDefaultFilter());
                        if (FilterPermissions.getDefaultFilter() == RatingFilterType.RATINGS) {
                            ListTop5MoviesUI.sortByRatings();
                            nonDefaultFilter = RatingFilterType.SALES;
                        } else {
                            ListTop5MoviesUI.sortBySales();
                            nonDefaultFilter = RatingFilterType.RATINGS;

                        }

                        //ask if use wants to change
                        int approveSwitch = 0 ;

                        while (true){
                            System.out.println("Would you like to switch the filter to: Sorting " + nonDefaultFilter.toString() + "?");
                            System.out.println("1. Yes");
                            System.out.println("2. Back");

                            if (approveSwitch !=1 && approveSwitch !=2) {
                                approveSwitch = scan.nextInt();
                                System.out.println("Invalid Input. Choose Again");
                                filterChoice = scan.nextInt();
                            }

                            if (approveSwitch==1){
                                FilterPermissions.setDefaultFilter(nonDefaultFilter);
                                System.out.println("Default Filter Set To: Filter " + nonDefaultFilter.toString());
                            }
                            else if (approveSwitch==2){
                                break;
                            }
                        }


                    }
                    else if (secondFilterChoice==2){
                        //edit permissions for user to see top 5 by various filters
                        System.out.println("Current User Permissions:");
                        if(FilterPermissions.isAccessRatingsFilter()){
                            System.out.println("Filter by Ratings: Allowed");
                        }
                        else{
                            System.out.println("Filter by Ratings: Blocked");
                        }
                        if(FilterPermissions.isAccessSalesFilter()){
                            System.out.println("Filter by Sales: Allowed");
                        }
                        else{
                            System.out.println("Filter by Sales: Blocked");
                        }



                        int editChoice = 0 ;

                        while (true){
                            System.out.println("\n1. Edit User Access to Ratings Filter");
                            System.out.println("\n2. Edit User Access to Sales Filter");
                            System.out.println("\n3. Back");

                            if (editChoice==1){
                                //edit ratings Filter
                                if(FilterPermissions.isAccessRatingsFilter()){
                                    System.out.println("Current Filter by Ratings: Allowed");
                                }
                                else{
                                    System.out.println("Current Filter by Ratings: Blocked");
                                }

                                System.out.println("Confirm Change in Access?");
                                System.out.println("1. Yes");
                                System.out.println("2. Back");
                                int cfmChoice = scan.nextInt();
                                if (cfmChoice ==1){
                                    FilterPermissions.setAccessRatingsFilter(!FilterPermissions.isAccessRatingsFilter());
                                    if(FilterPermissions.isAccessRatingsFilter()){
                                        System.out.println("Ratings filter successfully enabled.");
                                    }
                                    else{
                                        System.out.println("Ratings filter successfully disabled.");
                                    }
                                }
                                else{
                                    // if cfmChoice not =1 return
                                    break;
                                }

                            }

                            else if (editChoice==2) {
                                //edit sales filter
                                if(FilterPermissions.isAccessSalesFilter()){
                                    System.out.println("Current Filter by Sales: Allowed");
                                }
                                else{
                                    System.out.println("Current Filter by Sales: Blocked");
                                }

                                System.out.println("Confirm Change in Access?");
                                System.out.println("1. Yes");
                                System.out.println("2. Back");
                                int cfmChoice = scan.nextInt();
                                if (cfmChoice ==1){
                                    FilterPermissions.setAccessSalesFilter(!FilterPermissions.isAccessSalesFilter());
                                    if(FilterPermissions.isAccessSalesFilter()){
                                        System.out.println("Sales filter successfully enabled.");
                                    }
                                    else{
                                        System.out.println("Sales filter successfully disabled.");
                                    }
                                }
                                else{
                                    //if cfmChoice not == 1, return
                                    return;
                                }

                            }
                            else if (editChoice ==3){
                                break;
                            }

                            }


                        }
                    else if (secondFilterChoice==3){
                        break;
                    }

                }
            }


        }
    }


}
