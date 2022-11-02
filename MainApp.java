import java.util.Scanner;

import Admin.adminLogin;

class MainApp{
    public static void main (String[] args){
        int identity;
        String username1;
        String password1;
        adminLogin admin = new adminLogin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Who are you?\n");
        System.out.println("1. Admin\n");
        System.out.println("2. Movie Goer\n");
        System.out.println("3. Exit\n\n");
        System.out.println("Enter a number of your choice: ");
        identity = scan.nextInt();

        if (identity == 1){
            System.out.println("Please enter your username");
            username1 = scan.next();

            while (admin.verifyUsername(username1) == false){
                if (admin.verifyUsername(username1)){
                    System.out.println("Username is valid");
                }
                else{
                    System.out.println("Username is invalid, please key in again");
                }
            }

            System.out.println("Please enter your password");
            password1 = scan.next();
            while (admin.verifyPassword(password1) == false){
                if (admin.verifyPassword(password1)){
                    System.out.println("Password is valid");
                }
                else{
                    System.out.println("Password is invalid, please key in again");
                }
            }

            //log in as admin
        }
        else if (identity ==2){
            System.out.println("i am movie goer jingxuan\n");
        }
        else{
            return;
        }
    
    
    }
}