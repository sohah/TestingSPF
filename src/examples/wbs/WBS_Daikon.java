package wbs;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WBS_Daikon {


    /**
     * Takes as argument the filename (in absolute form) of the test cases generated from spf.
     *
     * @param args
     */
    public static void main(String[] args) {

        assert args.length == 1 : "to run you must pass the filename of the test cases file. Assumption violated. Failing";


        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.substring(line.indexOf("(") + 1, line.indexOf(")"));

                String[] param = line.split(",");


                assert param.length == 15 : "invalid number of parameters to run the program. Assumptions violated. Failing.";

                WBS.launch(Integer.parseInt(param[0]), Boolean.parseBoolean(param[1]), Boolean.parseBoolean(param[2]),
                        Integer.parseInt(param[3]), Boolean.parseBoolean(param[4]), Boolean.parseBoolean(param[5]),
                        Integer.parseInt(param[6]), Boolean.parseBoolean(param[7]), Boolean.parseBoolean(param[8]),
                        Integer.parseInt(param[9]), Boolean.parseBoolean(param[10]), Boolean.parseBoolean(param[11]),
                        Integer.parseInt(param[12]), Boolean.parseBoolean(param[13]), Boolean.parseBoolean(param[14]));
            }
        } catch (IOException e) {
            System.out.println("problem while reading the test case file. Failing.");
            assert false;
        }
    }
}
