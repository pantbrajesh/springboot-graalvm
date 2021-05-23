<h1>Comparing Startup time & Memory footprint for reactive application</h1>

![Image of Yaktocat] (https://github.com/pantbrajesh/springboot-graalvm/tree/master/reactive-h2/images/StandardBootTime.png)

The standard way takes about ```6.311``` seconds to start up and it uses around ```767``` MB of RAM:

![Image of Yaktocat] (https://github.com/pantbrajesh/springboot-graalvm/tree/master/reactive-h2/images/StandarMemory.png)

Now comparing our Natively compiled Spring Boot App, we see a startup time of about ```1.295``` seconds:

![Image of Yaktocat](https://github.com/pantbrajesh/springboot-graalvm/tree/master/reactive-h2/images/NativeBootTime.png)

and uses only ```165MB``` of RAM:

![Image of Yaktocat](https://github.com/pantbrajesh/springboot-graalvm/tree/master/reactive-h2/images/NativeMemory.png)

So with a default Spring App we have around ```800MB``` memory consumption, a natively compiled Spring App has only ```165MB``` . 
That means, we could run more than ```4``` Spring microservices with the same amount of RAM we needed for only one standard Spring microservice.

