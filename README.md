# xUML-RT Model Executor [![Build Status](https://travis-ci.org/ELTE-Soft/xUML-RT-Executor.svg?branch=master)](https://travis-ci.org/ELTE-Soft/xUML-RT-Executor)

The *xUML-RT Model Executor* is built on top of the Papyrus UML editor and provides model execution and debugging capabilities for an executable variant of the UML-RT language. The Model Executor is integrated in Eclipse and can be used to visually debug an executable UML model. It  is also packaged as a command line tool to support automated test case execution, integrated in test frameworks.

Webpage: http://modelexecution.eltesoft.hu/

## Build instructions

### Building in Eclipse

1. Install [Eclipse Mars SR1 Modeling Tools](http://www.eclipse.org/downloads/packages/eclipse-modeling-tools/mars1)
2. Import all projects from the repository root, except `TestModels`
3. Load and activate the target platform specification from `releng/hu.eltesoft.modelexecution.target/release.target`
4. Rebuild all projects
5. Start a guest Eclipse with a new `Eclipse Application` launcher.

#### Running Maven build from Eclipse

Use the build launcher named `clean-verify-release` in project `releng/hu.eltesoft.modelexecution.parent`.

### Building with Maven from command line

1. Install [Apache Maven 3.x](https://maven.apache.org/download.cgi)
2. Go to the `releng/hu.eltesoft.modelexecution.parent` directory
3. Run `mvn -Prelease clean verify` to build and test the whole system
4. Install the Eclipse update site zip generated under `releng/hu.eltesoft.modelexecution.update/target/` into an Eclipse
