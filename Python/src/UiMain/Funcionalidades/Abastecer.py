import tkinter as tk
from tkinter import ttk, Frame, DISABLED,Entry,scrolledtext,messagebox
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
import Objetos
from gestorAplicacion.produccion.TipoTransporte import TipoTransporte
from gestorAplicacion.produccion.Transporte import Transporte
from gestorAplicacion.produccion.Fabrica import Fabrica as fabrica
from gestorAplicacion.gestion.Conductor import Conductor 
from excepciones import Abastecer0productos,Letras,MayorA,FaltaUno


class Abastecer(Frame):
    tienda = None
    producto = None
    cantidadProducto = None
    tipoTransporte = None
    listaFiltradaTransportes = None
    def __init__(self, window): 
        super().__init__(window)
        self.config(bg="#b6fce6")

        # /*--------------Eventos--------------*/
        def deshabilitarTienda(event):
            desplegableTiendas.config(state='readonly')

        def rellenarCuadroDeTextoTienda(event):                    
            # Agregar contenido al widget de texto
            texto_widget.config(state=tk.NORMAL)
            desplegableProductos.config(state=tk.NORMAL)
            texto_widget.delete("1.0", tk.END)
            desplegableTransporte.set("")
            Abastecer.tipoTransporte = None
            Abastecer.tienda = encontrarObjeto(desplegableTiendas,fabrica.getListaFabricas()[0].getListaTienda())[0]
            cadenaDeTexto = Abastecer.tienda.productosPorCategoria()+"\n"+Abastecer.tienda.cantidadProductos()
            texto_widget.insert(tk.END, cadenaDeTexto)
            texto_widget.config(state=DISABLED)

        def deshabilitarProductos(event):
            if Abastecer.tienda != None:
                desplegableProductos.config(state='readonly')


        def rellenarCuadroDeTextoProducto(event):                    
            # Agregar contenido al widget de texto
            texto_widgetProductos.config(state=tk.NORMAL)
            entradaProductosQa.config(state=tk.NORMAL)
            texto_widgetProductos.delete("1.0", tk.END)
            Abastecer.producto = encontrarObjeto(desplegableProductos,fabrica.getListaFabricas()[0].getListaProductos())[0]
            cadenaDeTexto = Abastecer.producto.__str__()
            texto_widgetProductos.insert(tk.END, cadenaDeTexto)
            texto_widgetProductos.config(state=DISABLED)

        def eventoEntry(event):                    
            # Agregar contenido al widget de texto
            if event.keysym == "Return":
                return
            try:
                if event.char.isalpha():
                    entradaProductosQa.delete(0, tk.END)
                    raise ValueError
                else:
                    desplegableTransporte.config(state=tk.NORMAL)
                    Abastecer.cantidadProducto = entradaProductosQa.get()
                    Abastecer.listaFiltradaTransportes = TipoTransporte.crearTipoTransporteSegunCarga\
                    (Abastecer.producto.getPeso()*float(Abastecer.cantidadProducto))
                    desplegableTransporte['values']=[x.value[0] for x in Abastecer.listaFiltradaTransportes]
            except  :
                desplegableTransporte.config(state=DISABLED)
                entradaProductosQa.delete(0, tk.END)
                Abastecer.cantidadProducto = None
                messagebox.showerror("Error", Letras())
                return
            

        def deshabilitarTransporte(event):
            if Abastecer.cantidadProducto != None:
                desplegableTransporte.config(state='readonly')

        def rellenarCuadroDeTextoTransporte(event):                    
            # Agregar contenido al widget de texto
            texto_widgetTransporte.config(state=tk.NORMAL)
            texto_widgetTransporte.delete("1.0", tk.END)
            
            Abastecer.tipoTransporte = list(filter(lambda x: x.value[0]==desplegableTransporte.get(),TipoTransporte))[0]
            cadenaDeTexto = Abastecer.tipoTransporte.__str__()
            texto_widgetTransporte.insert(tk.END, cadenaDeTexto)
            botonEnviar.config(state="normal")
            texto_widgetTransporte.config(state=DISABLED)

        def encontrarObjeto(comboBox,listaObjetos):
            nombre = comboBox.get()
            objeto = None
            objeto = list(filter(lambda x: x.getNombre()==nombre,listaObjetos))
            return objeto
        
        def envio():
            try:
                if any(var is None for var in (Abastecer.tienda, Abastecer.producto, Abastecer.cantidadProducto, Abastecer.tipoTransporte)):
                    raise FaltaUno
                elif entradaProductosQa.get()=='0':
                    raise Abastecer0productos
                elif Abastecer.tienda.getCantidadPorCategoria()[Abastecer.producto.getCategoria()]\
                -(Abastecer.tienda.getProductosPorCategoria()[Abastecer.producto.getCategoria()]+int(Abastecer.cantidadProducto))<=0:
                    raise MayorA
                else:
                    listaProductos = fabrica.getListaFabricas()[0].cantidadProductos(int(Abastecer.cantidadProducto),Abastecer.producto)
                    transporte = Transporte(Abastecer.tipoTransporte.value[0],Abastecer.tipoTransporte.value[1],Abastecer.tipoTransporte.value[2],Conductor.getListaConductores()[0])
                    transporte.abastecerProducto(Abastecer.tienda,listaProductos)
                    Abastecer.tienda.descargarProducto(transporte)
                    messagebox.showinfo("Abasteciemintos",f"La tienda {Abastecer.tienda.getNombre()} ha sido abastecida exitosamente\
 con {Abastecer.cantidadProducto} unidades de {Abastecer.producto.getNombre()}")
                    entradaProductosQa.delete(0, tk.END)
            except FaltaUno:
                messagebox.showerror("Error", FaltaUno())
            except Abastecer0productos:
                messagebox.showerror("Error", Abastecer0productos())
            except MayorA:
                messagebox.showerror("Error", MayorA())

        # Distribución uniforme de filas
        for i in range(5):
            self.rowconfigure(i, weight=1)

        # Distribución uniforme de columnas
        self.columnconfigure(0, weight=1)
        self.columnconfigure(1, weight=3)
        self.columnconfigure(2, weight=1)

        frameCabecera = tk.Frame(self, bg="#b6fce6")
        frameCabecera.grid(row=0, column=0, columnspan=8, padx=5, pady=5)

        # Configurar el peso de la fila y columna para centrar el marco
        self.rowconfigure(0, weight=1)
        self.columnconfigure(0, weight=1)

        titulo = tk.Label(frameCabecera, text='Abastecer', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3 )
        titulo.pack(pady=3, fill="x")

        textoDescripcion = """El administrador podrá abastecer ciertos productos que vienen predeterminados 
        en la fábrica a algunas de las tiendas.
          Intervienen las clases Fabrica, Tienda y Transporte."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken")
        descripcion.pack(pady=3)

        # /*--------------Tiendas--------------*/
        # Stack para la parte de lista de tiendas
        predeterminadoTiendas = tk.StringVar(value='Seleccionar tienda')
        casillaTiendas = tk.Frame(self, width=100, height=200 ,bg="#338dd6",relief="raised",  border=2)
        casillaTiendas.grid(row=1, column=0, sticky="ew")

        stack = tk.Frame(casillaTiendas) 
        stack.pack(pady=3)

        textoTiedas = tk.Label(stack, text='Lista de tiendas',font=("Arial", 12, "bold"),border=1,relief="sunken")
        textoTiedas.pack(side='top', anchor='center')
        desplegableTiendas = ttk.Combobox(stack, values=[x.getNombre() for x in fabrica.getListaFabricas()[0].getListaTienda()], 
                                          textvariable=predeterminadoTiendas,state=tk.NORMAL)
        desplegableTiendas.pack(side='top', anchor='center')

        # Crear una casilla para contener el cuadro de texto
        casillaTextoTiendas = tk.Frame(self, width=113, height=200)
        casillaTextoTiendas.grid(row=1, column=1, columnspan=1)

        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widget = scrolledtext.ScrolledText(casillaTextoTiendas, width=32, height=8, bg="#c5c4ff")
        texto_widget.pack()
        # Agregar contenido al widget de texto
        texto_widget.insert(tk.END, informacion)
        texto_widget.configure(state=tk.DISABLED)

        desplegableTiendas.bind("<<ComboboxSelected>>",rellenarCuadroDeTextoTienda)
        desplegableTiendas.bind("<Button-1>",deshabilitarTienda)

        # /*--------------Productos--------------*/
        # Stack para la parte de productos
        predeterminadoProductos = tk.StringVar(value='Seleccionar producto')
        casillaProductos = tk.Frame(self, width=113, height=200, bg="#338dd6",relief="raised",  border=2)
        casillaProductos.grid(row=2, column=0, sticky="ew")

        stack = tk.Frame(casillaProductos)
        stack.pack()

        textoProductos = tk.Label(stack, text='Lista de Productos', font=("Arial", 12, "bold"),border=1,relief="sunken")
        textoProductos.pack(side='top', anchor='center')

        desplegableProductos = ttk.Combobox(stack, values=[x.getNombre() for x in fabrica.getListaFabricas()[0].getListaProductos()], textvariable=predeterminadoProductos,
                                            state=DISABLED,width=20)
        desplegableProductos.pack(side='top', anchor='center')

        # Crear una casilla para contener el cuadro de texto
        casillaTextoProductos = tk.Frame(self, width=113, height=200)
        casillaTextoProductos.grid(row=2, column=1, columnspan=1)
        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widgetProductos = tk.Text(casillaTextoProductos, width=32,height=8,bg="#c5c4ff")
        texto_widgetProductos.pack()
        # Agregar contenido al widget de texto
        texto_widgetProductos.insert(tk.END, informacion)
        texto_widgetProductos.configure(state=tk.DISABLED)

        desplegableProductos.bind("<<ComboboxSelected>>",rellenarCuadroDeTextoProducto)
        desplegableProductos.bind("<Button-1>",deshabilitarProductos)

        # /*--------------Cantidad de Productos--------------*/
        # Stack para la parte de productos
        casillaQaProductos = tk.Frame(self, width=113, height=200, bg="#338dd6",relief="raised",  border=2)
        casillaQaProductos.grid(row=2, column=2, sticky="ew")

        stack = tk.Frame(casillaQaProductos)
        stack.pack()

        textoProductosQa = tk.Label(stack, text='Cantidad de productos',font=("Arial", 12, "bold"),border=1,relief="sunken")
        textoProductosQa.pack(side='top', anchor='center')

        entradaProductosQa = tk.Entry(stack)
        entradaProductosQa.pack(side='top', anchor='center')
        entradaProductosQa.configure(state=DISABLED)
        entradaProductosQa.bind("<KeyRelease>", eventoEntry)

        # /*--------------Transporte--------------*/
        # Stack para la parte de productos
        predeterminadoTransporte = tk.StringVar(value='Seleccionar transporte')
        casillaTransporte = tk.Frame(self, width=113, height=200,bg="#338dd6",relief="raised",  border=2)
        casillaTransporte.grid(row=3, column=0, sticky="ew")

        stack = tk.Frame(casillaTransporte)
        stack.pack()

        textoTransporte = tk.Label(stack, text='Lista de Transporte', font=("Arial", 12, "bold"),border=1,relief="sunken")
        textoTransporte.pack(side='top', anchor='center')
        desplegableTransporte = ttk.Combobox(stack, values=["a"], textvariable=predeterminadoTransporte,
                                             state='readonly')
        desplegableTransporte.pack(side='top', anchor='center')
        desplegableTransporte.configure(state=DISABLED)

        # Crear una casilla para contener el cuadro de texto
        casillaTextoTransporte = tk.Frame(self, width=113, height=200)
        casillaTextoTransporte.grid(row=2 + 1, column=1, columnspan=1)
        # Crear un cuadro de texto para mostrar información
        informacion = "Texto de ejemplo"
        texto_widgetTransporte = tk.Text(casillaTextoTransporte, width=32, height=8, bg="#c5c4ff")
        texto_widgetTransporte.pack()
        # Agregar contenido al widget de texto
        texto_widgetTransporte.insert(tk.END, informacion)
        texto_widgetTransporte.configure(state=DISABLED)
        desplegableTransporte.bind("<<ComboboxSelected>>",rellenarCuadroDeTextoTransporte)
        desplegableTransporte.bind("<Button-1>",deshabilitarTransporte)
        # /*--------------Botones--------------*/
        # Crear un botón
        botonEnviar = tk.Button(self, text="Enviar",width=10, height=2, bg="#1c71b8", font=("Franklin Gothic", 14, "bold"), fg="#ffffff",border=2,relief="raised",command=envio)
        botonEnviar.grid(row=4, column=1, sticky="ew")
        botonEnviar.config(state=DISABLED)
