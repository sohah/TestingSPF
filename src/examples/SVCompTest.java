
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SVCompTest {

    int sideEffect = 0;

    public static void main(String[] args) {

//        StaticCharMethods02("abc");
//        StringCompare02("ab", "CD");
        RegexMatches02("Abc");
    }


    public static void StaticCharMethods02(String arg) {
        if (arg.length() < 1)
            return;
        char c = arg.charAt(0);
//        System.out.println("printing output");

        char upperC = Character.toUpperCase(c);
        char lowerC = Character.toLowerCase(c);
        if(upperC == lowerC)
            System.out.println("Failing.");
//        assert (Character.toUpperCase(c) != Character.toLowerCase(c));
    }

    public static void StringCompare02(String s3, String s4) {

        // test regionMatches (case sensitive)
        if (s3.regionMatches(0, s4, 0, 5)) // false
            assert true;
        else
            assert false;
    }

    public static void RegexMatches02(String string1){
        Pattern expression = Pattern.compile("W.*\\d[0-35-9]-\\d\\d-\\d\\d");

        Matcher matcher = expression.matcher(string1);

        while (matcher.find()) {
            System.out.println(matcher.group());
            String tmp = matcher.group();
            assert tmp.equals("WWWWW's Birthday is 12-17-77");
        }
    }

}
