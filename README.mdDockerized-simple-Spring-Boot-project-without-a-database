## 🚀 **Step 1: Create a Spring Boot Application**

1. **Generate a Spring Boot project** with these dependencies:
   - ✅ Spring Web
   - ✅ Spring Data JPA
   - ✅ MySQL Driver

2. **Configure `application.properties`:**

                           ```properties
                           spring.datasource.url=jdbc:mysql://db:3306/db5
                           spring.datasource.username=admin
                           spring.datasource.password=Mantu@12
                           spring.jpa.hibernate.ddl-auto=update
                           spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
                           ```

3. **Create the `User` entity:**

   ```java
   @Entity
   public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;

       // Getters and Setters
   }
   ```

4. **Set up the Repository Interface:**

   ```java
   public interface UserRepository extends JpaRepository<User, Long> {
   }
   ```

5. **Build the REST Controller:**

   ```java
   @RestController
   @RequestMapping("/users")
   public class UserController {

       @Autowired
       private UserRepository repository;

       @PostMapping
       public User addUser(@RequestBody User user) {
           return repository.save(user);
       }

       @GetMapping
       public List<User> getUsers() {
           return repository.findAll();
       }
   }
   ```

---

## 📦 **Step 2: Create the Dockerfile**

1. **Add a `Dockerfile` in your project root:**

   ```dockerfile
   FROM openjdk:21
   COPY target/sb_with_db.jar /do/app/
   WORKDIR /do/app
   ENTRYPOINT ["java", "-jar", "sb_with_db.jar"]
   ```

---

## 🐳 **Step 3: Set Up Docker Compose**

1. **Create `docker-compose.yml`:**

   ```yaml
   version: "3.8"

   services:
     app:
       image: docker_image/testapp
       ports:
         - "8080:8080"
       environment:
         SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/db5
         SPRING_DATASOURCE_USERNAME: admin
         SPRING_DATASOURCE_PASSWORD: Mantu@12
       depends_on:
         - db

     db:
       image: mysql:8.0.27
       environment:
         MYSQL_DATABASE: db5
         MYSQL_USER: admin
         MYSQL_PASSWORD: Mantu@12
         MYSQL_ROOT_PASSWORD: Mantu@12
       ports:
         - "3307:3306"
   ```

💡 **Why Docker Compose?**
It allows you to spin up multi-container apps (like Spring Boot + MySQL) with a single command!

---

## 🔧 **Step 4: Build and Run the Application**

1. **Package the JAR file:**

   ```sh
   mvn clean package
   ```

2. **Build the Docker image:**

   ```sh
   docker build -t testapp .
   ```

3. **Start the application:**

   ```sh
   docker-compose up -d
   ```

4. **Access the Application:**

   🌐 Open: [http://localhost:8080/users](http://localhost:8080/users)

---

## 🗂️ **Step 5: Access MySQL in Docker**

1. **Find the MySQL container:**

   ```sh
   docker ps
   ```

2. **Access the MySQL shell:**

   ```sh
   docker exec -it <container_id> bash
   ```

3. **Login to MySQL:**

   ```sh
   mysql -u admin -p
   ```

👉 Enter **password**: `Mantu@12`

---

## 🔍 **Find Docker Container ID**

### ✅ **Option 1: Using the Command Line**

```sh
docker ps
```

Example Output:

```
CONTAINER ID   IMAGE                 COMMAND                  PORTS                   NAMES
a1b2c3d4e5f6   mysql:8.0.27          "docker-entrypoint.s…"   0.0.0.0:3307->3306/tcp  your_db_container
```

### ✅ **Option 2: Using Docker Desktop**

1. Open **Docker Desktop**.
2. Navigate to the **Containers** tab.
3. Find the **db** service (e.g., `your_db_container`).
4. The **Container ID** is displayed at the top.

🚀 **You’re all set!** Your Spring Boot app is now running with Docker and MySQL!
