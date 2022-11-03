package Admin;
<<<<<<< HEAD

=======
>>>>>>> f2e38669dd69f8725192748250663cf754bef35f
import java.io.Serializable;


public class AdminAccount implements Serializable {
    private static final long serialVersionUID = 4L; 
    private String username;
    private String password;

    AdminAccount(String u, String p){
        username = u;
        password = p;
    }

    public String getAdminUsername(){
        return username;
    }

    public String getAdminPassword(){
        return password;
    }


}
