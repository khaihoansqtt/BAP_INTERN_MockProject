#### SETUP PROJECT

##### 1. Environment preparation

- Create database in mysql
- Update url datasource to the configuration file (application-local.yml for local environment, application-dev.yml for develop environment, application-prod.yml for production environment)
- Update spring.profiles.active in the application.yml file to set the profile for the application (If you do not specify a value, the application will take the default value is "local")

##### 2. Build Project

2.1 Build by IntelliJ

- Open Run/Debug Configurations popup by click menu Run/Edit Configurations...
- Add new Spring Boot Configuration 
- Input "com.base.Application" to Main class field
- Run Project

2.2 Build by cmd

- Open cmd in root folder (project folder) and run command line: `./gradlew -P<env> bootJar` (env values: local, dev, prod)
- If there is no -P<env> option then the "local" profile will be selected

Note: Read Wiki for more details

##### 3. CheckStyle
Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard.

Run command line: `./gradlew check`

##### 4. Mapstruct
Java bean mappings, the easy way!

https://mapstruct.org/
