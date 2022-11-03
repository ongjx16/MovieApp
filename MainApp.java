import java.util.Scanner;
import Admin.adminLogin;
import User.UserLogin;
import User.tickets;

public class MainApp{
    public static void main (String[] args){
        int identity;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        UserLogin user = new UserLogin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you brother?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1){
            System.out.println("Please enter your username");
            username1 = scan.next();

            while (!admin.verifyUsername(username1)){
                if (admin.verifyUsername(username1)){
                    System.out.println("Username is valid");
                }
                else{
                    System.out.println("Username is invalid, please key in again");
                    username1 = scan.next();
                }
            }

            System.out.println("Please enter your password");
            password1 = scan.next();
            while (!admin.verifyPassword(username1, password1)){
                if (admin.verifyPassword(username1, password1)){
                    System.out.println("Password is valid");
                }
                else{
                    System.out.println("Password is invalid, please key in again");
                    password1 = scan.next();
                }
            }

            //log in as admin
        }
        else if (identity ==2){
            System.out.println("You are now a user\n");
            System.out.println("What would you like to do now \n");
            System.out.println("(1) Book a movie\n");
            System.out.println("(2) See History");
            int option = scan.nextInt();

            if (option == 1){
                System.out.println("These are the cineplexes");
                ReadCineplexes readCineplexes = new ReadCineplexes();
                for(int i=0; i<readCineplexes.getCineplexes().length;i++){
                    System.out.println("[" + (i+1) + "] " + readCineplexes.getCineplexes()[i].getCineplexName() + "\n");
                }
                System.out.println("Choose your cineplex: ");
                int a = scan.nextInt();
                if (a> readCineplexes.getCineplexes().length || a < 1){
                    System.out.println("Invalid option, please choose again");
                    a = scan.nextInt();
                }
                System.out.println("Your choice is: " + readCineplexes.getCineplexes()[a-1].getCineplexName());
                Cineplex userCineplex = new Cineplex(readCineplexes.getCineplexes()[a-1].getCineplexName());
                System.out.println("Choose your movie! ");
                for(int j=0; j<userCineplex.getMovies().length;j++){
                    System.out.println("[" + (j+1) + "] " + userCineplex.getMovies()[j] + "\n");
                }

            }

            if (option == 2){
                System.out.println("Please enter your username");
                username1 = scan.next();

                while (!user.verifyUsername(username1)){
                    if (user.verifyUsername(username1)){
                        System.out.println("Username is valid");
                    }
                    else{
                        System.out.println("Username is invalid, please key in again");
                        username1 = scan.next();
                    }
                }

                System.out.println("Please enter your password");
                password1 = scan.next();
                while (!user.verifyPassword(username1, password1)){
                    if (user.verifyPassword(username1, password1)){
                        System.out.println("Password is valid");

                    }
                    else{
                        System.out.println("Password is invalid, please key in again");
                        password1 = scan.next();
                    }
                }
            }
        }
        else{
            return;
        }
    
    
    }
}
