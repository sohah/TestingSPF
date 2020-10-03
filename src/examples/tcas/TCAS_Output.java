package tcas;

public class TCAS_Output {
    static int result_alt_sep_test = 0;
    static int alim_res = 0;

    public static void mainProcess(int Cur_Vertical_Sep, int High_Confidence, int Two_of_Three_Reports_Valid,
                                   int Own_Tracked_Alt, int Own_Tracked_Alt_Rate, int Other_Tracked_Alt,
                                   int Alt_Layer_Value, int Up_Separation, int Down_Separation, int Other_RAC, int Other_Capability, int Climb_Inhibit) {

        SpfTCAS.mainProcess(Cur_Vertical_Sep, High_Confidence, Two_of_Three_Reports_Valid,
                Own_Tracked_Alt, Own_Tracked_Alt_Rate, Other_Tracked_Alt,
                Alt_Layer_Value, Up_Separation, Down_Separation, Other_RAC, Other_Capability, Climb_Inhibit);
        result_alt_sep_test = SpfTCAS.result_alt_sep_test;
        alim_res = SpfTCAS.alim_res;
    }
}
