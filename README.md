# 🧠 Owl AI Internship – Task 4 (Advanced)  
## 🚀 Full CRUD API using Spring Boot  

### 👨‍💻 Developed by: **Akash Shetty**

---

## 📌 Objective  
Design and implement a **Full CRUD (Create, Read, Update, Delete)** API using **Spring Boot** for managing `User` resources.  
The system performs all CRUD operations, includes **data validation**, **error handling**, and returns **JSON-formatted responses**.  

---

## 🧩 Features
- ✅ Create new users with proper validation  
- ✅ Fetch all users or a single user by ID or email  
- ✅ Update user details with duplicate email checks  
- ✅ Delete users by ID  
- ✅ Handles exceptions with custom error messages  
- ✅ Uses DTO pattern for clean request & response separation  
- ✅ Automatic timestamps for creation and modification  
- ✅ Tested using Postman  

---

## 🏗️ Tech Stack

| Category | Technologies |
|-----------|---------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.5.7 |
| **Database** | MySQL |
| **Build Tool** | Maven |
| **Validation** | Jakarta Validation |
| **Testing Tool** | Postman |
| **Version Control** | Git & GitHub |

---

## ⚙️ Tools / Platforms  
- 🧰 **IDE:** Spring Tool Suite / IntelliJ IDEA / Eclipse  
- 🗄️ **Database:** MySQL  
- 🧪 **Testing:** Postman  
- 🌐 **Version Control:** Git & GitHub  

---

## 🧠 Project Architecture

src/main/java/com/akash/owlAi/
│
├── controller/ # REST API endpoints
│ └── UserController.java
│
├── dto/ # Data Transfer Objects
│ ├── UserDTO.java
│ └── UserResponseDTO.java
│
├── entity/ # JPA entity class
│ └── User.java
│
├── exception/ # Custom exceptions and global handler
│ ├── DuplicateResourceException.java
│ ├── ResourceNotFoundException.java
│ └── GlobalExceptionHandler.java
│
├── repository/ # Repository interface for DB operations
│ └── UserRepository.java
│
├── service/ # Business logic layer
│ ├── UserService.java
│ └── UserServiceImpl.java
│
└── OwlAiInternshipTaskApplication.java


---

## 🗃️ Database Configuration

### **application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
logging.level.com.akash.owlAi=DEBUG

```
## 🧩 API Endpoints
Method	Endpoint	Description
GET	/api/users	Fetch all users
GET	/api/users/{id}	Fetch user by ID
GET	/api/users/email/{email}	Fetch user by email
POST	/api/users	Create a new user
PUT	/api/users/{id}	Update user details
DELETE	/api/users/{id}	Delete user by ID
## 📤 Example JSON Requests
```
## ➕ Create User (POST)
{
  "firstName": "Akash",
  "lastName": "Shetty",
  "email": "akash@example.com",
  "phoneNumber": "9876543210"
}

## ✏️ Update User (PUT)
{
  "firstName": "Akash Kumar",
  "lastName": "Shetty",
  "email": "akash@example.com",
  "phoneNumber": "9876543211"
}
```

## 📥 Example Responses
✅ Successful GET Response
```
{
  "id": 1,
  "firstName": "Akash",
  "lastName": "Shetty",
  "email": "akash@example.com",
  "phoneNumber": "9876543210",
  "createdAt": "2025-11-12T11:00:00",
  "updatedAt": "2025-11-12T11:10:00"
}

## ⚠️ Error Response (User Not Found)
{
  "status": 404,
  "message": "User not found with id: 10",
  "timestamp": "2025-11-12T11:15:00"
} 
```

## 🧰 Exception Handling
Exception	When It Occurs	HTTP Status
ResourceNotFoundException	User not found by ID or email	404
DuplicateResourceException	Email already exists	409
MethodArgumentNotValidException	Validation errors	400
Generic Exception	Any unexpected issue	500



## test endpoints:

POST /api/users → Add a new user

GET /api/users → Retrieve all users

GET /api/users/{id} → Retrieve a specific user

PUT /api/users/{id} → Update user

DELETE /api/users/{id} → Delete user

Validate JSON output and HTTP status codes.

## 🧠 Highlights

#### 🧩 Followed 3-tier architecture (Controller → Service → Repository)

#### 🧾 Implemented DTO pattern for clean data handling

#### ⚙️ Custom Global Exception Handling

#### 🔄 Transactional service methods ensure consistency

#### 🧑‍💻 Validation with annotations (@NotBlank, @Email, @Size)

#### ⏱️ Automatic timestamps via @PrePersist and @PreUpdate

#### 📡 Proper use of ResponseEntity and status codes



## ✨ Author

👨‍💻 Name: Akash Shetty
📧 Email: akashshetty@example.com
