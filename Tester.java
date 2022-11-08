import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        SeatingPlan layout = new SeatingPlan(7,7);
        layout.assignSeat(0, 0);
        layout.displaySeatPlan();
    }
}
