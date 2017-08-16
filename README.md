# Search-Text
#Setup-Database
  Get User.sql file form resource folder and import it to MYSQL to create database and table. 

#Build-and-run

Configurations

Open the application.properties file and set your own configurations:

Database connection parameters (this example use MySQL5 as DBMS)
Hibernate Search's index directory
Prerequisites

Java 8
Maven > 3.0
From terminal

Go on the project's root folder, then type:

$ mvn spring-boot:run
From Eclipse (Spring Tool Suite)

Import as Existing Maven Project and run it as Spring Boot App.

Usage

Run the application
Type the url http://localhost:8080/search?q=some text to search: a search will be performed for the query text "some text to search".

# Example  
 http://localhost:8080/search?q=olga
 
 This Return value -> 1 row 
 
 http://localhost:8080/search?q=
  
  This return enter key word. 
  
   http://localhost:8080/search?q=omar
  
  This return empty search. -> either meaning not match .  
