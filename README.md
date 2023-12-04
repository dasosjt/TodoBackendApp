# TodoBackendApp

TodoBackendApp is a Spring Boot application that serves as a backend for a simple Task application. It utilizes the Spring Boot Starter Parent with a version of 3.2.0 and is configured to work with Spring Boot 2.5.0.

## Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Building the Project](#building-the-project)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The project is structured as a Maven project and incorporates the Spring Boot framework. It provides a RESTful API for managing Task items using reactive programming with Spring WebFlux and R2DBC.

## Prerequisites

Before running the TodoBackendApp, ensure that you have the following prerequisites installed:

- Java 17
- Maven

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/dasosjt/TodoBackendApp.git
    ```

2. Navigate to the project directory:

    ```bash
    cd TodoBackendApp
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage

To run the TodoBackendApp, use the following Maven command:

```bash
mvn spring-boot:run
```

The application will start, and you can access the Task API at `http://localhost:8080/api/v1/task/`.

## Dependencies

- **Spring Boot Starter Data R2DBC**: Provides the necessary dependencies for R2DBC (Reactive Relational Database Connectivity).
- **Spring Boot Starter WebFlux**: Starter for building web applications using Spring WebFlux.
- **H2 Database**: An in-memory database used during development and testing.
- **R2DBC H2**: R2DBC driver for H2 database.
- **Spring Boot Configuration Processor**: Helps with the generation of configuration metadata files.
- **Project Lombok**: A library to simplify Java code by providing annotations for common tasks.
- **Spring Boot Starter Test**: Starter for testing Spring Boot applications.
- **Reactor Test**: Testing support for Reactor, which is used in the reactive components of the application.

## Building the Project

The project uses the Spring Boot Maven plugin for building. You can build the project using the following command:

```bash
mvn clean install
```

## Testing

The project includes unit tests for various components. Run the tests using:

```bash
mvn test
```

## Contributing

If you'd like to contribute to this project, please follow the [Contribution Guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).