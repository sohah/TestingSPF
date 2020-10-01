rm ../traces_infusion/*
mkdir ../traces_infusion
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces_infusion/infusion.dtrace.gz infusion.Infusion_Daikon /home/soha/git/jpf-symbc/testCase/testCases_infusion.txt
java -cp /home/soha/git/jpf-symbc/build/examples:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces_infusion/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_infusion.txt