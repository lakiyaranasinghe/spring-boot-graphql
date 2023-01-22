## Spring Boot Graphql
Simple Spring Boot GraphQL project using spring-boot-starter-graphql

## Sample Graphql Queries

Query
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"mutation createNewAuthor ($name: String!, $age: Int) {\n  createAuthor(name: $name, age: $age) {\n    id\n    name\n  }\n}\n","variables":{"name":"Dean","age":35}}'
```

Mutation
```shell script
curl --location --request POST 'http://localhost:8080/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query{\n    findAllAuthors{\n        id,\n        name,\n        age\n    }\n}","variables":{}}'
```
