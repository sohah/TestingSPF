#!/usr/bin/env bash

now=$(date)
echo "Current time : $now"

rm ../traces_infusion/*
mkdir ../traces_infusion
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_tcas/tcas.dtrace.gz tcas.TCAS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_tcas.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_tcas/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_tcas.txt



#java -cp /home/soha/git/jpf-symbc/src/examples/tcas:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/infusionDaikon/INFUSION_MGR_Functional.java
echo "finished spliting"

java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_infusion/infusionSteps4.dtrace.gz infusionDaikon.Infusion_Daikon /home/soha/git/jpf-symbc/testCase/testCases_infusion_steps4.txt

echo "finish chicory starting collecting invariants."
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon --config_option daikon.inv.unary.scalar.OneOfScalar.size=7 ../src/examples/infusionDaikon/Infusion_Result.spinfo ../traces_infusion/infusionSteps4.dtrace.gz --format java > ../daikonInv/daikon_invariants_infusion_steps4.txt
