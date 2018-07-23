# SpringBoot App with Jersey REST

Do you want to know how to build RESTful web services utilizing **JAX-RS** annotations along with **Jersey** library in a **Spring Boot Maven** project? Follow me!


## Technologies

- Java 1.8.171
- Maven 3.5.0
- SpringBoot 2.0.3
- Jersey 2.26
- Java IDE (I love IntelliJ, and you?)
- H2 DB

## SpringBoot Web Application

- UnhandledExceptionMapper.java
- JerseyConfig.java
- SpringBootJerseyApplication.java

## Jersey Application Packages

- Rest (UserResource.java, UserComponent.java, User.java)
- Service (UserService.java)
- Repository (PersonRepository.java)
- Mapper (UserConverter.java)
- Entity (Person.java)
- Exception (UserNotFoundException.java)

## Starting SpringBoot Application
Once you have packed the app with **mvn package** you can start the SpringBoot app typing **java -jar target/spring-boot-jersey-0.0.1-SNAPSHOT.jar**

## JAVA Clients

There are many ways to build a Java client to invoke the RESTful service. The most common ones are:

- [Apache HTTP Client](http://www.baeldung.com/httpclient-guide)
- HttpURLConnection
- [Jersey Client](http://www.baeldung.com/jersey-jax-rs-client)
- [SpringRestTemplate](http://www.baeldung.com/rest-template)