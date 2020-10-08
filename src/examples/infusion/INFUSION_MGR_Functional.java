package infusion;

// contains JR refinement over "INFUSION_MGR_FunctionalRecovered.java", without making the state symbolic yet.

public class INFUSION_MGR_Functional {
     final static int INFUSION_MGR_Functional_IN_ACTIVE = 1;
     final static int INFUSION_MGR_Functional_IN_Basal = 1;
     final static int INFUSION_MGR_Functional_IN_IDLE = 1;
     final static int INFUSION_MGR_Functional_IN_Infusion_Manager = 1;
     final static int INFUSION_MGR_Functional_IN_Intermittent_Bolus = 2;
     final static int INFUSION_MGR_Functional_IN_LOCKOUT = 1;
     final static int INFUSION_MGR_Functional_IN_Manual_Paused_KVO = 1;
     final static int INFUSION_MGR_Functional_IN_NOT_ON = 2;
     final static int INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD = 0;
     final static int INFUSION_MGR_Functional_IN_OFF = 1;
     final static int INFUSION_MGR_Functional_IN_OFF_b = 2;
     final static int INFUSION_MGR_Functional_IN_ON = 2;
     final static int INFUSION_MGR_Functional_IN_ON_b = 3;
     final static int INFUSION_MGR_Functional_IN_PAUSED = 2;
     final static int INFUSION_MGR_Functional_IN_Patient_Bolus = 3;
     final static int INFUSION_MGR_Functional_IN_Paused_KVO = 2;
     final static int INFUSION_MGR_Functional_IN_Paused_NoKVO = 3;
     final static int INFUSION_MGR_Functional_IN_THERAPY = 2;

     public static B_INFUSION_MGR_Functional_c_T localB;

    public static DW_INFUSION_MGR_Functional_f_T localDW;

