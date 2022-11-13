package Boundary;

import Control.*;
import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boundary class that movie-goer interacts with when user enters program as a movie-goer
 * @author shubham
 * @version 1.0
 * @since 2022-11-13
 */

public class UserUI {
    /**
     * Functions made for the movie-goer
     */
    public static void UserFunctions(){

        Scanner scan = new Scanner(System.in);
        ExceptionHandler check = new ExceptionHandler();


int option = 0;
        System.out.println("You are now a user");

        while (option != 7) {

            System.out.println("\nWhat would you like to do now ");
            System.out.println("(1) Book a movie");
            System.out.println("(2) Search/List movie");
            System.out.println("(3) Check seat availability"); // needs to be updated
            System.out.println("(4) List top 5 movies");
            System.out.println("(5) View Booking History"); // need to log in
            System.out.println("(6) Rate/Review movies");
            System.out.println("(7) Exit");
            option = check.checkNumberInput(option, 7);
            if (option == 1) { // Book a movie
                UserBookingUI.UserBookingFunction();
            }


            else if (option == 2) { //Search/List movies
                int searchOrList = 0;
                while (searchOrList != 3) {
                    System.out.println("What would you like to do?");
                    System.out.println("(1) Search movie by title");
                    System.out.println("(2) List all movies");
                    System.out.println("(3) Exit");
                    searchOrList = check.checkNumberInput(searchOrList, 3);



                    if (searchOrList == 1) {
                        searchMovie();
                    } else if (searchOrList == 2) {
                        selectMovie();
                    }
                }

            }

//            if (option == 3) { //View movie details
//                UserViewMovieDetailsUI.viewMovieDetails();
//            }

            else if (option == 3) { //Check Seat availability
                Showtimes showtimeChosen = UserBookingUI.chooseShowtimeByCineplex();
                showtimeChosen.getSeats().displaySeatPlan();

            }

            else if (option == 4){ //List top 5 movies
                listTop5();
            }

            //View Booking History
            else if (option == 5) {
                UserLogin UserLogin = new UserLogin();
                String usernameInput, passwordInput;
                while(true) {
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
                // add code for viewing booking history
                int i, j;
                for(i=0; i<UsersManager.readAllUsers().size(); i++){
                    if(UsersManager.readAllUsers().get(i).getUsername().equals(usernameInput)){
                        break;
                    }
                }

                ArrayList<String> historyDates = new ArrayList<String>();
                for(int k=0; k<UsersManager.readAllUsers().get(i).getBookingHistory().size();k++){
                    if(!historyDates.contains(UsersManager.readAllUsers().get(i).getBookingHistory().get(k).getMovieDate())){
                        historyDates.add(UsersManager.readAllUsers().get(i).getBookingHistory().get(k).getMovieDate());
                    }
                }
                System.out.println("Choose date to view booking history: ");
                for(int l=0; l<historyDates.size();l++){
                    System.out.println("["+(l+1)+"]"+historyDates.get(l));
                }
                int histDateChoice=0;
                histDateChoice = check.checkNumberInput(histDateChoice, historyDates.size()+1);

                System.out.println("Choose movie time to view booking history: ");
                for(int m=0; m<UsersManager.readAllUsers().get(i).getBookingHistory().size();m++){
                    if(UsersManager.readAllUsers().get(i).getBookingHistory().get(m).getMovieDate().equals(historyDates.get(histDateChoice-1))){
                        System.out.println("["+(m+1)+"]"+UsersManager.readAllUsers().get(i).getBookingHistory().get(m).getMovieTime());
                    }
                }

                int histTimeChoice=0;
                histTimeChoice = check.checkNumberInput(histTimeChoice, UsersManager.readAllUsers().get(i).getBookingHistory().size()+1);

                int n;
                for(n=0; n<UsersManager.readAllUsers().get(i).getBookingHistory().size();n++){
                    if(UsersManager.readAllUsers().get(i).getBookingHistory().get(n).getMovieTime().equals(histTimeChoice)&&UsersManager.readAllUsers().get(i).getBookingHistory().get(n).getMovieDate().equals(histDateChoice)){
                        break;
                    }
                }
                UserViewBookingDetailsUI viewBookingDetail = new UserViewBookingDetailsUI();
                viewBookingDetail.setToBook(UsersManager.readAllUsers().get(i).getBookingHistory().get(n-1));
                viewBookingDetail.display();


            }

            else if (option == 6) { // Rate/Review Movies
                int rateOrReview = 0;
                while (rateOrReview != 3){
                    System.out.println("Would you like to rate or review movies?");
                    System.out.println("(1) Rate Movie");
                    System.out.println("(2) Review Movie");
                    System.out.println("(3) Exit");
                    rateOrReview = check.checkNumberInput(rateOrReview, 3);


                    if (rateOrReview == 1){
                        UserRateReviewMoviesUI.rateMovies();
                    }else if (rateOrReview == 2){
                        UserRateReviewMoviesUI.reviewMovies();
                    }
                }

            }
        }
    }

    /**
     * Lists top 5 movies based on ratings or ticket sales
     * Method of listing can be chosen by movie-goer
     * Method of listing might be limited to movie-goer by admin
     */
    public static void listTop5(){
        ListTop5MoviesUI listTop5 = new ListTop5MoviesUI();
        Scanner scan = new Scanner(System.in);
        int listingMovies = 0;
        loopy: while(true) {
            try {
                System.out.println("\nWould you like to list the top 5 movies according to:");
                if (FilterPermissions.isAccessRatingsFilter() && FilterPermissions.isAccessSalesFilter()) {
                    System.out.println("(1) Ratings");
                    System.out.println("(2) Ticket Sales");
                    System.out.println("(3) Exit");
                    ExceptionHandler check = new ExceptionHandler();
                    listingMovies = check.checkNumberInput(listingMovies, 3);

                    if (listingMovies == 1) {
                        listTop5.sortByRatings();
                    } else if (listingMovies == 2) listTop5.sortBySales();
                    else if (listingMovies == 3) {
                        break loopy;
                    } else {
                        throw new Exception("Invalid input, please try again");
                    }

                } else if (!FilterPermissions.isAccessRatingsFilter() && FilterPermissions.isAccessSalesFilter()) {
                    System.out.println("(1) Ticket Sales");
                    System.out.println("(2) Exit");
                    ExceptionHandler check = new ExceptionHandler();
                    listingMovies = check.checkNumberInput(listingMovies, 2);

                    if (listingMovies == 1) {
                        listTop5.sortBySales();

                    } else if (listingMovies == 2) {
                        break loopy;
                    } else {
                        throw new Exception("Invalid input, please try again");
                    }
                } else if (FilterPermissions.isAccessRatingsFilter() && !FilterPermissions.isAccessSalesFilter()) {
                    System.out.println("(1) Ratings");
                    System.out.println("(2) Exit");
                    ExceptionHandler check = new ExceptionHandler();
                    listingMovies = check.checkNumberInput(listingMovies, 2);

                    if (listingMovies == 1) {
                        listTop5.sortByRatings();
                    } else if (listingMovies == 2) {
                        break loopy;
                    } else {
                        throw new Exception("Invalid input, please try again");
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * Movie goer can search for movie by typing in movie name
     * Error thrown when movie name is invalid, re prompt for input
     */

    public static void searchMovie(){
        UserViewMovieDetailsUI viewMovieDetails = new UserViewMovieDetailsUI();
        loop: while(true) {
            try {
                System.out.println("\nEnter the movie title you wish to search: ");
                Scanner in = new Scanner(System.in);
                String movieTitle = in.nextLine();
                int i;
                int index = 0;
                ArrayList<Movie> allMovies = new ArrayList<>(MoviesManager.readAllMovies());
                ArrayList<Movie> filteredMovies = new ArrayList<>();
                for (i = 0; i < allMovies.size(); i++) {
                    filteredMovies = MoviesManager.filterByStatus(MoviesManager.readAllMovies());
                }

                for (i = 0; i < filteredMovies.size(); i++) {
                    String movie = filteredMovies.get(i).getName().toUpperCase();
                    if (movie.equals(movieTitle.toUpperCase())) {
                        viewMovieDetails.setMovie(filteredMovies.get(i));
                        viewMovieDetails.display();
                        index++;
                        break loop;
                    }
                }
                if (index == 0) {
                    throw new Exception("Invalid input, please try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void selectMovie(){
        UserViewMovieDetailsUI viewMovieDetails = new UserViewMovieDetailsUI();
        Scanner scan = new Scanner(System.in);

                System.out.println("Please select the movie you'd like to find out more about: ");
                ArrayList<Movie> filteredMovies = new ArrayList<Movie> (MoviesManager.filterByStatus((MoviesManager.readAllMovies())));

                // printing everything in array list
                for (int i = 0; i < filteredMovies.size(); i++) {
                    System.out.println("(" + (i + 1) + ")" + filteredMovies.get(i).getName());
                }
                ExceptionHandler check = new ExceptionHandler();
                int movieSelection = 0;
                movieSelection = check.checkNumberInput(movieSelection, filteredMovies.size()+1);

        viewMovieDetails.setMovie(filteredMovies.get(movieSelection - 1));
        viewMovieDetails.display();


    }
}

