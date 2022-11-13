package Utils;

import java.io.Serializable;

/**
 * Represents the movie status of movies in MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-13
 */
public enum MovieStatus implements Serializable{
    /**
     * NOW_SHOWING means currently showing in cinemas
     */
    NOW_SHOWING {
        public String toString() {
            return "Now Showing";
        }
    },

    /**
     * PREVIEW means coming soon to cinemas
     */
    PREVIEW {
        public String toString() {
            return "Preview";
        }
    },

    /**
     * END_OF_SHOW means the movie has ended its showing
     */
    END_OF_SHOW {
        public String toString() {
            return "End of Showing";
        }
    }
}
