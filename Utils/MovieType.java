package Utils;

import java.io.Serializable;

/**
 * Represents the movie type of movies in MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-13
 */
public enum MovieType implements Serializable{
    /**
     * DIGITAL2D means the movie is digital 2D
     */
    DIGITAL2D {
        public String toString() {
            return "Digital 2D";
        }
    },

    /**
     * DIGITAL3D means the movie is digital 3D
     */
    DIGITAL3D {
        public String toString() {
            return "Digital 3D";
        }
    },

    /**
     * BLOCKBUSTER2D means the movie is blockbuster 2d
     */
    BLOCKBUSTER2D {
        public String toString() {
            return "Blockbuster 2D";
        }
    },

    /**
     * BLOCKBUSTER3D means the movie is blockbuster 3d
     */
    BLOCKBUSTER3D {
        public String toString() {
            return "Blockbuster 3D";
        }
    }
}
