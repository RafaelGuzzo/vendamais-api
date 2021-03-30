# vendamais-api


#### Pré-requisitos mínimos

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org)
- [PostgreSQL 9.5](https://www.postgresql.org/download/)

#### Importando o projeto para IDE [Eclipse](https://www.eclipse.org/downloads/) ou [STS](https://spring.io/tools)
> Tutorial de como importar um projeto maven: [https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde](https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde)

#### Criar o database no postgresql
```
CREATE DATABASE vendamais
```

#### O arquivo `application.properties` está configurado padrão

```
spring.datasource.url=jdbc:postgresql://localhost:5432/vendamais
spring.datasource.username=postgres
spring.datasource.password=postgres
```
> se o banco possuir outra senha ou estiver em outro host configurar o arquivo `application.properties`

#### Executar o projeto como Spring Boot Application

> Importar no [Postman](https://www.postman.com/) a collection `Venda Mais Api.postman_collection.json` do diretório `src/main/resources`
