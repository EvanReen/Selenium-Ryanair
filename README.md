# Selenium-Ryanair
Automating tests for Ryanair website.
Note: seat selection. Seats might be booked/taken in the process so if the tests fail that will be the case. 

# Requirements
- Latest Java version (Java 17)
- maven
- chrome web driver
- docker desktop
- If all steps to run this fail you can simply download the zip file of this project and import it into Eclipse IDE. Here is a link to help you with that:
    https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/How-to-import-a-Maven-project-from-GitHub-into-Eclipse
# Steps to run this: 

## Step 1: Clone Git Repo

- git clone https://github.com/EvanReen/Selenium-Ryanair.git

## Step 2: Change your directory to the project folder:

- cd ProjectFolder

## step 3: run the following commands 

1: mvn clean install

2: docker build -t ryanair-selenium-image .

3: docker run -d -p 4444:4444 --name selenium-chrome ryanair-selenium-image

## step 3 : run 'docker ps' command and copy the container ID and then run this command 

- docker exec -it container-id bash

## step 4: run it usinhg this command

- java -cp .:/usr/src/app/target/classes:/usr/src/app/target/libs/* RyanairTest.java


