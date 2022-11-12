package Utils;

import java.io.Serializable;

public enum MovieStatus implements Serializable{
    NOW_SHOWING {
        public String toString() {
            return "Now Showing";
        }
    },

    PREVIEW {
        public String toString() {
            return "Preview";
        }
    },

    END_OF_SHOW {
        public String toString() {
            return "End of Showing";
        }
    }
}
