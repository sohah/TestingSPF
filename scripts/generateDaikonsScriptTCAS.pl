#!/usr/bin/perl
use strict;
use warnings;
use autodie;

#use this to generate the shell script for getting daikon invariants.
# the main input is that file containing the test cases generated by spf in $TC_FileName
# run this from the script folder. no input to the perl file, except those configured by hand below.
# the output is the "generate_invairant${benchmark}.sh" file that we needs to run seperately to generate the daikon invariants.
# we need to do chmod a+x to generate_invairant${benchmark}.sh. then when we execute it the output will be in file , daikon_invariants_${benchmark}

my $TC_FileName="/home/soha/git/jpf-symbc/testCase/testCases_tcas.txt";
my $symbolicMethodName="launch";
my $benchmark="tcas";
my $mainClassName="tcas.SpfTCAS";

#### input configuration ends here#####


my $classPath="/home/soha/git/jpf-symbc/build/examples";

my $daikonScript_FileName="/home/soha/git/jpf-symbc/scripts/generate_invairant${benchmark}.sh";

my $trace_count=0;

open(DAIKONFH, '>', $daikonScript_FileName) or die $!;

print DAIKONFH "rm traces/*\n";

print DAIKONFH "mkdir traces\n";

#we first filter the test cases so that it calls the main with arguments seperated by spaces
open(FH, '<', $TC_FileName) or die $!;

while(<FH>){
  my $java_command = "java -cp ${classPath}:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Chicory --dtrace-file=../traces/${benchmark}-TC${trace_count}.dtrace.gz ${mainClassName}" ;

  #my $java_command = "java -cp $1:/home/soha/git/iDiscovery/daikon/daikon.jar daikon.Chicory --dtrace-file=traces/" . $benchmark . "-iter dtrace.gz" . $mainClassName ;

  my $line = $_;
  $line =~ s/launch//g;
  $line =~ s/,/ /g;
  $line =~ s/[()]/ /g;

  $line = $java_command . $line;
  $trace_count = $trace_count + 1;
  print DAIKONFH $line;
  #my $test = <>;
}
close(FH);

my $java_command = "\njava -cp ${classPath}:/home/soha/git/jpf-symbc/lib/daikon/daikon.jar daikon.Daikon ../traces/*.dtrace.gz --format java > ../daikonInv/daikon_invariants_${benchmark}.txt";
print DAIKONFH $java_command;

close(DAIKONFH);

#echo ">>analyze daikon traces for possible invariants"
#java -cp "/home/soha/git/iDiscovery/daikon/daikon.jar" daikon.Daikon traces/*.dtrace.gz --format java > daikon_invariants.txt
