package Boundary;

import Control.*;
import Entity.*;
import Utils.DateFormatter;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Boundary class that movie-goer interacts with when movie-goer chooses to make booking
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class UserBookingUI{
    /**
     * Functions available movie-goer to complete booking
     * Main flow of booking process
     * Movie-goer cineplex, movie and showtime using chooseShowtimeByCineplex
     * Movie-goer then chooses seating plan using choosingSeats
     * Tickets are printed, and login/signup prompted (using userLogin) to register booking
     * Booking registered, seats updated, booking history updated
     */
    private static boolean dealbreaker = false;

    public static void UserBookingFunction(){
        ExceptionHandler check = new ExceptionHandler();

        dealbreaker = false;
        Scanner scan = new Scanner(System.in);
        Showtimes showtimeToBook = null;

        showtimeToBook = chooseShowtimeByCineplex();

        if (dealbreaker){
            return;
        }

        float seatprice = 0f;

        DateFormatter newDate = new DateFormatter();

        //update seat price based on date, type of cinema and movie type
        seatprice = getPreliminaryPrice(newDate, showtimeToBook, seatprice);


        System.out.println("How many seats do you want? Input 0 to exit");
        int noOfSeats = 0;
        noOfSeats = check.checkNumberInput(noOfSeats, 100);

        if (noOfSeats == 0){
            dealbreaker = true;
            return;
        }

        //let user choose seats
        ArrayList<String> SeatsArray = choosingSeats(noOfSeats,showtimeToBook);

        if (dealbreaker){
            return;
        }

        //update ticket price with no of seats booked
        float updatedTicketPrice = getTotalPriceByNoOfSeats(seatprice, noOfSeats, showtimeToBook, newDate);

        if (dealbreaker){
            return;
        }

        System.out.println("Total price is: " + updatedTicketPrice);



        //generating tickets from the array
        System.out.println("These are your tickets: ");
        for (int n = 0; n < SeatsArray.size(); n++) {
            System.out.println("---------------------");
            Tickets tics = new Tickets(showtimeToBook.getMoviename(), showtimeToBook.getCinemaID(),CinemaManager.getCinemabyID(showtimeToBook.getCinemaID().toUpperCase()).getType(), showtimeToBook.getShowtime().substring(0,10), showtimeToBook.getShowtime().substring(11), SeatsArray.get(n));
            System.out.println("---------------------");
        }

        //get user details
        String newUsername = userLogin();

        if (dealbreaker){
            return;
        }

        // Generating transaction ID
        String txnID = new Transaction(showtimeToBook.getCinemaID()).getTransactionId();
        // Making a booking
        ArrayList<UserAccount> usersList = UsersManager.readAllUsers();
        int count = 0;
        for (count = 0; count < usersList.size(); count++) {
            if (usersList.get(count).getUsername().equals(newUsername)) {
                break;
            }
        }

        for(int i=0; i<SeatsArray.size(); i++){
            String row = "";
            String col = "";
            row=SeatsArray.get(i).substring(1);
            col = SeatsArray.get(i).substring(0,1);
            ShowtimesManager.updateSeats(showtimeToBook.getShowtimeID(),((row.charAt(0)-48)*10+(row.charAt(1)-48)), (col));
        }

        Booking booked1 = new Booking(usersList.get(count).getName(), usersList.get(count).getEmail(),usersList.get(count).getPhoneNumber(),updatedTicketPrice,txnID,showtimeToBook.getMoviename(),showtimeToBook.getShowtime().substring(0,10),showtimeToBook.getShowtime().substring(11),noOfSeats);
        UsersManager.editBookingHistory(count, booked1);
        MoviesManager.increaseSales(showtimeToBook.getMovieID(),noOfSeats);
        System.out.println("Booking successful!\n");
    }

    //return showtime object chosen

    /**
     * Allows movie-goer to choose cineplex, movie and showtime
     * Displays options to movie-goer by reading from AllCineplexes.dat, Showtimes.dat and AllMovies.dat
     * @return The showtime chosen by the movie-goer
     */
    public static Showtimes chooseShowtimeByCineplex(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your cineplex: ");
        int cineplexChoice = 0;
        String intermediate;
        ArrayList<Cineplex> readCineplexes = new ArrayList<Cineplex>(CineplexManager.readAllCineplexes());
        for (int i = 0; i < readCineplexes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + readCineplexes.get(i).getCineplexName() + "\n");
        }
        System.out.println("[0] Exit");

        ExceptionHandler check = new ExceptionHandler();
        cineplexChoice = check.checkNumberInput(cineplexChoice, readCineplexes.size()+1);

        if (cineplexChoice == 0){
            dealbreaker = true;
            return null;
        }

        System.out.println("Your choice is: " + readCineplexes.get(cineplexChoice - 1).getCineplexName());

        System.out.println("Choose your movie! ");
        ArrayList<Integer> movieIDs = new ArrayList<Integer>(ShowtimesManager.moviesByCineplex(readCineplexes.get(cineplexChoice - 1).getCineplexID()));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (int j = 0; j < movieIDs.size(); j++) {
            movies.add(MoviesManager.getMoviebyID(movieIDs.get(j)));
        }
        ArrayList<Movie> filteredMovies = new ArrayList<Movie>();
        filteredMovies = MoviesManager.filterByStatus(movies);
        for (int i = 0; i < filteredMovies.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + filteredMovies.get(i).getName() + " - " + filteredMovies.get(i).getType().toString());
        }
        System.out.println("[0] Exit");

        int movieChoice = 0;

        movieChoice = check.checkNumberInput(movieChoice, filteredMovies.size()+1);

        if (movieChoice == 0){
            dealbreaker = true;
            return null;
        }

        System.out.println("Your choice is: " + filteredMovies.get(movieChoice - 1).getName());

        String movieChosen = filteredMovies.get(movieChoice - 1).getName();
        int chosenMovieID = filteredMovies.get(movieChoice-1).getMovieID();

        ArrayList<Showtimes> showtimesAvailable = new ArrayList<Showtimes>(ShowtimesManager.showtimesByMovieAndCineplex(cineplexChoice, chosenMovieID));
        ArrayList<String> datesToSelect = new ArrayList<String>(ShowtimesManager.showtimeDates(showtimesAvailable));

        System.out.println("What dates would you like to see this movie?  ");
        DateFormatter newDate = new DateFormatter();
        for (int z = 0; z < datesToSelect.size(); z++) {
            System.out.println("[" + (z + 1) + "] " + datesToSelect.get(z) + " - "  + newDate.DayConverter(datesToSelect.get(z)) + "\n");
        }
        System.out.println("[0] Exit");
        int dateChoice = 0;
        dateChoice = check.checkNumberInput(dateChoice, datesToSelect.size()+1);

        if (dateChoice == 0){
            dealbreaker = true;
            return null;
        }

        System.out.println("What timings would you like to see this movie: ");
        for (int y = 0; y < showtimesAvailable.size(); y++) {
            if (showtimesAvailable.get(y).getShowtime().substring(0, 10).equals(datesToSelect.get(dateChoice - 1))) {
                System.out.println("[" + (y + 1) + "] " + showtimesAvailable.get(y).getShowtime().substring(11) + " || " + CinemaManager.getCinemabyID(showtimesAvailable.get(y).getCinemaID()).getType().toString());
            }
        }
        System.out.println("[0] Exit");
        int showtimeChoice = 0;
        showtimeChoice = check.checkNumberInput(showtimeChoice,  showtimesAvailable.size()+1);


        if (showtimeChoice == 0){
            dealbreaker = true;
            return null;
        }

        Showtimes showtimeOutput = showtimesAvailable.get(showtimeChoice - 1);
        return showtimeOutput;

    }

    /**
     *used to prompt user to log in or sign up so booking history can be stored in the user account
     * @return username string
     */
    public static String userLogin (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Sign up or Log in to register your booking.");
        System.out.println("[1] Sign up");
        System.out.println("[2] Log in");
        System.out.println("[0] Exit, please note that this is the last point of exit. " +
                "Continuing with Log In/Sign Up will confirm your booking!");
        String newUsername = " ";

        int op = 0;
        ExceptionHandler check = new ExceptionHandler();
        op = check.checkNumberInput(op,  2);

        if (op == 0){
            dealbreaker = true;
            return null;
        }
        if (op == 1) {
            String name;
            int phoneNumber;
            String email;
            String username;
            String password;
            int userId;
            System.out.println("Please enter your name: ");
            name = scan.nextLine();
            System.out.println("Please enter your phone number: ");
            phoneNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter your email: ");
            email = scan.nextLine();
            System.out.println("Please enter your username: ");
            username = scan.nextLine();
            for(int x = 0; x< UsersManager.readAllUsers().size(); x++){
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
                System.out.println("Please enter your username: ");
                usernameInput = scan.nextLine();
                UserLogin UserLogin = new UserLogin();
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
        return newUsername;
    }

    /**
     * Generates price based on type of cinema, type of movie and holiday dates
     * Determines the need to ask the movie-goer for type of ticket or not
     * @param newDate Date of the movie
     * @param showtimeToBook Showtime chosen
     * @param seatprice Base price of the seat
     * @return Final price of the seat
     */
    public static float getPreliminaryPrice (DateFormatter newDate, Showtimes showtimeToBook, float seatprice){
        // premium is always 25 so check on top
        if (newDate.isBlockbuster(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){ //include user's movie of type movie
            seatprice = seatprice + PricingManager.readAllPricing().get(0).getBlockbuster();
        }

        if (newDate.isPremium(CinemaManager.getCinemabyID(showtimeToBook.getCinemaID()))){ //include user's cinema of type cinema
            seatprice = PricingManager.readAllPricing().get(0).getPremium() + seatprice;
        }
        else if (newDate.isHoliday(showtimeToBook.getShowtime().substring(0,10))){ //include user's timing selected, pulled from showtimes available
            if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){ //include user's movie of type movie
                seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D() + seatprice;
            }
            else{
                seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D() + seatprice;
            }
        }
        else {
            if (newDate.isFri6pm(newDate.DayConverter(showtimeToBook.getShowtime()), newDate.HourConverter(showtimeToBook.getShowtime()))){
                if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){ //include user's movie of type movie
                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D() + seatprice;
                }
                else{
                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D() + seatprice;
                }
            }
            // weekend means its either 2d or 3d so account first
            if (newDate.isWeekend(newDate.DayConverter(showtimeToBook.getShowtime()))){ //include user's date and time selected, pulled from showtimes available
                if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){ //include user's movie of type movie
                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard3D() + seatprice;
                }
                else{
                    seatprice = PricingManager.readAllPricing().get(0).getAdultWeekendStandard2D() + seatprice;
                }
            }
        }
        return seatprice;
    }

    /**
     * Generates total price of the booking based on no. of seats and type of ticket
     * @param seatprice Seat price after going through getPreliminaryPrice
     * @param noOfSeats Number of seats chosen
     * @param showtimeToBook Showtime chosen
     * @param newDate Date of movie
     * @return Total price of booking
     */

    public static float getTotalPriceByNoOfSeats(float seatprice, int noOfSeats, Showtimes showtimeToBook, DateFormatter newDate){
        Scanner scan = new Scanner(System.in);
        if (seatprice == 0f || seatprice == 1f){ // situation where your movie selection is not premium, holiday or weekend
            seatprice = seatprice*noOfSeats;
            for (int i = 0; i < noOfSeats; i++) {
                System.out.println("What type of ticket are you looking for (ticket " + (i+1) + "):");
                System.out.println("1. Student");
                System.out.println("2. Adult");
                if (!newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))) { //include user's movie of type movie
                    System.out.println("3. Senior Citizen");
                }
                System.out.println("0. Exit");
                int selection = 0;

                ExceptionHandler check = new ExceptionHandler();
                selection = check.checkNumberInput(selection, 3);

                if (selection == 0){
                    dealbreaker = true;
                    return -100;
                }

                if (selection == 1){
                    if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))) { //include user's date and time selected, pulled from showtimes available
                        seatprice = seatprice + PricingManager.readAllPricing().get(0).getStudentStandard3D();
                    } else{
                        seatprice = seatprice + PricingManager.readAllPricing().get(0).getStudentStandard2D();
                    }
                } else if (selection == 2) {
                    if (newDate.isMonWed(newDate.DayConverter(showtimeToBook.getShowtime()))){//include user's date and time selected, pulled from showtimes available
                        if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){//include user's date and time selected, pulled from showtimes available
                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultMonWedStandard3D();
                        } else {
                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultMonWedStandard2D();
                        }
                    } else if (newDate.isThur(newDate.DayConverter(showtimeToBook.getShowtime()))) {//include user's date and time selected, pulled from showtimes available
                        if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){//include user's date and time selected, pulled from showtimes available
                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultThursStandard3D();
                        } else {
                            seatprice = seatprice + PricingManager.readAllPricing().get(0).getAdultThursStandard2D();
                        }
                    } else if (newDate.isFri(newDate.DayConverter(showtimeToBook.getShowtime()), newDate.HourConverter(showtimeToBook.getShowtime()))) {//include user's date and time selected, pulled from showtimes available
                        if (newDate.is3D(MoviesManager.getMoviebyID(showtimeToBook.getMovieID()))){//include user's date and time selected, pulled from showtimes available
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
            seatprice = seatprice*noOfSeats;
        }
        return seatprice;
    }

    public static ArrayList<String> choosingSeats (int noOfSeats, Showtimes showtimeToBook){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> SeatsArray = new ArrayList<String>();
        SeatingPlan layout;
        String row="";
        String col="";
        layout = showtimeToBook.getSeats();
        // asking for seats and saving it to an array
        for (int i = 0; i < noOfSeats; i++) {
            layout.displaySeatPlan();
            System.out.println("input your desired row and column, input 0 to exit");
            System.out.println("row (input number): ");
            row = scan.nextLine();

            if (Objects.equals(row, "0")){
                dealbreaker = true;
                return null;
            }

            if(row.length()==1){
                String init="0";
                row = init.concat(row);
            }
            while(((row.charAt(0)-48)*10+(row.charAt(1)-48))<1 || ((row.charAt(0)-48)*10+(row.charAt(1)-48))>16){
                System.out.println("Invalid row number, please input again: ");
                row = scan.nextLine();
                if(row.length()==1){
                    String init="0";
                    row = init.concat(row);
                }
            }
            System.out.println("column (input letter): ");
            col = scan.nextLine().toUpperCase();
            while(col.charAt(0)>80 || col.charAt(0)<65){
                System.out.println("Invalid column letter, please input again: ");
                col=scan.nextLine().toUpperCase();
            }

            while(layout.checkSeatIfOccupied(((row.charAt(0)-48)*10+(row.charAt(1)-48)),(col))==true){
                System.out.println("Sorry seat taken, please choose again: ");
                System.out.println("row (input number): ");
                row = scan.nextLine();
                if(row.length()==1){
                    String init="0";
                    row = init.concat(row);
                }
                while(((row.charAt(0)-48)*10+(row.charAt(1)-48))<1 || ((row.charAt(0)-48)*10+(row.charAt(1)-48))>16){
                    System.out.println("Invalid row number, please input again: ");
                    row = scan.nextLine();
                    if(row.length()==1){
                        String init="0";
                        row = init.concat(row);
                    }
                }
                System.out.println("column (input letter): ");
                col = scan.nextLine().toUpperCase();
                while(col.charAt(0)>80 || col.charAt(0)<65){
                    System.out.println("Invalid column letter, please input again: ");
                    col=scan.nextLine().toUpperCase();
                }
            }
            String seatyea = col + row;
            String seatId = new Seat(seatyea).getSeatId();

            layout.assignSeat(((row.charAt(0)-48)*10+(row.charAt(1)-48)), (col));
            System.out.println("This is your chosen seat: " + seatId);

            SeatsArray.add(seatyea);

        }
        layout.displaySeatPlan();
        return SeatsArray;
    }

}
