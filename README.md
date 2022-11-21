# spotted-lamp-2366


# REST API for an Covid-19 Application

* We have developed this REST API for an Covid-19 Application. This API performs all the fundamental CRUD operations of any Covid-19 Application platform with user validation at every step.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Swagger
* Lombook

## Modules

* User Module
* Admin Module
* Error Module

## Features

* User and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different Appointment, Member ,Vaccine Center ,Vaccine Inventory and Vaccine Ragistration.
* User Features:
    * A user can register himself or herself on the platform.
    * He/She can check the vaccine centres and vaccine availabilty.
    * If vaccine is available, can book an appointment slot.
    * After booking an appointment, he will get appointment details for the vaccine dose.    


## Contributors

* [@Rupsh Patil]()
* [@Hemant ]()
* [@Aman ]()
* [@sahil]()





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



