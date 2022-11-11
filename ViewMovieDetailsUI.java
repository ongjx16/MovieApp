import java.util.ArrayList;
import java.util.Scanner;

public class ViewMovieDetailsUI {
    public static void viewMovieDetails(){
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        while (selection != 2) {
            System.out.println("\n(1) Select movie to view details");
            System.out.println("(2) Exit");
            selection = scan.nextInt();

            if (selection == 1) {
                System.out.println("Please select the movie you'd like to find out more about: ");
                ArrayList<Movie> moviesList = new ArrayList<Movie>(MoviesManager.readAllMovies());
                ArrayList<Movie> filteredMovies = new ArrayList<>();

                // filtering movies to only show movies that have status "Preview" or "Now Showing"
                for (int i = 0; i < moviesList.size(); i++) {
                    filteredMovies = MoviesManager.filterByStatus();
                }

                // printing everything in array list
                for (int i = 0; i < filteredMovies.size(); i++) {
                    System.out.println("(" + (i + 1) + ")" + filteredMovies.get(i).getName());
                }
                int movieSelection = scan.nextInt();
                if (movieSelection > filteredMovies.size() || movieSelection < 1) {
                    System.out.println("Invalid input, select again");
                    movieSelection = scan.nextInt();
                }
                System.out.println("You've chosen: " + filteredMovies.get(movieSelection - 1));
                System.out.println("Here are the associated movie details!\n");
                System.out.println("Name: " + filteredMovies.get(movieSelection - 1).getName());
                System.out.println("Type: " + filteredMovies.get(movieSelection - 1).getType());
                System.out.println("Director: " + filteredMovies.get(movieSelection - 1).getDirector());
                System.out.println("Rating: " + filteredMovies.get(movieSelection - 1).getRating()[1]);
                System.out.println("Show Status: " + filteredMovies.get(movieSelection - 1).getShowingStatus());
                System.out.println("Show Length: " + filteredMovies.get(movieSelection - 1).getShowLength());
                System.out.println("Synopsis: " + filteredMovies.get(movieSelection - 1).getSynopsis());
            }
        }
    }
}
