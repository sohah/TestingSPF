#!/usr/bin/env bash
#rm ../traces_wbs/*
mkdir ../traces_wbs

#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/daikon-5.8.4/daikon.jar daikon.DynComp wbs.WBS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_wbs.txt
#mv WBS_Daikon.decls-DynComp ../src/examples/wbs
#java -cp /home/soha/git/jpf-symbc/src/examples/wbs:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/wbs/WBS_Daikon.java /home/soha/git/jpf-symbc/testCase/testCases_wbs.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/daikon-5.8.4/daikon.jar daikon.Chicory --comparability-file=/home/soha/git/jpf-symbc/src/examples/wbs/WBS_Daikon.decls-DynComp --dtrace-file=../traces_wbs/wbs.dtrace.gz wbs.WBS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_wbs.txt
#java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/daikon-5.8.4/daikon.jar daikon.Daikon ../traces_wbs/*.dtrace.gz /home/soha/git/jpf-symbc/src/examples/wbs/WBS_Daikon.decls-DynComp ../src/examples/wbs/WBS_Daikon.spinfo --format java > ../daikonInv/daikon_invariants_wbs_splitInfo_dyn.txt




java -cp /home/soha/git/jpf-symbc/src/examples/wbs:/home/soha/daikon-5.8.4/daikon.jar daikon.tools.jtb.CreateSpinfo ../src/examples/wbs/WBS.java

java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/daikon-5.8.4/daikon.jar daikon.Chicory --dtrace-file=../traces_wbs/wbs.dtrace.gz wbs.WBS_Daikon /home/soha/git/jpf-symbc/testCase/testCases_wbs.txt

java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/daikon-5.8.4/daikon.jar daikon.Daikon --nohierarchy ../traces_wbs/*.dtrace.gz  ../src/examples/wbs/WBS.spinfo --format java > ../daikonInv/daikon_invariants_wbs_Wrapping.txt
