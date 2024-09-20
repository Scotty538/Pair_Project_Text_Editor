# 159251 Assignment 1 - Text Editor

Alex Malone (23013729) & Scott O'Connor (96028881)

## Instructions
### Run the Program
Open the project file in an IDE and run the TETextEditor.java file.
Alternatively, from within the project directory, type the following in the command line:
```
mvn compile
```
```
mvn exec:java
```
### Run with Docker
1. To create the image, run the following commands from the root project directory:
   
   ```
   mvn clean install
   docker build -t app .
   ```
3. Then run the container with: (Note that you may need to change the port if it is already in use)
   ```
   docker run -p 8080:8080 -d app
   ```

## Notes
### Notable Directories
The `reports` directory contains the metrics and reports for the project.
- The `metrics` sub-directory contains metrics generated with the MetricsReloaded plugin
- The `pmd` sub-directory contains the automated pmd report and metrics in html/css format

The `src/main/resources` directory contains a `config.yaml` file which specifies the default font configurations for the text editor

### Github Actions CI Pipeline
The 'Run Maven Build' Actions workflow contains a `build.yaml` file which automates the `mvn clean test` command on each push to the github remote repository
You can track the build status of the commits under the Github Actions tab

### Search Feature
To use the search feature, type any word in the search bar to check if it is in the document
Searching for `""` will clear the highlighted word

## Most significant git commit IDs
### Alex
- [#13a3dc5](https://github.com/Scotty538/251-Assignment1-2024-Alex-Scott/commit/13a3dc5f295446d84e9a70dfd5b5fa9ada44a3e3)
- [#005df90](https://github.com/Scotty538/251-Assignment1-2024-Alex-Scott/commit/005df901021e09ee76c6a72c4fa2f6d8b55373e2)

### Scott
- [#696964e](https://github.com/Scotty538/251-Assignment1-2024-Alex-Scott/commit/696964ea2550572bd05c6492003c06419ca0eeef)
- [#05012be](https://github.com/Scotty538/251-Assignment1-2024-Alex-Scott/commit/05012bed307c580a2690e95f3e08c603700f6291)


## Gitub Repository Link
https://github.com/Scotty538/251-Assignment1-2024-Alex-Scott

