package Utils;

import java.io.Serializable;
public enum RatingFilterType implements Serializable{
    SALES {
        public String toString() {
            return "By Number of Seats Sold";
        }
    },

    RATINGS {
        public String toString() {
            return "By Average Rating";
        }
    }



}


