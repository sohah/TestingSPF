rm ../traces_wbs/*
mkdir ../traces_wbs
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_wbs/wbs.dtrace.gz wbs.WBS /home/soha/git/jpf-symbc/testCase/testCases_wbs.txt
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_wbs/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_wbs.txt