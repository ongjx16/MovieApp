package Boundary;

import java.util.ArrayList;
import Entity.Movie;
import Control.MoviesManager;
import Utils.RatingFilterType;

/**
 * User interface when movie-goer chooses to ListTop5Movies
 * Implements Details Interface
 */

public class ListTop5MoviesUI implements DetailsInterface{
    private ArrayList<Movie> moviesToDisplay;
    private RatingFilterType filterType;

    public ArrayList<Movie> getMoviesToDisplay() {
        return moviesToDisplay;
    }

    /**
     * Changes array list of movies to display
     * @param moviesToDisplay The array list of movies to display
     */
    public void setMoviesToDisplay(ArrayList<Movie> moviesToDisplay) {
        this.moviesToDisplay = moviesToDisplay;
    }

    public RatingFilterType getFilterType() {
        return filterType;
    }

    /**
     * Changes type of filter used for top5 movies
     * @param filterType The type of filter used
     */
    public void setFilterType(RatingFilterType filterType) {
        this.filterType = filterType;
    }

    /**
     * Sorts movies by average rating
     * Displays movies in descending order of average ratings
     */

    public void sortByRatings(){
        int i;
        int size = 0;
        ArrayList<Movie> allMovies = new ArrayList<Movie>(MoviesManager.filterByStatus(MoviesManager.readAllMovies())) ;


        ArrayList<Float> allRatings = new ArrayList<Float>();

        // adding the ratings of all movies into an array
        for (i=0; i<allMovies.size(); i++){
            allRatings.add(allMovies.get(i).getRating()[1]);
        }
        // sorting ratings from highest to lowest
        for (i=0; i<allRatings.size(); i++){
            for (int j=0; j<allRatings.size() - i - 1; j++){
                if (allRatings.get(j) < allRatings.get(j+1)){
                    float temp = allRatings.get(j);
                    allRatings.set(j, allRatings.get(j+1));
                    allRatings.set(j+1, temp);
                }
            }
        }

        // in case AllMovies.dat has less than 5 movies
        if (allRatings.size() < 5){
            size = allRatings.size();
        }else{
            size = 5;
        }
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // iterate through allMovies array to print movies with the top 5 rating
        for (i = 0; i< size; i++){
            for (int y = 0; y< allMovies.size(); y++) {
                if (allRatings.get(i).equals(allMovies.get(y).getRating()[1]) && !isRepeat(allMovies.get(y), filteredMovies)) {
                    filteredMovies.add(allMovies.get(y));
                    break;
                }
            }
        }
        setFilterType(RatingFilterType.RATINGS);
        setMoviesToDisplay(filteredMovies);
        display();

    }

    /**
     * Sorts movies by number of tickets sold
     * Displays movies in descending order of number of tickets sold
     */

    public void sortBySales(){
        int i;
        int size = 0;
        ArrayList<Movie> allMovies = new ArrayList<Movie>(MoviesManager.filterByStatus(MoviesManager.readAllMovies())) ;


        ArrayList<Integer> allSales = new ArrayList<Integer>();

        // adding the ratings of all movies into an array
        for (i=0; i<allMovies.size(); i++){
            allSales.add(allMovies.get(i).getSales());
        }
        // sorting ratings from highest to lowest
        for (i=0; i<allSales.size(); i++){
            for (int j=0; j<allSales.size() - i - 1; j++){
                if (allSales.get(j) < allSales.get(j+1)){
                    int temp = allSales.get(j);
                    allSales.set(j, allSales.get(j+1));
                    allSales.set(j+1, temp);
                }
            }
        }

        // in case AllMovies.dat has less than 5 movies
        if (allSales.size() < 5){
            size = allSales.size();
        }else{
            size = 5;
        }
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        // iterate through allMovies array to print movies with the top 5 rating
        for (i = 0; i< size; i++){
            for (int y = 0; y< allMovies.size(); y++) {
                if (allSales.get(i).equals(allMovies.get(y).getSales()) && !isRepeat(allMovies.get(y), filteredMovies)) {
                    filteredMovies.add(allMovies.get(y));
                    break;
                }
            }
        }

        setFilterType(RatingFilterType.SALES);
        setMoviesToDisplay(filteredMovies);
        display();

        }

    /**
     * Checks if specific movie is already in an array list of movies
     * @param movieToCompare The specific movie to check against
     * @param array The array of movies to check if it contains the specific movie
     * @return True if specific movie exists in the array list of movies
     */
    public boolean isRepeat(Movie movieToCompare, ArrayList<Movie> array){

        for (int i = 0; i< array.size(); i++){
            if (movieToCompare.equals(array.get(i))){
                return true;
            }
        }

        return false;
    }

    /**
     * Displays the top5 movies
     * Implements DetailsUIInterface
     */
    @Override
    public void display() {
        if (filterType.equals(RatingFilterType.RATINGS)){
            System.out.println("\nTop 5 Movies by User Ratings: ");
            for (int x = 0; x< moviesToDisplay.size(); x++ ){
                int numbering = x + 1;
                System.out.println(numbering + ": " + moviesToDisplay.get(x).getName() + ", No. of Ratings: " + String.format("%.1f", moviesToDisplay.get(x).getRating()[0])+ ", Average Rating: " + String.format("%.1f", moviesToDisplay.get(x).getRating()[1]));
            }
        }
        else{
            System.out.println("\nTop 5 Movies by Total Sales: ");
            for (int x = 0; x< moviesToDisplay.size(); x++ ){
                int numbering = x + 1;
                System.out.println(numbering + ": " + moviesToDisplay.get(x).getName() + ", Total Sales: " + moviesToDisplay.get(x).getSales());
            }
        }

    }
}
