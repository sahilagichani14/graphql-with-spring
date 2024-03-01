# graphql-with-spring
Learning and understanding GraphQL and VS REST 
1.  src/main/resources/graphql/schema.graphqls as all graphql schemas 
2. graphQL endpoint is POST /graphql (http://localhost:8080/graphql) not https
3. data or sql files in src/main/resources/ automatically loaded in h2 db using spring.graphql.schema.printer.enabled=true
   spring.jpa.hibernate.ddl-auto=none properties
4. 