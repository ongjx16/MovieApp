package Entity;

import java.io.Serializable;

public class Account implements Serializable{
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Account(String u,String p){
        this.password = p;
        this.username = u;
    }
    
}
