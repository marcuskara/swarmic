# Camel Metrics Example

This example show how to build a Camel services using Camel-CDI and Metrics-CDI

Application class configure a Camel route which try to reach an unreliable service bean (defined by `UnreliableService` class) each second.

Successful attempts to reach the service are stored in metrics.
If the service fails (50 % chance of failure), the route is retried maximum twice.
These retries are also stored in metric.

Fatal error after retries are also stored in metrics.

All registered metrics are reported to a Slf4j metric reporter which display all event on the console.

The example show you the possibilities given by Camel-CDI to create Camel routes, Metrics CDI to register new Metrics and new reporter to work with reporting info and of course how swarmic can embedded all these in a standalone application.

## Building

Before playing with samples, make sure to install `bom` and `parent` artifacts in your local maven repo by issue the following command at the root of the repo.

`mvn clean install`

You can then take a look at existing samples.


## Running from maven

Once built, you can run the example with

`mvn exec:exec`

You'll see all the reporting regarding Camel route displyed on the console.


## Building and running from fat jar

You can crate a fat jar containing all resources to run this example just enter the following command:

`mvn clean install -Pjar`

Then you can launch the service with:

`java -jar ./target/swarmic-camel.jar`


## Feedback

You can join the swarmic development team on the following channels:

* Gitter [chat room](https://gitter.im/swarmic/devs?utm_source=share-link&utm_medium=link&utm_campaign=share-link)
* Google [group & mailing list](https://groups.google.com/forum/#!forum/swarmic)
* Of course you can fill an issue and send a pull request directly on this repo