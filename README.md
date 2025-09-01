# registro-usuarios
## Descripcion
Rest API para registrar Usuarios y Telefonos 
## Prerequisitos
* Java 17
* Maven 3.9+
## Actualizar properties
```
spring.r2dbc.url=r2dbc:h2:mem:///users;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.r2dbc.username=
spring.r2dbc.password=
user.validation.password-regex=^[a-zA-Z0-9]+$
```
## Como probar
Opcion A: Con Maven Wrapper
```
# macOS/Linux:
./mvnw spring-boot:run

# Windows:
mvnw.cmd spring-boot:run

```
Opcion B: Build runnable JAR
```
# macOS/Linux
./mvnw clean package

# Windows
mvnw.cmd clean package
```
Run it:
```
java -jar target/*.jar
```
Opcional: Modificar expresion regular para validacion de clave<br>
```
java -jar target/*.jar --user.validation.password-regex=<<insertar regex>>"
```
cURL:
```
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "cityCode": "1",
            "contryCode": "57"
        }
    ]
}'
```
