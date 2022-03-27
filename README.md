# CreditCardApp
CreditCard Application 
# Getting Started

Please extract the contents of ZIP file into a empty folder

Open the project in IntelliJ Maven pointing to the CreditCardApp\pom.xml

###Development environment
* Java 11
* latest Spring 2.6.3
* Swagger
* Junit
* H2 
* IntelliJ 2921.3.2 (ultimate Edition)
* Windows 11 Home


CreditCardApp\src\main\resources\data.sql
contains some dummy data which can be accessed using H2 console.

The application has 5 test convering few areas of controller, repository, main class, validator

This application contains Swagger 

* #### http://localhost:8080//swagger-ui.html

H2 Console

* ####http://localhost:8080/h2


Assumptions
* CreditCard numbers have min length of 12 and max of 19
* CreditCard number can start with 0
* No synchronization logic added.
