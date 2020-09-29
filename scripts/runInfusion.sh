# this is running the valid properties and using mutation for them

alias runDiscovery='LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/soha/git/jpf-symbc/lib TARGET_CLASSPATH_WALA=/home/soha/git/jpf-symbc/build/examples/ java -Djava.library.path=/home/soha/git/jpf-symbc/lib -ea -Dfile.encoding=UTF-8 -jar /home/soha/git/jpf-core/build/RunJPF.jar '

#-Xmx1024m

shopt -s expand_aliases

DISCOVERYDIR=/home/soha/git/jpf-symbc

runDiscovery $DISCOVERYDIR/src/examples/infusion/infusion.jpf >& $DISCOVERYDIR/logs/infusion.log
