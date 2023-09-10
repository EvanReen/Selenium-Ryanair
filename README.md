# Selenium-Ryanair
Automating tests for Ryanair website.
Note: seat selection. Seats might be booked/taken in the process so if the tests fail that will be the case. 

# Requirements
- Latest Java version (Java 17)
- maven
- chrome web driver
- If all steps to run this fail you can simply clone this repo in Eclipse. Here is a link to help you with that:
    https://qaautomation.expert/2023/02/20/how-to-clone-a-project-from-github-using-eclipse/
# Steps to run this: 

## Step 1: Clone Git Repo

- git clone https://github.com/EvanReen/Selenium-Ryanair.git

## Step 2: Set Up Java Development Environment

- Ensure you have Java Development Kit (JDK) installed. You can download it from the official Oracle website or use OpenJDK.

## Step 3: Set Up WebDriver

- Download the WebDriver compatible with your browser (e.g., ChromeDriver for Google Chrome) and place it in a directory that's in your system's PATH.
- Make sure you have the correct WebDriver version for your browser.

## Step 4: Configure TestNG (if not already done)

## Step 5: Install Dependencies (if using Maven)

- If the project uses Maven for dependency management, navigate to the project's root directory in your terminal and run:
- mvn clean install

## Step 7: Run the Tests

- Open a terminal or command prompt.
- Navigate to the project's root directory.
- Execute the following command to run the tests using TestNG:
- mvn test
