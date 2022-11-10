import User.selector;public class UserLogin {


    public static boolean verifyUsername(String userNameInput) {
        for (int m = 0; m < selector.UsersManager.readAllUsers().size(); m++) {
            if (userNameInput.equals(selector.UsersManager.readAllUsers().get(m).getUsername())) {
                return true;
            }

        }
        return false;

    }

    public static boolean verifyPassword(String userNameInput, String passwordInput) {
        int n = 0;
        while ( n < selector.UsersManager.readAllUsers().size()) {
            if (userNameInput.equals(selector.UsersManager.readAllUsers().get(n).getUsername())) {
                if (passwordInput.equals(selector.UsersManager.readAllUsers().get(n).getPassword())) {
                    return true;
                }
            }

                n++;

        }
        return false;
    }


}
