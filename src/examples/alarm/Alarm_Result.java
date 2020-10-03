package alarm;

class Alarm_Result {



    // output
    static int Is_Audio_Disabled;
    static int Notification_Message;
    static int Audio_Notification_Command;
    static int Highest_Level_Alarm;
    static int Log_Message_ID;


    public static void step(Infusion_Manager_Outputs rtu_IM_IN,
                            Top_Level_Mode_Outputs rtu_TLM_MODE_IN,
                            System_Monitor_Output rtu_SYS_MON_IN,
                            Log_Output rtu_LOGGING_IN, Operator_Commands rtu_OP_CMD_IN,
                            Drug_Database_Inputs rtu_DB_IN,
                            Device_Sensor_Inputs rtu_SENSOR_IN,
                            Device_Configuration_Inputs rtu_CONST_IN,
                            System_Status_Outputs rtu_SYS_STAT_IN,
                            Config_Outputs rtu_CONFIG_IN, Alarm_Outputs
                                    rty_ALARM_OUT, B_ALARM_Functional_c_T localB,
                            DW_ALARM_Functional_f_T localDW) {



/*

        rtu_TLM_MODE_IN.System_On = System_On;
        rtu_TLM_MODE_IN.Request_Confirm_Stop = Request_Confirm_Stop;
        rtu_TLM_MODE_IN.Log_Message_ID = Log_Message_ID_2;


        rtu_sys_mon_in.System_Monitor_Failed = System_Monitor_Failed;

        rtu_logging_in.Log = Log;
        rtu_logging_in.Logging_Failed = Logging_Failed;


        rtu_op_cmd_in.System_Start = System_Start;
        rtu_op_cmd_in.System_Stop = System_Stop;
        rtu_op_cmd_in.Infusion_Initiate = Infusion_Initiate;
        rtu_op_cmd_in.Infusion_Inhibit = Infusion_Inhibit;
        rtu_op_cmd_in.Infusion_Cancel = Infusion_Cancel;
        rtu_op_cmd_in.Data_Config = Data_Config;
        rtu_op_cmd_in.Next = Next;
        rtu_op_cmd_in.Back = Back;
        rtu_op_cmd_in.Cancel = Cancel;
        rtu_op_cmd_in.Keyboard = Keyboard;
        rtu_op_cmd_in.Disable_Audio = Disable_Audio;
        rtu_op_cmd_in.Notification_Cancel = Notification_Cancel;
        rtu_op_cmd_in.Configuration_Type = Configuration_Type;
        rtu_op_cmd_in.Confirm_Stop = Confirm_Stop;


        rtu_db_in.Known_Prescription = Known_Prescription;
        rtu_db_in.Drug_Name = Drug_Name1;
        rtu_db_in.Drug_Concentration_High = Drug_Concentration_High;
        rtu_db_in.Drug_Concentration_Low = Drug_Concentration_Low;
        rtu_db_in.VTBI_High = VTBI_High;
        rtu_db_in.VTBI_Low = VTBI_Low;
        rtu_db_in.Interval_Patient_Bolus = Interval_Patient_Bolus;
        rtu_db_in.Number_Max_Patient_Bolus = Number_Max_Patient_Bolus;
        rtu_db_in.Flow_Rate_KVO = Flow_Rate_KVO1;
        rtu_db_in.Flow_Rate_High = Flow_Rate_High;
        rtu_db_in.Flow_Rate_Low = Flow_Rate_Low;


        rtu_sensor_in.Flow_Rate = Flow_Rate;
        rtu_sensor_in.Flow_Rate_Not_Stable = Flow_Rate_Not_Stable;
        rtu_sensor_in.Air_In_Line = Air_In_Line;
        rtu_sensor_in.Occlusion = Occlusion;
        rtu_sensor_in.Door_Open = Door_Open;
        rtu_sensor_in.Temp = Temp;
        rtu_sensor_in.Air_Pressure = Air_Pressure;
        rtu_sensor_in.Humidity = Humidity;
        rtu_sensor_in.Battery_Depleted = Battery_Depleted;
        rtu_sensor_in.Battery_Low = Battery_Low;
        rtu_sensor_in.Battery_Unable_To_Charge = Battery_Unable_To_Charge;
        rtu_sensor_in.Supply_Voltage = Supply_Voltage;
        rtu_sensor_in.CPU_In_Error = CPU_In_Error;
        rtu_sensor_in.RTC_In_Error = RTC_In_Error;
        rtu_sensor_in.Watchdog_Interrupted = Watchdog_Interrupted;
        rtu_sensor_in.Memory_Corrupted = Memory_Corrupted;
        rtu_sensor_in.Pump_Too_Hot = Pump_Too_Hot;
        rtu_sensor_in.Pump_Overheated = Pump_Overheated;
        rtu_sensor_in.Pump_Primed = Pump_Primed;
        rtu_sensor_in.Post_Successful = Post_Successful;


        rtu_const_in.Audio_Enable_Duration = Audio_Enable_Duration;
        rtu_const_in.Audio_Level = Audio_Level;
        rtu_const_in.Config_Warning_Duration = Config_Warning_Duration;
        rtu_const_in.Empty_Reservoir = Empty_Reservoir;
        rtu_const_in.Low_Reservoir = Low_Reservoir;
        rtu_const_in.Max_Config_Duration = Max_Config_Duration;
        rtu_const_in.Max_Duration_Over_Infusion = Max_Duration_Over_Infusion;
        rtu_const_in.Max_Duration_Under_Infusion = Max_Duration_Under_Infusion;
        rtu_const_in.Max_Paused_Duration = Max_Paused_Duration;
        rtu_const_in.Max_Idle_Duration = Max_Idle_Duration;
        rtu_const_in.Tolerance_Max = Tolerance_Max;
        rtu_const_in.Tolerance_Min = Tolerance_Min;
        rtu_const_in.Log_Interval = Log_Interval;
        rtu_const_in.System_Test_Interval = System_Test_Interval;
        rtu_const_in.Max_Display_Duration = Max_Display_Duration;
        rtu_const_in.Max_Confirm_Stop_Duration = Max_Confirm_Stop_Duration;


        rtu_sys_stat_in.Reservoir_Empty = Reservoir_Empty;
        rtu_sys_stat_in.Reservoir_Volume = Reservoir_Volume1;
        rtu_sys_stat_in.Volume_Infused = Volume_Infused;
        rtu_sys_stat_in.Log_Message_ID = Log_Message_ID3;
        rtu_sys_stat_in.In_Therapy = In_Therapy;


        rtu_config_in.Patient_ID = Patient_ID;
        rtu_config_in.Drug_Name = Drug_Name2;
        rtu_config_in.Drug_Concentration = Drug_Concentration;
        rtu_config_in.Infusion_Total_Duration = Infusion_Total_Duration;
        rtu_config_in.VTBI_Total = VTBI_Total;
        rtu_config_in.Flow_Rate_Basal = Flow_Rate_Basal;
        rtu_config_in.Flow_Rate_Intermittent_Bolus = Flow_Rate_Intermittent_Bolus;
        rtu_config_in.Duration_Intermittent_Bolus = Duration_Intermittent_Bolus;
        rtu_config_in.Interval_Intermittent_Bolus = Interval_Intermittent_Bolus;
        rtu_config_in.Flow_Rate_Patient_Bolus = Flow_Rate_Patient_Bolus;
        rtu_config_in.Duration_Patient_Bolus = Duration_Patient_Bolus;
        rtu_config_in.Lockout_Period_Patient_Bolus = Lockout_Period_Patient_Bolus;
        rtu_config_in.Max_Number_of_Patient_Bolus = Max_Number_of_Patient_Bolus;
        rtu_config_in.Flow_Rate_KVO = Flow_Rate_KVO2;
        rtu_config_in.Entered_Reservoir_Volume = Entered_Reservoir_Volume;
        rtu_config_in.Reservoir_Volume = Reservoir_Volume2;
        rtu_config_in.Configured = Configured;
        rtu_config_in.Error_Message_ID = Error_Message_ID;
        rtu_config_in.Request_Config_Type = Request_Config_Type;
        rtu_config_in.Request_Confirm_Infusion_Initiate = Request_Confirm_Infusion_Initiate;
        rtu_config_in.Request_Patient_Drug_Info = Request_Patient_Drug_Info;
        rtu_config_in.Request_Infusion_Info = Request_Infusion_Info;
        rtu_config_in.Log_Message_ID = Log_Message_ID4;
        rtu_config_in.Config_Timer = Config_Timer;
        rtu_config_in.Config_Mode = Config_Mode;

*/

        ALARM_Functional.ALARM_Functional(rtu_IM_IN, rtu_TLM_MODE_IN, rtu_SYS_MON_IN, rtu_LOGGING_IN, rtu_OP_CMD_IN, rtu_DB_IN, rtu_SENSOR_IN, rtu_CONST_IN, rtu_SYS_STAT_IN, rtu_CONFIG_IN, rty_ALARM_OUT, localB, localDW);
        Is_Audio_Disabled = rty_ALARM_OUT.Is_Audio_Disabled;
        Notification_Message = rty_ALARM_OUT.Notification_Message;
        Audio_Notification_Command = rty_ALARM_OUT.Audio_Notification_Command;
        Highest_Level_Alarm = rty_ALARM_OUT.Highest_Level_Alarm;
        Log_Message_ID = rty_ALARM_OUT.Log_Message_ID;

    }
}

