package Control;

/**
 * Login for movie-goers
 * @author murong
 * @version 1.0
 * @since 2022-11-13
 */
public class UserLogin extends Login{
    /**
     * Checks if user username input is valid. Overrides method in Login class since different database is being checked.
     * @param userNameInput
     * @return True if username is valid
     */
    @Override
    public boolean verifyUsername(String userNameInput) {
        for (int m = 0; m < UsersManager.readAllUsers().size(); m++) {
            if (userNameInput.equals(UsersManager.readAllUsers().get(m).getUsername())) {
                return true;
            }

        }
        return false;

    }

    /**
     * Checks if user password input is valid. Overrides method in Login class since different database is being checked.
     * @param userNameInput
     * @param passwordInput
     * @return True if password is valid
     */
@Override
    public boolean verifyPassword(String userNameInput, String passwordInput) {
        int n = 0;
        while ( n < UsersManager.readAllUsers().size()) {
            if (userNameInput.equals(UsersManager.readAllUsers().get(n).getUsername())) {
                if (passwordInput.equals(UsersManager.readAllUsers().get(n).getPassword())) {
                    return true;
                }
            }

            n++;

        }
        return false;
    }


}