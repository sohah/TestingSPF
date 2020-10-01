#!/usr/bin/perl
use strict;
use warnings;
use autodie;

my $i=4; #step number
my $argStart=174;

my $j=$argStart;

print "//${i} step

  //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
         boolean System_On_${i},
            boolean Request_Confirm_Stop_${i},
            int Log_Message_ID1_${i},

            //Operator_Commands rtu_OP_CMD_IN
            boolean System_Start_${i},
            boolean System_Stop_${i},
            boolean Infusion_Initiate_${i},
            boolean Infusion_Inhibit_${i},
            boolean Infusion_Cancel_${i},
            boolean Data_Config_${i},
            boolean Next_${i},
            boolean Back_${i},
            boolean Cancel_${i},
            boolean Keyboard_${i},
            int Disable_Audio_${i},
            boolean Notification_Cancel_${i},
            int Configuration_Type_${i},
            boolean Confirm_Stop_${i},
            boolean Patient_Bolus_Request_${i},
            int Patient_ID_${i},
            int Drug_Name_${i},
            int Drug_Concentration_${i},
            int Infusion_Total_Duration_${i},
            int VTBI_Total_${i},
            int Flow_Rate_Basal_${i},
            int Flow_Rate_Intermittent_Bolus_${i},
            int Duration_Intermittent_Bolus_${i},
            int Interval_Intermittent_Bolus_${i},
            int Flow_Rate_Patient_Bolus_${i},
            int Duration_Patient_Bolus_${i},
            int Lockout_Period_Patient_Bolus_${i},
            int Max_Number_of_Patient_Bolus_${i},
            int Flow_Rate_KVO_${i},
            int Entered_Reservoir_Volume_${i},
            int Reservoir_Volume_${i},
            int Configured_${i},
            int Error_Message_ID_${i},
            boolean Request_Config_Type_${i},
            boolean Request_Confirm_Infusion_Initiate_${i},
            boolean Request_Patient_Drug_Info_${i},
            boolean Request_Infusion_Info_${i},
            int Log_Message_ID_${i},
            int Config_Timer_${i},
            int Config_Mode_${i},


            //Alarm_Outputs rtu_ALARM_IN
            int Is_Audio_Disabled_${i},
            int Notification_Message_${i},
            int Audio_Notification_Command_${i},
            int Highest_Level_Alarm_${i},
            int Log_Message_ID3_${i},


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_${i},
            int Reservoir_Volume2_${i},
            int Volume_Infused_${i},
            int Log_Message_ID2_${i},
            boolean In_Therapy_${i},

            //Infusion_Manager_Outputs rty_IM_OUT
            int Commanded_Flow_Rate_${i},
            int Current_System_Mode_${i},
            boolean New_Infusion_${i},
            int Log_Message_ID4_${i},
            int Actual_Infusion_Duration_${i}";

#print "now printing body----------------"

