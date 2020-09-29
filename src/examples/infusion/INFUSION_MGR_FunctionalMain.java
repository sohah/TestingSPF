package infusion;

// contains JR refinement over "INFUSION_MGR_FunctionalRecovered.java", without making the state symbolic yet.

public class INFUSION_MGR_FunctionalMain {


    public void DoSimSymbolic() {
        INFUSION_MGR_Functional.INFUSION_MGR_FunctionalSymWrapper(false, false, 1, false, false, false, false, false, false, false, false,
                false, false, 1, false, 1, false, false, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, false, false, false, false
                , 1, 1, 1, 1, 1, 1, 1, 1, false, 1, 1, 1, false, 1, 1, false, 1, 1,

                //second step

                false, false, 1, false, false, false, false, false, false, false, false,
                false, false, 1, false, 1, false, false, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, false, false, false, false
                , 1, 1, 1, 1, 1, 1, 1, 1, false, 1, 1, 1, false, 1, 1, false, 1, 1,

                //third step

                false, false, 1, false, false, false, false, false, false, false, false,
                false, false, 1, false, 1, false, false, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, false, false, false, false
                , 1, 1, 1, 1, 1, 1, 1, 1, false, 1, 1, 1, false, 1, 1, false, 1, 1
                );
    }

    public void DoSimSymbolic(    //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                                  boolean System_On,
                                  boolean Request_Confirm_Stop,
                                  int Log_Message_ID1,

                                  //Operator_Commands rtu_OP_CMD_IN
                                  boolean System_Start,
                                  boolean System_Stop,
                                  boolean Infusion_Initiate,
                                  boolean Infusion_Inhibit,
                                  boolean Infusion_Cancel,
                                  boolean Data_Config,
                                  boolean Next,
                                  boolean Back,
                                  boolean Cancel,
                                  boolean Keyboard,
                                  int Disable_Audio,
                                  boolean Notification_Cancel,
                                  int Configuration_Type,
                                  boolean Confirm_Stop,
                                  boolean Patient_Bolus_Request,
                                  int Patient_ID,
                                  int Drug_Name,
                                  int Drug_Concentration,
                                  int Infusion_Total_Duration,
                                  int VTBI_Total,
                                  int Flow_Rate_Basal,
                                  int Flow_Rate_Intermittent_Bolus,
                                  int Duration_Intermittent_Bolus,
                                  int Interval_Intermittent_Bolus,
                                  int Flow_Rate_Patient_Bolus,
                                  int Duration_Patient_Bolus,
                                  int Lockout_Period_Patient_Bolus,
                                  int Max_Number_of_Patient_Bolus,
                                  int Flow_Rate_KVO,
                                  int Entered_Reservoir_Volume,
                                  int Reservoir_Volume,
                                  int Configured,
                                  int Error_Message_ID,
                                  boolean Request_Config_Type,
                                  boolean Request_Confirm_Infusion_Initiate,
                                  boolean Request_Patient_Drug_Info,
                                  boolean Request_Infusion_Info,
                                  int Log_Message_ID,
                                  int Config_Timer,
                                  int Config_Mode,


                                  //Alarm_Outputs rtu_ALARM_IN
                                  int Is_Audio_Disabled,
                                  int Notification_Message,
                                  int Audio_Notification_Command,
                                  int Highest_Level_Alarm,
                                  int Log_Message_ID3,


                                  //System_Status_Outputs rtu_SYS_STAT_IN
                                  boolean Reservoir_Empty,
                                  int Reservoir_Volume2,
                                  int Volume_Infused,
                                  int Log_Message_ID2,
                                  boolean In_Therapy,

                                  //Infusion_Manager_Outputs rty_IM_OUT
                                  int Commanded_Flow_Rate,
                                  int Current_System_Mode,
                                  boolean New_Infusion,
                                  int Log_Message_ID4,
                                  int Actual_Infusion_Duration,


                                  //second step input

                                  //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                                  boolean System_On_2,
                                  boolean Request_Confirm_Stop_2,
                                  int Log_Message_ID1_2,

                                  //Operator_Commands rtu_OP_CMD_IN
                                  boolean System_Start_2,
                                  boolean System_Stop_2,
                                  boolean Infusion_Initiate_2,
                                  boolean Infusion_Inhibit_2,
                                  boolean Infusion_Cancel_2,
                                  boolean Data_Config_2,
                                  boolean Next_2,
                                  boolean Back_2,
                                  boolean Cancel_2,
                                  boolean Keyboard_2,
                                  int Disable_Audio_2,
                                  boolean Notification_Cancel_2,
                                  int Configuration_Type_2,
                                  boolean Confirm_Stop_2,
                                  boolean Patient_Bolus_Request_2,
                                  int Patient_ID_2,
                                  int Drug_Name_2,
                                  int Drug_Concentration_2,
                                  int Infusion_Total_Duration_2,
                                  int VTBI_Total_2,
                                  int Flow_Rate_Basal_2,
                                  int Flow_Rate_Intermittent_Bolus_2,
                                  int Duration_Intermittent_Bolus_2,
                                  int Interval_Intermittent_Bolus_2,
                                  int Flow_Rate_Patient_Bolus_2,
                                  int Duration_Patient_Bolus_2,
                                  int Lockout_Period_Patient_Bolus_2,
                                  int Max_Number_of_Patient_Bolus_2,
                                  int Flow_Rate_KVO_2,
                                  int Entered_Reservoir_Volume_2,
                                  int Reservoir_Volume_2,
                                  int Configured_2,
                                  int Error_Message_ID_2,
                                  boolean Request_Config_Type_2,
                                  boolean Request_Confirm_Infusion_Initiate_2,
                                  boolean Request_Patient_Drug_Info_2,
                                  boolean Request_Infusion_Info_2,
                                  int Log_Message_ID_2,
                                  int Config_Timer_2,
                                  int Config_Mode_2,


                                  //Alarm_Outputs rtu_ALARM_IN
                                  int Is_Audio_Disabled_2,
                                  int Notification_Message_2,
                                  int Audio_Notification_Command_2,
                                  int Highest_Level_Alarm_2,
                                  int Log_Message_ID3_2,


                                  //System_Status_Outputs rtu_SYS_STAT_IN
                                  boolean Reservoir_Empty_2,
                                  int Reservoir_Volume2_2,
                                  int Volume_Infused_2,
                                  int Log_Message_ID2_2,
                                  boolean In_Therapy_2,

                                  //Infusion_Manager_Outputs rty_IM_OUT
                                  int Commanded_Flow_Rate_2,
                                  int Current_System_Mode_2,
                                  boolean New_Infusion_2,
                                  int Log_Message_ID4_2,
                                  int Actual_Infusion_Duration_2,


                                  //third step

                                  //second step input

                                  //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                                  boolean System_On_3,
                                  boolean Request_Confirm_Stop_3,
                                  int Log_Message_ID1_3,

                                  //Operator_Commands rtu_OP_CMD_IN
                                  boolean System_Start_3,
                                  boolean System_Stop_3,
                                  boolean Infusion_Initiate_3,
                                  boolean Infusion_Inhibit_3,
                                  boolean Infusion_Cancel_3,
                                  boolean Data_Config_3,
                                  boolean Next_3,
                                  boolean Back_3,
                                  boolean Cancel_3,
                                  boolean Keyboard_3,
                                  int Disable_Audio_3,
                                  boolean Notification_Cancel_3,
                                  int Configuration_Type_3,
                                  boolean Confirm_Stop_3,
                                  boolean Patient_Bolus_Request_3,
                                  int Patient_ID_3,
                                  int Drug_Name_3,
                                  int Drug_Concentration_3,
                                  int Infusion_Total_Duration_3,
                                  int VTBI_Total_3,
                                  int Flow_Rate_Basal_3,
                                  int Flow_Rate_Intermittent_Bolus_3,
                                  int Duration_Intermittent_Bolus_3,
                                  int Interval_Intermittent_Bolus_3,
                                  int Flow_Rate_Patient_Bolus_3,
                                  int Duration_Patient_Bolus_3,
                                  int Lockout_Period_Patient_Bolus_3,
                                  int Max_Number_of_Patient_Bolus_3,
                                  int Flow_Rate_KVO_3,
                                  int Entered_Reservoir_Volume_3,
                                  int Reservoir_Volume_3,
                                  int Configured_3,
                                  int Error_Message_ID_3,
                                  boolean Request_Config_Type_3,
                                  boolean Request_Confirm_Infusion_Initiate_3,
                                  boolean Request_Patient_Drug_Info_3,
                                  boolean Request_Infusion_Info_3,
                                  int Log_Message_ID_3,
                                  int Config_Timer_3,
                                  int Config_Mode_3,


                                  //Alarm_Outputs rtu_ALARM_IN
                                  int Is_Audio_Disabled_3,
                                  int Notification_Message_3,
                                  int Audio_Notification_Command_3,
                                  int Highest_Level_Alarm_3,
                                  int Log_Message_ID3_3,


                                  //System_Status_Outputs rtu_SYS_STAT_IN
                                  boolean Reservoir_Empty_3,
                                  int Reservoir_Volume2_3,
                                  int Volume_Infused_3,
                                  int Log_Message_ID2_3,
                                  boolean In_Therapy_3,

                                  //Infusion_Manager_Outputs rty_IM_OUT
                                  int Commanded_Flow_Rate_3,
                                  int Current_System_Mode_3,
                                  boolean New_Infusion_3,
                                  int Log_Message_ID4_3,
                                  int Actual_Infusion_Duration_3
                                  ) {

        INFUSION_MGR_Functional.INFUSION_MGR_FunctionalSymWrapper(//Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                System_On,
                Request_Confirm_Stop,
                Log_Message_ID1,

                //Operator_Commands rtu_OP_CMD_IN
                System_Start,
                System_Stop,
                Infusion_Initiate,
                Infusion_Inhibit,
                Infusion_Cancel,
                Data_Config,
                Next,
                Back,
                Cancel,
                Keyboard,
                Disable_Audio,
                Notification_Cancel,
                Configuration_Type,
                Confirm_Stop,
                Patient_Bolus_Request,
                Patient_ID,
                Drug_Name,
                Drug_Concentration,
                Infusion_Total_Duration,
                VTBI_Total,
                Flow_Rate_Basal,
                Flow_Rate_Intermittent_Bolus,
                Duration_Intermittent_Bolus,
                Interval_Intermittent_Bolus,
                Flow_Rate_Patient_Bolus,
                Duration_Patient_Bolus,
                Lockout_Period_Patient_Bolus,
                Max_Number_of_Patient_Bolus,
                Flow_Rate_KVO,
                Entered_Reservoir_Volume,
                Reservoir_Volume,
                Configured,
                Error_Message_ID,
                Request_Config_Type,
                Request_Confirm_Infusion_Initiate,
                Request_Patient_Drug_Info,
                Request_Infusion_Info,
                Log_Message_ID,
                Config_Timer,
                Config_Mode,


                //Alarm_Outputs rtu_ALARM_IN
                Is_Audio_Disabled,
                Notification_Message,
                Audio_Notification_Command,
                Highest_Level_Alarm,
                Log_Message_ID3,


                //System_Status_Outputs rtu_SYS_STAT_IN
                Reservoir_Empty,
                Reservoir_Volume2,
                Volume_Infused,
                Log_Message_ID2,
                In_Therapy,

                //Infusion_Manager_Outputs rty_IM_OUT
                Commanded_Flow_Rate,
                Current_System_Mode,
                New_Infusion,
                Log_Message_ID4,
                Actual_Infusion_Duration,


                //second step input

                //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                System_On_2,
                Request_Confirm_Stop_2,
                Log_Message_ID1_2,

                //Operator_Commands rtu_OP_CMD_IN
                System_Start_2,
                System_Stop_2,
                Infusion_Initiate_2,
                Infusion_Inhibit_2,
                Infusion_Cancel_2,
                Data_Config_2,
                Next_2,
                Back_2,
                Cancel_2,
                Keyboard_2,
                Disable_Audio_2,
                Notification_Cancel_2,
                Configuration_Type_2,
                Confirm_Stop_2,
                Patient_Bolus_Request_2,
                Patient_ID_2,
                Drug_Name_2,
                Drug_Concentration_2,
                Infusion_Total_Duration_2,
                VTBI_Total_2,
                Flow_Rate_Basal_2,
                Flow_Rate_Intermittent_Bolus_2,
                Duration_Intermittent_Bolus_2,
                Interval_Intermittent_Bolus_2,
                Flow_Rate_Patient_Bolus_2,
                Duration_Patient_Bolus_2,
                Lockout_Period_Patient_Bolus_2,
                Max_Number_of_Patient_Bolus_2,
                Flow_Rate_KVO_2,
                Entered_Reservoir_Volume_2,
                Reservoir_Volume_2,
                Configured_2,
                Error_Message_ID_2,
                Request_Config_Type_2,
                Request_Confirm_Infusion_Initiate_2,
                Request_Patient_Drug_Info_2,
                Request_Infusion_Info_2,
                Log_Message_ID_2,
                Config_Timer_2,
                Config_Mode_2,


                //Alarm_Outputs rtu_ALARM_IN
                Is_Audio_Disabled_2,
                Notification_Message_2,
                Audio_Notification_Command_2,
                Highest_Level_Alarm_2,
                Log_Message_ID3_2,


                //System_Status_Outputs rtu_SYS_STAT_IN
                Reservoir_Empty_2,
                Reservoir_Volume2_2,
                Volume_Infused_2,
                Log_Message_ID2_2,
                In_Therapy_2,

                //Infusion_Manager_Outputs rty_IM_OUT
                Commanded_Flow_Rate_2,
                Current_System_Mode_2,
                New_Infusion_2,
                Log_Message_ID4_2,
                Actual_Infusion_Duration_2,


                //third step

                //second step input

                //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
                System_On_3,
                Request_Confirm_Stop_3,
                Log_Message_ID1_3,

                //Operator_Commands rtu_OP_CMD_IN
                System_Start_3,
                System_Stop_3,
                Infusion_Initiate_3,
                Infusion_Inhibit_3,
                Infusion_Cancel_3,
                Data_Config_3,
                Next_3,
                Back_3,
                Cancel_3,
                Keyboard_3,
                Disable_Audio_3,
                Notification_Cancel_3,
                Configuration_Type_3,
                Confirm_Stop_3,
                Patient_Bolus_Request_3,
                Patient_ID_3,
                Drug_Name_3,
                Drug_Concentration_3,
                Infusion_Total_Duration_3,
                VTBI_Total_3,
                Flow_Rate_Basal_3,
                Flow_Rate_Intermittent_Bolus_3,
                Duration_Intermittent_Bolus_3,
                Interval_Intermittent_Bolus_3,
                Flow_Rate_Patient_Bolus_3,
                Duration_Patient_Bolus_3,
                Lockout_Period_Patient_Bolus_3,
                Max_Number_of_Patient_Bolus_3,
                Flow_Rate_KVO_3,
                Entered_Reservoir_Volume_3,
                Reservoir_Volume_3,
                Configured_3,
                Error_Message_ID_3,
                Request_Config_Type_3,
                Request_Confirm_Infusion_Initiate_3,
                Request_Patient_Drug_Info_3,
                Request_Infusion_Info_3,
                Log_Message_ID_3,
                Config_Timer_3,
                Config_Mode_3,


                //Alarm_Outputs rtu_ALARM_IN
                Is_Audio_Disabled_3,
                Notification_Message_3,
                Audio_Notification_Command_3,
                Highest_Level_Alarm_3,
                Log_Message_ID3_3,


                //System_Status_Outputs rtu_SYS_STAT_IN
                Reservoir_Empty_3,
                Reservoir_Volume2_3,
                Volume_Infused_3,
                Log_Message_ID2_3,
                In_Therapy_3,

                //Infusion_Manager_Outputs rty_IM_OUT
                Commanded_Flow_Rate_3,
                Current_System_Mode_3,
                New_Infusion_3,
                Log_Message_ID4_3,
                Actual_Infusion_Duration_3
                );
    }

