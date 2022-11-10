import java.util.Scanner;
import Admin.adminLogin;
import Admin.createAdmin;
import User.tickets;
import User.Booking;
import User.UserAccount;
import Admin.AdminAccount;
import java.io.*;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        int identity=0;
        int choice;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        UserLogin user = new UserLogin();
        Scanner scan = new Scanner(System.in);


        while (identity!=3){
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
                int choose=0;

                while (choose!=4){


                System.out.println("1. Edit Movie Details\n");
                System.out.println("2. Edit Showtime Details\n");
                System.out.println("3. Edit Movie\n");
                System.out.println("4. Quit \n");
                System.out.println("Enter a number of your choice: ");
                choose = scan.nextInt();

                if (choose == 1) {
                    choice = 0;

                    while (choice!=5) {

                        System.out.println("1. Create Movie\n");
                        System.out.println("2. Edit Movie\n");
                        System.out.println("3. Delete Movie\n");
                        System.out.println("4. See List of Current Movies\n");
                        System.out.println("5. Back\n\n");
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

                            System.out.println("3. Enter Movie Length (in minutes)");

                            showLength = scan.nextInt();
                            scan.nextLine();
                            System.out.println("4. Enter Movie Showing Status");

                            showingStatus = scan.nextLine();

                            System.out.println("5. Enter Movie Director");

                            director = scan.nextLine();

                            System.out.println("6. Enter Movie Synopsis");

                            synopsis = scan.nextLine();

                            MoviesManager.createMovie(name, type, showLength, showingStatus, director, synopsis);
                            System.out.println("Movie has been created!");
                        } else if (choice == 2) {
                            ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                            MoviesArray = MoviesManager.readAllMovies();
                            for (int i = 0; i < MoviesArray.size(); i++) {
                                System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());
                            }
                            System.out.println("Select Movie To Edit");
                            int movie = scan.nextInt() - 1;
                            int toChange = 0;

                            while (toChange != 7) {
                                System.out.println("\nEditing: "+ MoviesArray.get(movie).getName());
                                System.out.println("\nWhich attribute would you like to edit?");
                                System.out.println("1. Movie Name");
                                System.out.println("2. Movie Type");
                                System.out.println("3. Show Length");
                                System.out.println("4. Showing Status");
                                System.out.println("5. Director");
                                System.out.println("6. Movie Synopsis");
                                System.out.println("7. Save All Changes");

                                toChange = scan.nextInt();
                                if (toChange == 1) {
                                    //name
                                    MoviesManager.editMovie(movie, "name");
                                } else if (toChange == 2) {
                                    //type
                                    MoviesManager.editMovie(movie, "type");
                                } else if (toChange == 3) {
                                    //length
                                    MoviesManager.editMovie(movie, "length");
                                } else if (toChange == 4) {
                                    //showing status
                                    MoviesManager.editMovie(movie, "status");
                                } else if (toChange == 5) {
                                    //director
                                    MoviesManager.editMovie(movie, "director");
                                } else if (toChange == 6) {
                                    //synopsis
                                    MoviesManager.editMovie(movie, "synopsis");
                                }
                            }

                        } else if (choice == 3) {
                            ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                            MoviesArray = MoviesManager.readAllMovies();
                            for (int i = 0; i < MoviesArray.size(); i++) {
                                System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());

                            }
                            System.out.println("\nSelect Movie To Delete");
                            int movie = scan.nextInt();
                            MoviesManager.deleteMovie(movie - 1);


                        } else if (choice == 4) {
                            // Movie[] MoviesArray;
                            ArrayList<Movie> MoviesArray = new ArrayList<Movie>();
                            MoviesArray = MoviesManager.readAllMovies();
                            for (int i = 0; i < MoviesArray.size(); i++) {
                                System.out.println("Name: " + MoviesArray.get(i).getName());
                                System.out.println("Movie ID: " + MoviesArray.get(i).getMovieID());
                                System.out.println("Type: " + MoviesArray.get(i).getType());
                                System.out.println("Length: " + MoviesArray.get(i).getShowLength());
                                System.out.println("Status: " + MoviesArray.get(i).getShowingStatus());
                                System.out.println("Director: " + MoviesArray.get(i).getDirector());
                                System.out.println("Synopsis: " + MoviesArray.get(i).getSynopsis() + "\n");
                            }
                        }
                    }

                } else if (choose == 2) {
                    System.out.println("1. Create Showtime\n");
                    System.out.println("2. Edit Showtime\n");
                    System.out.println("3. Delete Showtime\n");
                    System.out.println("4. See List of Current Showtimes\n\n");
//                System.out.println("5. Seat tester");
                    System.out.println("Enter a number of your choice: ");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        int moviechoice;
                        //String showtime;
                        int movieid1;
                        String cinemaID;

                        scan.nextLine();
                        System.out.println("1. Choose Movie");

                        ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
                        for (int i = 0; i < MoviesArray.size(); i++) {
                            System.out.println(Integer.toString(i + 1) + ". " + MoviesArray.get(i).getName());
                        }

                        moviechoice = scan.nextInt();

                        int x = moviechoice - 1;
                        String moviename = MoviesArray.get(x).getName();
                        movieid1 = MoviesArray.get(x).getMovieID();

                        scan.nextLine();

                        System.out.println("2. Enter Date- DD/MM/YYYY: ");

                        String date = scan.nextLine();

                        System.out.println("Choose a showtime from the following list:\n");

                        File f = new File("DATFiles/Showtimes.dat");


//                     initialise an array of timings for admin to choose from
                        String[] timings;
                        ArrayList<String> newTimings = new ArrayList<String>();
                        timings = new String[5];
                        timings[0] = "10:00";
                        timings[1] = "12:30";
                        timings[2] = "15:00";
                        timings[3] = "17:30";
                        timings[4] = "20:00";
                        int k = 1;

                        String showtime;
                        boolean toAdd;

                        if (f.exists()) {

                            ArrayList<Showtimes> arrayoftimes = new ArrayList<Showtimes>(ShowtimesManager.searchShowtimes(date, movieid1));
                            //System.out.println(arrayoftimes.size());
                            for (int j = 0; j < 5; j++) {
                                toAdd= true;
                                for (int i = 0; i < arrayoftimes.size(); i++ ) {
                                    //System.out.println(arrayoftimes.get(i).getShowtime().substring(9));
                                    if ((arrayoftimes.get(i).getShowtime().substring(11).equals(timings[j]))) {
                                        toAdd = false;
                                    }
                                    ;
                                }
                                if (toAdd == true){
                                    System.out.println(Integer.toString(k) + ". " + timings[j]);
                                    newTimings.add(timings[j]);
                                    k++;
                                }

                            }
                            int choiceoftime = scan.nextInt();

                            showtime = date + " " + newTimings.get(choiceoftime - 1);

                        } else {
                            for (int j = 0; j < 5; j++) {
                                System.out.println(Integer.toString(k) + ". " + timings[j]);
                                k++;
                            }
                            int choiceoftime = scan.nextInt();
                            showtime = date + " " + timings[choiceoftime - 1];
                        }




                        //System.out.println(showtime);

                        scan.nextLine();
                        System.out.println("3. Enter Cinema ID: ");
                        cinemaID = scan.nextLine();

                        //ShowtimesManager.initialiser();
                        ShowtimesManager.createShowtimes(showtime, moviename, cinemaID);
                        System.out.println("Showtime has been created!");
                        return;

                    } else if (choice == 2) {
//                    ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
//
//                    for (int i = 0; i < ShowtimesArray.size(); i++) {
//                        System.out.println((i+1) +". " + ShowtimesArray.get(i).getShowtime());
//                    }
//                    System.out.println("Select Movie To Edit");
//                    int showtime = scan.nextInt()-1;
//                    int toChange = 0;
//
//                    while (toChange!=7){
//                        System.out.println("\nWhich attribute would you like to edit?");
//                        System.out.println("1. Movie Name");
//                        System.out.println("2. Movie Type");
//                        System.out.println("3. Show Length");
//                        System.out.println("4. Showing Status");
//                        System.out.println("5. Director");
//                        System.out.println("6. Movie Synopsis");
//                        System.out.println("7. Save All Changes");
//
//                        toChange = scan.nextInt();
//                        if (toChange ==1){
//                            //name
//                            MoviesManager.editMovie(movie, "name");
//                        }
//                        else if (toChange ==2){
//                            //type
//                            MoviesManager.editMovie(movie, "type");
//                        }
//                        else if (toChange ==3){
//                            //length
//                            MoviesManager.editMovie(movie, "length");
//                        }
//                        else if (toChange ==4){
//                            //showing status
//                            MoviesManager.editMovie(movie, "status");
//                        }
//                        else if (toChange ==5){
//                            //director
//                            MoviesManager.editMovie(movie, "director");
//                        }
//                        else if (toChange ==6){
//                            //synopsis
//                            MoviesManager.editMovie(movie, "synopsis");
//                        }
//                    }

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

                        ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                        for (int i = 0; i < ShowtimesArray.size(); i++) {
                            System.out.println("Movie Name: " + ShowtimesArray.get(i).getMoviename());
                            System.out.println("Showtime: " + ShowtimesArray.get(i).getShowtime());
                            System.out.println("Movie ID: " + ShowtimesArray.get(i).getMovieID());
                            System.out.println("Cinema ID: " + ShowtimesArray.get(i).getCinemaID()+"\n");
                        }
                    }

