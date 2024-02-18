<br/>
<p align="center">
  <a href="https://github.com/DeTiveNC/SpringTemplateDockerized">
    <img src="https://github.com/DeTiveNC/SpringTemplateDockerized/assets/116792124/a123ca6f-e2a6-4566-9611-d2c3d505da23" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Template for Spring+Docker+Postgresql</h3>

  <p align="center">
    Easy-To-Use dockerized SpringBootApp
    <br/>
    <br/>
    <a href="https://github.com/DeTiveNC/SpringTemplateDockerized/issues">Report Bug</a>
    .
    <a href="https://github.com/DeTiveNC/SpringTemplateDockerized/issues">Request Feature</a>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/DeTiveNC/SpringTemplateDockerized?color=dark-green) ![Forks](https://img.shields.io/github/forks/DeTiveNC/SpringTemplateDockerized?style=social) ![Stargazers](https://img.shields.io/github/stars/DeTiveNC/SpringTemplateDockerized?style=social) ![Issues](https://img.shields.io/github/issues/DeTiveNC/SpringTemplateDockerized) ![License](https://img.shields.io/github/license/DeTiveNC/SpringTemplateDockerized) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [License](#license)
* [Authors](#authors)
* [Future](#future-version)

## About The Project

For people that always have problems building correctly a Docker for Spring Boot Application, I have your solution.

This project is an easy-to-use spring boot app for test or start a web service from scratch for the last version of spring boot.

## Built With

Start of the project is with the help of spring initializers peaking dependecies for Postgres+Web+JPA

* [Spring Initializer](https://start.spring.io/)

## Getting Started

Steps to configure and run the project locally

### Prerequisites

You need to have: 
- Docker

### Installation

1. Clone the repo
```
    git clone https://github.com/detivenc/SpringTemplateDockerized.git
```
2. Build the project
    - SPRING:
       - On terminal at the project folder
 ```./mvnw clean package -DskipTests```
3. Run the script of docker-compose
            ```docker-compose up```
4. PgAdmin
When you run it access with the creadentials:
- admin@admin.com (you can change it)
- admin (you can change it)
When you need to add the server is:
- General: 
  - Name: whatever
- Connection:
  - Host: java_db
  - Username: postgres or change it
  - Password: postgres or change it

## Usage

Use this project to have a fast creation of spring project, test it and deploy it.
For testing, you can use Swagger and see the changes of the database with PgAdmin

## License

Distributed under the MIT License. See [LICENSE](https://github.com/DeTiveNC/SpringTemplateDockerized/blob/main/LICENSE.md) for more information.

## Authors

* **Nicolas Cao** - *Comp Eng Student* - [Nicolas Cao](https://github.com/detivenc) - *Built SpringProject*

### Future Version

Passing to kubernetes this whole project
