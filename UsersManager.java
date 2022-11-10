import User.selector;import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;

public class UsersManager {


    public static void createUser(String username, String password, String name, int phoneNumber, String email){
        try{

            //Creating the object
            ArrayList<selector.UserAccount> userList = new ArrayList<selector.UserAccount>(readAllUsers());

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

            selector.UserAccount user1 = new selector.UserAccount(username, password, name, phoneNumber, email, id);

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

    public static ArrayList<selector.UserAccount> readAllUsers () {
        ArrayList<selector.UserAccount> usersOutput = new ArrayList<selector.UserAccount>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllUsers.dat"));
            usersOutput = (ArrayList<selector.UserAccount>) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace(
        );}
        return (usersOutput);
    }

    public static void deleteUser (int index) {
        try{

            //Creating the object
            ArrayList<selector.UserAccount> usersList = new ArrayList<selector.UserAccount>(readAllUsers());

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

    public static void editBookingHistory (int index, Booking b) {
        try{

            //Creating the object
            ArrayList<selector.UserAccount> usersList = new ArrayList<selector.UserAccount>(readAllUsers());
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
            System.out.println("booking history changed");
        }catch(Exception e){}
    }








}
