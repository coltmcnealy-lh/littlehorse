# Contributing

The LittleHorse Server project is open-source according to the Server-Side Public License 1.0, and as such we appreciate any contributions to our codebase. Please note that all contributions will be subject to that license agreement.

This document details all of the necessary information for contributing to LittleHorse.

**Table of Contents**
- [Getting Started](#getting-started)
- [Running Examples](#running-examples)
- [Writing a Pull Request](#writing-a-pull-request)

## Getting Started

This section details how to set up your machine to develop LittleHorse.

### Prerequisites

This repository requires the following system dependencies:

- `java`
    - [sdk-java](sdk-java): Java 11
    - [server](server): Java 17
- `gradle`, preferably version 8 or later.
- `docker` and `docker-compose-plugin`.
- `go`, `protoc`, `protoc-gen-go`, `protoc-gen-go-grpc` and `protoc-gen-grpc-java`.
    - [Protocol Buffer Compiler](https://grpc.io/docs/protoc-installation/)
    - [Java gRPC compiler plugin](https://github.com/grpc/grpc-java/blob/master/compiler/README.md)
    - This needs to be put somewhere in your `PATH`.
- `pre-commit` (this is a dev dependency)
- `python` and [poetry](https://python-poetry.org/).
    - [sdk-python](sdk-python): >= 3.9
- `nvm` and `node` >= 20

### Setup Pre-commit

https://pre-commit.com/ is a framework for managing and maintaining multi-language pre-commit hooks.

```bash
pre-commit install
```

- Only java:

  ```
  export SKIP=install-python,install-dashboard,install-sdk-js,format-python,format-go,format-sdk-js,lint-python,mypy,go-tests,python-tests,dashboard-build,dashboard-tests,sdk-js-tests
  ```

- Only go:

  ```
  export SKIP=install-python,install-dashboard,install-sdk-js,format-python,format-java,format-sdk-js,lint-python,mypy,python-tests,dashboard-build,dashboard-tests,sdk-js-tests,java-build,javadoc
  ```

- Only python:

  ```
  export SKIP=install-dashboard,install-sdk-js,format-go,format-java,format-sdk-js,dashboard-build,dashboard-tests,sdk-js-tests,java-build,javadoc,go-tests
  ```

- Only js:

  ```
  export SKIP=install-python,format-java,format-python,format-go,lint-python,mypy,java-build,javadoc,go-tests,python-tests
  ```

### Setting up Dev Dependencies

LittleHorse depends upon Kafka as its backing data store. You can set up Kafka via:

```
./local-dev/setup.sh
```

Note that this will also set up a Keycloak container in case you want to test LittleHorse's OAuth capabilities.

### Running the Server

In `local-dev` there are various scripts to help debug. The simplest way to run LittleHorse locally is via:

```
./local-dev/do-server.sh
```

You can pass a configuration file name to `do-server.sh` to run the LH Server with a specific configuration. For example, if you want to run two LH Servers together to test their communication via interactive queries, you can:

```
./local-dev/do-server.sh server-1

# open a new terminal
./local-dev/do-server.sh server-2
```

### Configuring your clients

For the standard server, the default client configuration should work. Note that by default, `lhctl` checks `~/.config/littlehorse.config` for configuration options.

```
LHC_API_HOST=localhost
LHC_API_PORT=2023

# For task workers
LHW_SERVER_CONNECT_LISTENER=PLAIN
```
_NOTE: The configurations above are indeed the defaults._

## Running Examples

We provide a number of examples to use our SDK for defining a `WfSpec`. It may help to run a few of these and become familiar with the platform when developing for LittleHorse.

- [Java Examples](https://github.com/littlehorse-enterprises/littlehorse/tree/master/examples)
- [Python Examples](https://github.com/littlehorse-enterprises/littlehorse/tree/master/sdk-python/examples)
- [Go Examples](https://github.com/littlehorse-enterprises/littlehorse/tree/master/sdk-go/examples)



## Writing a Pull Request

Here at LittleHorse, we use the [Conventional Commits v1.0.0](https://www.conventionalcommits.org/en/v1.0.0/) specification for writing pull request messages.

Conventional Commits provides a standardized format for describing proposed changes and provides semantic versioning support for certain *types* of changes.

The basic structure of a conventional commit message is as follows.

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

Certain *types* of commits correlate to semantic versioning updates:

- fix: PATCH
- feat: MINOR
- a commit with the footer `BREAKING CHANGE:` or a `!` after the type/scope

You should reference the Conventional Commits v1.0.0 [website](https://www.conventionalcommits.org/en/v1.0.0/) for additional *types*, detailed specification rules, examples, and FAQs about the practice before making a pull request.