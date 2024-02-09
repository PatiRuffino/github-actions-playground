# Application Introduction

- The application consists in simple Spring Boot API with two GET endpoints, where one of them returns an object with message “Hello World” and the other one the same object with the message “Goodbye!”
- The API contains two unit tests that will be important for the pipeline process
- The application is containerized using Docker

# Technical Requirements

- To run the application, you must have
  - Java 21+
  - Maven

# CI/CD - Foundational

## Lab #1 - Continuos Integeration

- The main purpose of this lab is to build a Continuous Integration process for a Java application using Github Actions. This CI pipeline must run only when a push is done to the main branch. The pipeline should contain the following steps
    - **Build and Test**
        - Build and Run all unit tests of application
            - After execute all unit tests, the test report must be uploaded as an artifact
    - **Mutation Testing**
        - Run mutation tests using Maven. The tool to perform mutation testing is already configured in the application. You only need to perform Maven commands in the pipeline to execute them
            - After execute all mutation tests, the test report must be uploaded as an artifact
            - Use the command below to execute the mutation tests
          ```text
          mvn test-compile org.pitest:pitest-maven:mutationCoverage
          ```

    - **Security Validation**
        - The application already has OWASP configured in Maven. Your mission here is to run maven command in the pipeline to perform the dependency check using command below
      ```text
      mvn -B verify --file pom.xml -DskipTests
      ```
    - **Push image to DockerHub**
        - After execute all the steps, it is time to build the docker image and make it available in a registry, which in our case will be docker hub
        - To be able to perform a build, you can use <a href="https://github.com/docker/build-push-action">this</a> official docker action

## Lab #2 - Pull Request Automation

- The main purpose of this lab is to build an automation that will run only when a pull request is opened for the main branch. The automation must include the following steps
    - **Build and Test**
        - Build and Run all unit tests of application
            - After execute all unit tests, the test report must be uploaded as an artifact
    - **Security Validation**
        - The application already has OWASP configured in Maven. Your mission here is to run maven command in the pipeline to perform the dependency check using command below
      ```text
       mvn -B verify --file pom.xml -DskipTests
      ```
  
