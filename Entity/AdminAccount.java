package Entity;
import java.io.Serializable;

/**
 * Represents an account of admin in charge of the MOBILMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */

public class AdminAccount extends Account implements Serializable {

    private static final long serialVersionUID = 4L;

    /**
     * Creates an admin account with the username and password
     * @param username This admin's username
     * @param password This admin's password
     */
    public AdminAccount(String username, String password){
        super(username, password);
        // this.username = username;
        // this.password = password;
    }

    /**
     * Gets the username of the admin
     * @return The admin's username
     */
    public String getUsername() {
        return super.getUsername();
    }
    

    /**
     * Gets the password of the admin
     * @return The admin's password
     */
    public String getPassword() {
        return super.getPassword();
    }
    


}
