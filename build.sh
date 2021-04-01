#!/bin/sh

echo "build project And docker image"

# mvn clean package -Dmaven.test.skip=true -Ddockerfile.skip=true  -Pkubernetes
mvn clean package -Dmaven.test.skip=true -Pkubernetes

echo "clean docker images"

docker system prune -f

a=`uname  -a`

b="Darwin"
c="centos"
d="ubuntu"

if [[ $a =~ $b ]];then
    echo "mac"
elif [[ $a =~ $c ]];then
    echo "centos"
elif [[ $a =~ $d ]];then
    echo "ubuntu"
else
    echo $a
fi
