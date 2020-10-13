package wbs;

public class WBS_Output_Instance {

    //Outputs
    int NormalPressure_r;
    int AltPressure_r;
    int Sys_Mode;

    /*public static void launch(int pedal1, boolean auto1, boolean skid1, int pedal2, boolean auto2, boolean skid2
            , int pedal3, boolean auto3, boolean skid3
            , int pedal4, boolean auto4, boolean skid4
            , int pedal5, boolean auto5, boolean skid5){


        WBS wbs = new WBS();

        wbs.update(pedal1, auto1, skid1);
        Nor_Pressure = wbs.Nor_Pressure;
        Alt_Pressure = wbs.Alt_Pressure;
        Sys_Mode = wbs.Sys_Mode;


        wbs.update(pedal2, auto2, skid2);
        Nor_Pressure = wbs.Nor_Pressure;
        Alt_Pressure = wbs.Alt_Pressure;
        Sys_Mode = wbs.Sys_Mode;


   *//*     wbs.update(pedal3, auto3, skid3);
        Nor_Pressure = wbs.Nor_Pressure;
        Alt_Pressure = wbs.Alt_Pressure;
        Sys_Mode = wbs.Sys_Mode;


        wbs.update(pedal4, auto4, skid4);
        Nor_Pressure = wbs.Nor_Pressure;
        Alt_Pressure = wbs.Alt_Pressure;
        Sys_Mode = wbs.Sys_Mode;


        wbs.update(pedal5, auto5, skid5);
        Nor_Pressure = wbs.Nor_Pressure;
        Alt_Pressure = wbs.Alt_Pressure;
        Sys_Mode = wbs.Sys_Mode;*//*

    }*/

    public static WBS_Output_Instance update(int pedal_r, boolean autoBreak_r, boolean skid_r) {

        WBS_Output_Instance wbs_output = new WBS_Output_Instance();
        WBS.update(pedal_r, autoBreak_r, skid_r);
        wbs_output.NormalPressure_r = WBS.Nor_Pressure;
        wbs_output.AltPressure_r = WBS.Alt_Pressure;
        wbs_output.Sys_Mode = WBS.Sys_Mode;

        return wbs_output;

    }
}
