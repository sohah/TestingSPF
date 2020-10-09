package tcas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TCAS_Daikon {
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


                assert param.length == 36 : "invalid number of parameters to run the program. Assumptions violated. Failing.";

                SpfTCAS.launch(Integer.parseInt(param[0]), Integer.parseInt(param[1]), Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]), Integer.parseInt(param[7]), Integer.parseInt(param[8]), Integer.parseInt(param[9]), Integer.parseInt(param[10]), Integer.parseInt(param[11]),
                        Integer.parseInt(param[12]), Integer.parseInt(param[13]), Integer.parseInt(param[14]), Integer.parseInt(param[15]), Integer.parseInt(param[16]),Integer.parseInt(param[17]), Integer.parseInt(param[18]), Integer.parseInt(param[19]), Integer.parseInt(param[20]), Integer.parseInt(param[21]), Integer.parseInt(param[22]), Integer.parseInt(param[23]),
                        Integer.parseInt(param[24]), Integer.parseInt(param[25]), Integer.parseInt(param[26]), Integer.parseInt(param[27]), Integer.parseInt(param[28]),Integer.parseInt(param[29]), Integer.parseInt(param[30]), Integer.parseInt(param[31]), Integer.parseInt(param[32]), Integer.parseInt(param[33]), Integer.parseInt(param[34]), Integer.parseInt(param[35]));
            }
        } catch (IOException e) {
            System.out.println("problem while reading the test case file. Failing.");
            assert false;
        }
    }
}
