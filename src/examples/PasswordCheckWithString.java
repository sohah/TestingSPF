import gov.nasa.jpf.symbc.Debug;

public class PasswordCheckWithString {

    private static String password;

    public static boolean verifyPasswordInsecure(final String s) {

        Debug.assume(password.length() <= 4);
        Debug.assume(s.length() <= 4);

        if (s.length() != password.length())
            return false;

        for (int i = 0; i < password.length(); ++i) {
            if (s.charAt(i) != password.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        password = Debug.makeSymbolicString(args[2]);
        String input = Debug.makeSymbolicString(args[1]);

        boolean check = verifyPasswordInsecure(input);
        if (check) {
            System.out.println("Password accepted");
        } else {
            System.out.println("Access denied");
        }
    }
}