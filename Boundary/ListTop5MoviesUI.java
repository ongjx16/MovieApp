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

        ArrayList<float[]> sortedMovies = new ArrayList<float[]>();

        ArrayList<float[]> allRatings = new ArrayList<float[]>();

        // adding the ratings of all movies into an array
        for (i=0; i<allMovies.size(); i++){
            sortedMovies.add(allMovies.get(i).getRating());
        }
        // sorting ratings from highest to lowest
        for (i=0; i<sortedMovies.size(); i++){
            for (int j=0; j<sortedMovies.size() - i - 1; j++){
                if (sortedMovies.get(j)[1] < sortedMovies.get(j+1)[1]){
                    float[] temp = sortedMovies.get(j);
                    sortedMovies.set(j, sortedMovies.get(j+1));
                    sortedMovies.set(j+1, temp);
                }
            }
        }

        for (int y= 0; y<sortedMovies.size(); y++){
            if (sortedMovies.get(y)[0]>1.0){
                allRatings.add(sortedMovies.get(y));
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

                if (allRatings.get(i).equals(allMovies.get(y).getRating()) && !isRepeat(allMovies.get(y), filteredMovies)) {
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
                System.out.println(numbering + ": " + moviesToDisplay.get(x).getName() + ", No. of Ratings: " + String.format("%.0f", moviesToDisplay.get(x).getRating()[0])+ ", Average Rating: " + String.format("%.1f", moviesToDisplay.get(x).getRating()[1]));
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
