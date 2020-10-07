package alarmDaikon;

class Alarm_Result {


    // output
    int Is_Audio_Disabled;
    int Notification_Message;
    int Audio_Notification_Command;
    int Highest_Level_Alarm;
    int Log_Message_ID;


    public static void step(int Commanded_Flow_Rate,
                            int Current_System_Mode,
                            boolean System_On,
                            boolean System_Monitor_Failed,
                            boolean Logging_Failed,
                            boolean Infusion_Initiate,
                            int Disable_Audio,
                            boolean Notification_Cancel,
                            int VTBI_High,
                            int Flow_Rate_High,
                            int Flow_Rate_Low,
                            int Flow_Rate,
                            boolean Flow_Rate_Not_Stable,
                            boolean Air_In_Line,
                            boolean Occlusion,
                            boolean Door_Open,
                            boolean Temp,
                            boolean Air_Pressure,
                            boolean Humidity,
                            boolean Battery_Depleted,
                            boolean Battery_Low,
                            boolean Battery_Unable_To_Charge,
                            boolean Supply_Voltage,
                            boolean CPU_In_Error,
                            boolean RTC_In_Error,
                            boolean Watchdog_Interrupted,
                            boolean Memory_Corrupted,
                            boolean Pump_Too_Hot,
                            boolean Pump_Overheated,
                            int Audio_Enable_Duration,
                            int Audio_Level,
                            int Config_Warning_Duration,
                            int Low_Reservoir,
                            int Max_Duration_Over_Infusion,
                            int Max_Duration_Under_Infusion,
                            int Max_Paused_Duration,
                            int Max_Idle_Duration,
                            int Tolerance_Max,
                            int Tolerance_Min,
                            boolean Reservoir_Empty,
                            int Reservoir_Volume,
                            int Volume_Infused,
                            boolean In_Therapy,
                            int Config_Timer) {


        Alarm_Outputs rty_ALARM_OUT = ALARM_Functional.Alarm_FunctionalDaikonInterface(Commanded_Flow_Rate, Current_System_Mode, System_On, System_Monitor_Failed, Logging_Failed, Infusion_Initiate, Disable_Audio, Notification_Cancel, VTBI_High, Flow_Rate_High, Flow_Rate_Low, Flow_Rate, Flow_Rate_Not_Stable, Air_In_Line, Occlusion, Door_Open, Temp, Air_Pressure, Humidity, Battery_Depleted, Battery_Low, Battery_Unable_To_Charge, Supply_Voltage, CPU_In_Error, RTC_In_Error, Watchdog_Interrupted, Memory_Corrupted, Pump_Too_Hot, Pump_Overheated, Audio_Enable_Duration, Audio_Level, Config_Warning_Duration, Low_Reservoir, Max_Duration_Over_Infusion, Max_Duration_Under_Infusion, Max_Paused_Duration, Max_Idle_Duration, Tolerance_Max, Tolerance_Min, Reservoir_Empty, Reservoir_Volume, Volume_Infused, In_Therapy, Config_Timer);
        Alarm_Result alarm_result = new Alarm_Result();
        alarm_result.Is_Audio_Disabled = rty_ALARM_OUT.Is_Audio_Disabled;
        alarm_result.Notification_Message = rty_ALARM_OUT.Notification_Message;
        alarm_result.Audio_Notification_Command = rty_ALARM_OUT.Audio_Notification_Command;
        alarm_result.Highest_Level_Alarm = rty_ALARM_OUT.Highest_Level_Alarm;
        alarm_result.Log_Message_ID = rty_ALARM_OUT.Log_Message_ID;
    }
}

