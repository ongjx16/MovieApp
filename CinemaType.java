import java.io.Serializable;

public enum CinemaType implements Serializable {
    STANDARD{
        public String toString() {
            return "Standard";
        }
    }, PREMIUM{
        public String toString() {
            return "Premium";
        }
    }
}
