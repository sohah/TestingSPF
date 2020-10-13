package infusionTargetedDaikon;

public class Infusion_Result_static {

    static int Commanded_Flow_Rate;
    static int Current_System_Mode;
    static boolean New_Infusion;
    static int Log_Message_ID;
    static int Actual_Infusion_Duration;

    static void step(boolean System_On,
                     boolean Infusion_Initiate,
                     boolean Infusion_Inhibit,
                     boolean Infusion_Cancel,
                     boolean Patient_Bolus_Request,
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
                     int Configured,
                     int Highest_Level_Alarm,
                     boolean Reservoir_Empty,
                     int Volume_Infused) {

        Commanded_Flow_Rate = 0;
        Current_System_Mode = 0;
        New_Infusion = false;
        Log_Message_ID = 0;
        Actual_Infusion_Duration = 0;

        Infusion_Manager_Outputs rty_IM_OUT = INFUSION_MGR_Functional.Infusion_FunctionalDaikonInterface(System_On, Infusion_Initiate, Infusion_Inhibit, Infusion_Cancel, Patient_Bolus_Request, Infusion_Total_Duration, VTBI_Total, Flow_Rate_Basal, Flow_Rate_Intermittent_Bolus, Duration_Intermittent_Bolus, Interval_Intermittent_Bolus, Flow_Rate_Patient_Bolus, Duration_Patient_Bolus, Lockout_Period_Patient_Bolus, Max_Number_of_Patient_Bolus, Flow_Rate_KVO, Entered_Reservoir_Volume, Configured, Highest_Level_Alarm, Reservoir_Empty, Volume_Infused);

        Commanded_Flow_Rate = rty_IM_OUT.Commanded_Flow_Rate;
        Current_System_Mode = rty_IM_OUT.Current_System_Mode;
        New_Infusion = rty_IM_OUT.New_Infusion;
        Log_Message_ID = rty_IM_OUT.Log_Message_ID;
        Actual_Infusion_Duration = rty_IM_OUT.Actual_Infusion_Duration;

//        System.out.println("Current_System_Mode ==" + Current_System_Mode);

//        System.out.println("Current_System_Mode ==" + infusion_result.Current_System_Mode);

        /**
         * Perfect test cases for the property p9
         *     p9 = (System_On and (Highest_Level_Alarm = 4)) => ((Current_System_Mode = 1) or (Current_System_Mode = 6) or (Current_System_Mode = 7));
         */
//        assert(!(System_On && Highest_Level_Alarm==4) ||(Current_System_Mode != 1)):"property violated, Current_System_Mode = "+Current_System_Mode; // under these conditions mode can't be 1
//        assert(!(System_On && Highest_Level_Alarm==4) ||(Current_System_Mode != 6)):"property violated, Current_System_Mode = "+Current_System_Mode; // under these conditions mode can't be 6
//        assert((!(System_On && Highest_Level_Alarm==4) && ((Current_System_Mode == 1) ||(Current_System_Mode == 6)))):"property violated, Current_System_Mode = "+Current_System_Mode; // you can't find the condition false and the consequent is true
//        assert ((!(!System_On && Highest_Level_Alarm != 4) || ((Current_System_Mode != 1)))) : "property violated, Current_System_Mode = " + Current_System_Mode; // you can't find the condition false and the consequent is true
    }
}
