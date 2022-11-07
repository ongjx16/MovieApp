import java.io.Serializable;

public class SeatingPlan implements Serializable{

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

        for (int i = 0; i < col; i++) {
            if (i == 0) {
                System.out.print("-  " + (i+1) + "  ");
            }
            else{
                System.out.print(i+1 + "  ");
            }
        }
        System.out.print("\n");

        for(int i=0; i<row; i++){
            for(int j=0; j<col;j++){
                if (j == 0){
                    System.out.print((i+1) + " ");
                }
                if (seatPlan[i][j].isOccupied() == true){
                    System.out.print(" X "); //X = occupied
                }else{
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

}
