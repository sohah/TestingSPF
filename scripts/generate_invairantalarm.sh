rm ../traces_alarm/*
mkdir ../traces_alarm
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_alarm/alarm.dtrace.gz alarm.ALARM_Functional /home/soha/git/jpf-symbc/testCase/testCases_alarm.txt
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_alarm/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_alarm.txt