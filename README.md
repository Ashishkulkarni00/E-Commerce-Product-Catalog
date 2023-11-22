# 🛒 Product Catalog API

## Description
This is a RESTful API for managing products and categories in a catalog. The API allows users to perform CRUD operations on products and categories.

## Technologies Used
- Spring Boot
- Java Persistence API (JPA)
- Spring Data JPA
- MySQL 
- Postman 

## Setup Instructions
To run this project locally, follow these steps:

### Prerequisites
- JDK 11 or higher installed
- Maven installed
- MySQL installed 

### Steps
1. **Clone the Repository**
    ```bash
    git clone https://github.com/Ashishkulkarni00/E-Commerce-Product-Catalog.git
    cd E-Commerce-Product-Catalog
    ```

2. **Configure Database**
    - Create a MySQL database (or use an existing one).
    - Update the database configurations in `application.properties`.

3. **Build and Run**
    ```bash
    mvn spring-boot:run
    ```
   The application will start on [http://localhost:8081](http://localhost:8081).

## API Documentation
For detailed API documentation, including endpoints, request/response examples, and more, refer to the [API Postman Collection](https://www.postman.com/aerospace-geologist-55490909/workspace/e-commerce-product-catalog/collection/31326834-aa6d5767-eeb5-41e7-9679-ac6b2673e1a7?action=share&creator=31326834).

## API Endpoints
### Product Endpoints
- `POST /api/v1/products`: Add a new product
- `GET /api/v1/products/{productId}`: Get product by ID
- `GET /api/v1/products`: Get all products
- `GET /api/v1/products/category/{categoryId}`: Get products by category ID
- `DELETE /api/v1/products/{productId}`: Delete a product by ID
- `PUT /api/v1/products/{productId}`: Update a product by ID

### Category Endpoints
- `POST /api/v1/categories`: Add a new category
- `GET /api/v1/categories/{categoryId}`: Get category by ID
- `GET /api/v1/categories`: Get all categories
- `DELETE /api/v1/categories/{categoryId}`: Delete a category by ID
- `PUT /api/v1/categories/{categoryId}`: Update a category by ID

## API Endpoints
### Product Endpoints
#### POST - Add new product
- URL: `http://localhost:8081/api/v1/products`
- Body (raw - JSON):
  ```json
  {
    "product_name": "Macbook",
    "product_price": 20000.99,
    "product_description": "Official work",
    "category": {
      "category_id": 52
    }
  }
#### GET - Get product by product ID
- URL: `http://localhost:8081/api/v1/products/3`
#### GET - Get all products
- URL: `http://localhost:8081/api/v1/products`
#### GET - Get product by category ID
- URL: `http://localhost:8081/api/v1/products/category/1`
#### DELETE - Delete a product by ID
-URL: `http://localhost:8081/api/v1/products/3`
#### PUT - Update a product by product ID
- URL: `http://localhost:8081/api/v1/products/3`
- Body (raw - JSON):
 ```json
{
  "product_name": "Fitness Band",
  "product_price": 2000,
  "product_description": "Fitness and activity tracker",
  "category": {
    "category_id": 1
  }
}
```
### Product Endpoints
#### POST - Add new category
- URL: `http://localhost:8081/api/v1/categories`
- Body (raw - JSON):
 ```json
{
  "category_name": "Cricket",
  "category_description": "Cricket equipments"
}
```

#### GET - Get category by ID
- URL: `http://localhost:8081/api/v1/categories/2`
#### DELETE - Delete a category by ID
- URL: `http://localhost:8081/api/v1/categories/52`
#### GET - Get all categories
- URL: `http://localhost:8081/api/v1/categories`
#### PUT - Update category by ID
- URL: `http://localhost:8081/api/v1/categories/2`
- Body (raw - JSON):
 ```json
{
  "category_name": "Food",
  "category_description": "Snacks and chocolates"
}
```
