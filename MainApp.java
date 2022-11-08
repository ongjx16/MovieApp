import java.util.Scanner;
import Admin.adminLogin;
import User.UserAccount;
import User.UserLogin;
import Admin.AdminAccount;
import java.io.*;


import java.io.*;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
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
            System.out.println("4. See List of Current Movies\n\n");
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

                MoviesManager.create(name, type, rating, showLength, showingStatus, director, synopsis);
                System.out.println("Movie has been created!");
                return;
            } else if (choice == 2) {


            } else if (choice == 3) {


            } else if (choice == 4) {
                int k = MoviesManager.getNumber();
                Movie[] MoviesArray;
                MoviesArray = MoviesManager.readAllMovies();
                for (int i = 0; i < k; i++) {
                    System.out.println(MoviesArray[i].getType());
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

                    System.out.println("What dates would you like to see this movie: ");
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

                    Pricing newprice = new Pricing("3D", "Digital", "Student",
                            true, "THU", true, true);
                    float c = newprice.obtainPricing("digital", "Typical", "Student", true, true, "THU", true);
                    System.out.println("Your pricing is: " + c);
                    System.out.println("How many seat do you want");
                    int f = scan.nextInt();
                    SeatingPlan layout = new SeatingPlan(5,5);
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
                    System.out.println("Rating: " + readingMovies.getMovieDetails(h).getShowingStatus());
                    System.out.println("Show Length: " + readingMovies.getMovieDetails(h).getShowLength());
                    System.out.println("Synopsis: " + readingMovies.getMovieDetails(h).getSynopsis());
                }
            } 
            else {
                return;
            }
    }
}
