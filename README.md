# E-Commerce-POC
E-Commerce Microservices Backend POC using Spring Cloud


## Build & Run from Source

* __Initial Setup__ : Java 1.8.0_191, Apache Maven 3.6.0, PostgreSQL 10.5, MongoDB 4.0.3
* __PostgreSQL Setup__ : 
   * Host: localhost
   * Port: 5432
   * Database Name: postgres
   * Schema Name: public
   * [DDL Statements](https://github.com/AravindSh/E-Commerce-POC/blob/master/etc/Postgres_Scripts/create_alter.sql)
   * [Insert Statements](https://github.com/AravindSh/E-Commerce-POC/blob/master/etc/Postgres_Scripts/insert.sql)
* __MongoDB Setup__ :
   * Host: localhost
   * Port: 27017
   * Database Name: e_commerce_db
   * Collection Name: product_catalog
   * Create Sample Data: 
        Open a terminal/cmd and enter the following commands
        ```shell
        cd ./etc/mongodbDataInit/
        mvn clean package -Dmaven.test.skip=true
        java -jar ./target/mongodbDataInit-0.0.1-SNAPSHOT.jar
        ```
* __Run Config Server__ :
   ```shell
   cd configServer/
   mvn clean package -Dmaven.test.skip=true
   java -jar ./target/configServer-0.0.1-SNAPSHOT.jar
   ```
* __Run Eureka Server__ :
   * Primary Profile
     ```shell
     cd eurekaServer/
     mvn clean package -Dmaven.test.skip=true
     java -jar -Dspring.profiles.active=primary ./target/eurekaServer-0.0.1-SNAPSHOT.jar
     ```
   * Secondary Profile
     ```shell
     cd eurekaServer/
     java -jar -Dspring.profiles.active=secondary ./target/eurekaServer-0.0.1-SNAPSHOT.jar
     ```
* __Run Admin Microservice__ :
   * Default Profile
     ```shell
     cd admin/
     mvn clean package -Dmaven.test.skip=true
     java -jar ./target/admin-0.0.1-SNAPSHOT.jar
     ```
   * Replica Profile
     ```shell
     cd admin/
     java -jar -Dspring.profiles.active=replica ./target/admin-0.0.1-SNAPSHOT.jar
     ```
* __Run User Microservice__ :
   ```shell
   cd user/
   mvn clean package -Dmaven.test.skip=true
   java -jar ./target/user-0.0.1-SNAPSHOT.jar
   ```
* __Testing Endpoints__ :
   Download Postman Rest Client and import [postman collection](https://github.com/AravindSh/E-Commerce-POC/blob/master/etc/E_Commerce_poc.postman_collection.json) _OR_ use your favourite Rest Client and refer this [folder](https://github.com/AravindSh/E-Commerce-POC/tree/master/etc/Endpoint_Details) for all    endpoint details 
