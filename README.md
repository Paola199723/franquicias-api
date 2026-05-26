# Sistema de Franquicias API

Backend desarrollado con Java y Spring Boot para la administración de franquicias, sucursales y productos.

El proyecto fue construido siguiendo principios de **Clean Architecture**, separando responsabilidades en capas de dominio, aplicación y presentación.

---

# Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* Hibernate

---

# Arquitectura del proyecto

El proyecto está organizado usando una estructura basada en Clean Architecture:

```txt
src/main/java/com/franquicias/franquicias_api
│
├── application
│   ├── dto
│   ├── mapper
│   └── service
│
├── domain
│   ├── model
│   └── repository
│
├── presentation
│   └── controller
│
└── infrastructure
```

## Capas

### Domain

Contiene las entidades y repositorios principales del negocio.

### Application

Contiene:

* DTOs
* lógica de negocio
* mappers

### Presentation

Contiene los controladores REST expuestos al cliente.

---

# Configuración del proyecto

## 1. Clonar repositorio

```bash
git clone <url-del-repositorio>
```

---

## 2. Configurar PostgreSQL

Crear una base de datos:

```sql
CREATE DATABASE franquicias_db;
```

---

## 3. Configurar `application.properties`

Ubicado en:

```txt
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/franquicias_db
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# Ejecutar el proyecto

## Desde terminal

```bash
./mvnw spring-boot:run
```

o

```bash
mvn spring-boot:run
```

---

# Endpoints disponibles

# Franquicias

## Crear franquicia

```http
POST /franquicias
```

### Body

```json
{
  "nombre": "Franquicia Centro"
}
```

---

## Listar franquicias

```http
GET /franquicias
```

---

## Actualizar nombre franquicia

```http
PUT /franquicias/{id}
```

### Body

```json
{
  "nombre": "Nuevo Nombre"
}
```

---

# Sucursales

## Crear sucursal

```http
POST /sucursales
```

### Body

```json
{
  "nombre": "Sucursal Medellin",
  "franquiciaId": 1
}
```

---

## Actualizar nombre sucursal

```http
PUT /sucursales/{id}
```

### Body

```json
{
  "nombre": "Sucursal Norte"
}
```

---

# Productos

## Crear producto

```http
POST /productos
```

### Body

```json
{
  "nombre": "Coca Cola",
  "stock": 20,
  "sucursalId": 1
}
```

---

## Actualizar nombre producto

```http
PUT /productos/{id}/nombre
```

### Body

```json
{
  "nombre": "Coca Cola Zero"
}
```

---

## Actualizar stock producto

```http
PUT /productos/{id}/stock
```

### Body

```json
{
  "stock": 50
}
```

---

# Obtener productos con mayor stock por franquicia

```http
GET /franquicias/{id}/productos-mayor-stock
```

---

# Funcionalidades implementadas

* Crear franquicias
* Crear sucursales
* Crear productos
* Actualizar nombre de franquicia
* Actualizar nombre de sucursal
* Actualizar nombre de producto
* Actualizar stock de producto
* Obtener productos con mayor stock
* Persistencia con PostgreSQL
* Arquitectura limpia (Clean Architecture)

---

# Puntos extra implementados

Clean Architecture
Programación funcional usando Streams
Endpoint actualizar nombre franquicia
Endpoint actualizar nombre sucursal
Endpoint actualizar nombre producto

---

# Posibles mejoras futuras

* Dockerización del proyecto
* Swagger/OpenAPI
* Validaciones con Bean Validation
* Manejo global de excepciones
* Tests unitarios e integración
* Despliegue en la nube
* Infraestructura como código (Terraform)

---

# Autor

Desarrollado como prueba técnica backend con Spring Boot.
