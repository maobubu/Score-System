# Score-System
#### based on Spring and Spring MVC.
[![Build Status](https://travis-ci.org/withstars/Books-Management-System.svg?branch=master)](https://travis-ci.org/withstars/Books-Management-System)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/withstars/Books-Management-System)
### Project Overview
This project is based on Java Spring MVC and mysql database。I used Bootstrap for front end。
### How to use
```
$ git clone https://github.com/withstars/Score-System

$ cd Score-System

$ mvn clean compile

$ mvn clean package

$ mvn clean install

$ mvn jetty:run
```
### Don't forget to load the .sql file into your database.

```
$ cd Score-System/newsql/

$ mysql -u root -p library < system.sql
```

http://localhost:9000
