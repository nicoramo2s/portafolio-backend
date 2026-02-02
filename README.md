# Portfolio Backend

Backend application for a personal portfolio website built with Spring Boot 4.0.1 and Java 21.

## 🚀 Features

- **Personal Information Management**: CRUD operations for personal profile data
- **Education Management**: Track and display educational background
- **Experience Management**: Manage professional work experience
- **Projects Management**: Showcase projects with image uploads
- **Skills Management**: Display technical skills with proficiency levels
- **Authentication & Authorization**: Secure admin panel with Spring Security
- **CSRF Protection**: All forms protected against Cross-Site Request Forgery attacks
- **File Upload**: Support for project images with local storage
- **Responsive Admin Panel**: Modern UI for content management

## 🛠️ Tech Stack

- **Java**: 21
- **Spring Boot**: 4.0.1
- **Spring Security**: Authentication and authorization
- **Spring Data JPA**: Database operations
- **Thymeleaf**: Server-side template engine
- **PostgreSQL**: Database (Neon.tech)
- **Lombok**: Reduce boilerplate code
- **Maven**: Dependency management
- **Spring DevTools**: Development hot reload

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL database
- Git

## ⚙️ Installation & Setup

### 1. Clone the repository

```bash
git clone <repository-url>
cd my-portfolio-backend
```

### 2. Configure environment variables

Create a `.env` file in the root directory with the following variables:

```properties
DB_URL=your-database-host/database-name?sslmode=require&channelBinding=require
DB_USERNAME=your-database-username
DB_PASSWORD=your-database-password
FILE_UPLOAD_DIR=src/main/resources/static/img/projects
```

### 3. Install dependencies

```bash
mvn clean install
```

### 4. Run the application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🗄️ Database Configuration

The application uses PostgreSQL as the database. The connection is configured through environment variables for security:

- **Database URL**: `jdbc:postgresql://${DB_URL}`
- **Username**: `${DB_USERNAME}`
- **Password**: `${DB_PASSWORD}`

Database tables are automatically created on startup using JPA/Hibernate.

## 📁 Project Structure

```
my-portfolio-backend/
├── src/
│   ├── main/
│   │   ├── java/com/portfolio/my_portfolio_backend/
│   │   │   ├── config/          # Security and application configuration
│   │   │   ├── controller/      # REST controllers and view controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── repository/      # Data access layer
│   │   │   ├── service/         # Business logic
│   │   │   └── PortfolioApplication.java
│   │   └── resources/
│   │       ├── static/          # CSS, JS, images
│   │       ├── templates/       # Thymeleaf templates
│   │       └── application.properties
│   └── test/                    # Unit and integration tests
├── pom.xml
└── README.md
```

## 🔐 Security

The application implements Spring Security with:

- Form-based authentication
- CSRF protection on all POST forms
- Session management
- Password encoding
- Role-based access control for admin panel

### Default Admin Access

Configure your admin credentials in the security configuration or database.

## 🎨 Frontend Templates

The application uses Thymeleaf templates with modern CSS styling:

- **Public Portfolio**: Displays all sections (About, Education, Experience, Projects, Skills)
- **Admin Panel**: Secure CRUD operations for all content sections
- **Login Page**: Authentication interface
- **Form Pages**: Create/Edit forms for each content type
- **List Pages**: Data tables with edit/delete actions

## 📝 API Endpoints

### Public Routes
- `GET /` - Portfolio home page
- `GET /login` - Login page

### Admin Routes (Authentication Required)
- `GET /education` - List all education entries
- `GET /education/new` - Create education form
- `POST /education/save` - Save education entry
- `POST /education/delete/{id}` - Delete education entry

Similar patterns exist for:
- `/experience` - Work experience management
- `/projects` - Projects management
- `/skills` - Skills management
- `/personal-info` - Personal information management

## 🚀 Deployment

### Environment Variables for Production

Ensure the following environment variables are set in your production environment:

```bash
DB_URL=production-database-url
DB_USERNAME=production-username
DB_PASSWORD=production-password
FILE_UPLOAD_DIR=/path/to/upload/directory
```

### Build for Production

```bash
mvn clean package -DskipTests
```

The executable JAR will be created in the `target/` directory.

### Run Production Build

```bash
java -jar target/my-portfolio-backend-0.0.1-SNAPSHOT.jar
```

## 🔧 Configuration

Key configuration properties in `application.properties`:

- **Virtual Threads**: Enabled for improved performance (`spring.threads.virtual.enabled=true`)
- **Connection Pool**: Maximum 10 connections
- **Static Resources**: Served from classpath and file system
- **File Uploads**: Configurable upload directory

## 📦 Dependencies

Main dependencies include:

- `spring-boot-starter-webmvc` - Web MVC framework
- `spring-boot-starter-data-jpa` - JPA data access
- `spring-boot-starter-security` - Security framework
- `spring-boot-starter-thymeleaf` - Template engine
- `spring-boot-starter-validation` - Bean validation
- `thymeleaf-extras-springsecurity6` - Thymeleaf security integration
- `postgresql` - PostgreSQL driver
- `spring-dotenv` - Environment variable management
- `lombok` - Code generation

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👤 Author

**Nicolás**

- Portfolio: .....
- GitHub: [nicoramo2s](https://github.com/nicoramo2s)
- LinkedIn: [dario-nicolas-ramos](https://www.linkedin.com/in/dario-nicolas-ramos/)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Thymeleaf for the powerful template engine
- Neon.tech for PostgreSQL hosting
