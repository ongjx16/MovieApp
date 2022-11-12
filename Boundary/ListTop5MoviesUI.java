package Boundary;

import java.util.ArrayList;
import Entity.Movie;
import Control.MoviesManager;

public class ListTop5MoviesUI {

    public static void sortByRatings(){
        int i;
        int size = 0;
        ArrayList<Movie> allMovies = new ArrayList<Movie>(MoviesManager.filterByStatus(MoviesManager.readAllMovies())) ;


        ArrayList<Integer> allRatings = new ArrayList<Integer>();

        // adding the ratings of all movies into an array
        for (i=0; i<allMovies.size(); i++){
            allRatings.add(allMovies.get(i).getRating()[1]);
        }
        // sorting ratings from highest to lowest
        for (i=0; i<allRatings.size(); i++){
            for (int j=0; j<allRatings.size() - i - 1; j++){
                if (allRatings.get(j) < allRatings.get(j+1)){
                    int temp = allRatings.get(j);
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

        for (int x = 0; x< filteredMovies.size(); x++ ){
            int numbering = x + 1;
            System.out.println(numbering + ": " + filteredMovies.get(x).getName() + ", Rating: " + filteredMovies.get(x).getRating()[1]);
        }


    }

    public static boolean isRepeat(Movie movieToCompare, ArrayList<Movie> array){

        for (int i = 0; i< array.size(); i++){
            if (movieToCompare.equals(array.get(i))){
                return true;
            }
        }

        return false;
    }

    public static void sortBySales(){
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

        for (int x = 0; x< filteredMovies.size(); x++ ){
            int numbering = x + 1;
            System.out.println(numbering + ": " + filteredMovies.get(x).getName() + ", Sales: " + filteredMovies.get(x).getSales());
        }




        }

}
