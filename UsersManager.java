import Admin.AdminAccount;
import User.UserAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersManager {


    public static void createUser(String username, String password, String name, int phoneNumber, String email){
        try{

            //Creating the object
            ArrayList<UserAccount> userList = new ArrayList<UserAccount>(readAllUsers());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllUsers.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            int id;
            if(userList.size()>0){
                id = userList.get(userList.size()-1).getUserId() +1 ;
            }
            else{
                id = 1;
            }

            UserAccount user1 = new UserAccount(username, password, name, phoneNumber, email, id);

            userList.add(user1);
//            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(userList);
            out.flush();
            //closing the stream
            //out.reset();
            out.close();
            System.out.println("create user success");
        }catch(Exception e){e.printStackTrace(
        );}
    }

    public static ArrayList<UserAccount> readAllUsers () {
        ArrayList<UserAccount> usersOutput = new ArrayList<UserAccount>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllUsers.dat"));
            usersOutput = (ArrayList<UserAccount>) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace(
        );}
        return (usersOutput);
    }

    public static void deleteMovie (int index) {
        try{

            //Creating the object
            ArrayList<UserAccount> usersList = new ArrayList<UserAccount>(readAllUsers());

            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllUsers.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            usersList.remove(index);

            out.writeObject(usersList);
            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("user successfully removed");
        }catch(Exception e){}
    }

//    public static void editMovie (int index, String attribute) {
//        try{
//
//            //Creating the object
//            ArrayList<Movie> movieList = new ArrayList<Movie>(readAllUsers());
//
//            //Creating stream and writing the object
//            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllMovies.dat"));
//            ObjectOutputStream out = new ObjectOutputStream(fout);
//            Scanner scan = new Scanner(System.in);
//
//            if (attribute == "name"){
//                System.out.println("Current: " + movieList.get(index).getName());
//                System.out.println("Enter new name: ");
//                String newName = scan.nextLine();
//                movieList.get(index).setName(newName);
//            }
//            else if (attribute == "type"){
//                System.out.println("Current: " + movieList.get(index).getType());
//                System.out.println("Enter updated movie type: ");
//                String newType = scan.nextLine();
//                movieList.get(index).setType(newType);
//            }
//            else if (attribute == "length"){
//                System.out.println("Current: " + movieList.get(index).getShowLength());
//                System.out.println("Enter updated show length in minutes: ");
//                int length = scan.nextInt();
//                movieList.get(index).setShowLength(length);
//            }
//            else if (attribute == "status"){
//                System.out.println("Current: " + movieList.get(index).getShowingStatus());
//                System.out.println("Enter updated showing status: ");
//                String status = scan.nextLine();
//                movieList.get(index).setShowingStatus(status);
//            }
//            else if (attribute == "director"){
//                System.out.println("Current: " + movieList.get(index).getDirector());
//                System.out.println("Enter updated director name: ");
//                String director = scan.nextLine();
//                movieList.get(index).setDirector(director);
//            }
//            else if (attribute == "synopsis"){
//                System.out.println("Current: " + movieList.get(index).getSynopsis());
//                System.out.println("Enter updated synopsis: ");
//                String synopsis = scan.nextLine();
//                movieList.get(index).setSynopsis(synopsis);
//            }
//
//            out.writeObject(movieList);
//
//            out.flush();
//            //closing the stream
//            //out.reset();
//            fout.close();
//            out.close();
//            System.out.println("movie successfully removed");
//        }catch(Exception e){}
//    }








}
