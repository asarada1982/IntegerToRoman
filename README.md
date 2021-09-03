# API to convert Integer to Roman Number
  Rest API to convert integer to a roman number, for integers between 1-3999.

## How to build and run this project?

### Option 1: Using Docker Image

Execute following docker commands 

Step 1: docker pull asarada1982/assignment
Step 2: docker run -it --rm -p 8080:8080 asarada/assignment

Accessing the Program using rest API(get) below.
Usage: http://localhost:8080/romannumeral/?query=1001

### Option 2: Cloning Git repository
Step 1: Download <a href="https://github.com/asarada1982/assignment_1/blob/main/target/romannumeral.war">romannumeral.war</a>
Step 2: Deploy it on any Web Application server

Usage: http://localhost:port/romannumeral/?query=1001

### Option 3: Cloning Git repository 

Step 1: git clone https://github.com/asarada1982/assignment_1.git

Step 2: Open any Maven supported ide. (This project is created using IntelliJ)

Step 3: Open the project from cloned directory

Step 4: Build the Project

Step 5: Deploy the war file on the Web application Server.



## Your engineering and testing methodology

1. junit test cases had been build and the method is tested using junit
2. by accessing the rest api.


## Your packaging layout

### Source Code path
assignment_1/src/main/java/com/asarada/romannumeral/ <br>

### junit test case source path
assignment_1/src/test/java/com/asarada/romannumeral/

Web Archive: assignment_1/target/romannumeral.war

## Dependency attribution?
All the library dependencies are resolved/pulled using maven 
assignment_1/pom.xml 
