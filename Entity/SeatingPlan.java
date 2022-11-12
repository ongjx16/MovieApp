package Entity;

import java.io.Serializable;

public class SeatingPlan implements Serializable{
    private static final long serialVersionUID = -5501512317806849925L;

    // seat plan will be shown in matrix: X if occupied, O if not
    // seat ID will be (j*100)+i
    

    private Seat[][] seatPlan;

    private int row; 
    private int col; 

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

    public void displaySeatPlan(){
        System.out.println("Seating layout:\n");

        System.out.println("==============================");
        System.out.println("        SCREEN IS HERE        ");
        System.out.println("==============================");

        for (int i = 0; i < col; i++) {
            char c = (char)(i + 65);
            if (i == 0) {
                System.out.print("-  " + " " + c + " ");
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
                System.out.println("-------------------------------");

            }
            for(int j=0; j<col;j++){
                if (j == 0){
                    System.out.print((i+1) + "| ");
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
        System.out.println("Legend:");
        System.out.println("(X) Occupied, (O) Empty, (XX) Couple Seat Occupied, (OO) Couple Seat Empty");
    }

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

    public boolean checkSeatIfOccupied(int a, String b){
        b = b.toUpperCase();
        char aa = b.charAt(0);
        int conv = (int) aa - 65;
        if (seatPlan[a][conv].isOccupied() == true){
            return true;
        }
        else return false;
    }

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

    public Seat[][] getSeatPlan() {
        return seatPlan;
    }

    public void setSeatPlan(Seat[][] seatPlan) {
        this.seatPlan = seatPlan;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
