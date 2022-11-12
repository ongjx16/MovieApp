package Utils;

import java.io.Serializable;
public enum MovieType implements Serializable{
    DIGITAL2D {
        public String toString() {
            return "Digital 2D";
        }
    },

    DIGITAL3D {
        public String toString() {
            return "Digital 3D";
        }
    },

    BLOCKBUSTER2D {
        public String toString() {
            return "Blockbuster 2D";
        }
    },

    BLOCKBUSTER3D {
        public String toString() {
            return "Blockbuster 3D";
        }
    }
}
