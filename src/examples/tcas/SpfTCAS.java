package tcas;

public class SpfTCAS {

    //free input
    public static int Cur_Vertical_Sep;
    public static int Own_Tracked_Alt;
    public static int Own_Tracked_Alt_Rate;
    public static int Other_Tracked_Alt;
    public static int Alt_Layer_Value;
    public static int Up_Separation;
    public static int Down_Separation;
    public static int Other_RAC;
    public static int Other_Capability;
    public static int Climb_Inhibit;


    //all state input
    public static int OLEV = 600;
    public static int MAXALTDIFF = 300;
    public static int MINSEP = 600;
    public static int NOZCROSS = 100;
    public static boolean High_Confidence;
    public static boolean Two_of_Three_Reports_Valid;
    static int Positive_RA_Alt_Thresh_0;
    static int Positive_RA_Alt_Thresh_1;
    static int Positive_RA_Alt_Thresh_2;
    static int Positive_RA_Alt_Thresh_3;
    public static int NO_INTENT = 0;
    public static int DO_NOT_CLIMB = 1;
    public static int DO_NOT_DESCEND = 2;
    public static int TCAS_TA = 1;
    public static int OTHER = 2;
    public static int UNRESOLVED = 0;
    public static int UPWARD_RA = 1;
    public static int DOWNWARD_RA = 2;


    //created field for output
    private static int result_alt_sep_test = 0;
    private static int alim_res = 0;

    public static void initialize() {
        Positive_RA_Alt_Thresh_0 = 400;
        Positive_RA_Alt_Thresh_1 = 500;
        Positive_RA_Alt_Thresh_2 = 640;
        Positive_RA_Alt_Thresh_3 = 740;
    }

    public static int ALIM() {
        if (Alt_Layer_Value == 0) {
            return Positive_RA_Alt_Thresh_0;
        } else if (Alt_Layer_Value == 1) {
            return Positive_RA_Alt_Thresh_1;
        } else if (Alt_Layer_Value == 2) {
            return Positive_RA_Alt_Thresh_2;
        } else {
            return Positive_RA_Alt_Thresh_3;
        }
    }

    public static int Inhibit_Biased_Climb() {
        if (Climb_Inhibit > 0) {
            int ret = Up_Separation + NOZCROSS;
            return ret;
        } else {
            return Up_Separation;
        }
    }

