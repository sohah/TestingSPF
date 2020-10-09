#!/usr/bin/env bash

now=$(date)
echo "Current time : $now"

#rm ../traces_alarm/alarm156.dtrace.gz
#mkdir ../traces_alarm
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_tcas/tcas.dtrace.gz tcas.TCAS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_tcas.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_tcas/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_tcas.txt


#java -cp /home/soha/git/jpf-symbc/src/examples/tcas:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/alarmDaikon/ALARM_Functional.java

#echo "finished spliting"
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_alarm/alarm156.dtrace.gz alarmDaikon.Alarm_Daikon /home/soha/git/jpf-symbc/testCase/testCases_alarm_steps1_unfinished_depth156.txt

echo "finish chicory starting collecting invariants."
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon --config_option daikon.inv.unary.scalar.OneOfScalar.size=5 ../src/examples/alarmDaikon/Alarm_Result.spinfo ../traces_alarm/alarm156.dtrace.gz --format java > ../daikonInv/daikon_invariants_alarm156.txt
