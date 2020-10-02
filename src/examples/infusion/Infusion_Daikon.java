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

                ((new INFUSION_MGR_Functional())).INFUSION_MGR_FunctionalSymWrapper(Boolean.parseBoolean(param[0]),
                        Boolean.parseBoolean(param[1]),
                        Integer.parseInt(param[2]),

                        Boolean.parseBoolean(param[3]),
                        Boolean.parseBoolean(param[4]),
                        Boolean.parseBoolean(param[5]),
                        Boolean.parseBoolean(param[6]),
                        Boolean.parseBoolean(param[7]),
                        Boolean.parseBoolean(param[8]),
                        Boolean.parseBoolean(param[9]),
                        Boolean.parseBoolean(param[10]),
                        Boolean.parseBoolean(param[11]),
                        Boolean.parseBoolean(param[12]),
                        Integer.parseInt(param[13]),
                        Boolean.parseBoolean(param[14]),
                        Integer.parseInt(param[15]),
                        Boolean.parseBoolean(param[16]),
                        Boolean.parseBoolean(param[17]),
                        Integer.parseInt(param[18]),
                        Integer.parseInt(param[19]),
                        Integer.parseInt(param[20]),
                        Integer.parseInt(param[21]),
                        Integer.parseInt(param[22]),
                        Integer.parseInt(param[23]),
                        Integer.parseInt(param[24]),
                        Integer.parseInt(param[25]),
                        Integer.parseInt(param[26]),
                        Integer.parseInt(param[27]),
                        Integer.parseInt(param[28]),
                        Integer.parseInt(param[29]),
                        Integer.parseInt(param[30]),
                        Integer.parseInt(param[31]),
                        Integer.parseInt(param[32]),
                        Integer.parseInt(param[33]),
                        Integer.parseInt(param[34]),
                        Integer.parseInt(param[35]),
                        Boolean.parseBoolean(param[36]),
                        Boolean.parseBoolean(param[37]),
                        Boolean.parseBoolean(param[38]),
                        Boolean.parseBoolean(param[39]),
                        Integer.parseInt(param[40]),
                        Integer.parseInt(param[41]),
                        Integer.parseInt(param[42]),


                        Integer.parseInt(param[43]),
                        Integer.parseInt(param[44]),
                        Integer.parseInt(param[45]),
                        Integer.parseInt(param[46]),
                        Integer.parseInt(param[47]),


                        Boolean.parseBoolean(param[48]),
                        Integer.parseInt(param[49]),
                        Integer.parseInt(param[50]),
                        Integer.parseInt(param[51]),
                        Boolean.parseBoolean(param[52]),

                        Integer.parseInt(param[53]),
                        Integer.parseInt(param[54]),
                        Boolean.parseBoolean(param[55]),
                        Integer.parseInt(param[56]),
                        Integer.parseInt(param[57]),


                        //second step

                        Boolean.parseBoolean(param[58]),
                        Boolean.parseBoolean(param[59]),
                        Integer.parseInt(param[60]),

                        Boolean.parseBoolean(param[61]),
                        Boolean.parseBoolean(param[62]),
                        Boolean.parseBoolean(param[63]),
                        Boolean.parseBoolean(param[64]),
                        Boolean.parseBoolean(param[65]),
                        Boolean.parseBoolean(param[66]),
                        Boolean.parseBoolean(param[67]),
                        Boolean.parseBoolean(param[68]),
                        Boolean.parseBoolean(param[69]),
                        Boolean.parseBoolean(param[70]),
                        Integer.parseInt(param[71]),
                        Boolean.parseBoolean(param[72]),
                        Integer.parseInt(param[73]),
                        Boolean.parseBoolean(param[74]),
                        Boolean.parseBoolean(param[75]),
                        Integer.parseInt(param[76]),
                        Integer.parseInt(param[77]),
                        Integer.parseInt(param[78]),
                        Integer.parseInt(param[79]),
                        Integer.parseInt(param[80]),
                        Integer.parseInt(param[81]),
                        Integer.parseInt(param[82]),
                        Integer.parseInt(param[83]),
                        Integer.parseInt(param[84]),
                        Integer.parseInt(param[85]),
                        Integer.parseInt(param[86]),
                        Integer.parseInt(param[87]),
                        Integer.parseInt(param[88]),
                        Integer.parseInt(param[89]),
                        Integer.parseInt(param[90]),
                        Integer.parseInt(param[91]),
                        Integer.parseInt(param[92]),
                        Integer.parseInt(param[93]),
                        Boolean.parseBoolean(param[94]),
                        Boolean.parseBoolean(param[95]),
                        Boolean.parseBoolean(param[96]),
                        Boolean.parseBoolean(param[97]),
                        Integer.parseInt(param[98]),
                        Integer.parseInt(param[99]),
                        Integer.parseInt(param[100]),


                        Integer.parseInt(param[101]),
                        Integer.parseInt(param[102]),
                        Integer.parseInt(param[103]),
                        Integer.parseInt(param[104]),
                        Integer.parseInt(param[105]),


                        Boolean.parseBoolean(param[106]),
                        Integer.parseInt(param[107]),
                        Integer.parseInt(param[108]),
                        Integer.parseInt(param[109]),
                        Boolean.parseBoolean(param[110]),

                        Integer.parseInt(param[111]),
                        Integer.parseInt(param[112]),
                        Boolean.parseBoolean(param[113]),
                        Integer.parseInt(param[114]),
                        Integer.parseInt(param[115]),



                        //third step

                        Boolean.parseBoolean(param[116]),
                        Boolean.parseBoolean(param[117]),
                        Integer.parseInt(param[118]),

                        Boolean.parseBoolean(param[119]),
                        Boolean.parseBoolean(param[120]),
                        Boolean.parseBoolean(param[121]),
                        Boolean.parseBoolean(param[122]),
                        Boolean.parseBoolean(param[123]),
                        Boolean.parseBoolean(param[124]),
                        Boolean.parseBoolean(param[125]),
                        Boolean.parseBoolean(param[126]),
                        Boolean.parseBoolean(param[127]),
                        Boolean.parseBoolean(param[128]),
                        Integer.parseInt(param[129]),
                        Boolean.parseBoolean(param[130]),
                        Integer.parseInt(param[131]),
                        Boolean.parseBoolean(param[132]),
                        Boolean.parseBoolean(param[133]),
                        Integer.parseInt(param[134]),
                        Integer.parseInt(param[135]),
                        Integer.parseInt(param[136]),
                        Integer.parseInt(param[137]),
                        Integer.parseInt(param[138]),
                        Integer.parseInt(param[139]),
                        Integer.parseInt(param[140]),
                        Integer.parseInt(param[141]),
                        Integer.parseInt(param[142]),
                        Integer.parseInt(param[143]),
                        Integer.parseInt(param[144]),
                        Integer.parseInt(param[145]),
                        Integer.parseInt(param[146]),
                        Integer.parseInt(param[147]),
                        Integer.parseInt(param[148]),
                        Integer.parseInt(param[149]),
                        Integer.parseInt(param[150]),
                        Integer.parseInt(param[151]),
                        Boolean.parseBoolean(param[152]),
                        Boolean.parseBoolean(param[153]),
                        Boolean.parseBoolean(param[154]),
                        Boolean.parseBoolean(param[155]),
                        Integer.parseInt(param[156]),
                        Integer.parseInt(param[157]),
                        Integer.parseInt(param[158]),


                        Integer.parseInt(param[159]),
                        Integer.parseInt(param[160]),
                        Integer.parseInt(param[161]),
                        Integer.parseInt(param[162]),
                        Integer.parseInt(param[163]),


                        Boolean.parseBoolean(param[164]),
                        Integer.parseInt(param[165]),
                        Integer.parseInt(param[166]),
                        Integer.parseInt(param[167]),
                        Boolean.parseBoolean(param[168]),

                        Integer.parseInt(param[169]),
                        Integer.parseInt(param[170]),
                        Boolean.parseBoolean(param[171]),
                        Integer.parseInt(param[172]),
                        Integer.parseInt(param[173]),


                        //4th step
                        //
                        Boolean.parseBoolean(param[174]),
                        Boolean.parseBoolean(param[175]),
                        Integer.parseInt(param[176]),

                        Boolean.parseBoolean(param[177]),
                        Boolean.parseBoolean(param[178]),
                        Boolean.parseBoolean(param[179]),
                        Boolean.parseBoolean(param[180]),
                        Boolean.parseBoolean(param[181]),
                        Boolean.parseBoolean(param[182]),
                        Boolean.parseBoolean(param[183]),
                        Boolean.parseBoolean(param[184]),
                        Boolean.parseBoolean(param[185]),
                        Boolean.parseBoolean(param[186]),
                        Integer.parseInt(param[187]),
                        Boolean.parseBoolean(param[188]),
                        Integer.parseInt(param[189]),
                        Boolean.parseBoolean(param[190]),
                        Boolean.parseBoolean(param[191]),
                        Integer.parseInt(param[192]),
                        Integer.parseInt(param[193]),
                        Integer.parseInt(param[194]),
                        Integer.parseInt(param[195]),
                        Integer.parseInt(param[196]),
                        Integer.parseInt(param[197]),
                        Integer.parseInt(param[198]),
                        Integer.parseInt(param[199]),
                        Integer.parseInt(param[200]),
                        Integer.parseInt(param[201]),
                        Integer.parseInt(param[202]),
                        Integer.parseInt(param[203]),
                        Integer.parseInt(param[204]),
                        Integer.parseInt(param[205]),
                        Integer.parseInt(param[206]),
                        Integer.parseInt(param[207]),
                        Integer.parseInt(param[208]),
                        Integer.parseInt(param[209]),
                        Boolean.parseBoolean(param[210]),
                        Boolean.parseBoolean(param[211]),
                        Boolean.parseBoolean(param[212]),
                        Boolean.parseBoolean(param[213]),
                        Integer.parseInt(param[214]),
                        Integer.parseInt(param[215]),
                        Integer.parseInt(param[216]),


                        Integer.parseInt(param[217]),
                        Integer.parseInt(param[218]),
                        Integer.parseInt(param[219]),
                        Integer.parseInt(param[220]),
                        Integer.parseInt(param[221]),


                        Boolean.parseBoolean(param[222]),
                        Integer.parseInt(param[223]),
                        Integer.parseInt(param[224]),
                        Integer.parseInt(param[225]),
                        Boolean.parseBoolean(param[226]),

                        Integer.parseInt(param[227]),
                        Integer.parseInt(param[228]),
                        Boolean.parseBoolean(param[229]),
                        Integer.parseInt(param[230]),
                        Integer.parseInt(param[231])
                );
            }
        } catch (IOException e) {
            System.out.println("problem while reading the test case file. Failing.");
            assert false;
        }
    }
}