    public static boolean Non_Crossing_Biased_Climb() {
        int upward_preferred;
        int inhibit_biased_climb = Inhibit_Biased_Climb();
        if (inhibit_biased_climb > Down_Separation) {
            upward_preferred = 1;
        } else {
            upward_preferred = 0;
        }
        if (upward_preferred != 0) {
            int alim = ALIM();
            if (!(Down_Separation >= alim)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (!(Cur_Vertical_Sep >= MINSEP)) {
                return false;
            } else {
                int alim = ALIM();
                if (!(Up_Separation >= alim)) {
                    return false;
                } else {
                    boolean own_above_thread = Own_Above_Threat();
                    if (!own_above_thread) {
                        return false;
                    } else {
                        return true;
                    }
                }

            }
        }
    }

    public static boolean Non_Crossing_Biased_Descend() {
        int upward_preferred;
        int inhibit_biased_climb = Inhibit_Biased_Climb();
        if (inhibit_biased_climb > Down_Separation) {
            upward_preferred = 1;
        } else {
            upward_preferred = 0;
        }
        if (upward_preferred != 0) {
            int alim = ALIM();
            boolean own_below_threat = Own_Below_Threat();
            // reduction source
            if (!(Cur_Vertical_Sep >= MINSEP)) {
                return false;
            } else if (!(Down_Separation >= alim)) {
                return false;
            } else if (!own_below_threat) {
                return false;
            } else {
                return true;
            }
        } else {
            int alim = ALIM();
            boolean own_above_threat = Own_Above_Threat();
            // reduction source
            if (!(Up_Separation >= alim)) {
                return false;
            } else if (!own_above_threat) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean Own_Below_Threat() {
        boolean ret = false;
        if (Own_Tracked_Alt < Other_Tracked_Alt) {
            ret = true;
        }
        return ret;
    }

    public static boolean Own_Above_Threat() {
        boolean ret = false;
        if (Other_Tracked_Alt < Own_Tracked_Alt) {
            ret = true;
        }
        return ret;
    }

    public static int alt_assign() {
        int alt_sep = UNRESOLVED;
        boolean need_upward_RA = false;
        boolean non_crossing_biased_climb = Non_Crossing_Biased_Climb();
        if (non_crossing_biased_climb) {
            boolean own_below_threat = Own_Below_Threat(); //return symbolic temp variable
            if (own_below_threat) {
                need_upward_RA = true; //is symbolic
            }
        }
        boolean need_downward_RA = false;
        boolean non_crossing_biased_descend = Non_Crossing_Biased_Descend();
        if (non_crossing_biased_descend) {
            boolean own_above_threat = Own_Above_Threat();
            if (own_above_threat) {
                need_downward_RA = true;
            }
        }
        if (need_upward_RA) {
            if (need_downward_RA) {
                alt_sep = UNRESOLVED;
            } else {
                alt_sep = UPWARD_RA;
            }
        } else {
            if (need_downward_RA) {
                alt_sep = DOWNWARD_RA;
            } else {
                alt_sep = UNRESOLVED;
            }
        }

		/*if(need_upward_RA && need_downward_RA) alt_sep = 0;
		if(need_upward_RA && !need_downward_RA) alt_sep = 1;
		if(!need_upward_RA && need_downward_RA) alt_sep = 2;
		if(!need_upward_RA && !need_downward_RA) alt_sep = 0;*/

        return alt_sep;
    }

    public static int alt_sep_test() {
        boolean enabled = false;
        boolean tcas_equipped = false;
        boolean intent_not_known = false;
        int alt_sep = UNRESOLVED;

        if (High_Confidence) {
            if (Own_Tracked_Alt_Rate <= OLEV) {
                if (Cur_Vertical_Sep > MAXALTDIFF) {
                    enabled = true;
                }
            }
        }

        if (enabled) {
            if (Other_Capability == TCAS_TA) {
                tcas_equipped = true;
            }
            if (tcas_equipped) {
                if (Two_of_Three_Reports_Valid) {
                    if (Other_RAC == NO_INTENT) {
                        intent_not_known = true;
                    }
                }
                if (intent_not_known) {
                    alt_sep = alt_assign();
                }
            } else {
                alt_sep = alt_assign();
            }
        }

        return alt_sep;
    }

    public static void mainProcess(int Cur_Vertical_Sep, boolean High_Confidence, boolean Two_of_Three_Reports_Valid,
                                   int Own_Tracked_Alt, int Own_Tracked_Alt_Rate, int Other_Tracked_Alt,
                                   int Alt_Layer_Value, int Up_Separation, int Down_Separation, int Other_RAC, int Other_Capability, int Climb_Inhibit) {
        initialize();
        SpfTCAS.Cur_Vertical_Sep = Cur_Vertical_Sep;
        SpfTCAS.High_Confidence = High_Confidence;

        SpfTCAS.Two_of_Three_Reports_Valid = Two_of_Three_Reports_Valid;
        SpfTCAS.Own_Tracked_Alt = Own_Tracked_Alt;
        SpfTCAS.Own_Tracked_Alt_Rate = Own_Tracked_Alt_Rate;
        SpfTCAS.Other_Tracked_Alt = Other_Tracked_Alt;
        SpfTCAS.Alt_Layer_Value = Alt_Layer_Value;
        SpfTCAS.Up_Separation = Up_Separation;
        SpfTCAS.Down_Separation = Down_Separation;
        SpfTCAS.Other_RAC = Other_RAC;
        SpfTCAS.Other_Capability = Other_Capability;
        SpfTCAS.Climb_Inhibit = Climb_Inhibit;

        result_alt_sep_test = alt_sep_test();
        SpfTCAS.alim_res = ALIM();

        // MWW assertions.  These come from ACSL safety property paper: http://people.rennes.inria.fr/Arnaud.Gotlieb/CT_ATM_gotlieb.pdf


        // Prop1:
		/*assert((Up_Separation < alim_res &&
				Down_Separation < alim_res) ?
				result_alt_sep_test != DOWNWARD_RA : true);
*/
        //Prop2:
		/*assert((Up_Separation < alim_res &&
				Down_Separation >= alim_res) ?
				result_alt_sep_test != UPWARD_RA : true);
*/
        //Prop3:
		/*assert((Up_Separation > alim_res &&
				Down_Separation >= alim_res &&
				Own_Tracked_Alt > Other_Tracked_Alt) ?
				result_alt_sep_test != DOWNWARD_RA : true);*/

        //Prop4:
      /*  assert ((Up_Separation >= alim_res &&
                Down_Separation < alim_res) ?
                result_alt_sep_test != DOWNWARD_RA : true);
*/

        /***************** assertions from repairing**************/
        //assert(alim_res > 399);
    }

    public static void launch(int p1, boolean p2, boolean p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12,
                              int p13, boolean p14, boolean p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22, int p23, int p24) {

        mainProcess(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
        mainProcess(p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24);


    }

    public static void main(String[] argv) {

			launch(601, false, false, -1, 0, 0, 0, 301, 400, 0, 0, 1,
        601, false, false, -1, 0, 0, 0, 301, 400, 0, 0, 1);

    }

}
