# Use a specific version of OpenJDK
FROM  openjdk:19

# Set the working directory inside docker
WORKDIR /application

# Copy the JAR file
COPY /target/TextEditor-1.0-SNAPSHOT-jar-with-dependencies.jar ./NewOne-1.0.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "NewOne-1.0.jar"]
