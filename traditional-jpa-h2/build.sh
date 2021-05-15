#!/usr/bin/env bash

#mvn -U clean package -Dmaven.test.skip=true
#export MI=src/main/resources/META-INF
#rm -rf $MI
#mkdir -p $MI

#java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar ./target/tradational-0.0.1-SNAPSHOT.jar

#trap ctrl_c INT
#tree $MI

#mvn -Pnative clean package
############

ARTIFACT=${1}
MAINCLASS=${2}
VERSION=${3}

JAR="${ARTIFACT}-${VERSION}.jar"

rm -rf target
mkdir -p target/native-image
mvn -ntp package -Dmaven.test.skip=true
rm -rf "$ARTIFACT"

cd target/native-image

jar -xvf ../"$JAR"

cp -R META-INF BOOT-INF/classes

LIBPATH=$(find BOOT-INF/lib | tr '\n' ':')

CP=BOOT-INF/classes:$LIBPATH

GRAALVM_VERSION=$(native-image --version)

time native-image --verbose --trace-class-initialization=sun.instrument.InstrumentationImpl --initialize-at-run-time=org.hibernate.internal.util.ReflectHelper --enable-all-security-services --trace-class-initialization -H:+ReportExceptionStackTraces -H:EnableURLProtocols=http -H:+RemoveSaturatedTypeFlows -H:Name="$ARTIFACT" -Dspring.native.verbose=true -Dspring.native.remove-jmx-support=true -Dspring.native.remove-spel-support=true -Dspring.native.remove-yaml-support=true -Dspring.graal.dump-config=/tmp/computed-reflect-config.json -cp "$CP" "$MAINCLASS"


 # --trace-class-initialization  --initialize-at-run-time=org.hibernate.internal.util.ReflectHelper --initialize-at-build-time=sun.instrument.InstrumentationImpl --trace-class-initialization=sun.instrument.InstrumentationImpl