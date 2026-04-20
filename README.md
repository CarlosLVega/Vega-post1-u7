# Sistema de Gestión de Tareas

## Información del proyecto

**Asignatura:** Patrones de Diseño de Software  
**Unidad:** Unidad 7 - Patrones Arquitectónicos I  
**Actividad:** Post-Contenido 1  
**Estudiante:** Carlos Vega  
**Repositorio:** Vega-post1-u7  

## Descripción

Este proyecto implementa una API REST para la gestión de tareas utilizando Spring Boot y una arquitectura en capas estricta. La aplicación permite crear, listar, consultar, actualizar el estado y eliminar tareas.

El objetivo principal es separar correctamente las responsabilidades del sistema en capas de presentación, aplicación, dominio e infraestructura, evitando dependencias cruzadas y manteniendo una estructura clara y mantenible.

## Tecnologías utilizadas

- Java 17  
- Spring Boot 3.3.5  
- Spring Web  
- Spring Data JPA  
- Bean Validation  
- H2 Database  
- Maven  

## Arquitectura en capas

El proyecto está organizado en cuatro capas:

```text
controller  -> Capa de presentación
service     -> Capa de aplicación
domain      -> Capa de dominio
repository  -> Capa de infraestructura
````

## Estructura del proyecto

```text
com.example.tareas
├── controller
│   ├── TareaController.java
│   └── GlobalExceptionHandler.java
├── service
│   └── TareaService.java
├── domain
│   ├── TareaNotFoundException.java
│   └── model
│       ├── Tarea.java
│       └── EstadoTarea.java
├── repository
│   └── TareaRepository.java
└── TareasApplication.java
```

## Responsabilidades por capa

### Capa de presentación

La capa `controller` recibe peticiones HTTP, valida entradas básicas y delega en la capa de servicio.

Clases:

* TareaController
* GlobalExceptionHandler

### Capa de aplicación

La capa `service` contiene la lógica de aplicación y orquesta las operaciones.

Clase:

* TareaService

### Capa de dominio

Contiene entidades, enums y excepciones del negocio.

Clases:

* Tarea
* EstadoTarea
* TareaNotFoundException

### Capa de infraestructura

Gestiona la persistencia mediante JPA.

Clase:

* TareaRepository

## Modelo de dominio

Entidad principal:

* Tarea

Atributos:

* id
* titulo
* descripcion
* estado

Enum:

* PENDIENTE
* EN_PROGRESO
* COMPLETADA

## Endpoints disponibles

### Listar tareas

```
GET /api/tareas
```

### Buscar tarea por ID

```
GET /api/tareas/{id}
```

### Crear tarea

```
POST /api/tareas
```

Ejemplo:

```json
{
  "titulo": "Estudiar Spring Boot",
  "descripcion": "Repasar arquitectura en capas"
}
```

### Cambiar estado

```
PATCH /api/tareas/{id}/estado?estado=EN_PROGRESO
```

### Eliminar tarea

```
DELETE /api/tareas/{id}
```

## Manejo de errores

Se implementa manejo global con `GlobalExceptionHandler`.

Casos:

* Tarea inexistente → 404
* Error de validación → 400

Ejemplo:

```json
{
  "error": "Tarea 99 no encontrada"
}
```

```json
{
  "titulo": "El titulo es obligatorio"
}
```

## Configuración de H2

Consola:

```
http://localhost:8080/h2-console
```

Datos:

* JDBC URL: `jdbc:h2:mem:tareasdb`
* User Name: `sa`
* Password: *(vacío)*

## Cómo ejecutar el proyecto

Compilar:

```bash
mvn compile
```

Ejecutar:

```bash
mvn spring-boot:run
```

URL base:

```
http://localhost:8080
```

## Pruebas con PowerShell

```powershell
curl http://localhost:8080/api/tareas

curl -Method POST http://localhost:8080/api/tareas `
  -ContentType "application/json" `
  -Body '{"titulo":"Estudiar Spring Boot","descripcion":"Repasar arquitectura"}'

curl http://localhost:8080/api/tareas/99

curl -Method PATCH "http://localhost:8080/api/tareas/1/estado?estado=EN_PROGRESO"

curl -Method DELETE http://localhost:8080/api/tareas/1
```

## Verificación

* Compila correctamente con Maven
* Arquitectura en capas bien definida
* API funcional en puerto 8080
* H2 operativa
* CRUD completo funcionando
* Validaciones activas
* Manejo de errores correcto

## Commits sugeridos

```bash
git add .
git commit -m "Configura proyecto Spring Boot base"

git add .
git commit -m "Implementa dominio, repositorio y servicio"

git add .
git commit -m "Agrega controlador REST y manejo de errores"

git add .
git commit -m "Documenta arquitectura y endpoints"
```

## Conclusión

La implementación de una arquitectura en capas permite una separación clara de responsabilidades, reduciendo el acoplamiento y mejorando la mantenibilidad del sistema. Cada capa cumple un rol específico, lo que facilita la evolución del software y su escalabilidad.


