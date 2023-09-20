 FROM selenium/standalone-chrome:latest

# Switch to the root user temporarily to install packages
USER root

# Install Chrome and required dependencies
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    curl \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install Java (if not already installed in the base image)
RUN apt-get update && apt-get install -y openjdk-17-jre

# Install Chrome WebDriver
RUN apt-get install -y chromium-chromedriver

# Install Maven (if you are using it for your project)
RUN apt-get install -y maven

# Set the working directory
WORKDIR /usr/src/app

# Copy your Selenium test script into the container
COPY src/test/RyanairTest.java /usr/src/app/

# Copy the project's pom.xml and src directory to the container
COPY pom.xml .
COPY src ./src
COPY target ./target

  
# Cleanup to reduce image size
RUN apt-get remove -y wget unzip curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /root/.m2

# Switch back to the default user
USER seluser





