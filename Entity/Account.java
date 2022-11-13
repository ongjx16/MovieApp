package Entity;

import java.io.Serializable;

/** Parent class where User Account and Admin Account are inheriting from
 *@author murong
 *@version 1.0
 *@since 2022-11-13
 */
public abstract class Account implements Serializable{
    /**
     * Username of the user
     */
    private String username;
    /**
     * Password of the user
     */
    private String password;

    /**
     * Gets the password of the user
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Gets the username of the user
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Changes the password of the user
     * @param  password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Changes the username of the user
     * @param  username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Creates an account
     * @param u The username
     * @param p The password
     */
    public Account(String u,String p){
        this.password = p;
        this.username = u;
    }
    
}
