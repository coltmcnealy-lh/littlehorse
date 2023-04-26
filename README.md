# LittleHorse Server

This repository contains the code for the core LittleHorse Server. It has a dependency on the `lh-jlib` repository's Java library.

For a description of the architecture, see the [architecture docs](docs/ARCH.md).

## LH Repository Inventory

The LittleHorse project currently has multiple repositories, described below:

-   [`lh-server`](https://bitbucket.org/littlehorse-core/lh-server)
    -   Code for the LittleHorse Server.
-   [`lh-jlib`](https://bitbucket.org/littlehorse-core/lh-jlib)
    -   Protocol Buffer definitions used by clients and the `lh-server` repo.
    -   Library for creating `WfSpec`'s in Java.
    -   Library for executing `TaskRun`'s in Java.
    -   Shared constants, including configuration constants used by the LH Server.
-   [`lh-golib`](https://bitbucket.org/littlehorse-core/lh-golib)
    -   The `lhctl` command line interface.
    -   Library for creating `WfSpec`'s in GoLang (under development).
    -   Library for executing `TaskRun`'s in GoLang (under development).
-   [`lh-jtests`](https://bitbucket.org/littlehorse-core/lh-jtests)
    -   A series of system integration tests used to verify the cohesive behavior of the LH Server, Java Workflow SDK, and Java Task Library together.
-   [`lh-operator`](https://bitbucket.org/littlehorse-core/lh-operator)
    -   Code for a K8s Init Container that sets up the LittleHorse config file based on the `topology.kubernetes.io/zone` and pod name.
    -   Scripts to deploy LittleHorse on KIND or EKS.
    -   (FUTURE) code for a LittleHorse Controller/Operator.
-   [`lh-proto`](https://bitbucket.org/littlehorse-core/lh-proto/src/master)
    -   The LittleHorse Protocol Buffer Specification.
    -   It is mounted as a `git submodule` in this repo, and a few others.

# Development

This section describes how to run the LittleHorse server in a development environment.

## Prerequisites

This repository requires the following system dependencies:

-   `openjdk`, preferably version 17 or later.
-   `gradle`, preferably version 7.4 or later.
-   `docker` and `docker-compose-plugin`
-   `npm` (this is a dev dependency)

Once you've set up your system, you _also_ need to publish the `lh-jlib` library to your local Maven repository. See the `README` on that repo for instructions.

Additionally, you'll eventually want to install `lhctl` as per the `lh-golib` repository.

### Setting Up the Linters

We have decided to use the [Prettier for Java](https://github.com/jhipster/prettier-java) linter. It is the same linter used by most Javascript projects but adapted for Java. Therefore, it requires Node.js as a prerequisite to run.

To install the formatter, all you need to do is first install Node.js as per the website, and then run:

```
npm install  # This uses the package.json
npm run format  # This runs the linters
```

This repository (and all other LittleHorse Java repo's) have the `.vscode` folder checked into source control. The `settings.json` file is configured properly to enable formatting on save, but you first need to install the `Prettier - Code formatter` extension by `esbenp` on VSCode.

Install all the extensions:

```bash
jq ".recommendations[]" .vscode/extensions.json | xargs -L1 codium --install-extension
```

### Git Submodule (For Protocol Buffers)

As mentioned before, there is a Git Submodule for the `lh-proto` repo. The reason why we include that submodule in this repo is slightly complex--recall that the `lh-jlib` repository contains compiled Java code for all of the protobuf in `lh-proto`. What gives?

Well, there are some internal (i.e. not public-facing) API's defined in the `proto/` section of this repository. In order to compile those protocol buffers, we need to include the standard LittleHorse Proto in our classpath. One way to do that would be to require everyone to set a proto classpath env var; alternatively, we chose to just put the code here in this repo.

In order to compile the protocol buffers after making a change to `lh-proto`, `lh-jlib`, or `proto/internal_server.proto`, you first need to add the git submodule (this needs to be done only once):

```
git submodule init
git submodule update
cd proto/lh-proto
git checkout master && git pull
cd ../..
```

Then, you can make changes to `lh-proto/internal_server.proto`, and compile those as follows:

```
./local-dev/compile-proto.sh
```

When making changes to the upstream `lh-proto` repository, it is recommended to push your changes on the protocol buffer repository to some branch (`foo`). Then, you can:

```
cd proto/lh-proto
git fetch && git checkout foo && git pull
cd ../..
./local-dev/compile-proto.sh
```

## Setup Pre-commit

```bash
pre-commit install
```

## Running LH

The LH Server depends on Kafka as a backend database. To start Kafka using docker compose, you can run:

```
./local-dev/setup.sh
```

Next, you can start the LH server itself. The server can be started in a single command:

```
./local-dev/do-server.sh
```

You can confirm that the Server is running via:

```
-> lhctl search wfSpec
{
  "code":  "OK",
  "objectIds":  []
}
```

## Configuring Clients

When you run the LH Server according to the command above, the API Host is `localhost` and the API Port is `5000`.

Also note that mTLS will NOT be enabled; therefore, you should not have any client keys or certs configured in your `~/.config/littlehorse.config` if you wish to interact with the LH Server running in your terminal as per this README.

At this point, you're ready to consult the `README` in the `lh-jlib` repository for a tutorial on how to run your first workflow.

## Building the Image

The LittleHorse docker image (for now) requires the `lhctl` command line client, which is used for Kubernetes Health Checks. (That's a longer story).

Before you can build the image, you should compile the `lhctl` binary in the `lh-golib` repository, and then `cp $(which lhctl) ./build/`.

Now you can build the `littlehorse` docker image by running:

```
./local-dev/build.sh
```

Run server with docker (default config `local-dev/server-1.config`):

```
./local-dev/do-docker-server.sh
```

Run server with docker and specific config:

```
./local-dev/do-docker-server.sh <config-name>

# Example
./local-dev/do-docker-server.sh server-2
```

This step is needed to develop on KIND.

## Advanced

This section covers more advanced topics that you'll need to know when modifying the actual LH Server code.

### Running Multiple LH Servers

LittleHorse is a distributed system in which the different LH Server Instances (Brokers) need to communicate with each other. For example (among many others), all GET requests on the API use Interactive Queries, which involves requests between the different Brokers. Therefore, you'll need to be able to test with multiple brokers running at once.

Running two brokers is slightly tricky as you must configure the ports, advertised hostnames, and Kafka group instance ID's correctly.

However, you can start two Brokers in your terminal as follows:

```
# The first server has an external API port of 5000
./local-dev/do-server.sh

# <In another terminal>
# The second server has an external API port of 5002
./local-dev/do-server.sh server-2
```

> ./local-dev/do-server.sh <config-name>

### Debug Cycle

To "reset" the LittleHorse cluster, you need to delete the data in Kafka and also delete the KafkaStreams RocksDB state. That can be done as follows:

1. Stop all LH Server processes.
2. Run `./local-dev/refresh.sh`.
3. Start the LH Servers again.

### Linting

Due to the horrendous Java ecosystem of linters, we are actually using Prettier from the JavaScript community. There is a [Prettier Java Plugin](https://github.com/jhipster/prettier-java) which adapts Prettier to the Java environment.

Install the linters via:

```
npm install
```

Run the linters via:

```
npm run format
```

If you use VSCode, the `.vscode` directory I've checked in configures the linters to run upon every file save. Obviously, we will stop checking in IDE config files in the future, but this is just to get us started.

## Cleanup

You can clean up (i.e. stop Kafka and delete the data from the state directory) as follows:

```
./local-dev/cleanup.sh
```
