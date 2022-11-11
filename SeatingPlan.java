import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
                seatPlan[i][j] = new Seat(j*100+i);
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
                    System.out.print(" X "); //X = occupied
                }
                if (seatPlan[i][j].isOccupied() == false){
                    System.out.print(" O "); //O = vacant
                }
            }
            System.out.print("\n");
        }
    }


    public void assignSeat(int a, int b){
        if (seatPlan[a][b].isOccupied() == false){
            seatPlan[a][b].assign();
        }else{
            System.out.println("Sorry seat taken");
        }
    }

    public void unassignSeat(int a, int b){
        if (seatPlan[a][b].isOccupied() == true){
            seatPlan[a][b].unassign();
        }else{
            System.out.println("Seat is unoccupied");
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