print"
        Top_Level_Mode_Outputs rtu_TLM_MODE_IN_${i} = new Top_Level_Mode_Outputs();
        rtu_TLM_MODE_IN_${i}.System_On = System_On_${i};
        rtu_TLM_MODE_IN_${i}.Request_Confirm_Stop = Request_Confirm_Stop_${i};
        rtu_TLM_MODE_IN_${i}.Log_Message_ID = Log_Message_ID1_${i};


        Operator_Commands rtu_OP_CMD_IN_${i} = new Operator_Commands();
        rtu_OP_CMD_IN_${i}.System_Start = System_Start_${i};
        rtu_OP_CMD_IN_${i}.System_Stop = System_Stop_${i};
        rtu_OP_CMD_IN_${i}.Infusion_Initiate = Infusion_Initiate_${i};
        rtu_OP_CMD_IN_${i}.Infusion_Inhibit = Infusion_Inhibit_${i};
        rtu_OP_CMD_IN_${i}.Infusion_Cancel = Infusion_Cancel_${i};
        rtu_OP_CMD_IN_${i}.Data_Config = Data_Config_${i};
        rtu_OP_CMD_IN_${i}.Next = Next_${i};
        rtu_OP_CMD_IN_${i}.Back = Back_${i};
        rtu_OP_CMD_IN_${i}.Cancel = Cancel_${i};
        rtu_OP_CMD_IN_${i}.Keyboard = Keyboard_${i};
        rtu_OP_CMD_IN_${i}.Disable_Audio = Disable_Audio_${i};
        rtu_OP_CMD_IN_${i}.Notification_Cancel = Notification_Cancel_${i};
        rtu_OP_CMD_IN_${i}.Configuration_Type = Configuration_Type_${i};
        rtu_OP_CMD_IN_${i}.Confirm_Stop = Confirm_Stop_${i};


        Patient_Inputs rtu_PATIENT_IN_${i} = new Patient_Inputs();
        rtu_PATIENT_IN_${i}.Patient_Bolus_Request = Patient_Bolus_Request_${i};

        Config_Outputs rtu_CONFIG_IN_${i} = new Config_Outputs();
        rtu_CONFIG_IN_${i}.Patient_ID = Patient_ID_${i};
        rtu_CONFIG_IN_${i}.Drug_Name = Drug_Name_${i};
        rtu_CONFIG_IN_${i}.Drug_Concentration = Drug_Concentration_${i};
        rtu_CONFIG_IN_${i}.Infusion_Total_Duration = Infusion_Total_Duration_${i};
        rtu_CONFIG_IN_${i}.VTBI_Total = VTBI_Total_${i};
        rtu_CONFIG_IN_${i}.Flow_Rate_Basal = Flow_Rate_Basal_${i};
        rtu_CONFIG_IN_${i}.Flow_Rate_Intermittent_Bolus = Flow_Rate_Intermittent_Bolus_${i};
        rtu_CONFIG_IN_${i}.Duration_Intermittent_Bolus = Duration_Intermittent_Bolus_${i};
        rtu_CONFIG_IN_${i}.Interval_Intermittent_Bolus = Interval_Intermittent_Bolus_${i};
        rtu_CONFIG_IN_${i}.Flow_Rate_Patient_Bolus = Flow_Rate_Patient_Bolus_${i};
        rtu_CONFIG_IN_${i}.Duration_Patient_Bolus = Duration_Patient_Bolus_${i};
        rtu_CONFIG_IN_${i}.Lockout_Period_Patient_Bolus = Lockout_Period_Patient_Bolus_${i};
        rtu_CONFIG_IN_${i}.Max_Number_of_Patient_Bolus = Max_Number_of_Patient_Bolus_${i};
        rtu_CONFIG_IN_${i}.Flow_Rate_KVO = Flow_Rate_KVO_${i};
        rtu_CONFIG_IN_${i}.Entered_Reservoir_Volume = Entered_Reservoir_Volume_${i};
        rtu_CONFIG_IN_${i}.Reservoir_Volume = Reservoir_Volume_${i};
        rtu_CONFIG_IN_${i}.Configured = Configured_${i};
        rtu_CONFIG_IN_${i}.Error_Message_ID = Error_Message_ID_${i};
        rtu_CONFIG_IN_${i}.Request_Config_Type = Request_Config_Type_${i};
        rtu_CONFIG_IN_${i}.Request_Confirm_Infusion_Initiate = Request_Confirm_Infusion_Initiate_${i};
        rtu_CONFIG_IN_${i}.Request_Patient_Drug_Info = Request_Patient_Drug_Info_${i};
        rtu_CONFIG_IN_${i}.Request_Infusion_Info = Request_Infusion_Info_${i};
        rtu_CONFIG_IN_${i}.Log_Message_ID = Log_Message_ID_${i};
        rtu_CONFIG_IN_${i}.Config_Timer = Config_Timer_${i};
        rtu_CONFIG_IN_${i}.Config_Mode = Config_Mode_${i};


        Alarm_Outputs rtu_ALARM_IN_${i} = new Alarm_Outputs();
        rtu_ALARM_IN_${i}.Is_Audio_Disabled = Is_Audio_Disabled_${i};
        rtu_ALARM_IN_${i}.Notification_Message = Notification_Message_${i};
        rtu_ALARM_IN_${i}.Audio_Notification_Command = Audio_Notification_Command_${i};
        rtu_ALARM_IN_${i}.Highest_Level_Alarm = Highest_Level_Alarm_${i};
        rtu_ALARM_IN_${i}.Log_Message_ID = Log_Message_ID3_${i};


        System_Status_Outputs rtu_SYS_STAT_IN_${i} = new System_Status_Outputs();
        rtu_SYS_STAT_IN_${i}.Reservoir_Empty = Reservoir_Empty_${i};
        rtu_SYS_STAT_IN_${i}.Reservoir_Volume = Reservoir_Volume2_${i};
        rtu_SYS_STAT_IN_${i}.Volume_Infused = Volume_Infused_${i};
        rtu_SYS_STAT_IN_${i}.Log_Message_ID = Log_Message_ID2_${i};
        rtu_SYS_STAT_IN_${i}.In_Therapy = In_Therapy_${i};



        Infusion_Manager_Outputs rty_IM_OUT_${i} = new Infusion_Manager_Outputs();
        rty_IM_OUT_${i}.Commanded_Flow_Rate = Commanded_Flow_Rate_${i};
        rty_IM_OUT_${i}.Current_System_Mode = Current_System_Mode_${i};
        rty_IM_OUT_${i}.New_Infusion = New_Infusion_${i};
        rty_IM_OUT_${i}.Log_Message_ID = Log_Message_ID4_${i};
        rty_IM_OUT_${i}.Actual_Infusion_Duration = Actual_Infusion_Duration_${i};



                //${i} step

                (0 <= Log_Message_ID1_${i}) &&
                (0 <= Disable_Audio_${i}) &&
                (0 <= Configuration_Type_${i}) &&
                (0 <= Patient_ID_${i}) &&
                (0 <= Drug_Name_${i}) &&
                (0 <= Drug_Concentration_${i}) &&
                (0 <= Infusion_Total_Duration_${i}) &&
                (0 <= VTBI_Total_${i}) &&
                (0 <= Flow_Rate_Basal_${i}) &&
                (0 <= Flow_Rate_Intermittent_Bolus_${i}) &&
                (0 <= Duration_Intermittent_Bolus_${i}) &&
                (0 <= Interval_Intermittent_Bolus_${i}) &&
                (0 <= Flow_Rate_Patient_Bolus_${i}) &&
                (0 <= Duration_Patient_Bolus_${i}) &&
                (0 <= Lockout_Period_Patient_Bolus_${i}) &&
                (0 <= Max_Number_of_Patient_Bolus_${i}) &&
                (0 <= Flow_Rate_KVO_${i}) &&
                (0 <= Entered_Reservoir_Volume_${i}) &&
                (0 <= Reservoir_Volume_${i}) &&
                (0 <= Configured_${i}) &&
                (0 <= Error_Message_ID_${i}) &&
                (0 <= Log_Message_ID_${i}) &&
                (0 <= Config_Timer_${i}) &&
                (0 <= Config_Mode_${i}) &&
                (0 <= Is_Audio_Disabled_${i}) &&
                (0 <= Notification_Message_${i}) &&
                (0 <= Audio_Notification_Command_${i}) &&
                (0 <= Highest_Level_Alarm_${i}) &&
                (0 <= Log_Message_ID3_${i}) &&
                (0 <= Reservoir_Volume2_${i}) &&
                (0 <= Volume_Infused_${i}) &&
                (0 <= Log_Message_ID2_${i}) &&
                (0 <= Commanded_Flow_Rate_${i}) &&
                (0 <= Current_System_Mode_${i}) &&
                (0 <= Log_Message_ID4_${i}) &&
                (0 <= Actual_Infusion_Duration_${i}) &&
                (Log_Message_ID1_${i} <= 255) &&
                (Disable_Audio_${i} <= 255) &&
                (Configuration_Type_${i} <= 255) &&
                (Patient_ID_${i} <= 255) &&
                (Drug_Name_${i} <= 255) &&
                (Drug_Concentration_${i} <= 255) &&
                (Infusion_Total_Duration_${i} <= 255) &&
                (VTBI_Total_${i} <= 255) &&
                (Flow_Rate_Basal_${i} <= 255) &&
                (Flow_Rate_Intermittent_Bolus_${i} <= 255) &&
                (Duration_Intermittent_Bolus_${i} <= 255) &&
                (Interval_Intermittent_Bolus_${i} <= 255) &&
                (Flow_Rate_Patient_Bolus_${i} <= 255) &&
                (Duration_Patient_Bolus_${i} <= 255) &&
                (Lockout_Period_Patient_Bolus_${i} <= 255) &&
                (Max_Number_of_Patient_Bolus_${i} <= 255) &&
                (Flow_Rate_KVO_${i} <= 255) &&
                (Entered_Reservoir_Volume_${i} <= 255) &&
                (Reservoir_Volume_${i} <= 255) &&
                (Configured_${i} <= 255) &&
                (Error_Message_ID_${i} <= 255) &&
                (Log_Message_ID_${i} <= 255) &&
                (Config_Timer_${i} <= 255) &&
                (Config_Mode_${i} <= 255) &&
                (Is_Audio_Disabled_${i} <= 255) &&
                (Notification_Message_${i} <= 255) &&
                (Audio_Notification_Command_${i} <= 255) &&
                (Highest_Level_Alarm_${i} <= 255) &&
                (Log_Message_ID3_${i} <= 255) &&
                (Reservoir_Volume2_${i} <= 255) &&
                (Volume_Infused_${i} <= 255) &&
                (Log_Message_ID2_${i} <= 255) &&
                (Commanded_Flow_Rate_${i} <= 255) &&
                (Current_System_Mode_${i} <= 255) &&
                (Log_Message_ID4_${i} <= 255) &&
                (Actual_Infusion_Duration_${i} <= 255)


          INFUSION_MGR_Functional(rtu_TLM_MODE_IN_${i},
                    rtu_OP_CMD_IN_${i}, rtu_PATIENT_IN_${i},
                    rtu_CONFIG_IN_${i}, rtu_ALARM_IN_${i},
                    rtu_SYS_STAT_IN_${i}, rty_IM_OUT_${i},
                    localB, localDW);
            ";





            print "

                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),

                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),


                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),


                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),

                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Boolean.parseBoolean(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}]),
                        Integer.parseInt(param[${\($j++)}])\n"
