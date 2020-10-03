package alarm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Alarm_Daikon {

    public static void main(String[] args) {

        assert args.length == 1 : "to run you must pass the filename of the test cases file. Assumption violated. Failing";


        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.substring(line.indexOf("(") + 1, line.indexOf(")"));

                String[] param = line.split(",");


                assert param.length == 107 : "invalid number of parameters to run the program. Assumptions violated. Failing.";

                ALARM_Functional.ALARM_FunctionalSymWrapper(Integer.parseInt(param[0]),
                        Integer.parseInt(param[1]),
                        Boolean.parseBoolean(param[2]),
                        Integer.parseInt(param[3]),
                        Integer.parseInt(param[4]),


                        //Symbolic input of Top_Level_Mode_Outputs
                        Boolean.parseBoolean(param[5]),
                        Boolean.parseBoolean(param[6]),
                        Integer.parseInt(param[7]),


                        //Symbolic input of System_Monitor_Output
                        Boolean.parseBoolean(param[8]),

                        //Symbolic input of System_Monitor_Output
                        Integer.parseInt(param[9]),
                        Boolean.parseBoolean(param[10]),

                        //Symbolic input of Operator_Commands
                        Boolean.parseBoolean(param[11]),
                        Boolean.parseBoolean(param[12]),
                        Boolean.parseBoolean(param[13]),
                        Boolean.parseBoolean(param[14]),
                        Boolean.parseBoolean(param[15]),
                        Boolean.parseBoolean(param[16]),
                        Boolean.parseBoolean(param[17]),
                        Boolean.parseBoolean(param[18]),
                        Boolean.parseBoolean(param[19]),
                        Boolean.parseBoolean(param[20]),
                        Integer.parseInt(param[21]),
                        Boolean.parseBoolean(param[22]),
                        Integer.parseInt(param[23]),
                        Boolean.parseBoolean(param[24]),

                        //Symbolic input of Drug_Database_Inputs
                        Boolean.parseBoolean(param[25]),
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

                        //Symbolic input of Device_Sensor_Inputs
                        Integer.parseInt(param[36]),
                        Boolean.parseBoolean(param[37]),
                        Boolean.parseBoolean(param[38]),
                        Boolean.parseBoolean(param[39]),
                        Boolean.parseBoolean(param[40]),
                        Boolean.parseBoolean(param[41]),
                        Boolean.parseBoolean(param[42]),
                        Boolean.parseBoolean(param[43]),
                        Boolean.parseBoolean(param[44]),
                        Boolean.parseBoolean(param[45]),
                        Boolean.parseBoolean(param[46]),
                        Boolean.parseBoolean(param[47]),
                        Boolean.parseBoolean(param[48]),
                        Boolean.parseBoolean(param[49]),
                        Boolean.parseBoolean(param[50]),
                        Boolean.parseBoolean(param[51]),
                        Boolean.parseBoolean(param[52]),
                        Boolean.parseBoolean(param[53]),
                        Boolean.parseBoolean(param[54]),
                        Boolean.parseBoolean(param[55]),

                        //Symbolic input of Device_Configuration_Inputs
                        Integer.parseInt(param[56]),
                        Integer.parseInt(param[57]),
                        Integer.parseInt(param[58]),
                        Integer.parseInt(param[59]),
                        Integer.parseInt(param[60]),
                        Integer.parseInt(param[61]),
                        Integer.parseInt(param[62]),
                        Integer.parseInt(param[63]),
                        Integer.parseInt(param[64]),
                        Integer.parseInt(param[65]),
                        Integer.parseInt(param[66]),
                        Integer.parseInt(param[67]),
                        Integer.parseInt(param[68]),
                        Integer.parseInt(param[69]),
                        Integer.parseInt(param[70]),
                        Integer.parseInt(param[71]),

                        //Symbolic input of System_Status_Outputs
                        Boolean.parseBoolean(param[72]),
                        Integer.parseInt(param[73]),
                        Integer.parseInt(param[74]),
                        Integer.parseInt(param[75]),
                        Boolean.parseBoolean(param[76]),

                        //Symbolic input of Config_Outputs
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
                        Integer.parseInt(param[94]),
                        Boolean.parseBoolean(param[95]),
                        Boolean.parseBoolean(param[96]),
                        Boolean.parseBoolean(param[97]),
                        Boolean.parseBoolean(param[98]),
                        Integer.parseInt(param[99]),
                        Integer.parseInt(param[100]),
                        Integer.parseInt(param[101]),

                        //Symbolic input of Alarm_Outputs
                        Integer.parseInt(param[102]),
                        Integer.parseInt(param[103]),
                        Integer.parseInt(param[104]),
                        Integer.parseInt(param[105]),
                        Integer.parseInt(param[106]));
            }
        } catch (IOException e) {
            System.out.println("problem while reading the test case file. Failing.");
            assert false;
        }
    }
}
