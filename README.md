# backend_snack_overflow


## Description
intro to what the api does, only a few lines


### Class Diagram
<img src="./Backend Class Diagram.png" alt="class diagram" width="80%"/> 


### Entity Relationship Diagram
<img src="./Backend Entity Relationship Diagram.png" alt="entity relationship diagram" width="80%"/>


## Tech Stack

The technologies used for this project are:
- Intellij IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman


-------------


## How to use the project

### RESTful routes

##### To access the endpoints of the program, use https://localhost:{port}/{endpoint} - the default port is 8080 but any can be used

Each model - User, Recipe, Ingredient, Measurement, and Equipment - have REST controllers that provide basic CRUD functionality, specifically Index, Show, Create, Update, and Delete. The Users and Recipe models also have additional functionality as described below.

- INDEX
  - `GET https://localhost:8080/recipes` returns all recipes in JSON format, and can be accessed via web browser
  - This method is available for all other models

- SHOW
  - `GET https://localhost:8080/recipes/{id}` returns recipe with unique id = {id}, and can be accessed via web browser
  - This method is available for all other models

- CREATE
  - `POST https://localhost:8080/recipes` creates a recipe with a unique id, and returns the created recipe. Attributes of this new recipe must be sent with the request body in Postman
  - This method is available for all other models

- UPDATE
  - `PUT https://localhost:8080/recipes/{id}` updates recipe with unique id = {id}, and returns the updated recipe. All attributes, changed or not, must be included in the request body in Postman. 
  - For example: if a recipe's cookTime is not included in the PUT request, the value with default to 0.
  - This method is available for all other models

- DELETE
  - `DELETE https://localhost:8080/recipes/{id}` updates recipe with unique id = {id}. This must be done in Postman. If delete request is successful, Http status 202 - no content - is returned.
  - This method is available for all other models


#### Filters and Sort

##### Recipe

The recipe model contains some filters and a sort that allow the user to narrow their search.

- INDEX 
  - recipe-name={ingredient : recipe name 
     



## License
