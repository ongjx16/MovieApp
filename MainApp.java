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

                while (choose!=3){


                System.out.println("1. Edit Movie Details\n");
                System.out.println("2. Edit Showtime Details\n");
                System.out.println("3. Quit \n");
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
//                Movie[] MoviesArray;
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
                }
                return;
            }




            else if (identity == 2) {
                System.out.println("You are now a user");
                System.out.println("What would you like to do now ");
                System.out.println("(1) Book a movie");
                System.out.println("(2) Log In");
                System.out.println("(3) Sign Up");
                System.out.println("(4) See Movie Details");
                int option = scan.nextInt();

                if (option == 1) {
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
                        System.out.println("This is your chosen seat");
                        layout.displaySeatPlan();
                        int seatId = new Seat(e * 100 + d).getSeatId();
                        SeatsArray.add(String.valueOf(seatId));
                    }
                    // Generating transaction ID
                    String txnID = new Transaction("XXX").getTransactionId();
                    // Making a booking
                    Booking booked = new Booking("poohy", "poohyemail", 12345678, c * SeatsArray.size(), txnID, String.valueOf(g), String.valueOf(h));

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

                   

                    //generating tickets from the array
                    for (int n = 0; n < SeatsArray.size(); n++) {
                        System.out.println("\nTicket" + ":");
                        tickets tics = new tickets(movieChosen, "JE1", String.valueOf(g), String.valueOf(h), SeatsArray.get(n));
                    }
                    //sign up or login for user
                    System.out.println("Please Sign up or Log in to register your booking.");
                    System.out.println("[1] Sign up");
                    System.out.println("[2] Log in");
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
                        System.out.println("Please enter your password: ");
                        password = scan.nextLine();
                        UsersManager.createUser(username, password, name, phoneNumber, email);
                    }

                    if (op == 2) {
                        String usernameInput; 
                        String passwordInput;
                        while (true) {
                            System.out.println("Please enter your username: ");
                            usernameInput = scan.nextLine();
                            if (UserLogin.verifyUsername(usernameInput)) {
                                System.out.println("Please enter your password: ");
                                passwordInput = scan.nextLine();
                                while(!UserLogin.verifyPassword(usernameInput, passwordInput)) {
                                    System.out.println("Invalid password, please try again. ");
                                    passwordInput = scan.nextLine();
                                }
                                System.out.println("Welcome back " + usernameInput);
                                    break;

                            } else {
                                System.out.println("Username not found, please try again. ");
                            }
                        }
                    }

                if (option == 2) {
                    String usernameInput; 
                        String passwordInput;
                        while (true) {
                            System.out.println("Please enter your username: ");
                            usernameInput = scan.nextLine();
                            if (UserLogin.verifyUsername(usernameInput)) {
                                System.out.println("Please enter your password: ");
                                passwordInput = scan.nextLine();
                                while(!UserLogin.verifyPassword(usernameInput, passwordInput)) {
                                    System.out.println("Invalid password, please try again. ");
                                    passwordInput = scan.nextLine();
                                }
                                System.out.println("Welcome back " + usernameInput);
                                    break;

                            } else {
                                System.out.println("Username not found, please try again. ");
                            }
                        }
                }

                if (option == 3) {
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
                    System.out.println("Please enter your password: ");
                    password = scan.nextLine();
                    UsersManager.createUser(username, password, name, phoneNumber, email);

                }

                if (option == 4) {
                    System.out.println("Please select the movie you'd like to find out more about: ");
                    Cineplex readingMovies = new Cineplex("Tampines");
                    for (int i = 0; i < readingMovies.getMovies().length; i++) {
                        System.out.println("[" + (i + 1) + "]" + readingMovies.getMovies()[i]);
                    }
                    int movieInput = scan.nextInt();
                    if (movieInput > readingMovies.getMovies().length || movieInput < 1) {
                        System.out.println("Invalid input, select again");
                        movieInput = scan.nextInt();
                    }
                    System.out.println("You've chosen: " + readingMovies.getMovies()[movieInput - 1]);
                    System.out.println("Here are the associated movie details!\n");
                    System.out.println("Name: " + readingMovies.getMovieDetails(movieInput).getName());
                    System.out.println("Type: " + readingMovies.getMovieDetails(movieInput).getType());
                    System.out.println("Director: " + readingMovies.getMovieDetails(movieInput).getDirector());
                    System.out.println("Rating: " + readingMovies.getMovieDetails(movieInput).getRating());
                    System.out.println("Show Status: " + readingMovies.getMovieDetails(movieInput).getShowingStatus());
                    System.out.println("Show Length: " + readingMovies.getMovieDetails(movieInput).getShowLength());
                    System.out.println("Synopsis: " + readingMovies.getMovieDetails(movieInput).getSynopsis());
                }
            }
        }

    }
}
}
