import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        SeatingPlan layout = new SeatingPlan(5,5);
        layout.assignSeat(0, 0);
        layout.displaySeatPlan();
    }
}
