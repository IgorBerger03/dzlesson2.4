public class Main {
    public static void main(String[] args) {
        String login = "123abc_875678*&^&*&^&^";
        String password = "LA56jl;kfkfv";
        String confirmPassword = "LA56j";
        System.out.println(parameters(login, password, confirmPassword));
    }

    public static boolean parameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthLogin;
        boolean checkLengthPassword;
        boolean comparePassword;
        try {
            checkLogin = checkValidation(login);
            checkPassword = checkValidation(password);
            checkLengthLogin = checkLoginLength(login);
            checkLengthPassword = checkPasswordLength(password);
            comparePassword = comparingPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin && checkPassword && checkLengthLogin && checkLengthPassword && comparePassword;

    }
    public static boolean checkValidation(String checkWord) {
        if (checkWord == null) {
            System.out.println("Слово является null");
            return false;
        }
        if (checkWord.matches("\\w+")) {
            return true;
        }
        System.out.println("Недопустимые символы в слове");
        return false;
    }
    public static boolean checkLoginLength(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный пароль");
        }
        return true;
    }
    public static boolean checkPasswordLength(String password) {
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }
    public static boolean comparingPassword(String password, String confirmPassword) throws WrongPasswordException{
        if (password.equals(confirmPassword))
            return true;
        throw new WrongPasswordException("Пароли не совпадают");
    }

}