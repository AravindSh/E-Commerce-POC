# E-Commerce-POC
E commerce microservices backend POC using spring cloud


## Build & Run from Source

* __Initial Setup__ : Java 1.8.0_191, Apache Maven 3.6.0, PostgreSQL 10.5, MongoDB v4.0.3
* __PostgreSQL Setup__ : 
   * Host: localhost
   * Port: 5432
   * Database: postgres
   * Schema: public
   * [DDL](https://github.com/AravindSh/E-Commerce-POC/blob/master/etc/Postgres_Scripts/create_alter.sql)
   * [Sample Data](https://github.com/AravindSh/E-Commerce-POC/blob/master/etc/Postgres_Scripts/insert.sql)
* __MongoDB Setup__ :
   * Host: localhost
   * Port: 27017
   * Database: e_commerce_db
   * Collection: product_catalog
   * Sample Data: Open a terminal/cmd and enter the following commands
      ```shell
      cd ./etc/mongodbDataInit/
      mvn clean package -Dmaven.test.skip=true
      java -jar ./target/mongodbDataInit-0.0.1-SNAPSHOT.jar
      ```
