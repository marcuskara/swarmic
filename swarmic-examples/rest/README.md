# Rest Example

This example show how to build a Jax-RS service using Undertow and Resteasy fragmenets


## Building

Before playing with samples, make sure to install `bom` and `parent` artifacts in your local maven repo by issue the following command at the root of the repo.

`mvn clean install`

You can then take a look at existing samples.


## Running from maven

Once built, you can run the example with

`mvn exec:exec`

You can then test the Rest service with url (with curl or your browser)

`http://localhost:8080/hello/swarmic`

Answer should be `Hello : swarmic`

## Building and running from fat jar

You can crate a fat jar containing all resources to run this example just enter the following command:

`mvn clean install -Pjar`

Then you can launch the service with:

`java -jar ./target/swarmic-rest.jar`


## Feedback

You can join the swarmic development team on the following channels:

* Gitter [chat room](https://gitter.im/swarmic/devs?utm_source=share-link&utm_medium=link&utm_campaign=share-link)
* Google [group & mailing list](https://groups.google.com/forum/#!forum/swarmic)
* Of course you can fill an issue and send a pull request directly on this repo