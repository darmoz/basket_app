# basket_app
This is basket application was created for the recruitment process.
The application has been writen in Java under the Spring framework.
Application was developed in the REST architecture.

## build
To build the project please unzip basket.zip file to an internal folder. The unziped folder contains source and the gradle.build file.
The project can be executed with gradle.build at any envinronment which has preloded gradle engine.
The initial database tables with schema are provided with the code. 
Access to the mentioned database is protected with the password and the userId.
UserId: basket_user
Password: basket_pass

## conept of the project
Application author was inspired by self service shopping poinst which are located usualy in big markets.
The application was designed in the way that can be attached to any shoppingChart system. 
Customer functionality allows to select item, open the basket, place selected item in the basket and close the basket at any time.
From the system administrator side the functioinality of adding new items and create special offers to customers are implemented.

## project structure
Project structure is splitted into a few layers (see below):
Domain - where all domain object are sitted.
    - Items: is a shop storage 
    - Basket Items: items taken from storage with custoomer selected quantity
    - Basket: where all Basket Items are placed before final payment
Dto     
Dao - which provide access to standard crud requests for domain objects.
Mappers - which stears of incomming and outcomming object data transfer.
Controller - rest controllers with the api endpoints.
Service - where requested functionality and bussines logic is implemented.
    - Customer Service: with all customer related methods
    - Discount: with a bonus scheme
    
## database
Database was created with ORM approach via JPA API. Three of the domain layer object were use to create relational database.
Item is related to Basket Item with relation 1:1. The Basket Item is related to Basket with relation 1:N.
Items table has no cascade relation to other tables. The Basket table has cascade relation to the Basket Items table. However the oposit way is not true.

## unit test
Unit Test with coverage >80% was writen and succesfuly executed over the entire code.

## api documentation
The Swagger library was implemented in CoreConfiguration.class to get acces to the documentation api for all controllers.
After application execution (localy) the API documentation will be available under the following addres:
http://localhost:8080/swagger-ui.html
It presents possible endpoints for all controller used in the proejct with examples of response(JSON).

## disscount functionality
Disscount functionality was developed as a decorator pattern. This approach allows easly change or develop new discounts offers.

## contact
In case any question please contact author under dariusz.mozgowoj@gmail.com

