# BlogApplication
A springboot RESTful API's project for blogging application
* Developed these REST API's for Blogging Application. These API performs all the fundamental CRUD operations for a blogging platform with user validation at every step. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* MySQL
* Swagger
* Lombook

## Modules
* User Module
* Error Module

## Features

* User can register himself by authentication and authorization 
* User Features:
    * A user can register on the platform.
    * User can create multiple post.
    * User can create multiple comments
    * User can search for a post with category.    
    

## Installation & Run

* Update the port number, username and password as per your local database config.

```
    server.port=8088

    spring.datasource.url=jdbc:mysql://localhost:8088/sb2jeevanArogyaDb
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```


## API Root Endpoint

`https://localhost:8088/

`http://localhost:8088/swagger-ui/`

