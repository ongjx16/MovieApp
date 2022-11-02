import java.util.Scanner;

class MainApp{
    public static void main (String[] args){
        int identity;
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you brother?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1){
            System.out.println("i am admin\n");
            //log in as admin
        }
        else if (identity ==2){
            System.out.println("i am movie goer\n");
        }
        else{
            return;
        }
    
    
    }
}