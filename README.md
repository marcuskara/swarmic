# Swarmic

Swarmic is a CDI based project to create small standalone Java SE applications integrating different technologies and framework through CDI.

Swarmic is targeted to CDI 2.0, since it's the first version supporting Java SE boot.
Right now example are developed using JBoss Weld reference implementation but their will be ported to Apache OpenWebBeans when SE boot support will be added to this implementation.


## Current status

Swarmic is in it's early stage. For the moment we only demonstrate the following features:

* Camel integration thanks to Camel-CDI project
* Fat Jar building with the Maven Shaded plugin

Both are demonstrated in camel-metrics sample.

## Building

Before playing with samples, make sure to install `bom` and `parent` artifacts in your local maven repo by issue the following command at the root of the repo.

`mvn clean install`

You can then take a look at existing samples.

## Feedback

You can join the swarmic development team on the following channels:

* Gitter [chat room](https://gitter.im/swarmic/devs?utm_source=share-link&utm_medium=link&utm_campaign=share-link)
* Google [group & mailing list](https://groups.google.com/forum/#!forum/swarmic)
* Of course you can fill an issue and send a pull request directly on this repo




