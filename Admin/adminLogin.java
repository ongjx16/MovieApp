// public class adminLogin {

    // private String username;
    // private String password;



import java.io.*;  
public class adminLogin{
    
    
 public AdminAcount[] getAdmins (){
    AdminAccount[] admins = new AdminAccount[5];
    int i =0;
    boolean cont = true;
  try{  
  //Creating stream to read the object  
  ObjectInputStream in=new ObjectInputStream(new FileInputStream("AdminAccounts.dat")); 
  
  while (cont){
    AdminAccount admin = null;
    try{
        admin = (AdminAccount)in.readObject();
    }
    catch(ClassNotFoundException e){
        e.printStackTrace(
            );
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
  }catch(Exception e){System.out.println(e);} 

  return(admins);
  
//   for (int k =0; k<i; k++){
//     System.out.println(admins[k].getAdminUsername()+" "+admins[k].getAdminPassword());
//   }
 }
 
 
 public boolean verifyUsername(String usernameinput){
    admins = getAdmin();
    for (int m =0; m<admins.length; m++){
        if (usernameinput.equals(admins[m].getAdminUsername())){
            return true;
        }

    }
    return false;
    
}

public boolean verifyPassword(String passwordinput){
    admins = getAdmin();
    for (int m =0; m<admins.length; m++){
        if (passwordinput.equals(admins[m].getAdminPassword())){
            return true;
        }

    }
    return false;
    
}
}  
