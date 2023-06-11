import tkinter as tk
from tkinter import ttk

ventana = tk.Tk()
ventana.title("Abastecimiento de tiendas")
ventana.geometry("900x800")

# Distribución uniforme de filas
for i in range(4):
    ventana.rowconfigure(i, weight=1)

# Distribución uniforme de columnas
for j in range(8):
    ventana.columnconfigure(j, weight=1)

label3 = tk.Label(ventana, text="3")
label4 = tk.Label(ventana, text="4")
label5 = tk.Label(ventana, text="5")
label6 = tk.Label(ventana, text="6")
label7 = tk.Label(ventana, text="7")
label8 = tk.Label(ventana, text="8")

label10 = tk.Label(ventana, text="10")
label11 = tk.Label(ventana, text="11")
label12 = tk.Label(ventana, text="12")
label13 = tk.Label(ventana, text="13")
label14 = tk.Label(ventana, text="14")
label15 = tk.Label(ventana, text="15")
label16 = tk.Label(ventana, text="16")
label18 = tk.Label(ventana, text="18")
label19 = tk.Label(ventana, text="19")
label20 = tk.Label(ventana, text="20")
label21 = tk.Label(ventana, text="21")
label22 = tk.Label(ventana, text="22")
label23 = tk.Label(ventana, text="23")
label24 = tk.Label(ventana, text="24")
label25 = tk.Label(ventana, text="25")
label26 = tk.Label(ventana, text="26")
label28 = tk.Label(ventana, text="28")
label30 = tk.Label(ventana, text="30")
label31 = tk.Label(ventana, text="31")
label32 = tk.Label(ventana, text="32")

#/*--------------Tiendas--------------*/
#Stack para la parte de lista de tiendas
predeterminadoTiendas = tk.StringVar(value='Seleccionar tienda')
casillaTiendas = tk.Frame(ventana, width=113, height=200)
casillaTiendas.grid(row=0, column=0,sticky="ew")

stack = tk.Frame(casillaTiendas)
stack.pack()

textoTiedas = tk.Label(stack, text='Lista de tiendas')
textoTiedas.pack(side='top', anchor='center')

desplegableTiendas = ttk.Combobox(stack,values=["Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"],textvariable=predeterminadoTiendas,state='readonly')
desplegableTiendas.pack(side='top', anchor='center')

# Crear una casilla para contener el cuadro de texto
casillaTextoTiendas = tk.Frame(ventana, width=113, height=200)
casillaTextoTiendas.grid(row=0, column=1,columnspan=1)

# Crear un cuadro de texto para mostrar información
informacion = "Texto de ejemplo"
texto_widget = tk.Text(casillaTextoTiendas,width=16,height=8,bg="grey")
texto_widget.pack()


# Agregar contenido al widget de texto
texto_widget.insert(tk.END, informacion)
texto_widget.configure(state=tk.DISABLED)


#/*--------------Productos--------------*/
#Stack para la parte de productos
predeterminadoProductos = tk.StringVar(value='Seleccionar producto')
casillaProductos = tk.Frame(ventana, width=113, height=200)
casillaProductos.grid(row=1, column=0,sticky="ew")

stack = tk.Frame(casillaProductos)
stack.pack()

textoProductos = tk.Label(stack, text='Lista de Productos')
textoProductos.pack(side='top', anchor='center')

desplegableProductos = ttk.Combobox(stack,values=["Pan","Agua"],textvariable=predeterminadoProductos,state='readonly')
desplegableProductos.pack(side='top', anchor='center')


# Crear una casilla para contener el cuadro de texto
casillaTextoProductos = tk.Frame(ventana, width=113, height=200)
casillaTextoProductos.grid(row=1, column=1,columnspan=1)
# Crear un cuadro de texto para mostrar información
informacion = "Texto de ejemplo"
texto_widgetProductos = tk.Text(casillaTextoProductos,width=16,height=8,bg="grey")
texto_widgetProductos.pack()
# Agregar contenido al widget de texto
texto_widgetProductos.insert(tk.END, informacion)
texto_widgetProductos.configure(state=tk.DISABLED)

#/*--------------Cantidad de Productos--------------*/
#Stack para la parte de productos
casillaQaProductos = tk.Frame(ventana, width=113, height=200)
casillaQaProductos.grid(row=1, column=3,sticky="ew")

stack = tk.Frame(casillaQaProductos)
stack.pack()

textoProductosQa = tk.Label(stack, text='Cantidad de productos')
textoProductosQa.pack(side='top', anchor='center')

