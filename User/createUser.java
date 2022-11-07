package User;
import java.io.*;

public class createUser{
    public static void main(String args[]){
        try{
            //Creating the object
            UserAccount user =new UserAccount("user1", "test");
            UserAccount user2 = new UserAccount("user2","test");
            UserAccount user3 = new UserAccount("user3","test");
            UserAccount user4 = new UserAccount("user4","test");
            UserAccount user5 = new UserAccount("user5","test");
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream("UserAccounts.dat");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(user);
            out.writeObject(user2);
            out.writeObject(user3);
            out.writeObject(user4);
            out.writeObject(user5);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        }catch(Exception e){System.out.println(e);}
    }
}