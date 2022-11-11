import java.util.Date;
import java.util.Scanner;
import Admin.adminLogin;
import Admin.createAdmin;
import User.tickets;
import Admin.AdminAccount;
import java.io.*;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        int identity = 0;
        int choice;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        UserLogin user = new UserLogin();
        Scanner scan = new Scanner(System.in);


        while (identity != 3) {
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
                int choose = 0;

                while (choose != 4) {


                    System.out.println("1. Edit Movie Details\n");
                    System.out.println("2. Edit Showtime Details\n");
                    System.out.println("3. Edit System Settings\n");
                    System.out.println("4. Quit \n");
                    System.out.println("Enter a number of your choice: ");
                    choose = scan.nextInt();

                    if (choose == 1) {
                        choice = 0;

                        while (choice != 5) {

                            System.out.println("1. Create Movie\n");
                            System.out.println("2. Edit Movie\n");
                            System.out.println("3. Delete Movie\n");
                            System.out.println("4. See List of Current Movies\n");
                            System.out.println("5. Back\n\n");
                            System.out.println("Enter a number of your choice: ");
                            choice = scan.nextInt();


                        if (choice == 1) {
                            String name;
                            MovieType type;
                            String rating;
                            int showLength;
                            MovieStatus showingStatus;
                            String director;
                            String synopsis;

                                scan.nextLine();
                                System.out.println("1. Enter Movie Name");

                                name = scan.nextLine();

                            System.out.println("2. Choose Movie Type");

                            System.out.println("[1] " + MovieType.DIGITAL2D.toString());
                            System.out.println("[2] " + MovieType.DIGITAL3D.toString());
                            System.out.println("[3] " + MovieType.BLOCKBUSTER2D.toString());
                            System.out.println("[4] " + MovieType.BLOCKBUSTER3D.toString());

                            int typeChoice = scan.nextInt();

                            while(typeChoice<1 && typeChoice>4){
                                System.out.println("Invalid Choice. Choose Again.");
                                typeChoice = scan.nextInt();
                            }

                            if (typeChoice == 1){
                                type = MovieType.DIGITAL2D;
                            }
                            else if (typeChoice == 2){
                                type = MovieType.DIGITAL3D;
                            }
                            else if (typeChoice == 3){
                                type = MovieType.BLOCKBUSTER2D;
                            }
                            else {
                                type = MovieType.BLOCKBUSTER3D;
                            }


                                System.out.println("3. Enter Movie Length (in minutes)");

                            showLength = scan.nextInt();
                            scan.nextLine();
                            System.out.println("4. Choose Movie Showing Status");

                            System.out.println("[1] " + MovieStatus.COMING_SOON.toString());
                            System.out.println("[2] " + MovieStatus.NOW_SHOWING.toString());
                            System.out.println("[3] " + MovieStatus.END_OF_SHOW.toString());

                            int statusChoice = scan.nextInt();

                            while(statusChoice<1 && statusChoice>3){
                                System.out.println("Invalid Choice. Choose Again.");
                                statusChoice = scan.nextInt();
                            }

                            if (statusChoice == 1){
                                showingStatus = MovieStatus.COMING_SOON;
                            }
                            else if (statusChoice == 2){
                                showingStatus = MovieStatus.NOW_SHOWING;
                            }
                            else {
                                showingStatus = MovieStatus.END_OF_SHOW;
                            }

                                System.out.println("5. Enter Movie Director");

                            scan.nextLine();
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
                                    System.out.println("\nEditing: " + MoviesArray.get(movie).getName());
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
                                System.out.println("Type: " + MoviesArray.get(i).getType().toString());
                                System.out.println("Length: " + MoviesArray.get(i).getShowLength());
                                System.out.println("Status: " + MoviesArray.get(i).getShowingStatus().toString());
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
                                    toAdd = true;
                                    for (int i = 0; i < arrayoftimes.size(); i++) {
                                        //System.out.println(arrayoftimes.get(i).getShowtime().substring(9));
                                        if ((arrayoftimes.get(i).getShowtime().substring(11).equals(timings[j]))) {
                                            toAdd = false;
                                        }
                                        ;
                                    }
                                    if (toAdd == true) {
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
                                System.out.println((i + 1) + ". " + MoviesArray.get(i).getName());

                            }
                            System.out.println("\nSelect Movie To Delete");
                            int movie = scan.nextInt();
                            MoviesManager.deleteMovie(movie - 1);


                        } else if (choice == 4) {

                            ArrayList<Showtimes> ShowtimesArray = ShowtimesManager.readAllShowtimes();
                            for (int i = 0; i < ShowtimesArray.size(); i++) {
                                System.out.println("Movie Name: " + ShowtimesArray.get(i).getMoviename());
                                System.out.println("Showtime: " + ShowtimesArray.get(i).getShowtime());
                                System.out.println("Movie ID: " + ShowtimesArray.get(i).getMovieID());
                                System.out.println("Cinema ID: " + ShowtimesArray.get(i).getCinemaID() + "\n");
                            }
                        }


                    }
                    if (choose == 3) {

                       int settingsChoice = 0;

                        while (settingsChoice != 4) {

                            System.out.println("1. Edit Movie Prices\n");
                            System.out.println("2. Edit Holiday Dates\n");
                            System.out.println("3. Edit Top 5 Movie Filters\n");
                            System.out.println("4. Back\n");
                            System.out.println("Enter a number of your choice: ");
                            settingsChoice = scan.nextInt();


                        if (settingsChoice ==1 ){
                           //edit pricing
                            SystemSettings.editPricing();
                        }
                        else if (settingsChoice ==2){
                            //change holiday dates
                            SystemSettings.editHolidayDates();
                        }
                        else if (settingsChoice ==3){
                            //change filtering of top 5 movies
                            SystemSettings.editTop5Filtering();
                        }

                    }

                }
                return;
            } }
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
                        int cineplexChoice = scan.nextInt();
                        if (cineplexChoice > readCineplexes.getCineplexes().length || cineplexChoice < 1) {
                            System.out.println("Invalid option, please choose again");
                            cineplexChoice = scan.nextInt();
                        }
                        System.out.println("Your choice is: " + readCineplexes.getCineplexes()[cineplexChoice - 1].getCineplexName());
                        Cineplex userCineplex = new Cineplex(readCineplexes.getCineplexes()[cineplexChoice - 1].getCineplexName());
                        System.out.println("Choose your movie! ");
                        ArrayList<Integer> movies = new ArrayList<Integer>(ShowtimesManager.moviesByCineplex(cineplexChoice));
                        for (int j = 0; j < movies.size(); j++) {
                            System.out.println("[" + (j + 1) + "] " + MoviesManager.getMovieNameById(movies.get(j)) + "\n");
                        }
                        int movieChoice = scan.nextInt();
                        if (movieChoice > movies.size() || movieChoice < 1) {
                            System.out.println("Invalid choice, please choose again");
                            movieChoice = scan.nextInt();
                        }
                        System.out.println("Your choice is: " + MoviesManager.getMovieNameById(movies.get(movieChoice - 1)));
                        String movieChosen = MoviesManager.getMovieNameById(movies.get(movieChoice - 1));

                        ArrayList<Showtimes> showtimesAvailable = new ArrayList<Showtimes>(ShowtimesManager.showtimesByMovieAndCineplex(cineplexChoice, movies.get(movieChoice - 1)));
                        ArrayList<String> datesToSelect = new ArrayList<String>(ShowtimesManager.showtimeDates(showtimesAvailable));

                        System.out.println("What dates would you like to see this movie (Please enter in DD/MM/YY format): ");
                        for (int z = 0; z < datesToSelect.size(); z++) {
                            System.out.println("[" + (z + 1) + "] " + datesToSelect.get(z) + "\n");
                        }
                        int g = scan.nextInt();

                        System.out.println("What timings would you like to see this movie: ");
                        for (int y = 0; y < showtimesAvailable.size(); y++) {
                            if (showtimesAvailable.get(y).getShowtime().substring(0, 10).equals(datesToSelect.get(g - 1))) {
                                System.out.println("[" + (y + 1) + "] " + showtimesAvailable.get(y).getShowtime().substring(11));
                            }
                        }

                        float seatprice = 0f;
                        DateFormatter newDate = new DateFormatter();

                        // premium is always 25 so check on top
                        if (newDate.isPremium(){ //include user's cinema of type cinema
                            seatprice = PricingManager.readAllPricing().get(0).getPremium() + seatprice;
                        }
                        // blockbuster always adds 1 so check on top
                        if (newDate.isBlockbuster(){ //include user's movie of type movie
                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getBlockbuster();
                        }
                        if (newDate.isHoliday()){ //include user's timing selected, pulled from showtimes available
                            if (newDate.is3D()){ //include user's movie of type movie
                                seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D() + seatprice;
                            }
                            else{
                                seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D() + seatprice;
                            }
                        } else {
                            // weekend means its either 2d or 3d so account first
                            if (newDate.isWeekend(){ //include user's date and time selected, pulled from showtimes available
                                if (newDate.is3D()){ //include user's movie of type movie
                                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D() + seatprice;
                                }
                                else{
                                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D() + seatprice;
                                }
                            }
                        }

                        System.out.println("How many seat do you want");
                        int f = scan.nextInt();
                        SeatingPlan layout = new SeatingPlan(5, 5);
                        ArrayList<String> SeatsArray = new ArrayList<>();
                        // asking for seats and saving it to an array
                        for (int i = 0; i < f; i++) {
                            layout.displaySeatPlan();
                            System.out.println("input your desired row and column");
                            System.out.println("row (input number): ");
                            int d = scan.nextInt();
                            System.out.println("column (input letter): ");
                            String e = scan.next();
                            layout.assignSeat((d - 1), (e));
                            String seatyea = e + String.valueOf(d);
                            String seatId = new Seat(seatyea).getSeatId();
                            System.out.println("This is your chosen seat: " + seatId);
                            layout.displaySeatPlan();
                            SeatsArray.add(seatId);
                        }
                        if (seatprice == 0f || seatprice == 1f){ // situation where your movie selection is not premium, holiday or weekend
                            seatprice = seatprice*f;
                            for (int i = 0; i < f; i++) {
                                System.out.println("What type of ticket are you looking for");
                                System.out.println("1. Student");
                                System.out.println("2. Adult");
                                if (!newDate.is3D()) { //include user's movie of type movie
                                    System.out.println("3. Adult");
                                }
                                int selection = scan.nextInt();
                                if (selection == 1){
                                    if (newDate.is3D()) { //include user's date and time selected, pulled from showtimes available
                                        seatprice = seatprice + PricingManager.readAllPricing().get(0).getStudentStandard3D();
                                    } else{
                                        seatprice = seatprice + PricingManager.readAllPricing().get(0).getStudentStandard2D()
                                    }
                                } else if (selection == 2) {
                                    if (newDate.isMonWed()){//include user's date and time selected, pulled from showtimes available
                                        if (newDate.is3D()){//include user's date and time selected, pulled from showtimes available
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D();
                                        } else {
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D();
                                        }
                                    } else if (newDate.isThur()) {//include user's date and time selected, pulled from showtimes available
                                        if (newDate.is3D()){//include user's date and time selected, pulled from showtimes available
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultThursStandard3D();
                                        } else {
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultThursStandard2D();
                                        }
                                    } else if (newDate.isFri()) {//include user's date and time selected, pulled from showtimes available
                                        if (newDate.is3D()){//include user's date and time selected, pulled from showtimes available
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultFriStandard3D();
                                        } else {
                                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultFriStandard2D();
                                        }
                                    }
                                } else if (selection == 3) {
                                        seatprice = seatprice + PricingManager.readAllPricing().get(0).getSeniorStandard2D();
                                }
                            }

                        }
                        else{
                            seatprice = seatprice*f;
                        }


                        //generating tickets from the array
                        for (int n = 0; n < SeatsArray.size(); n++) {
                            System.out.println("\nTicket" + ":");
                            tickets tics = new tickets(movieChosen, "JE1", "hello", "test", SeatsArray.get(n));
                        }

                        System.out.println("Please Sign up or Log in to register your booking.");
                        System.out.println("[1] Sign up");
                        System.out.println("[2] Log in");
                        String newUsername = " ";
                        int op = scan.nextInt();
                        scan.nextLine();
                        if (op == 1) {
                            String name;
                            int phoneNumber;
                            String email;
                            String username;
                            String password;
                            int userId;
                            scan.nextLine();
                            System.out.println("Please enter your name: ");
                            name = scan.nextLine();
                            System.out.println("Please enter your phone number: ");
                            phoneNumber = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Please enter your email: ");
                            email = scan.nextLine();
                            System.out.println("Please enter your username: ");
                            username = scan.nextLine();
                            for(int x = 0; x<UsersManager.readAllUsers().size();x++){
                                if(UsersManager.readAllUsers().get(x).getUsername().equals(username)){
                                    System.out.println("Sorry, username has been taken. \nPlease key in new username: ");
                                    username = scan.nextLine();
                                    break;
                                }
                            }
                            System.out.println("Please enter your password: ");
                            password = scan.nextLine();
                            UsersManager.createUser(username, password, name, phoneNumber, email);
                            newUsername = username;
                        } else if (op == 2) {
                            String usernameInput;
                            String passwordInput;
                            while (true) {
                                System.out.println(UsersManager.readAllUsers().get(0).getUsername());
                                System.out.println(UsersManager.readAllUsers().get(0).getPassword());
                                System.out.println("Please enter your username: ");
                                usernameInput = scan.nextLine();
                                if (UserLogin.verifyUsername(usernameInput)) {
                                    System.out.println("Please enter your password: ");
                                    passwordInput = scan.nextLine();
                                    while (!UserLogin.verifyPassword(usernameInput, passwordInput)) {
                                        System.out.println("Invalid password, please try again. ");
                                        passwordInput = scan.nextLine();
                                    }
                                    System.out.println("Welcome back " + usernameInput);
                                    break;

                                } else {
                                    System.out.println("Username not found, please try again. ");
                                }
                            }
                            newUsername = usernameInput;
                        }
                        // Generating transaction ID
                        String txnID = new Transaction("XXX").getTransactionId();
                        // Making a booking
                        int count = 0;
                        Booking booked = new Booking("poohy", "poohyemail", 12345678, SeatsArray.size(), txnID, "hello", "bye");
                        Booking booked1 = new Booking("htut", "poohyemail", 12345678, SeatsArray.size(), txnID, "hello", "bye");
                        ArrayList<UserAccount> usersList = UsersManager.readAllUsers();
                        for (count = 0; count < usersList.size(); count++) {
                            if (usersList.get(count).getUsername().equals(newUsername)) {
                                UsersManager.editBookingHistory(count, booked1);
                                break;
                            }

                        }

                        UsersManager.readAllUsers().get(count).showBookingHistory();
                    }


                    if (option == 2) { //Search/List movies
//                        boolean exit = true;
                        int searchOrList = 0;
                        while (searchOrList != 3) {
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
                        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
                        for (int i = 0; i < allMovies.size(); i++) {
                            System.out.println("(" + (i + 1) + ")" + allMovies.get(i).getName());
                        }
                        int movieSelection = scan.nextInt();

                        if (movieSelection > allMovies.size() || movieSelection < 1) {
                            System.out.println("Invalid input, select again");
                            movieSelection = scan.nextInt();
                        }
                        System.out.println("You've chosen: " + allMovies.get(movieSelection-1).getName());
                        System.out.println("Here are the associated movie details!\n");
                        System.out.println("Movie: " + allMovies.get(movieSelection-1).getName());
                        System.out.println("Type: " + allMovies.get(movieSelection-1).getType());
                        System.out.println("Director: " + allMovies.get(movieSelection-1).getDirector());
                        System.out.println("Rating: " + allMovies.get(movieSelection-1).getRating()[1]);
                        System.out.println("Status: " + allMovies.get(movieSelection-1).getShowingStatus());
                        System.out.println("Duration: " + allMovies.get(movieSelection-1).getShowLength());
                        System.out.println("Synopsis: " + allMovies.get(movieSelection-1).getSynopsis());
                    }

                    if (option == 4) { //Check Seat availability

                    }

                    if (option == 5){ //List top 5 movies
                        boolean power = true;
                        while (power) {
                            System.out.println("Would you like to list the top 5 movies according to:");
                            System.out.println("(1) Ratings");
                            System.out.println("(2) Ticket Sales");
                            System.out.println("(3) Exit");
                            int listingMovies = scan.nextInt();

                            if (listingMovies == 1) {
                                ListTop5MoviesUI.sortByRatings();
                            } else if (listingMovies == 2) {
                                ListTop5MoviesUI.sortBySales();
                            } else if (listingMovies == 3) {
                                power = false;
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

                    if (option == 7) { // Rate Movies
                        System.out.println("Which movie would you like to rate?");
                        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
                        for (int i = 0; i < allMovies.size(); i++){
                            System.out.println("(" + i+1 + ")" + allMovies.get(i).getName());
                        }
                        int movieToRate = scan.nextInt();
                        System.out.println("What is your new rating?");
                        int newRating = scan.nextInt();
                        MoviesManager.updateRating(movieToRate,newRating);
                    }
                }
            }
        }
    }
}
