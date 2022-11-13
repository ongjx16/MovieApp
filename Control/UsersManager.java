package Control;

import Entity.Booking;
import Entity.UserAccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
/**
 * control class to execute changes to movie-goer accounts
 * used for sign up, get all registered accounts, and edit booking history of movie-goer
 * @author jing xuan
 * @version 1.0
 * @since 2022-11-13
 */
public class UsersManager {
    /**
     * used to sign up and store data of new user
     * @param username username of new user
     * @param password password of new user
     * @param name name of new user
     * @param phoneNumber phone number of new user
     * @param email email of new user
     */

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
        }catch(Exception e){e.printStackTrace(
        );}
    }

    /**
     * called when having to check through whole database of movie-goer accounts
     * @return array list of object type UserAccount, which comprises of all registered movie-goer accounts
     */

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

    /**
     * to delete any specific user
     * can be implemented in admin control panel for future improvements
     * @param index index in array list of UserAccount that requires deletion
     */

    public static void deleteUser (int index) {
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
            System.out.println("User successfully removed");
        }catch(Exception e){}
    }

    /**
     * add to booking history associated to the user account
     * @param index index in array list of UserAccount to which booking history needs edits to
     * @param b Booking object to be added to user account
     */

    public static void editBookingHistory (int index, Booking b) {
        try{

            //Creating the object
            ArrayList<UserAccount> usersList = new ArrayList<UserAccount>(readAllUsers());
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream(new File("DATFiles/AllUsers.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            usersList.get(index).addBooking(b);

            out.writeObject(usersList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
        }catch(Exception e){}
    }








}