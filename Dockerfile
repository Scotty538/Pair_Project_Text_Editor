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

# The following code will get the text editor deployed and running inside the Docker container.
#
#
## Use an official Ubuntu base image
#FROM ubuntu:20.04
#
## Set environment variables to avoid interactive prompts during installation
#ENV DEBIAN_FRONTEND=noninteractive
#
## Install Xvfb, Java, and other utilities
#RUN apt-get update && \
#    apt-get install -y \
#    xvfb \
#    openjdk-17-jdk \
#    x11vnc \
#    && rm -rf /var/lib/apt/lists/*
#
## Set the working directory inside docker
#WORKDIR /application
#
## Copy the JAR file
#COPY /target/TextEditor-1.0-jar-with-dependencies.jar ./NewOne-1.0.jar
#
## Expose the port the app runs on
#EXPOSE 8080
#
## Set environment variables
#ENV DISPLAY=:99
#
## Command to start Xvfb and run your application
#CMD Xvfb :99 -screen 0 1024x768x24 & x11vnc -display :99 -N -forever & export DISPLAY=:99 && java -jar NewOne-1.0.jar
#
