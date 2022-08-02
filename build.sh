#/bin/bash

mvn package;
scp ./target/socialContactApp-0.0.1-SNAPSHOT.jar root@180.76.98.70:~/Documents/temp
