#!/usr/bin/env bash

now=$(date)
echo "Current time : $now"

#rm ../traces_tcas/*
#mkdir ../traces_tcas
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_tcas/tcas.dtrace.gz tcas.TCAS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_tcas.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_tcas/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_tcas.txt

#java -cp /home/soha/git/jpf-symbc/src/examples/tcas:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/tcas/SpfTCAS.java

echo "finished spliting"
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_tcas/tcasStep2.dtrace.gz tcas.TCAS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_tcas_steps2.txt

echo "finish chicory starting collecting invariants."
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../src/examples/tcas/TCAS_Output.spinfo ../traces_tcas/tcasSteps2.dtrace.gz --format java > ../daikonInv/daikon_invariants_tcas_steps2.txt
