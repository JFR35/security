# Proyecto Spring Boot con Spring Security Básico

Este repositorio contiene un proyecto Spring Boot que demuestra una implementación básica de Spring Security para proteger endpoints de una API REST.

## Funcionalidades de Seguridad Implementadas:

* **Autenticación Básica (Basic Auth):** Los clientes deben proporcionar un nombre de usuario y contraseña en la cabecera `Authorization` de sus peticiones.
* **Autorización Basada en Roles:** Se definen roles de usuario (por ejemplo, `USER`, `ADMIN`) y se protegen endpoints específicos para requerir ciertos roles para el acceso.
* **Configuración en Memoria:** Los usuarios y sus roles están configurados directamente en la memoria para simplificar la demostración (en un escenario real, se usaría una base de datos o un proveedor de autenticación externo).

## Configuración de Seguridad

La configuración de Spring Security se encuentra en una clase anotada con `@Configuration` y `@EnableWebSecurity`. En esta clase, se personaliza la cadena de filtros de seguridad para:

* Requerir autenticación para todos los endpoints por defecto.
* Configurar la autenticación básica.
* Definir usuarios en memoria con sus roles y contraseñas (codificadas con `PasswordEncoder`).
* Especificar reglas de autorización para diferentes rutas, permitiendo el acceso solo a usuarios con roles específicos.

## Endpoints de Ejemplo y Roles:

* `/public`: Endpoint público, accesible sin autenticación.
* `/user`: Endpoint protegido, requiere el rol `USER` o `ADMIN`.
* `/admin`: Endpoint protegido, requiere el rol `ADMIN`.

## Cómo Ejecutar la Aplicación

1.  Asegúrate de tener instalado Java y Maven o Gradle.
2.  Clona este repositorio.
3.  Navega al directorio raíz del proyecto desde tu terminal.
4.  Ejecuta el comando:
    * **Maven:** `mvn spring-boot:run`
    * **Gradle:** `gradle bootRun`

La API estará disponible en el puerto configurado (por defecto suele ser el 8080).

## Cómo Probar la Seguridad

Puedes usar herramientas como `curl` o Postman para probar los endpoints protegidos.
