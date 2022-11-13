package Utils;

import java.io.Serializable;

/**
 * Represents the type of rating filter
 * @author htut
 * @version 1.0
 * @since 2022-11-13
 */
public enum RatingFilterType implements Serializable{
    /**
     * SALES means the number of seats sold
     */
    SALES {
        public String toString() {
            return "By Number of Seats Sold";
        }
    },
    /**
     * RATINGS means the average rating of a movie
     */
    RATINGS {
        public String toString() {
            return "By Average Rating";
        }
    }



}


