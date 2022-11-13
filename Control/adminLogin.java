package Control;
import Entity.AdminAccount;

import java.io.*;
public class adminLogin{
    
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
 
 
 public boolean verifyUsername(String usernameinput){
    AdminAccount[] admins = getAdmins();
    
    for (int m =0; m<admins.length; m++){
        if (usernameinput.equals(admins[m].getUsername())){
            return true;
        }

    }
    return false;
    
}

public boolean verifyPassword(String usernameinput, String passwordinput){
    AdminAccount[] admins = getAdmins();
    for (int m =0; m<admins.length; m++){
        if (usernameinput.equals(admins[m].getUsername())){
            if(passwordinput.equals(admins[m].getPassword())){
                return true;
            }
            break;
        }
    }
    return false;
    
}
}  
