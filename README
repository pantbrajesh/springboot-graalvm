This is a sample project using spring boot and graalvm with in memory database.

GraalVm : https://www.graalvm.org/
 
Spring Boot : https://spring.io/projects/spring-boot


Let's get started. You're going to need to install GraalVM. You could download it from  https://www.graalvm.org/

Once you have installed it, you will also need native-image builder component seperately. Run below command 

```shell
gu install native-image
```

```gu ``` is the utility that you get in graalvm. 

Also make sure your ``` JAVA_HOME ``` is set and pointing to graalvm. This is how it looks on my machine

```shell
java -version
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment GraalVM CE 21.1.0 (build 11.0.11+8-jvmci-21.1-b05)
OpenJDK 64-Bit Server VM GraalVM CE 21.1.0 (build 11.0.11+8-jvmci-21.1-b05, mixed mode, sharing)
```

To Run the project clone and run the below command

```shell
mvn -Pnative clean package -Dmaven.test.skip=true
```