//                else if (choice ==5){
//
//                    int moviechoice;
//                    //String showtime;
//                    int movieid1;
//                    String cinemaID;
//
//                    scan.nextLine();
//                    System.out.println("1. Choose Movie");
//
//                    ArrayList<Movie> MoviesArray = MoviesManager.readAllMovies();
//                    for (int i = 0; i < MoviesArray.size(); i++) {
//                        System.out.println(Integer.toString(i + 1) + ". " + MoviesArray.get(i).getName());
//                    }
//
//                    moviechoice = scan.nextInt();
//
//                    int x = moviechoice - 1;
//                    String moviename = MoviesArray.get(x).getName();
//                    movieid1 = MoviesArray.get(x).getMovieID();
//
//                    ShowtimesManager.searchShowtimes("25/12/2022", movieid1).get(0).getSeats().displaySeatPlan();
//                    //ShowtimesManager.searchShowtimes("21/12/2022", movieid1).get(0).getSeats().assignSeat(5,5);
//                    ShowtimesManager.updateSeats(ShowtimesManager.searchShowtimes("25/12/2022", movieid1).get(0).getShowtimeID());
//                    ShowtimesManager.searchShowtimes("25/12/2022", movieid1).get(0).getSeats().displaySeatPlan();
//
//
//
//
//
//
//                }

                }
                if (choose == 3){
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
            return;
        }

            else if (identity == 2) {
                System.out.println("You are now a user");
                System.out.println("What would you like to do now ");
                System.out.println("(1) Book a movie");
                System.out.println("(2) Search/List movie");
//                System.out.println("(2) Log In");
//                System.out.println("(3) Sign Up");
                System.out.println("(3) View Movie Details");
                System.out.println("(4) Check seat availability"); // needs to be updated
                System.out.println("(5) List top 5 movies");
                System.out.println("(6) View Booking History"); // need to log in
                System.out.println("(7) Rate movies");
                System.out.println("(8) Exit");
                int option = scan.nextInt();

                while (option != 8) {
                    if (option == 1) { // Book a movie
                        System.out.println("These are the cineplexes");
                        ReadCineplexes readCineplexes = new ReadCineplexes();
                        for (int i = 0; i < readCineplexes.getCineplexes().length; i++) {
                            System.out.println("[" + (i + 1) + "] " + readCineplexes.getCineplexes()[i].getCineplexName() + "\n");
                        }
                        System.out.println("Choose your cineplex: ");
                        int a = scan.nextInt();
                        if (a > readCineplexes.getCineplexes().length || a < 1) {
                            System.out.println("Invalid option, please choose again");
                            a = scan.nextInt();
                        }
                        System.out.println("Your choice is: " + readCineplexes.getCineplexes()[a - 1].getCineplexName());
                        Cineplex userCineplex = new Cineplex(readCineplexes.getCineplexes()[a - 1].getCineplexName());
                        System.out.println("Choose your movie! ");
                        for (int j = 0; j < userCineplex.getMovies().length; j++) {
                            System.out.println("[" + (j + 1) + "] " + userCineplex.getMovies()[j] + "\n");
                        }
                        int b = scan.nextInt();
                        if (b > userCineplex.getMovies().length || b < 1) {
                            System.out.println("Invalid choice, please choose again");
                            b = scan.nextInt();
                        }
                        System.out.println("Your choice is: " + userCineplex.getMovies()[b - 1]);
                        String movieChosen = userCineplex.getMovies()[b - 1];

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

                        Pricing newprice = new Pricing();
                        float c = newprice.obtainPricing("digital", "Typical", "Student", true, true, "THU", true);
                        System.out.println("Your pricing is: " + c);
                        System.out.println("How many seat do you want");
                        int f = scan.nextInt();
                        SeatingPlan layout = new SeatingPlan(5, 5);
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
                            int seatId = new Seat(e * 100 + d).getSeatId();
                            System.out.println("This is your chosen seat: " + seatId);
                            layout.displaySeatPlan();
                            SeatsArray.add(String.valueOf(seatId));
                        }

                        //generating tickets from the array
                        for (int n = 0; n < SeatsArray.size(); n++) {
                            System.out.println("\nTicket" + ":");
                            tickets tics = new tickets(movieChosen, "JE1", String.valueOf(g), String.valueOf(h), SeatsArray.get(n));
                        }
//
//                        System.out.println("Please Sign up or Log in to register your booking.");
//                        System.out.println("[1] Sign up");
//                        System.out.println("[2] Log in");
//                        String newUsername=" ";
//                        int op = scan.nextInt();
//                        scan.nextLine();
//                        if (op == 1) {
//                            String name;
//                            int phoneNumber;
//                            String email;
//                            String username;
//                            String password;
//                            int userId;
//                            scan.nextLine();
//                            System.out.println("Please enter your name: ");
//                            name = scan.nextLine();
//                            System.out.println("Please enter your phone number: ");
//                            phoneNumber = scan.nextInt();
//                            scan.nextLine();
//                            System.out.println("Please enter your email: ");
//                            email = scan.nextLine();
//                            System.out.println("Please enter your username: ");
//                            username = scan.nextLine();
//                            System.out.println("Please enter your password: ");
//                            password = scan.nextLine();
//                            UsersManager.createUser(username, password, name, phoneNumber, email);
//                            newUsername = username;
//                        }
//
//                        else if (op == 2) {
//                            String usernameInput;
//                            String passwordInput;
//                            while (true) {
//                                System.out.println(UsersManager.readAllUsers().get(0).getUsername());
//                                System.out.println(UsersManager.readAllUsers().get(0).getPassword());
//                                System.out.println("Please enter your username: ");
//                                usernameInput = scan.nextLine();
//                                if (UserLogin.verifyUsername(usernameInput)) {
//                                    System.out.println("Please enter your password: ");
//                                    passwordInput = scan.nextLine();
//                                    while (!UserLogin.verifyPassword(usernameInput, passwordInput)) {
//                                        System.out.println("Invalid password, please try again. ");
//                                        passwordInput = scan.nextLine();
//                                    }
//                                    System.out.println("Welcome back " + usernameInput);
//                                    break;
//
//                                } else {
//                                    System.out.println("Username not found, please try again. ");
//                                }
//                            }
//                            newUsername = usernameInput;
//                        }
//                        // Generating transaction ID
//                        String txnID = new Transaction("XXX").getTransactionId();
//                        // Making a booking
//                        int count =0;
//                        Booking booked = new Booking("poohy", "poohyemail", 12345678, c * SeatsArray.size(), txnID, String.valueOf(g), String.valueOf(h));
//                        Booking booked1 = new Booking("htut", "poohyemail", 12345678, c * SeatsArray.size(), txnID, String.valueOf(g), String.valueOf(h));
//                        ArrayList<UserAccount> usersList = UsersManager.readAllUsers();
//                        for(count=0; count<usersList.size(); count++){
//                            if(usersList.get(count).getUsername().equals(newUsername)) {
//                                UsersManager.editBookingHistory(count, booked1);
//                                break;
//                            }
//
//                        }
//                        UsersManager.readAllUsers().get(count).showBookingHistory();
//                    }
                    }

                    if (option == 2){ //Search/List movies
//                        boolean exit = true;
                        int searchOrList = 0;
                        while(searchOrList != 3) {
                            System.out.println("What would you like to do?");
                            System.out.println("(1) Search movie by title");
                            System.out.println("(2) List all movies");
                            System.out.println("(3) Exit");
                            searchOrList = scan.nextInt();


                            if (searchOrList == 1) {
                                MoviesManager.searchMovie();
                            } else if (searchOrList == 2) {
                                MoviesManager.printMoviedb();
                            }
//                            }else if (searchOrList == 3){
//                                return;
//                            }

                        }

                    }

                    if (option == 3) { //View movie details
                        System.out.println("Please select the movie you'd like to find out more about: ");
                        Cineplex readingMovies = new Cineplex("Tampines");
                        for (int i = 0; i < readingMovies.getMovies().length; i++) {
                            System.out.println("[" + (i + 1) + "]" + readingMovies.getMovies()[i]);
                        }
                        int movieSelection = scan.nextInt();
                        if (movieSelection > readingMovies.getMovies().length || movieSelection < 1) {
                            System.out.println("Invalid input, select again");
                            movieSelection = scan.nextInt();
                        }
                        System.out.println("You've chosen: " + readingMovies.getMovies()[movieSelection - 1]);
                        System.out.println("Here are the associated movie details!\n");
                        System.out.println("Name: " + readingMovies.getMovieDetails(movieSelection).getName());
                        System.out.println("Type: " + readingMovies.getMovieDetails(movieSelection).getType());
                        System.out.println("Director: " + readingMovies.getMovieDetails(movieSelection).getDirector());
                        System.out.println("Rating: " + readingMovies.getMovieDetails(movieSelection).getRating());
                        System.out.println("Show Status: " + readingMovies.getMovieDetails(movieSelection).getShowingStatus());
                        System.out.println("Show Length: " + readingMovies.getMovieDetails(movieSelection).getShowLength());
                        System.out.println("Synopsis: " + readingMovies.getMovieDetails(movieSelection).getSynopsis());
                    }

                    if (option == 4){ //Check Seat availability

                    }

                    if (option == 5){ //List top 5 movies

                        System.out.println("Would you like to list the top 5 movies according to:");
                        System.out.println("(1) Ratings");
                        System.out.println("(2) Ticket Sales");
                        System.out.println("(3) Exit");
                        int listingMovies = scan.nextInt();
                        int i;

                        if (listingMovies == 1){
                            ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
                            ArrayList<Integer> allRatings = new ArrayList<Integer>();
                            for (i=0; i<allMovies.size(); i++){
                                allRatings.add(allMovies.get(i).getRating()[1]);
                            }
                            for (i=0; i<allRatings.size(); i++){
                                System.out.println(allRatings.get(i));
                                for (int j=0; j<allRatings.size(); j++){
                                    if (allRatings.get(j) > allRatings.get(j+1)){
                                        int temp = allRatings.get(j);
                                        allRatings.set(j, allRatings.get(j+1));
                                        allRatings.set(j+1, temp);
                                    }
                                }
                            }
                        }
                    }

                    if (option == 6) { //View Booking History
//                        System.out.println("Please enter your username");
//                        username1 = scan.next();
//
//                        while (!user.verifyUsername(username1)) {
//                            if (user.verifyUsername(username1)) {
//                                System.out.println("Username is valid");
//                            } else {
//                                System.out.println("Username is invalid, please key in again");
//                                username1 = scan.next();
//                            }
//                        }
//
//                        System.out.println("Please enter your password");
//                        password1 = scan.next();
//                        while (!user.verifyPassword(username1, password1)) {
//                            if (user.verifyPassword(username1, password1)) {
//                                System.out.println("Password is valid");
//
//                            } else {
//                                System.out.println("Password is invalid, please key in again");
//                                password1 = scan.next();
//                            }
//                        }
                        // add code for viewing booking history
                    }

                    if (option == 7) {
//                        System.out.println("What is your username");
//                        String f = scan.next();
//                        System.out.println("What is your password");
//                        String g = scan.next();
//                        System.out.println("What is your name");
//                        String h = scan.next();
//                        System.out.println("What is your email");
//                        String i = scan.next();
//                        System.out.println("What is your phone number");
//                        int j = scan.nextInt();
//                        try {
//                            UserAccount newAccount = new UserAccount(f, g, h, i, j);
//                            FileOutputStream fout = new FileOutputStream("UserAccounts.dat");
//                            ObjectOutputStream out = new ObjectOutputStream(fout);
//                            out.writeObject(newAccount);
//                            out.flush();
//                            out.close();
//                            System.out.println("success");
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }

                    }
                }
            }
        }

    }
}
