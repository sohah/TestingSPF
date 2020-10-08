package infusion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Infusion_Daikon {

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


                assert param.length == 232 : "invalid number of parameters to run the program. Assumptions violated. Failing.";

                INFUSION_MGR_Functional.INFUSION_MGR_FunctionalSymWrapper(
                        //step 1
                        Boolean.parseBoolean(param[0]) ,
                        Boolean.parseBoolean(param[1]) ,
                        Boolean.parseBoolean(param[2]) ,
                        Boolean.parseBoolean(param[3]) ,
                        Boolean.parseBoolean(param[4]) ,
                        Integer.parseInt(param[5]) ,
                        Integer.parseInt(param[6]) ,
                        Integer.parseInt(param[7]) ,
                        Integer.parseInt(param[8]) ,
                        Integer.parseInt(param[9]) ,
                        Integer.parseInt(param[10]) ,
                        Integer.parseInt(param[11]) ,
                        Integer.parseInt(param[12]) ,
                        Integer.parseInt(param[13]) ,
                        Integer.parseInt(param[14]) ,
                        Integer.parseInt(param[15]) ,
                        Integer.parseInt(param[16]) ,
                        Integer.parseInt(param[17]) ,
                        Integer.parseInt(param[18]) ,
                        Integer.parseInt(param[19]) ,
                        Boolean.parseBoolean(param[20]) ,
                        Integer.parseInt(param[21]),

                        //step 2
                        Boolean.parseBoolean(param[22]) ,
                        Boolean.parseBoolean(param[23]) ,
                        Boolean.parseBoolean(param[24]) ,
                        Boolean.parseBoolean(param[25]) ,
                        Boolean.parseBoolean(param[26]) ,
                        Integer.parseInt(param[27]) ,
                        Integer.parseInt(param[28]) ,
                        Integer.parseInt(param[29]) ,
                        Integer.parseInt(param[30]) ,
                        Integer.parseInt(param[31]) ,
                        Integer.parseInt(param[32]) ,
                        Integer.parseInt(param[33]) ,
                        Integer.parseInt(param[34]) ,
                        Integer.parseInt(param[35]) ,
                        Integer.parseInt(param[36]) ,
                        Integer.parseInt(param[37]) ,
                        Integer.parseInt(param[38]) ,
                        Integer.parseInt(param[39]) ,
                        Integer.parseInt(param[40]) ,
                        Integer.parseInt(param[41]) ,
                        Boolean.parseBoolean(param[42]) ,
                        Integer.parseInt(param[43]) ,

                        //step 3
                        Boolean.parseBoolean(param[44]) ,
                        Boolean.parseBoolean(param[45]) ,
                        Boolean.parseBoolean(param[46]) ,
                        Boolean.parseBoolean(param[47]) ,
                        Boolean.parseBoolean(param[48]) ,
                        Integer.parseInt(param[49]) ,
                        Integer.parseInt(param[50]) ,
                        Integer.parseInt(param[51]) ,
                        Integer.parseInt(param[52]) ,
                        Integer.parseInt(param[53]) ,
                        Integer.parseInt(param[54]) ,
                        Integer.parseInt(param[55]) ,
                        Integer.parseInt(param[56]) ,
                        Integer.parseInt(param[57]) ,
                        Integer.parseInt(param[58]) ,
                        Integer.parseInt(param[59]) ,
                        Integer.parseInt(param[60]) ,
                        Integer.parseInt(param[61]) ,
                        Integer.parseInt(param[62]) ,
                        Integer.parseInt(param[63]) ,
                        Boolean.parseBoolean(param[64]) ,
                        Integer.parseInt(param[65]) ,

                        //step 4
                        Boolean.parseBoolean(param[66]) ,
                        Boolean.parseBoolean(param[67]) ,
                        Boolean.parseBoolean(param[68]) ,
                        Boolean.parseBoolean(param[69]) ,
                        Boolean.parseBoolean(param[70]) ,
                        Integer.parseInt(param[71]) ,
                        Integer.parseInt(param[72]) ,
                        Integer.parseInt(param[73]) ,
                        Integer.parseInt(param[74]) ,
                        Integer.parseInt(param[75]) ,
                        Integer.parseInt(param[76]) ,
                        Integer.parseInt(param[77]) ,
                        Integer.parseInt(param[78]) ,
                        Integer.parseInt(param[79]) ,
                        Integer.parseInt(param[80]) ,
                        Integer.parseInt(param[81]) ,
                        Integer.parseInt(param[82]) ,
                        Integer.parseInt(param[83]) ,
                        Integer.parseInt(param[84]) ,
                        Integer.parseInt(param[85]) ,
                        Boolean.parseBoolean(param[86]) ,
                        Integer.parseInt(param[87]) ,

                        //step 5
                        Boolean.parseBoolean(param[88]) ,
                        Boolean.parseBoolean(param[89]) ,
                        Boolean.parseBoolean(param[90]) ,
                        Boolean.parseBoolean(param[91]) ,
                        Boolean.parseBoolean(param[92]) ,
                        Integer.parseInt(param[93]) ,
                        Integer.parseInt(param[94]) ,
                        Integer.parseInt(param[95]) ,
                        Integer.parseInt(param[96]) ,
                        Integer.parseInt(param[97]) ,
                        Integer.parseInt(param[98]) ,
                        Integer.parseInt(param[99]) ,
                        Integer.parseInt(param[100]) ,
                        Integer.parseInt(param[101]) ,
                        Integer.parseInt(param[102]) ,
                        Integer.parseInt(param[103]) ,
                        Integer.parseInt(param[104]) ,
                        Integer.parseInt(param[105]) ,
                        Integer.parseInt(param[106]) ,
                        Integer.parseInt(param[107]) ,
                        Boolean.parseBoolean(param[108]) ,
                        Integer.parseInt(param[109]),

                        //step 6
                        Boolean.parseBoolean(param[110]) ,
                        Boolean.parseBoolean(param[111]) ,
                        Boolean.parseBoolean(param[112]) ,
                        Boolean.parseBoolean(param[113]) ,
                        Boolean.parseBoolean(param[114]) ,
                        Integer.parseInt(param[115]) ,
                        Integer.parseInt(param[116]) ,
                        Integer.parseInt(param[117]) ,
                        Integer.parseInt(param[118]) ,
                        Integer.parseInt(param[119]) ,
                        Integer.parseInt(param[120]) ,
                        Integer.parseInt(param[121]) ,
                        Integer.parseInt(param[122]) ,
                        Integer.parseInt(param[123]) ,
                        Integer.parseInt(param[124]) ,
                        Integer.parseInt(param[125]) ,
                        Integer.parseInt(param[126]) ,
                        Integer.parseInt(param[127]) ,
                        Integer.parseInt(param[128]) ,
                        Integer.parseInt(param[129]) ,
                        Boolean.parseBoolean(param[130]) ,
                        Integer.parseInt(param[131])

                        );
            }
        } catch (IOException e) {
            System.out.println("problem while reading the test case file. Failing.");
            assert false;
        }
    }
}
