package User;


import java.io.*;
public class UserLogin{

    public UserAccount[] getUsers (){
        UserAccount[] users = new UserAccount[5];
        int i =0;
        boolean cont = true;
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("UserAccounts.dat"));

            while (cont){
                UserAccount user = null;
                try{
                    user = (UserAccount)in.readObject();
                }
                catch(ClassNotFoundException e){
                    e.printStackTrace(
                    );
                }
                if(user!=null){
                    users[i] = user;
                    i++;

                }
                else{
                    cont = false;
                }
            }


            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}

        return(users);
    }


    public boolean verifyUsername(String usernameinput){
        UserAccount[] users = getUsers();
        for (int m =0; m<users.length; m++){
            if (usernameinput.equals(users[m].getUserUsername())){
                return true;
            }

        }
        return false;

    }

    public boolean verifyPassword(String usernameinput, String passwordinput){
        UserAccount[] users = getUsers();
        for (int m =0; m<users.length; m++){
            if (usernameinput.equals(users[m].getUserUsername())){
                if(passwordinput.equals(users[m].getUserPassword())){
                    return true;
                }
                break;
            }
        }
        return false;

    }
}
