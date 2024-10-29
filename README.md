# Sistema de Listado Articulos

Un sistema de gestión de listado de artículos desarrollado con Spring Boot 3.3.4.

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.4
- PostgreSQL
- JPA / Hibernate
- WebSockets
- Docker Compose
- Lombok
- Maven

## ⚙️ Requisitos Previos

- Java Development Kit (JDK) 17 o superior
- Maven 3.6+
- PostgreSQL
- Docker (opcional, para usar con Docker Compose)

## 🛠️ Instalación y Configuración

1. **Clonar el repositorio**
   ```bash
   git clone [url-del-repositorio]
   cd sv-articulos
   ```

2. **Configuración de la Base de Datos**
   
   Crear un archivo `application.properties` en `src/main/resources/` con la siguiente configuración:
   ```properties
   # Database Configuration
   spring.datasource.url=jdbc:postgresql://localhost:5432/svitems
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   
   # JPA Configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   
   # WebSocket Configuration
   spring.websocket.path=/ws
   ```

3. **Compilar el proyecto**
   ```bash
   mvn clean install
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

   O usando el archivo WAR generado:
   ```bash
   java -jar target/sv-articulos-1.0.0.war
   ```

## 🐳 Usando Docker Compose

El proyecto incluye soporte para Docker Compose. Para ejecutar la aplicación usando Docker:

1. **Crear un archivo docker-compose.yml**
   ```yaml
   version: '3.8'
   services:
     app:
       build: .
       ports:
         - "8080:8080"
       depends_on:
         - db
     db:
       image: postgres:latest
       environment:
         POSTGRES_DB: nombre_db
         POSTGRES_USER: usuario
         POSTGRES_PASSWORD: password
       ports:
         - "5432:5432"
   ```

2. **Ejecutar con Docker Compose**
   ```bash
   docker-compose up
   ```

## 🔌 WebSockets

La aplicación incluye soporte para WebSockets, permitiendo comunicación en tiempo real. La conexión WebSocket está disponible en:

- Desarrollo: `ws://localhost:8080/ws`
- Producción: `wss://[tu-dominio]/ws`

## 📦 Estructura del Proyecto

```
sv-articulos/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sis/
│   │   │           └── articulos/
│   │   │               ├── api/
│   │   │               ├── config/
│   │   │               ├── controllers/
│   │   │               ├── models/
│   │   │               ├── repositories/
│   │   │               ├── services/
│   │   │               └── SvArticulosApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## ✨ Características

- Gestión de artículos
- Sistema de ventas
- Comunicación en tiempo real mediante WebSockets
- Soporte para Docker
- API RESTful
- Persistencia con PostgreSQL


