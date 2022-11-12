package Entity;
import java.io.Serializable;

/**
 * Represents an account of admin in charge of the MOBILMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */

public class AdminAccount implements Serializable {

    private static final long serialVersionUID = 4L;
    /**
     * The username of the admin account
     */
    private String username;
    /**
     * The password of the admin account
     */
    private String password;

    /**
     * Creates an admin account with the username and password
     * @param u This admin's username
     * @param p This admin's password
     */
    public AdminAccount(String u, String p){
        username = u;
        password = p;
    }

    /**
     * Gets the username of the admin
     * @return The admin's username
     */
    public String getAdminUsername(){
        return username;
    }

    /**
     * Gets the password of the admin
     * @return The admin's password
     */
    public String getAdminPassword(){
        return password;
    }


}
