import java.util.Scanner;
import Admin.adminLogin;
import Admin.createAdmin;
import User.UserLogin;
import User.tickets;
import User.Booking;
import User.UserAccount;
import User.UserLogin;
import Admin.AdminAccount;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Float.parseFloat;

public class MainApp {
    public static void main(String[] args) {
        PricingManager.createPricing(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f,0f, 0f, 0f, 0f);
        int identity;
        int choice;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        UserLogin user = new UserLogin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you brother?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1) {
            createAdmin.main();
            System.out.println("Please enter your username");
            username1 = scan.next();

            while (!admin.verifyUsername(username1)) {
                if (admin.verifyUsername(username1)) {
                    System.out.println("Username is valid");
                } else {
                    System.out.println("Username is invalid, please key in again");
                    username1 = scan.next();
                }
            }

            System.out.println("Please enter your password");
            password1 = scan.next();
            while (!admin.verifyPassword(username1, password1)) {
                if (admin.verifyPassword(username1, password1)) {
                    System.out.println("Password is valid");
                } else {
                    System.out.println("Password is invalid, please key in again");
                    password1 = scan.next();
                }
            }



            System.out.println("1. Create Movie\n");
            System.out.println("2. Edit Movie\n");
            System.out.println("3. Delete Movie\n");
            System.out.println("4. See List of Current Movies\n");
            System.out.println("5. Adjust Pricing\n\n");
            System.out.println("Enter a number of your choice: ");
            choice = scan.nextInt();

            if (choice == 1) {
                String name;
                String type;
                String rating;
                int showLength;
                String showingStatus;
                String director;
                String synopsis;

                scan.nextLine();
                System.out.println("1. Enter Movie Name");

                name = scan.nextLine();

                System.out.println("2. Enter Movie Type");

                type = scan.nextLine();

                System.out.println("3. Enter Movie Rating");

                rating = scan.nextLine();

                System.out.println("4. Enter Movie Length");

                showLength = scan.nextInt();
                scan.nextLine();
                System.out.println("5. Enter Movie Showing Status");

                showingStatus = scan.nextLine();

                System.out.println("6. Enter Movie Director");

                director = scan.nextLine();

                System.out.println("7. Enter Movie Synopsis");

                synopsis = scan.nextLine();

                MoviesManager.createMovie(name, type, rating, showLength, showingStatus, director, synopsis);
                System.out.println("Movie has been created!");
                return;
            } else if (choice == 2) {
                ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                MoviesArray = MoviesManager.readAllMovies();
                System.out.println("Select Movie To Edit");
                int movie = scan.nextInt()-1;
                int toChange = 0;

                while (toChange!=7){
                    System.out.println("\nWhich attribute would you like to edit?");
                    System.out.println("1. Movie Name");
                    System.out.println("2. Movie Type");
                    System.out.println("3. Show Length");
                    System.out.println("4. Showing Status");
                    System.out.println("5. Director");
                    System.out.println("6. Movie Synopsis");
                    System.out.println("7. Save All Changes");

                    toChange = scan.nextInt();
                    if (toChange ==1){
                        //name
                        MoviesManager.editMovie(movie, "name");
                    }
                    else if (toChange ==2){
                        //type
                        MoviesManager.editMovie(movie, "type");
                    }
                    else if (toChange ==3){
                        //length
                        MoviesManager.editMovie(movie, "length");
                    }
                    else if (toChange ==4){
                        //showing status
                        MoviesManager.editMovie(movie, "status");
                    }
                    else if (toChange ==5){
                        //director
                        MoviesManager.editMovie(movie, "director");
                    }
                    else if (toChange ==6){
                        //synopsis
                        MoviesManager.editMovie(movie, "synopsis");
                    }
                }

            } else if (choice == 3) {
                ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                MoviesArray = MoviesManager.readAllMovies();
                for (int i = 0; i < MoviesArray.size(); i++) {
                    System.out.println((i+1) +". " + MoviesArray.get(i).getName());

                }
                System.out.println("\nSelect Movie To Delete");
                int movie = scan.nextInt();
                MoviesManager.deleteMovie (movie-1);


            } else if (choice == 4) {
//                Movie[] MoviesArray;
                ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                MoviesArray = MoviesManager.readAllMovies();
                for (int i = 0; i < MoviesArray.size(); i++) {
                    System.out.println("name " + MoviesArray.get(i).getName());
                    System.out.println("id " + MoviesArray.get(i).getMovieID());
                    System.out.println( "type " + MoviesArray.get(i).getType());
                    System.out.println( "length " + MoviesArray.get(i).getShowLength());
                    System.out.println("status " + MoviesArray.get(i).getShowingStatus());
                    System.out.println("director " + MoviesArray.get(i).getDirector());
                    System.out.println("synopsis " + MoviesArray.get(i).getSynopsis()+"\n");
                }
            } else if (choice == 5) {

                    System.out.println("Choose which price category you'd like to add: ");
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
        }
            else if (identity == 2) {
                System.out.println("You are now a user");
                System.out.println("What would you like to do now ");
                System.out.println("(1) Book a movie");
                System.out.println("(2) Log In");
                System.out.println("(3) Sign Up");
                System.out.println("(4) See Movie Details");
                int option = scan.nextInt();

                if (option == 1){
                    System.out.println("These are the cineplexes");
                    ReadCineplexes readCineplexes = new ReadCineplexes();
                    for(int i=0; i<readCineplexes.getCineplexes().length;i++){
                        System.out.println("[" + (i+1) + "] " + readCineplexes.getCineplexes()[i].getCineplexName() + "\n");
                    }
                    System.out.println("Choose your cineplex: ");
                    int a = scan.nextInt();
                    if (a> readCineplexes.getCineplexes().length || a < 1){
                        System.out.println("Invalid option, please choose again");
                        a = scan.nextInt();
                    }
                    System.out.println("Your choice is: " + readCineplexes.getCineplexes()[a-1].getCineplexName());
                    Cineplex userCineplex = new Cineplex(readCineplexes.getCineplexes()[a-1].getCineplexName());
                    System.out.println("Choose your movie! ");
                    for(int j=0; j<userCineplex.getMovies().length;j++){
                        System.out.println("[" + (j+1) + "] " + userCineplex.getMovies()[j] + "\n");
                    }
                    int b = scan.nextInt();
                    if (b > userCineplex.getMovies().length || b < 1){
                        System.out.println("Invalid choice, please choose again");
                        b = scan.nextInt();
                    }
                    System.out.println("Your choice is: " + userCineplex.getMovies()[b-1]);
                    String movieChosen = userCineplex.getMovies()[b-1];

                    System.out.println("What dates would you like to see this movie (Please enter in ddMM format): ");
                    int g = scan.nextInt();
                    //show the movie timings here.

//                    if (g > showmoviedates(chosen_movie).length || g < 1){
//                        System.out.println("Invalid choice, please choose again");
//                        g = scan.nextInt();
//                    }
//                    System.out.println("Your choice of date is: " + showmovietimings(chosen_movie).getshowtimings()[f-1]);

                    System.out.println("What timings would you like to see this movie: ");
                    int h = scan.nextInt();
//                    if (h > showmovietimings(chosen_date, chosen_movie).length || h < 1){
//                        System.out.println("Invalid choice, please choose again");
//                        h = scan.nextInt();
//                    }
//                    System.out.println("Your choice of date is: " + showmovietimings(chosen_date, chosen_movie).getshowtimings()[g-1]);

                    System.out.println("How many seat do you want");
                    int f = scan.nextInt();
                    SeatingPlan layout = new SeatingPlan(5,5);
                    ArrayList<String> SeatsArray = new ArrayList<>();
                    // asking for seats and saving it to an array
                    for (int i = 0; i < f; i++) {
                        layout.displaySeatPlan();
                        System.out.println("input your desired row and column");
                        System.out.println("row: ");
                        int d = scan.nextInt();
                        System.out.println("column: ");
                        int e = scan.nextInt();
                        layout.assignSeat((d - 1), (e - 1));
                        System.out.println("This is your chosen seat");
                        layout.displaySeatPlan();
                        int seatId = new Seat(e*100+d).getSeatId();
                        SeatsArray.add(String.valueOf(seatId));
                    }
                    // Generating transaction ID
                    String txnID = new Transaction("XXX").getTransactionId();
                    // Making a booking
                    Booking booked = new Booking("poohy", "poohyemail", 12345678, SeatsArray.size(), txnID, String.valueOf(g),String.valueOf(h));

                    // POP up to ask them to log in/sign up before confirming payment
//                    System.out.println("Before you proceed, please sign in or log in" + "\n (1) Log In \n (2) Creat new account");
//                    int bookingpopup = scan.nextInt();
//                    switch(bookingpopup){
//                        case 1:
//                            System.out.println("Please enter your username");
//                            username1 = scan.next();
//
//                            while (!user.verifyUsername(username1)) {
//                                if (user.verifyUsername(username1)) {
//                                    System.out.println("Username is valid");
//                                } else {
//                                    System.out.println("Username is invalid, please key in again");
//                                    username1 = scan.next();
//                                }
//                            }
//
//                            System.out.println("Please enter your password");
//                            password1 = scan.next();
//                            while (!user.verifyPassword(username1, password1)) {
//                                if (user.verifyPassword(username1, password1)) {
//                                    System.out.println("Password is valid");
//
//                                } else {
//                                    System.out.println("Password is invalid, please key in again");
//                                    password1 = scan.next();
//                                }
//                            }
//                            break;
//
//                        case 2:
//                            //add code for creating new acc
//                            break;
//                    }

                    UserLogin u = new UserLogin();
                    for(int j=0; j<u.getUsers()[0].getBookingHistory().size();j++) {
                        System.out.println(u.getUsers()[0].getBookingHistory().get(j).getTXNid());
                    }

                    //generating tickets from the array
                    for (int n = 0; n < SeatsArray.size(); n++){
                        System.out.println("\nTicket" + ":");
                        tickets tics = new tickets (movieChosen,"JE1", String.valueOf(g), String.valueOf(h), SeatsArray.get(n));
                    }
                }

                if (option == 2) {
                    System.out.println("Please enter your username");
                    username1 = scan.next();

                    while (!user.verifyUsername(username1)) {
                        if (user.verifyUsername(username1)) {
                            System.out.println("Username is valid");
                        } else {
                            System.out.println("Username is invalid, please key in again");
                            username1 = scan.next();
                        }
                    }

                    System.out.println("Please enter your password");
                    password1 = scan.next();
                    while (!user.verifyPassword(username1, password1)) {
                        if (user.verifyPassword(username1, password1)) {
                            System.out.println("Password is valid");

                        } else {
                            System.out.println("Password is invalid, please key in again");
                            password1 = scan.next();
                        }
                    }
                    System.out.println("What would you like to do?");
                    System.out.println("[1] View booking history");
                    System.out.println("[2] Leave a review");
                }

                if (option == 3){
                    System.out.println("What is your username");
                    String f = scan.next();
                    System.out.println("What is your password");
                    String g = scan.next();
                    System.out.println("What is your name");
                    String h = scan.next();
                    System.out.println("What is your email");
                    String i = scan.next();
                    System.out.println("What is your phone number");
                    int j = scan.nextInt();
                    try {
                        UserAccount newAccount = new UserAccount(f, g, h, i, j);
                        FileOutputStream fout=new FileOutputStream("UserAccounts.dat");
                        ObjectOutputStream out=new ObjectOutputStream(fout);
                        out.writeObject(newAccount);
                        out.flush();
                        out.close();
                        System.out.println("success");
                    }catch(Exception e){System.out.println(e);}

                }

                if (option == 4){
                    System.out.println("Please select the movie you'd like to find out more about: ");
                    Cineplex readingMovies = new Cineplex ("Tampines");
                    for (int i = 0; i < readingMovies.getMovies().length; i++){
                        System.out.println("[" + (i+1) + "]" + readingMovies.getMovies()[i]);
                    }
                    int h = scan.nextInt();
                    if (h > readingMovies.getMovies().length || h < 1){
                        System.out.println("Invalid input, select again");
                        h = scan.nextInt();
                    }
                    System.out.println("You've chosen: " + readingMovies.getMovies()[h-1]);
                    System.out.println("Here are the associated movie details!\n");
                    System.out.println("Name: " + readingMovies.getMovieDetails(h).getName());
                    System.out.println("Type: " + readingMovies.getMovieDetails(h).getType());
                    System.out.println("Director: " + readingMovies.getMovieDetails(h).getDirector());
                    System.out.println("Rating: " + readingMovies.getMovieDetails(h).getRating());
                    System.out.println("Show Status: " + readingMovies.getMovieDetails(h).getShowingStatus());
                    System.out.println("Show Length: " + readingMovies.getMovieDetails(h).getShowLength());
                    System.out.println("Synopsis: " + readingMovies.getMovieDetails(h).getSynopsis());
                }
            } 
            else {
                return;
            }
    }
}
