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


## Contributors
* [@Hemant]()





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

`https://localhost:8088/`

`http://localhost:8088/swagger-ui/`


## API Module Endpoints


### User Module


* `GET /customer/AllRegistration` : user can see all the registration
* `POST /customer/Id` : User can add using Id class id
* `PUT /customers/Member` : user can update member 
* `DELETE/customers/Member` : user can delete member 
........
And Many more Methods We Implemented in our controller


### Admin Module

* `POST /admin/addInventory` : only admin can add the inventory details using unique key
* `GET /admin/GetAllInventory` :only admin can access inventory details using unique key
* `DELETE /admin/DeleteInventory` : only admin can delete the inventory details using unique key

........
