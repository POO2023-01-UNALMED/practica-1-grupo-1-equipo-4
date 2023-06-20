# from gestorAplicacion.gestion.CuentaBancaria import CuentaBancaria
# from gestorAplicacion.gestion.Operario import Operario
# from gestorAplicacion.gestion.Vendedor import Vendedor
# from gestorAplicacion.produccion.Fabrica import Fabrica
# from gestorAplicacion.produccion.Producto import Producto
# from gestorAplicacion.produccion.Tienda import Tienda
# from gestorAplicacion.gestion.Factura import Factura
# from gestorAplicacion.gestion.Cliente import Cliente
# from gestorAplicacion.gestion.Conductor import Conductor
# from gestorAplicacion.produccion.Transporte import Transporte
# from gestorAplicacion.produccion.TipoTransporte import TipoTransporte

# producto1 = Producto("Ladrillo", "Bloque utilizado en paredes y estructuras", 1, 2.5, 10374, 0.25, "construccion")
# producto2 = Producto("Lámpara LED", "Bombilla LED de bajo consumo energético", 80, 0.2, 500, 50, "construccion")
# producto3 = Producto("Adhesivo", "Adhesivo multiusos", 20, 0.3, 20000, 5, "construccion")
# producto4 = Producto("Cemento", "Material utilizado para la construcción", 200, 40, 8000, 10, "construccion")
# producto5 = Producto("Marmol", "Roca metamórfica utilizada para la decoración y acabado de interiores", 20345, 3000000, 20, 1000, "construccion")
# producto6 = Producto("Pintura blanca", "Pintura acrílica de color blanco", 50, 1.5, 10000, 30, "construccion")
# producto7 = Producto("Granito", "Roca ígnea utilizada en encimeras, pisos y paredes", 10000, 27800, 20, 750, "construccion")

# producto8 = Producto("Sandwich de pollo", "Sandwich de pollo", 8, 0.2, 1, 3, "consumible")
# producto9 = Producto("Hojas de Te", "hojas de té verde", 6, 0.02, 1, 15, "consumible")
# producto10 = Producto("Carne de res", "Carne de res de vacas del llano", 15, 1, 1, 7, "consumible")
# producto11 = Producto("Jamon", "Jamón de cerdo", 9, 0.03, 1, 4, "consumible")
# producto12 = Producto("Carne de cerdo", "Cerdo de criadero", 12, 1, 1, 3, "consumible")
# producto13 = Producto("Galletitas", "Galletitas hechas con amor", 5, 0.006, 1, 2, "consumible")
# producto14 = Producto("Pastel de cumpleaños", "Pastel de cumpleaños de vainilla", 20, 2, 2, 7, "consumible")

# producto15 = Producto("LimpiaMax", "Limpiador multiusos", 8, 1, 1, 2, "aseo")
# producto16 = Producto("Lavadora", "Máquina para lavar ropa", 800, 70, 1, 200, "aseo")
# producto17 = Producto("Jabon", "Producto de limpieza", 5, 1, 1, 1, "aseo")
# producto18 = Producto("Papel higiénico", "Rollos de papel suave y absorbente", 8, 1, 1, 2, "aseo")
# producto19 = Producto("Detergente", "Detergente líquido para lavadora", 15, 1.2, 1, 2, "aseo")
# producto20 = Producto("Cepillo de dientes", "Cepillo de cerdas suaves para la higiene bucal", 4, 1, 1, 1, "aseo")
# producto21 = Producto("Bolsas de basura", "Bolsas resistentes para desechar la basura", 3, 0.5, 1, 1, "aseo")
# producto22 = Producto("Jabón líquido", "Jabón líquido para manos", 5, 3, 1, 1, "aseo")

# catalogoProductos = []

# for i in range(1, 23):
#     text = f'catalogoProductos.append(producto{i})'
#     exec(text)

# cuentaEmpresa = CuentaBancaria(9999999, 1000000000)

# #Cuentas vendedores
# cuentaVendedor1 = CuentaBancaria(56932, 100) #//cada vendedor tiene cien mil *hay que sacar cuentas*
# cuentaVendedor2 = CuentaBancaria(45728, 200)
# cuentaVendedor3 = CuentaBancaria(95687, 200)

# #Vendedores
# vendedor1 = Vendedor("Maria Beatriz",20,57793,cuentaVendedor1,None)
# vendedor2 = Vendedor("Adriana Alexia Putellas",21,89235,cuentaVendedor2,None)
# vendedor3 = Vendedor("Lionel Andres Messi",22,14720,cuentaVendedor3,None)



