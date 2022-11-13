package Utils;

import java.io.Serializable;

/**
 * Represents the type of cinema in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-13
 */
public enum CinemaType implements Serializable {
    /**
     * STANDARD cinema type
     */
    STANDARD{
        public String toString() {
            return "Standard";
        }
    },
    /**
     * PREMIUM cinema type
     */
    PREMIUM{
        public String toString() {
            return "Premium";
        }
    }
}