    public static void main(String[] args) {
        INFUSION_MGR_FunctionalMain infusionMain;
        if (args.length < 2) { // Run symbolically if no args
            infusionMain = new INFUSION_MGR_FunctionalMain();
            infusionMain.DoSimSymbolic();
        }
        // else {
        // rjcmain = new RJCMain(args[0], args[1]);
        // rjcmain.DoSim();
        // }
        else {
            infusionMain = new INFUSION_MGR_FunctionalMain();
            infusionMain.DoSimSymbolic( Boolean.parseBoolean(args[0]),
                    Boolean.parseBoolean(args[1]),
                    Integer.parseInt(args[2]),

                    Boolean.parseBoolean(args[3]),
                    Boolean.parseBoolean(args[4]),
                    Boolean.parseBoolean(args[5]),
                    Boolean.parseBoolean(args[6]),
                    Boolean.parseBoolean(args[7]),
                    Boolean.parseBoolean(args[8]),
                    Boolean.parseBoolean(args[9]),
                    Boolean.parseBoolean(args[10]),
                    Boolean.parseBoolean(args[11]),
                    Boolean.parseBoolean(args[12]),
                    Integer.parseInt(args[13]),
                    Boolean.parseBoolean(args[14]),
                    Integer.parseInt(args[15]),
                    Boolean.parseBoolean(args[16]),
                    Boolean.parseBoolean(args[17]),
                    Integer.parseInt(args[18]),
                    Integer.parseInt(args[19]),
                    Integer.parseInt(args[20]),
                    Integer.parseInt(args[21]),
                    Integer.parseInt(args[22]),
                    Integer.parseInt(args[23]),
                    Integer.parseInt(args[24]),
                    Integer.parseInt(args[25]),
                    Integer.parseInt(args[26]),
                    Integer.parseInt(args[27]),
                    Integer.parseInt(args[28]),
                    Integer.parseInt(args[29]),
                    Integer.parseInt(args[30]),
                    Integer.parseInt(args[31]),
                    Integer.parseInt(args[32]),
                    Integer.parseInt(args[33]),
                    Integer.parseInt(args[34]),
                    Integer.parseInt(args[35]),
                    Boolean.parseBoolean(args[36]),
                    Boolean.parseBoolean(args[37]),
                    Boolean.parseBoolean(args[38]),
                    Boolean.parseBoolean(args[39]),
                    Integer.parseInt(args[40]),
                    Integer.parseInt(args[41]),
                    Integer.parseInt(args[42]),


                    Integer.parseInt(args[43]),
                    Integer.parseInt(args[44]),
                    Integer.parseInt(args[45]),
                    Integer.parseInt(args[46]),
                    Integer.parseInt(args[47]),


                    Boolean.parseBoolean(args[48]),
                    Integer.parseInt(args[49]),
                    Integer.parseInt(args[50]),
                    Integer.parseInt(args[51]),
                    Boolean.parseBoolean(args[52]),

                    Integer.parseInt(args[53]),
                    Integer.parseInt(args[54]),
                    Boolean.parseBoolean(args[55]),
                    Integer.parseInt(args[56]),
                    Integer.parseInt(args[57]),




                    //second step
                    Boolean.parseBoolean(args[58]),
                    Boolean.parseBoolean(args[59]),
                    Integer.parseInt(args[60]),

                    Boolean.parseBoolean(args[61]),
                    Boolean.parseBoolean(args[62]),
                    Boolean.parseBoolean(args[63]),
                    Boolean.parseBoolean(args[64]),
                    Boolean.parseBoolean(args[65]),
                    Boolean.parseBoolean(args[66]),
                    Boolean.parseBoolean(args[67]),
                    Boolean.parseBoolean(args[68]),
                    Boolean.parseBoolean(args[69]),
                    Boolean.parseBoolean(args[70]),
                    Integer.parseInt(args[71]),
                    Boolean.parseBoolean(args[72]),
                    Integer.parseInt(args[73]),
                    Boolean.parseBoolean(args[74]),
                    Boolean.parseBoolean(args[75]),
                    Integer.parseInt(args[76]),
                    Integer.parseInt(args[77]),
                    Integer.parseInt(args[78]),
                    Integer.parseInt(args[79]),
                    Integer.parseInt(args[80]),
                    Integer.parseInt(args[81]),
                    Integer.parseInt(args[82]),
                    Integer.parseInt(args[83]),
                    Integer.parseInt(args[84]),
                    Integer.parseInt(args[85]),
                    Integer.parseInt(args[86]),
                    Integer.parseInt(args[87]),
                    Integer.parseInt(args[88]),
                    Integer.parseInt(args[89]),
                    Integer.parseInt(args[90]),
                    Integer.parseInt(args[91]),
                    Integer.parseInt(args[92]),
                    Integer.parseInt(args[93]),
                    Boolean.parseBoolean(args[94]),
                    Boolean.parseBoolean(args[95]),
                    Boolean.parseBoolean(args[96]),
                    Boolean.parseBoolean(args[97]),
                    Integer.parseInt(args[98]),
                    Integer.parseInt(args[99]),
                    Integer.parseInt(args[100]),


                    Integer.parseInt(args[101]),
                    Integer.parseInt(args[102]),
                    Integer.parseInt(args[103]),
                    Integer.parseInt(args[104]),
                    Integer.parseInt(args[105]),


                    Boolean.parseBoolean(args[106]),
                    Integer.parseInt(args[107]),
                    Integer.parseInt(args[108]),
                    Integer.parseInt(args[109]),
                    Boolean.parseBoolean(args[110]),

                    Integer.parseInt(args[111]),
                    Integer.parseInt(args[112]),
                    Boolean.parseBoolean(args[113]),
                    Integer.parseInt(args[114]),
                    Integer.parseInt(args[115]),

                    //third step


                    //second step
                    Boolean.parseBoolean(args[116]),
                    Boolean.parseBoolean(args[117]),
                    Integer.parseInt(args[118]),

                    Boolean.parseBoolean(args[119]),
                    Boolean.parseBoolean(args[120]),
                    Boolean.parseBoolean(args[121]),
                    Boolean.parseBoolean(args[122]),
                    Boolean.parseBoolean(args[123]),
                    Boolean.parseBoolean(args[124]),
                    Boolean.parseBoolean(args[125]),
                    Boolean.parseBoolean(args[126]),
                    Boolean.parseBoolean(args[127]),
                    Boolean.parseBoolean(args[128]),
                    Integer.parseInt(args[129]),
                    Boolean.parseBoolean(args[130]),
                    Integer.parseInt(args[131]),
                    Boolean.parseBoolean(args[132]),
                    Boolean.parseBoolean(args[133]),
                    Integer.parseInt(args[134]),
                    Integer.parseInt(args[135]),
                    Integer.parseInt(args[136]),
                    Integer.parseInt(args[137]),
                    Integer.parseInt(args[138]),
                    Integer.parseInt(args[139]),
                    Integer.parseInt(args[140]),
                    Integer.parseInt(args[141]),
                    Integer.parseInt(args[142]),
                    Integer.parseInt(args[143]),
                    Integer.parseInt(args[144]),
                    Integer.parseInt(args[145]),
                    Integer.parseInt(args[146]),
                    Integer.parseInt(args[147]),
                    Integer.parseInt(args[148]),
                    Integer.parseInt(args[149]),
                    Integer.parseInt(args[150]),
                    Integer.parseInt(args[151]),
                    Boolean.parseBoolean(args[152]),
                    Boolean.parseBoolean(args[153]),
                    Boolean.parseBoolean(args[154]),
                    Boolean.parseBoolean(args[155]),
                    Integer.parseInt(args[156]),
                    Integer.parseInt(args[157]),
                    Integer.parseInt(args[158]),


                    Integer.parseInt(args[156]),
                    Integer.parseInt(args[157]),
                    Integer.parseInt(args[158]),
                    Integer.parseInt(args[159]),
                    Integer.parseInt(args[160]),


                    Boolean.parseBoolean(args[161]),
                    Integer.parseInt(args[162]),
                    Integer.parseInt(args[163]),
                    Integer.parseInt(args[164]),
                    Boolean.parseBoolean(args[165]),

                    Integer.parseInt(args[166]),
                    Integer.parseInt(args[167]),
                    Boolean.parseBoolean(args[168]),
                    Integer.parseInt(args[169]),
                    Integer.parseInt(args[170])
                    );
        }
    }
}
