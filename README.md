# API REST con Seguridad JWT + gestion de roles - Documentación

Este proyecto implementa una API rest de accesos con seguridad basada en JWT, que incluye autenticación, control de acceso basado en roles y gestión de tokens.

## Tecnologías Utilizadas

- **Spring Boot:** Marco de desarrollo para Java.

- **Spring Security:** Módulo de seguridad para aplicaciones Spring.

- **Spring Data JPA:** Abstracción de acceso a datos utilizando JPA.

- **Hibernate:** Framework de mapeo objeto-relacional (ORM) que implementa JPA y facilita el trabajo con bases de datos relacionales en Java.

- **JWT (JSON Web Token):** Mecanismo para la creación de tokens seguros.

- **SpringDoc:** Biblioteca para integrar Swagger en proyectos Spring Boot y simplificar la documentación de la API.

- **Lombok:** Biblioteca que agiliza el desarrollo mediante anotaciones.

- **Maven:** Herramienta de gestión de dependencias y construcción de software.

- **PostgreSQL:** Sistema de gestión de bases de datos relacional de código abierto y potente.

## Tabla de Contenidos

1. [Endpoints de Autenticación](#endpoints-de-autenticación)
2. [Endpoint Public](#endpoint-public)
3. [Endpoint Manager](#endpoint-Manager)
4. [Endpoint Admin](#endpoint-Admin)
5. [Instalación](#instalación)
6. [Uso](#uso)
7. [Documentación de Swagger](#documentación-de-swagger)

## Endpoints de Autenticación

### `AuthenticationController`

Este controlador maneja el registro de usuarios, el inicio de sesión y la actualización de tokens.

- **Registrar Usuario:**
  - Método: `POST`
  - Ruta: `/api/v1/auth/register`
  - Descripción: Registra a un usuario y obtiene un token JWT + token de actualización.

- **Iniciar Sesión:**
  - Método: `POST`
  - Ruta: `/api/v1/auth/login`
  - Descripción: Inicia sesión para obtener un token JWT + token de actualización.

- **Actualizar Token:**
  - Método: `POST`
  - Ruta: `/api/v1/auth/refresh-token`
  - Descripción: Utiliza el token de actualización para obtener un nuevo token JWT.

### Ejemplos de Solicitudes

Consulta la documentación de Swagger o Postman para obtener ejemplos detallados de solicitudes.

## Endpoint Público

### `PublicController`

- **Endpoint Público:**
  - Método: `GET`
  - Ruta: `/api/v1/public`
  - Descripción: Accesible por usuarios con cualquier rol (USER, MANAGER, ADMIN).

## Endpoint de Gerente

### `ManagerController`

Endpoints accesibles solo con un token de gerente o administrador.

- **Endpoint GET:**
  - Método: `GET`
  - Ruta: `/api/v1/manager`

- **Endpoint POST:**
  - Método: `POST`
  - Ruta: `/api/v1/manager`

- **Endpoint PUT:**
  - Método: `PUT`
  - Ruta: `/api/v1/manager`

- **Endpoint DELETE:**
  - Método: `DELETE`
  - Ruta: `/api/v1/manager`

## Endpoint de Administrador

### `AdminController`

Endpoints accesibles solo con un token de administrador.

- **Endpoint GET:**
  - Método: `GET`
  - Ruta: `/api/v1/admin`

- **Endpoint POST:**
  - Método: `POST`
  - Ruta: `/api/v1/admin`

- **Endpoint PUT:**
  - Método: `PUT`
  - Ruta: `/api/v1/admin`

- **Endpoint DELETE:**
  - Método: `DELETE`
  - Ruta: `/api/v1/admin`

## Instalación

1. Clona el repositorio: `git clone https://github.com/JulianArrieta99/restapi-jwtsecurity.git`
2. Navega al directorio del proyecto: `cd restapi-jwtsecurity`
3. Compila y ejecuta la aplicación.

