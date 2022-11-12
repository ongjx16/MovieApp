package Entity;

import java.io.Serializable;

/**
 * Represents the seating plan in cinemas in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class SeatingPlan implements Serializable{
    private static final long serialVersionUID = -5501512317806849925L;

    /**
     * The seating plan made from seats
     */
    private Seat[][] seatPlan;
    /**
     * The seat's row
     */
    private int row;
    /**
     * The seat's col
     */
    private int col;

    /**
     * Creates a seating plan with array of seats
     * @param row seat's row
     * @param col seat's column
     */
    public SeatingPlan(int row, int col){
        this.row = row; 
        this.col = col;
        seatPlan = new Seat[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col;j++){
                char x = (char)(j + 65);
                String seatyea = x + String.valueOf(i);
                seatPlan[i][j] = new Seat(seatyea);
            }
        }
    }

    /**
     * Displays the seat plan
     */
    public void displaySeatPlan(){
        System.out.println("Seating layout:\n");

        System.out.println("======================================================");
        System.out.println("                      SCREEN IS HERE                  ");
        System.out.println("======================================================");

        for (int i = 0; i < col; i++) {
            char c = (char)(i + 65);
            if (i == 0) {
                System.out.print("-  " + "  " + c + " ");
            } else if (i == (col/2)) {
                System.out.print("  " + " " + c + " " + "");
            }
            else{
                System.out.print(" " + c + " ");
            }
        }
        System.out.print("\n");

        for(int i=0; i<row; i++){
            if (i == 0){
                System.out.println("------------------------------------------------------");

            }
            for(int j=0; j<col;j++){
                if (j == 0){
                    if (i < 9){
                        String intbutString = "0" + String.valueOf(i+1);
                        System.out.print((intbutString + "| "));
                    }
                    else{
                        System.out.print(i+1 + "| ");
                    }
                }
                if (j == col/2){
                    System.out.print("  ");
                }
                
                if (seatPlan[i][j].isOccupied() == true){
                    if (i == row-1 && j%2 == 0){
                        System.out.print("  X");
                    }
                    else if ((i == row-1 && j%2 != 0)){
                        System.out.print("X  ");
                    }
                    else{
                    System.out.print(" X ");} //X = occupied
                }
                if (seatPlan[i][j].isOccupied() == false){
                    if ((i == row-1 && j%2 == 0)){
                        System.out.print("  O");
                    }
                    else if ((i == row-1 && j%2 != 0)){
                        System.out.print("O  ");
                    }
                    else {System.out.print(" O ");} //O = vacant
                }
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Legend:");
        System.out.println("(X) Occupied, (O) Empty, (XX) Couple Seat Occupied, (OO) Couple Seat Empty\n");
    }

    /**
     * Assigns the seat to the movie-goer
     * @param a the seat's row
     * @param b the seat's column
     */
    public void assignSeat(int a, String b){
        b = b.toUpperCase();
        char aa = b.charAt(0);
        int conv = (int) aa - 65;
        if (seatPlan[a][conv].isOccupied() == false){
            seatPlan[a][conv].assign();
        }else{
            System.out.println("Sorry seat taken");
        }
    }

    /**
     * Checks if a seat is occupied
     * @param a seat's row
     * @param b seat's column
     * @return true or false
     */
    public boolean checkSeatIfOccupied(int a, String b){
        b = b.toUpperCase();
        char aa = b.charAt(0);
        int conv = (int) aa - 65;
        if (seatPlan[a][conv].isOccupied() == true){
            return true;
        }
        else return false;
    }

    /**
     * Unassigns a seat from movie-goer
     * @param a seat's row
     * @param b seat's column
     */
    public void unassignSeat(int a, String b){
        b = b.toUpperCase();
        char aa = b.charAt(0);
        System.out.println(aa);
        int conv = (int) aa - 65;
        if (seatPlan[a][conv].isOccupied() == true){
            seatPlan[a][conv].unassign();
        }else{
            System.out.println("src.Entity.Seat is unoccupied");
        }
    }

    /**
     * Gets the seating plan
     * @return the seating plan
     */
    public Seat[][] getSeatPlan() {
        return seatPlan;
    }

    /**
     * Changes the seat plan
     * @param seatPlan the seat plan
     */
    public void setSeatPlan(Seat[][] seatPlan) {
        this.seatPlan = seatPlan;
    }

    /**
     * Gets the row of the seat
     * @return seat's row
     */
    public int getRow() {
        return row;
    }

    /**
     * Changes the row of the seat
     * @param row seat's row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Gets the column of seat
     * @return seat's column
     */
    public int getCol() {
        return col;
    }

    /**
     * Changes the column of the seat
     * @param col seat's column
     */
    public void setCol(int col) {
        this.col = col;
    }
}
