# Welcome to Swarmic

Swarmic is a CDI based project to create small standalone Java SE applications integrating different technologies and framework through CDI.

Swarmic is targeted to CDI 2.0, since it's the first version supporting Java SE boot.
Right now example are developed using JBoss Weld reference implementation but they will be ported to Apache OpenWebBeans when SE boot support will be added to this implementation.


## Current status

Swarmic is in it's early stage. For the moment we only provide the following features:

* Servlet engine integration with Jetty and Undertow support
* Jax-RS integration with Resteasy support
* Basic security support with custom security annotation and interceptors

Project also provides following examples

* Rest service
* Camel and Metrics integration thanks to Camel-CDI and Metrics CDI projects

Examples can be ran directly from maven or from a fat jar embedding all required dependencies.

## Building

Before playing with examples, make sure to install `bom`, `parent` `core` and `fractions` artifacts in your local maven repo by issue the following command at the root of the repo.

`mvn clean install`

You can then take a look at existing examples.

## Feedback

You can join the swarmic development team on the following channels:

* Gitter [chat room](https://gitter.im/swarmic/devs?utm_source=share-link&utm_medium=link&utm_campaign=share-link)
* Google [group & mailing list](https://groups.google.com/forum/#!forum/swarmic)
* Of course you can fill an issue and send a pull request directly on this repo