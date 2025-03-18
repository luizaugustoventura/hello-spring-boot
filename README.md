# hello-spring-boot

This is a simple project I created in order to learn the basics of Java Spring Boot

## Main commands:

* `mvn clean install`: Installs (or reinstalls) the dependencies
* `mvn clean package`: Compiles the project, creating an executable in the `target` folder


Steps to run the project in a Docker container:

1. Create an executable running `mvn clean package`
2. Enter the `target` directory and copy the generated **.jar** file: `cd target && cp *.jar app.jar`
3. Execute the application: `java -jar app.jar`