public class Main {
    public static void main(String[] args) {
        String login = "123abc";
        String password = "LA56j";
        String confirmPassword = "LA56j";
        personInfo(login, password, confirmPassword);

    }
    public static boolean personInfo(String login, String password, String confirmPassword ){
        boolean checkLogin = login.matches("^[a-z0-9_]+$");
        boolean checkPassword = password.matches("^[a-z0-9_]+$");
        boolean comparePassword = confirmPassword.equals(password);
        if (login.length() > 20 ||(!checkLogin)) {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                System.out.println("Логин должен содержать в себе только латинские буквы, цифры, знак подчеркивания." +
                        "И равен или меньше 20 символов.");
            }
        } else if (password.length() > 20 || (!checkPassword)){
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                System.out.println("Пароль должен содержать в себе только латинские буквы, цифры, знак подчеркивания." +
                        "И равен 20 символов.");
            }
        } else if (!comparePassword) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                System.out.println("Пароли не совпадают");
            }

        } else {
            System.out.println("Регистрация прошла успешно");
        }
        return true;
    }
}