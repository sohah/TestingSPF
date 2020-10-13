package tcas;

public class TCAS_Output_Static {
    static int result_alt_sep_test_s = 0;
    static int alim_res_s = 0;

    public static void mainProcess(int Cur_Vertical_Sep_s, int High_Confidence_flag_s, int Two_of_Three_Reports_Valid_flag_s,
                                   int Own_Tracked_Alt_s, int Own_Tracked_Alt_Rate_s, int Other_Tracked_Alt_s,
                                   int Alt_Layer_Value_s, int Up_Separation_s, int Down_Separation_s, int Other_RAC_s, int Other_Capability_s, int Climb_Inhibit_s) {

        SpfTCAS.mainProcess(Cur_Vertical_Sep_s, High_Confidence_flag_s, Two_of_Three_Reports_Valid_flag_s,
                Own_Tracked_Alt_s, Own_Tracked_Alt_Rate_s, Other_Tracked_Alt_s,
                Alt_Layer_Value_s, Up_Separation_s, Down_Separation_s, Other_RAC_s, Other_Capability_s, Climb_Inhibit_s);
        result_alt_sep_test_s = SpfTCAS.result_alt_sep_test;
        alim_res_s = SpfTCAS.alim_res;
    }
}
