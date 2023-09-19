# Student

This project can be used as application for storage information about students with simple UI.

## Running the application
The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.


## Deploying to Production
To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw  clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).

## Project structure

- `Student.java` in `src/main/java/entity` This class is a Java entity class used to represent a student in a system.
- `H2Config` package in `src/main/java/config` This class is a configuration class used in a Java application to configure and initialize the H2 database.
- `StudentRepository` package in `src/main/java/repository` This interface is a Spring Data repository interface used to interact with the database for the Student entity.
- `Form` folder in `ui/` This class is a Vaadin-based UI component representing a form for managing student data.
- `StudentEditor` folder in `ui/`  It represents an editor for managing student data.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorials at [vaadin.com/tutorials](https://vaadin.com/tutorials).
- Watch training videos and get certified at [vaadin.com/learn/training]( https://vaadin.com/learn/training).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/components](https://vaadin.com/components).
- Find a collection of solutions to common use cases in [Vaadin Cookbook](https://cookbook.vaadin.com/).
