mvn -U clean package -Dmaven.test.skip=true
export MI=src/main/resources/META-INF
rm -rf $MI
mkdir -p $MI
java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar ./target/tradational-jpa-1.0.0-SNAPSHOT.jar
tree $MI
mvn -Pnative clean package