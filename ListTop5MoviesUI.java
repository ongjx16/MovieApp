import java.util.ArrayList;

public class ListTop5MoviesUI {

    public static void sortByRatings(){
        int i;
        int size = 0;
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
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

        // iterate through allMovies array to print movies with the top 5 rating
        for (i = 0; i< size; i++){
            if (allRatings.get(i).equals(allMovies.get(0).getRating()[1])){
                int numbering = i+1;
                System.out.println(numbering + ": " + allMovies.get(0).getName() + ", Rating: " + allMovies.get(0).getRating()[1]);
                allMovies.remove(0);
            }
        }
    }

    public static void sortBySales(){
        int i;
        int size = 0;
        ArrayList<Movie> allMovies = MoviesManager.readAllMovies();
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

        // iterate through allMovies array to print movies with the top 5 rating
        for (i = 0; i< size; i++){
            if (allSales.get(i).equals(allMovies.get(0).getSales())){
                int numbering = i+1;
                System.out.println(numbering + ": " + allMovies.get(0).getName() + ", Sales: " + allMovies.get(0).getSales());
                allMovies.remove(0);
            }
        }
    }
}
