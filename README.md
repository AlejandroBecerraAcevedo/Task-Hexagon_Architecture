# 📌 Task-Hexagon_Architecture

Este es un proyecto desarrollado con **Spring Boot** utilizando **Arquitectura Hexagonal** y **PostgreSQL** como base de datos. El objetivo es gestionar tareas mediante una API REST, con una estructura modular y desacoplada.

## 🚀 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **Swagger (Springdoc OpenAPI)**
- **Arquitectura Hexagonal**
- **Docker** (Opcional)

---

## 📂 Estructura del Proyecto
```
📦 spring_practice_hexagonal
 ┣ 📂 src/main/java/com/hexagonal/spring_practice_hexagonal
 ┃ ┣ 📂 application (Casos de uso)
 ┃ ┣ 📂 domain (Modelos de dominio)
 ┃ ┣ 📂 infrastructure (Adaptadores y controladores)
 ┃ ┗ 📜 SpringPracticeHexagonalApplication.java
 ┣ 📜 .env (Variables de entorno)
 ┣ 📜 Dockerfile
 ┣ 📜 application.properties
 ┣ 📜 pom.xml (Dependencias Maven)
 ┗ 📜 README.md
```

---
## 📌 Configuración del Proyecto

### 1️⃣ **Configurar Variables de Entorno**
El proyecto usa un archivo `.env` para almacenar las credenciales de la base de datos. Asegúrate de configurar las siguientes variables:

```properties
SPRING_DATASOURCE_URL=YOUR_DATABASE/YOUR_LOCAL_HOST_DATABASE/Tasks
SPRING_DATASOURCE_USERNAME=USERNAME_DATABASE_ADMIN
SPRING_DATASOURCE_PASSWORD=YOUR_PASSWORD_USER_DATABASE
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_OPEN_IN_VIEW=false
```

Si estás usando **Docker**, puedes modificar la configuración según sea necesario.

### 2️⃣ **Configurar PostgreSQL**
Si no tienes PostgreSQL instalado, puedes usar Docker:
```sh
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=tu_contraseña -e POSTGRES_DB=tasks -p 5432:5432 -d postgres
```

---

## 🚀 Ejecución del Proyecto

### 📌 **Ejecutar con Maven**
```sh
mvn clean install -DskipTests
mvn spring-boot:run
```

### 📌 **Ejecutar con Docker**
```sh
docker build -t task-hexagon .
docker run -p 8089:8089 --env-file .env task-hexagon
```

---

## 🔗 **Documentación API (Swagger)**

El proyecto usa **Springdoc OpenAPI** para documentar los endpoints. Una vez que la aplicación esté en ejecución, puedes acceder a la documentación en:
```
YOUR_LOCAL_HOST/doc/swagger-ui.html
```

Para obtener los **endpoints JSON**:
```
YOUR_LOCAL_HOST/api-docs
```

---

## ⚡ **Comandos Útiles**

### ✅ **Ejecutar Maven sin Tests**
```sh
mvn clean install -DskipTests
```

### ✅ **Eliminar caché de Maven y recompilar**
```sh
mvn dependency:purge-local-repository
mvn clean install
```

### ✅ **Regenerar los Wrappers de Maven**
```sh
rm -rf .mvn/ mvnw mvnw.cmd
mvn wrapper:wrapper
```

## 👨‍💻 **Contribución**
Si deseas contribuir al proyecto:
1. **Haz un fork** del repositorio.
2. **Crea una nueva rama** (`git checkout -b feature-nueva`).
3. **Realiza tus cambios y haz commit** (`git commit -m "Descripción del cambio"`).
4. **Haz push a tu rama** (`git push origin feature-nueva`).
5. **Abre un Pull Request** en GitHub.

---

## 📜 **Licencia**
Este proyecto está bajo la licencia MIT. Puedes usarlo libremente con o sin modificaciones.

🚀 **¡Gracias por usar Task-Hexagon_Architecture!** 😊