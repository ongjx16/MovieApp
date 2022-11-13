package Control;

import Entity.AdminAccount;

abstract public class Login {
    private String usernameinput;
    private String passwordinput;

    public String getUsernameinput() {
        return usernameinput;
    }

    public void setUsernameinput(String usernameinput) {
        this.usernameinput = usernameinput;
    }

    public String getPasswordinput() {
        return passwordinput;
    }

    public void setPasswordinput(String passwordinput) {
        this.passwordinput = passwordinput;
    }

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
