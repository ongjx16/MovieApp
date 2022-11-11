import java.io.Serializable;

public enum MovieStatus implements Serializable{
    NOW_SHOWING {
        public String toString() {
            return "Now Showing";
        }
    },

    COMING_SOON {
        public String toString() {
            return "Coming Soon";
        }
    },

    END_OF_SHOW {
        public String toString() {
            return "End of Showing";
        }
    }
}
