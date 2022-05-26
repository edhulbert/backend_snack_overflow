# SnackOverflow - A Tasty Java API


## Description

This project is a Recipe API containing recipes for meals from numerous cuisines. Each recipe contains ingredients, as well as the measurements, and also the equipment required to make that dish. 

The program allows the user to add a list of ingredients they have available to them, stored in their "cupboard", and then filter the recipes to find dishes that can be made with some, or all of the ingredients they have. 

The user is also able to filter recipes based on ingredients they do not want to see (i.e. dietary restrictions), and also sort the recipes based on the total time it takes to prepare and cook. 

Below is a description of all models available, along with the Class Diagram and Entity Relationship Diagram.

### Users
A user object contains a unique id, a username, a password, a list of favourite recipes, and a list of ingredients - their "cupboard". A specific user's cupboard and favourite recipes can be accessed directly with a GET request, described in the "How to use the API" section of this ReadMe.

### Recipes
Recipes contain an id, a name, preparation time, cooking time, the number of people it feeds, a list of *measurements* (see below), and a list of equipment needed. Recipes can be filtered by name, ingredient, and dietary restriction. Recipes can also be sorted by total time to make (prep time & cook time).

### Ingredients
Ingredients have an id, a name, and a list of *measurements* (see below). 

### Measurements
There is an implied many-to-many relationship between recipes and ingredients, but to allow for the *amount* of ingredient used in each recipe, the measurements object is used. Each measurement contains one recipe and one ingredient, and the amount of ingredient that is used by said recipe. This is stored as a string to allow for different units (e.g. "a pinch" and "2g" are valid measurements of salt). If the ingredient or recipe attached a measurement is deleted, the measurement is removed too.

### Equipment
 Each equipment object has a unique id, a name, and a list of recipes that it is used in. This relationship with recipes is many-to-many. Equipment can be created, updated and deleted, without affecting the recipes that it is attached to.
 
 **NOTE**: for the sake of clarity in this API, the plural of equipment is equipments. Yes, this is bad English, too bad.
 
 ### Class Diagram
 
<img src="./Backend Class Diagram.png" alt="class diagram" width="80%"/> 


### Entity Relationship Diagram
<img src="./Backend Entity Relationship Diagram.png" alt="entity relationship diagram" width="80%"/>

-------------

## Tech Stack

The technologies used for this project are:
- Intellij IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman


-------------


## How to use the API

### RESTful route endpoints

##### To access the endpoints of the program, use `https://localhost:{port}/{endpoint}` - the default port is 8080 but any can be used

Each model - User, Recipe, Ingredient, Measurement, and Equipment - have REST controllers that provide basic CRUD functionality, specifically Index, Show, Create, Update, and Delete routes. The User and Recipe models also have additional functionality, described below.

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


### Filters and Sort

The recipe model contains filters and a sort that allow the user to narrow their search.

- FILTER
  - /recipes?recipe-name={name} : recipe name includes (but not limited to) case-insensitive string
  - /recipes?ingredient={ingredient} : recipe includes {ingredient}, case-insensitive
  - /recipes?ingredients={ingredient1,ingredient2,...} : recipe includes AT LEAST ONE of user-input list of ingredients
  - /recipes?dietary-restriction={ingredient} : recipe does not include user-input ingredient
 
- SORT
	- /recipes?sort-by-total-time={boolean} : boolean=true returns all recipes, sorted by total time (prepTime + cookTime)

- FILTER AND SORT
	- /recipes?ingredient={ingredient}&sort-by-total-time={boolean} : return recipes with ingredient and sort by total time
	- no other filters+sorts currently supported

### User Favourite Recipes and Cupboard

A user's favourite recipes can be accessed via GET request `localhost:8080/users/{id}/fave-recipes`, where {id} is the unique id of the user of interest.

A user's cupboard is a list of all ingredients the user has at their disposal. It can be accessed via GET request `localhost:8080/users/{id}/cupboard`.  The response body contains each ingredient in the cupboard, along with all recipes that contain said ingredient.

----------------

## Dependancies
- Spring Web
- SpringBoot Devtools
- Spring Data JPA
- H2 Database
- JUnit Jupiter
- AssertJ Core

----------------

## Collaborators
- Adan Abdillahi
- Fiyin Ayodele
- Thouhid Khan Majles
- Ed Hulbert





