#!/usr/bin/env bash

now=$(date)
echo "Current time : $now"

#rm ../traces_infusion/*
#mkdir ../traces_infusion
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_tcas/tcas.dtrace.gz tcas.TCAS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_tcas.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_tcas/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_tcas.txt



#java -cp /home/soha/git/jpf-symbc/src/examples/tcas:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/infusionDaikon/INFUSION_MGR_Functional.java
#echo "finished spliting"

echo "running instance return ..."

#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_infusion/infusionSteps5_noreturn_static.dtrace.gz infusionDaikon.Infusion_Daikon /home/soha/git/jpf-symbc/testCase/testCases_infusion_steps5.txt

echo "finish chicory starting collecting invariants."
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon --config_option daikon.inv.unary.scalar.OneOfScalar.size=8 ../src/examples/infusionDaikon/Infusion_Result_Instance.spinfo ../traces_infusion/infusionSteps5_return_instance.dtrace.gz --format java > ../daikonInv/infusion_instance_steps5.txt

echo "done"
## separete command for running the on demand test for the crafted perfect test suite used for infusion property p9
#java -cp /home/soha/git/jpf-symbc/build/examples infusionDaikon.Infusion_Daikon ../testCase/testCases_infusionP9.txt