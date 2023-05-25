[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/UhcYLOEZ)
# Práctica 1 - Grupo 1, Equipo 4

Este proyecto ha sido creado mediante GitHub Classroom.

## Capas

### Capa de persistencia: Paquete baseDatos

Los archivos donde se guardan los objetos serializados deberán estar en un directorio relativo del proyecto llamado `/temp` que estará al interior de este paquete.

### Capa lógica: Paquete gestorAplicacion

Las clases al interior de este paquete se deben organizar en mínimo 2 paquetes diferentes. Estará compuesta por las clases presentadas durante la exposición del avance del proyecto las cuales consistían en mínimo 6 a 8 clases. 2 clases nuevas que implementen la herencia (2 clases deben heredar de una tercera. Esta tercera puede ser una nueva clase o una de las ya propuestas inicialmente)

### Capa asociada a la interfaz de usuario: uiMain

## Clases

### Empresa distribuidora SAS

La aplicación está dirigida a los administradores de la empresa y esta compuesta por las siguientes clases e interfaces.

Paquete: `produccion`
- Fábrica 
- Tienda 
- Transporte 
- TipoTransporte (enumerados)
- Producto


Paquete: `gestion` 
- Persona 
  - Hijo: Conductor 
  - Hijo: Operario
  - Hijo: Vendedor 
- Factura 
- CuentaBancaria
- Meta (Interfaz)
- Moda (Interfaz)
- Cliente
- Persona

## Funcionalidades

### Enviar pedido

Enviar un artículo de algunas de las tiendas disponibles. El puede escoger el medio de transporte y pagar el precio dependiendo de la características del envío. Las clases que intervienen son Fábrica, Transporte, Conductor, Tienda, Vendedor, Factura, CuentaBancaria.

### Devoluciones

Esta funcionalidad permitirá hacer devoluciones de los paquetes que los clientes no deseen o que hayan sido entregados incorrectamente. La clase Paquete tendría un atributo "estado" que indica si un paquete ha sido devuelto. La clase Fábrica tendría un método para gestionar las devoluciones y la clase Vendedor tendría un atributo "paquetes devueltos" que registra los paquetes devueltos por cada vendedor. Las clases que intervienen son Vendedor, Paquete, CuentaBancaria, Tienda.

### Generar factura

El administrador puede generar la factura a los clientes dependiendo de la tarifa de envío que se calculará teniendo en cuenta el peso y el tamaño del paquete que se desea enviar. Intervienen las clases Factura, Paquete, Transporte y CuentaBancaria.

### Pago a los trabajadores

El administrador podrá realizar el pago al trabajador o al conductor dependiendo si se utilizó o no su servicio, comprobando esto con las facturas. Intervienen las clases Factura, Conductor, Operario, Vendedor, CuentaBancaria.

### Abastecer tiendas

El administrador podrá abastecer ciertos productos que vienen predeterminados en la fábrica a algunas de las tiendas. Intervienen las clases Fabrica, Tienda y Transporte.
