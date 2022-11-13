package Control;

import Entity.AdminAccount;
/**
 * Login is parent class for logging in functions
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
abstract public class Login {
    /**
     * The username input by the user during login
     */
    private String usernameinput;
    /**
     * The password input by the user during login
     */
    private String passwordinput;

    /**
     * Gets the username input by the user
     * @return Username input by user
     */
    public String getUsernameinput() {
        return usernameinput;
    }
    /**
     * Changes username input by user
     * @param usernameinput Username input by user
     */
    public void setUsernameinput(String usernameinput) {
        this.usernameinput = usernameinput;
    }

    /**
     * Gets the password input by the user
     * @return Password input by user
     */
    public String getPasswordinput() {
        return passwordinput;
    }

    /**
     * Changes password input by user
     * @param passwordinput Password input by user
     */
    public void setPasswordinput(String passwordinput) {
        this.passwordinput = passwordinput;
    }

    /**
     * Verifies the password input by the user during login
     * Input compared with password set during sign in
     * @param usernameinput Username input by user
     * @param passwordinput Password input by user
     * @return True if password is valid
     */
    public boolean verifyPassword(String usernameinput, String passwordinput){
        AdminLogin AdminLogin = new AdminLogin();
        AdminAccount[] admins = AdminLogin.getAdmins();
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

    /**
     * Verifies if username is available for user during sign up
     * Input is compared with list of all usernames
     * @param usernameinput Username input by user
     * @return True if username is valid
     */
    public boolean verifyUsername(String usernameinput){
        AdminLogin AdminLogin = new AdminLogin();
        AdminAccount[] admins = AdminLogin.getAdmins();

        for (int m =0; m<admins.length; m++){
            if (usernameinput.equals(admins[m].getUsername())){
                return true;
            }

        }
        return false;

    }
}
