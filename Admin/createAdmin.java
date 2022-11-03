package Admin;
import java.io.*;

public class createAdmin{    
 public static void main(String args[]){   
  try{    
  //Creating the object    
  AdminAccount admin =new AdminAccount("jx", "test");  
  AdminAccount admin2 = new AdminAccount("somesh","test");
  AdminAccount admin3 = new AdminAccount("murong","password");
  AdminAccount admin4 = new AdminAccount("shubu","password2");
  AdminAccount admin5 = new AdminAccount("htut","password3");
  //Creating stream and writing the object    
  FileOutputStream fout=new FileOutputStream("AdminAccounts.dat");    
  ObjectOutputStream out=new ObjectOutputStream(fout);    
  out.writeObject(admin);  
  out.writeObject(admin2);
  out.writeObject(admin3);
  out.writeObject(admin4);
  out.writeObject(admin5);
  out.flush();    
  //closing the stream    
  out.close();    
  System.out.println("success");    
  }catch(Exception e){System.out.println(e);}    
 }    
}    