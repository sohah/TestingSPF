package infusionTargetedDaikon;

import java.util.Optional;

public class Infusion_Result_Instance {

    int Commanded_Flow_Rate;
    int Current_System_Mode;
    boolean New_Infusion;
    int Log_Message_ID;
    int Actual_Infusion_Duration;

    static Infusion_Result_Instance step(boolean System_On,
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


        Infusion_Result_Instance infusion_result = new Infusion_Result_Instance();
        Infusion_Manager_Outputs rty_IM_OUT = INFUSION_MGR_Functional.Infusion_FunctionalDaikonInterface(System_On, Infusion_Initiate, Infusion_Inhibit, Infusion_Cancel, Patient_Bolus_Request, Infusion_Total_Duration, VTBI_Total, Flow_Rate_Basal, Flow_Rate_Intermittent_Bolus, Duration_Intermittent_Bolus, Interval_Intermittent_Bolus, Flow_Rate_Patient_Bolus, Duration_Patient_Bolus, Lockout_Period_Patient_Bolus, Max_Number_of_Patient_Bolus, Flow_Rate_KVO, Entered_Reservoir_Volume, Configured, Highest_Level_Alarm, Reservoir_Empty, Volume_Infused);


        infusion_result.Commanded_Flow_Rate = rty_IM_OUT.Commanded_Flow_Rate;
        infusion_result.Current_System_Mode = rty_IM_OUT.Current_System_Mode;
        infusion_result.New_Infusion = rty_IM_OUT.New_Infusion;
        infusion_result.Log_Message_ID = rty_IM_OUT.Log_Message_ID;
        infusion_result.Actual_Infusion_Duration = rty_IM_OUT.Actual_Infusion_Duration;

//        System.out.println("Current_System_Mode = " + infusion_result.Current_System_Mode);

//        assert(infusion_result.Current_System_Mode != 8);


        return infusion_result;
    }
}