# #CuentaOperario
# cuentaOperario1 = CuentaBancaria(55555, 100000)
# #Operario
# operario1 = Operario("Jaime",20,97890,cuentaOperario1,None)#//cada oeprador tiene cien mil *hay que sacar cuentas*
# #Tiendas
# tienda1 = Tienda("Hefesto Construcciones",vendedor1,cuentaEmpresa) #//eso atributo de la cuenta del vendedor hay que cambiarlo ya que
# tienda2 = Tienda("Consumibles de la Abuela Tata",vendedor2,cuentaEmpresa) #//cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
# tienda3 = Tienda("Miss Músculo Aseo",vendedor3,cuentaEmpresa)

# #Agregar productos a las tiendas
# productos = [producto1, producto2, producto3, producto4, producto5, producto6, producto7,
#              producto8, producto9, producto10, producto11, producto12, producto13, producto14,
#              producto15, producto16, producto17, producto18, producto19, producto20, producto21, producto22]

# tiendas = [tienda1, tienda2, tienda3]

# productos_por_tienda = [
#     [producto1, producto2, producto3, producto4, producto5, producto6, producto7],  # Productos para tienda1
#     [producto8, producto9, producto10, producto11, producto12, producto13, producto14],  # Productos para tienda2
#     [producto15, producto16, producto17, producto18, producto19, producto20, producto21, producto22]  # Productos para tienda3
# ]
# for i in range(5):
#     for tienda, productos_tienda in zip(tiendas, productos_por_tienda):
#         tienda.getListaProductos().extend(productos_tienda)

# fabrica = Fabrica(catalogoProductos, tiendas, cuentaEmpresa,operario1)

# "Clientes"
# cuentaCliente1 = CuentaBancaria(11111, 5000000)
# cliente1 = Cliente("Juan Pérez", "Calle 123", cuentaCliente1)
# cuentaCliente2 = CuentaBancaria(22222, 200)
# cliente2 = Cliente("María García", "Avenida 456", cuentaCliente2)
# cuentaCliente3 = CuentaBancaria(33333, 20000)
# cliente3 = Cliente("Pedro Gómez", "Carrera 789", cuentaCliente3)
# cuentaCliente4 = CuentaBancaria(44444, 20000)
# cliente4 = Cliente("Luis Gómez", "Carrera 789", cuentaCliente4)
# cuentaCliente5 = CuentaBancaria(55555, 20000)
# cliente5 = Cliente("Josesito Gómez", "Carrera 789", cuentaCliente5)
# cuentaCliente6 = CuentaBancaria(66666, 30000)
# cliente6 = Cliente("Julián Araña Alvarez", "Carrera 101", cuentaCliente6)
# cuentaCliente7 = CuentaBancaria(77777, 70000)
# cliente7 = Cliente("Emiliano Dibu Martinez", "Carrera 23", cuentaCliente7)
# cuentaCliente8 = CuentaBancaria(88888, 211000)
# cliente8 = Cliente("Diego Armando Maradona", "Carrera 10", cuentaCliente8)

# ListaClientes = [cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8]


# "Conductores"
# cuentaConductor1 = CuentaBancaria(646541231, 100)
# cuentaConductor2 = CuentaBancaria(13213544, 100)
# cuentaConductor3 = CuentaBancaria(1321354, 100)

# conductor1 = Conductor("Pablo Ramirez", 45, 544764513, cuentaConductor1, None)
# conductor2 = Conductor("Hernando Cruz", 50, 645541321, cuentaConductor2, None)
# conductor3 = Conductor("Mario Casas", 25, 13216531, cuentaConductor3, None)

# conductor1.setFabrica(fabrica)
# conductor2.setFabrica(fabrica)
# conductor3.setFabrica(fabrica)



# transporte1 = Transporte(TipoTransporte.TREN, 100, 1000, conductor1)

# #un_transporte = Transporte(tipo, capacidad, costo, conductor)
# #transporteAbastecer = Transporte(TipoTransporte.CAMION, TipoTransporte.CAMION.get_precio_original_transporte(), TipoTransporte.CAMION.get_capacidad(), conductor1)
# #conductor1.setTransporte(transporteAbastecer)

# #Esto es para probar la funcionalidad pago a trabajadores
# vendedor1.setTienda(tienda1)
# vendedor2.setTienda(tienda2)
# vendedor3.setTienda(tienda3)
# conductor1.setTransporte(transporte1)
# operario1.setFabrica(fabrica)