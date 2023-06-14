import tkinter as tk
from tkinter import ttk, Frame, DISABLED
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
import Objetos as prueba

class Abastecer(Frame):
    def __init__(self, window):
        print(prueba.Fabrica)
        super().__init__(window)
        # Distribución uniforme de filas
        for i in range(5):
            self.rowconfigure(i, weight=1)

        # Distribución uniforme de columnas
        for j in range(6):
            self.columnconfigure(j, weight=1)

        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=8, padx=5, pady=5)

        # Configurar el peso de la fila y columna para centrar el marco
        self.rowconfigure(0, weight=1)
        self.columnconfigure(0, weight=1)

        titulo = tk.Label(frameCabecera, text='Pagar a trabajadores', font=("Arial", 15))
        titulo.pack()

        textoDescripcion = """Aquí podrá seleccionar alguno de los trabajadores disponibles
        según su función (Conductores, Operarios y Vendedores), pagarles por sus respectivas
        horas trabajadas y además verificar sus metas dando bonificaciones por el cumplimiento
        de las mismas"""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 10))
        descripcion.pack()

        # /*--------------Tiendas--------------*/
        # Stack para la parte de lista de tiendas
        predeterminadoTiendas = tk.StringVar(value='Seleccionar tienda')
        casillaTiendas = tk.Frame(self, width=113, height=200)
        casillaTiendas.grid(row=0 + 1, column=0, sticky="ew")

        stack = tk.Frame(casillaTiendas)
        stack.pack()

        textoTiedas = tk.Label(stack, text='Lista de tiendas')
        textoTiedas.pack(side='top', anchor='center')

        desplegableTiendas = ttk.Combobox(stack, values=["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado",
                                                         "Domingo"], textvariable=predeterminadoTiendas,
                                          state='readonly')
        desplegableTiendas.pack(side='top', anchor='center')

        # Crear una casilla para contener el cuadro de texto
        casillaTextoTiendas = tk.Frame(self, width=113, height=200)
        casillaTextoTiendas.grid(row=0 + 1, column=1, columnspan=1)

        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widget = tk.Text(casillaTextoTiendas, width=16, height=8, bg="grey")
        texto_widget.pack()

        # Agregar contenido al widget de texto
        texto_widget.insert(tk.END, informacion)
        texto_widget.configure(state=tk.DISABLED)

        # /*--------------Productos--------------*/
        # Stack para la parte de productos
        predeterminadoProductos = tk.StringVar(value='Seleccionar producto')
        casillaProductos = tk.Frame(self, width=113, height=200)
        casillaProductos.grid(row=1 + 1, column=0, sticky="ew")

        stack = tk.Frame(casillaProductos)
        stack.pack()

        textoProductos = tk.Label(stack, text='Lista de Productos')
        textoProductos.pack(side='top', anchor='center')

        desplegableProductos = ttk.Combobox(stack, values=["Pan", "Agua"], textvariable=predeterminadoProductos,
                                            state='readonly')
        desplegableProductos.pack(side='top', anchor='center')

        # Crear una casilla para contener el cuadro de texto
        casillaTextoProductos = tk.Frame(self, width=113, height=200)
        casillaTextoProductos.grid(row=1 + 1, column=1, columnspan=1)
        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widgetProductos = tk.Text(casillaTextoProductos, width=16, height=8, bg="grey")
        texto_widgetProductos.pack()
        # Agregar contenido al widget de texto
        texto_widgetProductos.insert(tk.END, informacion)
        texto_widgetProductos.configure(state=tk.DISABLED)

        # /*--------------Cantidad de Productos--------------*/
        # Stack para la parte de productos
        casillaQaProductos = tk.Frame(self, width=113, height=200)
        casillaQaProductos.grid(row=1 + 1, column=3, sticky="ew")

        stack = tk.Frame(casillaQaProductos)
        stack.pack()

        textoProductosQa = tk.Label(stack, text='Cantidad de productos')
        textoProductosQa.pack(side='top', anchor='center')

        entradaProductosQa = tk.Entry(stack)
        entradaProductosQa.pack(side='top', anchor='center')
        entradaProductosQa.configure(state=DISABLED)

        # Crear una casilla para contener el cuadro de texto
        casillaTextoProductos = tk.Frame(self, width=113, height=200)
        casillaTextoProductos.grid(row=1 + 1, column=1, columnspan=1)
        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widgetProductos = tk.Text(casillaTextoProductos, width=16, height=8, bg="grey")
        texto_widgetProductos.pack()
        # Agregar contenido al widget de texto
        texto_widgetProductos.insert(tk.END, informacion)
        texto_widgetProductos.configure(state=DISABLED)

        # /*--------------Transporte--------------*/
        # Stack para la parte de productos
        predeterminadoTransporte = tk.StringVar(value='Seleccionar transporte')
        casillaTransporte = tk.Frame(self, width=113, height=200)
        casillaTransporte.grid(row=2 + 1, column=0, sticky="ew")

        stack = tk.Frame(casillaTransporte)
        stack.pack()

        textoTransporte = tk.Label(stack, text='Lista de Transporte')
        textoTransporte.pack(side='top', anchor='center')

        desplegableTransporte = ttk.Combobox(stack, values=["Pan", "Agua"], textvariable=predeterminadoTransporte,
                                             state='readonly')
        desplegableTransporte.pack(side='top', anchor='center')
        desplegableTransporte.configure(state="disabled")

        # Crear una casilla para contener el cuadro de texto
        casillaTextoTransporte = tk.Frame(self, width=113, height=200)
        casillaTextoTransporte.grid(row=2 + 1, column=1, columnspan=1)
        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widgetTransporte = tk.Text(casillaTextoTransporte, width=16, height=8, bg="grey")
        texto_widgetTransporte.pack()
        # Agregar contenido al widget de texto
        texto_widgetTransporte.insert(tk.END, informacion)
        texto_widgetTransporte.configure(state=DISABLED)

        # /*--------------Botones--------------*/
        # Crear un botón
        botonSalida = tk.Button(self, text="Salida", width=10)
        botonSalida.grid(row=3 + 1, column=1, sticky="ew")

        botonEnviar = tk.Button(self, text="Enviar", width=5)
        botonEnviar.grid(row=3 + 1, column=2, sticky="ew")
