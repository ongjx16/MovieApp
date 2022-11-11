public class UserLogin {


    public static boolean verifyUsername(String userNameInput) {
        for (int m = 0; m < UsersManager.readAllUsers().size(); m++) {
            if (userNameInput.equals(UsersManager.readAllUsers().get(m).getUsername())) {
                return true;
            }

        }
        return false;

    }

    public static boolean verifyPassword(String userNameInput, String passwordInput) {
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