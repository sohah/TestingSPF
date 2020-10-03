package infusion;

public class Infusion_Result {

    static int Commanded_Flow_Rate;
    static int Current_System_Mode;
    static boolean New_Infusion;
    static int Log_Message_ID;
    static int Actual_Infusion_Duration;

    static void step(Top_Level_Mode_Outputs rtu_TLM_MODE_IN,
                     Operator_Commands rtu_OP_CMD_IN, Patient_Inputs rtu_PATIENT_IN,
                     Config_Outputs rtu_CONFIG_IN, Alarm_Outputs rtu_ALARM_IN,
                     System_Status_Outputs rtu_SYS_STAT_IN, Infusion_Manager_Outputs rty_IM_OUT,
                     B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T localDW) {

        INFUSION_MGR_Functional.INFUSION_MGR_Functional(rtu_TLM_MODE_IN,
                rtu_OP_CMD_IN, rtu_PATIENT_IN,
                rtu_CONFIG_IN, rtu_ALARM_IN,
                rtu_SYS_STAT_IN, rty_IM_OUT,
                localB, localDW);

        Commanded_Flow_Rate = rty_IM_OUT.Commanded_Flow_Rate;
        Current_System_Mode = rty_IM_OUT.Current_System_Mode;
        New_Infusion = rty_IM_OUT.New_Infusion;
        Log_Message_ID = rty_IM_OUT.Log_Message_ID;
        Actual_Infusion_Duration = rty_IM_OUT.Actual_Infusion_Duration;
    }
}
