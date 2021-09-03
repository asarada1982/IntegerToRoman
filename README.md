# API to convert Integer to Roman Number
  Rest API to convert integer to a roman number, for integers between 1-3999.

## How to build and run this project?

### Option 1: Using Docker Image

Execute following docker commands 

Step 1: docker pull asarada1982/assignment <br>
Step 2: docker run -it --rm -p 8080:8080 asarada/assignment <br>

Accessing the Program using rest API(get) below.
Usage: http://localhost:8080/romannumeral/?query=1001

### Option 2: Deploying pre built war file
Step 1: Download <a href="https://github.com/asarada1982/assignment_1/blob/main/target/romannumeral.war">romannumeral.war</a> <br>
Step 2: Deploy it on any Web Application server <br><br>

Usage: http://localhost:port/romannumeral/?query=1001

### Option 3: Cloning Git repository 

Step 1: git clone https://github.com/asarada1982/assignment_1.git <br>
Step 2: Open any Maven supported ide. (This project is created using IntelliJ) <br>
Step 3: Open the project from cloned directory <br>
Step 4: Build the Project <br>
Step 5: Deploy the war file on the Web application Server.



## Your engineering and testing methodology

1. junit test cases had been build and the method is tested using junit<br>
2. by accessing the rest api.


## Your packaging layout

### Source Code path
assignment_1/src/main/java/com/asarada/romannumeral/ <br>

### junit test case source path
assignment_1/src/test/java/com/asarada/romannumeral/<br>
Web Archive: assignment_1/target/romannumeral.war

## Dependency attribution?
All the library dependencies are resolved/pulled using maven <br>
POM file location : assignment_1/pom.xml 

## Java doc

Location: assignment_1/doc/

Usage: 
Clone the reposit<br><br>

Step 1: git clone https://github.com/asarada1982/assignment_1.git<br>
Step 2: Navigate to assignment_1/doc/<br>
Step 3: Open index.html