botonProductosQa = tk.Entry(stack)
botonProductosQa.pack(side='top', anchor='center')


# Crear una casilla para contener el cuadro de texto
casillaTextoProductos = tk.Frame(ventana, width=113, height=200)
casillaTextoProductos.grid(row=1, column=1,columnspan=1)
# Crear un cuadro de texto para mostrar información
informacion = "Texto de ejemplo"
texto_widgetProductos = tk.Text(casillaTextoProductos,width=16,height=8,bg="grey")
texto_widgetProductos.pack()
# Agregar contenido al widget de texto
texto_widgetProductos.insert(tk.END, informacion)
texto_widgetProductos.configure(state=tk.DISABLED)

#/*--------------Transporte--------------*/
#Stack para la parte de productos
predeterminadoTransporte = tk.StringVar(value='Seleccionar transporte')
casillaTransporte = tk.Frame(ventana, width=113, height=200)
casillaTransporte.grid(row=2, column=0,sticky="ew")

stack = tk.Frame(casillaTransporte)
stack.pack()

textoTransporte = tk.Label(stack, text='Lista de Transporte')
textoTransporte.pack(side='top', anchor='center')

desplegableTransporte = ttk.Combobox(stack,values=["Pan","Agua"],textvariable=predeterminadoTransporte,state='readonly')
desplegableTransporte.pack(side='top', anchor='center')

# Crear una casilla para contener el cuadro de texto
casillaTextoTransporte = tk.Frame(ventana, width=113, height=200)
casillaTextoTransporte.grid(row=2, column=1,columnspan=1)
# Crear un cuadro de texto para mostrar información
informacion = "Texto de ejemplo"
texto_widgetTransporte = tk.Text(casillaTextoTransporte,width=16,height=8,bg="grey")
texto_widgetTransporte.pack()
# Agregar contenido al widget de texto
texto_widgetTransporte.insert(tk.END, informacion)
texto_widgetTransporte.configure(state=tk.DISABLED)

#/*--------------Botones--------------*/
# Crear un botón
botonSalida = tk.Button(ventana, text="Salida",width=10)
botonSalida.grid(row=3, column=2,sticky="ew")

botonEnviar = tk.Button(ventana, text="Enviar",width=10)
botonEnviar.grid(row=3, column=4,sticky="ew")

# Ejecutar el bucle principal de la ventana


label3.grid(row=0, column=2, padx=10, pady=10,sticky="ew")
label4.grid(row=0, column=3, padx=10, pady=10,sticky="ew")
label5.grid(row=0, column=4, padx=10, pady=10,sticky="ew")
label6.grid(row=0, column=5, padx=10, pady=10,sticky="ew")
label7.grid(row=0, column=6, padx=10, pady=10,sticky="ew")
label8.grid(row=0, column=7, padx=10, pady=10,sticky="ew")
label10.grid(row=1, column=1, padx=10, pady=10,sticky="ew")
label11.grid(row=1, column=2, padx=10, pady=10,sticky="ew")
label12.grid(row=1, column=3, padx=10, pady=10,sticky="ew")
label13.grid(row=1, column=4, padx=10, pady=10,sticky="ew")
label14.grid(row=1, column=5, padx=10, pady=10,sticky="ew")
label15.grid(row=1, column=6, padx=10, pady=10,sticky="ew")
label16.grid(row=1, column=7, padx=10, pady=10,sticky="ew")
label18.grid(row=2, column=1, padx=10, pady=10,sticky="ew")
label19.grid(row=2, column=2, padx=10, pady=10,sticky="ew")
label20.grid(row=2, column=3, padx=10, pady=10,sticky="ew")
label21.grid(row=2, column=4, padx=10, pady=10,sticky="ew")
label22.grid(row=2, column=5, padx=10, pady=10,sticky="ew")
label23.grid(row=2, column=6, padx=10, pady=10,sticky="ew")
label24.grid(row=2, column=7, padx=10, pady=10,sticky="ew")
label25.grid(row=3, column=0, padx=10, pady=10,sticky="ew")
label26.grid(row=3, column=1, padx=10, pady=10,sticky="ew")
label28.grid(row=3, column=3, padx=10, pady=10,sticky="ew")
label30.grid(row=3, column=5, padx=10, pady=10,sticky="ew")
label31.grid(row=3, column=6, padx=10, pady=10,sticky="ew")
label32.grid(row=3, column=7, padx=10, pady=10,sticky="ew")
ventana.mainloop()