# Proyecto de Franquicias

Este proyecto es una aplicación para gestionar franquicias y sus sucursales. Se desarrolla utilizando **Spring** para el backend y **MySQL** como base de datos.

## Requisitos

- Java 17 o superior
- Maven

##Opcional:
- Docker
- Docker Compose

## Configuración del Entorno

## Para correr desde Spring
1. Clona el repositorio:
   https://github.com/julian0916/franquicias-prueba.git
2. Crea una base de datos llamada franquicias_db en mysql.
3. Cambia el nombre de usuario y contraseña por las tuyas en el archivo aplication.properties
4. Ejecuta la aplicacion.

## Para correr desde docker
1.Desde la raiz del proyecto ejecuta el comando docker compose -up
2.Si genera error al arrancar el docker de spring ingresar al 
docker mysql con el comando docker exec -it mysql_database mysql -u root -p
ingresar la contraseña y ejecutar el comando ALTER USER 'root'@'localhost' IDENTIFIED BY 'abc4321';
FLUSH PRIVILEGES;
3. Volver a ejecutar el comando comando docker compose -up y el docker spring arrancara sin problema.

## La aplicación expone una API RESTful para interactuar con la base de datos.
## Puedes utilizar herramientas como Postman o curl para probar los endpoints disponibles.

1. Endpoint para agregar una franquicia: POST http://localhost:8080/franquicias
   Enviar el parametro {
    "nombre" : "Nombre de franquicia"
}
2. Endpoint para agregar una sucursal POST http://localhost:8080/sucursales
   {
    "nombre": "Nombre de sucursal",
    "franquicia": {
        "id": 1 //Id de la franquicia a la que se quiere vincular
    }
}
3. Endpoint para agregar un producto a una sucursal POST http://localhost:8080/productos/sucursal/{id_sucursal}
   enviar el parametro {
    "nombre" : "nombre producto",
    "stock" : 10
}
4. Endpoint para eliminar un producto DELETE http://localhost:8080/productos/{id_producto}
5. Endpoint para editar el stock de un producto PUT http://localhost:8080/productos/{id_product}/stock?stock={cantidad_stock}
   Enviar parametros Key = stock value = numero de stock
6. Enpoint para buscar el stock maximo de productos en cada sucursal de una franquicia GET http://localhost:8080/productos/franquicia/{id_franquicia/max-stock
7. Enpoint para cambiar el nombre de una franquicia PUT http://localhost:8080/franquicias/{id_franquicia}
   Enviar parametro {
    "nombre" : "nombre nuevo"
}
8.Enpoint para cambiar el nombre de una sucursal PUT http://localhost:8080/sucursales/{id_sucursal}
   Enviar parametro {
    "nombre": "nombre nuevo",
    "franquicia": {
        "id": 1 //id de la franquicia 
    }
}
9. Endopoint para cambiar el nombre de un producto PUT http://localhost:8080/productos/{id_producto}/nombre?nombre={nombre_nuevo}
   Enviar parametros Key = nombre value = nombre nuevo.
   
   
