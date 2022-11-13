package Control;
import Entity.AdminAccount;

import java.io.*;

/**
 * Login for admins
 */
public class AdminLogin extends Login{
    /**
     * Gets a list of all the admins
     * @return list of all admins
     */
    
 public AdminAccount[] getAdmins (){
    AdminAccount[] admins = new AdminAccount[5];
    int i =0;
    boolean cont = true;
  try{  
  //Creating stream to read the object  
  ObjectInputStream in=new ObjectInputStream(new FileInputStream("DATFiles/AdminAccounts.dat"));
  
  while (cont){
    AdminAccount admin = null;
    try{
        admin = (AdminAccount)in.readObject();
    }
    catch(ClassNotFoundException e){
//        e.printStackTrace(
//            );
    }
    if(admin!=null){
        admins[i] = admin;
        i++;
        
    }
    else{
        cont = false;
    }
  }
  
  
  //closing the stream  
  in.close();  
  }catch(Exception e){
//      System.out.println(e);
  }

  return(admins);
  
//   for (int k =0; k<i; k++){
//     System.out.println(admins[k].getAdminUsername()+" "+admins[k].getAdminPassword());
//   }
 }

    /**
     * Checks if admin username input is valid
     * @param usernameinput
     * @return True if username is valid
     */


    /**
     * Checks if admin password input is valid
     * @param usernameinput
     * @param passwordinput
     * @return True if password is valid
     */



}