    static int INFUSION_MGR_Functional_Step_Scaling_Factor(int inputVal) {
        /* Graphical Function 'Step_Scaling_Factor': '<S1>:4016' */
        /* Transition: '<S1>:4013' */
        return inputVal;
    }

    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_writeLog(int logEvent,
                                                 B_INFUSION_MGR_Functional_c_T localB) {
        /* Graphical Function 'writeLog': '<S1>:3724' */
        /* Transition: '<S1>:3726' */
        localB.IM_OUT_Log_Message_ID = (int) logEvent;
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_resetForNewInfusion
    (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T
            localDW) {
        /* Graphical Function 'resetForNewInfusion': '<S1>:3956' */
        /* Transition: '<S1>:3958' */
        localDW.sbolus_timer = 0;
        localDW.pbolus_timer = 0;
        localDW.number_pbolus = 0;
        localDW.sbolusInter_timer = 0;
        localB.IM_OUT_Flow_Rate_Commanded = 0;
        localB.IM_OUT_Actual_Infusion_Duration = 0;
        INFUSION_MGR_Functional_writeLog(1, localB);
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_exit_internal_ACTIVE
    (DW_INFUSION_MGR_Functional_f_T localDW) {
        /* Exit Internal 'ACTIVE': '<S1>:3905' */
        /* Exit Internal 'Arbiter': '<S1>:3913' */
        localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Arbiter_c = 0;

        /* Exit Internal 'INTERMITTENT': '<S1>:3936' */
        if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_ON) {
            /* Exit 'ON': '<S1>:3941' */
            localDW.sbolus_timer++;
            localDW.sbolus_req = false;
            localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        } else {
            localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        }

        localDW.is_active_INTERMITTENT = 0;

        /* Exit Internal 'PATIENT': '<S1>:3927' */
        if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_ON_b) {
            /* Exit 'ON': '<S1>:3934' */
            localDW.pbolus_timer++;
            localDW.is_PATIENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        } else {
            localDW.is_PATIENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        }

        localDW.is_active_PATIENT = 0;

        /* Exit Internal 'BASAL': '<S1>:3907' */
        localDW.is_BASAL = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_BASAL = 0;
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_exit_internal_PAUSED
    (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T
            localDW) {
        /* Exit Internal 'PAUSED': '<S1>:3876' */
        /* Exit Internal 'Arbiter': '<S1>:3877' */

        if (localDW.is_Arbiter == INFUSION_MGR_Functional_IN_Manual_Paused_KVO) {
            /* Exit 'Manual_Paused_KVO': '<S1>:3892' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
            localB.IM_OUT_Current_System_Mode = 8;
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        } else if (localDW.is_Arbiter == INFUSION_MGR_Functional_IN_Paused_KVO) {
            /* Exit 'Paused_KVO': '<S1>:3891' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
            localB.IM_OUT_Current_System_Mode = 7;
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        } else if (localDW.is_Arbiter == INFUSION_MGR_Functional_IN_Paused_NoKVO) {
            /* Exit 'Paused_NoKVO': '<S1>:3890' */
            localB.IM_OUT_Flow_Rate_Commanded = 0;
            localB.IM_OUT_Current_System_Mode = 6;
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        } else
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


        localDW.is_active_Arbiter = 0;

        /* Exit Internal 'Manual_Paused': '<S1>:3899' */
        localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Manual_Paused = 0;

        /* Exit Internal 'Alarm_Paused': '<S1>:3893' */
        localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Alarm_Paused = 0;
    }


    static void INFUSION_MGR_Functional_TherapyExitOperations
            (B_INFUSION_MGR_Functional_c_T localB) {
        /* Graphical Function 'TherapyExitOperations': '<S1>:3953' */
        /* Transition: '<S1>:3955' */
        localB.IM_OUT_Flow_Rate_Commanded = 0;
        localB.IM_OUT_New_Infusion = false;
    }

    static int INFUSION_MGR_Functional_sbolus_trigger
            (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T localDW) {
        int sb;

        /* Graphical Function 'sbolus_trigger': '<S1>:3943' */
        /* Transition: '<S1>:3947' */
        sb = 0;

        int scalingFactor = INFUSION_MGR_Functional_Step_Scaling_Factor(localB.Interval_Intermittent_Bolus);
        int sbolusInter_timer_l = localDW.sbolusInter_timer;

        if (!(((int) sbolusInter_timer_l > scalingFactor ||
                ((int) sbolusInter_timer_l < scalingFactor)) ||
                (!((int) sbolusInter_timer_l == scalingFactor)))) {
            /* Transition: '<S1>:3949' */
            sb = 1;
            localDW.sbolusInter_timer = 0;
        } else {
            /* Transition: '<S1>:3948' */
        }

        return sb;
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_enter_internal_ACTIVE
    (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T
            localDW) {
        /* Entry Internal 'ACTIVE': '<S1>:3905' */
        localDW.is_active_BASAL = 1;

        /* Entry Internal 'BASAL': '<S1>:3907' */
        /* Transition: '<S1>:3908' */
        localDW.is_BASAL = INFUSION_MGR_Functional_IN_ON;
        localDW.is_active_PATIENT = 1;

        /* Entry Internal 'PATIENT': '<S1>:3927' */
        if (localDW.inPatientBolus) {
            /* Transition: '<S1>:3930' */
            localDW.is_PATIENT = INFUSION_MGR_Functional_IN_LOCKOUT;

            /* Entry 'LOCKOUT': '<S1>:3935' */
            localDW.lock_timer++;
        } else {
            /* Transition: '<S1>:3928' */
            localDW.is_PATIENT = INFUSION_MGR_Functional_IN_OFF_b;

            /* Entry 'OFF': '<S1>:3933' */
            localDW.pbolus_timer = 0;
            localDW.inPatientBolus = false;
        }

        localDW.is_active_INTERMITTENT = 1;

        /* Entry 'INTERMITTENT': '<S1>:3936' */
        localDW.sbolusInter_timer++;

        /* Entry Internal 'INTERMITTENT': '<S1>:3936' */
        /* Transition: '<S1>:3937' */
        localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_OFF;

        /* Entry 'OFF': '<S1>:3940' */
        localDW.sbolus_timer = 0;
        localDW.sbolus_req = false;
        localDW.sbolus_req = (INFUSION_MGR_Functional_sbolus_trigger(localB, localDW)
                != 0);
        localDW.is_active_Arbiter_c = 1;

        /* Entry Internal 'Arbiter': '<S1>:3913' */
        /* Transition: '<S1>:3916' */
        if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_ON_b) {
            /* Transition: '<S1>:3917' */
            localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Patient_Bolus;

            /* Entry 'Patient_Bolus': '<S1>:3924' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Patient_Bolus;
            localB.IM_OUT_Current_System_Mode = 4;
        } else if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_ON) {
            /* Transition: '<S1>:3918' */
            localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Intermittent_Bolus;

            /* Entry 'Intermittent_Bolus': '<S1>:3925' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Intermittent_Bolus;
            localB.IM_OUT_Current_System_Mode = 3;
        } else {
            /* Transition: '<S1>:3919' */
            localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Basal;

            /* Entry 'Basal': '<S1>:3926' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Basal;
            localB.IM_OUT_Current_System_Mode = 2;
        }
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static  void INFUSION_MGR_Functional_enter_internal_PAUSED
    (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T
            localDW) {
        /* Entry Internal 'PAUSED': '<S1>:3876' */
        localDW.is_active_Alarm_Paused = 1;

        /* Entry Internal 'Alarm_Paused': '<S1>:3893' */
        if (localB.Highest_Level_Alarm >= 3) {
            /* Transition: '<S1>:3964' */
            localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_ON;
        } else {
            /* Transition: '<S1>:3894' */
            localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_OFF;
        }

        localDW.is_active_Manual_Paused = 1;

        /* Entry Internal 'Manual_Paused': '<S1>:3899' */
        if (localB.Infusion_Inhibit) {
            /* Transition: '<S1>:3965' */
            localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_ON;
        } else {
            /* Transition: '<S1>:3900' */
            localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_OFF;
        }

        localDW.is_active_Arbiter = 1;

        /* Entry Internal 'Arbiter': '<S1>:3877' */
        /* Transition: '<S1>:3881' */
        int is_Alarm_Paused_l = localDW.is_Alarm_Paused;
        int Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
        if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 4)) {
            /* Transition: '<S1>:3882' */
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_NoKVO;

            /* Entry 'Paused_NoKVO': '<S1>:3890' */
            localB.IM_OUT_Flow_Rate_Commanded = 0;
            localB.IM_OUT_Current_System_Mode = 6;
        } else if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 3)) {
            /* Transition: '<S1>:3884' */
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_KVO;

            /* Entry 'Paused_KVO': '<S1>:3891' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
            localB.IM_OUT_Current_System_Mode = 7;
        } else {
            /* Transition: '<S1>:3883' */
            localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Manual_Paused_KVO;

            /* Entry 'Manual_Paused_KVO': '<S1>:3892' */
            localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
            localB.IM_OUT_Current_System_Mode = 8;
        }
    }


    /* Function for Chart: '<Root>/Infusion Manager Sub-System' */
    static void INFUSION_MGR_Functional_resetAllInfusionDetails
    (B_INFUSION_MGR_Functional_c_T localB, DW_INFUSION_MGR_Functional_f_T
            localDW) {
        /* Graphical Function 'resetAllInfusionDetails': '<S1>:3959' */
        /* Transition: '<S1>:3961' */
        INFUSION_MGR_Functional_resetForNewInfusion(localB, localDW);
        localDW.lock_timer = 0;
        localDW.inPatientBolus = false;
        localDW.number_pbolus = 0;
    }

    static void INFUSION_MGR_Functional_THERAPY(B_INFUSION_MGR_Functional_c_T
                                                        localB, DW_INFUSION_MGR_Functional_f_T localDW) {
        //DB_prinTF("1: %2x %2x ",localB.Infusion_Initiate,localB.Reservoir_Empty);

        /* During 'THERAPY': '<S1>:3867' */
        boolean Infusion_Initiate_l = localB.Infusion_Initiate;
        boolean Reservoir_Empty_l = localB.Reservoir_Empty;
        int Configured_l = localB.Configured;
        boolean Infusion_Cancel_l = localB.Infusion_Cancel;

        if ((Infusion_Initiate_l && Reservoir_Empty_l) ||
                (Configured_l < 1) || Infusion_Cancel_l) {
            /* Transition: '<S1>:3987' */
            /* Exit Internal 'THERAPY': '<S1>:3867' */
            if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_ACTIVE) {
                INFUSION_MGR_Functional_exit_internal_ACTIVE(localDW);
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
            } else if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_PAUSED) {
                INFUSION_MGR_Functional_exit_internal_PAUSED(localB, localDW);
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
            } else
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


            /* Exit 'THERAPY': '<S1>:3867' */
            INFUSION_MGR_Functional_TherapyExitOperations(localB);
            localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_IDLE;

            /* Entry 'IDLE': '<S1>:3866' */
            localB.IM_OUT_Current_System_Mode = 1;
            localB.IM_OUT_Flow_Rate_Commanded = 0;
            INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
        } else if (Infusion_Initiate_l && (Configured_l == 1) &&
                Reservoir_Empty_l) {
            /* Transition: '<S1>:3861' */
            INFUSION_MGR_Functional_resetForNewInfusion(localB, localDW);

            /* Transition: '<S1>:3863' */
            localB.IM_OUT_New_Infusion = true;

            /* Exit Internal 'THERAPY': '<S1>:3867' */
            if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_ACTIVE) {
                INFUSION_MGR_Functional_exit_internal_ACTIVE(localDW);
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
            } else if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_PAUSED) {
                INFUSION_MGR_Functional_exit_internal_PAUSED(localB, localDW);
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
            } else
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


            /* Exit 'THERAPY': '<S1>:3867' */
            INFUSION_MGR_Functional_TherapyExitOperations(localB);
            localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_THERAPY;

            /* Entry Internal 'THERAPY': '<S1>:3867' */
            boolean Infusion_Inhibit_l = localB.Infusion_Inhibit;
            int Highest_Level_Alarm_l = localB.Highest_Level_Alarm;

            if (Infusion_Inhibit_l || (Highest_Level_Alarm_l >= 3)) {
                /* Transition: '<S1>:3994' */
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_PAUSED;
                INFUSION_MGR_Functional_enter_internal_PAUSED(localB, localDW);
            } else {
                /* Transition: '<S1>:3875' */
                localDW.is_THERAPY = INFUSION_MGR_Functional_IN_ACTIVE;
                INFUSION_MGR_Functional_enter_internal_ACTIVE(localB, localDW);
            }
        } else {
            int IM_OUT_Actual_Infusion_Duration_l = localB.IM_OUT_Actual_Infusion_Duration;
            int Volume_Infused_l = localB.Volume_Infused;
            int VTBI_Total_l = localB.VTBI_Total;
            int scalingFactor = INFUSION_MGR_Functional_Step_Scaling_Factor((int) (localB.Infusion_Total_Duration - 1));
            if (((int) IM_OUT_Actual_Infusion_Duration_l >= scalingFactor) || (Volume_Infused_l >= VTBI_Total_l)) {
                /* Transition: '<S1>:3865' */
                /* Exit Internal 'THERAPY': '<S1>:3867' */

                if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_ACTIVE) {
                    INFUSION_MGR_Functional_exit_internal_ACTIVE(localDW);
                    localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
                } else if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_PAUSED) {
                    INFUSION_MGR_Functional_exit_internal_PAUSED(localB, localDW);
                    localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
                } else
                    localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


                /* Exit 'THERAPY': '<S1>:3867' */
                INFUSION_MGR_Functional_TherapyExitOperations(localB);
                localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_IDLE;

                /* Entry 'IDLE': '<S1>:3866' */
                localB.IM_OUT_Current_System_Mode = 1;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
                INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
            } else {
                localB.IM_OUT_New_Infusion = false;
                if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_ACTIVE) {
                    /* During 'ACTIVE': '<S1>:3905' */
                    boolean Infusion_Inhibit_l = localB.Infusion_Inhibit;
                    int Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                    if (Infusion_Inhibit_l || (Highest_Level_Alarm_l >= 3)) {
                        /* Transition: '<S1>:3871' */
                        INFUSION_MGR_Functional_exit_internal_ACTIVE(localDW);
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_PAUSED;
                        INFUSION_MGR_Functional_enter_internal_PAUSED(localB, localDW);
                    } else {
                        /* During 'BASAL': '<S1>:3907' */
                        if (localDW.is_BASAL == INFUSION_MGR_Functional_IN_OFF) {
                            /* During 'OFF': '<S1>:3912' */
                            if (localB.Infusion_Initiate) {
                                /* Transition: '<S1>:3909' */
                                localDW.is_BASAL = INFUSION_MGR_Functional_IN_ON;
                            }
                        } else {
                            /* During 'ON': '<S1>:3911' */
                            scalingFactor =
                                    INFUSION_MGR_Functional_Step_Scaling_Factor((int) (localB.Infusion_Total_Duration - 1));
                            if ((int) localB.IM_OUT_Actual_Infusion_Duration >= scalingFactor) {
                                /* Transition: '<S1>:3910' */
                                localDW.is_BASAL = INFUSION_MGR_Functional_IN_OFF;
                            }
                        }

                        /* During 'PATIENT': '<S1>:3927' */

                        if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_LOCKOUT) {
                            /* During 'LOCKOUT': '<S1>:3935' */
                            scalingFactor = INFUSION_MGR_Functional_Step_Scaling_Factor((int)
                                    (localB.Lockout_Period_Patient_Bolus - 1));
                            if ((int) localDW.lock_timer >= scalingFactor) {
                                /* Transition: '<S1>:3931' */
                                localDW.is_PATIENT = INFUSION_MGR_Functional_IN_OFF_b;
                                /* Entry 'OFF': '<S1>:3933' */
                                localDW.pbolus_timer = 0;
                                localDW.inPatientBolus = false;
                            } else {
                                localDW.lock_timer++;
                            }
                        } else if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_OFF_b) {
                            /* During 'OFF': '<S1>:3933' */
                            boolean Patient_Bolus_Request_l = localB.Patient_Bolus_Request;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            int number_pbolus_l = localDW.number_pbolus;
                            int Max_Number_of_Patient_Bolus_l = localB.Max_Number_of_Patient_Bolus;

                            if (Patient_Bolus_Request_l && (Highest_Level_Alarm_l < 2) && (number_pbolus_l < Max_Number_of_Patient_Bolus_l)) {
                                /* Transition: '<S1>:3929' */
                                localDW.is_PATIENT = INFUSION_MGR_Functional_IN_ON_b;

                                /* Entry 'ON': '<S1>:3934' */
                                localDW.number_pbolus++;
                                localDW.inPatientBolus = true;
                                localDW.pbolus_timer++;
                            }
                        } else {
                            /* During 'ON': '<S1>:3934' */
                            scalingFactor = INFUSION_MGR_Functional_Step_Scaling_Factor((int) (localB.Duration_Patient_Bolus - 1));
                            int pbolus_timer_l = localDW.pbolus_timer;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            if (((int) pbolus_timer_l >= scalingFactor) ||
                                    (Highest_Level_Alarm_l == 2)) {
                                /* Transition: '<S1>:3932' */
                                localDW.lock_timer = 0;

                                /* Exit 'ON': '<S1>:3934' */
                                localDW.pbolus_timer++;
                                localDW.is_PATIENT = INFUSION_MGR_Functional_IN_LOCKOUT;

                                /* Entry 'LOCKOUT': '<S1>:3935' */
                                localDW.lock_timer++;
                            } else {
                                localDW.pbolus_timer++;
                            }
                        }


                        /* During 'INTERMITTENT': '<S1>:3936' */
                        localDW.sbolusInter_timer++;
                        if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_OFF) {
                            /* During 'OFF': '<S1>:3940' */
                            boolean sbolus_req_l = localDW.sbolus_req;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;

                            if (sbolus_req_l && (Highest_Level_Alarm_l < 2)) {
                                /* Transition: '<S1>:3938' */
                                localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_ON;
                            } else {
                                localDW.sbolus_req = (INFUSION_MGR_Functional_sbolus_trigger
                                        (localB, localDW) != 0);
                            }
                        } else {
                            /* During 'ON': '<S1>:3941' */
                            scalingFactor = INFUSION_MGR_Functional_Step_Scaling_Factor((int) (localB.Duration_Intermittent_Bolus - 1));
                            int sbolus_timer_l = localDW.sbolus_timer;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            if (((int) sbolus_timer_l >= scalingFactor) ||
                                    (Highest_Level_Alarm_l == 2)) {
                                /* Transition: '<S1>:3939' */
                                /* Exit 'ON': '<S1>:3941' */
                                localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_OFF;

                                /* Entry 'OFF': '<S1>:3940' */
                                localDW.sbolus_timer = 0;
                                localDW.sbolus_req = false;
                                localDW.sbolus_req = (INFUSION_MGR_Functional_sbolus_trigger
                                        (localB, localDW) != 0);
                            } else {
                                localDW.sbolus_timer++;
                                localDW.sbolus_req = false;
                            }
                        }

                        /* During 'Arbiter': '<S1>:3913' */
                        if (localDW.is_Arbiter_d == INFUSION_MGR_Functional_IN_Basal) {
                            /* During 'Basal': '<S1>:3926' */
                            /* Transition: '<S1>:3923' */
                            /* Transition: '<S1>:3920' */
                            localB.IM_OUT_Actual_Infusion_Duration++;

                            /* Transition: '<S1>:4002' */
                            if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_ON_b) {
                                /* Transition: '<S1>:3917' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Patient_Bolus;

                                /* Entry 'Patient_Bolus': '<S1>:3924' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Patient_Bolus;
                                localB.IM_OUT_Current_System_Mode = 4;
                            } else if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_ON) {
                                /* Transition: '<S1>:3918' */
                                localDW.is_Arbiter_d =
                                        INFUSION_MGR_Functional_IN_Intermittent_Bolus;

                                /* Entry 'Intermittent_Bolus': '<S1>:3925' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Intermittent_Bolus;
                                localB.IM_OUT_Current_System_Mode = 3;
                            } else {
                                /* Transition: '<S1>:3919' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Basal;

                                /* Entry 'Basal': '<S1>:3926' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Basal;
                                localB.IM_OUT_Current_System_Mode = 2;
                            }
                        } else if (localDW.is_Arbiter_d == INFUSION_MGR_Functional_IN_Intermittent_Bolus) {
                            /* During 'Intermittent_Bolus': '<S1>:3925' */
                            /* Transition: '<S1>:3922' */
                            /* Transition: '<S1>:3920' */
                            localB.IM_OUT_Actual_Infusion_Duration++;

                            /* Transition: '<S1>:4002' */
                            if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_ON_b) {
                                /* Transition: '<S1>:3917' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Patient_Bolus;

                                /* Entry 'Patient_Bolus': '<S1>:3924' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Patient_Bolus;
                                localB.IM_OUT_Current_System_Mode = 4;
                            } else if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_ON) {
                                /* Transition: '<S1>:3918' */
                                localDW.is_Arbiter_d =
                                        INFUSION_MGR_Functional_IN_Intermittent_Bolus;

                                /* Entry 'Intermittent_Bolus': '<S1>:3925' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Intermittent_Bolus;
                                localB.IM_OUT_Current_System_Mode = 3;
                            } else {
                                /* Transition: '<S1>:3919' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Basal;

                                /* Entry 'Basal': '<S1>:3926' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Basal;
                                localB.IM_OUT_Current_System_Mode = 2;
                            }
                        } else {
                            /* During 'Patient_Bolus': '<S1>:3924' */
                            /* Transition: '<S1>:3921' */
                            /* Transition: '<S1>:3920' */
                            localB.IM_OUT_Actual_Infusion_Duration++;

                            /* Transition: '<S1>:4002' */
                            if (localDW.is_PATIENT == INFUSION_MGR_Functional_IN_ON_b) {
                                /* Transition: '<S1>:3917' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Patient_Bolus;

                                /* Entry 'Patient_Bolus': '<S1>:3924' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Patient_Bolus;
                                localB.IM_OUT_Current_System_Mode = 4;
                            } else if (localDW.is_INTERMITTENT == INFUSION_MGR_Functional_IN_ON) {
                                /* Transition: '<S1>:3918' */
                                localDW.is_Arbiter_d =
                                        INFUSION_MGR_Functional_IN_Intermittent_Bolus;

                                /* Entry 'Intermittent_Bolus': '<S1>:3925' */
                                localB.IM_OUT_Flow_Rate_Commanded =
                                        localB.Flow_Rate_Intermittent_Bolus;
                                localB.IM_OUT_Current_System_Mode = 3;
                            } else {
                                /* Transition: '<S1>:3919' */
                                localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_Basal;

                                /* Entry 'Basal': '<S1>:3926' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_Basal;
                                localB.IM_OUT_Current_System_Mode = 2;
                            }
                        }
                    }
                } else {
                    /* During 'PAUSED': '<S1>:3876' */
                    Infusion_Initiate_l = localB.Infusion_Initiate;
                    int Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                    boolean Infusion_Inhibit_l = localB.Infusion_Inhibit;
                    if (Infusion_Initiate_l && (Highest_Level_Alarm_l < 3) && (!Infusion_Inhibit_l)) {
                        /* Transition: '<S1>:3870' */
                        INFUSION_MGR_Functional_exit_internal_PAUSED(localB, localDW);
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_ACTIVE;
                        INFUSION_MGR_Functional_enter_internal_ACTIVE(localB, localDW);
                    } else {
                        /* During 'Alarm_Paused': '<S1>:3893' */
                        if (localDW.is_Alarm_Paused == INFUSION_MGR_Functional_IN_OFF) {
                            /* During 'OFF': '<S1>:3897' */
                            if (localB.Highest_Level_Alarm >= 3) {
                                /* Transition: '<S1>:3895' */
                                localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_ON;
                            }
                        } else {
                            /* During 'ON': '<S1>:3898' */
                            Infusion_Initiate_l = localB.Infusion_Initiate;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            if (Infusion_Initiate_l && (Highest_Level_Alarm_l < 3)) {
                                /* Transition: '<S1>:3896' */
                                localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_OFF;
                            }
                        }

                        /* During 'Manual_Paused': '<S1>:3899' */
                        if (localDW.is_Manual_Paused == INFUSION_MGR_Functional_IN_OFF) {
                            /* During 'OFF': '<S1>:3903' */
                            if (localB.Infusion_Inhibit) {
                                /* Transition: '<S1>:3901' */
                                localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_ON;
                            }
                        } else {
                            /* During 'ON': '<S1>:3904' */
                            Infusion_Initiate_l = localB.Infusion_Initiate;
                            Infusion_Inhibit_l = localB.Infusion_Inhibit;
                            if (Infusion_Initiate_l && (!Infusion_Inhibit_l)) {
                                /* Transition: '<S1>:3902' */
                                localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_OFF;
                            }
                        }

                        /* During 'Arbiter': '<S1>:3877' */
                        if (localDW.is_Arbiter == INFUSION_MGR_Functional_IN_Manual_Paused_KVO) {
                            /* During 'Manual_Paused_KVO': '<S1>:3892' */
                            /* Transition: '<S1>:3888' */
                            /* Transition: '<S1>:3889' */
                            /* Transition: '<S1>:3885' */
                            int is_Alarm_Paused_l = localDW.is_Alarm_Paused;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;
                            if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 4)) {
                                /* Transition: '<S1>:3882' */
                                /* Exit 'Manual_Paused_KVO': '<S1>:3892' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_NoKVO;

                                /* Entry 'Paused_NoKVO': '<S1>:3890' */
                                localB.IM_OUT_Flow_Rate_Commanded = 0;
                                localB.IM_OUT_Current_System_Mode = 6;
                            } else if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 3)) {
                                /* Transition: '<S1>:3884' */
                                /* Exit 'Manual_Paused_KVO': '<S1>:3892' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_KVO;

                                /* Entry 'Paused_KVO': '<S1>:3891' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 7;
                            } else {
                                /* Transition: '<S1>:3883' */
                                /* Exit 'Manual_Paused_KVO': '<S1>:3892' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Manual_Paused_KVO;

                                /* Entry 'Manual_Paused_KVO': '<S1>:3892' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 8;
                            }
                        } else if (localDW.is_Arbiter == INFUSION_MGR_Functional_IN_Paused_KVO) {
                            int is_Alarm_Paused_l = localDW.is_Alarm_Paused;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;

                            /* During 'Paused_KVO': '<S1>:3891' */
                            /* Transition: '<S1>:3887' */
                            /* Transition: '<S1>:3889' */
                            /* Transition: '<S1>:3885' */
                            if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 4)) {
                                /* Transition: '<S1>:3882' */
                                /* Exit 'Paused_KVO': '<S1>:3891' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_NoKVO;

                                /* Entry 'Paused_NoKVO': '<S1>:3890' */
                                localB.IM_OUT_Flow_Rate_Commanded = 0;
                                localB.IM_OUT_Current_System_Mode = 6;
                            } else if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 3)) {
                                /* Transition: '<S1>:3884' */
                                /* Exit 'Paused_KVO': '<S1>:3891' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_KVO;

                                /* Entry 'Paused_KVO': '<S1>:3891' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 7;
                            } else {
                                /* Transition: '<S1>:3883' */
                                /* Exit 'Paused_KVO': '<S1>:3891' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Manual_Paused_KVO;

                                /* Entry 'Manual_Paused_KVO': '<S1>:3892' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 8;
                            }
                        } else {
                            /* During 'Paused_NoKVO': '<S1>:3890' */
                            /* Transition: '<S1>:3886' */
                            /* Transition: '<S1>:3889' */
                            /* Transition: '<S1>:3885' */
                            int is_Alarm_Paused_l = localDW.is_Alarm_Paused;
                            Highest_Level_Alarm_l = localB.Highest_Level_Alarm;

                            if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 4)) {
                                /* Transition: '<S1>:3882' */
                                /* Exit 'Paused_NoKVO': '<S1>:3890' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_NoKVO;

                                /* Entry 'Paused_NoKVO': '<S1>:3890' */
                                localB.IM_OUT_Flow_Rate_Commanded = 0;
                                localB.IM_OUT_Current_System_Mode = 6;
                            } else if ((is_Alarm_Paused_l == INFUSION_MGR_Functional_IN_ON) && (Highest_Level_Alarm_l == 3)) {
                                /* Transition: '<S1>:3884' */
                                /* Exit 'Paused_NoKVO': '<S1>:3890' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Paused_KVO;

                                /* Entry 'Paused_KVO': '<S1>:3891' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 7;
                            } else {
                                /* Transition: '<S1>:3883' */
                                /* Exit 'Paused_NoKVO': '<S1>:3890' */
                                localDW.is_Arbiter = INFUSION_MGR_Functional_IN_Manual_Paused_KVO;

                                /* Entry 'Manual_Paused_KVO': '<S1>:3892' */
                                localB.IM_OUT_Flow_Rate_Commanded = localB.Flow_Rate_KVO;
                                localB.IM_OUT_Current_System_Mode = 8;
                            }
                        }
                    }
                }
            }
        }

    }


    /* Initial conditions for referenced model: 'INFUSION_MGR_Functional' */
    static void INFUSION_MGR_Functional_Init(B_INFUSION_MGR_Functional_c_T localB,
                                             DW_INFUSION_MGR_Functional_f_T localDW) {
        /* InitializeConditions for Chart: '<Root>/Infusion Manager Sub-System' */
        localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Arbiter_c = 0;
        localDW.is_Arbiter_d = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_BASAL = 0;
        localDW.is_BASAL = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_INTERMITTENT = 0;
        localDW.is_INTERMITTENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_PATIENT = 0;
        localDW.is_PATIENT = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Alarm_Paused = 0;
        localDW.is_Alarm_Paused = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Arbiter = 0;
        localDW.is_Arbiter = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_Manual_Paused = 0;
        localDW.is_Manual_Paused = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.is_active_c2_INFUSION_MGR_Functional = 0;
        localDW.is_c2_INFUSION_MGR_Functional =
                INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
        localDW.sbolus_req = false;
        localDW.sbolus_timer = 0;
        localDW.pbolus_timer = 0;
        localDW.lock_timer = 0;
        localDW.number_pbolus = 0;
        localDW.inPatientBolus = false;
        localDW.sbolusInter_timer = 0;
        localB.IM_OUT_Flow_Rate_Commanded = 0;
        localB.IM_OUT_Current_System_Mode = 0;
        localB.IM_OUT_New_Infusion = false;
        localB.IM_OUT_Log_Message_ID = 0;
        localB.IM_OUT_Actual_Infusion_Duration = 0;
    }


    public static Infusion_Manager_Outputs Infusion_FunctionalDaikonInterface(boolean System_On ,
                                                                              boolean Infusion_Initiate ,
                                                                              boolean Infusion_Inhibit ,
                                                                              boolean Infusion_Cancel ,
                                                                              boolean Patient_Bolus_Request ,
                                                                              int Infusion_Total_Duration ,
                                                                              int VTBI_Total ,
                                                                              int Flow_Rate_Basal ,
                                                                              int Flow_Rate_Intermittent_Bolus ,
                                                                              int Duration_Intermittent_Bolus ,
                                                                              int Interval_Intermittent_Bolus ,
                                                                              int Flow_Rate_Patient_Bolus ,
                                                                              int Duration_Patient_Bolus ,
                                                                              int Lockout_Period_Patient_Bolus ,
                                                                              int Max_Number_of_Patient_Bolus ,
                                                                              int Flow_Rate_KVO ,
                                                                              int Entered_Reservoir_Volume ,
                                                                              int Configured ,
                                                                              int Highest_Level_Alarm ,
                                                                              boolean     Reservoir_Empty ,
                                                                              int Volume_Infused ){
        Top_Level_Mode_Outputs rtu_TLM_MODE_IN = new Top_Level_Mode_Outputs();
        rtu_TLM_MODE_IN.System_On = System_On;


        Operator_Commands rtu_OP_CMD_IN = new Operator_Commands();
        rtu_OP_CMD_IN.Infusion_Initiate = Infusion_Initiate;
        rtu_OP_CMD_IN.Infusion_Inhibit = Infusion_Inhibit;
        rtu_OP_CMD_IN.Infusion_Cancel = Infusion_Cancel;

        Patient_Inputs rtu_PATIENT_IN = new Patient_Inputs();
        rtu_PATIENT_IN.Patient_Bolus_Request = Patient_Bolus_Request;



        Config_Outputs rtu_CONFIG_IN = new Config_Outputs();
        rtu_CONFIG_IN.Infusion_Total_Duration = Infusion_Total_Duration;
        rtu_CONFIG_IN.VTBI_Total = VTBI_Total;
        rtu_CONFIG_IN.Flow_Rate_Basal = Flow_Rate_Basal;
        rtu_CONFIG_IN.Flow_Rate_Intermittent_Bolus = Flow_Rate_Intermittent_Bolus;
        rtu_CONFIG_IN.Duration_Intermittent_Bolus = Duration_Intermittent_Bolus;
        rtu_CONFIG_IN.Interval_Intermittent_Bolus = Interval_Intermittent_Bolus;
        rtu_CONFIG_IN.Flow_Rate_Patient_Bolus = Flow_Rate_Patient_Bolus;
        rtu_CONFIG_IN.Duration_Patient_Bolus = Duration_Patient_Bolus;
        rtu_CONFIG_IN.Lockout_Period_Patient_Bolus = Lockout_Period_Patient_Bolus;
        rtu_CONFIG_IN.Max_Number_of_Patient_Bolus = Max_Number_of_Patient_Bolus;
        rtu_CONFIG_IN.Flow_Rate_KVO = Flow_Rate_KVO;
        rtu_CONFIG_IN.Entered_Reservoir_Volume = Entered_Reservoir_Volume;
        rtu_CONFIG_IN.Configured = Configured;

        Alarm_Outputs rtu_ALARM_IN = new Alarm_Outputs();
        rtu_ALARM_IN.Highest_Level_Alarm = Highest_Level_Alarm;

        System_Status_Outputs rtu_SYS_STAT_IN = new System_Status_Outputs();
        rtu_SYS_STAT_IN.Reservoir_Empty = Reservoir_Empty;
        rtu_SYS_STAT_IN.Volume_Infused = Volume_Infused;
        Infusion_Manager_Outputs rty_IM_OUT = new Infusion_Manager_Outputs();

        INFUSION_MGR_Functional(rtu_TLM_MODE_IN,
                rtu_OP_CMD_IN, rtu_PATIENT_IN,
                rtu_CONFIG_IN, rtu_ALARM_IN,
                rtu_SYS_STAT_IN, rty_IM_OUT);


        return rty_IM_OUT;
    }


    /* Output and update for referenced model: 'INFUSION_MGR_Functional' */
    static void INFUSION_MGR_Functional(Top_Level_Mode_Outputs rtu_TLM_MODE_IN,
                                        Operator_Commands rtu_OP_CMD_IN, Patient_Inputs rtu_PATIENT_IN,
                                        Config_Outputs rtu_CONFIG_IN, Alarm_Outputs rtu_ALARM_IN,
                                        System_Status_Outputs rtu_SYS_STAT_IN, Infusion_Manager_Outputs rty_IM_OUT) {
        /* BusSelector: '<Root>/BusConversion_InsertedFor_ALARM_IN_at_outport_0' */
        localB.Highest_Level_Alarm = rtu_ALARM_IN.Highest_Level_Alarm;

        /* BusSelector: '<Root>/BusConversion_InsertedFor_CONFIG_IN_at_outport_0' */
        localB.Infusion_Total_Duration = rtu_CONFIG_IN.Infusion_Total_Duration;
        localB.VTBI_Total = rtu_CONFIG_IN.VTBI_Total;
        localB.Flow_Rate_Basal = rtu_CONFIG_IN.Flow_Rate_Basal;
        localB.Flow_Rate_Intermittent_Bolus =
                rtu_CONFIG_IN.Flow_Rate_Intermittent_Bolus;
        localB.Duration_Intermittent_Bolus =
                rtu_CONFIG_IN.Duration_Intermittent_Bolus;
        localB.Interval_Intermittent_Bolus =
                rtu_CONFIG_IN.Interval_Intermittent_Bolus;
        localB.Flow_Rate_Patient_Bolus = rtu_CONFIG_IN.Flow_Rate_Patient_Bolus;
        localB.Duration_Patient_Bolus = rtu_CONFIG_IN.Duration_Patient_Bolus;
        localB.Lockout_Period_Patient_Bolus =
                rtu_CONFIG_IN.Lockout_Period_Patient_Bolus;
        localB.Max_Number_of_Patient_Bolus =
                rtu_CONFIG_IN.Max_Number_of_Patient_Bolus;
        localB.Flow_Rate_KVO = rtu_CONFIG_IN.Flow_Rate_KVO;
        localB.Configured = rtu_CONFIG_IN.Configured;

        /* BusSelector: '<Root>/BusConversion_InsertedFor_OP_CMD_IN_at_outport_0' */
        localB.Infusion_Initiate = rtu_OP_CMD_IN.Infusion_Initiate;
        localB.Infusion_Inhibit = rtu_OP_CMD_IN.Infusion_Inhibit;
        localB.Infusion_Cancel = rtu_OP_CMD_IN.Infusion_Cancel;

        /* BusSelector: '<Root>/BusConversion_InsertedFor_PATIENT_IN_at_outport_0' */
        localB.Patient_Bolus_Request = rtu_PATIENT_IN.Patient_Bolus_Request;

        /* BusSelector: '<Root>/BusConversion_InsertedFor_SYS_STAT_IN_at_outport_0' */
        localB.Reservoir_Empty = rtu_SYS_STAT_IN.Reservoir_Empty;
        localB.Volume_Infused = rtu_SYS_STAT_IN.Volume_Infused;

        /* Chart: '<Root>/Infusion Manager Sub-System' incorporates:
         *  BusSelector: '<Root>/BusConversion_InsertedFor_TLM_MODE_IN_at_outport_0'
         */
        /* Gateway: Infusion Manager Sub-System */
        /* During: Infusion Manager Sub-System */
        //DB_prinTF("10: ");
        if (localDW.is_active_c2_INFUSION_MGR_Functional == 0) {
            /* Entry: Infusion Manager Sub-System */
            //DB_prinTF("11: ");
            localDW.is_active_c2_INFUSION_MGR_Functional = 1;

            /* Entry Internal: Infusion Manager Sub-System */
            if (rtu_TLM_MODE_IN.System_On) {
                /* Transition: '<S1>:3986' */
                localDW.is_c2_INFUSION_MGR_Functional =
                        INFUSION_MGR_Functional_IN_Infusion_Manager;

                /* Entry Internal 'Infusion_Manager': '<S1>:3858' */
                /* Transition: '<S1>:3860' */
                localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_IDLE;

                /* Entry 'IDLE': '<S1>:3866' */
                localB.IM_OUT_Current_System_Mode = 1;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
                INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
            } else {
                /* Transition: '<S1>:3744' */
                localDW.is_c2_INFUSION_MGR_Functional = INFUSION_MGR_Functional_IN_NOT_ON;

                /* Entry 'NOT_ON': '<S1>:3740' */
                localB.IM_OUT_Current_System_Mode = 0;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
            }
        } else if (localDW.is_c2_INFUSION_MGR_Functional ==
                INFUSION_MGR_Functional_IN_Infusion_Manager) {
            /* During 'Infusion_Manager': '<S1>:3858' */
            //DB_prinTF("12: ");
            if (!rtu_TLM_MODE_IN.System_On) {
                /* Transition: '<S1>:3732' */
                /* Exit Internal 'Infusion_Manager': '<S1>:3858' */

                if (localDW.is_Infusion_Manager == INFUSION_MGR_Functional_IN_IDLE) {
                    /* Exit 'IDLE': '<S1>:3866' */
                    localB.IM_OUT_Current_System_Mode = 1;
                    localB.IM_OUT_Flow_Rate_Commanded = 0;
                    INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
                    localDW.is_Infusion_Manager =
                            INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
                } else if (localDW.is_Infusion_Manager == INFUSION_MGR_Functional_IN_THERAPY) {

                    /* Exit Internal 'THERAPY': '<S1>:3867' */
                    if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_ACTIVE) {
                        INFUSION_MGR_Functional_exit_internal_ACTIVE(localDW);
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
                    } else if (localDW.is_THERAPY == INFUSION_MGR_Functional_IN_PAUSED) {
                        INFUSION_MGR_Functional_exit_internal_PAUSED(localB, localDW);
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;

                    } else
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


                    /* Exit 'THERAPY': '<S1>:3867' */
                    INFUSION_MGR_Functional_TherapyExitOperations(localB);
                    localDW.is_Infusion_Manager =
                            INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;
                } else
                    localDW.is_Infusion_Manager =
                            INFUSION_MGR_Functional_IN_NO_ACTIVE_CHILD;


                localDW.is_c2_INFUSION_MGR_Functional = INFUSION_MGR_Functional_IN_NOT_ON;

                /* Entry 'NOT_ON': '<S1>:3740' */
                localB.IM_OUT_Current_System_Mode = 0;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
            } else if (localDW.is_Infusion_Manager == INFUSION_MGR_Functional_IN_IDLE) {
                //DB_prinTF("13: ");
                //DB_prinTF("2: %d %d %d ",localB.Infusion_Initiate, localB.Configured ,localB.Reservoir_Empty);
                /* During 'IDLE': '<S1>:3866' */
                boolean Infusion_Cancel_l = localB.Infusion_Cancel;
                boolean Infusion_Inhibit_l = localB.Infusion_Inhibit;
                boolean Infusion_Initiate_l = localB.Infusion_Initiate;
                int Configured_l = localB.Configured;
                boolean Reservoir_Empty_l = localB.Reservoir_Empty;
                if (Infusion_Cancel_l || Infusion_Inhibit_l) {
                    //DB_prinTF("30: ");
                    /* Transition: '<S1>:3993' */
                    /* Exit 'IDLE': '<S1>:3866' */
                    localB.IM_OUT_Current_System_Mode = 1;
                    localB.IM_OUT_Flow_Rate_Commanded = 0;
                    INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
                    localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_IDLE;

                    /* Entry 'IDLE': '<S1>:3866' */
                    localB.IM_OUT_Current_System_Mode = 1;
                    localB.IM_OUT_Flow_Rate_Commanded = 0;
                    INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
                } else if (Infusion_Initiate_l && (Configured_l > 0) && (!Reservoir_Empty_l)) {
                    //DB_prinTF("31: ");
                    /* Transition: '<S1>:3864' */
                    INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);

                    /* Transition: '<S1>:3863' */
                    localB.IM_OUT_New_Infusion = true;

                    /* Exit 'IDLE': '<S1>:3866' */
                    localB.IM_OUT_Current_System_Mode = 1;
                    localB.IM_OUT_Flow_Rate_Commanded = 0;
                    INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
                    localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_THERAPY;

                    /* Entry Internal 'THERAPY': '<S1>:3867' */
                    Infusion_Inhibit_l = localB.Infusion_Inhibit;
                    int Highest_Level_Alarm_l = localB.Highest_Level_Alarm;

                    if (Infusion_Inhibit_l || (Highest_Level_Alarm_l >= 3)) {
                        /* Transition: '<S1>:3994' */
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_PAUSED;
                        INFUSION_MGR_Functional_enter_internal_PAUSED(localB, localDW);
                    } else {
                        /* Transition: '<S1>:3875' */
                        localDW.is_THERAPY = INFUSION_MGR_Functional_IN_ACTIVE;
                        INFUSION_MGR_Functional_enter_internal_ACTIVE(localB, localDW);
                    }
                } else {
                    //DB_prinTF("32: ");
                    localB.IM_OUT_Current_System_Mode = 1;
                    localB.IM_OUT_Flow_Rate_Commanded = 0;
                }
            } else {
                //DB_prinTF("14: ");
                INFUSION_MGR_Functional_THERAPY(localB, localDW);
            }
        } else {
            //DB_prinTF("20: ");
            /* During 'NOT_ON': '<S1>:3740' */
            if (rtu_TLM_MODE_IN.System_On) {
                /* Transition: '<S1>:3741' */
                /* Exit 'NOT_ON': '<S1>:3740' */
                localDW.is_c2_INFUSION_MGR_Functional =
                        INFUSION_MGR_Functional_IN_Infusion_Manager;

                /* Entry Internal 'Infusion_Manager': '<S1>:3858' */
                /* Transition: '<S1>:3860' */
                localDW.is_Infusion_Manager = INFUSION_MGR_Functional_IN_IDLE;

                /* Entry 'IDLE': '<S1>:3866' */
                localB.IM_OUT_Current_System_Mode = 1;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
                INFUSION_MGR_Functional_resetAllInfusionDetails(localB, localDW);
            } else {
                localB.IM_OUT_Current_System_Mode = 0;
                localB.IM_OUT_Flow_Rate_Commanded = 0;
            }
        }

        /* End of Chart: '<Root>/Infusion Manager Sub-System' */

        /* BusCreator: '<Root>/BusConversion_InsertedFor_IM_OUT_at_inport_0' */
        rty_IM_OUT.Commanded_Flow_Rate = localB.IM_OUT_Flow_Rate_Commanded;
        rty_IM_OUT.Current_System_Mode = localB.IM_OUT_Current_System_Mode;
        rty_IM_OUT.New_Infusion = localB.IM_OUT_New_Infusion;
        rty_IM_OUT.Log_Message_ID = localB.IM_OUT_Log_Message_ID;
        rty_IM_OUT.Actual_Infusion_Duration = localB.IM_OUT_Actual_Infusion_Duration;

        //  assert (rty_IM_OUT.Commanded_Flow_Rate == 0);
    }

    static void INFUSION_MGR_FunctionalSymWrapper(
            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On,

            //Operator_Commands rtu_OP_CMD_IN
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
            int Reservoir_Volume,
            int Configured,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty,
            int Volume_Infused,

            //second step

            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On_2,

            //Operator_Commands rtu_OP_CMD_IN
            boolean Infusion_Initiate_2,
            boolean Infusion_Inhibit_2,
            boolean Infusion_Cancel_2,
            boolean Patient_Bolus_Request_2,
            int Infusion_Total_Duration_2,
            int VTBI_Total_2,
            int Flow_Rate_Basal_2,
            int Flow_Rate_Intermittent_Bolus_2,
            int Duration_Intermittent_Bolus_2,
            int Interval_Intermittent_Bolus_2,
            int Flow_Rate_Patient_Bolus_2,
            int Duration_Patient_Bolus_2,
            int Lockout_Period_Patient_Bolus_2,
            int Max_Number_of_Patient_Bolus_2,
            int Flow_Rate_KVO_2,
            int Entered_Reservoir_Volume_2,
            int Reservoir_Volume_2,
            int Configured_2,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm_2,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_2,
            int Volume_Infused_2,

            //third step
            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On_3,

            //Operator_Commands rtu_OP_CMD_IN
            boolean Infusion_Initiate_3,
            boolean Infusion_Inhibit_3,
            boolean Infusion_Cancel_3,
            boolean Patient_Bolus_Request_3,
            int Infusion_Total_Duration_3,
            int VTBI_Total_3,
            int Flow_Rate_Basal_3,
            int Flow_Rate_Intermittent_Bolus_3,
            int Duration_Intermittent_Bolus_3,
            int Interval_Intermittent_Bolus_3,
            int Flow_Rate_Patient_Bolus_3,
            int Duration_Patient_Bolus_3,
            int Lockout_Period_Patient_Bolus_3,
            int Max_Number_of_Patient_Bolus_3,
            int Flow_Rate_KVO_3,
            int Entered_Reservoir_Volume_3,
            int Reservoir_Volume_3,
            int Configured_3,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm_3,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_3,
            int Volume_Infused_3,

            //fourth step

            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On_4,

            //Operator_Commands rtu_OP_CMD_IN
            boolean Infusion_Initiate_4,
            boolean Infusion_Inhibit_4,
            boolean Infusion_Cancel_4,
            boolean Patient_Bolus_Request_4,
            int Infusion_Total_Duration_4,
            int VTBI_Total_4,
            int Flow_Rate_Basal_4,
            int Flow_Rate_Intermittent_Bolus_4,
            int Duration_Intermittent_Bolus_4,
            int Interval_Intermittent_Bolus_4,
            int Flow_Rate_Patient_Bolus_4,
            int Duration_Patient_Bolus_4,
            int Lockout_Period_Patient_Bolus_4,
            int Max_Number_of_Patient_Bolus_4,
            int Flow_Rate_KVO_4,
            int Entered_Reservoir_Volume_4,
            int Reservoir_Volume_4,
            int Configured_4,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm_4,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_4,
            int Volume_Infused_4,


            //fifth step

            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On_5,

            //Operator_Commands rtu_OP_CMD_IN
            boolean Infusion_Initiate_5,
            boolean Infusion_Inhibit_5,
            boolean Infusion_Cancel_5,
            boolean Patient_Bolus_Request_5,
            int Infusion_Total_Duration_5,
            int VTBI_Total_5,
            int Flow_Rate_Basal_5,
            int Flow_Rate_Intermittent_Bolus_5,
            int Duration_Intermittent_Bolus_5,
            int Interval_Intermittent_Bolus_5,
            int Flow_Rate_Patient_Bolus_5,
            int Duration_Patient_Bolus_5,
            int Lockout_Period_Patient_Bolus_5,
            int Max_Number_of_Patient_Bolus_5,
            int Flow_Rate_KVO_5,
            int Entered_Reservoir_Volume_5,
            int Reservoir_Volume_5,
            int Configured_5,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm_5,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_5,
            int Volume_Infused_5,

            //sixth step
            //Inputs of Infusion_Manager_Outputs rtu_TLM_MODE_IN
            boolean System_On_6,

            //Operator_Commands rtu_OP_CMD_IN
            boolean Infusion_Initiate_6,
            boolean Infusion_Inhibit_6,
            boolean Infusion_Cancel_6,
            boolean Patient_Bolus_Request_6,
            int Infusion_Total_Duration_6,
            int VTBI_Total_6,
            int Flow_Rate_Basal_6,
            int Flow_Rate_Intermittent_Bolus_6,
            int Duration_Intermittent_Bolus_6,
            int Interval_Intermittent_Bolus_6,
            int Flow_Rate_Patient_Bolus_6,
            int Duration_Patient_Bolus_6,
            int Lockout_Period_Patient_Bolus_6,
            int Max_Number_of_Patient_Bolus_6,
            int Flow_Rate_KVO_6,
            int Entered_Reservoir_Volume_6,
            int Reservoir_Volume_6,
            int Configured_6,


            //Alarm_Outputs rtu_ALARM_IN
            int Highest_Level_Alarm_6,


            //System_Status_Outputs rtu_SYS_STAT_IN
            boolean Reservoir_Empty_6,
            int Volume_Infused_6

     ) {

        localB = new B_INFUSION_MGR_Functional_c_T();

        localDW = new DW_INFUSION_MGR_Functional_f_T();


         INFUSION_MGR_Functional_Init(localB, localDW);
        
        if (    (0 <= Infusion_Total_Duration) &&
                (0 <= VTBI_Total) &&
                (0 <= Flow_Rate_Basal) &&
                (0 <= Flow_Rate_Intermittent_Bolus) &&
                (0 <= Duration_Intermittent_Bolus) &&
                (0 <= Interval_Intermittent_Bolus) &&
                (0 <= Flow_Rate_Patient_Bolus) &&
                (0 <= Duration_Patient_Bolus) &&
                (0 <= Lockout_Period_Patient_Bolus) &&
                (0 <= Max_Number_of_Patient_Bolus) &&
                (0 <= Flow_Rate_KVO) &&
                (0 <= Entered_Reservoir_Volume) &&
                (0 <= Reservoir_Volume) &&
                (0 <= Configured) &&
                (Infusion_Total_Duration <= 255) &&
                (VTBI_Total <= 255) &&
                (Flow_Rate_Basal <= 255) &&
                (Flow_Rate_Intermittent_Bolus <= 255) &&
                (Duration_Intermittent_Bolus <= 255) &&
                (Interval_Intermittent_Bolus <= 255) &&
                (Flow_Rate_Patient_Bolus <= 255) &&
                (Duration_Patient_Bolus <= 255) &&
                (Lockout_Period_Patient_Bolus <= 255) &&
                (Max_Number_of_Patient_Bolus <= 255) &&
                (Flow_Rate_KVO <= 255) &&
                (Entered_Reservoir_Volume <= 255) &&
                (Reservoir_Volume <= 255) &&
                (Configured <= 255) &&


                //second step

                (0 <= Infusion_Total_Duration_2) &&
                (0 <= VTBI_Total_2) &&
                (0 <= Flow_Rate_Basal_2) &&
                (0 <= Flow_Rate_Intermittent_Bolus_2) &&
                (0 <= Duration_Intermittent_Bolus_2) &&
                (0 <= Interval_Intermittent_Bolus_2) &&
                (0 <= Flow_Rate_Patient_Bolus_2) &&
                (0 <= Duration_Patient_Bolus_2) &&
                (0 <= Lockout_Period_Patient_Bolus_2) &&
                (0 <= Max_Number_of_Patient_Bolus_2) &&
                (0 <= Flow_Rate_KVO_2) &&
                (0 <= Entered_Reservoir_Volume_2) &&
                (0 <= Reservoir_Volume_2) &&
                (0 <= Configured_2) &&
                (0 <= Highest_Level_Alarm_2) &&
                (Infusion_Total_Duration_2 <= 255) &&
                (VTBI_Total_2 <= 255) &&
                (Flow_Rate_Basal_2 <= 255) &&
                (Flow_Rate_Intermittent_Bolus_2 <= 255) &&
                (Duration_Intermittent_Bolus_2 <= 255) &&
                (Interval_Intermittent_Bolus_2 <= 255) &&
                (Flow_Rate_Patient_Bolus_2 <= 255) &&
                (Duration_Patient_Bolus_2 <= 255) &&
                (Lockout_Period_Patient_Bolus_2 <= 255) &&
                (Max_Number_of_Patient_Bolus_2 <= 255) &&
                (Flow_Rate_KVO_2 <= 255) &&
                (Entered_Reservoir_Volume_2 <= 255) &&
                (Reservoir_Volume_2 <= 255) &&
                (Configured_2 <= 255) &&
                (Highest_Level_Alarm_2 <= 255) &&
                (Volume_Infused_2 <= 255) &&


                //third step

                (0 <= Infusion_Total_Duration_3) &&
                (0 <= VTBI_Total_3) &&
                (0 <= Flow_Rate_Basal_3) &&
                (0 <= Flow_Rate_Intermittent_Bolus_3) &&
                (0 <= Duration_Intermittent_Bolus_3) &&
                (0 <= Interval_Intermittent_Bolus_3) &&
                (0 <= Flow_Rate_Patient_Bolus_3) &&
                (0 <= Duration_Patient_Bolus_3) &&
                (0 <= Lockout_Period_Patient_Bolus_3) &&
                (0 <= Max_Number_of_Patient_Bolus_3) &&
                (0 <= Flow_Rate_KVO_3) &&
                (0 <= Entered_Reservoir_Volume_3) &&
                (0 <= Reservoir_Volume_3) &&
                (0 <= Configured_3) &&
                (0 <= Highest_Level_Alarm_3) &&
                (0 <= Volume_Infused_3) &&
                (Infusion_Total_Duration_3 <= 255) &&
                (VTBI_Total_3 <= 255) &&
                (Flow_Rate_Basal_3 <= 255) &&
                (Flow_Rate_Intermittent_Bolus_3 <= 255) &&
                (Duration_Intermittent_Bolus_3 <= 255) &&
                (Interval_Intermittent_Bolus_3 <= 255) &&
                (Flow_Rate_Patient_Bolus_3 <= 255) &&
                (Duration_Patient_Bolus_3 <= 255) &&
                (Lockout_Period_Patient_Bolus_3 <= 255) &&
                (Max_Number_of_Patient_Bolus_3 <= 255) &&
                (Flow_Rate_KVO_3 <= 255) &&
                (Entered_Reservoir_Volume_3 <= 255) &&
                (Reservoir_Volume_3 <= 255) &&
                (Configured_3 <= 255) &&
                (Highest_Level_Alarm_3 <= 255) &&
                (Volume_Infused_3 <= 255) &&


                //4 step

                (0 <= Infusion_Total_Duration_4) &&
                (0 <= VTBI_Total_4) &&
                (0 <= Flow_Rate_Basal_4) &&
                (0 <= Flow_Rate_Intermittent_Bolus_4) &&
                (0 <= Duration_Intermittent_Bolus_4) &&
                (0 <= Interval_Intermittent_Bolus_4) &&
                (0 <= Flow_Rate_Patient_Bolus_4) &&
                (0 <= Duration_Patient_Bolus_4) &&
                (0 <= Lockout_Period_Patient_Bolus_4) &&
                (0 <= Max_Number_of_Patient_Bolus_4) &&
                (0 <= Flow_Rate_KVO_4) &&
                (0 <= Entered_Reservoir_Volume_4) &&
                (0 <= Reservoir_Volume_4) &&
                (0 <= Configured_4) &&
                (0 <= Highest_Level_Alarm_4) &&
                (0 <= Volume_Infused_4) &&
                (Infusion_Total_Duration_4 <= 255) &&
                (VTBI_Total_4 <= 255) &&
                (Flow_Rate_Basal_4 <= 255) &&
                (Flow_Rate_Intermittent_Bolus_4 <= 255) &&
                (Duration_Intermittent_Bolus_4 <= 255) &&
                (Interval_Intermittent_Bolus_4 <= 255) &&
                (Flow_Rate_Patient_Bolus_4 <= 255) &&
                (Duration_Patient_Bolus_4 <= 255) &&
                (Lockout_Period_Patient_Bolus_4 <= 255) &&
                (Max_Number_of_Patient_Bolus_4 <= 255) &&
                (Flow_Rate_KVO_4 <= 255) &&
                (Entered_Reservoir_Volume_4 <= 255) &&
                (Reservoir_Volume_4 <= 255) &&
                (Configured_4 <= 255) &&
                (Highest_Level_Alarm_4 <= 255) &&
                (Volume_Infused_4 <= 255) &&

                //step5
                (0 <= Infusion_Total_Duration_5) &&
                (0 <= VTBI_Total_5) &&
                (0 <= Flow_Rate_Basal_5) &&
                (0 <= Flow_Rate_Intermittent_Bolus_5) &&
                (0 <= Duration_Intermittent_Bolus_5) &&
                (0 <= Interval_Intermittent_Bolus_5) &&
                (0 <= Flow_Rate_Patient_Bolus_5) &&
                (0 <= Duration_Patient_Bolus_5) &&
                (0 <= Lockout_Period_Patient_Bolus_5) &&
                (0 <= Max_Number_of_Patient_Bolus_5) &&
                (0 <= Flow_Rate_KVO_5) &&
                (0 <= Entered_Reservoir_Volume_5) &&
                (0 <= Reservoir_Volume_5) &&
                (0 <= Configured_5) &&
                (0 <= Highest_Level_Alarm_5) &&
                (0 <= Volume_Infused_5) &&
                (Infusion_Total_Duration_5 <= 255) &&
                (VTBI_Total_5 <= 255) &&
                (Flow_Rate_Basal_5 <= 255) &&
                (Flow_Rate_Intermittent_Bolus_5 <= 255) &&
                (Duration_Intermittent_Bolus_5 <= 255) &&
                (Interval_Intermittent_Bolus_5 <= 255) &&
                (Flow_Rate_Patient_Bolus_5 <= 255) &&
                (Duration_Patient_Bolus_5 <= 255) &&
                (Lockout_Period_Patient_Bolus_5 <= 255) &&
                (Max_Number_of_Patient_Bolus_5 <= 255) &&
                (Flow_Rate_KVO_5 <= 255) &&
                (Entered_Reservoir_Volume_5 <= 255) &&
                (Reservoir_Volume_5 <= 255) &&
                (Configured_5 <= 255) &&
                (Highest_Level_Alarm_5 <= 255) &&
                (Volume_Infused_5 <= 255)&&


                //step 6

        (0 <= Infusion_Total_Duration_6) &&
                (0 <= VTBI_Total_6) &&
                (0 <= Flow_Rate_Basal_6) &&
                (0 <= Flow_Rate_Intermittent_Bolus_6) &&
                (0 <= Duration_Intermittent_Bolus_6) &&
                (0 <= Interval_Intermittent_Bolus_6) &&
                (0 <= Flow_Rate_Patient_Bolus_6) &&
                (0 <= Duration_Patient_Bolus_6) &&
                (0 <= Lockout_Period_Patient_Bolus_6) &&
                (0 <= Max_Number_of_Patient_Bolus_6) &&
                (0 <= Flow_Rate_KVO_6) &&
                (0 <= Entered_Reservoir_Volume_6) &&
                (0 <= Reservoir_Volume_6) &&
                (0 <= Configured_6) &&
                (0 <= Highest_Level_Alarm_6) &&
                (0 <= Volume_Infused_6) &&
                (Infusion_Total_Duration_6 <= 255) &&
                (VTBI_Total_6 <= 255) &&
                (Flow_Rate_Basal_6 <= 255) &&
                (Flow_Rate_Intermittent_Bolus_6 <= 255) &&
                (Duration_Intermittent_Bolus_6 <= 255) &&
                (Interval_Intermittent_Bolus_6 <= 255) &&
                (Flow_Rate_Patient_Bolus_6 <= 255) &&
                (Duration_Patient_Bolus_6 <= 255) &&
                (Lockout_Period_Patient_Bolus_6 <= 255) &&
                (Max_Number_of_Patient_Bolus_6 <= 255) &&
                (Flow_Rate_KVO_6 <= 255) &&
                (Entered_Reservoir_Volume_6 <= 255) &&
                (Reservoir_Volume_6 <= 255) &&
                (Configured_6 <= 255) &&
                (Highest_Level_Alarm_6 <= 255) &&
                (Volume_Infused_6 <= 255)
                ) {
            Infusion_Result.step(System_On, Infusion_Initiate, Infusion_Inhibit, Infusion_Cancel, Patient_Bolus_Request, Infusion_Total_Duration, VTBI_Total, Flow_Rate_Basal, Flow_Rate_Intermittent_Bolus, Duration_Intermittent_Bolus, Interval_Intermittent_Bolus, Flow_Rate_Patient_Bolus, Duration_Patient_Bolus, Lockout_Period_Patient_Bolus, Max_Number_of_Patient_Bolus, Flow_Rate_KVO, Entered_Reservoir_Volume, Configured, Highest_Level_Alarm, Reservoir_Empty, Volume_Infused);

            Infusion_Result.step(System_On_2, Infusion_Initiate_2, Infusion_Inhibit_2, Infusion_Cancel_2, Patient_Bolus_Request_2, Infusion_Total_Duration_2, VTBI_Total_2, Flow_Rate_Basal_2, Flow_Rate_Intermittent_Bolus_2, Duration_Intermittent_Bolus_2, Interval_Intermittent_Bolus_2, Flow_Rate_Patient_Bolus_2, Duration_Patient_Bolus_2, Lockout_Period_Patient_Bolus_2, Max_Number_of_Patient_Bolus_2, Flow_Rate_KVO_2, Entered_Reservoir_Volume_2, Configured_2, Highest_Level_Alarm_2, Reservoir_Empty_2, Volume_Infused_2);

            Infusion_Result.step(System_On_3, Infusion_Initiate_3, Infusion_Inhibit_3, Infusion_Cancel_3, Patient_Bolus_Request_3, Infusion_Total_Duration_3, VTBI_Total_3, Flow_Rate_Basal_3, Flow_Rate_Intermittent_Bolus_3, Duration_Intermittent_Bolus_3, Interval_Intermittent_Bolus_3, Flow_Rate_Patient_Bolus_3, Duration_Patient_Bolus_3, Lockout_Period_Patient_Bolus_3, Max_Number_of_Patient_Bolus_3, Flow_Rate_KVO_3, Entered_Reservoir_Volume_3, Configured_3, Highest_Level_Alarm_3, Reservoir_Empty_3, Volume_Infused_3);

            Infusion_Result.step(System_On_4, Infusion_Initiate_4, Infusion_Inhibit_4, Infusion_Cancel_4, Patient_Bolus_Request_4, Infusion_Total_Duration_4, VTBI_Total_4, Flow_Rate_Basal_4, Flow_Rate_Intermittent_Bolus_4, Duration_Intermittent_Bolus_4, Interval_Intermittent_Bolus_4, Flow_Rate_Patient_Bolus_4, Duration_Patient_Bolus_4, Lockout_Period_Patient_Bolus_4, Max_Number_of_Patient_Bolus_4, Flow_Rate_KVO_4, Entered_Reservoir_Volume_4, Configured_4, Highest_Level_Alarm_4, Reservoir_Empty_4, Volume_Infused_4);

            Infusion_Result.step(System_On_5, Infusion_Initiate_5, Infusion_Inhibit_5, Infusion_Cancel_5, Patient_Bolus_Request_5, Infusion_Total_Duration_5, VTBI_Total_5, Flow_Rate_Basal_5, Flow_Rate_Intermittent_Bolus_5, Duration_Intermittent_Bolus_5, Interval_Intermittent_Bolus_5, Flow_Rate_Patient_Bolus_5, Duration_Patient_Bolus_5, Lockout_Period_Patient_Bolus_5, Max_Number_of_Patient_Bolus_5, Flow_Rate_KVO_5, Entered_Reservoir_Volume_5, Configured_5, Highest_Level_Alarm_5, Reservoir_Empty_5, Volume_Infused_5);

            Infusion_Result.step(System_On_6, Infusion_Initiate_6, Infusion_Inhibit_6, Infusion_Cancel_6, Patient_Bolus_Request_6, Infusion_Total_Duration_6, VTBI_Total_6, Flow_Rate_Basal_6, Flow_Rate_Intermittent_Bolus_6, Duration_Intermittent_Bolus_6, Interval_Intermittent_Bolus_6, Flow_Rate_Patient_Bolus_6, Duration_Patient_Bolus_6, Lockout_Period_Patient_Bolus_6, Max_Number_of_Patient_Bolus_6, Flow_Rate_KVO_6, Entered_Reservoir_Volume_6, Configured_6, Highest_Level_Alarm_6, Reservoir_Empty_6, Volume_Infused_6);


            boolean checkCondition;
            boolean checkOutput;

            //Prop1: mode_range
        /*checkCondition = ((rty_IM_OUT.Current_System_Mode == 0) || (rty_IM_OUT.Current_System_Mode == 1) || (rty_IM_OUT.Current_System_Mode == 2) || (rty_IM_OUT.Current_System_Mode == 3) || (rty_IM_OUT.Current_System_Mode == 4) || (rty_IM_OUT.Current_System_Mode == 6) || (rty_IM_OUT.Current_System_Mode == 7) || (rty_IM_OUT.Current_System_Mode == 8));
        assert checkCondition;
*/
            //prop2: system_on_implies_idle -------- couldn't be mapped to source
//        checkCondition = ((!(prev_On_Start)) && curr_On_Start);
//        checkOutput = (rty_IM_OUT.Current_System_Mode == 1);
//        assert(!checkCondition || checkOutput);

            //prop2 not_system_on_implies_mode_0
        /*checkCondition = (!(rtu_TLM_MODE_IN.System_On));
        checkOutput = (rty_IM_OUT.Current_System_Mode == 0);
        assert (!checkCondition || checkOutput);
*/

            //prop3 alarm_L4_implies_flow_rate_zero
        /*checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_ALARM_IN.Highest_Level_Alarm == 4));
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == 0);
        assert (!checkCondition || checkOutput);
*/
            //Prop4: alarm_L3_implies_flow_kvo -- Not Valid on the implementation
        /*checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_ALARM_IN.Highest_Level_Alarm == 3));
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate <= rtu_CONFIG_IN.Flow_Rate_KVO);
        if (checkCondition && !checkOutput) {
            Debug.printPC("pc for the violation");
            System.out.println(Debug.getSymbolicIntegerValue(rty_IM_OUT.Commanded_Flow_Rate));
            assert false;
        }*/

  /*      //Prop5: configured_lt_1_flow_rate_zero
        checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_CONFIG_IN.Configured < 1));
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == 0);
        assert (!checkCondition || checkOutput);*/

  /*      //Prop6: alarm_L2_implies_in_paused_or_idle_or_basal
        checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_ALARM_IN.Highest_Level_Alarm == 2));
        checkOutput =
                ((rty_IM_OUT.Current_System_Mode == 1) || (rty_IM_OUT.Current_System_Mode == 2) || (rty_IM_OUT.Current_System_Mode == 6) || (rty_IM_OUT.Current_System_Mode == 7) || (rty_IM_OUT.Current_System_Mode == 8));
        assert (!checkCondition || checkOutput);*/

/*
        //Prop7: mode_off_implies_infusion_rate_zero
        checkCondition = (rty_IM_OUT.Current_System_Mode == 0);
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == 0);
        assert (!checkCondition || checkOutput);
*/

        /*//Prop8: alarm_L2_implies_no_bolus
        checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_ALARM_IN.Highest_Level_Alarm == 2));
        checkOutput = (rty_IM_OUT.Current_System_Mode != 3) && (rty_IM_OUT.Current_System_Mode  != 4);
        assert (!checkCondition || checkOutput);*/


            //Prop9: alarm_GTE_3_implies_in_paused_or_idle
  /*      checkCondition = (rtu_TLM_MODE_IN.System_On && (rtu_ALARM_IN.Highest_Level_Alarm == 4));
        checkOutput =
                ((rty_IM_OUT.Current_System_Mode == 1) || (rty_IM_OUT.Current_System_Mode == 6) || (rty_IM_OUT.Current_System_Mode == 7));
        assert (!checkCondition || checkOutput);*/

            //Prop10: mode_basal_implies_infusion_rate_basal
        /*checkCondition = (rtu_TLM_MODE_IN.System_On &    INFUSION_MGR_Functional(rtu_TLM_MODE_IN,
                    rtu_OP_CMD_IN, rtu_PATIENT_IN,
                    rtu_CONFIG_IN, rtu_ALARM_IN,
                    rtu_SYS_STAT_IN, rty_IM_OUT,
                    localB, localDW);
& rty_IM_OUT.Current_System_Mode == 2);
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == rtu_CONFIG_IN.Flow_Rate_Basal);
        assert (!checkCondition || checkOutput);*/


            //Prop11: mode_intermittent_implies_infusion_rate_intermittent_bolus
  /*      checkCondition = rtu_TLM_MODE_IN.System_On && (rty_IM_OUT.Current_System_Mode == 3);
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == rtu_CONFIG_IN.Flow_Rate_Intermittent_Bolus);
        assert (!checkCondition || checkOutput);
*/
/*
        //Prop12: mode_patient_implies_infusion_rate_patient_bolus
        checkCondition = rtu_TLM_MODE_IN.System_On && (rty_IM_OUT.Current_System_Mode == 4);
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == rtu_CONFIG_IN.Flow_Rate_Patient_Bolus);
        assert (!checkCondition || checkOutput);
*/

  /*      // not_infusing_eq_rate_zero -- Could not map Infusing var
        checkCondition = (rtu_TLM_MODE_IN.System_On && (! (Infusing)));
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == 0);
        assert (!checkCondition || checkOutput);*/

            //Prop13: mode_idle_implies_infusion_rate_zero(
/*
        checkCondition = rtu_TLM_MODE_IN.System_On && (rty_IM_OUT.Current_System_Mode == 1);
        checkOutput = (rty_IM_OUT.Commanded_Flow_Rate == 0);
        assert (!checkCondition || checkOutput);
*/

            //Prop14: mode_paused_implies_infusion_rate_kvo
            /*checkCondition =
                    rtu_TLM_MODE_IN.System_On && (rty_IM_OUT.Current_System_Mode == 6 || rty_IM_OUT.Current_System_Mode == 7 || rty_IM_OUT.Current_System_Mode == 8);
            checkOutput = (rty_IM_OUT.Commanded_Flow_Rate <= rtu_CONFIG_IN.Flow_Rate_KVO);
            assert (!checkCondition || checkOutput);*/

            //  checkCondition = ((! System_On));
            // checkOutput = (Current_System_Mode == 0);

            // assert (!checkCondition || checkOutput);
        }
    }

    public static void main(String[] args) {
       INFUSION_MGR_Functional.INFUSION_MGR_FunctionalSymWrapper(
               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1 ,

               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1 ,

               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1 ,

               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1 ,

               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1,

               false ,           false ,           false ,           false ,           false ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,           1 ,                   1 ,                      false ,           1
        );
    }
}
